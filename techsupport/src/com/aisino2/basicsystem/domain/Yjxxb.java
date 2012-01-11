package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Yjxxb  {

	/** @param 预警信息表(t_yjxxb) */

	/** @ --预警规则ID--yjgzid--Integer--10-- */
	private Integer yjgzid;

	/** @ --预警信息ID--yjxxid--Integer--10-- */
	private Integer yjxxid;

	/** @ --所属企业名称--ssqymc--String--100-- */
	private String ssqymc;

	/** @ --所属企业地址--ssqydz--String--200-- */
	private String ssqydz;

	/** @ --管辖单位代码--gxdwbm--String--20-- */
	private String gxdwbm;

	/** @ --管辖单位名称--gxdwmc--String--60-- */
	private String gxdwmc;

	/** @ --预警类型--yjlx--String--60-- */
	private String yjlx;

	/** @ --预警时间--yjsj--Date---- */
	private Date yjsj;

	/** @ --比对表名--bdbm--String--100-- */
	private String bdbm;

	/** @ --业务表名--ywbm--String--100-- */
	private String ywbm;

	/** @ --行业类别--hylb--String--100-- */
	private String hylb;

	/** @ --姓名--xm--String--100-- */
	private String xm;

	/** @ --公民身份号码--gmsfhm--String--20-- */
	private String gmsfhm;

	/** @ --更新版本号--gxbbh--Integer--6-- */
	private Integer gxbbh;

	/** @ --业务类别--ywlb--String--30-- */
	private String ywlb;

	/** @ --联系电话--lxdh--String--30-- */
	private String lxdh;

	/** @ --情况描述--qkms--String--2000-- */
	private String qkms;

	/** 分页排序 */
	private String pageSort;
	
	private String ywbzj; //关注表主键
	
	private String bdbzj; //比对表主键
	


	public String getYwbzj() {
		return ywbzj;
	}

	public void setYwbzj(String ywbzj) {
		this.ywbzj = ywbzj;
	}

	public String getBdbzj() {
		return bdbzj;
	}

	public void setBdbzj(String bdbzj) {
		this.bdbzj = bdbzj;
	}

	/** @ 预警规则ID(yjgzid) */
	public Integer getYjgzid() {
		return yjgzid;
	}

	public void setYjgzid(Integer yjgzid) {
		this.yjgzid = yjgzid;
	}

	/** @ 预警信息ID(yjxxid) */
	public Integer getYjxxid() {
		return yjxxid;
	}

	public void setYjxxid(Integer yjxxid) {
		this.yjxxid = yjxxid;
	}

	/** @ 所属企业名称(ssqymc) */
	public String getSsqymc() {
		return ssqymc;
	}

	public void setSsqymc(String ssqymc) {
		this.ssqymc = ssqymc;
	}

	/** @ 所属企业地址(ssqydz) */
	public String getSsqydz() {
		return ssqydz;
	}

	public void setSsqydz(String ssqydz) {
		this.ssqydz = ssqydz;
	}

	/** @ 管辖单位代码(gxdwbm) */
	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}

	/** @ 管辖单位名称(gxdwmc) */
	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	/** @ 预警类型(yjlx) */
	public String getYjlx() {
		return yjlx;
	}

	public void setYjlx(String yjlx) {
		this.yjlx = yjlx;
	}

	/** @ 预警时间(yjsj) */
	public Date getYjsj() {
		return yjsj;
	}

	public void setYjsj(Date yjsj) {
		this.yjsj = yjsj;
	}

	/** @ 比对表名(bdbm) */
	public String getBdbm() {
		return bdbm;
	}

	public void setBdbm(String bdbm) {
		this.bdbm = bdbm;
	}

	/** @ 业务表名(ywbm) */
	public String getYwbm() {
		return ywbm;
	}

	public void setYwbm(String ywbm) {
		this.ywbm = ywbm;
	}

	/** @ 行业类别(hylb) */
	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	/** @ 姓名(xm) */
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	/** @ 公民身份号码(gmsfhm) */
	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	/** @ 更新版本号(gxbbh) */
	public Integer getGxbbh() {
		return gxbbh;
	}

	public void setGxbbh(Integer gxbbh) {
		this.gxbbh = gxbbh;
	}

	/** @ 业务类别(ywlb) */
	public String getYwlb() {
		return ywlb;
	}

	public void setYwlb(String ywlb) {
		this.ywlb = ywlb;
	}

	/** @ 联系电话(lxdh) */
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	/** @ 情况描述(qkms) */
	public String getQkms() {
		return qkms;
	}

	public void setQkms(String qkms) {
		this.qkms = qkms;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
