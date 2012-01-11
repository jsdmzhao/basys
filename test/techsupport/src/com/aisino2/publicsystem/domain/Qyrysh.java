package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyrysh  {

	/** @param 企业人员审核(t_qyrysh) */

	/** @ --人员审核ID--ryshid--Integer--10-- */
	private Integer ryshid;

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --从业人员ID--ryid--Integer--10-- */
	private Integer ryid;

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
	
	private Integer newRyid;

	

	/** @ 人员审核ID(ryshid) */
	public Integer getRyshid() {
		return ryshid;
	}

	public void setRyshid(Integer ryshid) {
		this.ryshid = ryshid;
	}

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

	public Integer getNewRyid() {
		return newRyid;
	}

	public void setNewRyid(Integer newRyid) {
		this.newRyid = newRyid;
	}
}
