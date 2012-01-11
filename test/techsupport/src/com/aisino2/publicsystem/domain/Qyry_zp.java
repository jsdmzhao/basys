package com.aisino2.publicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Qyry_zp  {

	/** @param 企业人员_照片(t_qyry_zp) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --从业人员ID--ryid--Integer--10-- */
	private Integer ryid;

	/** @ --照片ID--zpid--Integer--10-- */
	private Integer zpid;

	/** @ --图片名称--tpmc--String--100-- */
	private String tpmc;

	/** @ --图片类型--tplx--String--40-- */
	private String tplx;

	/** @ --图片内容--tpnr--byte[]---- */
	private byte[] tpnr;

	/** 分页排序 */
	private String pageSort;
	
	//照片是否存在 1-存在 0-不存在
	private String isZpExist;

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

	/** @ 照片ID(zpid) */
	public Integer getZpid() {
		return zpid;
	}

	public void setZpid(Integer zpid) {
		this.zpid = zpid;
	}

	/** @ 图片名称(tpmc) */
	public String getTpmc() {
		return tpmc;
	}

	public void setTpmc(String tpmc) {
		this.tpmc = tpmc;
	}

	/** @ 图片类型(tplx) */
	public String getTplx() {
		return tplx;
	}

	public void setTplx(String tplx) {
		this.tplx = tplx;
	}

	/** @ 图片内容(tpnr) */
	public byte[] getTpnr() {
		return tpnr;
	}

	public void setTpnr(byte[] tpnr) {
		this.tpnr = tpnr;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getIsZpExist() {
		return isZpExist;
	}

	public void setIsZpExist(String isZpExist) {
		this.isZpExist = isZpExist;
	}
}
