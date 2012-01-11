package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qybgxx  {

	/** @param 企业变更信息(t_qybgxx) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --企业历史ID--qylsid--Integer--10-- */
	private Integer qylsid;

	/** @ --企业变更信息ID--qybgxxid--Integer--10-- */
	private Integer qybgxxid;

	/** @ --变更登记序号--bgdjxh--String--30-- */
	private String bgdjxh;

	/** @ --变更类型代码--bglxdm--String--2-- */
	private String bglxdm;

	/** @ --变更类型--bglx--String--30-- */
	private String bglx;

	/** @ --变更日期--bgrq--Date---- */
	private Date bgrq;

	/** @ --变更原因--bgyy--String--2000-- */
	private String bgyy;

	/** @ --变更前内容--bgqnr--byte[]--300-- */
	private String bgqnr;

	/** @ --变更后内容--bghnr--byte[]--300-- */
	private String bghnr;

	/** 分页排序 */
	private String pageSort;
	
	private String qyzflbm;
	private String qyzflmc;
	private String qybm;
	private String qymc;
	private String gxdwbm;
	private String zjbh;
	private String frdb;
	private String jydz;
	private Date bgrqf;
	private Date bgrqt;
	
	private String gxdwmc;
	private String lxdh;
	private String yzbm;
	private String yyztmc;

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 企业历史ID(qylsid) */
	public Integer getQylsid() {
		return qylsid;
	}

	public void setQylsid(Integer qylsid) {
		this.qylsid = qylsid;
	}

	/** @ 企业变更信息ID(qybgxxid) */
	public Integer getQybgxxid() {
		return qybgxxid;
	}

	public void setQybgxxid(Integer qybgxxid) {
		this.qybgxxid = qybgxxid;
	}

	/** @ 变更登记序号(bgdjxh) */
	public String getBgdjxh() {
		return bgdjxh;
	}

	public void setBgdjxh(String bgdjxh) {
		this.bgdjxh = bgdjxh;
	}

	/** @ 变更类型代码(bglxdm) */
	public String getBglxdm() {
		return bglxdm;
	}

	public void setBglxdm(String bglxdm) {
		this.bglxdm = bglxdm;
	}

	/** @ 变更类型(bglx) */
	public String getBglx() {
		return bglx;
	}

	public void setBglx(String bglx) {
		this.bglx = bglx;
	}

	/** @ 变更日期(bgrq) */
	public Date getBgrq() {
		return bgrq;
	}

	public void setBgrq(Date bgrq) {
		this.bgrq = bgrq;
	}

	/** @ 变更原因(bgyy) */
	public String getBgyy() {
		return bgyy;
	}

	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getBgqnr() {
		return bgqnr;
	}

	public void setBgqnr(String bgqnr) {
		this.bgqnr = bgqnr;
	}

	public String getBghnr() {
		return bghnr;
	}

	public void setBghnr(String bghnr) {
		this.bghnr = bghnr;
	}

	public String getQyzflbm() {
		return qyzflbm;
	}

	public void setQyzflbm(String qyzflbm) {
		this.qyzflbm = qyzflbm;
	}

	public String getQyzflmc() {
		return qyzflmc;
	}

	public void setQyzflmc(String qyzflmc) {
		this.qyzflmc = qyzflmc;
	}

	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		this.qybm = qybm;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}

	public String getZjbh() {
		return zjbh;
	}

	public void setZjbh(String zjbh) {
		this.zjbh = zjbh;
	}

	public String getFrdb() {
		return frdb;
	}

	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}

	public String getJydz() {
		return jydz;
	}

	public void setJydz(String jydz) {
		this.jydz = jydz;
	}

	public Date getBgrqf() {
		return bgrqf;
	}

	public void setBgrqf(Date bgrqf) {
		this.bgrqf = bgrqf;
	}

	public Date getBgrqt() {
		return bgrqt;
	}

	public void setBgrqt(Date bgrqt) {
		this.bgrqt = bgrqt;
	}

	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getYzbm() {
		return yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getYyztmc() {
		return yyztmc;
	}

	public void setYyztmc(String yyztmc) {
		this.yyztmc = yyztmc;
	}
}
