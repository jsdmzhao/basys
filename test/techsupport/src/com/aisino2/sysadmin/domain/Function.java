package com.aisino2.sysadmin.domain;

import java.io.Serializable;

import com.aisino2.core.domain.BaseObject;

public class Function  implements Serializable{

	/** @param 功能(t_function) */

	/** @ --功能代码--funccode--String--50-- */
	private String funccode;

	/** @ --系统代码--systemcode--String--20-- */
	private String systemcode;

	/** @ --功能名称--funcname--String--100-- */
	private String funcname;

	/** @ --功能定义--funcdefine--String--200-- */
	private String funcdefine;

	/** @ --功能类别--functype--Integer--1-- */
	private Integer functype;

	/** 分页排序 */
	private String pageSort;
	/** @ --系统名称--*/
	private String systemname;
	
	private Integer roleid;
	
	private  System system;
	/**
	 * 功能类别名称
	 */
	private String functypename;

	/**
	 * 用户userid
	 */
	private  Integer userid;

	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/** @ 功能代码(funccode) */
	public String getFunccode() {
		return funccode;
	}

	public void setFunccode(String funccode) {
		this.funccode = funccode;
	}

	/** @ 系统代码(systemcode) */
	public String getSystemcode() {
		return systemcode;
	}

	public void setSystemcode(String systemcode) {
		this.systemcode = systemcode;
	}

	/** @ 功能名称(funcname) */
	public String getFuncname() {
		return funcname;
	}

	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}

	/** @ 功能定义(funcdefine) */
	public String getFuncdefine() {
		return funcdefine;
	}

	public void setFuncdefine(String funcdefine) {
		this.funcdefine = funcdefine;
	}

	/** @ 功能类别(functype) */
	public Integer getFunctype() {
		return functype;
	}

	public void setFunctype(Integer functype) {
		this.functype = functype;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getSystemname() {
		return systemname;
	}

	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public String getFunctypename() {
		return functypename;
	}

	public void setFunctypename(String functypename) {
		this.functypename = functypename;
	}
}
