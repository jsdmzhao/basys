package com.aisino2.publicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Qyzlxxfj  {

	/** @param 企业质量信息附件(t_qyzlxxfj) */

	/** @ --企业质量信息附件ID--qyzlxxfjid--Integer--10-- */
	private Integer qyzlxxfjid;

	/** @ --企业质量信息ID--qyzlxxid--Integer--10-- */
	private Integer qyzlxxid;

	/** @ --附件名称--fjmc--String--100-- */
	private String fjmc;

	/** @ --附件类型--fjlx--String--60-- */
	private String fjlx;

	/** @ --附件内容--fjnr--byte[]---- */
	private byte[] fjnr;

	/** 分页排序 */
	private String pageSort;
	
////附件的base64编码
	private String fjbase;
	
	

	public String getFjbase() {
		return fjbase;
	}

	public void setFjbase(String fjbase) {
		this.fjbase = fjbase;
	}

	/** @ 企业质量信息附件ID(qyzlxxfjid) */
	public Integer getQyzlxxfjid() {
		return qyzlxxfjid;
	}

	public void setQyzlxxfjid(Integer qyzlxxfjid) {
		this.qyzlxxfjid = qyzlxxfjid;
	}

	/** @ 企业质量信息ID(qyzlxxid) */
	public Integer getQyzlxxid() {
		return qyzlxxid;
	}

	public void setQyzlxxid(Integer qyzlxxid) {
		this.qyzlxxid = qyzlxxid;
	}

	/** @ 附件名称(fjmc) */
	public String getFjmc() {
		return fjmc;
	}

	public void setFjmc(String fjmc) {
		this.fjmc = fjmc;
	}

	/** @ 附件类型(fjlx) */
	public String getFjlx() {
		return fjlx;
	}

	public void setFjlx(String fjlx) {
		this.fjlx = fjlx;
	}

	/** @ 附件内容(fjnr) */
	public byte[] getFjnr() {
		return fjnr;
	}

	public void setFjnr(byte[] fjnr) {
		this.fjnr = fjnr;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
