package com.aisino2.techsupport.workflow.decision;

import javax.annotation.Resource;

import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.stereotype.Component;

import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.workflow.WorkflowUtil;

@Component
public class CeApprovalDecisionHandler implements DecisionHandler {
	private WorkflowUtil util;
	private SupportTicketService stService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7397585664840895226L;

	public String decide(OpenExecution execution) {
		Integer worksheet= (Integer) execution.getVariable("worksheetno");
		
		return null;
	}

	@Resource(name="WorkflowUtil")
	public void setUtil(WorkflowUtil util) {
		this.util = util;
	}

	@Resource(name="SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

}
