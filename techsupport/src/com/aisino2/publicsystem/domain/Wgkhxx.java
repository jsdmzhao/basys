package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Wgkhxx  {

	/** @param 外国客户信息(t_wgkhxx) */

	/** @ --客户信息ID--khxxid--Integer--10-- */
	private Integer khxxid;

	/** @ --英文姓--ywx--String--60-- */
	private String ywx;

	/** @ --英文名--ywm--String--60-- */
	private String ywm;

	/** @ --签证种类代码--qzzldm--String--40-- */
	private String qzzldm;

	/** @ --签证种类--qzzl--String--100-- */
	private String qzzl;

	/** @ --签证号码--qzhm--String--20-- */
	private String qzhm;

	/** @ --在华停留期至--zatlq--Date---- */
	private Date zatlq;

	/** @ --签发机关--qfjg--String--120-- */
	private String qfjg;

	/** @ --入境日期--rjrq--Date---- */
	private Date rjrq;

	/** @ --入境口岸--rjka--String--60-- */
	private String rjka;

	/** 分页排序 */
	private String pageSort;

	/** @ 客户信息ID(khxxid) */
	public Integer getKhxxid() {
		return khxxid;
	}

	public void setKhxxid(Integer khxxid) {
		this.khxxid = khxxid;
	}

	/** @ 英文姓(ywx) */
	public String getYwx() {
		return ywx;
	}

	public void setYwx(String ywx) {
		this.ywx = ywx;
	}

	/** @ 英文名(ywm) */
	public String getYwm() {
		return ywm;
	}

	public void setYwm(String ywm) {
		this.ywm = ywm;
	}

	/** @ 签证种类代码(qzzldm) */
	public String getQzzldm() {
		return qzzldm;
	}

	public void setQzzldm(String qzzldm) {
		this.qzzldm = qzzldm;
	}

	/** @ 签证种类(qzzl) */
	public String getQzzl() {
		return qzzl;
	}

	public void setQzzl(String qzzl) {
		this.qzzl = qzzl;
	}

	/** @ 签证号码(qzhm) */
	public String getQzhm() {
		return qzhm;
	}

	public void setQzhm(String qzhm) {
		this.qzhm = qzhm;
	}

	/** @ 在华停留期至(zatlq) */
	public Date getZatlq() {
		return zatlq;
	}

	public void setZatlq(Date zatlq) {
		this.zatlq = zatlq;
	}

	/** @ 签发机关(qfjg) */
	public String getQfjg() {
		return qfjg;
	}

	public void setQfjg(String qfjg) {
		this.qfjg = qfjg;
	}

	/** @ 入境日期(rjrq) */
	public Date getRjrq() {
		return rjrq;
	}

	public void setRjrq(Date rjrq) {
		this.rjrq = rjrq;
	}

	/** @ 入境口岸(rjka) */
	public String getRjka() {
		return rjka;
	}

	public void setRjka(String rjka) {
		this.rjka = rjka;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
