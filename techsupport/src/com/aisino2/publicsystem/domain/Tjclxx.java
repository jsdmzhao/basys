package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Tjclxx  {

	/** @param 提交材料信息(t_tjclxx) */

	/** @ --提交材料信息ID--tjclxxid--Integer--10-- */
	private Integer tjclxxid;

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --企业备案信息ID--qybaxxid--Integer--10-- */
	private Integer qybaxxid;

	/** @ --提交材料类型代码--tjcllxdm--String--2-- */
	private String tjcllxdm;

	/** @ --提交材料类型--tjcllx--String--100-- */
	private String tjcllx;

	/** @ --提交日期--tijiaorq--Date---- */
	private Date tijiaorq;

	/** @ --提交人姓名--tjrxm--String--100-- */
	private String tjrxm;

	/** @ --提交材料内容--tjclnr--byte[]---- */
	private byte[] tjclnr;

	/** 分页排序 */
	private String pageSort;

	/** @ 提交材料信息ID(tjclxxid) */
	public Integer getTjclxxid() {
		return tjclxxid;
	}

	public void setTjclxxid(Integer tjclxxid) {
		this.tjclxxid = tjclxxid;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 企业备案信息ID(qybaxxid) */
	public Integer getQybaxxid() {
		return qybaxxid;
	}

	public void setQybaxxid(Integer qybaxxid) {
		this.qybaxxid = qybaxxid;
	}

	/** @ 提交材料类型代码(tjcllxdm) */
	public String getTjcllxdm() {
		return tjcllxdm;
	}

	public void setTjcllxdm(String tjcllxdm) {
		this.tjcllxdm = tjcllxdm;
	}

	/** @ 提交材料类型(tjcllx) */
	public String getTjcllx() {
		return tjcllx;
	}

	public void setTjcllx(String tjcllx) {
		this.tjcllx = tjcllx;
	}

	/** @ 提交日期(tijiaorq) */
	public Date getTijiaorq() {
		return tijiaorq;
	}

	public void setTijiaorq(Date tijiaorq) {
		this.tijiaorq = tijiaorq;
	}

	/** @ 提交人姓名(tjrxm) */
	public String getTjrxm() {
		return tjrxm;
	}

	public void setTjrxm(String tjrxm) {
		this.tjrxm = tjrxm;
	}

	/** @ 提交材料内容(tjclnr) */
	public byte[] getTjclnr() {
		return tjclnr;
	}

	public void setTjclnr(byte[] tjclnr) {
		this.tjclnr = tjclnr;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
