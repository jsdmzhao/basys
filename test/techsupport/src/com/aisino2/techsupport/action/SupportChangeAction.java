package com.aisino2.techsupport.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.web.PageAction;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
import com.aisino2.techsupport.service.ISupportChangeService;

@Component("SupportChangeAction")
@Scope("prototype")
public class SupportChangeAction extends PageAction {
	private ISupportChangeService support_change_service;
	private String returnMsg;
	private int returnNo;
	private String taskId;
	private Tracking track;
	private SupportTicket change_st;
	
	public Tracking getTrack() {
		return track;
	}

	public void setTrack(Tracking track) {
		this.track = track;
	}

	public SupportTicket getChange_st() {
		return change_st;
	}

	public void setChange_st(SupportTicket change_st) {
		this.change_st = change_st;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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

	@Resource(name="SupportChangeServiceImpl")
	public void setSupport_change_service(
			ISupportChangeService support_change_service) {
		this.support_change_service = support_change_service;
	}

	/**
	 * 支持部门变更
	 * @return
	 * @throws Exception
	 */
	public String change_department() throws Exception{
		if(change_st == null)
			throw new RuntimeException("更变部门参数为空");
		if(taskId == null)
			throw new RuntimeException("任务编号为空");
		try{
			support_change_service.change_support_department(taskId, change_st,track);
			returnNo=0;
		}catch (Exception e) {
			returnNo=1;
			returnMsg = e.getMessage();
			log.error(e);
			log.debug(e,e.fillInStackTrace());
		}
		return SUCCESS;
	}
	
	/**
	 * 支持单负责人变更 
	 * @return
	 * @throws Exception
	 */
	public String change_support_leader() throws Exception{
		if(change_st == null)
			throw new RuntimeException("更变支持单负责人参数为空");
		if(taskId == null)
			throw new RuntimeException("任务编号为空");
		try{
			support_change_service.change_support_leader(taskId, change_st,track);
			returnNo=0;
		}catch (Exception e) {
			returnNo=1;
			returnMsg = e.getMessage();
			log.error(e);
			log.debug(e,e.fillInStackTrace());
		}
		return SUCCESS;
	}
}
