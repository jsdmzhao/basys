package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Kyqk  {

	/** @param 可疑情况(t_kyqk) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --可疑情况ID--kyqkid--Integer--10-- */
	private Integer kyqkid;

	/** @ --可疑情况登记序号--kyqkdjxh--String--30-- */
	private String kyqkdjxh;

	/** @ --可疑情况类型代码--kyqklxbm--String--2-- */
	private String kyqklxbm;

	/** @ --可疑情况类型--kyqklx--String--100-- */
	private String kyqklx;

	/** @ --疑点详细描述--ydxxms--String--2000-- */
	private String ydxxms;

	/** @ --填报人编号--tbrbh--String--20-- */
	private String tbrbh;

	/** @ --填报人姓名--tbrxm--String--100-- */
	private String tbrxm;

	/** @ --填报时间--tbsj--Date---- */
	private Date tbsj;
	/** @ --填报时间--tbsj--Date---- */
	private Date tbsjzhi;

	/** @ --接警时间--jjsj--Date---- */
	private Date jjsj;

	/** @ --接警人姓名--jjrxm--String--30-- */
	private String jjrxm;

	/** @ --接警处理结果--jjcljg--String--2000-- */
	private String jjcljg;
	/** @ --删除标志--scbz--int--10-- */
	private int scbz;
	private String gxdwbh;
	private String qymc;
	private String hylbdm;
	private String qybm;
	private String hydm;// 行业类别代码 进入可疑情况页面直接检索时传递此参数
	/** 分页排序 */
	private String pageSort;

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 可疑情况ID(kyqkid) */
	public Integer getKyqkid() {
		return kyqkid;
	}

	public void setKyqkid(Integer kyqkid) {
		this.kyqkid = kyqkid;
	}

	/** @ 可疑情况登记序号(kyqkdjxh) */
	public String getKyqkdjxh() {
		return kyqkdjxh;
	}

	public void setKyqkdjxh(String kyqkdjxh) {
		this.kyqkdjxh = kyqkdjxh;
	}

	/** @ 可疑情况类型代码(kyqklxbm) */
	public String getKyqklxbm() {
		return kyqklxbm;
	}

	public void setKyqklxbm(String kyqklxbm) {
		this.kyqklxbm = kyqklxbm;
	}

	/** @ 可疑情况类型(kyqklx) */
	public String getKyqklx() {
		return kyqklx;
	}

	public void setKyqklx(String kyqklx) {
		this.kyqklx = kyqklx;
	}

	/** @ 疑点详细描述(ydxxms) */
	public String getYdxxms() {
		return ydxxms;
	}

	public void setYdxxms(String ydxxms) {
		this.ydxxms = ydxxms;
	}

	/** @ 填报人编号(tbrbh) */
	public String getTbrbh() {
		return tbrbh;
	}

	public void setTbrbh(String tbrbh) {
		this.tbrbh = tbrbh;
	}

	/** @ 填报人姓名(tbrxm) */
	public String getTbrxm() {
		return tbrxm;
	}

	public void setTbrxm(String tbrxm) {
		this.tbrxm = tbrxm;
	}

	/** @ 填报时间(tbsj) */
	public Date getTbsj() {
		return tbsj;
	}

	public void setTbsj(Date tbsj) {
		this.tbsj = tbsj;
	}

	/** @ 接警时间(jjsj) */
	public Date getJjsj() {
		return jjsj;
	}

	public void setJjsj(Date jjsj) {
		this.jjsj = jjsj;
	}

	/** @ 接警人姓名(jjrxm) */
	public String getJjrxm() {
		return jjrxm;
	}

	public void setJjrxm(String jjrxm) {
		this.jjrxm = jjrxm;
	}

	/** @ 接警处理结果(jjcljg) */
	public String getJjcljg() {
		return jjcljg;
	}

	public void setJjcljg(String jjcljg) {
		this.jjcljg = jjcljg;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getTbsjzhi() {
		return tbsjzhi;
	}

	public void setTbsjzhi(Date tbsjzhi) {
		this.tbsjzhi = tbsjzhi;
	}

	public int getScbz() {
		return scbz;
	}

	public void setScbz(int scbz) {
		this.scbz = scbz;
	}

	public String getGxdwbh() {
		return gxdwbh;
	}

	public void setGxdwbh(String gxdwbh) {
		this.gxdwbh = gxdwbh;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}

	public String getHydm() {
		return hydm;
	}

	public void setHydm(String hydm) {
		this.hydm = hydm;
	}
}
