package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Ryxxczrz  {

	/** @param 人员信息操作日志(t_ryxxczrz) */

	/** @ --人员信息操作日志ID--ryxxczrzid--Integer--10-- */
	private Integer ryxxczrzid;

	/** @ --操作时间--czsj--Date---- */
	private Date czsj;

	/** @ --操作类型--czlx--String--40-- */
	private String czlx;

	/** @ --操作内容--cznr--String--2000-- */
	private String cznr;

	/** @ --操作人--czr--String--30-- */
	private String czr;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --从业人员编号--cyrybh--String--20-- */
	private String cyrybh;

	/** 分页排序 */
	private String pageSort;

	/** @ 人员信息操作日志ID(ryxxczrzid) */
	public Integer getRyxxczrzid() {
		return ryxxczrzid;
	}

	public void setRyxxczrzid(Integer ryxxczrzid) {
		this.ryxxczrzid = ryxxczrzid;
	}

	/** @ 操作时间(czsj) */
	public Date getCzsj() {
		return czsj;
	}

	public void setCzsj(Date czsj) {
		this.czsj = czsj;
	}

	/** @ 操作类型(czlx) */
	public String getCzlx() {
		return czlx;
	}

	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}

	/** @ 操作内容(cznr) */
	public String getCznr() {
		return cznr;
	}

	public void setCznr(String cznr) {
		this.cznr = cznr;
	}

	/** @ 操作人(czr) */
	public String getCzr() {
		return czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	/** @ 企业编码(qybm) */
	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}

	/** @ 从业人员编号(cyrybh) */
	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
