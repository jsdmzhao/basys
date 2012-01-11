package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Ickrzjl  {

	/** @param IC卡日志记录(t_ickrzjl) */

	/** @ --日志编号--rzbh--Integer--10-- */
	private Integer rzbh;

	/** @ --批次号--pch--String--20-- */
	private String pch;

	/** @ --关联编号--glbh--String--20-- */
	private String glbh;

	/** @ --从业人员编号--cyrybh--String--30-- */
	private String cyrybh;

	/** @ --操作类别--czlb--String--40-- */
	private String czlb;

	/** @ --操作原因--czyy--String--200-- */
	private String czyy;

	/** @ --操作人--czr--String--30-- */
	private String czr;

	/** @ --操作时间--czsj--Date---- */
	private Date czsj;

	/** 分页排序 */
	private String pageSort;
	/** @ --姓名-- */
	private String xm;
	
	/** @ --行业类别代码--*/
	private String hylbdm;
	
	/** @ --行业类别--*/
	private String hylb;

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	/** @ 日志编号(rzbh) */
	public Integer getRzbh() {
		return rzbh;
	}

	public void setRzbh(Integer rzbh) {
		this.rzbh = rzbh;
	}

	/** @ 批次号(pch) */
	public String getPch() {
		return pch;
	}

	public void setPch(String pch) {
		this.pch = pch;
	}

	/** @ 关联编号(glbh) */
	public String getGlbh() {
		return glbh;
	}

	public void setGlbh(String glbh) {
		this.glbh = glbh;
	}

	/** @ 从业人员编号(cyrybh) */
	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	/** @ 操作类别(czlb) */
	public String getCzlb() {
		return czlb;
	}

	public void setCzlb(String czlb) {
		this.czlb = czlb;
	}

	/** @ 操作原因(czyy) */
	public String getCzyy() {
		return czyy;
	}

	public void setCzyy(String czyy) {
		this.czyy = czyy;
	}

	/** @ 操作人(czr) */
	public String getCzr() {
		return czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	/** @ 操作时间(czsj) */
	public Date getCzsj() {
		return czsj;
	}

	public void setCzsj(Date czsj) {
		this.czsj = czsj;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}
}
