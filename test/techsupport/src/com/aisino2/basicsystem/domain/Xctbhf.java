package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Xctbhf  {

	/** @param 协查通报回复(t_xctbhf) */

	/** @ --通报ID--tbid--Integer--10-- */
	private Integer tbid;

	/** @ --接收单位ID--jsdwid--Integer--10-- */
	private Integer jsdwid;

	/** @ --回复ID--hfid--Integer--10-- */
	private Integer hfid;

	/** @ --回复时间--hfsj--Date---- */
	private Date hfsj;

	/** @ --回复内容--hfnr--String--2000-- */
	private String hfnr;

	/** @ --回复人--hfr--String--100-- */
	private String hfr;
	
	////接受单位名称
	private String jsdwmc;

	/** 分页排序 */
	private String pageSort;

	/** @ 通报ID(tbid) */
	public Integer getTbid() {
		return tbid;
	}

	public void setTbid(Integer tbid) {
		this.tbid = tbid;
	}

	/** @ 接收单位ID(jsdwid) */
	public Integer getJsdwid() {
		return jsdwid;
	}

	public void setJsdwid(Integer jsdwid) {
		this.jsdwid = jsdwid;
	}

	/** @ 回复ID(hfid) */
	public Integer getHfid() {
		return hfid;
	}

	public void setHfid(Integer hfid) {
		this.hfid = hfid;
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

	public String getJsdwmc() {
		return jsdwmc;
	}

	public void setJsdwmc(String jsdwmc) {
		this.jsdwmc = jsdwmc;
	}
}
