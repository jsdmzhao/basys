package com.aisino2.basicsystem.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.core.domain.BaseObject;

public class Gatztb  {

	/** @param 公安通知通报(t_gatztb) */

	/** @ --公安通报ID--gatbid--Integer--10-- */
	private Integer gatbid;

	/** @ --标题--bt--String--100-- */
	private String bt;

	/** @ --发布时间--fbsj--Date---- */
	private Date fbsj;
	private Date fbsjzhi;

	/** @ --发布内容--fbnr--String--2000-- */
	private String fbnr;

	/** @ --发布人--fbr--String--100-- */
	private String fbr;

	/** @ --发布单位编码--fbdwbm--String--20-- */
	private String fbdwbm;

	/** @ --发布单位--fbdw--String--200-- */
	private String fbdw;

	/** @ --截止日期--jzrq--Date---- */
	private Date jzrq;

	/** @ --过期标识--gqbs--String--2-- */
	private String gqbs;
	private String gqbsFlg;

	/** @ --公安通报类型编码--gatblxbm--String--2-- */
	private String gatblxbm;

	/** @ --公安通报类型名称--gatblxmc--String--20-- */
	private String gatblxmc;
	//协查通报附件的List
	private List xctbfj;
	private List lXctbfjList;
	private Map jsdwMap;//接收单位map
	private String jsdwbm;
	/** 分页排序 */
	private String pageSort;
	/** @ --收取时间--sqsj--Date---- */
	private Date sqsj;
	private String qsFlg;
	private String qssl;//签收数量

	/** @ 公安通报ID(gatbid) */
	public Integer getGatbid() {
		return gatbid;
	}

	public void setGatbid(Integer gatbid) {
		this.gatbid = gatbid;
	}

	/** @ 标题(bt) */
	public String getBt() {
		return bt;
	}

	public void setBt(String bt) {
		this.bt = bt;
	}

	/** @ 发布时间(fbsj) */
	public Date getFbsj() {
		return fbsj;
	}

	public void setFbsj(Date fbsj) {
		this.fbsj = fbsj;
	}

	/** @ 发布内容(fbnr) */
	public String getFbnr() {
		return fbnr;
	}

	public void setFbnr(String fbnr) {
		this.fbnr = fbnr;
	}

	/** @ 发布人(fbr) */
	public String getFbr() {
		return fbr;
	}

	public void setFbr(String fbr) {
		this.fbr = fbr;
	}

	/** @ 发布单位编码(fbdwbm) */
	public String getFbdwbm() {
		return fbdwbm;
	}

	public void setFbdwbm(String fbdwbm) {
		this.fbdwbm = fbdwbm;
	}

	/** @ 发布单位(fbdw) */
	public String getFbdw() {
		return fbdw;
	}

	public void setFbdw(String fbdw) {
		this.fbdw = fbdw;
	}

	/** @ 截止日期(jzrq) */
	public Date getJzrq() {
		return jzrq;
	}

	public void setJzrq(Date jzrq) {
		this.jzrq = jzrq;
	}

	/** @ 过期标识(gqbs) */
	public String getGqbs() {
		return gqbs;
	}

	public void setGqbs(String gqbs) {
		this.gqbs = gqbs;
	}

	/** @ 公安通报类型编码(gatblxbm) */
	public String getGatblxbm() {
		return gatblxbm;
	}

	public void setGatblxbm(String gatblxbm) {
		this.gatblxbm = gatblxbm;
	}

	/** @ 公安通报类型名称(gatblxmc) */
	public String getGatblxmc() {
		return gatblxmc;
	}

	public void setGatblxmc(String gatblxmc) {
		this.gatblxmc = gatblxmc;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public List getXctbfj() {
		return xctbfj;
	}

	public void setXctbfj(List xctbfj) {
		this.xctbfj = xctbfj;
	}

	public List getLXctbfjList() {
		return lXctbfjList;
	}

	public void setLXctbfjList(List xctbfjList) {
		lXctbfjList = xctbfjList;
	}

	public Map getJsdwMap() {
		return jsdwMap;
	}

	public void setJsdwMap(Map jsdwMap) {
		this.jsdwMap = jsdwMap;
	}

	public Date getFbsjzhi() {
		return fbsjzhi;
	}

	public void setFbsjzhi(Date fbsjzhi) {
		this.fbsjzhi = fbsjzhi;
	}

	public String getGqbsFlg() {
		return gqbsFlg;
	}

	public void setGqbsFlg(String gqbsFlg) {
		this.gqbsFlg = gqbsFlg;
	}

	public String getJsdwbm() {
		return jsdwbm;
	}

	public void setJsdwbm(String jsdwbm) {
		this.jsdwbm = jsdwbm;
	}

	public Date getSqsj() {
		return sqsj;
	}

	public void setSqsj(Date sqsj) {
		this.sqsj = sqsj;
	}

	public String getQsFlg() {
		return qsFlg;
	}

	public void setQsFlg(String qsFlg) {
		this.qsFlg = qsFlg;
	}

	public String getQssl() {
		return qssl;
	}

	public void setQssl(String qssl) {
		this.qssl = qssl;
	}
}
