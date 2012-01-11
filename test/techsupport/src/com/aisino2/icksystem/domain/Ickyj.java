package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Ickyj  {

	/** @param IC卡预警(t_ickyj) */

	/** @ --IC卡预警ID--ickyjid--Integer--10-- */
	private Integer ickyjid;

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --企业名称--qymc--String--120-- */
	private String qymc;

	/** @ --刷卡时间--sksj--Date---- */
	private Date sksj;

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

	/** @ --从业人员编号--cyrybh--String--30-- */
	private String cyrybh;

	/** @ --姓名--xm--String--100-- */
	private String xm;

	/** @ --姓名拼音--xmpy--String--60-- */
	private String xmpy;

	/** @ --卡ID号--ickh--String--100-- */
	private String ickh;

	/** @ --卡号--kh--String--20-- */
	private String kh;

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

	/** @ --从业类别代码--cylbdm--String--4-- */
	private String cylbdm;

	/** @ --从业类别--cylb--String--60-- */
	private String cylb;

	/** @ --预警原因--yjyy--String--300-- */
	private String yjyy;
	
	private Date sxsj;//失效时间
	
	private Integer ryid;//人员id

	/** 分页排序 */
	private String pageSort;
	
	/** @ --起始时间-- */
	private Date sksjf;
	/** @ --截止时间-- */
	private Date sksjt;
	private String bds;
	private String hylbdm;

	/** @ IC卡预警ID(ickyjid) */
	public Integer getIckyjid() {
		return ickyjid;
	}

	public void setIckyjid(Integer ickyjid) {
		this.ickyjid = ickyjid;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
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

	/** @ 刷卡时间(sksj) */
	public Date getSksj() {
		return sksj;
	}

	public void setSksj(Date sksj) {
		this.sksj = sksj;
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

	/** @ 从业人员编号(cyrybh) */
	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	/** @ 姓名(xm) */
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	/** @ 姓名拼音(xmpy) */
	public String getXmpy() {
		return xmpy;
	}

	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}

	/** @ 卡ID号(ickh) */
	public String getIckh() {
		return ickh;
	}

	public void setIckh(String ickh) {
		this.ickh = ickh;
	}

	/** @ 卡号(kh) */
	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
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

	/** @ 从业类别代码(cylbdm) */
	public String getCylbdm() {
		return cylbdm;
	}

	public void setCylbdm(String cylbdm) {
		this.cylbdm = cylbdm;
	}

	/** @ 从业类别(cylb) */
	public String getCylb() {
		return cylb;
	}

	public void setCylb(String cylb) {
		this.cylb = cylb;
	}

	/** @ 预警原因(yjyy) */
	public String getYjyy() {
		return yjyy;
	}

	public void setYjyy(String yjyy) {
		this.yjyy = yjyy;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
	
	
	public Date getSksjf() {
		return sksjf;
	}

	public void setSksjf(Date sksjf) {
		this.sksjf = sksjf;
	}

	public Date getSksjt() {
		return sksjt;
	}

	public void setSksjt(Date sksjt) {
		this.sksjt = sksjt;
	}

	public Date getSxsj() {
		return sxsj;
	}

	public void setSxsj(Date sxsj) {
		this.sxsj = sxsj;
	}

	public Integer getRyid() {
		return ryid;
	}

	public void setRyid(Integer ryid) {
		this.ryid = ryid;
	}

	public String getBds() {
		return bds;
	}

	public void setBds(String bds) {
		this.bds = bds;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}
}
