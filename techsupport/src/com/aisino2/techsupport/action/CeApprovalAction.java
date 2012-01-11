package com.aisino2.techsupport.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.web.BaseAction;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.ICeApprovalService;
import com.aisino2.techsupport.service.WorksheetService;

/**
 *
 * 技术支持单 总工审核环节。
 */
@Component("CeApprovalAction")
@Scope("prototype")
public class CeApprovalAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3356192997278386119L;
	private ICeApprovalService ceApprovalService;
	private WorksheetService worksheetService;
	/**
	 * 支持单任务号
	 */
	private String taskId;
	
	/**
	 * 回显用支持的实体 
	 */
	private SupportTicket st;
	
	/**
	 * 环节保存用的 
	 */
	private SupportTicket ceApprovalSt;
	
//	返回状态信息
	/**
	 * 返回状态信息
	 */
	private String returnMsg;
//	返回状态号
	/**
	 * 返回状态号
	 */
	private int returnNo;
	
	/**
	 * 
	 * 初始化 技术支持单 总工审核环节信息
	 * @return 
	 * @throws Exception
	 */
	public String init() throws Exception{
		st=worksheetService.getWorksheetTask(taskId).getSt();
		return SUCCESS;
	}
	
	/**
	 * 保存总工审核信息
	 * @throws Exception
	 */
	public String  save()	throws Exception{
		try {
			ceApprovalService.insertCeApproval(taskId, ceApprovalSt,ceApprovalSt.getTrackList().get(0));
			returnNo = 0;
			returnMsg="总工审核 保存成功";
		} catch (RuntimeException e) {
			returnNo=1;
			returnMsg="总工审核 保存失败";
			throw e;
		}
		return SUCCESS;
	}

	@Resource(name="CeApprovalServiceImpl")
	public void setCeApprovalService(ICeApprovalService ceApprovalService) {
		this.ceApprovalService = ceApprovalService;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public SupportTicket getSt() {
		return st;
	}

	public void setSt(SupportTicket st) {
		this.st = st;
	}

	public SupportTicket getCeApprovalSt() {
		return ceApprovalSt;
	}

	public void setCeApprovalSt(SupportTicket ceApprovalSt) {
		this.ceApprovalSt = ceApprovalSt;
	}

	@Resource(name="WorksheetServiceImpl")
	public void setWorksheetService(WorksheetService worksheetService) {
		this.worksheetService = worksheetService;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public int getReturnNo() {
		return returnNo;
	}

	public void setReturnNo(int returnNo) {
		this.returnNo = returnNo;
	}
}
