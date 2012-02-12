package com.aisino2.techsupport.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.task.Participation;
import org.jbpm.api.task.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.techsupport.common.Constants;
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
	
	
	@Resource(name="SupportTicketServiceImpl")
	public void setSupport_ticket_service(
			SupportTicketService support_ticket_service) {
		this.support_ticket_service = support_ticket_service;
	}

	@Resource(name="TrackingServiceImpl")
	public void setTracking_service(TrackingService tracking_service) {
		this.tracking_service = tracking_service;
	}

	@Resource(name="WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}
	/**
	 * 重新指派机构
	 */
	public void change_support_department(String taskId,SupportTicket st,Tracking tracking) {
		if(st.getSupportDeptList() == null || st.getSupervision_list().isEmpty())
			throw new RuntimeException("需要变更的部门为空");
		//保存支持单信息指派部门信息
		support_ticket_service.updateSupportTicket(st);
		//保存变更原因为进展
		tracking_service.insertTracking(tracking);
		
		//流程部分
		//先通过TASKID查询当前实例的ID，通过实例ID查询部署ID。通过部署ID+环境名称，插叙到 关联的
		//环节信息。
		String reassign_department_execid = workflow.getTaskService().getTask(taskId).getExecutionId();
		Task reassign_support_leader_task = workflow.getTaskService().createTaskQuery().executionId(reassign_department_execid)
				.activityName(Constants.ST_PROCESS_REASSGIN_STLEADER).uniqueResult();
		Map<String,Object> params = workflow.setDeptAssigneeVariable(st.getSupportDeptList());
		
		String[] new_assign_department_approval_users = params.get("deptApprovalUsers").toString().split(",");
		for(String assign_user : new_assign_department_approval_users){
			workflow.getTaskService().addTaskParticipatingUser(reassign_support_leader_task.getId(), assign_user, Participation.CANDIDATE);
		}
		workflow.getTaskService().setVariables(taskId, params);
		
		//到下一个流程
		workflow.getTaskService().completeTask(taskId,params);
	}

	/**
	 * 重新指派负责人
	 */
	public void change_support_leader(String taskId,SupportTicket st,Tracking tracking) {
		if(st.getLstSupportLeaders()== null || st.getLstSupportLeaders().isEmpty())
			throw new RuntimeException("需要变更的支持单负责人为空");
		//保存支持单信息指派部门信息
		support_ticket_service.updateSupportTicket(st);
		//保存变更原因为进展
		tracking_service.insertTracking(tracking);
		
		//流程部分
	}

}
