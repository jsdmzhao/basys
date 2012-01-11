package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Zktjhjrb  {

	/** @param 制卡统计汇总日报(t_zktjhjrb) */

	/** @ --制卡统计汇总日报ID--zktjhzrbid--Integer--10-- */
	private Integer zktjhzrbid;

	/** @ --采集端统计日期--cjdtjrq--Date---- */
	private Date cjdtjrq;

	/** @ --采集点编码--cjdbm--String--20-- */
	private String cjdbm;

	/** @ --采集点名称--cjdmc--String--100-- */
	private String cjdmc;

	/** @ --制卡中心编码--zkzxbm--String--20-- */
	private String zkzxbm;

	/** @ --制卡中心名称--zkzxmc--String--100-- */
	private String zkzxmc;

	/** @ --提交卡片总数--tjkpzs--Integer--10-- */
	private Integer tjkpzs;

	/** @ --总制卡数--zzks--Integer--10-- */
	private Integer zzks;

	/** @ --未制卡数--wzks--Integer--10-- */
	private Integer wzks;

	/** @ --已组包数--yzbs--Integer--10-- */
	private Integer yzbs;

	/** @ --已发送数--yfss--Integer--10-- */
	private Integer yfss;

	/** @ --已发卡数--yfks--Integer--10-- */
	private Integer yfks;

	/** @ --重制卡数--czks--Integer--10-- */
	private Integer czks;

	/** 分页排序 */
	private String pageSort;

	/** @ 制卡统计汇总日报ID(zktjhzrbid) */
	public Integer getZktjhzrbid() {
		return zktjhzrbid;
	}

	public void setZktjhzrbid(Integer zktjhzrbid) {
		this.zktjhzrbid = zktjhzrbid;
	}

	/** @ 采集端统计日期(cjdtjrq) */
	public Date getCjdtjrq() {
		return cjdtjrq;
	}

	public void setCjdtjrq(Date cjdtjrq) {
		this.cjdtjrq = cjdtjrq;
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

	/** @ 制卡中心编码(zkzxbm) */
	public String getZkzxbm() {
		return zkzxbm;
	}

	public void setZkzxbm(String zkzxbm) {
		this.zkzxbm = zkzxbm;
	}

	/** @ 制卡中心名称(zkzxmc) */
	public String getZkzxmc() {
		return zkzxmc;
	}

	public void setZkzxmc(String zkzxmc) {
		this.zkzxmc = zkzxmc;
	}

	/** @ 提交卡片总数(tjkpzs) */
	public Integer getTjkpzs() {
		return tjkpzs;
	}

	public void setTjkpzs(Integer tjkpzs) {
		this.tjkpzs = tjkpzs;
	}

	/** @ 总制卡数(zzks) */
	public Integer getZzks() {
		return zzks;
	}

	public void setZzks(Integer zzks) {
		this.zzks = zzks;
	}

	/** @ 未制卡数(wzks) */
	public Integer getWzks() {
		return wzks;
	}

	public void setWzks(Integer wzks) {
		this.wzks = wzks;
	}

	/** @ 已组包数(yzbs) */
	public Integer getYzbs() {
		return yzbs;
	}

	public void setYzbs(Integer yzbs) {
		this.yzbs = yzbs;
	}

	/** @ 已发送数(yfss) */
	public Integer getYfss() {
		return yfss;
	}

	public void setYfss(Integer yfss) {
		this.yfss = yfss;
	}

	/** @ 已发卡数(yfks) */
	public Integer getYfks() {
		return yfks;
	}

	public void setYfks(Integer yfks) {
		this.yfks = yfks;
	}

	/** @ 重制卡数(czks) */
	public Integer getCzks() {
		return czks;
	}

	public void setCzks(Integer czks) {
		this.czks = czks;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
