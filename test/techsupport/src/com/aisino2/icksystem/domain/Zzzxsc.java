package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Zzzxsc  {

	/** @param 制证中心上传(t_zzzxsc) */

	/** @ --IC卡受理ID--ickslid--Integer--10-- */
	private Integer ickslid;

	/** @ --制证中心上传ID--zzzxscid--Integer--10-- */
	private Integer zzzxscid;

	/** @ --数据上传标志--sjscbz--String--2-- */
	private String sjscbz;

	/** @ --发送时间--fssj--Date---- */
	private Date fssj;

	/** @ --回馈时间--hksj--Date---- */
	private Date hksj;

	/** @ --制证中心记录编号--zzzxjlbh--String--60-- */
	private String zzzxjlbh;

	/** @ --制证错误原因--zzcwyy--String--2000-- */
	private String zzcwyy;

	/** 分页排序 */
	private String pageSort;

	/** @ IC卡受理ID(ickslid) */
	public Integer getIckslid() {
		return ickslid;
	}

	public void setIckslid(Integer ickslid) {
		this.ickslid = ickslid;
	}

	/** @ 制证中心上传ID(zzzxscid) */
	public Integer getZzzxscid() {
		return zzzxscid;
	}

	public void setZzzxscid(Integer zzzxscid) {
		this.zzzxscid = zzzxscid;
	}

	/** @ 数据上传标志(sjscbz) */
	public String getSjscbz() {
		return sjscbz;
	}

	public void setSjscbz(String sjscbz) {
		this.sjscbz = sjscbz;
	}

	/** @ 发送时间(fssj) */
	public Date getFssj() {
		return fssj;
	}

	public void setFssj(Date fssj) {
		this.fssj = fssj;
	}

	/** @ 回馈时间(hksj) */
	public Date getHksj() {
		return hksj;
	}

	public void setHksj(Date hksj) {
		this.hksj = hksj;
	}

	/** @ 制证中心记录编号(zzzxjlbh) */
	public String getZzzxjlbh() {
		return zzzxjlbh;
	}

	public void setZzzxjlbh(String zzzxjlbh) {
		this.zzzxjlbh = zzzxjlbh;
	}

	/** @ 制证错误原因(zzcwyy) */
	public String getZzcwyy() {
		return zzcwyy;
	}

	public void setZzcwyy(String zzcwyy) {
		this.zzcwyy = zzcwyy;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
