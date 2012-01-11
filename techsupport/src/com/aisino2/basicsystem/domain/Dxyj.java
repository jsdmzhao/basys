package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Dxyj  {

	/** @param 短信预警(t_dxyj) */

	/** @ --预警规则ID--yjgzid--Integer--10-- */
	private Integer yjgzid;

	/** @ --预警信息ID--yjxxid--Integer--10-- */
	private Integer yjxxid;

	/** @ --短信预警ID--dxyjid--Integer--10-- */
	private Integer dxyjid;

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

	/** @ 预警规则ID(yjgzid) */
	public Integer getYjgzid() {
		return yjgzid;
	}

	public void setYjgzid(Integer yjgzid) {
		this.yjgzid = yjgzid;
	}

	/** @ 预警信息ID(yjxxid) */
	public Integer getYjxxid() {
		return yjxxid;
	}

	public void setYjxxid(Integer yjxxid) {
		this.yjxxid = yjxxid;
	}

	/** @ 短信预警ID(dxyjid) */
	public Integer getDxyjid() {
		return dxyjid;
	}

	public void setDxyjid(Integer dxyjid) {
		this.dxyjid = dxyjid;
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
