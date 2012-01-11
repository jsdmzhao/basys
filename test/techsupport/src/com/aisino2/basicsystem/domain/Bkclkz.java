package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Bkclkz  {

	/** @param 布控车辆快照(t_bkclkz) */

	/** @ --报警信息ID--bjxxid2--Integer--10-- */
	private Integer bjxxid2;

	/** @ --物品报警规则ID--wpbjgzid--Integer--10-- */
	private Integer wpbjgzid;
	
	/** @ --布控物品基本信息快照ID--bkwpjbxxkzid--Integer--10-- */
	private Integer bkwpjbxxkzid;

	/** @ --布控车辆快照ID--bkclkzid--Integer--10-- */
	private Integer bkclkzid;

	/** @ --车辆类型代码--cllxdm--String--10-- */
	private String cllxdm;

	/** @ --车辆类型--cllx--String--32-- */
	private String cllx;

	/** @ --车辆品牌--clpp--String--64-- */
	private String clpp;

	/** @ --车辆型号--clxh--String--64-- */
	private String clxh;

	/** @ --号牌种类代码--hpzldm--String--4-- */
	private String hpzldm;

	/** @ --号牌种类--hpzl--String--32-- */
	private String hpzl;

	/** @ --号牌号码--hphm--String--32-- */
	private String hphm;

	/** @ --车身颜色--csys--String--32-- */
	private String csys;

	/** @ --机动车所有人--syr--String--512-- */
	private String syr;

	/** @ --初次登记时间--ccdjrq--Date---- */
	private Date ccdjrq;

	/** @ --发动机号--fdjh--String--60-- */
	private String fdjh;

	/** @ --车辆识别代号--clsbdh--String--50-- */
	private String clsbdh;

	/** @ --车架号--cjh--String--50-- */
	private String cjh;

	/** 分页排序 */
	private String pageSort;

	/** @ 报警信息ID(bjxxid2) */
	public Integer getBjxxid2() {
		return bjxxid2;
	}

	public void setBjxxid2(Integer bjxxid2) {
		this.bjxxid2 = bjxxid2;
	}

	public Integer getWpbjgzid() {
		return wpbjgzid;
	}

	public void setWpbjgzid(Integer wpbjgzid) {
		this.wpbjgzid = wpbjgzid;
	}

	/** @ 布控物品基本信息快照ID(bkwpjbxxkzid) */
	public Integer getBkwpjbxxkzid() {
		return bkwpjbxxkzid;
	}

	public void setBkwpjbxxkzid(Integer bkwpjbxxkzid) {
		this.bkwpjbxxkzid = bkwpjbxxkzid;
	}

	/** @ 布控车辆快照ID(bkclkzid) */
	public Integer getBkclkzid() {
		return bkclkzid;
	}

	public void setBkclkzid(Integer bkclkzid) {
		this.bkclkzid = bkclkzid;
	}

	/** @ 车辆类型代码(cllxdm) */
	public String getCllxdm() {
		return cllxdm;
	}

	public void setCllxdm(String cllxdm) {
		this.cllxdm = cllxdm;
	}

	/** @ 车辆类型(cllx) */
	public String getCllx() {
		return cllx;
	}

	public void setCllx(String cllx) {
		this.cllx = cllx;
	}

	/** @ 车辆品牌(clpp) */
	public String getClpp() {
		return clpp;
	}

	public void setClpp(String clpp) {
		this.clpp = clpp;
	}

	/** @ 车辆型号(clxh) */
	public String getClxh() {
		return clxh;
	}

	public void setClxh(String clxh) {
		this.clxh = clxh;
	}

	/** @ 号牌种类代码(hpzldm) */
	public String getHpzldm() {
		return hpzldm;
	}

	public void setHpzldm(String hpzldm) {
		this.hpzldm = hpzldm;
	}

	/** @ 号牌种类(hpzl) */
	public String getHpzl() {
		return hpzl;
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	/** @ 号牌号码(hphm) */
	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	/** @ 车身颜色(csys) */
	public String getCsys() {
		return csys;
	}

	public void setCsys(String csys) {
		this.csys = csys;
	}

	/** @ 机动车所有人(syr) */
	public String getSyr() {
		return syr;
	}

	public void setSyr(String syr) {
		this.syr = syr;
	}

	/** @ 初次登记时间(ccdjrq) */
	public Date getCcdjrq() {
		return ccdjrq;
	}

	public void setCcdjrq(Date ccdjrq) {
		this.ccdjrq = ccdjrq;
	}

	/** @ 发动机号(fdjh) */
	public String getFdjh() {
		return fdjh;
	}

	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}

	/** @ 车辆识别代号(clsbdh) */
	public String getClsbdh() {
		return clsbdh;
	}

	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}

	/** @ 车架号(cjh) */
	public String getCjh() {
		return cjh;
	}

	public void setCjh(String cjh) {
		this.cjh = cjh;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
