package com.aisino2.sysadmin.domain;

import com.aisino2.core.domain.BaseObject;

public class Role_param  {

	/** @param 角色参数(t_role_param) */

	/** @ --角色ID--roleid--Integer--9-- */
	private Integer roleid;

	/** @ --参数编码--paramcode--String--50-- */
	private String paramcode;
	
	/** @ --参数名称-- */
	private String paramname;

	/** @ --参数值-- */
	private String paramvalue;

	/** 分页排序 */
	private String pageSort;

	/** @ 角色ID(roleid) */
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/** @ 参数编码(paramcode) */
	public String getParamcode() {
		return paramcode;
	}

	public void setParamcode(String paramcode) {
		this.paramcode = paramcode;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getParamname() {
		return paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	public String getParamvalue() {
		return paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}
}
