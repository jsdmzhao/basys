package com.aisino2.publicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class StxzTzxx  {

	/** @param 安全检查设备(t_aqjcsb) */

	/** @ --企业总数--qyzs--Integer--10-- */
	private Integer qyzs;
	
	/** @ --人员总数--qyzs--Integer--10-- */
	private Integer ryzs;
	
	/** @ --上传业务数--qyzs--Integer--10-- */
	private Integer scyws;
	
	/** @ --未上传企业数--qyzs--Integer--10-- */
	private Integer wscqys;
	
	/** @ --截取个数--qyzs--Integer--10-- */
	private Integer subCodeLen;
	
	/** @ --行业类别代码--qyzs--Integer--10-- */
	private String hylbdm;
	
	/** @ --未上传企业数--qyzs--Integer--10-- */
	private String likeDepartCode;
	private String departcode;
	private String departname;
	private String zrs;
	private String qymc;
	/** 分页排序 */
	private String pageSort;


	public Integer getQyzs() {
		return qyzs;
	}


	public void setQyzs(Integer qyzs) {
		this.qyzs = qyzs;
	}


	public Integer getRyzs() {
		return ryzs;
	}


	public void setRyzs(Integer ryzs) {
		this.ryzs = ryzs;
	}


	public Integer getScyws() {
		return scyws;
	}


	public void setScyws(Integer scyws) {
		this.scyws = scyws;
	}


	public Integer getWscqys() {
		return wscqys;
	}


	public void setWscqys(Integer wscqys) {
		this.wscqys = wscqys;
	}


	public String getPageSort() {
		return pageSort;
	}


	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}




	public String getHylbdm() {
		return hylbdm;
	}


	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}


	public String getLikeDepartCode() {
		return likeDepartCode;
	}


	public void setLikeDepartCode(String likeDepartCode) {
		this.likeDepartCode = likeDepartCode;
	}


	public Integer getSubCodeLen() {
		return subCodeLen;
	}


	public void setSubCodeLen(Integer subCodeLen) {
		this.subCodeLen = subCodeLen;
	}


	public String getDepartcode() {
		return departcode;
	}


	public void setDepartcode(String departcode) {
		this.departcode = departcode;
	}


	public String getDepartname() {
		return departname;
	}


	public void setDepartname(String departname) {
		this.departname = departname;
	}


	public String getZrs() {
		return zrs;
	}


	public void setZrs(String zrs) {
		this.zrs = zrs;
	}


	public String getQymc() {
		return qymc;
	}


	public void setQymc(String qymc) {
		this.qymc = qymc;
	}




	
	
}
