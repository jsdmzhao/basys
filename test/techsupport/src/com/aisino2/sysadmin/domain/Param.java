package com.aisino2.sysadmin.domain;

import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Param  {

	/** @param 参数设置(t_param) */

	/** @ --参数编码--paramcode--String--50-- */
	private String paramcode;

	/** @ --参数名称--paramname--String--50-- */
	private String paramname;

	/** @ --参数值--paramvalue--String--1000-- */
	private String paramvalue;
	
	/** @ --角色Id集合--*/
	private String roleidSet;

	/** @ --角色参数列表--*/
	private List lRoleParamList;
	
	/** 筛选字段*/
	private String query_simplepin;

	/** 分页排序 */
	private String pageSort;

	/** @ 参数编码(paramcode) */

	

	public String getParamcode() {
		return paramcode;
	}

	public List getLRoleParamList() {
		return lRoleParamList;
	}

	public void setLRoleParamList(List roleParamList) {
		lRoleParamList = roleParamList;
	}

	public String getRoleidSet() {
		return roleidSet;
	}

	public void setRoleidSet(String roleidSet) {
		this.roleidSet = roleidSet;
	}

	public void setParamcode(String paramcode) {
		this.paramcode = paramcode;
	}

	/** @ 参数名称(paramname) */
	public String getParamname() {
		return paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	/** @ 参数值(paramvalue) */
	public String getParamvalue() {
		return paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getQuery_simplepin() {
		return query_simplepin;
	}

	public void setQuery_simplepin(String query_simplepin) {
		this.query_simplepin = query_simplepin;
	}
}
