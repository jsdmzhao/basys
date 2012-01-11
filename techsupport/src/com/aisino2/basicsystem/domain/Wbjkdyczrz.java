package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Wbjkdyczrz  {

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) */

	/** @ --操作日志id--czrzid--Integer--10-- */
	private Integer czrzid;

	/** @ --操作账号--czzh--String--30-- */
	private String czzh;

	/** @ --操作公司名称--czgsmc--String--100-- */
	private String czgsmc;

	/** @ --操作时间--czsj--Date---- */
	private Date czsj;

	/** @ --调用接口名称--dyjkmc--String--30-- */
	private String dyjkmc;

	/** @ --操作类型--czlx--String--20-- */
	private String czlx;

	/** @ --总共条数--zgts--Integer--10-- */
	private Integer zgts;

	/** @ --操作结果--czjg--String--20-- */
	private String czjg;

	/** @ --成功条数--cgts--Integer--10-- */
	private Integer cgts;

	/** @ --失败条数--sbts--Integer--10-- */
	private Integer sbts;

	/** @ --行业名称--hymc--String--100-- */
	private String hymc;

	/** @ --行业编码--hybm--String--30-- */
	private String hybm;

	/** 分页排序 */
	private String pageSort;

	/** @ 操作日志id(czrzid) */
	public Integer getCzrzid() {
		return czrzid;
	}

	public void setCzrzid(Integer czrzid) {
		this.czrzid = czrzid;
	}

	/** @ 操作账号(czzh) */
	public String getCzzh() {
		return czzh;
	}

	public void setCzzh(String czzh) {
		this.czzh = czzh;
	}

	/** @ 操作公司名称(czgsmc) */
	public String getCzgsmc() {
		return czgsmc;
	}

	public void setCzgsmc(String czgsmc) {
		this.czgsmc = czgsmc;
	}

	/** @ 操作时间(czsj) */
	public Date getCzsj() {
		return czsj;
	}

	public void setCzsj(Date czsj) {
		this.czsj = czsj;
	}

	/** @ 调用接口名称(dyjkmc) */
	public String getDyjkmc() {
		return dyjkmc;
	}

	public void setDyjkmc(String dyjkmc) {
		this.dyjkmc = dyjkmc;
	}

	/** @ 操作类型(czlx) */
	public String getCzlx() {
		return czlx;
	}

	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}

	/** @ 总共条数(zgts) */
	public Integer getZgts() {
		return zgts;
	}

	public void setZgts(Integer zgts) {
		this.zgts = zgts;
	}

	/** @ 操作结果(czjg) */
	public String getCzjg() {
		return czjg;
	}

	public void setCzjg(String czjg) {
		this.czjg = czjg;
	}

	/** @ 成功条数(cgts) */
	public Integer getCgts() {
		return cgts;
	}

	public void setCgts(Integer cgts) {
		this.cgts = cgts;
	}

	/** @ 失败条数(sbts) */
	public Integer getSbts() {
		return sbts;
	}

	public void setSbts(Integer sbts) {
		this.sbts = sbts;
	}

	/** @ 行业名称(hymc) */
	public String getHymc() {
		return hymc;
	}

	public void setHymc(String hymc) {
		this.hymc = hymc;
	}

	/** @ 行业编码(hybm) */
	public String getHybm() {
		return hybm;
	}

	public void setHybm(String hybm) {
		this.hybm = hybm;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
