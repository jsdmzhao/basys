package com.aisino2.publicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Qyryxxtj  {

	/** @param 企业人员信息统计表(t_qyryxxtj) */

	/** @ --企业人员信息统计ID--qyryxxtj--Integer--10-- */
	private Integer qyryxxtj;

	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

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

	/** @ --企业名称--qymc--String--120-- */
	private String qymc;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --总人数--zrs--Integer--6-- */
	private Integer zrs;

	/** @ --当月注册人数--dyzcrs--Integer--6-- */
	private Integer dyzcrs;

	/** @ --当月离职人数--dylzrs--Integer--6-- */
	private Integer dylzrs;

	/** @ --最近7日注册人数--zjqrzcrs--Integer--6-- */
	private Integer zjqrzcrs;

	/** @ --最近7日离职人数--zjqrlzrs--Integer--6-- */
	private Integer zjqrlzrs;

	/** @ --当前在职人数--dqzzrs--Integer--6-- */
	private Integer dqzzrs;

	/** @ --最低刷卡比--zdskb--Float--5,2-- */
	private Float zdskb;

	/** @ --前一日刷卡数--qyrsks--Integer--6-- */
	private Integer qyrsks;

	/** @ --状态代码--ztdm--String--2-- */
	private String ztdm;

	/** 分页排序 */
	private String pageSort;
	
	
	/** 地市机关标志 非数据库字段 */
	private String dsjgbz;
	/** 分县局标志 非数据库字段 */
	private String fxjbz;
	/** 科所队标志 非数据库字段 */
	private String gxdwbz;
	/** 场所标志 非数据库字段 */
	private String csbz;
	private String csbm;//场所编码
	
	
	

	/** @ 企业人员信息统计ID(qyryxxtj) */
	public Integer getQyryxxtj() {
		return qyryxxtj;
	}

	public void setQyryxxtj(Integer qyryxxtj) {
		this.qyryxxtj = qyryxxtj;
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

	/** @ 总人数(zrs) */
	public Integer getZrs() {
		return zrs;
	}

	public void setZrs(Integer zrs) {
		this.zrs = zrs;
	}

	/** @ 当月注册人数(dyzcrs) */
	public Integer getDyzcrs() {
		return dyzcrs;
	}

	public void setDyzcrs(Integer dyzcrs) {
		this.dyzcrs = dyzcrs;
	}

	/** @ 当月离职人数(dylzrs) */
	public Integer getDylzrs() {
		return dylzrs;
	}

	public void setDylzrs(Integer dylzrs) {
		this.dylzrs = dylzrs;
	}

	/** @ 最近7日注册人数(zjqrzcrs) */
	public Integer getZjqrzcrs() {
		return zjqrzcrs;
	}

	public void setZjqrzcrs(Integer zjqrzcrs) {
		this.zjqrzcrs = zjqrzcrs;
	}

	/** @ 最近7日离职人数(zjqrlzrs) */
	public Integer getZjqrlzrs() {
		return zjqrlzrs;
	}

	public void setZjqrlzrs(Integer zjqrlzrs) {
		this.zjqrlzrs = zjqrlzrs;
	}

	/** @ 当前在职人数(dqzzrs) */
	public Integer getDqzzrs() {
		return dqzzrs;
	}

	public void setDqzzrs(Integer dqzzrs) {
		this.dqzzrs = dqzzrs;
	}

	/** @ 最低刷卡比(zdskb) */
	public Float getZdskb() {
		return zdskb;
	}

	public void setZdskb(Float zdskb) {
		this.zdskb = zdskb;
	}

	/** @ 前一日刷卡数(qyrsks) */
	public Integer getQyrsks() {
		return qyrsks;
	}

	public void setQyrsks(Integer qyrsks) {
		this.qyrsks = qyrsks;
	}

	/** @ 状态代码(ztdm) */
	public String getZtdm() {
		return ztdm;
	}

	public void setZtdm(String ztdm) {
		this.ztdm = ztdm;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
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

	public String getCsbm() {
		return csbm;
	}

	public void setCsbm(String csbm) {
		this.csbm = csbm;
	}
}
