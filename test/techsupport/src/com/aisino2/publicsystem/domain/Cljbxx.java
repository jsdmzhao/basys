package com.aisino2.publicsystem.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.core.domain.BaseObject;

public class Cljbxx  {

	/** @param 车辆基本信息(t_cljbxx) */

	/** @ --车辆基本信息ID--cljbxxid--Integer--10-- */
	private Integer cljbxxid;
	
	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --车辆登记序号--cldjxh--String--24-- */
	private String cldjxh;

	/** @ --车辆类型编码--cllxbm--String--1-- */
	private String cllxbm;

	/** @ --车辆类型--cllx--String--32-- */
	private String cllx;

	/** @ --车辆品牌编码--clppbm--String--10-- */
	private String clppbm;

	/** @ --车辆品牌--clpp--String--32-- */
	private String clpp;

	/** @ --车身主色编码--cszsbm--String--3-- */
	private String cszsbm;

	/** @ --车身主色--cszs--String--4-- */
	private String cszs;

	/** @ --第一辅色编码--dyfsbm--String--3-- */
	private String dyfsbm;

	/** @ --第一辅色--dyfs--String--4-- */
	private String dyfs;

	/** @ --第二辅色编码--drfsbm--String--3-- */
	private String drfsbm;

	/** @ --第二辅色--drfs--String--4-- */
	private String drfs;

	/** @ --车牌号--cph--String--15-- */
	private String cph;

	/** @ --是否有车牌标志--sfycphbz--String--1-- */
	private String sfycphbz;

	/** @ --无车牌号原因编码--wcphyybm--String--2-- */
	private String wcphyybm;

	/** @ --无车牌号原因--wcphyy--String--32-- */
	private String wcphyy;

	/** @ --无车牌号原因描述--wcphyyms--String--100-- */
	private String wcphyyms;

	/** @ --号牌种类编码--hpzlbm--String--2-- */
	private String hpzlbm;

	/** @ --号牌种类--hpzl--String--24-- */
	private String hpzl;

	/** @ --发动机号--fdjh--String--30-- */
	private String fdjh;

	/** @ --车架号--cjh--String--30-- */
	private String cjh;

	/** @ --受理时间--slsj--Date---- */
	private Date slsj;

	/** @ --受理人--slr--String--100-- */
	private String slr;

	/** @ --录入时间--lrsj--Date---- */
	private Date lrsj;

	/** @ --录入人--lrr--String--100-- */
	private String lrr;

	/** @ --撤销时间--cxsj--Date---- */
	private Date cxsj;

	/** @ --撤销标志--cxbz--String--2-- */
	private String cxbz;

	/** @ --撤销人--cxr--String--30-- */
	private String cxr;

	/** @ --车辆性质编码--clxzbm--String--2-- */
	private String clxzbm;

	/** @ --车辆性质--clxz--String--24-- */
	private String clxz;

	/** @ --车主--czm--String--50-- */
	private String czm;

	/** @ --车主电话--czdh--String--20-- */
	private String czdh;

	/** @ --车主国籍代码--czgjdm--String--3-- */
	private String czgjdm;

	/** @ --车主国籍--czgj--String--40-- */
	private String czgj;

	/** @ --车主户籍地址--czhjdz--String--200-- */
	private String czhjdz;

	/** @ --车主行政区划代码--czxzqhdm--String--6-- */
	private String czxzqhdm;

	/** @ --车主行政区划--czxzqh--String--200-- */
	private String czxzqh;

	/** @ --车主性别代码--czxbdm--String--1-- */
	private String czxbdm;

	/** @ --车主性别--czxb--String--2-- */
	private String czxb;

	/** @ --车主常用证件类型代码--czcyzjlxdm--String--4-- */
	private String czcyzjlxdm;

	/** @ --车主常用证件--czcyzj--String--40-- */
	private String czcyzj;

	/** @ --车主证件号码--czzjhm--String--20-- */
	private String czzjhm;

	/** @ --行驶里程--xslc--Integer--10-- */
	private Integer xslc;

	/** @ --车辆状态--clzt--String--2-- */
	private String clzt;

	/** @ --备注--bz--String--2000-- */
	private String bz;

	/** @ --车牌号简称代码--cphjcdm--String--2-- */
	private String cphjcdm;

	/** @ --车牌号简称--cphjc--String--2-- */
	private String cphjc;

	/** @ --车牌号序号--cphxh--String--13-- */
	private String cphxh;
	
	/** @ --车主状态--czzt--String--2-- */
	private String czzt;

	/** @ --出厂日期--ccrq--Date-- */
	private Date ccrq;

	/** 分页排序 */
	private String pageSort;
	
	/** 车辆信息_照片 */
	private List lClxx_zpList;
	
	/** 车辆信息人员_照片 */
	private List<Clxxry_zp> lClxxry_zpList;
	
	/** @ --车辆产地--clcd--String--24-- */
	private String clcd;
	/** @ --车辆产地编码--clcdbm--String--2-- */
	private String clcdbm;
	/** @ --车辆厂商--clcs--String--200-- */
	private String clcs;
	/** @ --车辆厂商编码--clcsbm--String--10-- */
	private String clcsbm;
	/** @ --车辆型号--clxh--String--100-- */
	private String clxh;
	/** @ --车辆型号编码--clxhbm--String--10-- */
	private String clxhbm;
	private Clxxwgryxx clxxwgryxx;
	private String qymc;
	private String qybm;
	private String hylbdm;
	private String gxdwdm;
	private String czxzdz;//车主现住地址
	private String czxzdxzqh;//车主现住地行政区划
	private String czxzdxzqhdm;//车主现住地行政区划代码
	/** @ 参数Map传入参数:(wplb:物品类别(报警用) qyid:企业ID(报警用)qybm:企业编码(生成车辆登记序号用)) 传出参数:(biduiflag:比对标志(报警用))*/
	private Map parameterMap;

	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	public String getCzzt() {
		return czzt;
	}

	public void setCzzt(String czzt) {
		this.czzt = czzt;
	}

	public Map getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map parameterMap) {
		this.parameterMap = parameterMap;
	}

	public String getCphjcdm() {
		return cphjcdm;
	}

	public void setCphjcdm(String cphjcdm) {
		this.cphjcdm = cphjcdm;
	}

	public String getCphjc() {
		return cphjc;
	}

	public void setCphjc(String cphjc) {
		this.cphjc = cphjc;
	}

	public String getCphxh() {
		return cphxh;
	}

	public void setCphxh(String cphxh) {
		this.cphxh = cphxh;
	}

	public Clxxwgryxx getClxxwgryxx() {
		return clxxwgryxx;
	}

	public void setClxxwgryxx(Clxxwgryxx clxxwgryxx) {
		this.clxxwgryxx = clxxwgryxx;
	}

	public List getLClxx_zpList() {
		return lClxx_zpList;
	}

	public List getLClxxry_zpList() {
		return lClxxry_zpList;
	}

	public void setLClxxry_zpList(List clxxry_zpList) {
		lClxxry_zpList = clxxry_zpList;
	}

	public void setLClxx_zpList(List clxx_zpList) {
		lClxx_zpList = clxx_zpList;
	}


	/** @ 车辆基本信息ID(cljbxxid) */
	public Integer getCljbxxid() {
		return cljbxxid;
	}

	public void setCljbxxid(Integer cljbxxid) {
		this.cljbxxid = cljbxxid;
	}

	/** @ 车辆登记序号(cldjxh) */
	public String getCldjxh() {
		return cldjxh;
	}

	public void setCldjxh(String cldjxh) {
		this.cldjxh = cldjxh;
	}

	/** @ 车辆类型编码(cllxbm) */
	public String getCllxbm() {
		return cllxbm;
	}

	public void setCllxbm(String cllxbm) {
		this.cllxbm = cllxbm;
	}

	/** @ 车辆类型(cllx) */
	public String getCllx() {
		return cllx;
	}

	public void setCllx(String cllx) {
		this.cllx = cllx;
	}

	/** @ 车辆品牌编码(clppbm) */
	public String getClppbm() {
		return clppbm;
	}

	public void setClppbm(String clppbm) {
		this.clppbm = clppbm;
	}

	/** @ 车辆品牌(clpp) */
	public String getClpp() {
		return clpp;
	}

	public void setClpp(String clpp) {
		this.clpp = clpp;
	}

	/** @ 车身主色编码(cszsbm) */
	public String getCszsbm() {
		return cszsbm;
	}

	public void setCszsbm(String cszsbm) {
		this.cszsbm = cszsbm;
	}

	/** @ 车身主色(cszs) */
	public String getCszs() {
		return cszs;
	}

	public void setCszs(String cszs) {
		this.cszs = cszs;
	}

	/** @ 第一辅色编码(dyfsbm) */
	public String getDyfsbm() {
		return dyfsbm;
	}

	public void setDyfsbm(String dyfsbm) {
		this.dyfsbm = dyfsbm;
	}

	/** @ 第一辅色(dyfs) */
	public String getDyfs() {
		return dyfs;
	}

	public void setDyfs(String dyfs) {
		this.dyfs = dyfs;
	}

	/** @ 第二辅色编码(drfsbm) */
	public String getDrfsbm() {
		return drfsbm;
	}

	public void setDrfsbm(String drfsbm) {
		this.drfsbm = drfsbm;
	}

	/** @ 第二辅色(drfs) */
	public String getDrfs() {
		return drfs;
	}

	public void setDrfs(String drfs) {
		this.drfs = drfs;
	}

	/** @ 车牌号(cph) */
	public String getCph() {
		return cph;
	}

	public void setCph(String cph) {
		this.cph = cph;
	}

	/** @ 是否有车牌标志(sfycphbz) */
	public String getSfycphbz() {
		return sfycphbz;
	}

	public void setSfycphbz(String sfycphbz) {
		this.sfycphbz = sfycphbz;
	}

	/** @ 无车牌号原因编码(wcphyybm) */
	public String getWcphyybm() {
		return wcphyybm;
	}

	public void setWcphyybm(String wcphyybm) {
		this.wcphyybm = wcphyybm;
	}

	/** @ 无车牌号原因(wcphyy) */
	public String getWcphyy() {
		return wcphyy;
	}

	public void setWcphyy(String wcphyy) {
		this.wcphyy = wcphyy;
	}

	/** @ 无车牌号原因描述(wcphyyms) */
	public String getWcphyyms() {
		return wcphyyms;
	}

	public void setWcphyyms(String wcphyyms) {
		this.wcphyyms = wcphyyms;
	}

	/** @ 号牌种类编码(hpzlbm) */
	public String getHpzlbm() {
		return hpzlbm;
	}

	public void setHpzlbm(String hpzlbm) {
		this.hpzlbm = hpzlbm;
	}

	/** @ 号牌种类(hpzl) */
	public String getHpzl() {
		return hpzl;
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	/** @ 发动机号(fdjh) */
	public String getFdjh() {
		return fdjh;
	}

	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}

	/** @ 车架号(cjh) */
	public String getCjh() {
		return cjh;
	}

	public void setCjh(String cjh) {
		this.cjh = cjh;
	}

	/** @ 受理时间(slsj) */
	public Date getSlsj() {
		return slsj;
	}

	public void setSlsj(Date slsj) {
		this.slsj = slsj;
	}

	/** @ 受理人(slr) */
	public String getSlr() {
		return slr;
	}

	public void setSlr(String slr) {
		this.slr = slr;
	}

	/** @ 录入时间(lrsj) */
	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	/** @ 录入人(lrr) */
	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	/** @ 撤销时间(cxsj) */
	public Date getCxsj() {
		return cxsj;
	}

	public void setCxsj(Date cxsj) {
		this.cxsj = cxsj;
	}

	/** @ 撤销标志(cxbz) */
	public String getCxbz() {
		return cxbz;
	}

	public void setCxbz(String cxbz) {
		this.cxbz = cxbz;
	}

	/** @ 撤销人(cxr) */
	public String getCxr() {
		return cxr;
	}

	public void setCxr(String cxr) {
		this.cxr = cxr;
	}

	/** @ 车辆性质(clxz) */
	public String getClxz() {
		return clxz;
	}

	public void setClxz(String clxz) {
		this.clxz = clxz;
	}

	/** @ 车主(czm) */
	public String getCzm() {
		return czm;
	}

	public void setCzm(String czm) {
		this.czm = czm;
	}

	/** @ 车主电话(czdh) */
	public String getCzdh() {
		return czdh;
	}

	public void setCzdh(String czdh) {
		this.czdh = czdh;
	}

	/** @ 车主国籍代码(czgjdm) */
	public String getCzgjdm() {
		return czgjdm;
	}

	public void setCzgjdm(String czgjdm) {
		this.czgjdm = czgjdm;
	}

	/** @ 车主国籍(czgj) */
	public String getCzgj() {
		return czgj;
	}

	public void setCzgj(String czgj) {
		this.czgj = czgj;
	}

	/** @ 车主户籍地址(czhjdz) */
	public String getCzhjdz() {
		return czhjdz;
	}

	public void setCzhjdz(String czhjdz) {
		this.czhjdz = czhjdz;
	}

	/** @ 车主行政区划代码(czxzqhdm) */
	public String getCzxzqhdm() {
		return czxzqhdm;
	}

	public void setCzxzqhdm(String czxzqhdm) {
		this.czxzqhdm = czxzqhdm;
	}

	/** @ 车主行政区划(czxzqh) */
	public String getCzxzqh() {
		return czxzqh;
	}

	public void setCzxzqh(String czxzqh) {
		this.czxzqh = czxzqh;
	}

	/** @ 车主性别代码(czxbdm) */
	public String getCzxbdm() {
		return czxbdm;
	}

	public void setCzxbdm(String czxbdm) {
		this.czxbdm = czxbdm;
	}

	/** @ 车主性别(czxb) */
	public String getCzxb() {
		return czxb;
	}

	public void setCzxb(String czxb) {
		this.czxb = czxb;
	}

	/** @ 车主常用证件类型代码(czcyzjlxdm) */
	public String getCzcyzjlxdm() {
		return czcyzjlxdm;
	}

	public void setCzcyzjlxdm(String czcyzjlxdm) {
		this.czcyzjlxdm = czcyzjlxdm;
	}

	/** @ 车主常用证件(czcyzj) */
	public String getCzcyzj() {
		return czcyzj;
	}

	public void setCzcyzj(String czcyzj) {
		this.czcyzj = czcyzj;
	}

	/** @ 车主证件号码(czzjhm) */
	public String getCzzjhm() {
		return czzjhm;
	}

	public void setCzzjhm(String czzjhm) {
		this.czzjhm = czzjhm;
	}

	/** @ 行驶里程(xslc) */
	public Integer getXslc() {
		return xslc;
	}

	public void setXslc(Integer xslc) {
		this.xslc = xslc;
	}

	/** @ 车辆状态(clzt) */
	public String getClzt() {
		return clzt;
	}

	public void setClzt(String clzt) {
		this.clzt = clzt;
	}

	/** @ 备注(bz) */
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getClxzbm() {
		return clxzbm;
	}

	public void setClxzbm(String clxzbm) {
		this.clxzbm = clxzbm;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getCcrq() {
		return ccrq;
	}

	public void setCcrq(Date ccrq) {
		this.ccrq = ccrq;
	}

	public String getClcd() {
		return clcd;
	}

	public void setClcd(String clcd) {
		this.clcd = clcd;
	}

	public String getClcdbm() {
		return clcdbm;
	}

	public void setClcdbm(String clcdbm) {
		this.clcdbm = clcdbm;
	}

	public String getClcs() {
		return clcs;
	}

	public void setClcs(String clcs) {
		this.clcs = clcs;
	}

	public String getClcsbm() {
		return clcsbm;
	}

	public void setClcsbm(String clcsbm) {
		this.clcsbm = clcsbm;
	}

	public String getClxh() {
		return clxh;
	}

	public void setClxh(String clxh) {
		this.clxh = clxh;
	}

	public String getClxhbm() {
		return clxhbm;
	}

	public void setClxhbm(String clxhbm) {
		this.clxhbm = clxhbm;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		this.qybm = qybm;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public String getGxdwdm() {
		return gxdwdm;
	}

	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
	}

	public String getCzxzdz() {
		return czxzdz;
	}

	public void setCzxzdz(String czxzdz) {
		this.czxzdz = czxzdz;
	}

	public String getCzxzdxzqh() {
		return czxzdxzqh;
	}

	public void setCzxzdxzqh(String czxzdxzqh) {
		this.czxzdxzqh = czxzdxzqh;
	}

	public String getCzxzdxzqhdm() {
		return czxzdxzqhdm;
	}

	public void setCzxzdxzqhdm(String czxzdxzqhdm) {
		this.czxzdxzqhdm = czxzdxzqhdm;
	}
	
}
