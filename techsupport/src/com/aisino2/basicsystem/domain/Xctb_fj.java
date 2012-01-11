package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Xctb_fj  {

	/** @param 协查通报_附件(t_xctb_fj) */

	/** @ --通报ID--tbid--Integer--10-- */
	private Integer tbid;

	/** @ --附件ID--fjid--Integer--10-- */
	private Integer fjid;

	/** @ --附件名称--fjmc--String--100-- */
	private String fjmc;

	/** @ --附件类型--fjlx--String--60-- */
	private String fjlx;

	/** @ --附件内容--fjnr--byte[]---- */
	private byte[] fjnr;

	/** @ --附件序号--fjxh--Integer--10-- */
	private Integer fjxh;
	
	////附件的base64编码
	private String fjbase;
	
	//操作标准变量
	private String oprflag;

	/** 分页排序 */
	private String pageSort;

	/** @ 通报ID(tbid) */
	public Integer getTbid() {
		return tbid;
	}

	public void setTbid(Integer tbid) {
		this.tbid = tbid;
	}

	/** @ 附件ID(fjid) */
	public Integer getFjid() {
		return fjid;
	}

	public void setFjid(Integer fjid) {
		this.fjid = fjid;
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

	public String getOprflag() {
		return oprflag;
	}

	public void setOprflag(String oprflag) {
		this.oprflag = oprflag;
	}

	public String getFjbase() {
		return fjbase;
	}

	public void setFjbase(String fjbase) {
		this.fjbase = fjbase;
	}
}
