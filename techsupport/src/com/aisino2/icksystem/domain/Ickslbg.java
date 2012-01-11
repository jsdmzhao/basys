package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Ickslbg  {

	/** @param IC卡受理变更(t_ickslbg) */

	/** @ --IC卡受理ID--ickslid--Integer--10-- */
	private Integer ickslid;

	/** @ --IC卡受理变更ID--ickslbgid--Integer--10-- */
	private Integer ickslbgid;

	/** @ --物流ID--wlid--Integer--10-- */
	private Integer wlid;

	/** @ --组包ID--zbid--Integer--10-- */
	private Integer zbid;

	/** @ --卡号--kh--String--20-- */
	private String kh;

	/** @ --卡ID号--ickh--String--100-- */
	private String ickh;

	/** @ --申领原因--slyy--String--200-- */
	private String slyy;

	/** @ --受理人--slr--String--30-- */
	private String slr;

	/** @ --受理时间--slsj--Date---- */
	private Date slsj;

	/** @ --有效期开始日期--yxsksrq--Date---- */
	private Date yxsksrq;

	/** @ --有效期截至日期--yxqhzrq--Date---- */
	private Date yxqhzrq;

	/** @ --采集时间--cjsj--Date---- */
	private Date cjsj;

	/** @ --采集人--cjr--String--30-- */
	private String cjr;

	/** @ --采集点编码--cjdbm--String--20-- */
	private String cjdbm;

	/** @ --采集点名称--cjdmc--String--100-- */
	private String cjdmc;

	/** @ --接收时间--jssj--Date---- */
	private Date jssj;

	/** @ --接收包名称--jsbmc--String--20-- */
	private String jsbmc;

	/** @ --发放人--ffr--String--30-- */
	private String ffr;

	/** @ --发放时间--ffsj--Date---- */
	private Date ffsj;

	/** @ --领取人--lqr--String--30-- */
	private String lqr;

	/** @ --领取时间--lqsj--Date---- */
	private Date lqsj;

	/** @ --领取人证件类型--lqrzjlx--String--40-- */
	private String lqrzjlx;

	/** @ --领取人证件号码--lqrzjhm--String--20-- */
	private String lqrzjhm;

	/** @ --IC卡注销人--ickzxr--String--30-- */
	private String ickzxr;

	/** @ --IC卡注销时间--ickzxsj--Date---- */
	private Date ickzxsj;

	/** @ --IC卡注销原因--ickzxyy--String--200-- */
	private String ickzxyy;

	/** @ --年检人--njr--String--30-- */
	private String njr;

	/** @ --年检时间--njsj--Date---- */
	private Date njsj;

	/** @ --制卡状态标识--zkztbs--String--2-- */
	private String zkztbs;

	/** @ --是否确认--sfqr--String--1-- */
	private String sfqr;

	/** @ --印刷人--ysr--String--100-- */
	private String ysr;

	/** @ --印刷时间--yssj--Date---- */
	private Date yssj;

	/** @ --电写入人--dxrr--String--100-- */
	private String dxrr;

	/** @ --电写入时间--dxrsj--Date---- */
	private Date dxrsj;

	/** @ --重印刷时间--cyssj--Date---- */
	private Date cyssj;

	/** @ --重印刷原因--cysyy--String--200-- */
	private String cysyy;

	/** @ --重电写入时间--cdxrsj--Date---- */
	private Date cdxrsj;

	/** @ --重电写入原因--cdxryy--String--200-- */
	private String cdxryy;

	/** @ --补换卡原因--bhkyy--String--200-- */
	private String bhkyy;

	/** @ --原卡是否收回--yksfsh--String--1-- */
	private String yksfsh;

	/** 分页排序 */
	private String pageSort;

	/** @ IC卡受理ID(ickslid) */
	public Integer getIckslid() {
		return ickslid;
	}

	public void setIckslid(Integer ickslid) {
		this.ickslid = ickslid;
	}

	/** @ IC卡受理变更ID(ickslbgid) */
	public Integer getIckslbgid() {
		return ickslbgid;
	}

	public void setIckslbgid(Integer ickslbgid) {
		this.ickslbgid = ickslbgid;
	}

	/** @ 物流ID(wlid) */
	public Integer getWlid() {
		return wlid;
	}

	public void setWlid(Integer wlid) {
		this.wlid = wlid;
	}

	/** @ 组包ID(zbid) */
	public Integer getZbid() {
		return zbid;
	}

	public void setZbid(Integer zbid) {
		this.zbid = zbid;
	}

	/** @ 卡号(kh) */
	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	/** @ 卡ID号(ickh) */
	public String getIckh() {
		return ickh;
	}

	public void setIckh(String ickh) {
		this.ickh = ickh;
	}

	/** @ 申领原因(slyy) */
	public String getSlyy() {
		return slyy;
	}

	public void setSlyy(String slyy) {
		this.slyy = slyy;
	}

	/** @ 受理人(slr) */
	public String getSlr() {
		return slr;
	}

	public void setSlr(String slr) {
		this.slr = slr;
	}

	/** @ 受理时间(slsj) */
	public Date getSlsj() {
		return slsj;
	}

	public void setSlsj(Date slsj) {
		this.slsj = slsj;
	}

	/** @ 有效期开始日期(yxsksrq) */
	public Date getYxsksrq() {
		return yxsksrq;
	}

	public void setYxsksrq(Date yxsksrq) {
		this.yxsksrq = yxsksrq;
	}

	/** @ 有效期截至日期(yxqhzrq) */
	public Date getYxqhzrq() {
		return yxqhzrq;
	}

	public void setYxqhzrq(Date yxqhzrq) {
		this.yxqhzrq = yxqhzrq;
	}

	/** @ 采集时间(cjsj) */
	public Date getCjsj() {
		return cjsj;
	}

	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	/** @ 采集人(cjr) */
	public String getCjr() {
		return cjr;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	/** @ 采集点编码(cjdbm) */
	public String getCjdbm() {
		return cjdbm;
	}

	public void setCjdbm(String cjdbm) {
		this.cjdbm = cjdbm;
	}

	/** @ 采集点名称(cjdmc) */
	public String getCjdmc() {
		return cjdmc;
	}

	public void setCjdmc(String cjdmc) {
		this.cjdmc = cjdmc;
	}

	/** @ 接收时间(jssj) */
	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	/** @ 接收包名称(jsbmc) */
	public String getJsbmc() {
		return jsbmc;
	}

	public void setJsbmc(String jsbmc) {
		this.jsbmc = jsbmc;
	}

	/** @ 发放人(ffr) */
	public String getFfr() {
		return ffr;
	}

	public void setFfr(String ffr) {
		this.ffr = ffr;
	}

	/** @ 发放时间(ffsj) */
	public Date getFfsj() {
		return ffsj;
	}

	public void setFfsj(Date ffsj) {
		this.ffsj = ffsj;
	}

	/** @ 领取人(lqr) */
	public String getLqr() {
		return lqr;
	}

	public void setLqr(String lqr) {
		this.lqr = lqr;
	}

	/** @ 领取时间(lqsj) */
	public Date getLqsj() {
		return lqsj;
	}

	public void setLqsj(Date lqsj) {
		this.lqsj = lqsj;
	}

	/** @ 领取人证件类型(lqrzjlx) */
	public String getLqrzjlx() {
		return lqrzjlx;
	}

	public void setLqrzjlx(String lqrzjlx) {
		this.lqrzjlx = lqrzjlx;
	}

	/** @ 领取人证件号码(lqrzjhm) */
	public String getLqrzjhm() {
		return lqrzjhm;
	}

	public void setLqrzjhm(String lqrzjhm) {
		this.lqrzjhm = lqrzjhm;
	}

	/** @ IC卡注销人(ickzxr) */
	public String getIckzxr() {
		return ickzxr;
	}

	public void setIckzxr(String ickzxr) {
		this.ickzxr = ickzxr;
	}

	/** @ IC卡注销时间(ickzxsj) */
	public Date getIckzxsj() {
		return ickzxsj;
	}

	public void setIckzxsj(Date ickzxsj) {
		this.ickzxsj = ickzxsj;
	}

	/** @ IC卡注销原因(ickzxyy) */
	public String getIckzxyy() {
		return ickzxyy;
	}

	public void setIckzxyy(String ickzxyy) {
		this.ickzxyy = ickzxyy;
	}

	/** @ 年检人(njr) */
	public String getNjr() {
		return njr;
	}

	public void setNjr(String njr) {
		this.njr = njr;
	}

	/** @ 年检时间(njsj) */
	public Date getNjsj() {
		return njsj;
	}

	public void setNjsj(Date njsj) {
		this.njsj = njsj;
	}

	/** @ 制卡状态标识(zkztbs) */
	public String getZkztbs() {
		return zkztbs;
	}

	public void setZkztbs(String zkztbs) {
		this.zkztbs = zkztbs;
	}

	/** @ 是否确认(sfqr) */
	public String getSfqr() {
		return sfqr;
	}

	public void setSfqr(String sfqr) {
		this.sfqr = sfqr;
	}

	/** @ 印刷人(ysr) */
	public String getYsr() {
		return ysr;
	}

	public void setYsr(String ysr) {
		this.ysr = ysr;
	}

	/** @ 印刷时间(yssj) */
	public Date getYssj() {
		return yssj;
	}

	public void setYssj(Date yssj) {
		this.yssj = yssj;
	}

	/** @ 电写入人(dxrr) */
	public String getDxrr() {
		return dxrr;
	}

	public void setDxrr(String dxrr) {
		this.dxrr = dxrr;
	}

	/** @ 电写入时间(dxrsj) */
	public Date getDxrsj() {
		return dxrsj;
	}

	public void setDxrsj(Date dxrsj) {
		this.dxrsj = dxrsj;
	}

	/** @ 重印刷时间(cyssj) */
	public Date getCyssj() {
		return cyssj;
	}

	public void setCyssj(Date cyssj) {
		this.cyssj = cyssj;
	}

	/** @ 重印刷原因(cysyy) */
	public String getCysyy() {
		return cysyy;
	}

	public void setCysyy(String cysyy) {
		this.cysyy = cysyy;
	}

	/** @ 重电写入时间(cdxrsj) */
	public Date getCdxrsj() {
		return cdxrsj;
	}

	public void setCdxrsj(Date cdxrsj) {
		this.cdxrsj = cdxrsj;
	}

	/** @ 重电写入原因(cdxryy) */
	public String getCdxryy() {
		return cdxryy;
	}

	public void setCdxryy(String cdxryy) {
		this.cdxryy = cdxryy;
	}

	/** @ 补换卡原因(bhkyy) */
	public String getBhkyy() {
		return bhkyy;
	}

	public void setBhkyy(String bhkyy) {
		this.bhkyy = bhkyy;
	}

	/** @ 原卡是否收回(yksfsh) */
	public String getYksfsh() {
		return yksfsh;
	}

	public void setYksfsh(String yksfsh) {
		this.yksfsh = yksfsh;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
