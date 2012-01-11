package com.aisino2.publicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Clxxry_zp  {

	/** @param 车辆信息人员_照片(t_clxxry_zp) */

	/** @ --车辆基本信息ID--cljbxxid--Integer--10-- */
	private Integer cljbxxid;

	/** @ --车辆信息人员照片ID--clxxryzpid--Integer--10-- */
	private Integer clxxryzpid;

	/** @ --图片名称--tpmc--String--100-- */
	private String tpmc;

	/** @ --图片类型--tplx--String--40-- */
	private String tplx;

	/** @ --图片内容--tpnr--byte[]---- */
	private byte[] tpnr;

	/** 分页排序 */
	private String pageSort;

	/** @ 车辆基本信息ID(cljbxxid) */
	public Integer getCljbxxid() {
		return cljbxxid;
	}

	public void setCljbxxid(Integer cljbxxid) {
		this.cljbxxid = cljbxxid;
	}

	/** @ 车辆信息人员照片ID(clxxryzpid) */
	public Integer getClxxryzpid() {
		return clxxryzpid;
	}

	public void setClxxryzpid(Integer clxxryzpid) {
		this.clxxryzpid = clxxryzpid;
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
	
}
