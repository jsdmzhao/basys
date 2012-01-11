package com.aisino2.sysadmin.domain;

import com.aisino2.core.domain.BaseObject;

public class Globalpar  {

	/** @param 全局参数(t_globalpar) */

	/** @ --参数编码--globalparcode--String--50-- */
	private String globalparcode;

	/** @ --参数名称--globalparname--String--50-- */
	private String globalparname;

	/** @ --参数值--globalparvalue--String--1000-- */
	private String globalparvalue;

	/** 分页排序 */
	private String pageSort;

	/** @ 参数编码(globalparcode) */
	public String getGlobalparcode() {
		return globalparcode;
	}

	public void setGlobalparcode(String globalparcode) {
		this.globalparcode = globalparcode;
	}

	/** @ 参数名称(globalparname) */
	public String getGlobalparname() {
		return globalparname;
	}

	public void setGlobalparname(String globalparname) {
		this.globalparname = globalparname;
	}

	/** @ 参数值(globalparvalue) */
	public String getGlobalparvalue() {
		return globalparvalue;
	}

	public void setGlobalparvalue(String globalparvalue) {
		this.globalparvalue = globalparvalue;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
