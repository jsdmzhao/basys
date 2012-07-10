package com.aisino2.techsupport.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.task.Participation;
import org.jbpm.api.task.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IDepartmentService;
import com.aisino2.sysadmin.service.IUserService;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.dao.ISupportLeaderRelationDao;
import com.aisino2.techsupport.domain.SupportLeaderRelation;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.ISupportChangeService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.TrackingService;
import com.aisino2.techsupport.workflow.WorkflowUtil;

@Component("SupportChangeServiceImpl")
@Scope("prototype")
public class SupportChangeServiceImpl implements ISupportChangeService {
	private SupportTicketService support_ticket_service;
	private TrackingService tracking_service;
	private WorkflowUtil workflow;
	private IUserService user_service;
	private ISupportLeaderRelationDao supportLeaderRelationDao;
	private IDepartmentService department_service;
	
	@Resource(name="departmentService")
	public void setDepartment_service(IDepartmentService department_service) {
		this.department_service = department_service;
	}

	@Resource(name = "supportLeaderDaoImpl")
	public void setSupportLeaderRelationDao(
			ISupportLeaderRelationDao supportLeaderRelationDao) {
		this.supportLeaderRelationDao = supportLeaderRelationDao;
	}

	@Resource(name = "userService")
	public void setUser_service(IUserService user_service) {
		this.user_service = user_service;
	}

	@Resource(name = "SupportTicketServiceImpl")
	public void setSupport_ticket_service(
			SupportTicketService support_ticket_service) {
		this.support_ticket_service = support_ticket_service;
	}

	@Resource(name = "TrackingServiceImpl")
	public void setTracking_service(TrackingService tracking_service) {
		this.tracking_service = tracking_service;
	}

	@Resource(name = "WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}

	/**
	 * 重新指派机构
	 */
	public void change_support_department(String taskId, SupportTicket st,
			Tracking tracking) {
		if (st.getSupportDeptList() == null
				|| st.getSupportDeptList().isEmpty())
			throw new RuntimeException("需要变更的部门为空");
		//更新最后操作时间
		st.setLastUpdateDate(new Date());
		// 保存支持单信息指派部门信息
		support_ticket_service.updateSupportTicket(st);
		// 保存变更原因为进展
		tracking_service.insertTracking(tracking);
		SupportLeaderRelation slr = new SupportLeaderRelation();
		List<Integer> deleteNotDepartid = new ArrayList<Integer>();
		for (Department d : st.getSupportDeptList()) {
			if(d != null){
				d = department_service.getDepartment(d);
				deleteNotDepartid.add(d.getDepartid());
			}
			
		}
		slr.setStId(st.getId());
		slr.setDeleteNotDepartid(deleteNotDepartid);
		// 流程部分
		// 先通过TASKID查询当前实例的ID，通过实例ID查询部署ID。通过部署ID+环境名称，插叙到 关联的
		// 环节信息。

		String reassign_department_process_id = workflow
				.getExecutionService()
				.findExecutionById(
						workflow.getTaskService().getTask(taskId)
								.getExecutionId()).getProcessInstance().getId();
		Task reassign_support_leader_task = workflow.getTaskService()
				.createTaskQuery()
				.processInstanceId(reassign_department_process_id)
				.activityName(Constants.ST_PROCESS_REASSGIN_STLEADER)
				.uniqueResult();
		Task tracking_task = workflow.getTaskService().createTaskQuery()
				.processInstanceId(reassign_department_process_id)
				.activityName(Constants.ST_PROCESS_TRACKING).uniqueResult();
		// 之前的 追踪批复 候选人
		List<Participation> tracking_candidate_users = workflow
				.getTaskService().getTaskParticipations(tracking_task.getId());

		List<Participation> candidate_user_list = workflow.getTaskService()
				.getTaskParticipations(reassign_support_leader_task.getId());

		Map<String, Object> params = workflow.setDeptAssigneeVariable(st
				.getSupportDeptList());

		String[] new_assign_department_approval_users = params
				.get("deptApprovalUsers").toString().split(",");
		// 清除以前指派的部门
		for (Participation p : candidate_user_list) {
			workflow.getTaskService().removeTaskParticipatingUser(
					reassign_support_leader_task.getId(), p.getUserId(),
					Participation.CANDIDATE);
		}
		// 清楚以前的非新部门追踪批复候选人

		for (Participation p : tracking_candidate_users) {
			boolean safe = false;
			User slrr = new User();
			slrr.setUserid(Integer.parseInt(p.getUserId()));
			slrr = user_service.getUser(slrr);
			for (Integer departid : deleteNotDepartid) {
				if (departid.equals(slrr.getDepartid()))
					safe = true;
			}
			if (!safe)
				workflow.getTaskService().removeTaskParticipatingUser(
						tracking_task.getId(), slrr.getUserid().toString(),
						Participation.CANDIDATE);
		}
		// 执行删除
		supportLeaderRelationDao.delete(slr);
		try {
			// 重新指派
			for (String assign_user : new_assign_department_approval_users) {

				workflow.getTaskService().addTaskParticipatingUser(
						reassign_support_leader_task.getId(), assign_user,
						Participation.CANDIDATE);

			}

			params.put("reassign_depart_repeat", "to reassign_depart");
			// 到下一个流程
			workflow.getTaskService().completeTask(taskId, params);
		} catch (Exception e) {
			// 恢复以前的指派的部门审批人
			List<Participation> new_reassign_support_leader_users = workflow
					.getTaskService().getTaskParticipations(
							reassign_support_leader_task.getId());
			for (Participation p : new_reassign_support_leader_users) {
				workflow.getTaskService().removeTaskParticipatingUser(
						reassign_support_leader_task.getId(), p.getUserId(),
						Participation.CANDIDATE);
			}

			for (Participation p : candidate_user_list) {
				workflow.getTaskService().addTaskParticipatingUser(
						reassign_support_leader_task.getId(), p.getUserId(),
						Participation.CANDIDATE);
			}
			List<Participation> new_tracking_candidate_users = workflow
					.getTaskService().getTaskParticipations(
							tracking_task.getId());
			// 当添加出错的时候，滚回以前的状态
			for (Participation p : tracking_candidate_users) {
				if (!new_tracking_candidate_users.contains(p)) {
					workflow.getTaskService().addTaskParticipatingUser(
							tracking_task.getId(), p.getUserId(),
							Participation.CANDIDATE);
				}
			}
			throw new RuntimeException("流程控制指派部门审批人候选人发生错误",
					e.fillInStackTrace());
		}
	}

	/**
	 * 重新指派负责人
	 */
	public void change_support_leader(String taskId, SupportTicket st,
			Tracking tracking) {
		if (st.getLstSupportLeaders() == null
				|| st.getLstSupportLeaders().isEmpty())
			throw new RuntimeException("需要变更的支持单负责人为空");
		//更新最后操作时间
		st.setLastUpdateDate(new Date());
		//添加部门审批信息
		st.getTrackList().add(tracking);
		// 保存支持单信息指派部门信息
		support_ticket_service.updateSupportTicket(st);
		// 保存变更原因为进展
		tracking_service.insertTracking(tracking);

		// 流程部分
		String reassign_support_leader_process_id = workflow
				.getExecutionService()
				.findExecutionById(
						workflow.getTaskService().getTask(taskId)
								.getExecutionId()).getProcessInstance().getId();
		Task tracking_task = workflow.getTaskService().createTaskQuery()
				.processInstanceId(reassign_support_leader_process_id)
				.activityName(Constants.ST_PROCESS_TRACKING).uniqueResult();
		// 之前的 追踪批复 候选人
		List<Participation> tracking_candidate_users = workflow
				.getTaskService().getTaskParticipations(tracking_task.getId());
		System.out.println("================taskID="+tracking_task.getId());
		
		SupportTicket comm_st = support_ticket_service.getSupportTicket(st);

		if (tracking_candidate_users.isEmpty()) {
			try {

				workflow.getTaskService()
						.addTaskParticipatingUser(
								tracking_task.getId(),
								st.getLstSupportLeaders().get(0).getUserid()
										.toString(), Participation.CANDIDATE);

				Map<String, String> params = new HashMap<String, String>();
				params.put("reassign_stleader_repeat", "to_reassgin_stleader");
				// 完成本流程跳转到下一个流程
				workflow.getTaskService().completeTask(taskId, params);
				return;
			} catch (Exception e) {
				List<Participation> new_tracking_candidate_users = workflow
						.getTaskService().getTaskParticipations(
								tracking_task.getId());
				// 当添加出错的时候，滚回以前的状态
				for (Participation new_p : new_tracking_candidate_users) {
					if (Integer.parseInt(new_p.getUserId()) == st
							.getLstSupportLeaders().get(0).getUserid()) {
						workflow.getTaskService().addTaskParticipatingUser(
								tracking_task.getId(),
								st.getLstSupportLeaders().get(0).getUserid()
										.toString(), Participation.CANDIDATE);
					}
				}

				throw new RuntimeException("流程控制 追踪批复 候选人发生错误",
						e.fillInStackTrace());
			}
		}
		
		System.out.println("====================2222222222222222");
		User sl = user_service.getUser(st.getLstSupportLeaders().get(0));
		//修正子部门和父级部门可以分别指派的问题 
		//获取当前部门审批人的部门信息
		User curr_appr_user = new User();
		curr_appr_user.setUserid(tracking.getProcessor().getUserid());
		curr_appr_user = user_service.getUser(curr_appr_user);
		
		for (Participation p : tracking_candidate_users) {
			User old_tracking_user = new User();
			old_tracking_user.setUserid(Integer.parseInt(p.getUserId()));
			old_tracking_user = user_service.getUser(old_tracking_user);
			
			
			// 因为一个部门只允许指派一个
			//修正子部门和父级部门可以分别指派的问题
			Department old_department = new Department();
			old_department.setDepartid(old_tracking_user.getDepartid());
			old_department = department_service.getDepartment(old_department);
			System.out.println("==========33333333333333333");
			while(old_department != null && !old_department.getDepartid().equals(
					curr_appr_user.getDepartid())){
				old_department = department_service.getParentDepart(old_department);
			}
			if (old_department != null && old_department.getDepartid()
					.equals(curr_appr_user.getDepartid())){
				
				Department sl_department = new Department();
				sl_department.setDepartid(sl.getDepartid());
				sl_department = department_service.getDepartment(sl_department);
				while(!sl_department.getDepartid().equals(
						curr_appr_user.getDepartid())){
					sl_department = department_service.getParentDepart(sl_department);
				}
				
				if(sl_department != null && sl_department.getDepartid()
					.equals(curr_appr_user.getDepartid())){
					workflow.getTaskService().removeTaskParticipatingUser(
							tracking_task.getId(), p.getUserId(),
							Participation.CANDIDATE);
				}
			}

		}
		System.out.println("=============4444444444444444444");
		workflow.getTaskService().addTaskParticipatingUser(
				tracking_task.getId(), sl.getUserid().toString(),
				Participation.CANDIDATE);

		try {
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("reassign_stleader_repeat",
					"to_reassgin_stleader");
			// 完成本流程跳转到下一个流程
			workflow.getTaskService().completeTask(taskId, params);
			
		} catch (Exception e) {
			List<Participation> new_tracking_candidate_users = workflow
					.getTaskService().getTaskParticipations(
							tracking_task.getId());
			for(Participation p : new_tracking_candidate_users)
				workflow.getTaskService().removeTaskParticipatingUser(
						tracking_task.getId(), p.getUserId(),
						Participation.CANDIDATE);
			for(Participation p : tracking_candidate_users){
				// 当添加出错的时候，滚回以前的状态
					workflow.getTaskService().addTaskParticipatingUser(
							tracking_task.getId(), p.getUserId(),
							Participation.CANDIDATE);
			}
			
			throw new RuntimeException("流程控制 追踪批复 候选人发生错误",
					e.fillInStackTrace());
		}

	}
}
