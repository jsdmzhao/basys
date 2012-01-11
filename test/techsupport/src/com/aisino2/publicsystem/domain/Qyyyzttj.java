package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyyyzttj  {

	/** @param 企业营业状态统计(t_qyyyzttj) */

	/** @ --企业营业状态统计ID--qyyyzttjid--Integer--10-- */
	private Integer qyyyzttjid;

	/** @ --统计日期--tjrq--Date---- */
	private Date tjrq;

	/** @ --行业类别代码--hylbdm--String--3-- */
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

	/** @ --营业--yy--Integer--6-- */
	private Integer yy;

	/** @ --自主停业--zzty--Integer--6-- */
	private Integer zzty;

	/** @ --勒令停业--llty--Integer--6-- */
	private Integer llty;

	/** @ --歇业--xy--Integer--6-- */
	private Integer xy;

	/** @ --注销--zx--Integer--6-- */
	private Integer zx;

	/** @ --其他--qt--Integer--6-- */
	private Integer qt;

	/** @ --合计--hj--Integer--6-- */
	private Integer hj;
	
	/** @ --营业（至截止日期）--yyT--Integer--6-- */
	private Integer yyT;

	/** @ --自主停业（至截止日期）--zztyT--Integer--6-- */
	private Integer zztyT;

	/** @ --勒令停业（至截止日期）--lltyT--Integer--6-- */
	private Integer lltyT;

	/** @ --歇业（至截止日期）--xyT--Integer--6-- */
	private Integer xyT;

	/** @ --注销（至截止日期）--zxT--Integer--6-- */
	private Integer zxT;

	/** @ --其他（至截止日期）--qtT--Integer--6-- */
	private Integer qtT;

	/** @ --合计（至截止日期）--hjT--Integer--6-- */
	private Integer hjT;

	/** 分页排序 */
	private String pageSort;
	
	/** @ --地市机关 标志 非数据库字段 */
	private String dsjgbz;

	/** @ --分县局代码 标志 非数据库字段 */
	private String fxjbz;

	/** @ --管辖单位代码 标志 非数据库字段 */
	private String gxdwbz;
	
	/** @ --起始日期 非数据库字段 */
	private Date qsrq;

	/** @ --截止日期 非数据库字段 */
	private Date jzrq;

	/** @ 企业营业状态统计ID(qyyyzttjid) */
	public Integer getQyyyzttjid() {
		return qyyyzttjid;
	}

	public void setQyyyzttjid(Integer qyyyzttjid) {
		this.qyyyzttjid = qyyyzttjid;
	}

	/** @ 统计日期(tjrq) */
	public Date getTjrq() {
		return tjrq;
	}

	public void setTjrq(Date tjrq) {
		this.tjrq = tjrq;
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

	/** @ 营业(yy) */
	public Integer getYy() {
		return yy;
	}

	public void setYy(Integer yy) {
		this.yy = yy;
	}

	/** @ 自主停业(zzty) */
	public Integer getZzty() {
		return zzty;
	}

	public void setZzty(Integer zzty) {
		this.zzty = zzty;
	}

	/** @ 勒令停业(llty) */
	public Integer getLlty() {
		return llty;
	}

	public void setLlty(Integer llty) {
		this.llty = llty;
	}

	/** @ 歇业(xy) */
	public Integer getXy() {
		return xy;
	}

	public void setXy(Integer xy) {
		this.xy = xy;
	}

	/** @ 注销(zx) */
	public Integer getZx() {
		return zx;
	}

	public void setZx(Integer zx) {
		this.zx = zx;
	}

	/** @ 其他(qt) */
	public Integer getQt() {
		return qt;
	}

	public void setQt(Integer qt) {
		this.qt = qt;
	}

	/** @ 合计(hj) */
	public Integer getHj() {
		return hj;
	}

	public void setHj(Integer hj) {
		this.hj = hj;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Integer getYyT() {
		return yyT;
	}

	public void setYyT(Integer yyT) {
		this.yyT = yyT;
	}

	public Integer getZztyT() {
		return zztyT;
	}

	public void setZztyT(Integer zztyT) {
		this.zztyT = zztyT;
	}

	public Integer getLltyT() {
		return lltyT;
	}

	public void setLltyT(Integer lltyT) {
		this.lltyT = lltyT;
	}

	public Integer getXyT() {
		return xyT;
	}

	public void setXyT(Integer xyT) {
		this.xyT = xyT;
	}

	public Integer getZxT() {
		return zxT;
	}

	public void setZxT(Integer zxT) {
		this.zxT = zxT;
	}

	public Integer getQtT() {
		return qtT;
	}

	public void setQtT(Integer qtT) {
		this.qtT = qtT;
	}

	public Integer getHjT() {
		return hjT;
	}

	public void setHjT(Integer hjT) {
		this.hjT = hjT;
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
}
