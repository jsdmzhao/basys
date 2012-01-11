package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qgztjx_kz  {

	/** @param 全国在逃简项快照(t_qgztjx_kz) */

	private Date bjsj;

	private String bjlx;

	/** @ --报警规则ID--bjgzid--Integer--10-- */
	private Integer bjgzid;

	/** @ --报警信息ID--bjxxid--Integer--10-- */
	private Integer bjxxid;

	/** @ --全国在逃简项快照ID--qgztjxkzid--Integer--10-- */
	private Integer qgztjxkzid;

	/** @ --通报编号--tbbh--String--20-- */
	private String tbbh;

	/** @ --行政区划编码--xzqhbm--String--6-- */
	private String xzqhbm;

	/** @ --行政区划--xzqh--String--100-- */
	private String xzqh;

	/** @ --姓名拼音--xmpy--String--60-- */
	private String xmpy;

	/** @ --姓名--xm--String--100-- */
	private String xm;

	/** @ --别名--bm--String--30-- */
	private String bm;

	/** @ --性别代码--xbdm--String--2-- */
	private String xbdm;

	/** @ --性别--xb--String--2-- */
	private String xb;

	/** @ --出生日期--csrq--Date---- */
	private Date csrq;

	/** @ --公民身份号码--gmsfhm--String--20-- */
	private String gmsfhm;

	/** @ --户籍地编码--hjdbm--String--6-- */
	private String hjdbm;

	/** @ --户籍地--hjd--String--300-- */
	private String hjd;

	/** @ --户籍详细地址--hjxxdz--String--300-- */
	private String hjxxdz;

	/** @ --现住地区编码--xzdqbm--String--6-- */
	private String xzdqbm;

	/** @ --现住地区--xzdq--String--300-- */
	private String xzdq;

	/** @ --现住地详细地址--xzdxxdz--String--300-- */
	private String xzdxxdz;

	/** @ --其他证件类型--qtzjlx--String--20-- */
	private String qtzjlx;

	/** @ --其他证件号码--qtzjhm--String--20-- */
	private String qtzjhm;

	/** @ --案件级别编码--ajjbbm--String--2-- */
	private String ajjbbm;

	/** @ --案件级别--ajjb--String--20-- */
	private String ajjb;

	/** @ --案件类别编码--ajlbbm--String--20-- */
	private String ajlbbm;

	/** @ --案件类别--ajlb--String--60-- */
	private String ajlb;

	/** @ --简要案情--jyaq--String--2000-- */
	private String jyaq;

	/** @ --登记日期--djrq--Date---- */
	private Date djrq;

	/** @ --登记人--djr--String--30-- */
	private String djr;

	/** @ --立案地区编码--ladqbm--String--6-- */
	private String ladqbm;

	/** @ --立案地区--ladq--String--300-- */
	private String ladq;

	/** @ --办案单位编码--badwbm--String--20-- */
	private String badwbm;

	/** @ --办案单位--badw--String--100-- */
	private String badw;

	/** @ --填表人--tbr--String--100-- */
	private String tbr;

	/** @ --联系人--lxr--String--100-- */
	private String lxr;

	/** @ --联系方式--lxfs--String--60-- */
	private String lxfs;

	/** 分页排序 */
	private String pageSort;

	/** @ 报警规则ID(bjgzid) */
	public Integer getBjgzid() {
		return bjgzid;
	}

	public void setBjgzid(Integer bjgzid) {
		this.bjgzid = bjgzid;
	}

	/** @ 报警信息ID(bjxxid) */
	public Integer getBjxxid() {
		return bjxxid;
	}

	public void setBjxxid(Integer bjxxid) {
		this.bjxxid = bjxxid;
	}

	/** @ 全国在逃简项快照ID(qgztjxkzid) */
	public Integer getQgztjxkzid() {
		return qgztjxkzid;
	}

	public void setQgztjxkzid(Integer qgztjxkzid) {
		this.qgztjxkzid = qgztjxkzid;
	}

	/** @ 通报编号(tbbh) */
	public String getTbbh() {
		return tbbh;
	}

	public void setTbbh(String tbbh) {
		this.tbbh = tbbh;
	}

	/** @ 行政区划编码(xzqhbm) */
	public String getXzqhbm() {
		return xzqhbm;
	}

	public void setXzqhbm(String xzqhbm) {
		this.xzqhbm = xzqhbm;
	}

	/** @ 行政区划(xzqh) */
	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	/** @ 姓名拼音(xmpy) */
	public String getXmpy() {
		return xmpy;
	}

	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}

	/** @ 姓名(xm) */
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	/** @ 别名(bm) */
	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	/** @ 性别代码(xbdm) */
	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	/** @ 性别(xb) */
	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	/** @ 出生日期(csrq) */
	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	/** @ 公民身份号码(gmsfhm) */
	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	/** @ 户籍地编码(hjdbm) */
	public String getHjdbm() {
		return hjdbm;
	}

	public void setHjdbm(String hjdbm) {
		this.hjdbm = hjdbm;
	}

	/** @ 户籍地(hjd) */
	public String getHjd() {
		return hjd;
	}

	public void setHjd(String hjd) {
		this.hjd = hjd;
	}

	/** @ 户籍详细地址(hjxxdz) */
	public String getHjxxdz() {
		return hjxxdz;
	}

	public void setHjxxdz(String hjxxdz) {
		this.hjxxdz = hjxxdz;
	}

	/** @ 现住地区编码(xzdqbm) */
	public String getXzdqbm() {
		return xzdqbm;
	}

	public void setXzdqbm(String xzdqbm) {
		this.xzdqbm = xzdqbm;
	}

	/** @ 现住地区(xzdq) */
	public String getXzdq() {
		return xzdq;
	}

	public void setXzdq(String xzdq) {
		this.xzdq = xzdq;
	}

	/** @ 现住地详细地址(xzdxxdz) */
	public String getXzdxxdz() {
		return xzdxxdz;
	}

	public void setXzdxxdz(String xzdxxdz) {
		this.xzdxxdz = xzdxxdz;
	}

	/** @ 其他证件类型(qtzjlx) */
	public String getQtzjlx() {
		return qtzjlx;
	}

	public void setQtzjlx(String qtzjlx) {
		this.qtzjlx = qtzjlx;
	}

	/** @ 其他证件号码(qtzjhm) */
	public String getQtzjhm() {
		return qtzjhm;
	}

	public void setQtzjhm(String qtzjhm) {
		this.qtzjhm = qtzjhm;
	}

	/** @ 案件级别编码(ajjbbm) */
	public String getAjjbbm() {
		return ajjbbm;
	}

	public void setAjjbbm(String ajjbbm) {
		this.ajjbbm = ajjbbm;
	}

	/** @ 案件级别(ajjb) */
	public String getAjjb() {
		return ajjb;
	}

	public void setAjjb(String ajjb) {
		this.ajjb = ajjb;
	}

	/** @ 案件类别编码(ajlbbm) */
	public String getAjlbbm() {
		return ajlbbm;
	}

	public void setAjlbbm(String ajlbbm) {
		this.ajlbbm = ajlbbm;
	}

	/** @ 案件类别(ajlb) */
	public String getAjlb() {
		return ajlb;
	}

	public void setAjlb(String ajlb) {
		this.ajlb = ajlb;
	}

	/** @ 简要案情(jyaq) */
	public String getJyaq() {
		return jyaq;
	}

	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}

	/** @ 登记日期(djrq) */
	public Date getDjrq() {
		return djrq;
	}

	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}

	/** @ 登记人(djr) */
	public String getDjr() {
		return djr;
	}

	public void setDjr(String djr) {
		this.djr = djr;
	}

	/** @ 立案地区编码(ladqbm) */
	public String getLadqbm() {
		return ladqbm;
	}

	public void setLadqbm(String ladqbm) {
		this.ladqbm = ladqbm;
	}

	/** @ 立案地区(ladq) */
	public String getLadq() {
		return ladq;
	}

	public void setLadq(String ladq) {
		this.ladq = ladq;
	}

	/** @ 办案单位编码(badwbm) */
	public String getBadwbm() {
		return badwbm;
	}

	public void setBadwbm(String badwbm) {
		this.badwbm = badwbm;
	}

	/** @ 办案单位(badw) */
	public String getBadw() {
		return badw;
	}

	public void setBadw(String badw) {
		this.badw = badw;
	}

	/** @ 填表人(tbr) */
	public String getTbr() {
		return tbr;
	}

	public void setTbr(String tbr) {
		this.tbr = tbr;
	}

	/** @ 联系人(lxr) */
	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	/** @ 联系方式(lxfs) */
	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getBjsj() {
		return bjsj;
	}

	public void setBjsj(Date bjsj) {
		this.bjsj = bjsj;
	}

	public String getBjlx() {
		return bjlx;
	}

	public void setBjlx(String bjlx) {
		this.bjlx = bjlx;
	}
}
