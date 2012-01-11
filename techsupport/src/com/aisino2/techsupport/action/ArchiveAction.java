package com.aisino2.techsupport.action;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.RequestAware;
import org.drools.lang.dsl.DSLMapParser.mapping_file_return;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.core.web.BaseAction;
import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Worksheet;
import com.aisino2.techsupport.service.ArchiveSerivce;
import com.aisino2.techsupport.service.WorksheetService;

/**
 * 技术支持单 归档结单环节
 * 技术支持单流程 最后一步 归档。
 * 归档后的支持单无法回滚到以前的环节。
 */
@SuppressWarnings("serial")
@Component("ArchiveAction")
@Scope("prototype")
public class ArchiveAction extends BaseAction{
	
	private WorksheetService worksheetService;
	private ArchiveSerivce archiveSerivce;
	
//	回显用ST
	private SupportTicket st;
//	反馈用ST
	private SupportTicket archiveSt;
//	任务号
	private String taskId;
	
	
//	返回状态信息
	private String returnMsg;
//	返回状态号
	private int returnNo;
	
	/**
	 * 页面初始化
	 * @return
	 * @throws Exception
	 */
	public String init() throws Exception{
		Worksheet worksheet=worksheetService.getWorksheetTask(taskId);
		st=worksheet.getSt();
		return SUCCESS;
	}
	
	/**
	 * 归档结单
	 * @return
	 * @throws Exception
	 */
	public String archive() throws Exception {
		try {
			HttpSession session=this.getRequest().getSession();
			archiveSt.setArchiveUser((User) session.getAttribute(Constants.userKey));
			archiveSt.setArchiveDate(new Date());
			archiveSerivce.inserArchive(taskId , archiveSt);
			returnNo=0;
			returnMsg="归档 成功";
		} catch (RuntimeException e) {
			returnNo=1;
			returnMsg="归档 失败:"+e.getMessage()+",请联系管理员";
			throw e;
		}
		return SUCCESS;
	}

	public SupportTicket getSt() {
		return st;
	}

	public void setSt(SupportTicket st) {
		this.st = st;
	}

	public SupportTicket getArchiveSt() {
		return archiveSt;
	}

	public void setArchiveSt(SupportTicket archiveSt) {
		this.archiveSt = archiveSt;
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

	@Resource(name="WorksheetServiceImpl")
	public void setWorksheetService(WorksheetService worksheetService) {
		this.worksheetService = worksheetService;
	}

	@Resource(name="ArchiveServiceImpl")
	public void setArchiveSerivce(ArchiveSerivce archiveSerivce) {
		this.archiveSerivce = archiveSerivce;
	}

}
