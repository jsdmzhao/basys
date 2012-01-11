package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Asjtj  {

	private Integer asjtjid;// 案事件统计ID
	private String hylbdm;// 行业类别代码
	private String hylb;// 行业类别
	private String qybm;// 企业编码
	private String qymc;// 企业名称
	private String dsjgmc;// 地市机关名称
	private String fxjdm;// 分县局代码
	private String dsjgdm;// 地市机关代码
	private String fxjmc;// 分县局名称
	private String gxdwdm;// 管辖单位代码
	private String gxdwmc;// 管辖单位名称
	private Date tjrq;// 统计日期
	private Integer xsajs;// 刑事案件数
	private Integer zzajs;// 治安案件数
	private Integer fazs;// 发案总数
	private Integer xsajsT;// 刑事案件数(至截止日期)
	private Integer zzajsT;// 治安案件数(至截止日期)
	private Integer fazsT;// 发案总数(至截止日期)
	private Integer xj;//小计
	/** @ --起始时间--qssj--String---- */
	private Date qssj;
	/** @ --截止时间--jzsj--String---- */
	private Date jzsj;
	
	/** 地市机关标志 非数据库字段 */
	private String dsjgbz;
	/** 分县局标志 非数据库字段 */
	private String fxjbz;
	/** 科所队标志 非数据库字段 */
	private String gxdwbz;
	/** 场所标志 非数据库字段 */
	private String csbz;
	private String csbm;//场所编码

	public Integer getAsjtjid() {
		return asjtjid;
	}

	public void setAsjtjid(Integer asjtjid) {
		this.asjtjid = asjtjid;
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

	public String getDsjgmc() {
		return dsjgmc;
	}

	public void setDsjgmc(String dsjgmc) {
		this.dsjgmc = dsjgmc;
	}

	public String getFxjdm() {
		return fxjdm;
	}

	public void setFxjdm(String fxjdm) {
		this.fxjdm = fxjdm;
	}

	public String getDsjgdm() {
		return dsjgdm;
	}

	public void setDsjgdm(String dsjgdm) {
		this.dsjgdm = dsjgdm;
	}

	public String getFxjmc() {
		return fxjmc;
	}

	public void setFxjmc(String fxjmc) {
		this.fxjmc = fxjmc;
	}

	public String getGxdwdm() {
		return gxdwdm;
	}

	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
	}

	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	public Date getTjrq() {
		return tjrq;
	}

	public void setTjrq(Date tjrq) {
		this.tjrq = tjrq;
	}

	public Integer getXsajs() {
		return xsajs;
	}

	public void setXsajs(Integer xsajs) {
		this.xsajs = xsajs;
	}

	public Integer getZzajs() {
		return zzajs;
	}

	public void setZzajs(Integer zzajs) {
		this.zzajs = zzajs;
	}

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

	public Integer getXj() {
		if(xsajs!=null&&zzajs!=null){
			return new Integer(xsajs.intValue()+zzajs.intValue());
		}
		return 0;
	}

	public void setXj(Integer xj) {
		this.xj = xj;
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

	public Integer getFazs() {
		return fazs;
	}

	public void setFazs(Integer fazs) {
		this.fazs = fazs;
	}

	public Integer getXsajsT() {
		return xsajsT;
	}

	public void setXsajsT(Integer xsajsT) {
		this.xsajsT = xsajsT;
	}

	public Integer getZzajsT() {
		return zzajsT;
	}

	public void setZzajsT(Integer zzajsT) {
		this.zzajsT = zzajsT;
	}

	public Integer getFazsT() {
		return fazsT;
	}

	public void setFazsT(Integer fazsT) {
		this.fazsT = fazsT;
	}

	public String getCsbm() {
		return csbm;
	}

	public void setCsbm(String csbm) {
		this.csbm = csbm;
	}
}
