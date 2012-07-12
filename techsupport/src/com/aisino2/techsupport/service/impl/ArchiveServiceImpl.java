package com.aisino2.techsupport.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.core.service.BaseService;
import com.aisino2.techsupport.common.Constants;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.service.ArchiveSerivce;
import com.aisino2.techsupport.service.IAttachmentService;
import com.aisino2.techsupport.service.SupportTicketService;
import com.aisino2.techsupport.workflow.WorkflowUtil;

/**
 * 技术支持单归档结单环节
 *
 */
@Component("ArchiveServiceImpl")
public class ArchiveServiceImpl extends BaseService implements ArchiveSerivce {
	/**
	 * 支持单服务
	 */
	private SupportTicketService stService;
	private IAttachmentService attachmeng_service;
	
	/**
	 *  流程服务
	 */
	private WorkflowUtil workflow;
	
	public void inserArchive(String taskId, SupportTicket st) {
//		保存支持单信息
		st.setStStatus(Constants.ST_STATUS_COMPLETE);
		//更新最后操作时间
		st.setLastUpdateDate(new Date());
		
		stService.updateSupportTicket(st);
		
//		流程控制
//		流程前进
//		完成最后的结单流程
		workflow.workflowNext(workflow.setVariable(taskId, null));
	}

	@Resource(name="SupportTicketServiceImpl")
	public void setStService(SupportTicketService stService) {
		this.stService = stService;
	}

	@Resource(name="WorkflowUtil")
	public void setWorkflow(WorkflowUtil workflow) {
		this.workflow = workflow;
	}

	@Resource(name="")
	public void setAttachmeng_service(IAttachmentService attachmeng_service) {
		this.attachmeng_service = attachmeng_service;
	}

	
}
