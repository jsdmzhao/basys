package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Zdycxtj  {

	/** @param 自定义查询条件(t_zdycxtj) */

	/** @ --自定义查询条件ID--zdycxtjid--Integer--10-- */
	private Integer zdycxtjid;

	/** @ --高级查询方案ID--gjcxfaid--Integer--10-- */
	private Integer gjcxfaid;

	/** @ --查询条件--cxtj--String--2000-- */
	private String cxtj;

	/** @ --查询排序--cxpx--String--2000-- */
	private String cxpx;

	/** 分页排序 */
	private String pageSort;

	/** @ 自定义查询条件ID(zdycxtjid) */
	public Integer getZdycxtjid() {
		return zdycxtjid;
	}

	public void setZdycxtjid(Integer zdycxtjid) {
		this.zdycxtjid = zdycxtjid;
	}

	/** @ 高级查询方案ID(gjcxfaid) */
	public Integer getGjcxfaid() {
		return gjcxfaid;
	}

	public void setGjcxfaid(Integer gjcxfaid) {
		this.gjcxfaid = gjcxfaid;
	}

	/** @ 查询条件(cxtj) */
	public String getCxtj() {
		return cxtj;
	}

	public void setCxtj(String cxtj) {
		this.cxtj = cxtj;
	}

	/** @ 查询排序(cxpx) */
	public String getCxpx() {
		return cxpx;
	}

	public void setCxpx(String cxpx) {
		this.cxpx = cxpx;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
