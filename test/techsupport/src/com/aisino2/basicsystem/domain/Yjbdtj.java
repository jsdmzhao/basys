package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Yjbdtj  {

	/** @param 预警比对条件(t_yjbdtj) */

	/** @ --预警规则ID--yjgzid--Integer--10-- */
	private Integer yjgzid;

	/** @ --预警比对条件ID--yjbdtjid--Integer--10-- */
	private Integer yjbdtjid;

	/** @ --条件类型--tjlx--String--2-- */
	private String tjlx;

	/** @ --业务表字段名--ywbzdm--String--60-- */
	private String ywbzdm;

	/** @ --比对表字段名--bdbzdm--String--60-- */
	private String bdbzdm;

	/** @ --比对关系--bdgx--String--20-- */
	private String bdgx;

	/** @ --关系串--gxc--String--200-- */
	private String gxc;

	/** @ --执行顺序--zxsx--String--100-- */
	private String zxsx;

	/** @ --逻辑关系--ljgx--String--100-- */
	private String ljgx;

	/** @ --级别--jibie--Integer--6-- */
	private Integer jibie;

	/** 分页排序 */
	private String pageSort;

	/** @ 预警规则ID(yjgzid) */
	public Integer getYjgzid() {
		return yjgzid;
	}

	public void setYjgzid(Integer yjgzid) {
		this.yjgzid = yjgzid;
	}

	/** @ 预警比对条件ID(yjbdtjid) */
	public Integer getYjbdtjid() {
		return yjbdtjid;
	}

	public void setYjbdtjid(Integer yjbdtjid) {
		this.yjbdtjid = yjbdtjid;
	}

	/** @ 条件类型(tjlx) */
	public String getTjlx() {
		return tjlx;
	}

	public void setTjlx(String tjlx) {
		this.tjlx = tjlx;
	}

	/** @ 业务表字段名(ywbzdm) */
	public String getYwbzdm() {
		return ywbzdm;
	}

	public void setYwbzdm(String ywbzdm) {
		this.ywbzdm = ywbzdm;
	}

	/** @ 比对表字段名(bdbzdm) */
	public String getBdbzdm() {
		return bdbzdm;
	}

	public void setBdbzdm(String bdbzdm) {
		this.bdbzdm = bdbzdm;
	}

	/** @ 比对关系(bdgx) */
	public String getBdgx() {
		return bdgx;
	}

	public void setBdgx(String bdgx) {
		this.bdgx = bdgx;
	}

	/** @ 关系串(gxc) */
	public String getGxc() {
		return gxc;
	}

	public void setGxc(String gxc) {
		this.gxc = gxc;
	}

	/** @ 执行顺序(zxsx) */
	public String getZxsx() {
		return zxsx;
	}

	public void setZxsx(String zxsx) {
		this.zxsx = zxsx;
	}

	/** @ 逻辑关系(ljgx) */
	public String getLjgx() {
		return ljgx;
	}

	public void setLjgx(String ljgx) {
		this.ljgx = ljgx;
	}

	/** @ 级别(jibie) */
	public Integer getJibie() {
		return jibie;
	}

	public void setJibie(Integer jibie) {
		this.jibie = jibie;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
