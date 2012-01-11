package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Gatztbjsdw  {

	/** @param 公安通知通报接收单位(t_gatztbjsdw) */

	/** @ --公安通报ID--gatbid--Integer--10-- */
	private Integer gatbid;

	/** @ --公安接收单位ID--gajsdwid--Integer--10-- */
	private Integer gajsdwid;

	/** @ --接收单位编码--jsdwbm--String--20-- */
	private String jsdwbm;

	/** @ --接收单位名称--jsdwmc--String--100-- */
	private String jsdwmc;

	/** @ --收取时间--sqsj--Date---- */
	private Date sqsj;

	/** @ --行业类型代码--hylxdm--String--4-- */
	private String hylxdm;

	/** @ --行业类型--hylx--String--40-- */
	private String hylx;

	/** @ --收取IP--sqip--String--20-- */
	private String sqip;
	private String sjListflg;
	private String qsr;//签收人
	private String qsyj;//签收意见
	/** 分页排序 */
	private String pageSort;

	/** @ 公安通报ID(gatbid) */
	public Integer getGatbid() {
		return gatbid;
	}

	public void setGatbid(Integer gatbid) {
		this.gatbid = gatbid;
	}

	/** @ 公安接收单位ID(gajsdwid) */
	public Integer getGajsdwid() {
		return gajsdwid;
	}

	public void setGajsdwid(Integer gajsdwid) {
		this.gajsdwid = gajsdwid;
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

	/** @ 行业类型代码(hylxdm) */
	public String getHylxdm() {
		return hylxdm;
	}

	public void setHylxdm(String hylxdm) {
		this.hylxdm = hylxdm;
	}

	/** @ 行业类型(hylx) */
	public String getHylx() {
		return hylx;
	}

	public void setHylx(String hylx) {
		this.hylx = hylx;
	}

	/** @ 收取IP(sqip) */
	public String getSqip() {
		return sqip;
	}

	public void setSqip(String sqip) {
		this.sqip = sqip;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getSjListflg() {
		return sjListflg;
	}

	public void setSjListflg(String sjListflg) {
		this.sjListflg = sjListflg;
	}

	public String getQsr() {
		return qsr;
	}

	public void setQsr(String qsr) {
		this.qsr = qsr;
	}

	public String getQsyj() {
		return qsyj;
	}

	public void setQsyj(String qsyj) {
		this.qsyj = qsyj;
	}
}
