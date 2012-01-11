package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Bdbjtj  {

	/** @param 比对报警统计表(t_bdbjtj) */

	/** @ --比对报警统计ID--bdbjtjid--Integer--10-- */
	private Integer bdbjtjid;

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

	/** @ --车辆报警次数--clbjcs--Integer--6-- */
	private Integer clbjcs;

	/** @ --从业人员报警次数--cyrybjcs--Integer--6-- */
	private Integer cyrybjcs;

	/** @ --涉车人员报警次数--scrybjcs--Integer--6-- */
	private Integer scrybjcs;

	/** @ --可疑车辆报警次数--kyclbjcs--Integer--6-- */
	private Integer kyclbjcs;

	/** 分页排序 */
	private String pageSort;
	
	/** @ --小计--xiaoji--Integer--6-- */
	private Integer xiaoji;

	private String dsjgbz; // 地市局标志
	private String fxjbz; // 分县局标志
	private String gxdwbz; // 科所队标志
	private String csbz;// 企业标志
	
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

	public Integer getXiaoji() {
		return xiaoji;
	}

	public void setXiaoji(Integer xiaoji) {
		this.xiaoji = xiaoji;
	}

	/** @ 比对报警统计ID(bdbjtjid) */
	public Integer getBdbjtjid() {
		return bdbjtjid;
	}

	public void setBdbjtjid(Integer bdbjtjid) {
		this.bdbjtjid = bdbjtjid;
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

	/** @ 车辆报警次数(clbjcs) */
	public Integer getClbjcs() {
		return clbjcs;
	}

	public void setClbjcs(Integer clbjcs) {
		this.clbjcs = clbjcs;
	}

	/** @ 从业人员报警次数(cyrybjcs) */
	public Integer getCyrybjcs() {
		return cyrybjcs;
	}

	public void setCyrybjcs(Integer cyrybjcs) {
		this.cyrybjcs = cyrybjcs;
	}

	/** @ 涉车人员报警次数(scrybjcs) */
	public Integer getScrybjcs() {
		return scrybjcs;
	}

	public void setScrybjcs(Integer scrybjcs) {
		this.scrybjcs = scrybjcs;
	}

	/** @ 可疑车辆报警次数(kyclbjcs) */
	public Integer getKyclbjcs() {
		return kyclbjcs;
	}

	public void setKyclbjcs(Integer kyclbjcs) {
		this.kyclbjcs = kyclbjcs;
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
}
