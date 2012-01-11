package com.aisino2.basicsystem.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Cjtj {
	// 结果属性
	private String departbrevitycode;
	private String departname;
	private Integer jjzs=0;
	private Integer yxbjs=0;
	private Integer hfs=0;
	private Float hfl=0f;
	// 查询条件
	private Date bjsj1;
	private Date bjsj2;
	private String gxdwbm;
	private String gxdwlevel;
	private String gxdwbm_full;
	private String hylbdm;
	private String isleaf;
	// 合计判断
	private String isQuery;

	public String getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

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

	public Integer getJjzs() {
		return jjzs;
	}

	public void setJjzs(Integer jjzs) {
		this.jjzs = jjzs;
	}

	public Integer getYxbjs() {
		return yxbjs;
	}

	public void setYxbjs(Integer yxbjs) {
		this.yxbjs = yxbjs;
	}

	public Integer getHfs() {
		return hfs;
	}

	public void setHfs(Integer hfs) {
		this.hfs = hfs;
	}

	public Float getHfl() {
		if(yxbjs!=0){
			hfl=(((float)hfs/(float)yxbjs)*100);
			BigDecimal   b   =   new   BigDecimal(hfl);   
			hfl=b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();   
		}
		return hfl;
	}

	public void setHfl(Float hfl) {
		this.hfl = hfl;
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

	public String getGxdwbm_full() {
		return gxdwbm_full;
	}

	public void setGxdwbm_full(String gxdwbm_full) {
		this.gxdwbm_full = gxdwbm_full;
	}

	public String getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}
	
	
}