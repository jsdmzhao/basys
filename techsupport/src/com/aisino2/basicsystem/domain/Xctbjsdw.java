package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Xctbjsdw  {

	/** @param 协查通报接收单位(t_xctbjsdw) */

	/** @ --通报ID--tbid--Integer--10-- */
	private Integer tbid;

	/** @ --接收单位ID--jsdwid--Integer--10-- */
	private Integer jsdwid;

	/** @ --接收单位编码--jsdwbm--String--20-- */
	private String jsdwbm;

	/** @ --接收单位名称--jsdwmc--String--100-- */
	private String jsdwmc;

	/** @ --收取时间--sqsj--Date---- */
	private Date sqsj;
	
	////行业类型代码
	private String hylxdm;
	///行业类型
	private String hylx;
	
	///标题
	private String bt;
	
	/** @ --发布时间-- */
	private Date fbsj;
	
	/** @ --发布单位编码-- */
	private String fbdwbm;
	
	/** @ --发布单位-- */
	private String fbdw;

	/** 分页排序 */
	private String pageSort;
	
	private String gxdwbm;
	
	private String gxdwmc;
	
	public String getGxdwbm() {
	    return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
	    this.gxdwbm = gxdwbm;
	}

	public String getGxdwmc() {
	    return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
	    this.gxdwmc = gxdwmc;
	}

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

	/** @ 接收单位编码(jsdwbm) */
	public String getJsdwbm() {
		return jsdwbm;
	}

	public void setJsdwbm(String jsdwbm) {
		this.jsdwbm = jsdwbm;
	}

	/** @ 接收单位名称(jsdwmc) */
	public String getJsdwmc() {
		return jsdwmc;
	}

	public void setJsdwmc(String jsdwmc) {
		this.jsdwmc = jsdwmc;
	}

	/** @ 收取时间(sqsj) */
	public Date getSqsj() {
		return sqsj;
	}

	public void setSqsj(Date sqsj) {
		this.sqsj = sqsj;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getHylxdm() {
		return hylxdm;
	}

	public void setHylxdm(String hylxdm) {
		this.hylxdm = hylxdm;
	}

	public String getHylx() {
		return hylx;
	}

	public void setHylx(String hylx) {
		this.hylx = hylx;
	}

	public String getBt() {
		return bt;
	}

	public void setBt(String bt) {
		this.bt = bt;
	}

	public Date getFbsj() {
		return fbsj;
	}

	public void setFbsj(Date fbsj) {
		this.fbsj = fbsj;
	}

	public String getFbdwbm() {
		return fbdwbm;
	}

	public void setFbdwbm(String fbdwbm) {
		this.fbdwbm = fbdwbm;
	}

	public String getFbdw() {
		return fbdw;
	}

	public void setFbdw(String fbdw) {
		this.fbdw = fbdw;
	}
}
