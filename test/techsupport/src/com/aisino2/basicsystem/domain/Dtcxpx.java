package com.aisino2.basicsystem.domain;

import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Dtcxpx  {

	/** @param 动态查询排序(t_dtcxpx) */

	/** @ --动态查询排序ID--dtcxpxid--Integer--10-- */
	private Integer dtcxpxid;

	/** @ --高级查询方案ID--gjcxfaid--Integer--10-- */
	private Integer gjcxfaid;

	/** @ --数据表名--sjbm--String--30-- */
	private String sjbm;

	/** @ --字段名--zdm--String--30-- */
	private String zdm;

	/** @ --字段中文名--zdzwm--String--30-- */
	private String zdzwm;

	/** @ --排序方式--pxfs--String--10-- */
	private String pxfs;

	/** 分页排序 */
	private String pageSort;
	/**数据表结构id*/
	private Integer sjbjgid;
	
	/** @ --数据表中文名 */
	private String sjbzwm;
	
	public String getSjbzwm() {
		return sjbzwm;
	}

	public void setSjbzwm(String sjbzwm) {
		this.sjbzwm = sjbzwm;
	}

	public Integer getSjbjgid() {
		return sjbjgid;
	}

	public void setSjbjgid(Integer sjbjgid) {
		this.sjbjgid = sjbjgid;
	}

	/**排序规则List*/
	private List lPxgz_table;

	public List getLPxgz_table() {
		return lPxgz_table;
	}

	public void setLPxgz_table(List pxgz_table) {
		lPxgz_table = pxgz_table;
	}

	/** @ 动态查询排序ID(dtcxpxid) */
	public Integer getDtcxpxid() {
		return dtcxpxid;
	}

	public void setDtcxpxid(Integer dtcxpxid) {
		this.dtcxpxid = dtcxpxid;
	}

	/** @ 高级查询方案ID(gjcxfaid) */
	public Integer getGjcxfaid() {
		return gjcxfaid;
	}

	public void setGjcxfaid(Integer gjcxfaid) {
		this.gjcxfaid = gjcxfaid;
	}

	/** @ 数据表名(sjbm) */
	public String getSjbm() {
		return sjbm;
	}

	public void setSjbm(String sjbm) {
		this.sjbm = sjbm;
	}

	/** @ 字段名(zdm) */
	public String getZdm() {
		return zdm;
	}

	public void setZdm(String zdm) {
		this.zdm = zdm;
	}

	/** @ 字段中文名(zdzwm) */
	public String getZdzwm() {
		return zdzwm;
	}

	public void setZdzwm(String zdzwm) {
		this.zdzwm = zdzwm;
	}

	/** @ 排序方式(pxfs) */
	public String getPxfs() {
		return pxfs;
	}

	public void setPxfs(String pxfs) {
		this.pxfs = pxfs;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
