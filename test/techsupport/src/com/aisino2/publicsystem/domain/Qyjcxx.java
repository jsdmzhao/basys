package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyjcxx  {

	/** @param 企业奖惩信息(t_qyjcxx) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;
	/** @ --企业名称--qymc--Integer--10-- */
	private String qymc;
	/** @ --企业编码--qybm--Integer--10-- */
	private String qybm;

	/** @ --企业处罚ID--qycfid--Integer--10-- */
	private Integer qycfid;

	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

	/** @ --企业奖惩日期--qyjcrq--Date---- */
	private Date qyjcrq;
	/** @ --企业奖惩日期zhi--qyjcrqzhi--Date---- */
	private Date qyjcrqzhi;

	/** @ --处罚登记序号--cfdjxh--String--30-- */
	private String cfdjxh;

	/** @ --奖惩类别代码--cflbbm--String--2-- */
	private String cflbbm;

	/** @ --奖惩类别--cflb--String--100-- */
	private String cflb;

	/** @ --奖惩明细类别代码--jcmxlbdm--String--2-- */
	private String jcmxlbdm;

	/** @ --奖惩明细类别--jcmxlb--String--100-- */
	private String jcmxlb;

	/** @ --行政处罚批准文号--xzcfpzwh--String--20-- */
	private String xzcfpzwh;

	/** @ --批准机构代码--pzjgdm--String--20-- */
	private String pzjgdm;

	/** @ --批准机构--pzjg--String--100-- */
	private String pzjg;

	/** @ --批准人编号--pzrbh--String--30-- */
	private String pzrbh;

	/** @ --批准人姓名--pzrxm--String--100-- */
	private String pzrxm;

	/** @ --批准日期--pzrq--Date---- */
	private Date pzrq;

	/** @ --执行人编号--zxrbh--String--30-- */
	private String zxrbh;

	/** @ --执行人姓名--zxrxm--String--100-- */
	private String zxrxm;

	/** @ --执行日期--zxrq--Date---- */
	private Date zxrq;

	/** @ --情况描述--qkms--String--2000-- */
	private String qkms;

	/** @ --依据理由--yjly--String--2000-- */
	private String yjly;

	/** @ --奖惩幅度--jcfd--String--100-- */
	private String jcfd;

	/** @ --被奖惩人--bjcr--String--100-- */
	private String bjcr;
	/** @ --删除标志--scbz--String--100-- */
	private int scbz;
	
	/** @ --导出标识--dcbs--Integer--2-- */
	private Integer dcbs;
	
	private String zxbz;
	/** 分页排序 */
	private String pageSort;

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 企业处罚ID(qycfid) */
	public Integer getQycfid() {
		return qycfid;
	}

	public void setQycfid(Integer qycfid) {
		this.qycfid = qycfid;
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

	/** @ 企业奖惩日期(qyjcrq) */
	public Date getQyjcrq() {
		return qyjcrq;
	}

	public void setQyjcrq(Date qyjcrq) {
		this.qyjcrq = qyjcrq;
	}

	/** @ 处罚登记序号(cfdjxh) */
	public String getCfdjxh() {
		return cfdjxh;
	}

	public void setCfdjxh(String cfdjxh) {
		this.cfdjxh = cfdjxh;
	}

	/** @ 奖惩类别代码(cflbbm) */
	public String getCflbbm() {
		return cflbbm;
	}

	public void setCflbbm(String cflbbm) {
		this.cflbbm = cflbbm;
	}

	/** @ 奖惩类别(cflb) */
	public String getCflb() {
		return cflb;
	}

	public void setCflb(String cflb) {
		this.cflb = cflb;
	}

	/** @ 奖惩明细类别代码(jcmxlbdm) */
	public String getJcmxlbdm() {
		return jcmxlbdm;
	}

	public void setJcmxlbdm(String jcmxlbdm) {
		this.jcmxlbdm = jcmxlbdm;
	}

	/** @ 奖惩明细类别(jcmxlb) */
	public String getJcmxlb() {
		return jcmxlb;
	}

	public void setJcmxlb(String jcmxlb) {
		this.jcmxlb = jcmxlb;
	}

	/** @ 行政处罚批准文号(xzcfpzwh) */
	public String getXzcfpzwh() {
		return xzcfpzwh;
	}

	public void setXzcfpzwh(String xzcfpzwh) {
		this.xzcfpzwh = xzcfpzwh;
	}

	/** @ 批准机构代码(pzjgdm) */
	public String getPzjgdm() {
		return pzjgdm;
	}

	public void setPzjgdm(String pzjgdm) {
		this.pzjgdm = pzjgdm;
	}

	/** @ 批准机构(pzjg) */
	public String getPzjg() {
		return pzjg;
	}

	public void setPzjg(String pzjg) {
		this.pzjg = pzjg;
	}

	/** @ 批准人编号(pzrbh) */
	public String getPzrbh() {
		return pzrbh;
	}

	public void setPzrbh(String pzrbh) {
		this.pzrbh = pzrbh;
	}

	/** @ 批准人姓名(pzrxm) */
	public String getPzrxm() {
		return pzrxm;
	}

	public void setPzrxm(String pzrxm) {
		this.pzrxm = pzrxm;
	}

	/** @ 批准日期(pzrq) */
	public Date getPzrq() {
		return pzrq;
	}

	public void setPzrq(Date pzrq) {
		this.pzrq = pzrq;
	}

	/** @ 执行人编号(zxrbh) */
	public String getZxrbh() {
		return zxrbh;
	}

	public void setZxrbh(String zxrbh) {
		this.zxrbh = zxrbh;
	}

	/** @ 执行人姓名(zxrxm) */
	public String getZxrxm() {
		return zxrxm;
	}

	public void setZxrxm(String zxrxm) {
		this.zxrxm = zxrxm;
	}

	/** @ 执行日期(zxrq) */
	public Date getZxrq() {
		return zxrq;
	}

	public void setZxrq(Date zxrq) {
		this.zxrq = zxrq;
	}

	/** @ 情况描述(qkms) */
	public String getQkms() {
		return qkms;
	}

	public void setQkms(String qkms) {
		this.qkms = qkms;
	}

	/** @ 依据理由(yjly) */
	public String getYjly() {
		return yjly;
	}

	public void setYjly(String yjly) {
		this.yjly = yjly;
	}

	/** @ 奖惩幅度(jcfd) */
	public String getJcfd() {
		return jcfd;
	}

	public void setJcfd(String jcfd) {
		this.jcfd = jcfd;
	}

	/** @ 被奖惩人(bjcr) */
	public String getBjcr() {
		return bjcr;
	}

	public void setBjcr(String bjcr) {
		this.bjcr = bjcr;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}

	public Date getQyjcrqzhi() {
		return qyjcrqzhi;
	}

	public void setQyjcrqzhi(Date qyjcrqzhi) {
		this.qyjcrqzhi = qyjcrqzhi;
	}

	public int getScbz() {
		return scbz;
	}

	public Integer getDcbs() {
		return dcbs;
	}

	public void setDcbs(Integer dcbs) {
		this.dcbs = dcbs;
	}

	public void setScbz(int scbz) {
		this.scbz = scbz;
	}

	public String getZxbz() {
		return zxbz;
	}

	public void setZxbz(String zxbz) {
		this.zxbz = zxbz;
	}

}
