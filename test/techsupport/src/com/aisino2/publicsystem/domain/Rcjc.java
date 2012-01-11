package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Rcjc  {

	/** @param 日常检查(t_rcjc) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --日常检查ID--rcjcid--Integer--10-- */
	private Integer rcjcid;

	/** @ --日常检查编号--rcjcbh--String--30-- */
	private String rcjcbh;

	/** @ --检查机构代码--jcjgdm--String--20-- */
	private String jcjgdm;

	/** @ --检查机构名称--jcjgmc--String--100-- */
	private String jcjgmc;

	/** @ --检查人员编号--jcrybh--String--20-- */
	private String jcrybh;

	/** @ --检查人姓名--jcrxm--String--30-- */
	private String jcrxm;

	/** @ --职务代码--zwdm--String--4-- */
	private String zwdm;

	/** @ --检查人职务--jcrzw--String--100-- */
	private String jcrzw;

	/** @ --检查方式--jcfs--String--20-- */
	private String jcfs;

	/** @ --隶属单位--lsdw--String--100-- */
	private String lsdw;

	/** @ --检查日期--jcrq--Date---- */
	private Date jcrq;

	/** @ --检查事项--jcsx--String--300-- */
	private String jcsx;

	/** @ --发现问题--fxwt--String--300-- */
	private String fxwt;

	/** @ --处理结果--cljg--String--2000-- */
	private String cljg;

	/** @ --企业负责人--csfzr--String--30-- */
	private String csfzr;
	
	/** @ --企业负责人编号--csfzr--String--30-- */
	private String csfzrbh;

	/** @ --是否知道检查结果--sfzdjcjg--String--2-- */
	private String sfzdjcjg;

	/** @ --备注--bz--String--2000-- */
	private String bz;
	/** 分页排序 */
	private String pageSort;
	
	/** @ --所属省份*/
	private String sssf;
	
	/** @ --检查日期(查询)*/
	private Date jcrqf;

	/** @ --检查日期至(查询) */
	private Date jcrqt;
	
	/** @ --行业类别代码--HYLBDM--String--4-- */
	private String hylbdm;
	
	/** @ --行业类别--HYLBDM--String--4-- */
	private String hylb;
	
	/**企业名称*/
	private String qymc;
	
	/**企业编码*/
	private String qybm;
	
	/** @ --检查方式显示值 */
	private String jcfsDisName;
	
	/** 管辖单位编码*/
	private String gxdwbm;
	
	/** 管辖单位名称*/
	private String gxdwmc;
	/** 删除标志*/
	private int scbz;
	
	/** 民警检查证编号 16位*/
	private String mjjczbh;
	
	/** 两次日常检查间隔时间，单位：小时*/
	private int rcjcjgsj;
	
	/** 检查机构简项代码（去掉检查机构代码后面的偶数个0）*/
	private int jcjgdm_jx;

	
	
	
	
	
	private Integer rcjccs;//检查次数
	
	/** @ --起始时间--qssj--String---- */
	private Date qssj;
	/** @ --截止时间--jzsj--String---- */
	private Date jzsj;
	
	/** 地市机关标志 非数据库字段 */
	private String dsjgbz;
	/** 分县局标志 非数据库字段 */
	private String fxjbz;
	/** 科所队标志 非数据库字段 */
	private String gxdwbz;
	/** 场所标志 非数据库字段 */
	private String csbz;
	private String csbm;//场所编码
	
	
	private String csjb;//次数级别
	
	/** @ --地市机关代码--dsjgdm--String--20-- */
	private String dsjgdm;

	/** @ --地市机关名称--dsjgmc--String--60-- */
	private String dsjgmc;

	/** @ --分县局代码--fxjdm--String--20-- */
	private String fxjdm;

	/** @ --分县局名称--fxjmc--String--60-- */
	private String fxjmc;

	/** 管辖单位名称*/
	private String gxdwdm;
	
	/**内外网标志*/
	private String nwwbz;
	
	public Integer getRcjccs() {
		return rcjccs;
	}

	public void setRcjccs(Integer rcjccs) {
		this.rcjccs = rcjccs;
	}

	public int getScbz() {
		return scbz;
	}

	public void setScbz(int scbz) {
		this.scbz = scbz;
	}

	/** @ --行业类别--HYLBDM--String--4-- */
	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}
	
	/** @ --行业类别代码--HYLBDM--String--4-- */
	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}
	
	/** 管辖单位编码*/
	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}
	
	/** 管辖单位名称*/
	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}
	
	/** @ --检查日期至(查询) */
	public Date getJcrqt() {
		return jcrqt;
	}

	public void setJcrqt(Date jcrqt) {
		this.jcrqt = jcrqt;
	}
	
	/** @ --检查日期(查询)*/
	public Date getJcrqf() {
		return jcrqf;
	}

	public void setJcrqf(Date jcrqf) {
		this.jcrqf = jcrqf;
	}
	
	/** @ --所属省份*/
	public String getSssf() {
		return sssf;
	}

	public void setSssf(String sssf) {
		this.sssf = sssf;
	}
	
	/** @ --检查方式显示值 */
	public String getJcfsDisName() {
		return jcfsDisName;
	}

	public void setJcfsDisName(String jcfsDisName) {
		this.jcfsDisName = jcfsDisName;
	}
	

	
	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	/**企业编码*/
	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}


	

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 日常检查ID(rcjcid) */
	public Integer getRcjcid() {
		return rcjcid;
	}

	public void setRcjcid(Integer rcjcid) {
		this.rcjcid = rcjcid;
	}

	/** @ 日常检查编号(rcjcbh) */
	public String getRcjcbh() {
		return rcjcbh;
	}

	public void setRcjcbh(String rcjcbh) {
		this.rcjcbh = rcjcbh;
	}

	/** @ 检查机构代码(jcjgdm) */
	public String getJcjgdm() {
		return jcjgdm;
	}

	public void setJcjgdm(String jcjgdm) {
		this.jcjgdm = jcjgdm;
	}

	/** @ 检查机构名称(jcjgmc) */
	public String getJcjgmc() {
		return jcjgmc;
	}

	public void setJcjgmc(String jcjgmc) {
		this.jcjgmc = jcjgmc;
	}

	/** @ 检查人员编号(jcrybh) */
	public String getJcrybh() {
		return jcrybh;
	}

	public void setJcrybh(String jcrybh) {
		this.jcrybh = jcrybh;
	}

	/** @ 检查人姓名(jcrxm) */
	public String getJcrxm() {
		return jcrxm;
	}

	public void setJcrxm(String jcrxm) {
		this.jcrxm = jcrxm;
	}

	/** @ 职务代码(zwdm) */
	public String getZwdm() {
		return zwdm;
	}

	public void setZwdm(String zwdm) {
		this.zwdm = zwdm;
	}

	/** @ 检查人职务(jcrzw) */
	public String getJcrzw() {
		return jcrzw;
	}

	public void setJcrzw(String jcrzw) {
		this.jcrzw = jcrzw;
	}

	/** @ 检查方式(jcfs) */
	public String getJcfs() {
		return jcfs;
	}

	public void setJcfs(String jcfs) {
		this.jcfs = jcfs;
	}

	/** @ 隶属单位(lsdw) */
	public String getLsdw() {
		return lsdw;
	}

	public void setLsdw(String lsdw) {
		this.lsdw = lsdw;
	}

	/** @ 检查日期(jcrq) */
	public Date getJcrq() {
		return jcrq;
	}

	public void setJcrq(Date jcrq) {
		this.jcrq = jcrq;
	}

	/** @ 检查事项(jcsx) */
	public String getJcsx() {
		return jcsx;
	}

	public void setJcsx(String jcsx) {
		this.jcsx = jcsx;
	}

	/** @ 发现问题(fxwt) */
	public String getFxwt() {
		return fxwt;
	}

	public void setFxwt(String fxwt) {
		this.fxwt = fxwt;
	}

	/** @ 处理结果(cljg) */
	public String getCljg() {
		return cljg;
	}

	public void setCljg(String cljg) {
		this.cljg = cljg;
	}

	/** @ 企业负责人(csfzr) */
	public String getCsfzr() {
		return csfzr;
	}

	public void setCsfzr(String csfzr) {
		this.csfzr = csfzr;
	}

	/** @ 是否知道检查结果(sfzdjcjg) */
	public String getSfzdjcjg() {
		return sfzdjcjg;
	}

	public void setSfzdjcjg(String sfzdjcjg) {
		this.sfzdjcjg = sfzdjcjg;
	}

	/** @ 备注(bz) */
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getQssj() {
		return qssj;
	}

	public void setQssj(Date qssj) {
		this.qssj = qssj;
	}

	public Date getJzsj() {
		return jzsj;
	}

	public void setJzsj(Date jzsj) {
		this.jzsj = jzsj;
	}

	public String getDsjgbz() {
		return dsjgbz;
	}

	public void setDsjgbz(String dsjgbz) {
		this.dsjgbz = dsjgbz;
	}

	public String getFxjbz() {
		return fxjbz;
	}

	public void setFxjbz(String fxjbz) {
		this.fxjbz = fxjbz;
	}

	public String getGxdwbz() {
		return gxdwbz;
	}

	public void setGxdwbz(String gxdwbz) {
		this.gxdwbz = gxdwbz;
	}

	public String getCsbz() {
		return csbz;
	}

	public void setCsbz(String csbz) {
		this.csbz = csbz;
	}

	public String getCsbm() {
		return csbm;
	}

	public void setCsbm(String csbm) {
		this.csbm = csbm;
	}
 


	public String getCsjb() {
		return csjb;
	}

	public void setCsjb(String csjb) {
		this.csjb = csjb;
	}

	public String getDsjgdm() {
		return dsjgdm;
	}

	public void setDsjgdm(String dsjgdm) {
		this.dsjgdm = dsjgdm;
	}

	public String getDsjgmc() {
		return dsjgmc;
	}

	public void setDsjgmc(String dsjgmc) {
		this.dsjgmc = dsjgmc;
	}

	public String getFxjdm() {
		return fxjdm;
	}

	public void setFxjdm(String fxjdm) {
		this.fxjdm = fxjdm;
	}

	public String getFxjmc() {
		return fxjmc;
	}

	public void setFxjmc(String fxjmc) {
		this.fxjmc = fxjmc;
	}

	public String getGxdwdm() {
		return gxdwdm;
	}

	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
	}

	public String getCsfzrbh() {
		return csfzrbh;
	}

	public void setCsfzrbh(String csfzrbh) {
		this.csfzrbh = csfzrbh;
	}

	public String getMjjczbh() {
		return mjjczbh;
	}

	public void setMjjczbh(String mjjczbh) {
		this.mjjczbh = mjjczbh;
	}

	public int getRcjcjgsj() {
		return rcjcjgsj;
	}

	public void setRcjcjgsj(int rcjcjgsj) {
		this.rcjcjgsj = rcjcjgsj;
	}

	public int getJcjgdm_jx() {
		return jcjgdm_jx;
	}

	public void setJcjgdm_jx(int jcjgdm_jx) {
		this.jcjgdm_jx = jcjgdm_jx;
	}

	public String getNwwbz() {
		return nwwbz;
	}

	public void setNwwbz(String nwwbz) {
		this.nwwbz = nwwbz;
	}
	

}
