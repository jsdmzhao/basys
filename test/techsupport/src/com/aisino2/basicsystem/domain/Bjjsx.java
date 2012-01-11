package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Bjjsx  {

	/** @param 报警机刷新(t_bjjsx) */

	/** @ --报警机序号--bjjxh--Integer--10-- */
	private Integer bjjxh;

	/** @ --公安机关编码--gajgbm--String--20-- */
	private String gajgbm;

	/** @ --公安机关名称--gajgmc--String--100-- */
	private String gajgmc;

	/** @ --报警机IP地址--bjjipdz--String--60-- */
	private String bjjipdz;

	/** @ --报警机刷新时间--bjjsxj--Date---- */
	private Date bjjsxj;

	/** @ --与上次刷新时间间隔--yscsxsjdjg--Integer--6-- */
	private Integer yscsxsjdjg;

	/** 分页排序 */
	private String pageSort;

	/** @ 报警机序号(bjjxh) */
	public Integer getBjjxh() {
		return bjjxh;
	}

	public void setBjjxh(Integer bjjxh) {
		this.bjjxh = bjjxh;
	}

	/** @ 公安机关编码(gajgbm) */
	public String getGajgbm() {
		return gajgbm;
	}

	public void setGajgbm(String gajgbm) {
		this.gajgbm = gajgbm;
	}

	/** @ 公安机关名称(gajgmc) */
	public String getGajgmc() {
		return gajgmc;
	}

	public void setGajgmc(String gajgmc) {
		this.gajgmc = gajgmc;
	}

	/** @ 报警机IP地址(bjjipdz) */
	public String getBjjipdz() {
		return bjjipdz;
	}

	public void setBjjipdz(String bjjipdz) {
		this.bjjipdz = bjjipdz;
	}

	/** @ 报警机刷新时间(bjjsxj) */
	public Date getBjjsxj() {
		return bjjsxj;
	}

	public void setBjjsxj(Date bjjsxj) {
		this.bjjsxj = bjjsxj;
	}

	/** @ 与上次刷新时间间隔(yscsxsjdjg) */
	public Integer getYscsxsjdjg() {
		return yscsxsjdjg;
	}

	public void setYscsxsjdjg(Integer yscsxsjdjg) {
		this.yscsxsjdjg = yscsxsjdjg;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
