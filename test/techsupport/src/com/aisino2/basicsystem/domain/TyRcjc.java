package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class TyRcjc  {

	/** @param 日常检查(T_TYRCJC) */

	/** @ --日常检查ID--rcjcid--Integer--10-- */
	private Integer rcjcid;
	
	/** @ --企业编码--qybm--String--30-- */
	private String qybm;

	/** @ --企业名称--qymc--String--100-- */
	private String qymc;

	/** @ --检查人姓名--jcrxm--String--30-- */
	private String jcrxm;

	/** @ --检查人职务--jcrzw--String--100-- */
	private String jcrzw;

	/** @ --隶属单位--lsdw--String--100-- */
	private String lsdw;

	/** @ --检查日期--jcrq--Date---- */
	private Date jcrq;

	/** @ --检查事项--jcsx--String--300-- */
	private String jcsx;

	/** @ --发现问题--fxwt--String--300-- */
	private String fxwt;

	/** @ --处理结果--cljg--String--2000-- */
	private String cljg;

	/** @ --企业负责人--qyfzr--String--30-- */
	private String qyfzr;

	/** @ --是否知道检查结果--sfzdjcjg--String--2-- */
	private String sfzdjcjg;

	/** @ --备注--bz--String--2000-- */
	private String bz;

	/** @ --检查方式--jcfs--String--20-- */
	private String jcfs;

	/** @ --日常检查编号--rcjcbh--String--30-- */
	private String rcjcbh;

	/** @ --检查机构代码--jcjgdm--String--20-- */
	private String jcjgdm;

	/** @ --检查机构名称--jcjgmc--String--100-- */
	private String jcjgmc;

	/** @ --检查人员编号--jcrybh--String--20-- */
	private String jcrybh;

	/** @ --职务代码--zwdm--String--4-- */
	private String zwdm;
	
	/** @ --管辖单位编码--gxdwbm--String--30-- */
	private String gxdwbm;
	
	/** @ --管辖单位名称--gxdwmc--String--100-- */
	private String gxdwmc;

	/** @ --行业类别代码--HYLBDM--String--4-- */
	private String hylbdm;

	/** @ --行业类别代码--HYLB--String--30-- */
	private String hylb;

	/** 分页排序 */
	private String pageSort;

	/** @ --所属省份*/
	private String sssf;
	
	/** @ --检查日期(查询)*/
	private Date jcrqf;

	/** @ --检查日期至(查询) */
	private Date jcrqt;
	
	/** @ --检查方式显示值 */
	private String jcfsDisName;
	

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

	public Integer getRcjcid() {
		return rcjcid;
	}

	public void setRcjcid(Integer rcjcid) {
		this.rcjcid = rcjcid;
	}

	public String getJcrxm() {
		return jcrxm;
	}

	public void setJcrxm(String jcrxm) {
		this.jcrxm = jcrxm;
	}

	public String getJcrzw() {
		return jcrzw;
	}

	public void setJcrzw(String jcrzw) {
		this.jcrzw = jcrzw;
	}

	public String getLsdw() {
		return lsdw;
	}

	public void setLsdw(String lsdw) {
		this.lsdw = lsdw;
	}

	public Date getJcrq() {
		return jcrq;
	}

	public void setJcrq(Date jcrq) {
		this.jcrq = jcrq;
	}

	public String getJcsx() {
		return jcsx;
	}

	public void setJcsx(String jcsx) {
		this.jcsx = jcsx;
	}

	public String getFxwt() {
		return fxwt;
	}

	public void setFxwt(String fxwt) {
		this.fxwt = fxwt;
	}

	public String getCljg() {
		return cljg;
	}

	public void setCljg(String cljg) {
		this.cljg = cljg;
	}

	public String getQyfzr() {
		return qyfzr;
	}

	public void setQyfzr(String qyfzr) {
		this.qyfzr = qyfzr;
	}

	public String getSfzdjcjg() {
		return sfzdjcjg;
	}

	public void setSfzdjcjg(String sfzdjcjg) {
		this.sfzdjcjg = sfzdjcjg;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getJcfs() {
		return jcfs;
	}

	public void setJcfs(String jcfs) {
		this.jcfs = jcfs;
	}

	public String getRcjcbh() {
		return rcjcbh;
	}

	public void setRcjcbh(String rcjcbh) {
		this.rcjcbh = rcjcbh;
	}

	public String getJcjgdm() {
		return jcjgdm;
	}

	public void setJcjgdm(String jcjgdm) {
		this.jcjgdm = jcjgdm;
	}

	public String getJcjgmc() {
		return jcjgmc;
	}

	public void setJcjgmc(String jcjgmc) {
		this.jcjgmc = jcjgmc;
	}

	public String getJcrybh() {
		return jcrybh;
	}

	public void setJcrybh(String jcrybh) {
		this.jcrybh = jcrybh;
	}

	public String getZwdm() {
		return zwdm;
	}

	public void setZwdm(String zwdm) {
		this.zwdm = zwdm;
	}

	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getSssf() {
		return sssf;
	}

	public void setSssf(String sssf) {
		this.sssf = sssf;
	}

	public Date getJcrqf() {
		return jcrqf;
	}

	public void setJcrqf(Date jcrqf) {
		this.jcrqf = jcrqf;
	}

	public Date getJcrqt() {
		return jcrqt;
	}

	public void setJcrqt(Date jcrqt) {
		this.jcrqt = jcrqt;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		this.qybm = qybm;
	}

	public String getJcfsDisName() {
		return jcfsDisName;
	}

	public void setJcfsDisName(String jcfsDisName) {
		this.jcfsDisName = jcfsDisName;
	}

	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}

	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}
	
}
