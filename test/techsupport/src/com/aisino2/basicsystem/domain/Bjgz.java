package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Bjgz  {

	/** @param 报警规则(t_bjgz) */

	/** @ --报警规则ID--bjgzid--Integer--10-- */
	private Integer bjgzid;

	/** @ --业务表名--ywbm--String--100-- */
	private String ywbm;
	
	/** @ --业务表字段名--ywbzdm--String--60-- */
	private String ywbzdm;

	/** @ --比对表名--bdbm--String--100-- */
	private String bdbm;
	
	/** @ --比对表字段名--bdbzdm--String--60-- */
	private String bdbzdm;
	
	/** @ --比对类型代码--bdlx--String--2-- */
	private String bdlxdm;

	/** @ --比对类型--bdlx--String--20-- */
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

	/** @ --报警级别--bjjb--String--2-- */
	private String bjjb;

	/** @ --报警方式--bjfs--String--60-- */
	private String bjfs;
	
	/** @ --报警类型代码--bjlxdm--String--4-- */
	private String bjlxdm;

	/** @ --报警类型--bjlx--String--60-- */
	private String bjlx;
	
	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--100-- */
	private String hylb;

	/** 分页排序 */
	private String pageSort;

	/** @ 报警规则ID(bjgzid) */
	public Integer getBjgzid() {
		return bjgzid;
	}

	public void setBjgzid(Integer bjgzid) {
		this.bjgzid = bjgzid;
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

	/** @ 报警级别(bjjb) */
	public String getBjjb() {
		return bjjb;
	}

	public void setBjjb(String bjjb) {
		this.bjjb = bjjb;
	}

	/** @ 报警方式(bjfs) */
	public String getBjfs() {
		return bjfs;
	}

	public void setBjfs(String bjfs) {
		this.bjfs = bjfs;
	}

	/** @ 报警类型(bjlx) */
	public String getBjlx() {
		return bjlx;
	}

	public void setBjlx(String bjlx) {
		this.bjlx = bjlx;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
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

	public String getYwbzdm() {
		return ywbzdm;
	}

	public void setYwbzdm(String ywbzdm) {
		this.ywbzdm = ywbzdm;
	}

	public String getBdbzdm() {
		return bdbzdm;
	}

	public void setBdbzdm(String bdbzdm) {
		this.bdbzdm = bdbzdm;
	}

	public String getBdlxdm() {
		return bdlxdm;
	}

	public void setBdlxdm(String bdlxdm) {
		this.bdlxdm = bdlxdm;
	}

	public String getBjlxdm() {
		return bjlxdm;
	}

	public void setBjlxdm(String bjlxdm) {
		this.bjlxdm = bjlxdm;
	}
}
