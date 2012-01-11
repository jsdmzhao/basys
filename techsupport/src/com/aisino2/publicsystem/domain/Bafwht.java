package com.aisino2.publicsystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Bafwht  {

	/** @param 保安服务合同(t_bafwht) */

	/** @ --保安服务合同ID--bafwhtid--Integer--10-- */
	private Integer bafwhtid;

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --保安服务公司名称--bafwgsmc--String--200-- */
	private String bafwgsmc;

	/** @ --保安人员资格证书名称--baryzgzsmc--String--100-- */
	private String baryzgzsmc;

	/** @ --保安人员培训结束日期--barypxjsrq--Date---- */
	private Date barypxjsrq;

	/** @ --合同编号--htbh--String--30-- */
	private String htbh;

	/** @ --签订日期--qdrq--Date---- */
	private Date qdrq;

	/** @ --结束日期--jsrq--Date---- */
	private Date jsrq;
	
	/** @ --合同有效期--htyxq--Integer--2-- */
	private Integer htyxq;

	/** @ --保安人员培训内容--barypxnr--String--2000-- */
	private String barypxnr;
	
	/** @ --请求动作：查看、修改 - 查看则不给删除按钮(非数据库字段)- */
	private String bafwhtRequetType;

	/** 分页排序 */
	private String pageSort;
	
	private List lBafwhtList;
	//jsrq是否需要删除结束日期，0-不删除 1-删除
	private String isJsrqNull;
	
	private String balxdm;
	private String balxmc;
	private String fzjgmc;

	/** @ 保安服务合同ID(bafwhtid) */
	public Integer getBafwhtid() {
		return bafwhtid;
	}

	public void setBafwhtid(Integer bafwhtid) {
		this.bafwhtid = bafwhtid;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 保安服务公司名称(bafwgsmc) */
	public String getBafwgsmc() {
		return bafwgsmc;
	}

	public void setBafwgsmc(String bafwgsmc) {
		this.bafwgsmc = bafwgsmc;
	}

	/** @ 保安人员资格证书名称(baryzgzsmc) */
	public String getBaryzgzsmc() {
		return baryzgzsmc;
	}

	public void setBaryzgzsmc(String baryzgzsmc) {
		this.baryzgzsmc = baryzgzsmc;
	}

	/** @ 保安人员培训结束日期(barypxjsrq) */
	public Date getBarypxjsrq() {
		return barypxjsrq;
	}

	public void setBarypxjsrq(Date barypxjsrq) {
		this.barypxjsrq = barypxjsrq;
	}

	/** @ 合同编号(htbh) */
	public String getHtbh() {
		return htbh;
	}

	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}

	/** @ 签订日期(qdrq) */
	public Date getQdrq() {
		return qdrq;
	}

	public void setQdrq(Date qdrq) {
		this.qdrq = qdrq;
	}

	/** @ 结束日期(jsrq) */
	public Date getJsrq() {
		return jsrq;
	}

	public void setJsrq(Date jsrq) {
		this.jsrq = jsrq;
	}

	/** @ 保安人员培训内容(barypxnr) */
	public String getBarypxnr() {
		return barypxnr;
	}

	public void setBarypxnr(String barypxnr) {
		this.barypxnr = barypxnr;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getBafwhtRequetType() {
		return bafwhtRequetType;
	}

	public void setBafwhtRequetType(String bafwhtRequetType) {
		this.bafwhtRequetType = bafwhtRequetType;
	}

	public List getLBafwhtList() {
		return lBafwhtList;
	}

	public void setLBafwhtList(List bafwhtList) {
		lBafwhtList = bafwhtList;
	}

	public Integer getHtyxq() {
		return htyxq;
	}

	public void setHtyxq(Integer htyxq) {
		this.htyxq = htyxq;
	}

	public String getIsJsrqNull() {
		return isJsrqNull;
	}

	public void setIsJsrqNull(String isJsrqNull) {
		this.isJsrqNull = isJsrqNull;
	}

	public String getBalxdm() {
		return balxdm;
	}

	public void setBalxdm(String balxdm) {
		this.balxdm = balxdm;
	}

	public String getBalxmc() {
		return balxmc;
	}

	public void setBalxmc(String balxmc) {
		this.balxmc = balxmc;
	}

	public String getFzjgmc() {
		return fzjgmc;
	}

	public void setFzjgmc(String fzjgmc) {
		this.fzjgmc = fzjgmc;
	}
}
