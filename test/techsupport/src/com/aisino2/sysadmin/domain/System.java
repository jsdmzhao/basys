package com.aisino2.sysadmin.domain;

import com.aisino2.core.domain.BaseObject;

public class System  {

	/** @param 系统(t_system) */

	/** @ --系统代码--systemcode--String--20-- */
	private String systemcode;

	/** @ --系统名称--systemname--String--50-- */
	private String systemname;

	/** @ --系统定义--systemdefine--String--200-- */
	private String systemdefine;

	/** @ --图片路径--picturepath--String--200-- */
	private String picturepath;

	/** @ --上级系统代码--parentsystemcode--String--20-- */
	private String parentsystemcode;

	/** @ --节点顺序--nodeorder--Integer--9-- */
	private Integer nodeorder;

	/** @ --是否叶结点--isleaf--String--1-- */
	private String isleaf;

	/** @ --系统全路径代码--fullcode--String--50-- */
	private String fullcode;

	/** 分页排序 */
	private String pageSort;
	
	/** 移动方式 */
	private String way;
	
	/**
	 * 上级系统名称
	 */
	
	
	private String parentsystemname;
	
	
	//用户userid
	private Integer userid;

   //系统下拉列表使用属性
   private String display_name;
   
   private String fact_value;
	   
	public String getDisplay_name() {
		return systemname;
	}
	
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	
	public String getFact_value() {
		return systemcode;
	}
	
	public void setFact_value(String fact_value) {
		this.fact_value = fact_value;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/** @ 系统代码(systemcode) */
	public String getSystemcode() {
		return systemcode;
	}

	public void setSystemcode(String systemcode) {
		this.systemcode = systemcode;
	}

	/** @ 系统名称(systemname) */
	public String getSystemname() {
		return systemname;
	}

	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}

	/** @ 系统定义(systemdefine) */
	public String getSystemdefine() {
		return systemdefine;
	}

	public void setSystemdefine(String systemdefine) {
		this.systemdefine = systemdefine;
	}

	/** @ 图片路径(picturepath) */
	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

	/** @ 上级系统代码(parentsystemcode) */
	public String getParentsystemcode() {
		return parentsystemcode;
	}

	public void setParentsystemcode(String parentsystemcode) {
		this.parentsystemcode = parentsystemcode;
	}

	/** @ 节点顺序(nodeorder) */
	public Integer getNodeorder() {
		return nodeorder;
	}

	public void setNodeorder(Integer nodeorder) {
		this.nodeorder = nodeorder;
	}

	/** @ 是否叶结点(isleaf) */
	public String getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}

	/** @ 系统全路径代码(fullcode) */
	public String getFullcode() {
		return fullcode;
	}

	public void setFullcode(String fullcode) {
		this.fullcode = fullcode;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getParentsystemname() {
		return parentsystemname;
	}

	public void setParentsystemname(String parentsystemname) {
		this.parentsystemname = parentsystemname;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}
}
