package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyryjctj  {

	/** @param 企业人员奖惩统计表(t_qyryjctj) */

	/** @ --企业人员奖惩统计ID--qyryjctjid--Integer--10-- */
	private Integer qyryjctjid;

	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

	/** @ --统计日期--tjrq--Date---- */
	private Date tjrq;

	/** @ --从业人员编号--cyrybh--String--20-- */
	private String cyrybh;

	/** @ --从业人员类别代码--cyrylbdm--String--2-- */
	private String cyrylbdm;

	/** @ --从业人员类别名称--cyrylbmc--String--30-- */
	private String cyrylbmc;

	/** @ --姓名--xm--String--100-- */
	private String xm;

	/** @ --证件号码--zjhm--String--20-- */
	private String zjhm;

	/** @ --地市机关名称--dsjgmc--String--60-- */
	private String dsjgmc;

	/** @ --分县局代码--fxjdm--String--20-- */
	private String fxjdm;

	/** @ --地市机关代码--dsjgdm--String--20-- */
	private String dsjgdm;

	/** @ --分县局名称--fxjmc--String--60-- */
	private String fxjmc;

	/** @ --管辖单位代码--gxdwdm--String--20-- */
	private String gxdwdm;

	/** @ --管辖单位名称--gxdwmc--String--60-- */
	private String gxdwmc;

	/** @ --企业名称--qymc--String--120-- */
	private String qymc;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** 警告 */
	private Integer jg;

	/** 罚款 */
	private Integer fk;

	/** 拘留 */
	private Integer jl;

	/** 拘留并罚款 */
	private Integer jlbfk;

	/** 追究刑事责任 */
	private Integer zjxszr;

	/** 限期出境或驱逐出境 */
	private Integer xqcjhqzcj;

	/** 其他处罚类型 */
	private Integer qtfklx;

	/** 通报表扬次数 */
	private Integer tbbycs;
	/** 物质奖励次数 */
	private Integer wzjlcs;
	/** 其他奖励次数 */
	private Integer qtjlcs;
	
	/** 截止日期 奖惩数 */
	private Integer jzrqJczs;
	/** 截止日期 处罚数 */
	private Integer jzrqCfzs;
	/** 截止日期 奖励数 */
	private Integer jzrqJlzs;
	
	/** 周期内 奖惩数 */
	private Integer zqnJczs;
	/** 周期内 处罚数 */
	private Integer zqnCfzs;
	/** 周期内 奖励数 */
	private Integer zqnJlzs;
	
	/** @ --小计--xj--Integer--6-- */
	private Integer xj;

	/** 分页排序 */
	private String pageSort;

	private String csbm;// 场所编码

	/** @ --地市机关 标志 非数据库字段 */
	private String dsjgbz;

	/** @ --分县局代码 标志 非数据库字段 */
	private String fxjbz;

	/** @ --管辖单位代码 标志 非数据库字段 */
	private String gxdwbz;

	/** @ --场所代码 标志 非数据库字段 */
	private String csbz;
	
	/** @ --起始日期 非数据库字段 */
	private Date qsrq;

	/** @ --截止日期 非数据库字段 */
	private Date jzrq;

	public Date getQsrq() {
		return qsrq;
	}

	public void setQsrq(Date qsrq) {
		this.qsrq = qsrq;
	}

	public Date getJzrq() {
		return jzrq;
	}

	public void setJzrq(Date jzrq) {
		this.jzrq = jzrq;
	}

	/** @ 企业人员奖惩统计ID(qyryjctjid) */
	public Integer getQyryjctjid() {
		return qyryjctjid;
	}

	public void setQyryjctjid(Integer qyryjctjid) {
		this.qyryjctjid = qyryjctjid;
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

	/** @ 从业人员编号(cyrybh) */
	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	/** @ 从业人员类别代码(cyrylbdm) */
	public String getCyrylbdm() {
		return cyrylbdm;
	}

	public void setCyrylbdm(String cyrylbdm) {
		this.cyrylbdm = cyrylbdm;
	}

	/** @ 从业人员类别名称(cyrylbmc) */
	public String getCyrylbmc() {
		return cyrylbmc;
	}

	public void setCyrylbmc(String cyrylbmc) {
		this.cyrylbmc = cyrylbmc;
	}

	/** @ 姓名(xm) */
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	/** @ 证件号码(zjhm) */
	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
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

	/** @ 地市机关代码(dsjgdm) */
	public String getDsjgdm() {
		return dsjgdm;
	}

	public void setDsjgdm(String dsjgdm) {
		this.dsjgdm = dsjgdm;
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

	/** @ 企业名称(qymc) */
	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
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

	/** @ 警告(jg) */
	public Integer getJg() {
		return jg;
	}

	public void setJg(Integer jg) {
		this.jg = jg;
	}

	/** @ 罚款(fk) */
	public Integer getFk() {
		return fk;
	}

	public void setFk(Integer fk) {
		this.fk = fk;
	}

	/** @ 拘留(jl) */
	public Integer getJl() {
		return jl;
	}

	public void setJl(Integer jl) {
		this.jl = jl;
	}

	/** @ 拘留并罚款(jlbfk) */
	public Integer getJlbfk() {
		return jlbfk;
	}

	public void setJlbfk(Integer jlbfk) {
		this.jlbfk = jlbfk;
	}

	/** @ 追究刑事责任(zjxszr) */
	public Integer getZjxszr() {
		return zjxszr;
	}

	public void setZjxszr(Integer zjxszr) {
		this.zjxszr = zjxszr;
	}

	/** @ 限期出境或驱逐出境(xqcjhqzcj) */
	public Integer getXqcjhqzcj() {
		return xqcjhqzcj;
	}

	public void setXqcjhqzcj(Integer xqcjhqzcj) {
		this.xqcjhqzcj = xqcjhqzcj;
	}

	/** @ 其他处罚类型(qtfklx) */
	public Integer getQtfklx() {
		return qtfklx;
	}

	public void setQtfklx(Integer qtfklx) {
		this.qtfklx = qtfklx;
	}

	/** @ 小计(xj) */
	public Integer getXj() {
		return xj;
	}

	public void setXj(Integer xj) {
		this.xj = xj;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getCsbm() {
		return csbm;
	}

	public void setCsbm(String csbm) {
		this.csbm = csbm;
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

	public Integer getJzrqJczs() {
		return jzrqJczs;
	}

	public void setJzrqJczs(Integer jzrqJczs) {
		this.jzrqJczs = jzrqJczs;
	}

	public Integer getJzrqCfzs() {
		return jzrqCfzs;
	}

	public void setJzrqCfzs(Integer jzrqCfzs) {
		this.jzrqCfzs = jzrqCfzs;
	}

	public Integer getJzrqJlzs() {
		return jzrqJlzs;
	}

	public void setJzrqJlzs(Integer jzrqJlzs) {
		this.jzrqJlzs = jzrqJlzs;
	}

	public Integer getZqnJczs() {
		return zqnJczs;
	}

	public void setZqnJczs(Integer zqnJczs) {
		this.zqnJczs = zqnJczs;
	}

	public Integer getZqnCfzs() {
		return zqnCfzs;
	}

	public void setZqnCfzs(Integer zqnCfzs) {
		this.zqnCfzs = zqnCfzs;
	}

	public Integer getZqnJlzs() {
		return zqnJlzs;
	}

	public void setZqnJlzs(Integer zqnJlzs) {
		this.zqnJlzs = zqnJlzs;
	}
}
