package com.aisino2.sysadmin.domain;

import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Role_func  {

	/** @param 角色功能(t_role_func) */

	/** @ --角色ID--roleid--Integer--9-- */
	private Integer roleid;

	/** @ --功能代码--funccode--String--50-- */
	private String funccode;

	/** @ --参数--param--String--200-- */
	private String param;

	/** 分页排序 */
	private String pageSort;
	
	/** @ --系统代码--
	 * */
	private String systemcode;
	

	/**
	 * 用户userid
	 */
	private Integer userid;
	
	/** @ --功能定义--funcdefine--String--200-- */
	private String funcdefine;
	
	private String funcname;
	
	private String functype;

	private List lFuncList;

	private Function function;
	

	public String getFuncname() {
		return funcname;
	}

	public void setFuncname(String funcname) {
		this.funcname = funcname;
	}

	public String getFunctype() {
		return functype;
	}

	public void setFunctype(String functype) {
		this.functype = functype;
	}

	  public List getLFuncList() {
		return lFuncList;
	}

	public void setLFuncList(List funcList) {
		lFuncList = funcList;
	}
	
	/** @ 角色ID(roleid) */
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/** @ 功能代码(funccode) */
	public String getFunccode() {
		return funccode;
	}

	public void setFunccode(String funccode) {
		this.funccode = funccode;
	}

	/** @ 参数(param) */
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFuncdefine() {
		return funcdefine;
	}

	public void setFuncdefine(String funcdefine) {
		this.funcdefine = funcdefine;
	}

	public String getSystemcode() {
		return systemcode;
	}

	public void setSystemcode(String systemcode) {
		this.systemcode = systemcode;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
}
