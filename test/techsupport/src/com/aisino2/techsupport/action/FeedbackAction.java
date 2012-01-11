package com.aisino2.techsupport.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.web.BaseAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.domain.Worksheet;
import com.aisino2.techsupport.service.FeedbackService;
import com.aisino2.techsupport.service.WorksheetService;

/**
 * 技术支持单 反馈确认环节
 * 反馈确认视图
 */
@SuppressWarnings("serial")
@Component("FeedbackAction")
@Scope("prototype")
public class FeedbackAction extends BaseAction {

	private FeedbackService feedbackService;
	private WorksheetService worksheetService;
//	回显用ST
	private SupportTicket st;
//	反馈用ST
	private SupportTicket feedbackSt;
//	任务号
	private String taskId;
//	进展信息
	private Tracking tracking;

	
//	返回状态信息
	private String returnMsg;
//	返回状态号
	private int returnNo;
	
	
	public String init() throws Exception{
//		工作单
		Worksheet worksheet = null;
		
		worksheet=worksheetService.getWorksheetTask(taskId);
		
		st=worksheet.getSt();
		
		return SUCCESS;
	}
	/**
	 * 保存
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		try {
			User currentUser = (User) this.getRequest().getAttribute(Constants.userKey);
			tracking.setProcessor(currentUser);
			tracking.setProcessorId(currentUser.getUserid());
			feedbackService.insertFeedbackAndGo(taskId, feedbackSt, tracking);
			returnNo = 0;
			returnMsg="反馈确认 保存成功";
		} catch (RuntimeException e) {
			returnNo=1;
			returnMsg="反馈确认 保存失败";
			throw e;
		}
		return SUCCESS;
	}
	
	/**
	 * 不与反馈
	 * @return
	 * @throws Exception
	 */
	public String noFeedback() throws Exception{
		try {
			User currentUser = (User) this.getRequest().getAttribute(Constants.userKey);
			tracking.setProcessor(currentUser);
			tracking.setProcessorId(currentUser.getUserid());
			feedbackService.insertFeedbackAndGoback(taskId, feedbackSt, tracking);
			returnNo = 0;
			returnMsg="反馈确认 不与反馈成功";
		} catch (RuntimeException e) {
			returnNo=1;
			returnMsg="反馈确认 不与反馈失败";
			throw e;
		}
		return SUCCESS;
	}
	
	@Resource(name="FeedbackServiceImpl")
	public void setFeedbackService(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
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
	public SupportTicket getSt() {
		return st;
	}
	public void setSt(SupportTicket st) {
		this.st = st;
	}
	public SupportTicket getFeedbackSt() {
		return feedbackSt;
	}
	public void setFeedbackSt(SupportTicket feedbackSt) {
		this.feedbackSt = feedbackSt;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	@Resource(name="WorksheetServiceImpl")
	public void setWorksheetService(WorksheetService worksheetService) {
		this.worksheetService = worksheetService;
	}
	public Tracking getTracking() {
		return tracking;
	}
	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}
	
}
