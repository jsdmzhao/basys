package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;

public class Sjbjg  {

	/** @param 数据表结构(t_sjbjg) */

	/** @ --数据表结构ID--sjbjgid--Integer--10-- */
	private Integer sjbjgid;

	/** @ --数据表ID--sjbid--Integer--10-- */
	private Integer sjbid;

	/** @ --字段名--zdm--String--30-- */
	private String zdm;

	/** @ --字段中文名--zdzwm--String--30-- */
	private String zdzwm;

	/** @ --字段类型--zdlx--String--10-- */
	private String zdlx;

	/** @ --字段长度--zdcd--String--10-- */
	private String zdcd;

	/** @ --缺省值--qsz--String--100-- */
	private String qsz;

	/** @ --排序--px--Integer--10-- */
	private Integer px;

	/** @ --格式--gs--String--100-- */
	private String gs;

	/** @ --是否多行文本--sfdjhwb--String--1-- */
	private String sfdjhwb;

	/** @ --是否必填--sfbt--String--1-- */
	private String sfbt;

	/** @ --是否只读--sfzd--String--1-- */
	private String sfzd;

	/** @ --是否可见--sfkj--String--1-- */
	private String sfkj;

	/** @ --是否查询--sfcx--String--1-- */
	private String sfcx;

	/** @ --下拉框类型--xlklx--String--20-- */
	private String xlklx;

	/** @ --定制下拉框读取域列表--dzxlkdqy--String--100-- */
	private String dzxlkdqy;

	/** @ --下拉框宽度--xlkkd--Integer--6-- */
	private Integer xlkkd;

	/** @ --下拉框高度--xlkgd--Integer--6-- */
	private Integer xlkgd;

	/** @ --备注--bz--String--2000-- */
	private String bz;
	/** @ --字典项 --xlknr -- -- */
	private String xlknr;

	public String getXlknr() {
		return xlknr;
	}

	public void setXlknr(String xlknr) {
		this.xlknr = xlknr;
	}

	/** 分页排序 */
	private String pageSort;

	/** @ 数据表结构ID(sjbjgid) */
	public Integer getSjbjgid() {
		return sjbjgid;
	}

	public void setSjbjgid(Integer sjbjgid) {
		this.sjbjgid = sjbjgid;
	}

	/** @ 数据表ID(sjbid) */
	public Integer getSjbid() {
		return sjbid;
	}

	public void setSjbid(Integer sjbid) {
		this.sjbid = sjbid;
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

	/** @ 字段类型(zdlx) */
	public String getZdlx() {
		return zdlx;
	}

	public void setZdlx(String zdlx) {
		this.zdlx = zdlx;
	}

	/** @ 字段长度(zdcd) */
	public String getZdcd() {
		return zdcd;
	}

	public void setZdcd(String zdcd) {
		this.zdcd = zdcd;
	}

	/** @ 缺省值(qsz) */
	public String getQsz() {
		return qsz;
	}

	public void setQsz(String qsz) {
		this.qsz = qsz;
	}

	/** @ 排序(px) */
	public Integer getPx() {
		return px;
	}

	public void setPx(Integer px) {
		this.px = px;
	}

	/** @ 格式(gs) */
	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	/** @ 是否多行文本(sfdjhwb) */
	public String getSfdjhwb() {
		return sfdjhwb;
	}

	public void setSfdjhwb(String sfdjhwb) {
		this.sfdjhwb = sfdjhwb;
	}

	/** @ 是否必填(sfbt) */
	public String getSfbt() {
		return sfbt;
	}

	public void setSfbt(String sfbt) {
		this.sfbt = sfbt;
	}

	/** @ 是否只读(sfzd) */
	public String getSfzd() {
		return sfzd;
	}

	public void setSfzd(String sfzd) {
		this.sfzd = sfzd;
	}

	/** @ 是否可见(sfkj) */
	public String getSfkj() {
		return sfkj;
	}

	public void setSfkj(String sfkj) {
		this.sfkj = sfkj;
	}

	/** @ 是否查询(sfcx) */
	public String getSfcx() {
		return sfcx;
	}

	public void setSfcx(String sfcx) {
		this.sfcx = sfcx;
	}

	/** @ 下拉框类型(xlklx) */
	public String getXlklx() {
		return xlklx;
	}

	public void setXlklx(String xlklx) {
		this.xlklx = xlklx;
	}

	/** @ 定制下拉框读取域列表(dzxlkdqy) */
	public String getDzxlkdqy() {
		return dzxlkdqy;
	}

	public void setDzxlkdqy(String dzxlkdqy) {
		this.dzxlkdqy = dzxlkdqy;
	}

	/** @ 下拉框宽度(xlkkd) */
	public Integer getXlkkd() {
		return xlkkd;
	}

	public void setXlkkd(Integer xlkkd) {
		this.xlkkd = xlkkd;
	}

	/** @ 下拉框高度(xlkgd) */
	public Integer getXlkgd() {
		return xlkgd;
	}

	public void setXlkgd(Integer xlkgd) {
		this.xlkgd = xlkgd;
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
}
