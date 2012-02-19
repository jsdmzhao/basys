package com.aisino2.techsupport.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.IExceptionService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.service.TrackingService;
import com.aisino2.techsupport.workflow.WorkflowUtil;

@Component("ExceptionServiceImpl")
public class ExceptionServiceImpl implements IExceptionService {
	private SupportTicketService st_service;
	private TrackingService tracking_service;
	private WorkflowUtil workflow;

	@Resource(name = "SupportTicketServiceImpl")
	public void setSt_service(SupportTicketService st_service) {
		this.st_service = st_service;
	}

	@Resource(name = "TrackingServiceImpl")
	public void setTracking_service(TrackingService tracking_service) {
		this.tracking_service = tracking_service;
	}
	@Resource(name="WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}

	public void insertExceptionAndGo(String taskid, SupportTicket st,
			Tracking tracking) {
		//保存支持单状态
		st.setStStatus(Constants.ST_STATUS_STOP);
		st_service.updateSupportTicket(st);
		//保存进展信息之终止原因
		tracking_service.insertTracking(tracking);
		//流程
		workflow.getTaskService().completeTask(taskid);
	}

}
