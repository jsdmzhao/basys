package com.aisino2.sysadmin.domain;

import java.util.Date;

public class Operatelog  {

	/** @param 操作日志表(t_operatelog) */

	/** @ --操作日志ID--operatelogid--Integer--10-- */
	private Integer operatelogid;

	/** @ --操作单位代码--operateunitcode--String--200-- */
	private String operateunitcode;

	/** @ --操作单位名称--operateunitname--String--300-- */
	private String operateunitname;

	/** @ --操作用户ID--operateuserid--Integer--10-- */
	private Integer operateuserid;

	/** @ --登录用户名--useraccount--String--200-- */
	private String useraccount;

	/** @ --姓名--username--String--30-- */
	private String username;

	/** @ --操作子系统--operatesystem--String--30-- */
	private String operatesystem;

	/** @ --操作模块--operatemodule--String--30-- */
	private String operatemodule;

	/** @ --操作sql语句--operatesql--String--4000-- */
	//private String operatesql;
	private String operatesql;

	/** @ --操作类型--operatetype--String--20-- */
	private String operatetype;

	/** @ --操作时间--operatedate--Date---- */
	private Date operatedate;

	/** 分页排序 */
	private String pageSort;

	/** @ --操作时间查询 */
	private Date operatedatef;
	
	/** @ --操作时间查询至 */
	private Date operatedatet;

	public Date getOperatedatef() {
		return operatedatef;
	}

	public void setOperatedatef(Date operatedatef) {
		this.operatedatef = operatedatef;
	}

	public Date getOperatedatet() {
		return operatedatet;
	}

	public void setOperatedatet(Date operatedatet) {
		this.operatedatet = operatedatet;
	}

	/** @ 操作日志ID(operatelogid) */
	public Integer getOperatelogid() {
		return operatelogid;
	}

	public void setOperatelogid(Integer operatelogid) {
		this.operatelogid = operatelogid;
	}

	/** @ 操作单位代码(operateunitcode) */
	public String getOperateunitcode() {
		return operateunitcode;
	}

	public void setOperateunitcode(String operateunitcode) {
		this.operateunitcode = operateunitcode;
	}

	/** @ 操作单位名称(operateunitname) */
	public String getOperateunitname() {
		return operateunitname;
	}

	public void setOperateunitname(String operateunitname) {
		this.operateunitname = operateunitname;
	}

	/** @ 操作用户ID(operateuserid) */
	public Integer getOperateuserid() {
		return operateuserid;
	}

	public void setOperateuserid(Integer operateuserid) {
		this.operateuserid = operateuserid;
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

	/** @ 操作子系统(operatesystem) */
	public String getOperatesystem() {
		return operatesystem;
	}

	public void setOperatesystem(String operatesystem) {
		this.operatesystem = operatesystem;
	}

	/** @ 操作模块(operatemodule) */
	public String getOperatemodule() {
		return operatemodule;
	}

	public void setOperatemodule(String operatemodule) {
		this.operatemodule = operatemodule;
	}

	/** @ 操作sql语句(operatesql) */
//	public String getOperatesql() {
//		return operatesql;
//	}
//
//	public void setOperatesql(String operatesql) {
//		this.operatesql = operatesql;
//	}

	/** @ 操作类型(operatetype) */
	public String getOperatetype() {
		return operatetype;
	}

	public void setOperatetype(String operatetype) {
		this.operatetype = operatetype;
	}

	/** @ 操作时间(operatedate) */
	public Date getOperatedate() {
		return operatedate;
	}

	public void setOperatedate(Date operatedate) {
		this.operatedate = operatedate;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getOperatesql() {
		return operatesql;
	}

	public void setOperatesql(String operatesql) {
		this.operatesql = operatesql;
	}

	
}
