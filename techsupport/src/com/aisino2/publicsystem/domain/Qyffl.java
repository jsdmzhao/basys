package com.aisino2.publicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Qyffl  {

	/** @param 企业副分类(t_qyffl) */

	/** @ --企业分类ID--qyflid--Integer--10-- */
	private Integer qyflid;

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --企业分类编码--qyflbm--String--4-- */
	private String qyflbm;

	/** @ --上级场所分类名称--sjcsflmc--String--200-- */
	private String sjcsflmc;
	/** @ --上级场所分类编码--sjcsflbm--String--200-- */
	private String sjcsflbm;

	/** @ --企业分类名称--qyflmc--String--300-- */
	private String qyflmc;

	/** 分页排序 */
	private String pageSort;

	/** @ 企业分类ID(qyflid) */
	public Integer getQyflid() {
		return qyflid;
	}

	public void setQyflid(Integer qyflid) {
		this.qyflid = qyflid;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 企业分类编码(qyflbm) */
	public String getQyflbm() {
		return qyflbm;
	}

	public void setQyflbm(String qyflbm) {
		this.qyflbm = qyflbm;
	}

	/** @ 上级场所分类名称(sjcsflmc) */
	public String getSjcsflmc() {
		return sjcsflmc;
	}

	public void setSjcsflmc(String sjcsflmc) {
		this.sjcsflmc = sjcsflmc;
	}

	/** @ 企业分类名称(qyflmc) */
	public String getQyflmc() {
		return qyflmc;
	}

	public void setQyflmc(String qyflmc) {
		this.qyflmc = qyflmc;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getSjcsflbm() {
		return sjcsflbm;
	}

	public void setSjcsflbm(String sjcsflbm) {
		this.sjcsflbm = sjcsflbm;
	}
}
