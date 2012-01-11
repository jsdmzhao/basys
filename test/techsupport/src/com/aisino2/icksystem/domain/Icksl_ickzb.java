package com.aisino2.icksystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Icksl_ickzb  {

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) */

	/** @ --IC卡受理ID--ickslid--Integer--10-- */
	private Integer ickslid;

	/** @ --组包ID--zbid--Integer--10-- */
	private Integer zbid;

	/** @ --批次中的排版号--pczdpbh--Integer--2-- */
	private Integer pczdpbh;

	/** @ --组包后所处的页码--zbhsuym--Integer--10-- */
	private Integer zbhsuym;

	/** 分页排序 */
	private String pageSort;

	/** IC卡受理表中的采集点编码 */
	private String cjdbmInIcksl;
	
	/** @ IC卡受理ID(ickslid) */
	public Integer getIckslid() {
		return ickslid;
	}

	public void setIckslid(Integer ickslid) {
		this.ickslid = ickslid;
	}

	/** @ 组包ID(zbid) */
	public Integer getZbid() {
		return zbid;
	}

	public void setZbid(Integer zbid) {
		this.zbid = zbid;
	}

	/** @ 批次中的排版号(pczdpbh) */
	public Integer getPczdpbh() {
		return pczdpbh;
	}

	public void setPczdpbh(Integer pczdpbh) {
		this.pczdpbh = pczdpbh;
	}

	/** @ 组包后所处的页码(zbhsuym) */
	public Integer getZbhsuym() {
		return zbhsuym;
	}

	public void setZbhsuym(Integer zbhsuym) {
		this.zbhsuym = zbhsuym;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getCjdbmInIcksl() {
		return cjdbmInIcksl;
	}

	public void setCjdbmInIcksl(String cjdbmInIcksl) {
		this.cjdbmInIcksl = cjdbmInIcksl;
	}
}
