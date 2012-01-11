package com.aisino2.publicsystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Qybaxx  {

	/** @param 企业备案信息(t_qybaxx) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --企业备案信息ID--qybaxxid--Integer--10-- */
	private Integer qybaxxid;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --企业备案编码--qybabm--String--20-- */
	private String qybabm;

	/** @ --备案日期--barq--Date---- */
	private Date barq;
	/** @ --备案日期zhi--barqzhi--Date---- */
	private Date barqzhi;

	/** @ --备案部门编码--babmbm--String--20-- */
	private String babmbm;

	/** @ --备案部门名称--babmmc--String--200-- */
	private String babmmc;

	/** @ --备案人--bar--String--200-- */
	private String bar;

	/** @ --是否提交完整--sftjwz--String--1-- */
	private String sftjwz;
	/** 分页排序 */
	private String pageSort;
	/** 提交材料类型 */
	private List lTjclxx;
	/** 场所补充备案信息 */
	private Qybcbaxx qybcbaxx;
	private int scbz;
	/** @ --所属省份--*/
	private String sssf;
	
	public String getSssf() {
		return sssf;
	}
	public void setSssf(String sssf) {
		this.sssf = sssf;
	}
	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}
	public List getLTjclxx() {
		return lTjclxx;
	}

	public void setLTjclxx(List tjclxx) {
		lTjclxx = tjclxx;
	}
	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 企业备案信息ID(qybaxxid) */
	public Integer getQybaxxid() {
		return qybaxxid;
	}

	public void setQybaxxid(Integer qybaxxid) {
		this.qybaxxid = qybaxxid;
	}

	/** @ 企业编码(qybm) */
	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}

	/** @ 企业备案编码(qybabm) */
	public String getQybabm() {
		return qybabm;
	}

	public void setQybabm(String qybabm) {
		this.qybabm = qybabm;
	}

	/** @ 备案日期(barq) */
	public Date getBarq() {
		return barq;
	}

	public void setBarq(Date barq) {
		this.barq = barq;
	}

	/** @ 备案部门编码(babmbm) */
	public String getBabmbm() {
		return babmbm;
	}

	public void setBabmbm(String babmbm) {
		this.babmbm = babmbm;
	}

	/** @ 备案部门名称(babmmc) */
	public String getBabmmc() {
		return babmmc;
	}

	public void setBabmmc(String babmmc) {
		this.babmmc = babmmc;
	}

	/** @ 备案人(bar) */
	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	/** @ 是否提交完整(sftjwz) */
	public String getSftjwz() {
		return sftjwz;
	}

	public void setSftjwz(String sftjwz) {
		this.sftjwz = sftjwz;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getBarqzhi() {
		return barqzhi;
	}

	public void setBarqzhi(Date barqzhi) {
		this.barqzhi = barqzhi;
	}
	public Qybcbaxx getQybcbaxx() {
		return qybcbaxx;
	}
	public void setQybcbaxx(Qybcbaxx qybcbaxx) {
		this.qybcbaxx = qybcbaxx;
	}
	public int getScbz() {
		return scbz;
	}
	public void setScbz(int scbz) {
		this.scbz = scbz;
	}
}
