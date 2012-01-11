package com.aisino2.publicsystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Baryxx  {

	/** @param 保安人员信息(t_baryxx) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;
	
	/** @ --保安人员ID--oldbaryid--Integer--10-- */
	private Integer oldbaryid;

	/** @ --保安人员ID--baryid--Integer--10-- */
	private Integer baryid;

	/** @ --姓名--xm--String--100-- */
	private String xm;

	/** @ --性别代码--xbdm--String--2-- */
	private String xbdm;

	/** @ --性别--xb--String--2-- */
	private String xb;

	/** @ --出生日期--csrq--Date---- */
	private Date csrq;

	/** @ --公民身份号码--gmsfhm--String--20-- */
	private String gmsfhm;

	/** @ --户籍地行政区划代码--hjdxzqhdm--String--10-- */
	private String hjdxzqhdm;

	/** @ --户籍地行政区划--hjdxzqh--String--200-- */
	private String hjdxzqh;

	/** @ --户籍地详址--hjdxz--String--200-- */
	private String hjdxz;

	/** @ --保安类型编码--balxbm--String--2-- */
	private String balxbm;

	/** @ --保安类型--balx--String--10-- */
	private String balx;

	/** @ --发证机关--fzjg--String--60-- */
	private String fzjg;

	/** @ --上岗日期--sgrq--Date---- */
	private Date sgrq;

	/** @ --离职原因--lzyy--String--200-- */
	private String lzyy;

	/** @ --离职日期--lzrq--Date---- */
	private Date lzrq;

	/** @ --备注--bz--String--2000-- */
	private String bz;

	/** @ --状态--zt--String--10-- */
	private String zt;

	/** @ --录入人--lrr--String--100-- */
	private String lrr;

	/** @ --录入时间--lrsj--Date---- */
	private Date lrsj;

	/** 分页排序 */
	private String pageSort;
	
	/** @ --请求动作：查看、修改 - 查看则不给删除按钮(非数据库字段)- */
	private String baryRequetType;
	
	private List lBaryxxList;//临时存储列表数据
	
	/** @ --企业名称--qymc--String--120-- */
	private String qymc;
	
	/** @ --行业类别--hylb--String--40-- */
	private String hylb;
	
	/** @ --行业类别代码--hylbdm--String -- */
	private String hylbdm;

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 保安人员ID(baryid) */
	public Integer getBaryid() {
		return baryid;
	}

	public void setBaryid(Integer baryid) {
		this.baryid = baryid;
	}

	/** @ 姓名(xm) */
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	/** @ 性别代码(xbdm) */
	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	/** @ 性别(xb) */
	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	/** @ 出生日期(csrq) */
	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	/** @ 公民身份号码(gmsfhm) */
	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	public String getHjdxzqhdm() {
		return hjdxzqhdm;
	}

	public void setHjdxzqhdm(String hjdxzqhdm) {
		this.hjdxzqhdm = hjdxzqhdm;
	}

	/** @ 户籍地行政区划(hjdxzqh) */
	public String getHjdxzqh() {
		return hjdxzqh;
	}

	public void setHjdxzqh(String hjdxzqh) {
		this.hjdxzqh = hjdxzqh;
	}

	/** @ 户籍地详址(hjdxz) */
	public String getHjdxz() {
		return hjdxz;
	}

	public void setHjdxz(String hjdxz) {
		this.hjdxz = hjdxz;
	}

	/** @ 保安类型编码(balxbm) */
	public String getBalxbm() {
		return balxbm;
	}

	public void setBalxbm(String balxbm) {
		this.balxbm = balxbm;
	}

	/** @ 保安类型(balx) */
	public String getBalx() {
		return balx;
	}

	public void setBalx(String balx) {
		this.balx = balx;
	}

	/** @ 发证机关(fzjg) */
	public String getFzjg() {
		return fzjg;
	}

	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}

	/** @ 上岗日期(sgrq) */
	public Date getSgrq() {
		return sgrq;
	}

	public void setSgrq(Date sgrq) {
		this.sgrq = sgrq;
	}

	/** @ 离职原因(lzyy) */
	public String getLzyy() {
		return lzyy;
	}

	public void setLzyy(String lzyy) {
		this.lzyy = lzyy;
	}

	/** @ 离职日期(lzrq) */
	public Date getLzrq() {
		return lzrq;
	}

	public void setLzrq(Date lzrq) {
		this.lzrq = lzrq;
	}

	/** @ 备注(bz) */
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	/** @ 状态(zt) */
	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	/** @ 录入人(lrr) */
	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	/** @ 录入时间(lrsj) */
	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getBaryRequetType() {
		return baryRequetType;
	}

	public void setBaryRequetType(String baryRequetType) {
		this.baryRequetType = baryRequetType;
	}

	public List getLBaryxxList() {
		return lBaryxxList;
	}

	public void setLBaryxxList(List baryxxList) {
		lBaryxxList = baryxxList;
	}

	public Integer getOldbaryid() {
		return oldbaryid;
	}

	public void setOldbaryid(Integer oldbaryid) {
		this.oldbaryid = oldbaryid;
	}
	
}
