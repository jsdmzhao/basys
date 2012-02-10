package com.aisino2.techsupport.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.ISupportChangeService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.workflow.WorkflowUtil;

@Component("SupportChangeServiceImpl")
@Scope("prototype")
public class SupportChangeServiceImpl implements ISupportChangeService {
	private SupportTicketService support_ticket_service;
	private WorkflowUtil workflow;
	
	@Resource(name="WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}

	public void change_support_department(String taskId,SupportTicket st,Tracking tracking) {
		if(st.getSupportDeptList() == null || st.getSupervision_list().isEmpty())
			throw new RuntimeException("需要变更的部门为空");
		support_ticket_service.updateSupportTicket(st);
		
		//流程部分
//		workflow.getTaskService().createTaskQuery().activityName(arg0)
	}

	public void change_support_leader(String taskId,SupportTicket st,Tracking tracking) {
		if(st.getLstSupportLeaders()== null || st.getLstSupportLeaders().isEmpty())
			throw new RuntimeException("需要变更的支持单负责人为空");
		support_ticket_service.updateSupportTicket(st);
	}

}
