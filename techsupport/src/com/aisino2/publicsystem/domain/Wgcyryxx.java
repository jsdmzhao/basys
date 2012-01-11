package com.aisino2.publicsystem.domain;

import java.util.Date;

public class Wgcyryxx extends Qyryxx{

	/** @param 外国从业人员信息(t_wgcyryxx) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --从业人员ID--ryid--Integer--10-- */
	private Integer ryid;

	/** @ --英文姓--ywx--String--60-- */
	private String ywx;

	/** @ --英文名--ywm--String--60-- */
	private String ywm;

	/** @ --外国人就业许可证号--wgrjyxkz--String--60-- */
	private String wgrjyxkz;

	/** @ --签证种类代码--qzzldm--String--40-- */
	private String qzzldm;

	/** @ --签证号码--qzhm--String--20-- */
	private String qzhm;

	/** @ --在华停留期至--zatlq--Date---- */
	private Date zatlq;

	/** @ --签发机关--qfjg--String--120-- */
	private String qfjg;

	/** @ --入境日期--rjrq--Date---- */
	private Date rjrq;

	/** @ --入境口岸--rjka--String--60-- */
	private String rjka;

	/** 分页排序 */
	private String pageSort;
	
	
	//已下新增属性为人员的属性
	
	/** @param 企业人员信息(t_qyryxx) */

	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

	/** @ --从业人员编号--cyrybh--String--20-- */
	private String cyrybh;

	/** @ --从业人员类别代码--cyrylbdm--String--2-- */
	private String cyrylbdm;

	/** @ --从业人员类别名称--cyrylbmc--String--30-- */
	private String cyrylbmc;

	/** @ --姓名--xm--String--100-- */
	private String xm;

	/** @ --全名--qm--String--100-- */
	private String qm;

	/** @ --别名--bm--String--30-- */
	private String bm;

	/** @ --姓名拼音--xmpy--String--60-- */
	private String xmpy;

	/** @ --国籍代码--gjdm--String--40-- */
	private String gjdm;

	/** @ --国籍--gj--String--100-- */
	private String gj;

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

	/** @ --婚姻状况代码--hyzkdm--String--2-- */
	private String hyzkdm;

	/** @ --婚姻状况--hyzk--String--4-- */
	private String hyzk;

	/** @ --身高--shengao--Float--5,2-- */
	private Float shengao;

	/** @ --体重--tizh--Float--5,2-- */
	private Float tizh;

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

	/** @ --暂住证号码--zzzhm--String--20-- */
	private String zzzhm;

	/** @ --暂住地址--zzdz--String--200-- */
	private String zzdz;

	/** @ --岗位编号--gwbh--String--4-- */
	private String gwbh;

	/** @ --岗位名称--gwmc--String--60-- */
	private String gwmc;

	/** @ --岗位责任描述--gwzrms--String--2000-- */
	private String gwzrms;

	/** @ --手机--shouji--String--20-- */
	private String shouji;

	/** @ --联系电话--lxdh--String--30-- */
	private String lxdh;

	/** @ --紧急联系人--jjlxr--String--30-- */
	private String jjlxr;

	/** @ --紧急联系人电话--jjlxrdh--String--20-- */
	private String jjlxrdh;

	/** @ --工种代码--gzdm--String--4-- */
	private String gzdm;

	/** @ --工种--gz--String--60-- */
	private String gz;

	/** @ --职务--zhiwu--String--20-- */
	private String zhiwu;

	/** @ --入职日期--rzrq--Date---- */
	private Date rzrq;

	/** @ --从业人员状态代码--cyryztdm--String--2-- */
	private String cyryztdm;

	/** @ --从业人员状态--cyryzt--String--4-- */
	private String cyryzt;

	/** @ --注销人--zxr--String--30-- */
	private String zxr;

	/** @ --注销标志--zxbz--String--2-- */
	private String zxbz;

	/** @ --注销时间--zxsj--Date---- */
	private Date zxsj;

	/** @ --录入时间--lrsj--Date---- */
	private Date lrsj;

	/** @ --录入人--lrr--String--100-- */
	private String lrr;

	/** @ --录入单位编码--lrdwbm--String--20-- */
	private String lrdwbm;

	/** @ --录入单位名称--lrdwmc--String--60-- */
	private String lrdwmc;

	/** @ --核查单位--hcdw--String--100-- */
	private String hcdw;

	/** @ --核查人--hcr--String--30-- */
	private String hcr;

	/** @ --核查时间--hcsj--Date---- */
	private Date hcsj;

	/** @ --注销原因--zxyy--String--200-- */
	private String zxyy;

	/** @ --制卡状态--zkzt--String--4-- */
	private String zkzt;

	/** @ --保存时间--bcsj--Date---- */
	private Date bcsj;

	/** @ --导出标识--dcbs--Integer--2-- */
	private Integer dcbs;

	/** @ --备注--bz--String--2000-- */
	private String bz;

	/** @ --删除标志--scbz--Integer--2-- */
	private Integer scbz;

	/** @ --比对标志--biduiflag--String--1-- */
	private String biduiflag;

	/** @ --照片未通过原因--zpwtgyy--String--2000-- */
	private String zpwtgyy;

	/** @ --状态--zt--String--10-- */
	private String zt;
	
	/** @ --操作类型 */
	private String czlx;
	
	/** @ --操作人-- */
	private String czr;
	
	private String qybm;//企业编码
	private String qymc;//企业名称
	private Integer zpid;//照片id
	private String qyzlmc;
	private Date  lrsjf;//录入开始时间
	private Date  lrsjt;//录入结束时间

	
	private String xxdm;//血型代码
	private String xx;//血型
	
	private String whcd;//文化程度
	private String whcddm;//文化程度代码
	
	/** @ --从业类别代码--cyrylbdm--String--4-- */
	private String cylbdm;

	/** @ --从业类别名称--cyrylbmc--String--60-- */
	private String cylb;
	
	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 从业人员ID(ryid) */
	public Integer getRyid() {
		return ryid;
	}

	public void setRyid(Integer ryid) {
		this.ryid = ryid;
	}

	/** @ 英文姓(ywx) */
	public String getYwx() {
		return ywx;
	}

	public void setYwx(String ywx) {
		this.ywx = ywx;
	}

	/** @ 英文名(ywm) */
	public String getYwm() {
		return ywm;
	}

	public void setYwm(String ywm) {
		this.ywm = ywm;
	}

	/** @ 外国人就业许可证号(wgrjyxkz) */
	public String getWgrjyxkz() {
		return wgrjyxkz;
	}

	public void setWgrjyxkz(String wgrjyxkz) {
		this.wgrjyxkz = wgrjyxkz;
	}

	/** @ 签证种类代码(qzzldm) */
	public String getQzzldm() {
		return qzzldm;
	}

	public void setQzzldm(String qzzldm) {
		this.qzzldm = qzzldm;
	}

	/** @ 签证号码(qzhm) */
	public String getQzhm() {
		return qzhm;
	}

	public void setQzhm(String qzhm) {
		this.qzhm = qzhm;
	}

	/** @ 在华停留期至(zatlq) */
	public Date getZatlq() {
		return zatlq;
	}

	public void setZatlq(Date zatlq) {
		this.zatlq = zatlq;
	}

	/** @ 签发机关(qfjg) */
	public String getQfjg() {
		return qfjg;
	}

	public void setQfjg(String qfjg) {
		this.qfjg = qfjg;
	}

	/** @ 入境日期(rjrq) */
	public Date getRjrq() {
		return rjrq;
	}

	public void setRjrq(Date rjrq) {
		this.rjrq = rjrq;
	}

	/** @ 入境口岸(rjka) */
	public String getRjka() {
		return rjka;
	}

	public void setRjka(String rjka) {
		this.rjka = rjka;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	public String getCyrylbdm() {
		return cyrylbdm;
	}

	public void setCyrylbdm(String cyrylbdm) {
		this.cyrylbdm = cyrylbdm;
	}

	public String getCyrylbmc() {
		return cyrylbmc;
	}

	public void setCyrylbmc(String cyrylbmc) {
		this.cyrylbmc = cyrylbmc;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getQm() {
		return qm;
	}

	public void setQm(String qm) {
		this.qm = qm;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getXmpy() {
		return xmpy;
	}

	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}

	public String getGjdm() {
		return gjdm;
	}

	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
	}

	public String getGj() {
		return gj;
	}

	public void setGj(String gj) {
		this.gj = gj;
	}

	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	public String getMinzu() {
		return minzu;
	}

	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}

	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getHyzkdm() {
		return hyzkdm;
	}

	public void setHyzkdm(String hyzkdm) {
		this.hyzkdm = hyzkdm;
	}

	public String getHyzk() {
		return hyzk;
	}

	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}

	public Float getShengao() {
		return shengao;
	}

	public void setShengao(Float shengao) {
		this.shengao = shengao;
	}

	public Float getTizh() {
		return tizh;
	}

	public void setTizh(Float tizh) {
		this.tizh = tizh;
	}

	public String getHjdxzqh() {
		return hjdxzqh;
	}

	public void setHjdxzqh(String hjdxzqh) {
		this.hjdxzqh = hjdxzqh;
	}

	public String getHjdxzqhdm() {
		return hjdxzqhdm;
	}

	public void setHjdxzqhdm(String hjdxzqhdm) {
		this.hjdxzqhdm = hjdxzqhdm;
	}

	public String getHjdxz() {
		return hjdxz;
	}

	public void setHjdxz(String hjdxz) {
		this.hjdxz = hjdxz;
	}

	public String getCyzjdm() {
		return cyzjdm;
	}

	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}

	public String getCyzj() {
		return cyzj;
	}

	public void setCyzj(String cyzj) {
		this.cyzj = cyzj;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getZzzhm() {
		return zzzhm;
	}

	public void setZzzhm(String zzzhm) {
		this.zzzhm = zzzhm;
	}

	public String getZzdz() {
		return zzdz;
	}

	public void setZzdz(String zzdz) {
		this.zzdz = zzdz;
	}

	public String getGwbh() {
		return gwbh;
	}

	public void setGwbh(String gwbh) {
		this.gwbh = gwbh;
	}

	public String getGwmc() {
		return gwmc;
	}

	public void setGwmc(String gwmc) {
		this.gwmc = gwmc;
	}

	public String getGwzrms() {
		return gwzrms;
	}

	public void setGwzrms(String gwzrms) {
		this.gwzrms = gwzrms;
	}

	public String getShouji() {
		return shouji;
	}

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getJjlxr() {
		return jjlxr;
	}

	public void setJjlxr(String jjlxr) {
		this.jjlxr = jjlxr;
	}

	public String getJjlxrdh() {
		return jjlxrdh;
	}

	public void setJjlxrdh(String jjlxrdh) {
		this.jjlxrdh = jjlxrdh;
	}

	public String getGzdm() {
		return gzdm;
	}

	public void setGzdm(String gzdm) {
		this.gzdm = gzdm;
	}

	public String getGz() {
		return gz;
	}

	public void setGz(String gz) {
		this.gz = gz;
	}

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public Date getRzrq() {
		return rzrq;
	}

	public void setRzrq(Date rzrq) {
		this.rzrq = rzrq;
	}

	public String getCyryztdm() {
		return cyryztdm;
	}

	public void setCyryztdm(String cyryztdm) {
		this.cyryztdm = cyryztdm;
	}

	public String getCyryzt() {
		return cyryzt;
	}

	public void setCyryzt(String cyryzt) {
		this.cyryzt = cyryzt;
	}

	public String getZxr() {
		return zxr;
	}

	public void setZxr(String zxr) {
		this.zxr = zxr;
	}

	public String getZxbz() {
		return zxbz;
	}

	public void setZxbz(String zxbz) {
		this.zxbz = zxbz;
	}

	public Date getZxsj() {
		return zxsj;
	}

	public void setZxsj(Date zxsj) {
		this.zxsj = zxsj;
	}

	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	public String getLrdwbm() {
		return lrdwbm;
	}

	public void setLrdwbm(String lrdwbm) {
		this.lrdwbm = lrdwbm;
	}

	public String getLrdwmc() {
		return lrdwmc;
	}

	public void setLrdwmc(String lrdwmc) {
		this.lrdwmc = lrdwmc;
	}

	public String getHcdw() {
		return hcdw;
	}

	public void setHcdw(String hcdw) {
		this.hcdw = hcdw;
	}

	public String getHcr() {
		return hcr;
	}

	public void setHcr(String hcr) {
		this.hcr = hcr;
	}

	public Date getHcsj() {
		return hcsj;
	}

	public void setHcsj(Date hcsj) {
		this.hcsj = hcsj;
	}

	public String getZxyy() {
		return zxyy;
	}

	public void setZxyy(String zxyy) {
		this.zxyy = zxyy;
	}

	public String getZkzt() {
		return zkzt;
	}

	public void setZkzt(String zkzt) {
		this.zkzt = zkzt;
	}

	public Date getBcsj() {
		return bcsj;
	}

	public void setBcsj(Date bcsj) {
		this.bcsj = bcsj;
	}

	public Integer getDcbs() {
		return dcbs;
	}

	public void setDcbs(Integer dcbs) {
		this.dcbs = dcbs;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Integer getScbz() {
		return scbz;
	}

	public void setScbz(Integer scbz) {
		this.scbz = scbz;
	}

	public String getBiduiflag() {
		return biduiflag;
	}

	public void setBiduiflag(String biduiflag) {
		this.biduiflag = biduiflag;
	}

	public String getZpwtgyy() {
		return zpwtgyy;
	}

	public void setZpwtgyy(String zpwtgyy) {
		this.zpwtgyy = zpwtgyy;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getCzlx() {
		return czlx;
	}

	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}

	public String getCzr() {
		return czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public Integer getZpid() {
		return zpid;
	}

	public void setZpid(Integer zpid) {
		this.zpid = zpid;
	}

	public Date getLrsjf() {
		return lrsjf;
	}

	public void setLrsjf(Date lrsjf) {
		this.lrsjf = lrsjf;
	}

	public Date getLrsjt() {
		return lrsjt;
	}

	public void setLrsjt(Date lrsjt) {
		this.lrsjt = lrsjt;
	}

	public String getQyzlmc() {
		return qyzlmc;
	}

	public void setQyzlmc(String qyzlmc) {
		this.qyzlmc = qyzlmc;
	}

	public String getXxdm() {
		return xxdm;
	}

	public void setXxdm(String xxdm) {
		this.xxdm = xxdm;
	}

	public String getXx() {
		return xx;
	}

	public void setXx(String xx) {
		this.xx = xx;
	}

	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getWhcddm() {
		return whcddm;
	}

	public void setWhcddm(String whcddm) {
		this.whcddm = whcddm;
	}

	public String getCylbdm() {
		return cylbdm;
	}

	public void setCylbdm(String cylbdm) {
		this.cylbdm = cylbdm;
	}

	public String getCylb() {
		return cylb;
	}

	public void setCylb(String cylb) {
		this.cylb = cylb;
	}
}
