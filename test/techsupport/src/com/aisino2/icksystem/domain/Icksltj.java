package com.aisino2.icksystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Icksltj  {

	/** @param IC卡受理统计(t_icksltj) */

	/** @ --IC卡受理统计ID--icksltjid--Integer--10-- */
	private Integer icksltjid;

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

	/** @ --当前在职人数--dqzzrs--Integer--6-- */
	private Integer dqzzrs;

	/** @ --已受理人数--yslrs--Integer--6-- */
	private Integer yslrs;

	/** @ --发放数--ffs--Integer--6-- */
	private Integer ffs;

	/** @ --状态--zt--String--2-- */
	private String zt;

	/** 分页排序 */
	private String pageSort;

	/** @ IC卡受理统计ID(icksltjid) */
	public Integer getIcksltjid() {
		return icksltjid;
	}

	public void setIcksltjid(Integer icksltjid) {
		this.icksltjid = icksltjid;
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
		this.qybm = qybm;
	}

	/** @ 当前在职人数(dqzzrs) */
	public Integer getDqzzrs() {
		return dqzzrs;
	}

	public void setDqzzrs(Integer dqzzrs) {
		this.dqzzrs = dqzzrs;
	}

	/** @ 已受理人数(yslrs) */
	public Integer getYslrs() {
		return yslrs;
	}

	public void setYslrs(Integer yslrs) {
		this.yslrs = yslrs;
	}

	/** @ 发放数(ffs) */
	public Integer getFfs() {
		return ffs;
	}

	public void setFfs(Integer ffs) {
		this.ffs = ffs;
	}

	/** @ 状态(zt) */
	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
