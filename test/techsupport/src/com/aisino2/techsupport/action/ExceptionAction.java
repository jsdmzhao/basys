package com.aisino2.techsupport.action;

import com.aisino2.core.web.PageAction;
import com.aisino2.techsupport.service.IExceptionService;


public class ExceptionAction extends PageAction{
	private IExceptionService exception_service;
	private String taskId;
	private 
	public String save() throws Exception{
		
		return SUCCESS;
	}
}
