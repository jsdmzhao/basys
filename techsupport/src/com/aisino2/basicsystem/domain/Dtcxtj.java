package com.aisino2.basicsystem.domain;

import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Dtcxtj  {

	/** @param 动态查询条件(t_dtcxtj) */

	/** @ --动态查询条件ID--dtcxtjid--Integer--10-- */
	private Integer dtcxtjid;

	/** @ --高级查询方案ID--gjcxfaid--Integer--10-- */
	private Integer gjcxfaid;

	/** @ --数据表名--sjbm--String--30-- */
	private String sjbm;

	/** @ --字段名--zdm--String--30-- */
	private String zdm;

	/** @ --字段中文名--zdzwm--String--30-- */
	private String zdzwm;

	/** @ --字段类型--zdlx--String--10-- */
	private String zdlx;

	/** @ --字段值--zdz--String--300-- */
	private String zdz;

	/** @ --显示值--xsz--String--300-- */
	private String xsz;

	/** @ --匹配符--ppf--String--20-- */
	private String ppf;

	/** @ --开始括号--kskh--String--1-- */
	private String kskh;

	/** @ --结束括号--jskh--String--1-- */
	private String jskh;

	/** @ --关系符--gxf--String--20-- */
	private String gxf;

	/** 分页排序 */
	private String pageSort;
	
	/**数据表结构id*/
	private Integer sjbjgid;

	/**匹配条件(动态查询条件)List*/
	private List lPptj_table;
	
	/** @ --数据表中文名 */
	private String sjbzwm;
	
	/** @ --下拉框内容 */
	private String xlknr;

	public String getXlknr() {
		return xlknr;
	}

	public void setXlknr(String xlknr) {
		this.xlknr = xlknr;
	}

	public String getSjbzwm() {
		return sjbzwm;
	}

	public void setSjbzwm(String sjbzwm) {
		this.sjbzwm = sjbzwm;
	}

	public List getLPptj_table() {
		return lPptj_table;
	}

	public void setLPptj_table(List pptj_table) {
		lPptj_table = pptj_table;
	}

	public Integer getSjbjgid() {
		return sjbjgid;
	}

	public void setSjbjgid(Integer sjbjgid) {
		this.sjbjgid = sjbjgid;
	}

	/** @ 动态查询条件ID(dtcxtjid) */
	public Integer getDtcxtjid() {
		return dtcxtjid;
	}

	public void setDtcxtjid(Integer dtcxtjid) {
		this.dtcxtjid = dtcxtjid;
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

	/** @ 字段类型(zdlx) */
	public String getZdlx() {
		return zdlx;
	}

	public void setZdlx(String zdlx) {
		this.zdlx = zdlx;
	}

	/** @ 字段值(zdz) */
	public String getZdz() {
		return zdz;
	}

	public void setZdz(String zdz) {
		this.zdz = zdz;
	}

	/** @ 显示值(xsz) */
	public String getXsz() {
		return xsz;
	}

	public void setXsz(String xsz) {
		this.xsz = xsz;
	}

	/** @ 匹配符(ppf) */
	public String getPpf() {
		return ppf;
	}

	public void setPpf(String ppf) {
		this.ppf = ppf;
	}

	/** @ 开始括号(kskh) */
	public String getKskh() {
		return kskh;
	}

	public void setKskh(String kskh) {
		this.kskh = kskh;
	}

	/** @ 结束括号(jskh) */
	public String getJskh() {
		return jskh;
	}

	public void setJskh(String jskh) {
		this.jskh = jskh;
	}

	/** @ 关系符(gxf) */
	public String getGxf() {
		return gxf;
	}

	public void setGxf(String gxf) {
		this.gxf = gxf;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
