package com.aisino2.sysadmin.action.json;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.action.PageAction;

@Component
@Scope("prototype")
public class SystemManageAction extends PageAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6479289252324243277L;
	
	public String query() throws Exception{
		return SUCCESS;
	}
	
	public String querylist() throws Exception{
		return SUCCESS;
	}
	
	public String add() throws Exception{
		return SUCCESS;
	}
	
	public String remove() throws Exception{
		return SUCCESS;
	}
	
	public String modify() throws Exception{
		return SUCCESS;
	}
	
}
