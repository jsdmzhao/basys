package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyryxxhc  {

	/** @param 企业人员信息核查(t_qyryxxhc) */

	/** @ --公安人口库同步数据ID--garkktbsjid--Integer--10-- */
	private Integer garkktbsjid;

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --从业人员ID--ryid--Integer--10-- */
	private Integer ryid;

	/** @ --核查ID--hcid--Integer--10-- */
	private Integer hcid;

	/** @ --地市机关代码--dsjgdm--String--20-- */
	private String dsjgdm;

	/** @ --地市机关名称--dsjgmc--String--60-- */
	private String dsjgmc;

	/** @ --分县局代码--fxjdm--String--20-- */
	private String fxjdm;

	/** @ --分县局名称--fxjmc--String--60-- */
	private String fxjmc;

	/** @ --管辖单位代码--gxdwdm--String--20-- */
	private String gxdwdm;

	/** @ --管辖单位名称--gxdwmc--String--60-- */
	private String gxdwmc;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --企业名称--qymc--String--120-- */
	private String qymc;

	/** @ --姓名--xm--String--100-- */
	private String xm;

	/** @ --性别代码--xbdm--String--2-- */
	private String xbdm;

	/** @ --性别--xb--String--2-- */
	private String xb;

	/** @ --英文名--ywm--String--60-- */
	private String ywm;

	/** @ --英文姓--ywx--String--60-- */
	private String ywx;

	/** @ --外国人就业许可证号--wgrjyxkz--String--60-- */
	private String wgrjyxkz;

	/** @ --常用证件代码--cyzjdm--String--40-- */
	private String cyzjdm;

	/** @ --常用证件--cyzj--String--100-- */
	private String cyzj;

	/** @ --证件号码--zjhm--String--20-- */
	private String zjhm;

	/** @ --岗位编号--gwbh--String--4-- */
	private String gwbh;

	/** @ --岗位名称--gemc--String--60-- */
	private String gemc;

	/** @ --姓名拼音--xmpy--String--60-- */
	private String xmpy;

	/** @ --比对时间--bdsj--Date---- */
	private Date bdsj;

	/** @ --核查时间--hcsj--Date---- */
	private Date hcsj;

	/** @ --核查问题--hcwt--String--100-- */
	private String hcwt;

	/** @ --核查意见--hcyj--String--300-- */
	private String hcyj;

	/** @ --核查人--hcr--String--30-- */
	private String hcr;

	/** @ --核查单位--hcdw--String--100-- */
	private String hcdw;

	/** @ --核查单位代码--hcdwdm--String--30-- */
	private String hcdwdm;

	/** @ --核查状态--hczt--String--100-- */
	private String hczt;

	/** 分页排序 */
	private String pageSort;
	
	/** 行业类别代码 hylbdm */
	private String hylbdm;
	/** 行业类别 hylb */
	private String hylb;
	/** 从业类别代码 cylbdm */
	private String cylbdm;
	/** 从业类别 cylb */
	private String cylb;
	/** 从业人员编号 cyrybh */
	private String cyrybh;
	/**  民族代码mzdm */
	private String mzdm;
	/**  户籍地行政区划代码hjdxzqhdm */
	private String hjdxzqhdm;
	/**  出生日期csrq */
	private Date csrq;

	private String yjbz;//预警标识

	/** @ 公安人口库同步数据ID(garkktbsjid) */
	public Integer getGarkktbsjid() {
		return garkktbsjid;
	}

	public void setGarkktbsjid(Integer garkktbsjid) {
		this.garkktbsjid = garkktbsjid;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 从业人员ID(ryid) */
	public Integer getRyid() {
		return ryid;
	}

	public void setRyid(Integer ryid) {
		this.ryid = ryid;
	}

	/** @ 核查ID(hcid) */
	public Integer getHcid() {
		return hcid;
	}

	public void setHcid(Integer hcid) {
		this.hcid = hcid;
	}

	/** @ 地市机关代码(dsjgdm) */
	public String getDsjgdm() {
		return dsjgdm;
	}

	public void setDsjgdm(String dsjgdm) {
		this.dsjgdm = dsjgdm;
	}

	/** @ 地市机关名称(dsjgmc) */
	public String getDsjgmc() {
		return dsjgmc;
	}

	public void setDsjgmc(String dsjgmc) {
		this.dsjgmc = dsjgmc;
	}

	/** @ 分县局代码(fxjdm) */
	public String getFxjdm() {
		return fxjdm;
	}

	public void setFxjdm(String fxjdm) {
		this.fxjdm = fxjdm;
	}

	/** @ 分县局名称(fxjmc) */
	public String getFxjmc() {
		return fxjmc;
	}

	public void setFxjmc(String fxjmc) {
		this.fxjmc = fxjmc;
	}

	/** @ 管辖单位代码(gxdwdm) */
	public String getGxdwdm() {
		return gxdwdm;
	}

	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
	}

	/** @ 管辖单位名称(gxdwmc) */
	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	/** @ 企业编码(qybm) */
	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}

	/** @ 企业名称(qymc) */
	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
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

	/** @ 英文名(ywm) */
	public String getYwm() {
		return ywm;
	}

	public void setYwm(String ywm) {
		this.ywm = ywm;
	}

	/** @ 英文姓(ywx) */
	public String getYwx() {
		return ywx;
	}

	public void setYwx(String ywx) {
		this.ywx = ywx;
	}

	/** @ 外国人就业许可证号(wgrjyxkz) */
	public String getWgrjyxkz() {
		return wgrjyxkz;
	}

	public void setWgrjyxkz(String wgrjyxkz) {
		this.wgrjyxkz = wgrjyxkz;
	}

	/** @ 常用证件代码(cyzjdm) */
	public String getCyzjdm() {
		return cyzjdm;
	}

	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}

	/** @ 常用证件(cyzj) */
	public String getCyzj() {
		return cyzj;
	}

	public void setCyzj(String cyzj) {
		this.cyzj = cyzj;
	}

	/** @ 证件号码(zjhm) */
	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	/** @ 岗位编号(gwbh) */
	public String getGwbh() {
		return gwbh;
	}

	public void setGwbh(String gwbh) {
		this.gwbh = gwbh;
	}

	/** @ 岗位名称(gemc) */
	public String getGemc() {
		return gemc;
	}

	public void setGemc(String gemc) {
		this.gemc = gemc;
	}

	/** @ 姓名拼音(xmpy) */
	public String getXmpy() {
		return xmpy;
	}

	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}

	/** @ 比对时间(bdsj) */
	public Date getBdsj() {
		return bdsj;
	}

	public void setBdsj(Date bdsj) {
		this.bdsj = bdsj;
	}

	/** @ 核查时间(hcsj) */
	public Date getHcsj() {
		return hcsj;
	}

	public void setHcsj(Date hcsj) {
		this.hcsj = hcsj;
	}

	/** @ 核查问题(hcwt) */
	public String getHcwt() {
		return hcwt;
	}

	public void setHcwt(String hcwt) {
		this.hcwt = hcwt;
	}

	/** @ 核查意见(hcyj) */
	public String getHcyj() {
		return hcyj;
	}

	public void setHcyj(String hcyj) {
		this.hcyj = hcyj;
	}

	/** @ 核查人(hcr) */
	public String getHcr() {
		return hcr;
	}

	public void setHcr(String hcr) {
		this.hcr = hcr;
	}

	/** @ 核查单位(hcdw) */
	public String getHcdw() {
		return hcdw;
	}

	public void setHcdw(String hcdw) {
		this.hcdw = hcdw;
	}

	/** @ 核查单位代码(hcdwdm) */
	public String getHcdwdm() {
		return hcdwdm;
	}

	public void setHcdwdm(String hcdwdm) {
		this.hcdwdm = hcdwdm;
	}

	/** @ 核查状态(hczt) */
	public String getHczt() {
		return hczt;
	}

	public void setHczt(String hczt) {
		this.hczt = hczt;
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

	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	public String getHjdxzqhdm() {
		return hjdxzqhdm;
	}

	public void setHjdxzqhdm(String hjdxzqhdm) {
		this.hjdxzqhdm = hjdxzqhdm;
	}

	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getCylbdm() {
		return cylbdm;
	}

	public void setCylbdm(String cylbdm) {
		this.cylbdm = cylbdm;
	}

	public String getCylb() {
		return cylb;
	}

	public void setCylb(String cylb) {
		this.cylb = cylb;
	}

	public String getYjbz() {
		return yjbz;
	}

	public void setYjbz(String yjbz) {
		this.yjbz = yjbz;
	}
}
