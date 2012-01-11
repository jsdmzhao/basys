package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qycftj  {

	/** @param 企业处罚统计表(t_qycftj) */

	/** @ --企业处罚统计ID--qycftjid--Integer--10-- */
	private Integer qycftjid;

	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

	/** @ --统计日期--tjrq--Date---- */
	private Date tjrq;
	/** @ --统计日期至--tjrqzhi--Date---- */
	private Date tjrqzhi;

	/** @ --地市机关代码--dsjgdm--String--20-- */
	private String dsjgdm;

	/** @ --地市机关名称--dsjgmc--String--60-- */
	private String dsjgmc;

	/** @ --分县局代码--fxjdm--String--20-- */
	private String fxjdm;

	/** @ --分县局名称--fxjmc--String--60-- */
	private String fxjmc;

	/** @ --管辖单位名称--gxdwmc--String--60-- */
	private String gxdwmc;

	/** @ --管辖单位代码--gxdwdm--String--20-- */
	private String gxdwdm;

	/** @ --场所编码--csbm--String--20-- */
	private String csbm;

	/** @ --场所名称--csmc--String--120-- */
	private String csmc;

	/** @ --警告次数--jgcs--Integer--6-- */
	private Integer jgcs;

	/** @ --罚没次数--fmcs--Integer--6-- */
	private Integer fmcs;

	/** @ --停吊次数--tdcs--Integer--6-- */
	private Integer tdcs;

	/** @ --追究次数--zjcs--Integer--6-- */
	private Integer zjcs;

	/** @ --其他处罚次数--qtfmcs--Integer--6-- */
	private Integer qtfmcs;
	
	/** @ --通报表扬次数--tbbycs--Integer--6-- */
	private Integer tbbycs;

	/** @ --物质奖励次数--wzjlcs--Integer--6-- */
	private Integer wzjlcs;

	/** @ --其他奖励次数--qtjlcs--Integer--6-- */
	private Integer qtjlcs;
	
	private Integer jczsT;// 企业奖惩总数(至截止日期)
	
	private Integer cfzsT;// 企业处罚总数(至截止日期)
	
	private Integer jlzsT;// 企业奖励总数(至截止日期)
	
	private Integer jczs;// 企业奖惩总数(周期内新增)
	
	private Integer cfzs;// 企业处罚总数(周期内新增)
	
	private Integer jlzs;// 企业奖励总数(周期内新增)
	
	
	private Date qssj;  ///起始时间
	
	private Date jzsj;  //截至时间
	

	public Date getQssj() {
		return qssj;
	}

	public void setQssj(Date qssj) {
		this.qssj = qssj;
	}

	public Date getJzsj() {
		return jzsj;
	}

	public void setJzsj(Date jzsj) {
		this.jzsj = jzsj;
	}

	/** 分页排序 */
	private String pageSort;
	
	
	/** @ --小计--qtfmcs--Integer--6-- */
	private Integer xiaoji;
	
	private String dsjgbz; // 地市局标志
	private String fxjbz; // 分县局标志
	private String gxdwbz; // 科所队标志
	private String csbz;// 企业标志
	
	

	// 合计判断
	private String isQuery;
	
	public String getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	public String getDsjgbz() {
		return dsjgbz;
	}

	public void setDsjgbz(String dsjgbz) {
		this.dsjgbz = dsjgbz;
	}

	public String getFxjbz() {
		return fxjbz;
	}

	public void setFxjbz(String fxjbz) {
		this.fxjbz = fxjbz;
	}

	public String getGxdwbz() {
		return gxdwbz;
	}

	public void setGxdwbz(String gxdwbz) {
		this.gxdwbz = gxdwbz;
	}

	public String getCsbz() {
		return csbz;
	}

	public void setCsbz(String csbz) {
		this.csbz = csbz;
	}

	/** @ 企业处罚统计ID(qycftjid) */
	public Integer getQycftjid() {
		return qycftjid;
	}

	public void setQycftjid(Integer qycftjid) {
		this.qycftjid = qycftjid;
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

	/** @ 统计日期(tjrq) */
	public Date getTjrq() {
		return tjrq;
	}

	public void setTjrq(Date tjrq) {
		this.tjrq = tjrq;
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

	/** @ 管辖单位名称(gxdwmc) */
	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	/** @ 管辖单位代码(gxdwdm) */
	public String getGxdwdm() {
		return gxdwdm;
	}

	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
	}

	/** @ 场所编码(csbm) */
	public String getCsbm() {
		return csbm;
	}

	public void setCsbm(String csbm) {
		this.csbm = csbm;
	}

	/** @ 场所名称(csmc) */
	public String getCsmc() {
		return csmc;
	}

	public void setCsmc(String csmc) {
		this.csmc = csmc;
	}

	/** @ 警告次数(jgcs) */
	public Integer getJgcs() {
		return jgcs;
	}

	public void setJgcs(Integer jgcs) {
		this.jgcs = jgcs;
	}

	/** @ 罚没次数(fmcs) */
	public Integer getFmcs() {
		return fmcs;
	}

	public void setFmcs(Integer fmcs) {
		this.fmcs = fmcs;
	}

	/** @ 停吊次数(tdcs) */
	public Integer getTdcs() {
		return tdcs;
	}

	public void setTdcs(Integer tdcs) {
		this.tdcs = tdcs;
	}

	/** @ 追究次数(zjcs) */
	public Integer getZjcs() {
		return zjcs;
	}

	public void setZjcs(Integer zjcs) {
		this.zjcs = zjcs;
	}

	/** @ 其他处罚次数(qtfmcs) */
	public Integer getQtfmcs() {
		return qtfmcs;
	}

	public void setQtfmcs(Integer qtfmcs) {
		this.qtfmcs = qtfmcs;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getTjrqzhi() {
		return tjrqzhi;
	}

	public void setTjrqzhi(Date tjrqzhi) {
		this.tjrqzhi = tjrqzhi;
	}

	public Integer getXiaoji() {
		return xiaoji;
	}

	public void setXiaoji(Integer xiaoji) {
		this.xiaoji = xiaoji;
	}

	public Integer getTbbycs() {
		return tbbycs;
	}

	public void setTbbycs(Integer tbbycs) {
		this.tbbycs = tbbycs;
	}

	public Integer getWzjlcs() {
		return wzjlcs;
	}

	public void setWzjlcs(Integer wzjlcs) {
		this.wzjlcs = wzjlcs;
	}

	public Integer getQtjlcs() {
		return qtjlcs;
	}

	public void setQtjlcs(Integer qtjlcs) {
		this.qtjlcs = qtjlcs;
	}

	public Integer getJczsT() {
		return jczsT;
	}

	public void setJczsT(Integer jczsT) {
		this.jczsT = jczsT;
	}

	public Integer getCfzsT() {
		return cfzsT;
	}

	public void setCfzsT(Integer cfzsT) {
		this.cfzsT = cfzsT;
	}

	public Integer getJlzsT() {
		return jlzsT;
	}

	public void setJlzsT(Integer jlzsT) {
		this.jlzsT = jlzsT;
	}

	public Integer getJczs() {
		return jczs;
	}

	public void setJczs(Integer jczs) {
		this.jczs = jczs;
	}

	public Integer getCfzs() {
		return cfzs;
	}

	public void setCfzs(Integer cfzs) {
		this.cfzs = cfzs;
	}

	public Integer getJlzs() {
		return jlzs;
	}

	public void setJlzs(Integer jlzs) {
		this.jlzs = jlzs;
	}
}
