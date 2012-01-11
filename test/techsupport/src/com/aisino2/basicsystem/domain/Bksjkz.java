package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Bksjkz  {

	/** @param 布控手机快照(t_bksjkz) */

	/** @ --报警信息ID--bjxxid2--Integer--10-- */
	private Integer bjxxid2;
	
	/** @ --物品报警规则ID--wpbjgzid--Integer--10-- */
	private Integer wpbjgzid;

	/** @ --布控物品基本信息快照ID--bkwpjbxxkzid--Integer--10-- */
	private Integer bkwpjbxxkzid;

	/** @ --布控手机快照ID--bksjkzid--Integer--10-- */
	private Integer bksjkzid;

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

	/** @ 报警信息ID(bjxxid2) */
	public Integer getBjxxid2() {
		return bjxxid2;
	}

	public void setBjxxid2(Integer bjxxid2) {
		this.bjxxid2 = bjxxid2;
	}

	public Integer getWpbjgzid() {
		return wpbjgzid;
	}

	public void setWpbjgzid(Integer wpbjgzid) {
		this.wpbjgzid = wpbjgzid;
	}

	/** @ 布控物品基本信息快照ID(bkwpjbxxkzid) */
	public Integer getBkwpjbxxkzid() {
		return bkwpjbxxkzid;
	}

	public void setBkwpjbxxkzid(Integer bkwpjbxxkzid) {
		this.bkwpjbxxkzid = bkwpjbxxkzid;
	}

	/** @ 布控手机快照ID(bksjkzid) */
	public Integer getBksjkzid() {
		return bksjkzid;
	}

	public void setBksjkzid(Integer bksjkzid) {
		this.bksjkzid = bksjkzid;
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
