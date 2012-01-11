package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyryskjl  {

	/** @param 企业人员刷卡记录(t_qyryskjl) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --行业类别代码--hylbdm--String--3-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

	/** @ --刷卡ID--skid--Integer--10-- */
	private Integer skid;

	/** @ --卡ID号--ickh--String--100-- */
	private String ickh;

	/** @ --刷卡时间--sksj--Date---- */
	private Date sksj;

	/** @ --上传时间--scsj--Date---- */
	private Date scsj;

	/** @ --卡号--kh--String--20-- */
	private String kh;

	/** @ --从业人员编号--cyrybh--String--30-- */
	private String cyrybh;

	/** @ --IC卡受理流水号--icksllsh--Integer--10-- */
	private Integer icksllsh;

	/** 分页排序 */
	private String pageSort;
	
	/** 从业人员姓名 */
	private String xm;
	
	/** 从业人员姓名 注册人员*/
	private String xmzc;
	
	/** 从业人员姓名 非注册人员*/
	private String xmfzc;
	
	/**场所名称*/
	private String qymc;
	
	/** 管辖单位编码*/
	private String gxdwbm;
	
	/** 管辖单位名称*/
	private String gxdwmc;
	
	/** 是否走台 0-否，1-是*/
	private String sfzt;
	/** 常用证件代码*/
	private String cyzjdm;
	/** 常用证件*/
	private String cyzj;
	/** 证件号码*/
	private String zjhm;
	/** 刷卡起始日期 yyyy-MM-dd*/
	private Date sksjf;
	/** 刷卡截止日期 yyyy-MM-dd*/
	private Date sksjt;
	/** 职务*/
	private String zhiwu;
	/** 从业人员类别代码*/
	private String cyrylbdm;
	/** 人员ID*/
	private Integer ryid;
	private String applyid;//大河webservice每条记录的唯一标示符
	
	private String lxdh;
	private String shouji;
	private Integer skcs;//刷卡次数
	private String bds;
	
	private String jczt;//进出状态 内保单位使用
	private String dwlb;		//单位类别:同内保行业类别代码
	private String dwlbdm;		//单位类别:同内保行业类别代码

	public String getDwlb() {
		return dwlb;
	}

	public void setDwlb(String dwlb) {
		this.dwlb = dwlb;
	}

	public String getDwlbdm() {
		return dwlbdm;
	}

	public void setDwlbdm(String dwlbdm) {
		this.dwlbdm = dwlbdm;
	}

	public String getJczt() {
		return jczt;
	}

	public void setJczt(String jczt) {
		this.jczt = jczt;
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

	/** @ 行业类别代码(hylbdm) */
	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	/** @ 行业类别(hylb) */
	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	/** @ 刷卡ID(skid) */
	public Integer getSkid() {
		return skid;
	}

	public void setSkid(Integer skid) {
		this.skid = skid;
	}

	/** @ 卡ID号(ickh) */
	public String getIckh() {
		return ickh;
	}

	public void setIckh(String ickh) {
		this.ickh = ickh;
	}

	/** @ 刷卡时间(sksj) */
	public Date getSksj() {
		return sksj;
	}

	public void setSksj(Date sksj) {
		this.sksj = sksj;
	}

	/** @ 上传时间(scsj) */
	public Date getScsj() {
		return scsj;
	}

	public void setScsj(Date scsj) {
		this.scsj = scsj;
	}

	/** @ 卡号(kh) */
	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	/** @ 从业人员编号(cyrybh) */
	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	/** @ IC卡受理流水号(icksllsh) */
	public Integer getIcksllsh() {
		return icksllsh;
	}

	public void setIcksllsh(Integer icksllsh) {
		this.icksllsh = icksllsh;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXmzc() {
		return xmzc;
	}

	public void setXmzc(String xmzc) {
		this.xmzc = xmzc;
	}

	public String getXmfzc() {
		return xmfzc;
	}

	public void setXmfzc(String xmfzc) {
		this.xmfzc = xmfzc;
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

	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	public String getSfzt() {
		return sfzt;
	}

	public void setSfzt(String sfzt) {
		this.sfzt = sfzt;
	}

	public String getCyzjdm() {
		return cyzjdm;
	}

	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}

	public String getCyzj() {
		return cyzj;
	}

	public void setCyzj(String cyzj) {
		this.cyzj = cyzj;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
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

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public String getCyrylbdm() {
		return cyrylbdm;
	}

	public void setCyrylbdm(String cyrylbdm) {
		this.cyrylbdm = cyrylbdm;
	}

	public Integer getRyid() {
		return ryid;
	}

	public void setRyid(Integer ryid) {
		this.ryid = ryid;
	}

	public String getApplyid() {
		return applyid;
	}

	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getShouji() {
		return shouji;
	}

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}

	public Integer getSkcs() {
		return skcs;
	}

	public void setSkcs(Integer skcs) {
		this.skcs = skcs;
	}

	public String getBds() {
		return bds;
	}

	public void setBds(String bds) {
		this.bds = bds;
	}
}
