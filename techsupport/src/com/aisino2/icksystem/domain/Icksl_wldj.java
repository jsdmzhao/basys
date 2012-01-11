package com.aisino2.icksystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Icksl_wldj  {

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) */

	/** @ --IC卡受理ID--ickslid--Integer--10-- */
	private Integer ickslid;

	/** @ --物流ID--wlid--Integer--10-- */
	private Integer wlid;
	
	/** @ --物流包制卡状态标识 制卡状态的冗余字段--wlbzkztbs--String--2-- */
	private String wlbzkztbs;

	/** 分页排序 */
	private String pageSort;

	/** @ IC卡受理ID(ickslid) */
	public Integer getIckslid() {
		return ickslid;
	}

	public void setIckslid(Integer ickslid) {
		this.ickslid = ickslid;
	}

	/** @ 物流ID(wlid) */
	public Integer getWlid() {
		return wlid;
	}

	public void setWlid(Integer wlid) {
		this.wlid = wlid;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getWlbzkztbs() {
		return wlbzkztbs;
	}

	public void setWlbzkztbs(String wlbzkztbs) {
		this.wlbzkztbs = wlbzkztbs;
	}

	
}
