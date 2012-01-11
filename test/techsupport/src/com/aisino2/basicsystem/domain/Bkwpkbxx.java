package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Bkwpkbxx  {

	/** @param 布控物品基本信息(t_bkwpkbxx) */

	/** @ --布控物品基本信息ID--bkwpjbxxid--Integer--10-- */
	private Integer bkwpjbxxid;

	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--100-- */
	private String hylb;

	/** @ --布控物品类型代码--bkwplxdm--String--2-- */
	private String bkwplxdm;

	/** @ --布控物品类型--bkwplx--String--20-- */
	private String bkwplx;

	/** @ --布控物品名称--bkwpmc--String--30-- */
	private String bkwpmc;

	/** @ --布控物品描述--bkwpms--String--2000-- */
	private String bkwpms;

	/** @ --发文单位--fwdw--String--100-- */
	private String fwdw;

	/** @ --发文单位编码--fwdwbm--String--60-- */
	private String fwdwbm;

	/** @ --案件类别编码--ajlbbm--String--30-- */
	private String ajlbbm;

	/** @ --案件类别--ajlb--String--60-- */
	private String ajlb;

	/** @ --通报编号--tbbh--String--30-- */
	private String tbbh;

	/** @ --通报时间--tbsj2--Date---- */
	private Date tbsj2;

	/** @ --简要案情--jyaq--String--2000-- */
	private String jyaq;

	/** @ --处理结果--cljg--String--2000-- */
	private String cljg;

	/** @ --布控人--bkr--String--100-- */
	private String bkr;

	/** @ --布控操作员--bkczy--String--100-- */
	private String bkczy;

	/** @ --布控操作时间--bkczsj--Date---- */
	private Date bkczsj;
	
	
	private Date bkczsjks;   ///布控开始时间
	
	private Date bkczsjjs;   //布控结束时间

	/** @ --布控到期时间--bkdqsj--Date---- */
	private Date bkdqsj;

	/** @ --布控范围编码--bkfwbm--String--2-- */
	private String bkfwbm;

	/** @ --布控范围--bkfw--String--300-- */
	private String bkfw;

	/** @ --布控审批意见--bkspyj--String--2000-- */
	private String bkspyj;

	/** @ --联系人--lxr--String--100-- */
	private String lxr;

	/** @ --联系方式--lxfs--String--300-- */
	private String lxfs;

	/** @ --是否同意发布--sftyfb--String--2-- */
	private String sftyfb;

	/** @ --审批单位--spdw--String--100-- */
	private String spdw;

	/** @ --审批人--spr2--String--100-- */
	private String spr2;

	/** @ --审批日期--sprq--Date---- */
	private Date sprq;

	/** @ --请求撤控标识--qqckbs--String--2-- */
	private String qqckbs;

	/** @ --撤控标识--ckbs--String--2-- */
	private String ckbs;

	/** @ --撤控原因--ckyy--String--2000-- */
	private String ckyy;

	/** @ --撤控时间--cksj--Date---- */
	private Date cksj;

	/** @ --撤控人--ckr--String--100-- */
	private String ckr;

	/** @ --撤控操作员--ckczy--String--100-- */
	private String ckczy;

	/** @ --撤控操作时间--ckczsj--Date---- */
	private Date ckczsj;

	/** @ --撤控部门编码--ckbmbm--String--60-- */
	private String ckbmbm;

	/** @ --撤控部门名称--ckbmmc--String--100-- */
	private String ckbmmc;

	/** @ --撤控审批单位--ckspdw--String--100-- */
	private String ckspdw;

	/** @ --撤控审批人--ckspr--String--100-- */
	private String ckspr;

	/** @ --撤控审批意见--ckspyj--String--2000-- */
	private String ckspyj;

	/** @ --撤控审批日期--cksprq--Date---- */
	private Date cksprq;

	/** @ --行政区划--xzqh--String--100-- */
	private String xzqh;

	/** @ --发送标识--fsbs--String--2-- */
	private String fsbs;

	/** @ --布控对象照片--bkdxzp--byte[]---- */
	private byte[] bkdxzp;

	/** @ --物品简拼--wpjp--String--200-- */
	private String wpjp;
	
	private String shjg;    ///审核结果
	
	private String shyj;    ///审核意见
	
	private String fileload;   //文件传输
	
	private String cmdID; // 页面区分ID
	
	private String tyCheck; // 同音检索check
	
	private Bkcl bkcl;  ///布控车辆
	
	private Bksj bksj;  ///布控手机
	
	private String wpqp; //物品全拼
	
	///////车辆内容
	
	/** @ --布控车辆ID--bkclid--Integer--10-- */
	private Integer bkclid;

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
	
	///////手机内容
	
	/** @ --布控手机ID--bksjid--Integer--10-- */
	private Integer bksjid;

	/** @ --手机串号--sjch--String--30-- */
	private String sjch;

	/** @ --品牌--pp--String--100-- */
	private String pp;

	/** @ --型号--xh--String--100-- */
	private String xh;

	/** @ --颜色--ys--String--60-- */
	private String ys;
	
	

	/** 分页排序 */
	private String pageSort;

	/** @ 布控物品基本信息ID(bkwpjbxxid) */
	public Integer getBkwpjbxxid() {
		return bkwpjbxxid;
	}

	public void setBkwpjbxxid(Integer bkwpjbxxid) {
		this.bkwpjbxxid = bkwpjbxxid;
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

	/** @ 布控物品类型代码(bkwplxdm) */
	public String getBkwplxdm() {
		return bkwplxdm;
	}

	public void setBkwplxdm(String bkwplxdm) {
		this.bkwplxdm = bkwplxdm;
	}

	/** @ 布控物品类型(bkwplx) */
	public String getBkwplx() {
		return bkwplx;
	}

	public void setBkwplx(String bkwplx) {
		this.bkwplx = bkwplx;
	}

	/** @ 布控物品名称(bkwpmc) */
	public String getBkwpmc() {
		return bkwpmc;
	}

	public void setBkwpmc(String bkwpmc) {
		this.bkwpmc = bkwpmc;
	}

	/** @ 布控物品描述(bkwpms) */
	public String getBkwpms() {
		return bkwpms;
	}

	public void setBkwpms(String bkwpms) {
		this.bkwpms = bkwpms;
	}

	/** @ 发文单位(fwdw) */
	public String getFwdw() {
		return fwdw;
	}

	public void setFwdw(String fwdw) {
		this.fwdw = fwdw;
	}

	/** @ 发文单位编码(fwdwbm) */
	public String getFwdwbm() {
		return fwdwbm;
	}

	public void setFwdwbm(String fwdwbm) {
		this.fwdwbm = fwdwbm;
	}

	/** @ 案件类别编码(ajlbbm) */
	public String getAjlbbm() {
		return ajlbbm;
	}

	public void setAjlbbm(String ajlbbm) {
		this.ajlbbm = ajlbbm;
	}

	/** @ 案件类别(ajlb) */
	public String getAjlb() {
		return ajlb;
	}

	public void setAjlb(String ajlb) {
		this.ajlb = ajlb;
	}

	/** @ 通报编号(tbbh) */
	public String getTbbh() {
		return tbbh;
	}

	public void setTbbh(String tbbh) {
		this.tbbh = tbbh;
	}

	/** @ 通报时间(tbsj2) */
	public Date getTbsj2() {
		return tbsj2;
	}

	public void setTbsj2(Date tbsj2) {
		this.tbsj2 = tbsj2;
	}

	/** @ 简要案情(jyaq) */
	public String getJyaq() {
		return jyaq;
	}

	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}

	/** @ 处理结果(cljg) */
	public String getCljg() {
		return cljg;
	}

	public void setCljg(String cljg) {
		this.cljg = cljg;
	}

	/** @ 布控人(bkr) */
	public String getBkr() {
		return bkr;
	}

	public void setBkr(String bkr) {
		this.bkr = bkr;
	}

	/** @ 布控操作员(bkczy) */
	public String getBkczy() {
		return bkczy;
	}

	public void setBkczy(String bkczy) {
		this.bkczy = bkczy;
	}

	/** @ 布控操作时间(bkczsj) */
	public Date getBkczsj() {
		return bkczsj;
	}

	public void setBkczsj(Date bkczsj) {
		this.bkczsj = bkczsj;
	}

	/** @ 布控到期时间(bkdqsj) */
	public Date getBkdqsj() {
		return bkdqsj;
	}

	public void setBkdqsj(Date bkdqsj) {
		this.bkdqsj = bkdqsj;
	}

	/** @ 布控范围编码(bkfwbm) */
	public String getBkfwbm() {
		return bkfwbm;
	}

	public void setBkfwbm(String bkfwbm) {
		this.bkfwbm = bkfwbm;
	}

	/** @ 布控范围(bkfw) */
	public String getBkfw() {
		return bkfw;
	}

	public void setBkfw(String bkfw) {
		this.bkfw = bkfw;
	}

	/** @ 布控审批意见(bkspyj) */
	public String getBkspyj() {
		return bkspyj;
	}

	public void setBkspyj(String bkspyj) {
		this.bkspyj = bkspyj;
	}

	/** @ 联系人(lxr) */
	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	/** @ 联系方式(lxfs) */
	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	/** @ 是否同意发布(sftyfb) */
	public String getSftyfb() {
		return sftyfb;
	}

	public void setSftyfb(String sftyfb) {
		this.sftyfb = sftyfb;
	}

	/** @ 审批单位(spdw) */
	public String getSpdw() {
		return spdw;
	}

	public void setSpdw(String spdw) {
		this.spdw = spdw;
	}

	/** @ 审批人(spr2) */
	public String getSpr2() {
		return spr2;
	}

	public void setSpr2(String spr2) {
		this.spr2 = spr2;
	}

	/** @ 审批日期(sprq) */
	public Date getSprq() {
		return sprq;
	}

	public void setSprq(Date sprq) {
		this.sprq = sprq;
	}

	/** @ 请求撤控标识(qqckbs) */
	public String getQqckbs() {
		return qqckbs;
	}

	public void setQqckbs(String qqckbs) {
		this.qqckbs = qqckbs;
	}

	/** @ 撤控标识(ckbs) */
	public String getCkbs() {
		return ckbs;
	}

	public void setCkbs(String ckbs) {
		this.ckbs = ckbs;
	}

	/** @ 撤控原因(ckyy) */
	public String getCkyy() {
		return ckyy;
	}

	public void setCkyy(String ckyy) {
		this.ckyy = ckyy;
	}

	/** @ 撤控时间(cksj) */
	public Date getCksj() {
		return cksj;
	}

	public void setCksj(Date cksj) {
		this.cksj = cksj;
	}

	/** @ 撤控人(ckr) */
	public String getCkr() {
		return ckr;
	}

	public void setCkr(String ckr) {
		this.ckr = ckr;
	}

	/** @ 撤控操作员(ckczy) */
	public String getCkczy() {
		return ckczy;
	}

	public void setCkczy(String ckczy) {
		this.ckczy = ckczy;
	}

	/** @ 撤控操作时间(ckczsj) */
	public Date getCkczsj() {
		return ckczsj;
	}

	public void setCkczsj(Date ckczsj) {
		this.ckczsj = ckczsj;
	}

	/** @ 撤控部门编码(ckbmbm) */
	public String getCkbmbm() {
		return ckbmbm;
	}

	public void setCkbmbm(String ckbmbm) {
		this.ckbmbm = ckbmbm;
	}

	/** @ 撤控部门名称(ckbmmc) */
	public String getCkbmmc() {
		return ckbmmc;
	}

	public void setCkbmmc(String ckbmmc) {
		this.ckbmmc = ckbmmc;
	}

	/** @ 撤控审批单位(ckspdw) */
	public String getCkspdw() {
		return ckspdw;
	}

	public void setCkspdw(String ckspdw) {
		this.ckspdw = ckspdw;
	}

	/** @ 撤控审批人(ckspr) */
	public String getCkspr() {
		return ckspr;
	}

	public void setCkspr(String ckspr) {
		this.ckspr = ckspr;
	}

	/** @ 撤控审批意见(ckspyj) */
	public String getCkspyj() {
		return ckspyj;
	}

	public void setCkspyj(String ckspyj) {
		this.ckspyj = ckspyj;
	}

	/** @ 撤控审批日期(cksprq) */
	public Date getCksprq() {
		return cksprq;
	}

	public void setCksprq(Date cksprq) {
		this.cksprq = cksprq;
	}

	/** @ 行政区划(xzqh) */
	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	/** @ 发送标识(fsbs) */
	public String getFsbs() {
		return fsbs;
	}

	public void setFsbs(String fsbs) {
		this.fsbs = fsbs;
	}

	/** @ 布控对象照片(bkdxzp) */
	public byte[] getBkdxzp() {
		return bkdxzp;
	}

	public void setBkdxzp(byte[] bkdxzp) {
		this.bkdxzp = bkdxzp;
	}

	/** @ 物品简拼(wpjp) */
	public String getWpjp() {
		return wpjp;
	}

	public void setWpjp(String wpjp) {
		this.wpjp = wpjp;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getBkczsjks() {
		return bkczsjks;
	}

	public void setBkczsjks(Date bkczsjks) {
		this.bkczsjks = bkczsjks;
	}

	public Date getBkczsjjs() {
		return bkczsjjs;
	}

	public void setBkczsjjs(Date bkczsjjs) {
		this.bkczsjjs = bkczsjjs;
	}

	public Bkcl getBkcl() {
		return bkcl;
	}

	public void setBkcl(Bkcl bkcl) {
		this.bkcl = bkcl;
	}

	public Bksj getBksj() {
		return bksj;
	}

	public void setBksj(Bksj bksj) {
		this.bksj = bksj;
	}

	public Integer getBkclid() {
		return bkclid;
	}

	public void setBkclid(Integer bkclid) {
		this.bkclid = bkclid;
	}

	public String getCllxdm() {
		return cllxdm;
	}

	public void setCllxdm(String cllxdm) {
		this.cllxdm = cllxdm;
	}

	public String getCllx() {
		return cllx;
	}

	public void setCllx(String cllx) {
		this.cllx = cllx;
	}

	public String getClpp() {
		return clpp;
	}

	public void setClpp(String clpp) {
		this.clpp = clpp;
	}

	public String getClxh() {
		return clxh;
	}

	public void setClxh(String clxh) {
		this.clxh = clxh;
	}

	public String getHpzldm() {
		return hpzldm;
	}

	public void setHpzldm(String hpzldm) {
		this.hpzldm = hpzldm;
	}

	public String getHpzl() {
		return hpzl;
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getCsys() {
		return csys;
	}

	public void setCsys(String csys) {
		this.csys = csys;
	}

	public String getSyr() {
		return syr;
	}

	public void setSyr(String syr) {
		this.syr = syr;
	}

	public Date getCcdjrq() {
		return ccdjrq;
	}

	public void setCcdjrq(Date ccdjrq) {
		this.ccdjrq = ccdjrq;
	}

	public String getFdjh() {
		return fdjh;
	}

	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}

	public String getClsbdh() {
		return clsbdh;
	}

	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}

	public String getCjh() {
		return cjh;
	}

	public void setCjh(String cjh) {
		this.cjh = cjh;
	}

	public Integer getBksjid() {
		return bksjid;
	}

	public void setBksjid(Integer bksjid) {
		this.bksjid = bksjid;
	}

	public String getSjch() {
		return sjch;
	}

	public void setSjch(String sjch) {
		this.sjch = sjch;
	}

	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getYs() {
		return ys;
	}

	public void setYs(String ys) {
		this.ys = ys;
	}


	public String getShjg() {
		return shjg;
	}

	public void setShjg(String shjg) {
		this.shjg = shjg;
	}

	public String getShyj() {
		return shyj;
	}

	public void setShyj(String shyj) {
		this.shyj = shyj;
	}

	public String getFileload() {
		return fileload;
	}

	public void setFileload(String fileload) {
		this.fileload = fileload;
	}

	public String getCmdID() {
		return cmdID;
	}

	public void setCmdID(String cmdID) {
		this.cmdID = cmdID;
	}

	public String getTyCheck() {
		return tyCheck;
	}

	public void setTyCheck(String tyCheck) {
		this.tyCheck = tyCheck;
	}

	public String getWpqp() {
		return wpqp;
	}

	public void setWpqp(String wpqp) {
		this.wpqp = wpqp;
	}
}
