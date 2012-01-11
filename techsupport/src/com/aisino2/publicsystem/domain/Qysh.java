package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qysh  {

	/** @param 企业审核(t_qysh) */

	/** @ --企业审核ID--qyshid--Integer--10-- */
	private Integer qyshid;

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --审核时间--shsj--Date---- */
	private Date shsj;

	/** @ --审核人--shr--String--60-- */
	private String shr;

	/** @ --审核单位代码--shdwdm--String--20-- */
	private String shdwdm;

	/** @ --审核单位名称--shdwmc--String--60-- */
	private String shdwmc;

	/** @ --审核失败原因--shsbyy--String--2000-- */
	private String shsbyy;

	/** @ --上级审核ID--sjshid--Integer--10-- */
	private Integer sjshid;

	/** @ --审核状态--shzt--String--2-- */
	private String shzt;

	/** 分页排序 */
	private String pageSort;

	/** @ 企业审核ID(qyshid) */
	public Integer getQyshid() {
		return qyshid;
	}

	public void setQyshid(Integer qyshid) {
		this.qyshid = qyshid;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 审核时间(shsj) */
	public Date getShsj() {
		return shsj;
	}

	public void setShsj(Date shsj) {
		this.shsj = shsj;
	}

	/** @ 审核人(shr) */
	public String getShr() {
		return shr;
	}

	public void setShr(String shr) {
		this.shr = shr;
	}

	/** @ 审核单位代码(shdwdm) */
	public String getShdwdm() {
		return shdwdm;
	}

	public void setShdwdm(String shdwdm) {
		this.shdwdm = shdwdm;
	}

	/** @ 审核单位名称(shdwmc) */
	public String getShdwmc() {
		return shdwmc;
	}

	public void setShdwmc(String shdwmc) {
		this.shdwmc = shdwmc;
	}

	/** @ 审核失败原因(shsbyy) */
	public String getShsbyy() {
		return shsbyy;
	}

	public void setShsbyy(String shsbyy) {
		this.shsbyy = shsbyy;
	}

	/** @ 上级审核ID(sjshid) */
	public Integer getSjshid() {
		return sjshid;
	}

	public void setSjshid(Integer sjshid) {
		this.sjshid = sjshid;
	}

	/** @ 审核状态(shzt) */
	public String getShzt() {
		return shzt;
	}

	public void setShzt(String shzt) {
		this.shzt = shzt;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
