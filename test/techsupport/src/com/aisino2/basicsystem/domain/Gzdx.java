package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Gzdx  {

	/** @param 关注对象(t_gzdx) */

	/** @ --关注对象ID--gzdxid--Integer--10-- */
	private Integer gzdxid;

	/** @ --姓名--xm--String--100-- */
	private String xm;

	/** @ --别名--bm--String--30-- */
	private String bm;

	/** @ --姓名拼音--xmpy--String--60-- */
	private String xmpy;

	/** @ --民族代码--mzdm--String--40-- */
	private String mzdm;

	/** @ --民族--minzu--String--20-- */
	private String minzu;

	/** @ --性别代码--xbdm--String--2-- */
	private String xbdm;

	/** @ --性别--xb--String--2-- */
	private String xb;

	/** @ --出生日期--csrq--Date---- */
	private Date csrq;
	
	/** @ --出生日期--csrq--Date---- */
	private Date csrq2;

	/** @ --户籍地行政区划--hjdxzqh--String--200-- */
	private String hjdxzqh;

	/** @ --户籍地行政区划代码--hjdxzqhdm--String--10-- */
	private String hjdxzqhdm;

	/** @ --户籍地详址--hjdxz--String--200-- */
	private String hjdxz;

	/** @ --常用证件代码--cyzjdm--String--40-- */
	private String cyzjdm;

	/** @ --常用证件--cyzj--String--100-- */
	private String cyzj;

	/** @ --证件号码--zjhm--String--20-- */
	private String zjhm;

	/** @ --文化程度编码--whcdbm--String--2-- */
	private String whcdbm;

	/** @ --文化程度--whcd--String--60-- */
	private String whcd;

	/** @ --关注对象身份--gzdxsf--String--100-- */
	private String gzdxsf;

	/** @ --身高--shengao--Float--5,2-- */
	private Float shengao;

	/** @ --现住地区编码--xzdqbm--String--6-- */
	private String xzdqbm;

	/** @ --现住地区--xzdq--String--300-- */
	private String xzdq;

	/** @ --现住地区祥址--xzdqxz--String--2000-- */
	private String xzdqxz;

	/** @ --专长编码--zcbm--String--2-- */
	private String zcbm;

	/** @ --专长--zc--String--100-- */
	private String zc;

	/** @ --填报单位编码--tbdabm--String--60-- */
	private String tbdabm;

	/** @ --填报单位--tbdw--String--100-- */
	private String tbdw;

	/** @ --填表人--tbr--String--100-- */
	private String tbr;

	/** @ --填报日期--tbrq--Date---- */
	private Date tbrq;

	/** @ --注销标志--zxbz--String--2-- */
	private String zxbz;

	/** @ --注销日期--zxrq--Date---- */
	private Date zxrq;

	/** @ --注销人--zxr--String--30-- */
	private String zxr;

	/** @ --备注--bz--String--2000-- */
	private String bz;
	
	
	/** @ --行业类别--bz--String--2000-- */
	private String hylb;
	
	/** @ --行业类别代码--bz--String--2000-- */
	private String hylbdm;

	/** @ --联系电话--lxdh--String--100-- */
	private String lxdh;
	
	/** 分页排序 */
	private String pageSort;
	
	/** 为操作那列传的参数 */
	private String flag;
	

	/** 同音查询 */
	private String tyCheck;
	
	private Integer num;//身份验证用记录数
	
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	/** @ 关注对象ID(gzdxid) */
	public Integer getGzdxid() {
		return gzdxid;
	}

	public void setGzdxid(Integer gzdxid) {
		this.gzdxid = gzdxid;
	}

	/** @ 姓名(xm) */
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	/** @ 别名(bm) */
	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	/** @ 姓名拼音(xmpy) */
	public String getXmpy() {
		return xmpy;
	}

	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}

	/** @ 民族代码(mzdm) */
	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	/** @ 民族(minzu) */
	public String getMinzu() {
		return minzu;
	}

	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}

	/** @ 性别代码(xbdm) */
	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	/** @ 性别(xb) */
	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	/** @ 出生日期(csrq) */
	public Date getCsrq() {
		return csrq;
	}
	/** @ 出生日期(csrq) */
	public Date getCsrq2() {
		return csrq2;
	}
	
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	/** @ 户籍地行政区划(hjdxzqh) */
	public String getHjdxzqh() {
		return hjdxzqh;
	}

	public void setHjdxzqh(String hjdxzqh) {
		this.hjdxzqh = hjdxzqh;
	}

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	public String getHjdxzqhdm() {
		return hjdxzqhdm;
	}

	public void setHjdxzqhdm(String hjdxzqhdm) {
		this.hjdxzqhdm = hjdxzqhdm;
	}

	/** @ 户籍地详址(hjdxz) */
	public String getHjdxz() {
		return hjdxz;
	}

	public void setHjdxz(String hjdxz) {
		this.hjdxz = hjdxz;
	}

	/** @ 常用证件代码(cyzjdm) */
	public String getCyzjdm() {
		return cyzjdm;
	}

	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}

	/** @ 常用证件(cyzj) */
	public String getCyzj() {
		return cyzj;
	}

	public void setCyzj(String cyzj) {
		this.cyzj = cyzj;
	}

	/** @ 证件号码(zjhm) */
	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	/** @ 文化程度编码(whcdbm) */
	public String getWhcdbm() {
		return whcdbm;
	}

	public void setWhcdbm(String whcdbm) {
		this.whcdbm = whcdbm;
	}

	/** @ 文化程度(whcd) */
	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	/** @ 关注对象身份(gzdxsf) */
	public String getGzdxsf() {
		return gzdxsf;
	}

	public void setGzdxsf(String gzdxsf) {
		this.gzdxsf = gzdxsf;
	}

	/** @ 身高(shengao) */
	public Float getShengao() {
		return shengao;
	}

	public void setShengao(Float shengao) {
		this.shengao = shengao;
	}

	/** @ 现住地区编码(xzdqbm) */
	public String getXzdqbm() {
		return xzdqbm;
	}

	public void setXzdqbm(String xzdqbm) {
		this.xzdqbm = xzdqbm;
	}

	/** @ 现住地区(xzdq) */
	public String getXzdq() {
		return xzdq;
	}

	public void setXzdq(String xzdq) {
		this.xzdq = xzdq;
	}

	/** @ 现住地区祥址(xzdqxz) */
	public String getXzdqxz() {
		return xzdqxz;
	}

	public void setXzdqxz(String xzdqxz) {
		this.xzdqxz = xzdqxz;
	}

	/** @ 专长编码(zcbm) */
	public String getZcbm() {
		return zcbm;
	}

	public void setZcbm(String zcbm) {
		this.zcbm = zcbm;
	}

	/** @ 专长(zc) */
	public String getZc() {
		return zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	/** @ 填报单位编码(tbdabm) */
	public String getTbdabm() {
		return tbdabm;
	}

	public void setTbdabm(String tbdabm) {
		this.tbdabm = tbdabm;
	}

	/** @ 填报单位(tbdw) */
	public String getTbdw() {
		return tbdw;
	}

	public void setTbdw(String tbdw) {
		this.tbdw = tbdw;
	}

	/** @ 填表人(tbr) */
	public String getTbr() {
		return tbr;
	}

	public void setTbr(String tbr) {
		this.tbr = tbr;
	}

	/** @ 填报日期(tbrq) */
	public Date getTbrq() {
		return tbrq;
	}

	public void setTbrq(Date tbrq) {
		this.tbrq = tbrq;
	}

	/** @ 注销标志(zxbz) */
	public String getZxbz() {
		return zxbz;
	}

	public void setZxbz(String zxbz) {
		this.zxbz = zxbz;
	}

	/** @ 注销日期(zxrq) */
	public Date getZxrq() {
		return zxrq;
	}

	public void setZxrq(Date zxrq) {
		this.zxrq = zxrq;
	}

	/** @ 注销人(zxr) */
	public String getZxr() {
		return zxr;
	}

	public void setZxr(String zxr) {
		this.zxr = zxr;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setCsrq2(Date csrq2) {
		this.csrq2 = csrq2;
	}

	public String getTyCheck() {
		return tyCheck;
	}

	public void setTyCheck(String tyCheck) {
		this.tyCheck = tyCheck;
	}

	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
