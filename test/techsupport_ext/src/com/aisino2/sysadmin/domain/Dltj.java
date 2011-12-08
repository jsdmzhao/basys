package com.aisino2.sysadmin.domain;

import java.util.Date;

public class Dltj  {
	
	
	private String  departbrevitycode;  ///部门简项代码
	
	private String  departname;   //部门名称

	private String dlzs;   //登陆人数
	
	private Date kssj;  //开始时间
	
	private Date jssj;  //结束时间
	
	private String gxdwbm;  ///管辖单位编码
	
	private String isQuery;

	public String getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	public Date getKssj() {
		return kssj;
	}

	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}

	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}

	/** 分页排序 */
	private String pageSort;

	public String getDepartbrevitycode() {
		return departbrevitycode;
	}

	public void setDepartbrevitycode(String departbrevitycode) {
		this.departbrevitycode = departbrevitycode;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	public String getDlzs() {
		return dlzs;
	}

	public void setDlzs(String dlzs) {
		this.dlzs = dlzs;
	}

	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	
	
	

	
}
