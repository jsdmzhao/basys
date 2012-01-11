package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Zjb_ls  {

	/** @param 证件历史表(t_zjb_ls) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --企业历史ID--qylsid--Integer--10-- */
	private Integer qylsid;

	/** @ --证件历史ID--zjlsid--Integer--10-- */
	private Integer zjlsid;

	/** @ --证件ID--fk_zjid--Integer--10-- */
	private Integer fk_zjid;

	/** @ --证件分类--zjfl--String--40-- */
	private String zjfl;

	/** @ --证件编号--zjbh--String--60-- */
	private String zjbh;

	/** @ --发证机关--fzjg--String--60-- */
	private String fzjg;

	/** @ --起始日期--qsrq--Date---- */
	private Date qsrq;

	/** @ --截止日期--jzrq--Date---- */
	private Date jzrq;

	private String fzjgdm; //发证机关代码
	
	/** 分页排序 */
	private String pageSort;
	
	/** @ --营业执照 证件编号--zjbh--String--60-- */
	private String yyzzZjbh;
	/** @ --营业执照 发证机关--fzjg--String--60-- */
	private String yyzzFzjg;
	/** @ --营业执照 起始日期--qsrq--Date---- */
	private Date yyzzQsrq;
	/** @ --营业执照 截止日期--jzrq--Date---- */
	private Date yyzzJzrq;
	private String yyzzFzjgdm; //发证机关代码

	/** @ --经营许可 证件编号--zjbh--String--60-- */
	private String jyxkZjbh;
	/** @ --经营许可 发证机关--fzjg--String--60-- */
	private String jyxkFzjg;
	/** @ --经营许可 起始日期--qsrq--Date---- */
	private Date jyxkQsrq;
	/** @ --经营许可 截止日期--jzrq--Date---- */
	private Date jyxkJzrq;
	private String jyxkFzjgdm; //发证机关代码
	
	/** @ --特行许可证 证件编号--zjbh--String--60-- */
	private String thxkZjbh;
	/** @ --特行许可证 发证机关--fzjg--String--60-- */
	private String thxkFzjg;
	/** @ --特行许可证 起始日期--qsrq--Date---- */
	private Date thxkQsrq;
	/** @ --特行许可证 截止日期--jzrq--Date---- */
	private Date thxkJzrq;
	private String thxkFzjgdm; //发证机关代码

	/** @ --税务登记证 证件编号--zjbh--String--60-- */
	private String swdjZjbh;
	/** @ --税务登记证 发证机关--fzjg--String--60-- */
	private String swdjFzjg;
	/** @ --税务登记证 起始日期--qsrq--Date---- */
	private Date swdjQsrq;
	/** @ --税务登记证 截止日期--jzrq--Date---- */
	private Date swdjJzrq;
	private String swdjFzjgdm; //发证机关代码

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 企业历史ID(qylsid) */
	public Integer getQylsid() {
		return qylsid;
	}

	public void setQylsid(Integer qylsid) {
		this.qylsid = qylsid;
	}

	/** @ 证件历史ID(zjlsid) */
	public Integer getZjlsid() {
		return zjlsid;
	}

	public void setZjlsid(Integer zjlsid) {
		this.zjlsid = zjlsid;
	}

	/** @ 证件ID(fk_zjid) */
	public Integer getFk_zjid() {
		return fk_zjid;
	}

	public void setFk_zjid(Integer fk_zjid) {
		this.fk_zjid = fk_zjid;
	}

	/** @ 证件分类(zjfl) */
	public String getZjfl() {
		return zjfl;
	}

	public void setZjfl(String zjfl) {
		this.zjfl = zjfl;
	}

	/** @ 证件编号(zjbh) */
	public String getZjbh() {
		return zjbh;
	}

	public void setZjbh(String zjbh) {
		this.zjbh = zjbh;
	}

	/** @ 发证机关(fzjg) */
	public String getFzjg() {
		return fzjg;
	}

	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}

	/** @ 起始日期(qsrq) */
	public Date getQsrq() {
		return qsrq;
	}

	public void setQsrq(Date qsrq) {
		this.qsrq = qsrq;
	}

	/** @ 截止日期(jzrq) */
	public Date getJzrq() {
		return jzrq;
	}

	public void setJzrq(Date jzrq) {
		this.jzrq = jzrq;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getYyzzZjbh() {
		return yyzzZjbh;
	}

	public void setYyzzZjbh(String yyzzZjbh) {
		this.yyzzZjbh = yyzzZjbh;
	}

	public String getYyzzFzjg() {
		return yyzzFzjg;
	}

	public void setYyzzFzjg(String yyzzFzjg) {
		this.yyzzFzjg = yyzzFzjg;
	}

	public Date getYyzzQsrq() {
		return yyzzQsrq;
	}

	public void setYyzzQsrq(Date yyzzQsrq) {
		this.yyzzQsrq = yyzzQsrq;
	}

	public Date getYyzzJzrq() {
		return yyzzJzrq;
	}

	public void setYyzzJzrq(Date yyzzJzrq) {
		this.yyzzJzrq = yyzzJzrq;
	}

	public String getJyxkZjbh() {
		return jyxkZjbh;
	}

	public void setJyxkZjbh(String jyxkZjbh) {
		this.jyxkZjbh = jyxkZjbh;
	}

	public String getJyxkFzjg() {
		return jyxkFzjg;
	}

	public void setJyxkFzjg(String jyxkFzjg) {
		this.jyxkFzjg = jyxkFzjg;
	}

	public Date getJyxkQsrq() {
		return jyxkQsrq;
	}

	public void setJyxkQsrq(Date jyxkQsrq) {
		this.jyxkQsrq = jyxkQsrq;
	}

	public Date getJyxkJzrq() {
		return jyxkJzrq;
	}

	public void setJyxkJzrq(Date jyxkJzrq) {
		this.jyxkJzrq = jyxkJzrq;
	}

	public String getThxkZjbh() {
		return thxkZjbh;
	}

	public void setThxkZjbh(String thxkZjbh) {
		this.thxkZjbh = thxkZjbh;
	}

	public String getThxkFzjg() {
		return thxkFzjg;
	}

	public void setThxkFzjg(String thxkFzjg) {
		this.thxkFzjg = thxkFzjg;
	}

	public Date getThxkQsrq() {
		return thxkQsrq;
	}

	public void setThxkQsrq(Date thxkQsrq) {
		this.thxkQsrq = thxkQsrq;
	}

	public Date getThxkJzrq() {
		return thxkJzrq;
	}

	public void setThxkJzrq(Date thxkJzrq) {
		this.thxkJzrq = thxkJzrq;
	}

	public String getSwdjZjbh() {
		return swdjZjbh;
	}

	public void setSwdjZjbh(String swdjZjbh) {
		this.swdjZjbh = swdjZjbh;
	}

	public String getSwdjFzjg() {
		return swdjFzjg;
	}

	public void setSwdjFzjg(String swdjFzjg) {
		this.swdjFzjg = swdjFzjg;
	}

	public Date getSwdjQsrq() {
		return swdjQsrq;
	}

	public void setSwdjQsrq(Date swdjQsrq) {
		this.swdjQsrq = swdjQsrq;
	}

	public Date getSwdjJzrq() {
		return swdjJzrq;
	}

	public void setSwdjJzrq(Date swdjJzrq) {
		this.swdjJzrq = swdjJzrq;
	}

	public String getFzjgdm() {
		return fzjgdm;
	}

	public void setFzjgdm(String fzjgdm) {
		this.fzjgdm = fzjgdm;
	}

	public String getYyzzFzjgdm() {
		return yyzzFzjgdm;
	}

	public void setYyzzFzjgdm(String yyzzFzjgdm) {
		this.yyzzFzjgdm = yyzzFzjgdm;
	}

	public String getJyxkFzjgdm() {
		return jyxkFzjgdm;
	}

	public void setJyxkFzjgdm(String jyxkFzjgdm) {
		this.jyxkFzjgdm = jyxkFzjgdm;
	}

	public String getThxkFzjgdm() {
		return thxkFzjgdm;
	}

	public void setThxkFzjgdm(String thxkFzjgdm) {
		this.thxkFzjgdm = thxkFzjgdm;
	}

	public String getSwdjFzjgdm() {
		return swdjFzjgdm;
	}

	public void setSwdjFzjgdm(String swdjFzjgdm) {
		this.swdjFzjgdm = swdjFzjgdm;
	}
}
