package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Icksl_lsb  {

	/** @param IC卡受理临时表(t_icksl_lsb) */

	/** @ --原IC卡芯片号--ickhold--String--100-- */
	private String ickhold;

	/** @ --现IC卡芯片号--ickhnew--String--100-- */
	private String ickhnew;

	/** @ --录入时间--lrsj--Date---- */
	private Date lrsj;

	/** @ --处理时间--clsj--Date---- */
	private Date clsj;

	/** @ --处理标识--clbz--Integer--2-- */
	private Integer clbz;

	/** 分页排序 */
	private String pageSort;

	/** @ 原IC卡芯片号(ickhold) */
	public String getIckhold() {
		return ickhold;
	}

	public void setIckhold(String ickhold) {
		this.ickhold = ickhold;
	}

	/** @ 现IC卡芯片号(ickhnew) */
	public String getIckhnew() {
		return ickhnew;
	}

	public void setIckhnew(String ickhnew) {
		this.ickhnew = ickhnew;
	}

	/** @ 录入时间(lrsj) */
	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	/** @ 处理时间(clsj) */
	public Date getClsj() {
		return clsj;
	}

	public void setClsj(Date clsj) {
		this.clsj = clsj;
	}

	/** @ 处理标识(clbz) */
	public Integer getClbz() {
		return clbz;
	}

	public void setClbz(Integer clbz) {
		this.clbz = clbz;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
