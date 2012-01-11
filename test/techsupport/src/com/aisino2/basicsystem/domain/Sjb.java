package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Sjb  {

	/** @param 数据表(t_sjb) */

	/** @ --数据表ID--sjbid--Integer--10-- */
	private Integer sjbid;

	/** @ --数据表名--sjbm--String--30-- */
	private String sjbm;

	/** @ --数据表中文名--sjbzwm--String--30-- */
	private String sjbzwm;

	/** @ --对应类对象--dyldx--String--30-- */
	private String dyldx;

	/** @ --是否记录操作日志--sfjlczrz--Integer--2-- */
	private Integer sfjlczrz;

	/** @ --是否系统字典--sfxtzd--Integer--2-- */
	private Integer sfxtzd;

	/** @ --所属数据库用户--sssjkyh--String--20-- */
	private String sssjkyh;

	/** @ --主键--zj--String--30-- */
	private String zj;
	
	private String sjbidSet;

	private String sjbmSet;

	/** 分页排序 */
	private String pageSort;

	public String getSjbmSet() {
		return sjbmSet;
	}

	public void setSjbmSet(String sjbmSet) {
		this.sjbmSet = sjbmSet;
	}

	public String getSjbidSet() {
		return sjbidSet;
	}

	public void setSjbidSet(String sjbidSet) {
		this.sjbidSet = sjbidSet;
	}

	/** @ 数据表ID(sjbid) */
	public Integer getSjbid() {
		return sjbid;
	}

	public void setSjbid(Integer sjbid) {
		this.sjbid = sjbid;
	}

	/** @ 数据表名(sjbm) */
	public String getSjbm() {
		return sjbm;
	}

	public void setSjbm(String sjbm) {
		this.sjbm = sjbm;
	}

	/** @ 数据表中文名(sjbzwm) */
	public String getSjbzwm() {
		return sjbzwm;
	}

	public void setSjbzwm(String sjbzwm) {
		this.sjbzwm = sjbzwm;
	}

	/** @ 对应类对象(dyldx) */
	public String getDyldx() {
		return dyldx;
	}

	public void setDyldx(String dyldx) {
		this.dyldx = dyldx;
	}

	/** @ 是否记录操作日志(sfjlczrz) */
	public Integer getSfjlczrz() {
		return sfjlczrz;
	}

	public void setSfjlczrz(Integer sfjlczrz) {
		this.sfjlczrz = sfjlczrz;
	}

	/** @ 是否系统字典(sfxtzd) */
	public Integer getSfxtzd() {
		return sfxtzd;
	}

	public void setSfxtzd(Integer sfxtzd) {
		this.sfxtzd = sfxtzd;
	}

	/** @ 所属数据库用户(sssjkyh) */
	public String getSssjkyh() {
		return sssjkyh;
	}

	public void setSssjkyh(String sssjkyh) {
		this.sssjkyh = sssjkyh;
	}

	/** @ 主键(zj) */
	public String getZj() {
		return zj;
	}

	public void setZj(String zj) {
		this.zj = zj;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
