package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Garkktbsj  {

	/** @param 公安人口库同步数据(t_garkktbsj) */

	/** @ --公安人口库同步数据ID--garkktbsjid--Integer--10-- */
	private Integer garkktbsjid;

	/** @ --公民身份证号码--gmsfzhm--String--20-- */
	private String gmsfzhm;

	/** @ --姓名--xm--String--100-- */
	private String xm;

	/** @ --性别--xb--String--2-- */
	private String xb;

	/** @ --民族--mz--String--30-- */
	private String mz;

	/** @ --婚姻状况--hyzk--String--4-- */
	private String hyzk;

	/** @ --户籍省县--hjsx--String--20-- */
	private String hjsx;

	/** @ --户籍地详址--hjdxz--String--200-- */
	private String hjdxz;

	/** @ --出生日期--csrq--Date---- */
	private Date csrq;

	/** @ --照片--zp--byte[]---- */
	private byte[] zp;

	/** 分页排序 */
	private String pageSort;

	/** @ 公安人口库同步数据ID(garkktbsjid) */
	public Integer getGarkktbsjid() {
		return garkktbsjid;
	}

	public void setGarkktbsjid(Integer garkktbsjid) {
		this.garkktbsjid = garkktbsjid;
	}

	/** @ 公民身份证号码(gmsfzhm) */
	public String getGmsfzhm() {
		return gmsfzhm;
	}

	public void setGmsfzhm(String gmsfzhm) {
		this.gmsfzhm = gmsfzhm;
	}

	/** @ 姓名(xm) */
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	/** @ 性别(xb) */
	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	/** @ 民族(mz) */
	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	/** @ 婚姻状况(hyzk) */
	public String getHyzk() {
		return hyzk;
	}

	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}

	/** @ 户籍省县(hjsx) */
	public String getHjsx() {
		return hjsx;
	}

	public void setHjsx(String hjsx) {
		this.hjsx = hjsx;
	}

	/** @ 户籍地详址(hjdxz) */
	public String getHjdxz() {
		return hjdxz;
	}

	public void setHjdxz(String hjdxz) {
		this.hjdxz = hjdxz;
	}

	/** @ 出生日期(csrq) */
	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	/** @ 照片(zp) */
	public byte[] getZp() {
		return zp;
	}

	public void setZp(byte[] zp) {
		this.zp = zp;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
