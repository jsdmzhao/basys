package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Yjgz  {

	/** @param 预警规则(t_yjgz) */

	/** @ --预警规则ID--yjgzid--Integer--10-- */
	private Integer yjgzid;

	/** @ --业务表名--ywbm--String--100-- */
	private String ywbm;

	/** @ --比对表名--bdbm--String--100-- */
	private String bdbm;

	/** @ --比对类型--bdlx--String--2-- */
	private String bdlx;

	/** @ --是否有效--sfyx--String--2-- */
	private String sfyx;

	/** @ --发布策略--fbcl--String--300-- */
	private String fbcl;

	/** @ --发布方式--fbfs--String--2-- */
	private String fbfs;

	/** @ --特行单位字段--txdwzd--String--60-- */
	private String txdwzd;

	/** @ --管辖单位字段--gxdwzd--String--60-- */
	private String gxdwzd;

	/** @ --预警级别--yjjb--String--2-- */
	private String yjjb;

	/** @ --预警方式--yjfs--String--60-- */
	private String yjfs;

	/** @ --预警类型--yjlx--String--60-- */
	private String yjlx;

	/** 分页排序 */
	private String pageSort;

	/** @ 预警规则ID(yjgzid) */
	public Integer getYjgzid() {
		return yjgzid;
	}

	public void setYjgzid(Integer yjgzid) {
		this.yjgzid = yjgzid;
	}

	/** @ 业务表名(ywbm) */
	public String getYwbm() {
		return ywbm;
	}

	public void setYwbm(String ywbm) {
		this.ywbm = ywbm;
	}

	/** @ 比对表名(bdbm) */
	public String getBdbm() {
		return bdbm;
	}

	public void setBdbm(String bdbm) {
		this.bdbm = bdbm;
	}

	/** @ 比对类型(bdlx) */
	public String getBdlx() {
		return bdlx;
	}

	public void setBdlx(String bdlx) {
		this.bdlx = bdlx;
	}

	/** @ 是否有效(sfyx) */
	public String getSfyx() {
		return sfyx;
	}

	public void setSfyx(String sfyx) {
		this.sfyx = sfyx;
	}

	/** @ 发布策略(fbcl) */
	public String getFbcl() {
		return fbcl;
	}

	public void setFbcl(String fbcl) {
		this.fbcl = fbcl;
	}

	/** @ 发布方式(fbfs) */
	public String getFbfs() {
		return fbfs;
	}

	public void setFbfs(String fbfs) {
		this.fbfs = fbfs;
	}

	/** @ 特行单位字段(txdwzd) */
	public String getTxdwzd() {
		return txdwzd;
	}

	public void setTxdwzd(String txdwzd) {
		this.txdwzd = txdwzd;
	}

	/** @ 管辖单位字段(gxdwzd) */
	public String getGxdwzd() {
		return gxdwzd;
	}

	public void setGxdwzd(String gxdwzd) {
		this.gxdwzd = gxdwzd;
	}

	/** @ 预警级别(yjjb) */
	public String getYjjb() {
		return yjjb;
	}

	public void setYjjb(String yjjb) {
		this.yjjb = yjjb;
	}

	/** @ 预警方式(yjfs) */
	public String getYjfs() {
		return yjfs;
	}

	public void setYjfs(String yjfs) {
		this.yjfs = yjfs;
	}

	/** @ 预警类型(yjlx) */
	public String getYjlx() {
		return yjlx;
	}

	public void setYjlx(String yjlx) {
		this.yjlx = yjlx;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
