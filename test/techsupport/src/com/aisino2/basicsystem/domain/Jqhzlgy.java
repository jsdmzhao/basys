package com.aisino2.basicsystem.domain;

import java.util.Date;

public class Jqhzlgy {
	// 结果属性
	private String departbrevitycode;
	private String departname;
	
	private String bjzs;    //报警总数
	private String zhs;     //抓获数
	private String bdzhs;    //本地抓获数
	private String bszhs;    //本省抓获数
	private String kszhs;     //跨省抓获数
	
	// 查询条件
	private Date bjsj1;
	private Date bjsj2;
	private String gxdwbm;
	private String gxdwlevel;
	private String hylbdm;
	// 合计判断
	private String isQuery;
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
	public String getBjzs() {
		return bjzs;
	}
	public void setBjzs(String bjzs) {
		this.bjzs = bjzs;
	}
	public String getZhs() {
		return zhs;
	}
	public void setZhs(String zhs) {
		this.zhs = zhs;
	}
	public String getBdzhs() {
		return bdzhs;
	}
	public void setBdzhs(String bdzhs) {
		this.bdzhs = bdzhs;
	}
	public String getBszhs() {
		return bszhs;
	}
	public void setBszhs(String bszhs) {
		this.bszhs = bszhs;
	}
	public String getKszhs() {
		return kszhs;
	}
	public void setKszhs(String kszhs) {
		this.kszhs = kszhs;
	}
	public Date getBjsj1() {
		return bjsj1;
	}
	public void setBjsj1(Date bjsj1) {
		this.bjsj1 = bjsj1;
	}
	public Date getBjsj2() {
		return bjsj2;
	}
	public void setBjsj2(Date bjsj2) {
		this.bjsj2 = bjsj2;
	}
	public String getGxdwbm() {
		return gxdwbm;
	}
	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}
	public String getGxdwlevel() {
		return gxdwlevel;
	}
	public void setGxdwlevel(String gxdwlevel) {
		this.gxdwlevel = gxdwlevel;
	}
	public String getHylbdm() {
		return hylbdm;
	}
	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}
	public String getIsQuery() {
		return isQuery;
	}
	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}
	public String getPageSort() {
		return pageSort;
	}
	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
	
	

	
}