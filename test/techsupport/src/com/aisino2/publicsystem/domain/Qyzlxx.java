package com.aisino2.publicsystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Qyzlxx  {

	/** @param 企业质量信息(t_qyzlxx) */

	/** @ --企业质量信息ID--qyzlxxid--Integer--10-- */
	private Integer qyzlxxid;

	/** @ --行业类别代码--hylbdm--String--3-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

	/** @ --发布单位代码--fbdwdm--String--20-- */
	private String fbdwdm;

	/** @ --发布单位名称--fbdwmc--String--60-- */
	private String fbdwmc;

	/** @ --发布人--fbr--String--30-- */
	private String fbr;

	/** @ --发布时间--fbsj--Date---- */
	private Date fbsj;

	/** @ --删除标志--scbz--Integer--2-- */
	private Integer scbz;

	/** 分页排序 */
	private String pageSort;
	
	private String fjnr;

	/** @ --发布截止时间 非数据库字段--fbsj--Date---- */
	private Date fbjzsj;
	
	/**  附件名称，非数据库字段*/	
	private String fjmc;
	
	private List fj_obj;
		
////附件的base64编码
	private String fjbase;
	
/////附件的base64码
	private String fjbase64;
	////附件的名称
	private String fjname;
	
	/////传base64的文件de 专用属性
	private List lXctbfjList;
	
	private List XctbfjListData;
	
	private List lXctbfj;
	
	private Integer  qyzlxx_fjid;
	
	
	
	public Integer getQyzlxx_fjid() {
		return qyzlxx_fjid;
	}

	public void setQyzlxx_fjid(Integer qyzlxx_fjid) {
		this.qyzlxx_fjid = qyzlxx_fjid;
	}

	public List getXctbfjListData() {
		return XctbfjListData;
	}

	public void setXctbfjListData(List xctbfjListData) {
		XctbfjListData = xctbfjListData;
	}

	public String getFjbase64() {
		return fjbase64;
	}

	public void setFjbase64(String fjbase64) {
		this.fjbase64 = fjbase64;
	}

	public String getFjname() {
		return fjname;
	}

	public void setFjname(String fjname) {
		this.fjname = fjname;
	}

	public List getLXctbfjList() {
		return lXctbfjList;
	}

	public void setLXctbfjList(List xctbfjList) {
		lXctbfjList = xctbfjList;
	}

	public String getFjbase() {
		return fjbase;
	}

	public void setFjbase(String fjbase) {
		this.fjbase = fjbase;
	}

	public List getFj_obj() {
		return fj_obj;
	}

	public void setFj_obj(List fj_obj) {
		this.fj_obj = fj_obj;
	}

	public String getFjnr() {
		return fjnr;
	}

	public void setFjnr(String fjnr) {
		this.fjnr = fjnr;
	}

	public String getFjmc() {
		return fjmc;
	}

	public void setFjmc(String fjmc) {
		this.fjmc = fjmc;
	}

	public Date getFbjzsj() {
		return fbjzsj;
	}

	public void setFbjzsj(Date fbjzsj) {
		this.fbjzsj = fbjzsj;
	}

	/** @ 企业质量信息ID(qyzlxxid) */
	public Integer getQyzlxxid() {
		return qyzlxxid;
	}

	public void setQyzlxxid(Integer qyzlxxid) {
		this.qyzlxxid = qyzlxxid;
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

	/** @ 发布单位代码(fbdwdm) */
	public String getFbdwdm() {
		return fbdwdm;
	}

	public void setFbdwdm(String fbdwdm) {
		this.fbdwdm = fbdwdm;
	}

	/** @ 发布单位名称(fbdwmc) */
	public String getFbdwmc() {
		return fbdwmc;
	}

	public void setFbdwmc(String fbdwmc) {
		this.fbdwmc = fbdwmc;
	}

	/** @ 发布人(fbr) */
	public String getFbr() {
		return fbr;
	}

	public void setFbr(String fbr) {
		this.fbr = fbr;
	}

	/** @ 发布时间(fbsj) */
	public Date getFbsj() {
		return fbsj;
	}

	public void setFbsj(Date fbsj) {
		this.fbsj = fbsj;
	}

	/** @ 删除标志(scbz) */
	public Integer getScbz() {
		return scbz;
	}

	public void setScbz(Integer scbz) {
		this.scbz = scbz;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
