package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Bksj  {

	/** @param 布控手机(t_bksj) */

	/** @ --布控物品基本信息ID--bkwpjbxxid--Integer--10-- */
	private Integer bkwpjbxxid;

	/** @ --布控手机ID--bksjid--Integer--10-- */
	private Integer bksjid;

	/** @ --手机串号--sjch--String--30-- */
	private String sjch;

	/** @ --品牌--pp--String--100-- */
	private String pp;

	/** @ --型号--xh--String--100-- */
	private String xh;

	/** @ --颜色--ys--String--60-- */
	private String ys;

	/** 分页排序 */
	private String pageSort;

	/** @ 布控物品基本信息ID(bkwpjbxxid) */
	public Integer getBkwpjbxxid() {
		return bkwpjbxxid;
	}

	public void setBkwpjbxxid(Integer bkwpjbxxid) {
		this.bkwpjbxxid = bkwpjbxxid;
	}

	/** @ 布控手机ID(bksjid) */
	public Integer getBksjid() {
		return bksjid;
	}

	public void setBksjid(Integer bksjid) {
		this.bksjid = bksjid;
	}

	/** @ 手机串号(sjch) */
	public String getSjch() {
		return sjch;
	}

	public void setSjch(String sjch) {
		this.sjch = sjch;
	}

	/** @ 品牌(pp) */
	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	/** @ 型号(xh) */
	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	/** @ 颜色(ys) */
	public String getYs() {
		return ys;
	}

	public void setYs(String ys) {
		this.ys = ys;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
