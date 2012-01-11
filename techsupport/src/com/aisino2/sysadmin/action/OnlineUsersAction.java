package com.aisino2.sysadmin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.aisino2.core.dao.Page;
import com.aisino2.core.web.PageAction;
import com.aisino2.sysadmin.domain.OnlineUser;
import com.opensymphony.xwork2.ActionContext;

public class OnlineUsersAction extends PageAction{	
	private String tabledata;
	private int totalrows;
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setDataTable(List lData) throws Exception{
		List lPro=new ArrayList();
		lPro.add("sessionID");
		lPro.add("userid");
		lPro.add("username");
		lPro.add("departmentname");
		lPro.add("loginip");
		lPro.add("logintime");		
		OnlineUser OnlineUser=new OnlineUser();
		this.setData(OnlineUser, lData, lPro, null);
		this.tabledata = this.getData();
        totalrows=this.getTotalrows();
	}
	
	public String querylist() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST); 
		HttpSession session = request.getSession();
		ServletContext application=session.getServletContext();
		List onlineUsersList=(ArrayList)application.getAttribute("ONLINEUSERSLIST");
		Page page=new Page(pagesize,pagerow);
		totalrows=onlineUsersList.size();
		page.setData(onlineUsersList);	
		
		setDataTable(onlineUsersList);
		result="success";
        return "success";
    }

	public String getTabledata() {
		return tabledata;
	}

	public void setTabledata(String tabledata) {
		this.tabledata = tabledata;
	}

	public int getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(int totalrows) {
		this.totalrows = totalrows;
	}
}
