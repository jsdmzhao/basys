package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Cjdtjrb  {

	/** @param 采集端统计日报(t_cjdtjrb) */

	/** @ --采集端统计日报ID--cjdtjrbid--Integer--10-- */
	private Integer cjdtjrbid;

	/** @ --采集端统计日期--cjdtjrq--Date---- */
	private Date cjdtjrq;

	/** @ --所属地市编码--ssdsbm--String--20-- */
	private String ssdsbm;

	/** @ --所属地市名称--ssdsmc--String--100-- */
	private String ssdsmc;

	/** @ --采集点编码--cjdbm--String--20-- */
	private String cjdbm;

	/** @ --采集点名称--cjdmc--String--100-- */
	private String cjdmc;

	/** @ --已录入场所数--lrcss--Integer--6-- */
	private Integer lrcss;

	/** @ --已录入从业人员数--lrcyrys--Integer--6-- */
	private Integer lrcyrys;

	/** @ --已受理IC卡数--yslicks--Integer--6-- */
	private Integer yslicks;

	/** @ --已接收--yjss--Integer--6-- */
	private Integer yjss;

	/** @ --已发放--yffs--Integer--6-- */
	private Integer yffs;

	/** 分页排序 */
	private String pageSort;
	
	/** 地市标志 非数据库字段 */
	private String ssdsbz;
	/** 采集点标志 非数据库字段 */
	private String cjdbz;
	/** @ --起始时间--qssj--String---- */
	private String qssj;
	/** @ --截止时间--jzsj--String---- */
	private String jzsj;
	private String yzxs;// 已注销数
	private String bhks;// 补换卡数
	
	private String hylbdm ; //行业类别代码
	private String hylb;  //行业类别

	/** @ 采集端统计日报ID(cjdtjrbid) */
	public Integer getCjdtjrbid() {
		return cjdtjrbid;
	}

	public String getYzxs() {
		return yzxs;
	}

	public void setYzxs(String yzxs) {
		this.yzxs = yzxs;
	}

	public String getBhks() {
		return bhks;
	}

	public void setBhks(String bhks) {
		this.bhks = bhks;
	}

	public void setCjdtjrbid(Integer cjdtjrbid) {
		this.cjdtjrbid = cjdtjrbid;
	}

	/** @ 采集端统计日期(cjdtjrq) */
	public Date getCjdtjrq() {
		return cjdtjrq;
	}

	public void setCjdtjrq(Date cjdtjrq) {
		this.cjdtjrq = cjdtjrq;
	}

	/** @ 所属地市编码(ssdsbm) */
	public String getSsdsbm() {
		return ssdsbm;
	}

	public void setSsdsbm(String ssdsbm) {
		this.ssdsbm = ssdsbm;
	}

	/** @ 所属地市名称(ssdsmc) */
	public String getSsdsmc() {
		return ssdsmc;
	}

	public void setSsdsmc(String ssdsmc) {
		this.ssdsmc = ssdsmc;
	}

	/** @ 采集点编码(cjdbm) */
	public String getCjdbm() {
		return cjdbm;
	}

	public void setCjdbm(String cjdbm) {
		this.cjdbm = cjdbm;
	}

	/** @ 采集点名称(cjdmc) */
	public String getCjdmc() {
		return cjdmc;
	}

	public void setCjdmc(String cjdmc) {
		this.cjdmc = cjdmc;
	}

	/** @ 已录入场所数(lrcss) */
	public Integer getLrcss() {
		return lrcss;
	}

	public void setLrcss(Integer lrcss) {
		this.lrcss = lrcss;
	}

	/** @ 已录入从业人员数(lrcyrys) */
	public Integer getLrcyrys() {
		return lrcyrys;
	}

	public void setLrcyrys(Integer lrcyrys) {
		this.lrcyrys = lrcyrys;
	}

	/** @ 已受理IC卡数(yslicks) */
	public Integer getYslicks() {
		return yslicks;
	}

	public void setYslicks(Integer yslicks) {
		this.yslicks = yslicks;
	}

	/** @ 已接收(yjss) */
	public Integer getYjss() {
		return yjss;
	}

	public void setYjss(Integer yjss) {
		this.yjss = yjss;
	}

	/** @ 已发放(yffs) */
	public Integer getYffs() {
		return yffs;
	}

	public void setYffs(Integer yffs) {
		this.yffs = yffs;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getSsdsbz() {
		return ssdsbz;
	}

	public void setSsdsbz(String ssdsbz) {
		this.ssdsbz = ssdsbz;
	}

	public String getCjdbz() {
		return cjdbz;
	}

	public void setCjdbz(String cjdbz) {
		this.cjdbz = cjdbz;
	}

	public String getQssj() {
		return qssj;
	}

	public void setQssj(String qssj) {
		this.qssj = qssj;
	}

	public String getJzsj() {
		return jzsj;
	}

	public void setJzsj(String jzsj) {
		this.jzsj = jzsj;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}
}
