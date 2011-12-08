package com.aisino2.sysadmin.domain;

public class OnlineUser {
    private String sessionID;
    private String userid;
    private String username;
    private String departmentname;
    private String loginip;
    private String logintime;
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
    
}
