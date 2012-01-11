package com.aisino2.publicsystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Qybcbaxx  {

	/** @param 企业补充备案信息(t_qybcbaxx) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --企业备案信息ID--qybaxxid--Integer--10-- */
	private Integer qybaxxid;

	/** @ --补备告知日期--bbgzrq--Date---- */
	private Date bbgzrq;

	/** @ --补备原因--bbyy--String--2000-- */
	private String bbyy;

	/** @ --补备完成日期--bbwcrq--Date---- */
	private Date bbwcrq;
	/** 备案信息 */
	private Qybaxx qybaxx;
	
	/** 补备完成日期是否为空 0-不为空，1-空 */
	private String isBbwcrqNull;
	/** 提交材料类型 */
	private List lTjclxx;

	/** 分页排序 */
	private String pageSort;

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 企业备案信息ID(qybaxxid) */
	public Integer getQybaxxid() {
		return qybaxxid;
	}

	public void setQybaxxid(Integer qybaxxid) {
		this.qybaxxid = qybaxxid;
	}

	/** @ 补备告知日期(bbgzrq) */
	public Date getBbgzrq() {
		return bbgzrq;
	}

	public void setBbgzrq(Date bbgzrq) {
		this.bbgzrq = bbgzrq;
	}

	/** @ 补备原因(bbyy) */
	public String getBbyy() {
		return bbyy;
	}

	public void setBbyy(String bbyy) {
		this.bbyy = bbyy;
	}

	/** @ 补备完成日期(bbwcrq) */
	public Date getBbwcrq() {
		return bbwcrq;
	}

	public void setBbwcrq(Date bbwcrq) {
		this.bbwcrq = bbwcrq;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Qybaxx getQybaxx() {
		return qybaxx;
	}

	public void setQybaxx(Qybaxx qybaxx) {
		this.qybaxx = qybaxx;
	}

	public String getIsBbwcrqNull() {
		return isBbwcrqNull;
	}

	public void setIsBbwcrqNull(String isBbwcrqNull) {
		this.isBbwcrqNull = isBbwcrqNull;
	}

	public List getLTjclxx() {
		return lTjclxx;
	}

	public void setLTjclxx(List tjclxx) {
		lTjclxx = tjclxx;
	}
}
