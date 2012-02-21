package com.aisino2.techsupport.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.task.Participation;
import org.springframework.stereotype.Component;

import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IUserService;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.IDeptApprovalService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.TrackingService;
import com.aisino2.techsupport.workflow.WorkflowUtil;

/**
 * 部门审核环节服务，主要包括产品方案部和技术开发部
 *
 */
@Component("DeptApprovalServiceImpl")
public class DeptApprovalServiceImpl extends BaseService implements
		IDeptApprovalService {
	private SupportTicketService stService;
	private TrackingService trackingService;
	
	/**
	 * 流程控制服务
	 */
	private WorkflowUtil workflow;
	
	private IUserService user_service;
	
	@Resource(name="userService")
	public void setUser_service(IUserService user_service) {
		this.user_service = user_service;
	}

	public void insertDeptApproval(String taskId, SupportTicket st,Tracking tracking) {
		
		if(Constants.ST_APPR_TYPE_APPR_NOPASS.equals(tracking.getApprovalCode()) ){
			st.setStStatus(Constants.ST_STATUS_DEPARTMENT_APPRAVAL_NOPASS);
		}
//		保存技术支持单信息
		stService.updateSupportTicket(st);
//		保存部门审核意见信息
		trackingService.insertTracking(tracking);
		
		if(tracking.getProcessor().getDepartid()==null)
			throw new RuntimeException("当前用户单位信息为空");
//		流程控制
//		当当前单位审批后，不允许再次看到本环节信息，故此，在这里对 指派候选人里面的当前用户单位ID做移除。
//		当全部指派单位审批后，提交流程到下一个环节
		
		//指派的部门候选列表
		List<Participation> candidate_department_list = workflow.getTaskService().getTaskParticipations(taskId);
		
//		移除已经批复过的技术部门
		for(Participation participation : candidate_department_list){
			User user = new User();
			user.setUserid(Integer.parseInt(participation.getUserId()));
			tracking.setProcessor(user_service.getUser(tracking.getProcessor()));
			if (tracking.getProcessor().getDepartid().equals(user_service.getUser(user).getDepartid())){
				//移除候选列表
				workflow.getTaskService().removeTaskParticipatingUser(taskId, participation.getUserId(), Participation.CANDIDATE);
			}
		}
		
		//指派人参数
		Map<String, Object> candidateUsers=new HashMap<String, Object>();
		
		try{
			//指派追踪批复用户
//			设置总的审批结果，及只要有一个部门审批未通过，那么就未通过，上报给总工，再定夺。
			Map<String, Object> paramsMap=new HashMap<String, Object>();
			paramsMap.put("deptApprovalCode", tracking.getApprovalCode());
			//当任意一个审批不通过，则退回到上一步，总工审批（公司一级审批）
			if(Constants.ST_APPR_TYPE_APPR_NOPASS.equals(tracking.getApprovalCode()) ){
				workflow.workflowNext(workflow.setVariable(taskId, null, candidateUsers, paramsMap));
				return;
			}
			
//			@fixed 技术负责人变成多个指派
			String supportLeaderIds = "";
			SupportTicket comm_st = stService.getSupportTicket(st);
			for (User sl : comm_st.getLstSupportLeaders())
				supportLeaderIds += "," + sl.getUserid();
			supportLeaderIds = supportLeaderIds.length() > 0 ? supportLeaderIds
					.substring(1) : supportLeaderIds;
			candidateUsers.put("trackingUsers", supportLeaderIds);
			
//			流程提交以后不能查看，另外确保所有 经理 都审核了 
			candidate_department_list = workflow.getTaskService().getTaskParticipations(taskId);
				
			//在一致同意的情况下（同一个部门只能有一个审批人对支持单进行审批）,进入下一个环节，否则等待其他部门审批完成
			if(candidate_department_list.isEmpty()){
				//设置状态为进行中
				st = new SupportTicket();
				st.setId(comm_st.getId());
				st.setStStatus(Constants.ST_STATUS_GOING);
				st.setLstSupportLeaders(null);
//				保存技术支持单信息
				stService.updateSupportTicket(st);
				paramsMap.putAll(candidateUsers);
				workflow.getTaskService().completeTask(taskId, paramsMap);
			}
			else{
				workflow.getTaskService().setVariables(taskId, workflow.setVariable(taskId, null, candidateUsers, paramsMap));
			}
		}catch (Exception e) {
			//得到初始部门指派时候的部门审批人
			String oldDeptApprovalUsersStr= (String) workflow.getTaskService().getVariable(taskId, "deptApprovalUsers");
			String[] dept_appr_users = oldDeptApprovalUsersStr.split(",");
			for(int i=0;i<dept_appr_users.length;i++)
				workflow.getTaskService().addTaskParticipatingUser(taskId, dept_appr_users[i], Participation.CANDIDATE);
			log.error(e);
			log.debug(e,e.fillInStackTrace());
			throw new RuntimeException("流程提交出现错误");
		}
	}

	@Resource(name="SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	@Resource(name="TrackingServiceImpl")
	public void setTrackingService(TrackingService trackingService) {
		this.trackingService = trackingService;
	}

	@Resource(name="WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}

	
}
