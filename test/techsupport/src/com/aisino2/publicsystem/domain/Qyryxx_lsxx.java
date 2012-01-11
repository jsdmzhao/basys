package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyryxx_lsxx  {

	/** @param 企业人员历史信息(t_qyryxx_lsxx) */

	/** @ --人员历史ID--rylsid--Integer--10-- */
	private Integer rylsid;

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --从业人员ID--ryid--Integer--10-- */
	private Integer ryid;

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
	
	/** @ --从业人员类别代码--cyrylbdm--String--4-- */
	private String cylbdm;

	/** @ --从业人员类别名称--cyrylbmc--String--60-- */
	private String cylb;

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

	/** @ --操作类型--czlx--String--40-- */
	private String czlx;

	/** @ --变更原因--bgyy--String--2000-- */
	private String bgyy;

	/** @ --变更类别代码--bglbdm--String--2-- */
	private String bglbdm;

	/** @ --变更类别--bglb--String--60-- */
	private String bglb;

	/** @ --工种代码--gzdm--String--4-- */
	private String gzdm;

	/** @ --工种--gz--String--60-- */
	private String gz;
	
	/** @ --预警标志 0-未预警 1-已预警-- */
	private String yjbz;
	
	/** @ --预警时间--yjsj--Date---- */
	private Date yjsj;
	
	
	private String qymc;//企业名称
	
	private String qybm;//企业编码
	private String kh;//卡号
	
	/** 离职时间 */
	private Date lzrq;

	/** 分页排序 */
	private String pageSort;

	private String xxdm;//血型代码
	private String xx;//血型
	
	private String whcd;//文化程度
	private String whcddm;//文化程度代码
	private String djrq;//文化程度
	/** @ 人员历史ID(rylsid) */
	public Integer getRylsid() {
		return rylsid;
	}

	public void setRylsid(Integer rylsid) {
		this.rylsid = rylsid;
	}

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

	/** @ 行业类别代码(hylbdm) */
	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	/** @ 行业类别(hylb) */
	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	/** @ 从业人员编号(cyrybh) */
	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	/** @ 从业人员类别代码(cyrylbdm) */
	public String getCyrylbdm() {
		return cyrylbdm;
	}

	public void setCyrylbdm(String cyrylbdm) {
		this.cyrylbdm = cyrylbdm;
	}

	/** @ 从业人员类别名称(cyrylbmc) */
	public String getCyrylbmc() {
		return cyrylbmc;
	}

	public void setCyrylbmc(String cyrylbmc) {
		this.cyrylbmc = cyrylbmc;
	}

	/** @ 姓名(xm) */
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	/** @ 全名(qm) */
	public String getQm() {
		return qm;
	}

	public void setQm(String qm) {
		this.qm = qm;
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

	/** @ 国籍代码(gjdm) */
	public String getGjdm() {
		return gjdm;
	}

	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
	}

	/** @ 国籍(gj) */
	public String getGj() {
		return gj;
	}

	public void setGj(String gj) {
		this.gj = gj;
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

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	/** @ 婚姻状况代码(hyzkdm) */
	public String getHyzkdm() {
		return hyzkdm;
	}

	public void setHyzkdm(String hyzkdm) {
		this.hyzkdm = hyzkdm;
	}

	/** @ 婚姻状况(hyzk) */
	public String getHyzk() {
		return hyzk;
	}

	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}

	/** @ 身高(shengao) */
	public Float getShengao() {
		return shengao;
	}

	public void setShengao(Float shengao) {
		this.shengao = shengao;
	}

	/** @ 体重(tizh) */
	public Float getTizh() {
		return tizh;
	}

	public void setTizh(Float tizh) {
		this.tizh = tizh;
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

	/** @ 暂住证号码(zzzhm) */
	public String getZzzhm() {
		return zzzhm;
	}

	public void setZzzhm(String zzzhm) {
		this.zzzhm = zzzhm;
	}

	/** @ 暂住地址(zzdz) */
	public String getZzdz() {
		return zzdz;
	}

	public void setZzdz(String zzdz) {
		this.zzdz = zzdz;
	}

	/** @ 岗位编号(gwbh) */
	public String getGwbh() {
		return gwbh;
	}

	public void setGwbh(String gwbh) {
		this.gwbh = gwbh;
	}

	/** @ 岗位名称(gwmc) */
	public String getGwmc() {
		return gwmc;
	}

	public void setGwmc(String gwmc) {
		this.gwmc = gwmc;
	}

	/** @ 岗位责任描述(gwzrms) */
	public String getGwzrms() {
		return gwzrms;
	}

	public void setGwzrms(String gwzrms) {
		this.gwzrms = gwzrms;
	}

	/** @ 手机(shouji) */
	public String getShouji() {
		return shouji;
	}

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}

	/** @ 联系电话(lxdh) */
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	/** @ 紧急联系人(jjlxr) */
	public String getJjlxr() {
		return jjlxr;
	}

	public void setJjlxr(String jjlxr) {
		this.jjlxr = jjlxr;
	}

	/** @ 紧急联系人电话(jjlxrdh) */
	public String getJjlxrdh() {
		return jjlxrdh;
	}

	public void setJjlxrdh(String jjlxrdh) {
		this.jjlxrdh = jjlxrdh;
	}

	/** @ 职务(zhiwu) */
	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	/** @ 入职日期(rzrq) */
	public Date getRzrq() {
		return rzrq;
	}

	public void setRzrq(Date rzrq) {
		this.rzrq = rzrq;
	}

	/** @ 从业人员状态代码(cyryztdm) */
	public String getCyryztdm() {
		return cyryztdm;
	}

	public void setCyryztdm(String cyryztdm) {
		this.cyryztdm = cyryztdm;
	}

	/** @ 从业人员状态(cyryzt) */
	public String getCyryzt() {
		return cyryzt;
	}

	public void setCyryzt(String cyryzt) {
		this.cyryzt = cyryzt;
	}

	/** @ 注销人(zxr) */
	public String getZxr() {
		return zxr;
	}

	public void setZxr(String zxr) {
		this.zxr = zxr;
	}

	/** @ 注销标志(zxbz) */
	public String getZxbz() {
		return zxbz;
	}

	public void setZxbz(String zxbz) {
		this.zxbz = zxbz;
	}

	/** @ 注销时间(zxsj) */
	public Date getZxsj() {
		return zxsj;
	}

	public void setZxsj(Date zxsj) {
		this.zxsj = zxsj;
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

	/** @ 录入单位编码(lrdwbm) */
	public String getLrdwbm() {
		return lrdwbm;
	}

	public void setLrdwbm(String lrdwbm) {
		this.lrdwbm = lrdwbm;
	}

	/** @ 录入单位名称(lrdwmc) */
	public String getLrdwmc() {
		return lrdwmc;
	}

	public void setLrdwmc(String lrdwmc) {
		this.lrdwmc = lrdwmc;
	}

	/** @ 核查单位(hcdw) */
	public String getHcdw() {
		return hcdw;
	}

	public void setHcdw(String hcdw) {
		this.hcdw = hcdw;
	}

	/** @ 核查人(hcr) */
	public String getHcr() {
		return hcr;
	}

	public void setHcr(String hcr) {
		this.hcr = hcr;
	}

	/** @ 核查时间(hcsj) */
	public Date getHcsj() {
		return hcsj;
	}

	public void setHcsj(Date hcsj) {
		this.hcsj = hcsj;
	}

	/** @ 注销原因(zxyy) */
	public String getZxyy() {
		return zxyy;
	}

	public void setZxyy(String zxyy) {
		this.zxyy = zxyy;
	}

	/** @ 制卡状态(zkzt) */
	public String getZkzt() {
		return zkzt;
	}

	public void setZkzt(String zkzt) {
		this.zkzt = zkzt;
	}

	/** @ 保存时间(bcsj) */
	public Date getBcsj() {
		return bcsj;
	}

	public void setBcsj(Date bcsj) {
		this.bcsj = bcsj;
	}

	/** @ 导出标识(dcbs) */
	public Integer getDcbs() {
		return dcbs;
	}

	public void setDcbs(Integer dcbs) {
		this.dcbs = dcbs;
	}

	/** @ 备注(bz) */
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	/** @ 删除标志(scbz) */
	public Integer getScbz() {
		return scbz;
	}

	public void setScbz(Integer scbz) {
		this.scbz = scbz;
	}

	/** @ 比对标志(biduiflag) */
	public String getBiduiflag() {
		return biduiflag;
	}

	public void setBiduiflag(String biduiflag) {
		this.biduiflag = biduiflag;
	}

	/** @ 照片未通过原因(zpwtgyy) */
	public String getZpwtgyy() {
		return zpwtgyy;
	}

	public void setZpwtgyy(String zpwtgyy) {
		this.zpwtgyy = zpwtgyy;
	}

	/** @ 状态(zt) */
	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
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

	/** @ 操作类型(czlx) */
	public String getCzlx() {
		return czlx;
	}

	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}

	/** @ 变更原因(bgyy) */
	public String getBgyy() {
		return bgyy;
	}

	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}

	/** @ 变更类别代码(bglbdm) */
	public String getBglbdm() {
		return bglbdm;
	}

	public void setBglbdm(String bglbdm) {
		this.bglbdm = bglbdm;
	}

	/** @ 变更类别(bglb) */
	public String getBglb() {
		return bglb;
	}

	public void setBglb(String bglb) {
		this.bglb = bglb;
	}

	/** @ 工种代码(gzdm) */
	public String getGzdm() {
		return gzdm;
	}

	public void setGzdm(String gzdm) {
		this.gzdm = gzdm;
	}

	/** @ 工种(gz) */
	public String getGz() {
		return gz;
	}

	public void setGz(String gz) {
		this.gz = gz;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
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
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}

	public Date getLzrq() {
		return lzrq;
	}

	public void setLzrq(Date lzrq) {
		this.lzrq = lzrq;
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

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
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

	public String getYjbz() {
		return yjbz;
	}

	public void setYjbz(String yjbz) {
		this.yjbz = yjbz;
	}

	public Date getYjsj() {
		return yjsj;
	}

	public void setYjsj(Date yjsj) {
		this.yjsj = yjsj;
	}

	public String getDjrq() {
		return djrq;
	}

	public void setDjrq(String djrq) {
		this.djrq = djrq;
	}
}
