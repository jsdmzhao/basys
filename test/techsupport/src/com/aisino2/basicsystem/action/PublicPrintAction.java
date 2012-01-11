package com.aisino2.basicsystem.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.core.web.PageAction;
import com.opensymphony.xwork2.ActionContext;

public class PublicPrintAction extends PageAction {
	
	private String con;
	
	private String titlecon;
	
	private String result="";
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public String printCon() throws Exception{
		
		//System.out.println(con);
		String title = "<table width='100%' border='0' cellpadding='0' cellspacing='0' align='center'><tr><td width='100%' align='center' class='title1'>"+titlecon+"</td></tr></table>";
		
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		con = title+con; 
		session.setAttribute("printCon", con);
		
		this.result="success";
		return "success";
		
	}

	public String getTitlecon() {
		return titlecon;
	}

	public void setTitlecon(String titlecon) {
		this.titlecon = titlecon;
	}

}
