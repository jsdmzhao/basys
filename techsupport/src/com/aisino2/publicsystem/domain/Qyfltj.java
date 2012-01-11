package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyfltj  {

	/** @param 企业分类统计(t_qyfltj) */

	/** @ --企业分类统计ID--qyfltjid--Integer--10-- */
	private Integer qyfltjid;

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

	/** @ --歌舞娱乐--gwyl--Integer--6-- */
	private Integer gwyl;

	/** @ --游艺场所--yysdzyxt--Integer--6-- */
	private Integer yysdzyxt;

	/** @ --其他娱乐场所--qtylcs--Integer--6-- */
	private Integer qtylcs;

	/** @ --桑拿、洗浴、按摩--snxyam--Integer--6-- */
	private Integer snxyam;

	/** @ --美容美发、足浴--mrmfzy--Integer--6-- */
	private Integer mrmfzy;

	/** @ --其他服务场所--qtfwcs--Integer--6-- */
	private Integer qtfwcs;

	/** @ --周期内新增企业数--hj--Integer--6-- */
	private Integer hj;
	
	/** @ --歌舞娱乐--gwylT--至截止日期-- */
	private Integer gwylT;

	/** @ --游艺场所--yysdzyxtT--至截止日期-- */
	private Integer yysdzyxtT;

	/** @ --其他娱乐场所--qtylcsT--至截止日期-- */
	private Integer qtylcsT;

	/** @ --桑拿、洗浴、按摩--snxyamT--至截止日期-- */
	private Integer snxyamT;

	/** @ --美容美发、足浴--mrmfzyT--至截止日期-- */
	private Integer mrmfzyT;

	/** @ --其他服务场所--qtfwcsT--至截止日期-- */
	private Integer qtfwcsT;

	/** @ --合计--hjT--至截止日期-- */
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
	
	private Integer qczlqy;//汽车租赁企业
	private Integer qczlry;//汽车租赁人员
	private Integer escqy; //二手车企业
	private Integer escry; //二手车人员
	private Integer esjqy; //二手机企业
	private Integer esjry; //二手机人员
	private Integer jxqy;  //机修企业
	private Integer jxry;  //机修人员
	private Integer czcqy; //出租车企业
	private Integer czcry; //出租车人员
	private Integer qyhj;//企业合计
	private Integer ryhj;//人员合计
	public Integer getQyhj() {
		return qyhj;
	}

	public void setQyhj(Integer qyhj) {
		this.qyhj = qyhj;
	}

	public Integer getQczlqy() {
		return qczlqy;
	}

	public void setQczlqy(Integer qczlqy) {
		this.qczlqy = qczlqy;
	}

	public Integer getQczlry() {
		return qczlry;
	}

	public void setQczlry(Integer qczlry) {
		this.qczlry = qczlry;
	}

	public Integer getEscqy() {
		return escqy;
	}

	public void setEscqy(Integer escqy) {
		this.escqy = escqy;
	}

	public Integer getEscry() {
		return escry;
	}

	public void setEscry(Integer escry) {
		this.escry = escry;
	}

	public Integer getEsjqy() {
		return esjqy;
	}

	public void setEsjqy(Integer esjqy) {
		this.esjqy = esjqy;
	}

	public Integer getEsjry() {
		return esjry;
	}

	public void setEsjry(Integer esjry) {
		this.esjry = esjry;
	}

	public Integer getJxqy() {
		return jxqy;
	}

	public void setJxqy(Integer jxqy) {
		this.jxqy = jxqy;
	}

	public Integer getJxry() {
		return jxry;
	}

	public void setJxry(Integer jxry) {
		this.jxry = jxry;
	}

	public Integer getCzcqy() {
		return czcqy;
	}

	public void setCzcqy(Integer czcqy) {
		this.czcqy = czcqy;
	}

	public Integer getCzcry() {
		return czcry;
	}

	public void setCzcry(Integer czcry) {
		this.czcry = czcry;
	}

	/** @ 企业分类统计ID(qyfltjid) */
	public Integer getQyfltjid() {
		return qyfltjid;
	}

	public void setQyfltjid(Integer qyfltjid) {
		this.qyfltjid = qyfltjid;
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

	/** @ 歌舞娱乐(gwyl) */
	public Integer getGwyl() {
		return gwyl;
	}

	public void setGwyl(Integer gwyl) {
		this.gwyl = gwyl;
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

	public Integer getGwylT() {
		return gwylT;
	}

	public void setGwylT(Integer gwylT) {
		this.gwylT = gwylT;
	}


	public Integer getYysdzyxtT() {
		return yysdzyxtT;
	}

	public void setYysdzyxtT(Integer yysdzyxtT) {
		this.yysdzyxtT = yysdzyxtT;
	}




	public Integer getQtylcs() {
		return qtylcs;
	}

	public void setQtylcs(Integer qtylcs) {
		this.qtylcs = qtylcs;
	}

	public Integer getSnxyam() {
		return snxyam;
	}

	public void setSnxyam(Integer snxyam) {
		this.snxyam = snxyam;
	}

	public Integer getMrmfzy() {
		return mrmfzy;
	}

	public void setMrmfzy(Integer mrmfzy) {
		this.mrmfzy = mrmfzy;
	}

	public Integer getQtfwcs() {
		return qtfwcs;
	}

	public void setQtfwcs(Integer qtfwcs) {
		this.qtfwcs = qtfwcs;
	}

	public Integer getHj() {
		return hj;
	}

	public void setHj(Integer hj) {
		this.hj = hj;
	}

	public Integer getQtylcsT() {
		return qtylcsT;
	}

	public void setQtylcsT(Integer qtylcsT) {
		this.qtylcsT = qtylcsT;
	}

	public Integer getSnxyamT() {
		return snxyamT;
	}

	public void setSnxyamT(Integer snxyamT) {
		this.snxyamT = snxyamT;
	}

	public Integer getMrmfzyT() {
		return mrmfzyT;
	}

	public void setMrmfzyT(Integer mrmfzyT) {
		this.mrmfzyT = mrmfzyT;
	}

	public Integer getQtfwcsT() {
		return qtfwcsT;
	}

	public void setQtfwcsT(Integer qtfwcsT) {
		this.qtfwcsT = qtfwcsT;
	}

	public Integer getHjT() {
		return hjT;
	}

	public void setHjT(Integer hjT) {
		this.hjT = hjT;
	}

	public Integer getYysdzyxt() {
		return yysdzyxt;
	}

	public void setYysdzyxt(Integer yysdzyxt) {
		this.yysdzyxt = yysdzyxt;
	}

	public Integer getRyhj() {
		return ryhj;
	}

	public void setRyhj(Integer ryhj) {
		this.ryhj = ryhj;
	}

}
