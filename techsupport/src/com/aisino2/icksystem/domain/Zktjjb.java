package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Zktjjb  {

	/** @param 制卡统计季报(t_zktjjb) */

	/** @ --制卡统计季报ID--zktjjbid--Integer--10-- */
	private Integer zktjjbid;

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

	/** @ --制卡数--zks--Integer--6-- */
	private Integer zks;

	/** @ --印刷数--yss--Integer--6-- */
	private Integer yss;

	/** @ --重印数--cys--Integer--6-- */
	private Integer cys;

	/** @ --打印错误数--dycws--Integer--6-- */
	private Integer dycws;

	/** @ --塑封错误数--sfcws--Integer--6-- */
	private Integer sfcws;

	/** @ --冲卡错误数--ckcws--Integer--6-- */
	private Integer ckcws;

	/** @ --卡片损坏数--kpshs--Integer--6-- */
	private Integer kpshs;

	/** @ --未能接收数--wnjss--Integer--6-- */
	private Integer wnjss;

	/** @ --其他--qt--Integer--6-- */
	private Integer qt;

	/** @ --电写入错误数--dxrcws--Integer--6-- */
	private Integer dxrcws;

	/** @ --平均制卡量--pjzkl--Integer--6-- */
	private Integer pjzkl;

	/** @ --平均废卡量--pjfkl--Integer--6-- */
	private Integer pjfkl;

	/** @ --废卡率--fkl--Float--5,2-- */
	private Float fkl;

	/** 分页排序 */
	private String pageSort;

	/** @ 制卡统计季报ID(zktjjbid) */
	public Integer getZktjjbid() {
		return zktjjbid;
	}

	public void setZktjjbid(Integer zktjjbid) {
		this.zktjjbid = zktjjbid;
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

	/** @ 制卡数(zks) */
	public Integer getZks() {
		return zks;
	}

	public void setZks(Integer zks) {
		this.zks = zks;
	}

	/** @ 印刷数(yss) */
	public Integer getYss() {
		return yss;
	}

	public void setYss(Integer yss) {
		this.yss = yss;
	}

	/** @ 重印数(cys) */
	public Integer getCys() {
		return cys;
	}

	public void setCys(Integer cys) {
		this.cys = cys;
	}

	/** @ 打印错误数(dycws) */
	public Integer getDycws() {
		return dycws;
	}

	public void setDycws(Integer dycws) {
		this.dycws = dycws;
	}

	/** @ 塑封错误数(sfcws) */
	public Integer getSfcws() {
		return sfcws;
	}

	public void setSfcws(Integer sfcws) {
		this.sfcws = sfcws;
	}

	/** @ 冲卡错误数(ckcws) */
	public Integer getCkcws() {
		return ckcws;
	}

	public void setCkcws(Integer ckcws) {
		this.ckcws = ckcws;
	}

	/** @ 卡片损坏数(kpshs) */
	public Integer getKpshs() {
		return kpshs;
	}

	public void setKpshs(Integer kpshs) {
		this.kpshs = kpshs;
	}

	/** @ 未能接收数(wnjss) */
	public Integer getWnjss() {
		return wnjss;
	}

	public void setWnjss(Integer wnjss) {
		this.wnjss = wnjss;
	}

	/** @ 其他(qt) */
	public Integer getQt() {
		return qt;
	}

	public void setQt(Integer qt) {
		this.qt = qt;
	}

	/** @ 电写入错误数(dxrcws) */
	public Integer getDxrcws() {
		return dxrcws;
	}

	public void setDxrcws(Integer dxrcws) {
		this.dxrcws = dxrcws;
	}

	/** @ 平均制卡量(pjzkl) */
	public Integer getPjzkl() {
		return pjzkl;
	}

	public void setPjzkl(Integer pjzkl) {
		this.pjzkl = pjzkl;
	}

	/** @ 平均废卡量(pjfkl) */
	public Integer getPjfkl() {
		return pjfkl;
	}

	public void setPjfkl(Integer pjfkl) {
		this.pjfkl = pjfkl;
	}

	/** @ 废卡率(fkl) */
	public Float getFkl() {
		return fkl;
	}

	public void setFkl(Float fkl) {
		this.fkl = fkl;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
