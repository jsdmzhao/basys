package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Gatztbhf  {

	/** @param 公安通知通报回复(t_gatztbhf) */

	/** @ --公安通报ID--gatbid--Integer--10-- */
	private Integer gatbid;

	/** @ --公安接收单位ID--gajsdwid--Integer--10-- */
	private Integer gajsdwid;

	/** @ --公安通知通报回复ID--gatztbhfid--Integer--10-- */
	private Integer gatztbhfid;

	/** @ --回复时间--hfsj--Date---- */
	private Date hfsj;

	/** @ --回复内容--hfnr--String--2000-- */
	private String hfnr;

	/** @ --回复人--hfr--String--100-- */
	private String hfr;

	/** 分页排序 */
	private String pageSort;

	/** @ 公安通报ID(gatbid) */
	public Integer getGatbid() {
		return gatbid;
	}

	public void setGatbid(Integer gatbid) {
		this.gatbid = gatbid;
	}

	/** @ 公安接收单位ID(gajsdwid) */
	public Integer getGajsdwid() {
		return gajsdwid;
	}

	public void setGajsdwid(Integer gajsdwid) {
		this.gajsdwid = gajsdwid;
	}

	/** @ 公安通知通报回复ID(gatztbhfid) */
	public Integer getGatztbhfid() {
		return gatztbhfid;
	}

	public void setGatztbhfid(Integer gatztbhfid) {
		this.gatztbhfid = gatztbhfid;
	}

	/** @ 回复时间(hfsj) */
	public Date getHfsj() {
		return hfsj;
	}

	public void setHfsj(Date hfsj) {
		this.hfsj = hfsj;
	}

	/** @ 回复内容(hfnr) */
	public String getHfnr() {
		return hfnr;
	}

	public void setHfnr(String hfnr) {
		this.hfnr = hfnr;
	}

	/** @ 回复人(hfr) */
	public String getHfr() {
		return hfr;
	}

	public void setHfr(String hfr) {
		this.hfr = hfr;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
