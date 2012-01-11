package com.aisino2.basicsystem.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Ztxx {
	// 结果属性
	private String departbrevitycode;
	private String departname;
	private Integer bjzs = 0;
	private Integer yxbjs = 0;
	private Integer zts = 0;
	private Integer lws = 0;
	private Integer zhqgztrs = 0;
	private Integer zhbdbkrs = 0;
	private Integer bdbkydzhs = 0;
	private Float ztl = 0f;
	private Float cjl = 0f;
	private Integer cjs =0;
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
	/** 分页排序 */
	private String pageSort;
	
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Integer getBjzs() {
		return bjzs;
	}

	public void setBjzs(Integer bjzs) {
		this.bjzs = bjzs;
	}

	public Integer getYxbjs() {
		return yxbjs;
	}

	public void setYxbjs(Integer yxbjs) {
		this.yxbjs = yxbjs;
	}

	public Integer getZts() {
		return zts;
	}

	public void setZts(Integer zts) {
		this.zts = zts;
	}

	public Integer getLws() {
		return lws;
	}

	public void setLws(Integer lws) {
		this.lws = lws;
	}

	public Integer getZhqgztrs() {
		return zhqgztrs;
	}

	public void setZhqgztrs(Integer zhqgztrs) {
		this.zhqgztrs = zhqgztrs;
	}

	public Integer getZhbdbkrs() {
		return zhbdbkrs;
	}

	public void setZhbdbkrs(Integer zhbdbkrs) {
		this.zhbdbkrs = zhbdbkrs;
	}

	public Integer getBdbkydzhs() {
		return bdbkydzhs;
	}

	public void setBdbkydzhs(Integer bdbkydzhs) {
		this.bdbkydzhs = bdbkydzhs;
	}

	public Float getZtl() {
		if(yxbjs!=0){
			ztl = (((float)zts/(float)yxbjs)*100);
			BigDecimal b = new BigDecimal(ztl);   
			ztl=b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();   
		}
		return ztl;
	}

	public void setZtl(Float ztl) {
		this.ztl = ztl;
	}

	public Float getCjl() {
		if(yxbjs!=0){
			cjl = (((float)cjs/(float)yxbjs)*100);
			BigDecimal b = new BigDecimal(cjl);   
			cjl=b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();   
		}
		return cjl;
	}

	public void setCjl(Float cjl) {
		this.cjl = cjl;
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

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public Integer getCjs() {
		return cjs;
	}

	public void setCjs(Integer cjs) {
		this.cjs = cjs;
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