package com.aisino2.sysadmin.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Loginlog  {

	/** @param 登录日志表(t_loginlog) */

	/** @ --登录日志ID--loginlogid--Integer--10-- */
	private Integer loginlogid;

	/** @ --登录用户ID--loginuserid--Integer--10-- */
	private Integer loginuserid;

	/** @ --登录用户名--useraccount--String--200-- */
	private String useraccount;

	/** @ --姓名--username--String--30-- */
	private String username;

	/** @ --登录单位代码--loginunitcode--String--200-- */
	private String loginunitcode;

	/** @ --登录单位名称--loginunitname--String--300-- */
	private String loginunitname;

	/** @ --登录IP--loginip--String--20-- */
	private String loginip;

	/** @ --登录MAC--loginmac--String--20-- */
	private String loginmac;

	/** @ --登录时间--logintiime--Date---- */
	private Date logintiime;

	/** @ --退出时间--quittime--Date---- */
	private Date quittime;

	/** 分页排序 */
	private String pageSort;
	
	/** @ --登录起始时间-- */
	private Date logintiimef;
	
	/** @ --登录截止时间-- */
	private Date logintiimet;

	/** @ 登录日志ID(loginlogid) */
	public Integer getLoginlogid() {
		return loginlogid;
	}

	public void setLoginlogid(Integer loginlogid) {
		this.loginlogid = loginlogid;
	}

	/** @ 登录用户ID(loginuserid) */
	public Integer getLoginuserid() {
		return loginuserid;
	}

	public void setLoginuserid(Integer loginuserid) {
		this.loginuserid = loginuserid;
	}

	/** @ 登录用户名(useraccount) */
	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	/** @ 姓名(username) */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/** @ 登录单位代码(loginunitcode) */
	public String getLoginunitcode() {
		return loginunitcode;
	}

	public void setLoginunitcode(String loginunitcode) {
		this.loginunitcode = loginunitcode;
	}

	/** @ 登录单位名称(loginunitname) */
	public String getLoginunitname() {
		return loginunitname;
	}

	public void setLoginunitname(String loginunitname) {
		this.loginunitname = loginunitname;
	}

	/** @ 登录IP(loginip) */
	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	/** @ 登录MAC(loginmac) */
	public String getLoginmac() {
		return loginmac;
	}

	public void setLoginmac(String loginmac) {
		this.loginmac = loginmac;
	}

	/** @ 登录时间(logintiime) */
	public Date getLogintiime() {
		return logintiime;
	}

	public void setLogintiime(Date logintiime) {
		this.logintiime = logintiime;
	}

	/** @ 退出时间(quittime) */
	public Date getQuittime() {
		return quittime;
	}

	public void setQuittime(Date quittime) {
		this.quittime = quittime;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getLogintiimef() {
		return logintiimef;
	}

	public void setLogintiimef(Date logintiimef) {
		this.logintiimef = logintiimef;
	}

	public Date getLogintiimet() {
		return logintiimet;
	}

	public void setLogintiimet(Date logintiimet) {
		this.logintiimet = logintiimet;
	}
}
