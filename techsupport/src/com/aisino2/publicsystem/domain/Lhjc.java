package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Lhjc  {

	/** @param 联合检查(t_lhjc) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --联合检查ID--lhjcid--Integer--10-- */
	private Integer lhjcid;

	/** @ --管理部门联合检查登记序号--glbmlhjcdjxh--String--30-- */
	private String glbmlhjcdjxh;

	/** @ --联查机构级别代码--lcjgjbdm--String--1-- */
	private String lcjgjbdm;

	/** @ --联查机构级别--lcjgjb--String--30-- */
	private String lcjgjb;

	/** @ --联查机构类型代码--lcjglxdm--String--1-- */
	private String lcjglxdm;

	/** @ --联查机构类型--lcjglx--String--30-- */
	private String lcjglx;

	/** @ --联查机构代码--lcjgdm--String--30-- */
	private String lcjgdm;

	/** @ --联查机构名称--lcjgmc--String--100-- */
	private String lcjgmc;

	/** @ --联查时间--lcsj--Date---- */
	private Date lcsj;
	/** @ --联查时间zhi--lcsjzhi--Date---- */
	private Date lcsjzhi;

	/** @ --联查人员姓名--lcryxm--String--300-- */
	private String lcryxm;

	/** @ --联查事项--lcsx--String--200-- */
	private String lcsx;

	/** @ --发现问题--fxwt--String--300-- */
	private String fxwt;

	/** @ --联查结果--lcjg--String--200-- */
	private String lcjg;
	/** @ --联查结果--lcjg--String--200-- */
	private String qybm;
	private String gxdwbm;
	private String qymc;
	private String hylbdm;
	/** 分页排序 */
	private String pageSort;
	private int scbz;
	/** @ --导出标识--dcbs--Integer--2-- */
	private Integer dcbs;
	public Integer getDcbs() {
		return dcbs;
	}

	public void setDcbs(Integer dcbs) {
		this.dcbs = dcbs;
	}

	public int getScbz() {
		return scbz;
	}

	public void setScbz(int scbz) {
		this.scbz = scbz;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 联合检查ID(lhjcid) */
	public Integer getLhjcid() {
		return lhjcid;
	}

	public void setLhjcid(Integer lhjcid) {
		this.lhjcid = lhjcid;
	}

	/** @ 管理部门联合检查登记序号(glbmlhjcdjxh) */
	public String getGlbmlhjcdjxh() {
		return glbmlhjcdjxh;
	}

	public void setGlbmlhjcdjxh(String glbmlhjcdjxh) {
		this.glbmlhjcdjxh = glbmlhjcdjxh;
	}

	/** @ 联查机构级别代码(lcjgjbdm) */
	public String getLcjgjbdm() {
		return lcjgjbdm;
	}

	public void setLcjgjbdm(String lcjgjbdm) {
		this.lcjgjbdm = lcjgjbdm;
	}

	/** @ 联查机构级别(lcjgjb) */
	public String getLcjgjb() {
		return lcjgjb;
	}

	public void setLcjgjb(String lcjgjb) {
		this.lcjgjb = lcjgjb;
	}

	/** @ 联查机构类型代码(lcjglxdm) */
	public String getLcjglxdm() {
		return lcjglxdm;
	}

	public void setLcjglxdm(String lcjglxdm) {
		this.lcjglxdm = lcjglxdm;
	}

	/** @ 联查机构类型(lcjglx) */
	public String getLcjglx() {
		return lcjglx;
	}

	public void setLcjglx(String lcjglx) {
		this.lcjglx = lcjglx;
	}

	/** @ 联查机构代码(lcjgdm) */
	public String getLcjgdm() {
		return lcjgdm;
	}

	public void setLcjgdm(String lcjgdm) {
		this.lcjgdm = lcjgdm;
	}

	/** @ 联查机构名称(lcjgmc) */
	public String getLcjgmc() {
		return lcjgmc;
	}

	public void setLcjgmc(String lcjgmc) {
		this.lcjgmc = lcjgmc;
	}

	/** @ 联查时间(lcsj) */
	public Date getLcsj() {
		return lcsj;
	}

	public void setLcsj(Date lcsj) {
		this.lcsj = lcsj;
	}

	/** @ 联查人员姓名(lcryxm) */
	public String getLcryxm() {
		return lcryxm;
	}

	public void setLcryxm(String lcryxm) {
		this.lcryxm = lcryxm;
	}

	/** @ 联查事项(lcsx) */
	public String getLcsx() {
		return lcsx;
	}

	public void setLcsx(String lcsx) {
		this.lcsx = lcsx;
	}

	/** @ 发现问题(fxwt) */
	public String getFxwt() {
		return fxwt;
	}

	public void setFxwt(String fxwt) {
		this.fxwt = fxwt;
	}

	/** @ 联查结果(lcjg) */
	public String getLcjg() {
		return lcjg;
	}

	public void setLcjg(String lcjg) {
		this.lcjg = lcjg;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getLcsjzhi() {
		return lcsjzhi;
	}

	public void setLcsjzhi(Date lcsjzhi) {
		this.lcsjzhi = lcsjzhi;
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

	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}
}
