package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyry_tjxx  {

	/** @param 企业人员体检信息(t_qyry_tjxx) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --从业人员ID--ryid--Integer--10-- */
	private Integer ryid;

	/** @ --体检信息ID--tjxxid--Integer--10-- */
	private Integer tjxxid;

	/** @ --体检日期--tijianrq--Date---- */
	private Date tijianrq;

	/** @ --体检状况及描述--tjzkjms--String--2000-- */
	private String tjzkjms;

	/** @ --录入人--lrr--String--100-- */
	private String lrr;

	/** @ --录入日期--lrrq--Date---- */
	private Date lrrq;

	/** 分页排序 */
	private String pageSort;

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

	/** @ 体检信息ID(tjxxid) */
	public Integer getTjxxid() {
		return tjxxid;
	}

	public void setTjxxid(Integer tjxxid) {
		this.tjxxid = tjxxid;
	}

	/** @ 体检日期(tijianrq) */
	public Date getTijianrq() {
		return tijianrq;
	}

	public void setTijianrq(Date tijianrq) {
		this.tijianrq = tijianrq;
	}

	/** @ 体检状况及描述(tjzkjms) */
	public String getTjzkjms() {
		return tjzkjms;
	}

	public void setTjzkjms(String tjzkjms) {
		this.tjzkjms = tjzkjms;
	}

	/** @ 录入人(lrr) */
	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	/** @ 录入日期(lrrq) */
	public Date getLrrq() {
		return lrrq;
	}

	public void setLrrq(Date lrrq) {
		this.lrrq = lrrq;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
