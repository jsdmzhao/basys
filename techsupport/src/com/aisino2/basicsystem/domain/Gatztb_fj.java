package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Gatztb_fj  {

	/** @param 公安通知通报_附件(t_gatztb_fj) */

	/** @ --公安通报ID--gatbid--Integer--10-- */
	private Integer gatbid;

	/** @ --公安附件ID--gafjid--Integer--10-- */
	private Integer gafjid;

	/** @ --附件名称--fjmc--String--100-- */
	private String fjmc;

	/** @ --附件类型--fjlx--String--60-- */
	private String fjlx;

	/** @ --附件内容--fjnr--byte[]---- */
	private byte[] fjnr;

	/** @ --附件序号--fjxh--Integer--10-- */
	private Integer fjxh;
	private String fjbase;
	private String oprflag;

	/** 分页排序 */
	private String pageSort;

	/** @ 公安通报ID(gatbid) */
	public Integer getGatbid() {
		return gatbid;
	}

	public void setGatbid(Integer gatbid) {
		this.gatbid = gatbid;
	}

	/** @ 公安附件ID(gafjid) */
	public Integer getGafjid() {
		return gafjid;
	}

	public void setGafjid(Integer gafjid) {
		this.gafjid = gafjid;
	}

	/** @ 附件名称(fjmc) */
	public String getFjmc() {
		return fjmc;
	}

	public void setFjmc(String fjmc) {
		this.fjmc = fjmc;
	}

	/** @ 附件类型(fjlx) */
	public String getFjlx() {
		return fjlx;
	}

	public void setFjlx(String fjlx) {
		this.fjlx = fjlx;
	}

	/** @ 附件内容(fjnr) */
	public byte[] getFjnr() {
		return fjnr;
	}

	public void setFjnr(byte[] fjnr) {
		this.fjnr = fjnr;
	}

	/** @ 附件序号(fjxh) */
	public Integer getFjxh() {
		return fjxh;
	}

	public void setFjxh(Integer fjxh) {
		this.fjxh = fjxh;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getFjbase() {
		return fjbase;
	}

	public void setFjbase(String fjbase) {
		this.fjbase = fjbase;
	}

	public String getOprflag() {
		return oprflag;
	}

	public void setOprflag(String oprflag) {
		this.oprflag = oprflag;
	}
}
