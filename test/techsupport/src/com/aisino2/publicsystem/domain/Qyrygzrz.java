package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyrygzrz  {

	/** @param 企业人员工作日志(t_qyrygzrz) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;
	
	/** @ --工作日期--gzrq--Date---- */
	private Date gzrq;

	/** @ --从业人员ID--ryid--Integer--10-- */
	private Integer ryid;

	/** @ --企业人员工作日志ID--qyrygzrzid--Integer--10-- */
	private Integer qyrygzrzid;

	/** @ --工作开始时间--gzkssj--Date---- */
	private Date gzkssj;

	/** @ --工作结束时间--gzjssj--Date---- */
	private Date gzjssj;

	/** @ --工作地点--gzdd--String--100-- */
	private String gzdd;

	/** @ --岗位信息--gwxx--String--300-- */
	private String gwxx;
	
	/** @ --从业类别--gwxx--String--300-- */
	private String cylb;

	/** 分页排序 */
	private String pageSort;
	
	private String xm;
	private String zjhm;
	private String cyrybh;
	private String qybm;
	private String qymc;
	private String gxdwbm;
	private String gxdwmc;
	private String kh;
	private String jydz;
	
	private Date gzrqf;
	private Date gzrqt;

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 从业人员ID(ryid) */
	public Integer getRyid() {
		return ryid;
	}

	public void setRyid(Integer ryid) {
		this.ryid = ryid;
	}

	/** @ 企业人员工作日志ID(qyrygzrzid) */
	public Integer getQyrygzrzid() {
		return qyrygzrzid;
	}

	public void setQyrygzrzid(Integer qyrygzrzid) {
		this.qyrygzrzid = qyrygzrzid;
	}

	/** @ 工作开始时间(gzkssj) */
	public Date getGzkssj() {
		return gzkssj;
	}

	public void setGzkssj(Date gzkssj) {
		this.gzkssj = gzkssj;
	}

	/** @ 工作结束时间(gzjssj) */
	public Date getGzjssj() {
		return gzjssj;
	}

	public void setGzjssj(Date gzjssj) {
		this.gzjssj = gzjssj;
	}

	/** @ 工作地点(gzdd) */
	public String getGzdd() {
		return gzdd;
	}

	public void setGzdd(String gzdd) {
		this.gzdd = gzdd;
	}

	/** @ 岗位信息(gwxx) */
	public String getGwxx() {
		return gwxx;
	}

	public void setGwxx(String gwxx) {
		this.gwxx = gwxx;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getGzrq() {
		return gzrq;
	}

	public void setGzrq(Date gzrq) {
		this.gzrq = gzrq;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}

	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	public Date getGzrqf() {
		return gzrqf;
	}

	public void setGzrqf(Date gzrqf) {
		this.gzrqf = gzrqf;
	}

	public Date getGzrqt() {
		return gzrqt;
	}

	public void setGzrqt(Date gzrqt) {
		this.gzrqt = gzrqt;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getJydz() {
		return jydz;
	}

	public void setJydz(String jydz) {
		this.jydz = jydz;
	}

	public String getCylb() {
		return cylb;
	}

	public void setCylb(String cylb) {
		this.cylb = cylb;
	}
	
}
