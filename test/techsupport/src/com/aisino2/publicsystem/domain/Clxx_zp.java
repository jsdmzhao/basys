package com.aisino2.publicsystem.domain;

import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Clxx_zp  {

	/** @param 车辆信息_照片(t_clxx_zp) */

	/** @ --车辆基本信息ID--cljbxxid--Integer--10-- */
	private Integer cljbxxid;

	/** @ --车辆信息照片ID--clxxzpid--Integer--10-- */
	private Integer clxxzpid;

	/** @ --图片名称--tpmc--String--100-- */
	private String tpmc;

	/** @ --图片类型--tplx--String--40-- */
	private String tplx;

	/** @ --图片内容--tpnr--byte[]---- */
	private byte[] tpnr;
	
	//图片内容中转Bean
	private String tempTpmc;//临时文件名
	
	private String czcclxxzpContent;//base64串

	private String sclxxzpid;//车辆照片临时主键
	private List lClzpList;// 车辆照片
	private String clxxzpStringContent;
	private String rowId;//照片所在行

	/** @ --照片是否删除 0：不删除，1：删除 */
	private String zpsfsc;

	/** 分页排序 */
	private String pageSort;

	public String getTempTpmc() {
		return tempTpmc;
	}

	public void setTempTpmc(String tempTpmc) {
		this.tempTpmc = tempTpmc;
	}

	public String getCzcclxxzpContent() {
		return czcclxxzpContent;
	}

	public void setCzcclxxzpContent(String czcclxxzpContent) {
		this.czcclxxzpContent = czcclxxzpContent;
	}

	public String getZpsfsc() {
		return zpsfsc;
	}

	public void setZpsfsc(String zpsfsc) {
		this.zpsfsc = zpsfsc;
	}

	/** @ 车辆基本信息ID(cljbxxid) */
	public Integer getCljbxxid() {
		return cljbxxid;
	}

	public void setCljbxxid(Integer cljbxxid) {
		this.cljbxxid = cljbxxid;
	}

	/** @ 车辆信息照片ID(clxxzpid) */
	public Integer getClxxzpid() {
		return clxxzpid;
	}

	public void setClxxzpid(Integer clxxzpid) {
		this.clxxzpid = clxxzpid;
	}

	/** @ 图片名称(tpmc) */
	public String getTpmc() {
		return tpmc;
	}

	public void setTpmc(String tpmc) {
		this.tpmc = tpmc;
	}

	/** @ 图片类型(tplx) */
	public String getTplx() {
		return tplx;
	}

	public void setTplx(String tplx) {
		this.tplx = tplx;
	}

	/** @ 图片内容(tpnr) */
	public byte[] getTpnr() {
		return tpnr;
	}

	public void setTpnr(byte[] tpnr) {
		this.tpnr = tpnr;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getSclxxzpid() {
		return sclxxzpid;
	}

	public void setSclxxzpid(String sclxxzpid) {
		this.sclxxzpid = sclxxzpid;
	}

	public List getLClzpList() {
		return lClzpList;
	}

	public void setLClzpList(List clzpList) {
		lClzpList = clzpList;
	}

	public String getClxxzpStringContent() {
		return clxxzpStringContent;
	}

	public void setClxxzpStringContent(String clxxzpStringContent) {
		this.clxxzpStringContent = clxxzpStringContent;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
}
