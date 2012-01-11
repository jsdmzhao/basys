package com.aisino2.techsupport.workflow.assignee;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.service.SupportTicketService;

@Component("ApplyAssignmentHandler")
public class ApplyAssignmentHandler extends CommonAssignmentHandler {
	private SupportTicketService stService;
	
	@Override
	public void assign(Assignable assignable, OpenExecution execution)
			throws Exception {
		// TODO Auto-generated method stub
		super.assign(assignable, execution);
		
		//录入填报指派
		Map<String, Object> params = (HashMap<String, Object>)execution.getVariable("params");
		HttpServletRequest request = (HttpServletRequest)params.get("request");
		ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		stService = (SupportTicketService) context.getBean("SupportTicketService");
		Integer stId =  (Integer) execution.getVariable("worksheetno");
		SupportTicket st = new SupportTicket();
		st.setId(stId);
		st = stService.getSupportTicket(st);
//		assignable.addCandidateUser(st.getSupportLeader().getUserid().toString());
	}

	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}
}
