package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Wbjkczrzmx  {

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) */

	/** @ --操作日志id--czrzid--Integer--10-- */
	private Integer czrzid;

	/** @ --明细id--mxid--Integer--10-- */
	private Integer mxid;

	/** @ --操作结果类型--czjglx--String--10-- */
	private String czjglx;

	/** @ --失败原因--sbyy--String--100-- */
	private String sbyy;

	/** @ --第几条--djt--Integer--10-- */
	private Integer djt;

	/** @ --名称--mc--String--30-- */
	private String mc;

	/** 分页排序 */
	private String pageSort;

	/** @ 操作日志id(czrzid) */
	public Integer getCzrzid() {
		return czrzid;
	}

	public void setCzrzid(Integer czrzid) {
		this.czrzid = czrzid;
	}

	/** @ 明细id(mxid) */
	public Integer getMxid() {
		return mxid;
	}

	public void setMxid(Integer mxid) {
		this.mxid = mxid;
	}

	/** @ 操作结果类型(czjglx) */
	public String getCzjglx() {
		return czjglx;
	}

	public void setCzjglx(String czjglx) {
		this.czjglx = czjglx;
	}

	/** @ 失败原因(sbyy) */
	public String getSbyy() {
		return sbyy;
	}

	public void setSbyy(String sbyy) {
		this.sbyy = sbyy;
	}

	/** @ 第几条(djt) */
	public Integer getDjt() {
		return djt;
	}

	public void setDjt(Integer djt) {
		this.djt = djt;
	}

	/** @ 名称(mc) */
	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
