package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Rylbtj  {

	/** @param 人员类别统计(t_rylbtj) */

	/** @ --人员类别统计ID--rybtjid--Integer--10-- */
	private Integer rybtjid;

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

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --企业名称--qymc--String--120-- */
	private String qymc;

	/** @ --管理人员--glry--Integer--6-- */
	private Integer glry;

	/** @ --法定代表人或主要负责人--fddbr--Integer--6-- */
	private Integer fddbr;

	/** @ --主要股东组成人员--zygdzcry--Integer--6-- */
	private Integer zygdzcry;

	/** @ --治安负责人--zafzr--Integer--6-- */
	private Integer zafzr;

	/** @ --其他管理人员--qtglry--Integer--6-- */
	private Integer qtglry;

	/** @ --服务人员--fwry--Integer--6-- */
	private Integer fwry;

	/** @ --一般服务人员--ybfwry--Integer--6-- */
	private Integer ybfwry;

	/** @ --临时服务人员--lsfwry--Integer--6-- */
	private Integer lsfwry;

	/** @ --演艺人员--yyry--Integer--6-- */
	private Integer yyry;

	/** @ --其他服务人员--qtfwry--Integer--6-- */
	private Integer qtfwry;

	/** @ --保安人员--bary--Integer--6-- */
	private Integer bary;

	/** @ --安全检查人员--aqjcry--Integer--6-- */
	private Integer aqjcry;

	/** @ --其他--qt--Integer--6-- */
	private Integer qt;

	/** @ --合计--hj--Integer--6-- */
	private Integer hj;
	
	/** @ --管理人员--glryT--至截止日期-- */
	private Integer glryT;
	
	/** @ --服务人员--fwryT--至截止日期-- */
	private Integer fwryT;
	
	/** @ --保安人员--baryT--至截止日期-- */
	private Integer baryT;

	/** @ --安全检查人员--aqjcryT--至截止日期-- */
	private Integer aqjcryT;

	/** @ --其他--qtT--至截止日期-- */
	private Integer qtT;
	
	/** @ --合计--hjT--至截止日期-- */
	private Integer hjT;
	
	private String csbm;//场所编码
	
	/** @ --地市机关 标志 非数据库字段 */
	private String dsjgbz;

	/** @ --分县局代码 标志 非数据库字段 */
	private String fxjbz;

	/** @ --管辖单位代码 标志 非数据库字段 */
	private String gxdwbz;
	
	/** @ --场所代码 标志 非数据库字段 */
	private String csbz;

	/** 分页排序 */
	private String pageSort;
	
	/** @ --起始日期 非数据库字段 */
	private Date qsrq;

	/** @ --截止日期 非数据库字段 */
	private Date jzrq;
	
	private Integer qczlry;//汽车租赁人员
	private Integer escry; //二手车人员
	private Integer esjry; //二手机人员
	private Integer jxry;  //机修人员
	private Integer czcry; //出租车人员
	private Integer ryhj;//企业合计
	private String deptleave;
	private String deptcode;

	public String getDeptleave() {
		return deptleave;
	}

	public void setDeptleave(String deptleave) {
		this.deptleave = deptleave;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
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

	/** @ 人员类别统计ID(rybtjid) */
	public Integer getRybtjid() {
		return rybtjid;
	}

	public void setRybtjid(Integer rybtjid) {
		this.rybtjid = rybtjid;
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

	/** @ 管理人员(glry) */
	public Integer getGlry() {
		return glry;
	}

	public void setGlry(Integer glry) {
		this.glry = glry;
	}

	/** @ 法定代表人或主要负责人(fddbr) */
	public Integer getFddbr() {
		return fddbr;
	}

	public void setFddbr(Integer fddbr) {
		this.fddbr = fddbr;
	}

	/** @ 主要股东组成人员(zygdzcry) */
	public Integer getZygdzcry() {
		return zygdzcry;
	}

	public void setZygdzcry(Integer zygdzcry) {
		this.zygdzcry = zygdzcry;
	}

	/** @ 治安负责人(zafzr) */
	public Integer getZafzr() {
		return zafzr;
	}

	public void setZafzr(Integer zafzr) {
		this.zafzr = zafzr;
	}

	/** @ 其他管理人员(qtglry) */
	public Integer getQtglry() {
		return qtglry;
	}

	public void setQtglry(Integer qtglry) {
		this.qtglry = qtglry;
	}

	/** @ 服务人员(fwry) */
	public Integer getFwry() {
		return fwry;
	}

	public void setFwry(Integer fwry) {
		this.fwry = fwry;
	}

	/** @ 一般服务人员(ybfwry) */
	public Integer getYbfwry() {
		return ybfwry;
	}

	public void setYbfwry(Integer ybfwry) {
		this.ybfwry = ybfwry;
	}

	/** @ 临时服务人员(lsfwry) */
	public Integer getLsfwry() {
		return lsfwry;
	}

	public void setLsfwry(Integer lsfwry) {
		this.lsfwry = lsfwry;
	}

	/** @ 演艺人员(yyry) */
	public Integer getYyry() {
		return yyry;
	}

	public void setYyry(Integer yyry) {
		this.yyry = yyry;
	}

	/** @ 其他服务人员(qtfwry) */
	public Integer getQtfwry() {
		return qtfwry;
	}

	public void setQtfwry(Integer qtfwry) {
		this.qtfwry = qtfwry;
	}

	/** @ 保安人员(bary) */
	public Integer getBary() {
		return bary;
	}

	public void setBary(Integer bary) {
		this.bary = bary;
	}

	/** @ 安全检查人员(aqjcry) */
	public Integer getAqjcry() {
		return aqjcry;
	}

	public void setAqjcry(Integer aqjcry) {
		this.aqjcry = aqjcry;
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

	public Integer getGlryT() {
		return glryT;
	}

	public void setGlryT(Integer glryT) {
		this.glryT = glryT;
	}

	public Integer getFwryT() {
		return fwryT;
	}

	public void setFwryT(Integer fwryT) {
		this.fwryT = fwryT;
	}

	public Integer getBaryT() {
		return baryT;
	}

	public void setBaryT(Integer baryT) {
		this.baryT = baryT;
	}

	public Integer getAqjcryT() {
		return aqjcryT;
	}

	public void setAqjcryT(Integer aqjcryT) {
		this.aqjcryT = aqjcryT;
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

	public Integer getQczlry() {
		return qczlry;
	}

	public void setQczlry(Integer qczlry) {
		this.qczlry = qczlry;
	}

	public Integer getEscry() {
		return escry;
	}

	public void setEscry(Integer escry) {
		this.escry = escry;
	}

	public Integer getEsjry() {
		return esjry;
	}

	public void setEsjry(Integer esjry) {
		this.esjry = esjry;
	}

	public Integer getJxry() {
		return jxry;
	}

	public void setJxry(Integer jxry) {
		this.jxry = jxry;
	}

	public Integer getCzcry() {
		return czcry;
	}

	public void setCzcry(Integer czcry) {
		this.czcry = czcry;
	}

	public Integer getRyhj() {
		return ryhj;
	}

	public void setRyhj(Integer ryhj) {
		this.ryhj = ryhj;
	}

}
