package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Dxbj  {

	/** @param 短信报警(t_dxbj) */

	/** @ --报警规则ID--bjgzid--Integer--10-- */
	private Integer bjgzid;

	/** @ --报警信息ID--bjxxid--Integer--10-- */
	private Integer bjxxid;

	/** @ --短信报警ID--dxbjid--Integer--10-- */
	private Integer dxbjid;

	/** @ --短信号码--dxhm--String--20-- */
	private String dxhm;

	/** @ --第一次发送时间--dycfssj--Date---- */
	private Date dycfssj;

	/** @ --最后一次发送时间--zhycfssj--Date---- */
	private Date zhycfssj;

	/** @ --发送次数--fscs--Integer--6-- */
	private Integer fscs;

	/** @ --短信状态--dxzt--String--2-- */
	private String dxzt;

	/** @ --短信内容--dxnr--String--300-- */
	private String dxnr;

	/** 分页排序 */
	private String pageSort;

	/** @ 报警规则ID(bjgzid) */
	public Integer getBjgzid() {
		return bjgzid;
	}

	public void setBjgzid(Integer bjgzid) {
		this.bjgzid = bjgzid;
	}

	/** @ 报警信息ID(bjxxid) */
	public Integer getBjxxid() {
		return bjxxid;
	}

	public void setBjxxid(Integer bjxxid) {
		this.bjxxid = bjxxid;
	}

	/** @ 短信报警ID(dxbjid) */
	public Integer getDxbjid() {
		return dxbjid;
	}

	public void setDxbjid(Integer dxbjid) {
		this.dxbjid = dxbjid;
	}

	/** @ 短信号码(dxhm) */
	public String getDxhm() {
		return dxhm;
	}

	public void setDxhm(String dxhm) {
		this.dxhm = dxhm;
	}

	/** @ 第一次发送时间(dycfssj) */
	public Date getDycfssj() {
		return dycfssj;
	}

	public void setDycfssj(Date dycfssj) {
		this.dycfssj = dycfssj;
	}

	/** @ 最后一次发送时间(zhycfssj) */
	public Date getZhycfssj() {
		return zhycfssj;
	}

	public void setZhycfssj(Date zhycfssj) {
		this.zhycfssj = zhycfssj;
	}

	/** @ 发送次数(fscs) */
	public Integer getFscs() {
		return fscs;
	}

	public void setFscs(Integer fscs) {
		this.fscs = fscs;
	}

	/** @ 短信状态(dxzt) */
	public String getDxzt() {
		return dxzt;
	}

	public void setDxzt(String dxzt) {
		this.dxzt = dxzt;
	}

	/** @ 短信内容(dxnr) */
	public String getDxnr() {
		return dxnr;
	}

	public void setDxnr(String dxnr) {
		this.dxnr = dxnr;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
