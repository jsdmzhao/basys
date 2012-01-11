package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Asjgl  {

	/** @param 案事件管理(t_asjgl) */

	/** @ --案事件管理ID--asjglid--Integer--10-- */
	private Integer asjglid;

	/** @ --行业类别--hylb--String--100-- */
	private String hylb;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --企业名称--qymc--String--200-- */
	private String qymc;

	/** @ --案件编号--ajbh--String--60-- */
	private String ajbh;

	/** @ --案件性质--ajxz--String--60-- */
	private String ajxz;

	/** @ --案件类别--ajlb--String--60-- */
	private String ajlb;

	/** @ --发案时间--fasj--Date---- */
	private Date fasj;

	/** @ --发案地点--fadd--String--300-- */
	private String fadd;

	/** @ --情况描述--qkms--String--2000-- */
	private String qkms;

	/** @ --所属单位编码--ssdwbm--String--20-- */
	private String ssdwbm;

	/** @ --所属单位名称--ssdwmc--String--100-- */
	private String ssdwmc;
	
	/** @ --所属单位层级--ssdwlevel--String--100-- */
	private Integer ssdwlevel;

	/** @ --企业涉案类型--qysalx--String--60-- */
	private String qysalx;

	/** @ --登记人--djr--String--30-- */
	private String djr;

	/** @ --登记单位编码--djdwbm--String--60-- */
	private String djdwbm;

	/** @ --登记单位名称--djdwmc--String--100-- */
	private String djdwmc;

	/** @ --登记时间--djsj--Date---- */
	private Date djsj;

	/** @  */
	private String hylbdm;
	
	/** @  */
	private String ajxzdm;
	
	/** @  */
	private String ajlbdm;
	
	/** @  */
	private String ajly;
	
	/** @  */
	private String ajlydm;
	
	
	/** @  */
	private String ladw;
	
	/** @  */
	private String ladwbm;
	
	/** @  */
	private String qyzr;
	
	/** @  */
	private String qyzrdm;
	
	/** @  */
	private String qyryjs;
	
	/** @  */
	private String qyryjsdm;
	
	
	/** @ ---立案日期---- */
	private Date larq;
	
	
	/** @ ---djsj--Date---- */
	private Date parq;
	
	/** @ --发案时间至---- */
	private Date fasj2;

	/** @ --年份---- */
	private String nianfen;
	
	/** @ --月份---- */
	private String yuefen;
	
	/** @ --登记时间至---- */
	private Date djsj2;
	/** @ --导出标识--dcbs--Integer--2-- */
	private Integer dcbs;
	
	/** 分页排序 */
	private String pageSort;

	public Date getDjsj2() {
		return djsj2;
	}

	public void setDjsj2(Date djsj2) {
		this.djsj2 = djsj2;
	}

	public String getNianfen() {
		return nianfen;
	}

	public void setNianfen(String nianfen) {
		this.nianfen = nianfen;
	}

	public String getYuefen() {
		return yuefen;
	}

	public void setYuefen(String yuefen) {
		this.yuefen = yuefen;
	}

	/** @ 案事件管理ID(asjglid) */
	public Integer getAsjglid() {
		return asjglid;
	}

	public void setAsjglid(Integer asjglid) {
		this.asjglid = asjglid;
	}

	/** @ 行业类别(hylb) */
	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	/** @ 企业编码(qybm) */
	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		this.qybm = qybm;
	}

	/** @ 企业名称(qymc) */
	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	/** @ 案件编号(ajbh) */
	public String getAjbh() {
		return ajbh;
	}

	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
	}

	/** @ 案件性质(ajxz) */
	public String getAjxz() {
		return ajxz;
	}

	public void setAjxz(String ajxz) {
		this.ajxz = ajxz;
	}

	/** @ 案件类别(ajlb) */
	public String getAjlb() {
		return ajlb;
	}

	public void setAjlb(String ajlb) {
		this.ajlb = ajlb;
	}

	/** @ 发案时间(fasj) */
	public Date getFasj() {
		return fasj;
	}

	public void setFasj(Date fasj) {
		this.fasj = fasj;
	}

	/** @ 发案地点(fadd) */
	public String getFadd() {
		return fadd;
	}

	public void setFadd(String fadd) {
		this.fadd = fadd;
	}

	/** @ 情况描述(qkms) */
	public String getQkms() {
		return qkms;
	}

	public void setQkms(String qkms) {
		this.qkms = qkms;
	}

	/** @ 所属单位编码(ssdwbm) */
	public String getSsdwbm() {
		return ssdwbm;
	}

	public void setSsdwbm(String ssdwbm) {
		this.ssdwbm = ssdwbm;
	}

	/** @ 所属单位名称(ssdwmc) */
	public String getSsdwmc() {
		return ssdwmc;
	}

	public void setSsdwmc(String ssdwmc) {
		this.ssdwmc = ssdwmc;
	}
	
	/** @ 所属单位层级(ssdwlevel) */
	public Integer getSsdwlevel() {
		return ssdwlevel;
	}

	public void setSsdwlevel(Integer ssdwlevel) {
		this.ssdwlevel = ssdwlevel;
	}

	/** @ 企业涉案类型(qysalx) */
	public String getQysalx() {
		return qysalx;
	}

	public void setQysalx(String qysalx) {
		this.qysalx = qysalx;
	}

	/** @ 登记人(djr) */
	public String getDjr() {
		return djr;
	}

	public void setDjr(String djr) {
		this.djr = djr;
	}

	/** @ 登记单位编码(djdwbm) */
	public String getDjdwbm() {
		return djdwbm;
	}

	public void setDjdwbm(String djdwbm) {
		this.djdwbm = djdwbm;
	}

	/** @ 登记单位名称(djdwmc) */
	public String getDjdwmc() {
		return djdwmc;
	}

	public void setDjdwmc(String djdwmc) {
		this.djdwmc = djdwmc;
	}

	/** @ 登记时间(djsj) */
	public Date getDjsj() {
		return djsj;
	}

	public void setDjsj(Date djsj) {
		this.djsj = djsj;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public String getAjxzdm() {
		return ajxzdm;
	}

	public void setAjxzdm(String ajxzdm) {
		this.ajxzdm = ajxzdm;
	}

	public String getAjlbdm() {
		return ajlbdm;
	}

	public void setAjlbdm(String ajlbdm) {
		this.ajlbdm = ajlbdm;
	}

	public Date getFasj2() {
		return fasj2;
	}

	public void setFasj2(Date fasj2) {
		this.fasj2 = fasj2;
	}

	public String getAjly() {
		return ajly;
	}

	public void setAjly(String ajly) {
		this.ajly = ajly;
	}

	public String getAjlydm() {
		return ajlydm;
	}

	public void setAjlydm(String ajlydm) {
		this.ajlydm = ajlydm;
	}

	public String getLadw() {
		return ladw;
	}

	public void setLadw(String ladw) {
		this.ladw = ladw;
	}

	public String getLadwbm() {
		return ladwbm;
	}

	public void setLadwbm(String ladwbm) {
		this.ladwbm = ladwbm;
	}

	public String getQyryjs() {
		return qyryjs;
	}

	public void setQyryjs(String qyryjs) {
		this.qyryjs = qyryjs;
	}

	public String getQyryjsdm() {
		return qyryjsdm;
	}

	public void setQyryjsdm(String qyryjsdm) {
		this.qyryjsdm = qyryjsdm;
	}

	public String getQyzr() {
		return qyzr;
	}

	public void setQyzr(String qyzr) {
		this.qyzr = qyzr;
	}

	public String getQyzrdm() {
		return qyzrdm;
	}

	public void setQyzrdm(String qyzrdm) {
		this.qyzrdm = qyzrdm;
	}

	public Date getLarq() {
		return larq;
	}

	public void setLarq(Date larq) {
		this.larq = larq;
	}

	public Date getParq() {
		return parq;
	}

	public void setParq(Date parq) {
		this.parq = parq;
	}

	public Integer getDcbs() {
		return dcbs;
	}

	public void setDcbs(Integer dcbs) {
		this.dcbs = dcbs;
	}

	
}
