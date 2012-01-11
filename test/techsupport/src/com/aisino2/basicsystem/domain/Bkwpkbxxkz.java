package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Bkwpkbxxkz  {

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) */

	/** @ --报警信息ID--bjxxid2--Integer--10-- */
	private Integer bjxxid2;
	
	/** @ --物品报警规则ID--wpbjgzid--Integer--10-- */
	private Integer wpbjgzid;

	/** @ --布控物品基本信息快照ID--bkwpjbxxkzid--Integer--10-- */
	private Integer bkwpjbxxkzid;

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
	
	private String wpqp; //物品全拼
	
    private Bkclkz bkclkz;  ///布控车辆
	
	private Bksjkz bksjkz;  ///布控手机

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

	public String getWpqp() {
		return wpqp;
	}

	public void setWpqp(String wpqp) {
		this.wpqp = wpqp;
	}

	public Bkclkz getBkclkz() {
		return bkclkz;
	}

	public void setBkclkz(Bkclkz bkclkz) {
		this.bkclkz = bkclkz;
	}

	public Bksjkz getBksjkz() {
		return bksjkz;
	}

	public void setBksjkz(Bksjkz bksjkz) {
		this.bksjkz = bksjkz;
	}

	
}
