package com.aisino2.techsupport.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.web.PageAction;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.IExceptionService;

@Component("ExceptionAction")
@Scope("prototype")
public class ExceptionAction extends PageAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7987244127956712223L;
	private IExceptionService exception_service;
	private String taskId;
	private SupportTicket exception_st;
	private Tracking tracking;
	
	private int returnNo;
	private String returnMsg;
	
	@Resource(name="ExceptionServiceImpl")
	public void setException_service(IExceptionService exception_service) {
		this.exception_service = exception_service;
	}


	public String getTaskId() {
		return taskId;
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	public SupportTicket getException_st() {
		return exception_st;
	}


	public void setException_st(SupportTicket exception_st) {
		this.exception_st = exception_st;
	}


	public Tracking getTracking() {
		return tracking;
	}


	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}


	public int getReturnNo() {
		return returnNo;
	}


	public void setReturnNo(int returnNo) {
		this.returnNo = returnNo;
	}


	public String getReturnMsg() {
		return returnMsg;
	}


	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	/**
	 * 例行终止
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		try{
			exception_service.insertExceptionAndGo(taskId, exception_st, tracking);
			returnNo = 0;
		}catch (Exception e) {
			returnMsg="终止失败:["+e.getMessage()+"]";
			returnNo = 1;
			log.error(e);
			log.debug(e,e.fillInStackTrace());
			throw new RuntimeException(returnMsg);
		}
		return SUCCESS;
	}
}
