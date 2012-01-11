package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Kycl  {

	/** @param 可疑车辆(t_kycl) */

	/** @ --车辆基本信息ID--cljbxxid--Integer--10-- */
	private Integer cljbxxid;

	/** @ --可疑车辆ID--kyqkclid--Integer--10-- */
	private Integer kyqkclid;

	/** @ --可疑情况类别编码--kyqklbbm--String--2-- */
	private String kyqklbbm;

	/** @ --可疑情况类别--kyqklb--String--100-- */
	private String kyqklb;

	/** @ --疑点详细描述--ydxxms--String--2000-- */
	private String ydxxms;

	/** @ --报告人--bgr--String--30-- */
	private String bgr;

	/** @ --报告时间--bgsj--Date---- */
	private Date bgsj;

	/** 分页排序 */
	private String pageSort;
	
	/** 报告方式代码 */
	private String bgfsdm;
	/** 报告方式 */
	private String bgfs;
	/** 报告人联系方式 */
	private String bgrlsfs;
	/** 接报人 */
	private String jbr;

	public String getBgfsdm() {
		return bgfsdm;
	}

	public void setBgfsdm(String bgfsdm) {
		this.bgfsdm = bgfsdm;
	}

	public String getBgfs() {
		return bgfs;
	}

	public void setBgfs(String bgfs) {
		this.bgfs = bgfs;
	}

	public String getBgrlsfs() {
		return bgrlsfs;
	}

	public void setBgrlsfs(String bgrlsfs) {
		this.bgrlsfs = bgrlsfs;
	}

	public String getJbr() {
		return jbr;
	}

	public void setJbr(String jbr) {
		this.jbr = jbr;
	}

	/** @ 车辆基本信息ID(cljbxxid) */
	public Integer getCljbxxid() {
		return cljbxxid;
	}

	public void setCljbxxid(Integer cljbxxid) {
		this.cljbxxid = cljbxxid;
	}

	/** @ 可疑车辆ID(kyqkclid) */
	public Integer getKyqkclid() {
		return kyqkclid;
	}

	public void setKyqkclid(Integer kyqkclid) {
		this.kyqkclid = kyqkclid;
	}

	/** @ 可疑情况类别编码(kyqklbbm) */
	public String getKyqklbbm() {
		return kyqklbbm;
	}

	public void setKyqklbbm(String kyqklbbm) {
		this.kyqklbbm = kyqklbbm;
	}

	/** @ 可疑情况类别(kyqklb) */
	public String getKyqklb() {
		return kyqklb;
	}

	public void setKyqklb(String kyqklb) {
		this.kyqklb = kyqklb;
	}

	/** @ 疑点详细描述(ydxxms) */
	public String getYdxxms() {
		return ydxxms;
	}

	public void setYdxxms(String ydxxms) {
		this.ydxxms = ydxxms;
	}

	/** @ 报告人(bgr) */
	public String getBgr() {
		return bgr;
	}

	public void setBgr(String bgr) {
		this.bgr = bgr;
	}

	/** @ 报告时间(bgsj) */
	public Date getBgsj() {
		return bgsj;
	}

	public void setBgsj(Date bgsj) {
		this.bgsj = bgsj;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
