package com.aisino2.publicsystem.domain;

import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Pmt  {

	/** @param 平面图(t_pmt) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --平面图ID--pmtid--Integer--10-- */
	private Integer pmtid;

	/** @ --平面图类型代码--pmtlxdm--String--40-- */
	private String pmtlxdm;

	/** @ --平面图类型名称--pmtlxmc--String--100-- */
	private String pmtlxmc;

	/** @ --平面图纸--pmtz--byte[]---- */
	private byte[] pmtz;

	/** @ 平面图临时路径(pmtlslj 非数据库表字段) */
	private String pmtlslj;
	
	/** @ 平面图记录状态(pmtjlzt 非数据库表字段)OLD原有记录， NEW-新增记录，OLD_DELETED-删除原有记录，NEW_DELETED-删除新增(未提交到数据库)记录*/
	private String pmtjlzt;
	
	/** 分页排序 */
	private String pageSort;
	
	/** @ --请求动作：查看、修改 - 查看则不给删除按钮(非数据库字段)- */
	private String pmtRequetType;
	
	/** @ 控件得到的平面图 字符串(非数据库表字段)*/
	private String pmtStringContent;
	
	private List lPmtList;
	
	/** @ 存放新增平面图临时ID(sPmtid 非数据库表字段) */
	private String sPmtid;

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 平面图ID(pmtid) */
	public Integer getPmtid() {
		return pmtid;
	}

	public void setPmtid(Integer pmtid) {
		this.pmtid = pmtid;
	}

	/** @ 平面图类型代码(pmtlxdm) */
	public String getPmtlxdm() {
		return pmtlxdm;
	}

	public void setPmtlxdm(String pmtlxdm) {
		this.pmtlxdm = pmtlxdm;
	}

	/** @ 平面图类型名称(pmtlxmc) */
	public String getPmtlxmc() {
		return pmtlxmc;
	}

	public void setPmtlxmc(String pmtlxmc) {
		this.pmtlxmc = pmtlxmc;
	}

	/** @ 平面图纸(pmtz) */
	public byte[] getPmtz() {
		return pmtz;
	}

	public void setPmtz(byte[] pmtz) {
		this.pmtz = pmtz;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getSPmtid() {
		return sPmtid;
	}

	public void setSPmtid(String pmtid) {
		sPmtid = pmtid;
	}

	public String getPmtlslj() {
		return pmtlslj;
	}

	public void setPmtlslj(String pmtlslj) {
		this.pmtlslj = pmtlslj;
	}

	public String getPmtjlzt() {
		return pmtjlzt;
	}

	public void setPmtjlzt(String pmtjlzt) {
		this.pmtjlzt = pmtjlzt;
	}

	public String getPmtRequetType() {
		return pmtRequetType;
	}

	public void setPmtRequetType(String pmtRequetType) {
		this.pmtRequetType = pmtRequetType;
	}

	public String getPmtStringContent() {
		return pmtStringContent;
	}

	public void setPmtStringContent(String pmtStringContent) {
		this.pmtStringContent = pmtStringContent;
	}

	public List getLPmtList() {
		return lPmtList;
	}

	public void setLPmtList(List pmtList) {
		lPmtList = pmtList;
	}
}
