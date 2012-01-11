package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qycf  {

	/** @param 企业处罚(t_qycf) */

	/** @ --企业处罚ID--qycfid--Integer--10-- */
	private Integer qycfid;

	/** @ --行业类别--hylb--String--100-- */
	private String hylb;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --企业名称--qymc--String--200-- */
	private String qymc;

	/** @ --所属单位编码--ssdwbm--String--20-- */
	private String ssdwbm;

	/** @ --所属单位名称--ssdwmc--String--100-- */
	private String ssdwmc;

	/** @ --违规情况描述--wgqkms--String--2000-- */
	private String wgqkms;

	/** @ --处罚依据--cfyj--String--2000-- */
	private String cfyj;

	/** @ --处罚类型--cflx--String--60-- */
	private String cflx;

	/** @ --处罚结果--cfjg--String--2000-- */
	private String cfjg;

	/** @ --批准机构编码--pzjgbm--String--20-- */
	private String pzjgbm;

	/** @ --批准机构名称--pzjgmc--String--100-- */
	private String pzjgmc;

	/** @ --批准人姓名--pzrxm--String--100-- */
	private String pzrxm;

	/** @ --处罚执行人姓名--cfzxrxm--String--100-- */
	private String cfzxrxm;

	/** @ --处罚日期--cfrq--Date---- */
	private Date cfrq;
	
	/** @ --处罚日期--cfrq--Date---- */
	private Date cfrq2;

	/** @ --登记时间--djsj--Date---- */
	private Date djsj;

	/** @ --登记人--djr--String--30-- */
	private String djr;
	/** @ --奖惩类别代码--cflbbm--String--2-- */
	private String cflbbm;

	/** @ --奖惩类别--cflb--String--100-- */
	private String cflb;
	/** 分页排序 */
	private String pageSort;
	
	/**  */
	private String hylbdm;
	
	/**  */
	private String bz;
	
	/**  */
	private String cfjgdm;

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getCfjgdm() {
		return cfjgdm;
	}

	public void setCfjgdm(String cfjgdm) {
		this.cfjgdm = cfjgdm;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	/** @ 企业处罚ID(qycfid) */
	public Integer getQycfid() {
		return qycfid;
	}
	
	/** 标志位*/
	public String flag;
	

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setQycfid(Integer qycfid) {
		this.qycfid = qycfid;
	}

	/** @ 行业类别(hylb) */
	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
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

	/** @ 所属单位编码(ssdwbm) */
	public String getSsdwbm() {
		return ssdwbm;
	}

	public void setSsdwbm(String ssdwbm) {
		this.ssdwbm = ssdwbm;
	}

	/** @ 所属单位名称(ssdwmc) */
	public String getSsdwmc() {
		return ssdwmc;
	}

	public void setSsdwmc(String ssdwmc) {
		this.ssdwmc = ssdwmc;
	}

	/** @ 违规情况描述(wgqkms) */
	public String getWgqkms() {
		return wgqkms;
	}

	public void setWgqkms(String wgqkms) {
		this.wgqkms = wgqkms;
	}

	/** @ 处罚依据(cfyj) */
	public String getCfyj() {
		return cfyj;
	}

	public void setCfyj(String cfyj) {
		this.cfyj = cfyj;
	}

	/** @ 处罚类型(cflx) */
	public String getCflx() {
		return cflx;
	}

	public void setCflx(String cflx) {
		this.cflx = cflx;
	}

	/** @ 处罚结果(cfjg) */
	public String getCfjg() {
		return cfjg;
	}

	public void setCfjg(String cfjg) {
		this.cfjg = cfjg;
	}

	/** @ 批准机构编码(pzjgbm) */
	public String getPzjgbm() {
		return pzjgbm;
	}

	public void setPzjgbm(String pzjgbm) {
		this.pzjgbm = pzjgbm;
	}

	/** @ 批准机构名称(pzjgmc) */
	public String getPzjgmc() {
		return pzjgmc;
	}

	public void setPzjgmc(String pzjgmc) {
		this.pzjgmc = pzjgmc;
	}

	/** @ 批准人姓名(pzrxm) */
	public String getPzrxm() {
		return pzrxm;
	}

	public void setPzrxm(String pzrxm) {
		this.pzrxm = pzrxm;
	}

	/** @ 处罚执行人姓名(cfzxrxm) */
	public String getCfzxrxm() {
		return cfzxrxm;
	}

	public void setCfzxrxm(String cfzxrxm) {
		this.cfzxrxm = cfzxrxm;
	}

	/** @ 处罚日期(cfrq) */
	public Date getCfrq() {
		return cfrq;
	}

	public void setCfrq(Date cfrq) {
		this.cfrq = cfrq;
	}

	/** @ 登记时间(djsj) */
	public Date getDjsj() {
		return djsj;
	}

	public void setDjsj(Date djsj) {
		this.djsj = djsj;
	}

	/** @ 登记人(djr) */
	public String getDjr() {
		return djr;
	}

	public void setDjr(String djr) {
		this.djr = djr;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getCfrq2() {
		return cfrq2;
	}

	public void setCfrq2(Date cfrq2) {
		this.cfrq2 = cfrq2;
	}

	public String getCflbbm() {
		return cflbbm;
	}

	public void setCflbbm(String cflbbm) {
		this.cflbbm = cflbbm;
	}

	public String getCflb() {
		return cflb;
	}

	public void setCflb(String cflb) {
		this.cflb = cflb;
	}
}
