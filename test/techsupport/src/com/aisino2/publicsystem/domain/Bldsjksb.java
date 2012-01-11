package com.aisino2.publicsystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Bldsjksb  {

	/** @param 闭路电视监控设备(t_bldsjksb) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --闭路电视监控设备ID--bldsjksbid--Integer--10-- */
	private Integer bldsjksbid;

	/** @ --网络传输类型编码--wlcslxbm--String--20-- */
	private String wlcslxbm;

	/** @ --网络传输类型名称--wlcslxmc--String--100-- */
	private String wlcslxmc;

	/** @ --设备检测机构名称--sbjcjgmc--String--200-- */
	private String sbjcjgmc;

	/** @ --安装摄像头数量--azsxtsl--Integer--6-- */
	private Integer azsxtsl;

	/** @ --设备序号--sbxh--String--20-- */
	private String sbxh;

	/** @ --生产厂商名称--sccsmc--String--200-- */
	private String sccsmc;

	/** @ --规格型号--ggxh--String--100-- */
	private String ggxh;

	/** @ --安装数量--azsl--Integer--6-- */
	private Integer azsl;

	/** @ --设备名称--sbmc--String--100-- */
	private String sbmc;

	/** @ --是否录像--sflx--String--2-- */
	private String sflx;

	/** @ --服务器IP地址--ipdz--String--20-- */
	private String ipdz;

	/** @ --安装位置--anwz--String--2000-- */
	private String anwz;

	/** 分页排序 */
	private String pageSort;
	
    public List lBldsjksbList;
	
	/** @ --请求动作：查看、修改 - 查看则不给删除按钮(非数据库字段)- */
	private String bldsjkRequetType;

	/** @ --企业编码-- */
	private String qybm;

	/** @ --企业名称--csmc */
	private String qymc;
	
	/** @ --企业主分类编码-- */
	private String qyzflbm;

	/** @ --企业主分类名称-- */
	private String qyzflmc;
	
	/** @ --企业行业类别-- */
	private String hylbdm;
	
	/** @ --企业行业类别-- */
	private String hylb;
	
	/** @ --状态--zt--String--10 */
	private String zt;
	
	/** @ --停用原因--tyyy--String--2000 */
	private String tyyy;
	
	/** @ --停用时间--tysj--Date-- */
	private Date tysj;
	
	/** @ --经办人--jibr--String--30 */
	private String jibr;
	
	/** @ --备注--bz--String--2000 */
	private String bz;
	
	/** @ --录入人--lrr--String--100 */
	private String lrr;
	
	/** @ --录入时间--lrsj--Date-- */
	private Date lrsj;
	

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 闭路电视监控设备ID(bldsjksbid) */
	public Integer getBldsjksbid() {
		return bldsjksbid;
	}

	public void setBldsjksbid(Integer bldsjksbid) {
		this.bldsjksbid = bldsjksbid;
	}

	/** @ 网络传输类型编码(wlcslxbm) */
	public String getWlcslxbm() {
		return wlcslxbm;
	}

	public void setWlcslxbm(String wlcslxbm) {
		this.wlcslxbm = wlcslxbm;
	}

	/** @ 网络传输类型名称(wlcslxmc) */
	public String getWlcslxmc() {
		return wlcslxmc;
	}

	public void setWlcslxmc(String wlcslxmc) {
		this.wlcslxmc = wlcslxmc;
	}

	/** @ 设备检测机构名称(sbjcjgmc) */
	public String getSbjcjgmc() {
		return sbjcjgmc;
	}

	public void setSbjcjgmc(String sbjcjgmc) {
		this.sbjcjgmc = sbjcjgmc;
	}

	/** @ 安装摄像头数量(azsxtsl) */
	public Integer getAzsxtsl() {
		return azsxtsl;
	}

	public void setAzsxtsl(Integer azsxtsl) {
		this.azsxtsl = azsxtsl;
	}

	/** @ 设备序号(sbxh) */
	public String getSbxh() {
		return sbxh;
	}

	public void setSbxh(String sbxh) {
		this.sbxh = sbxh;
	}

	/** @ 生产厂商名称(sccsmc) */
	public String getSccsmc() {
		return sccsmc;
	}

	public void setSccsmc(String sccsmc) {
		this.sccsmc = sccsmc;
	}

	/** @ 规格型号(ggxh) */
	public String getGgxh() {
		return ggxh;
	}

	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}

	/** @ 安装数量(azsl) */
	public Integer getAzsl() {
		return azsl;
	}

	public void setAzsl(Integer azsl) {
		this.azsl = azsl;
	}

	/** @ 设备名称(sbmc) */
	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	/** @ 是否录像(sflx) */
	public String getSflx() {
		return sflx;
	}

	public void setSflx(String sflx) {
		this.sflx = sflx;
	}

	/** @ 服务器IP地址(ipdz) */
	public String getIpdz() {
		return ipdz;
	}

	public void setIpdz(String ipdz) {
		this.ipdz = ipdz;
	}

	/** @ 安装位置(anwz) */
	public String getAnwz() {
		return anwz;
	}

	public void setAnwz(String anwz) {
		this.anwz = anwz;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public List getLBldsjksbList() {
		return lBldsjksbList;
	}

	public void setLBldsjksbList(List bldsjksbList) {
		lBldsjksbList = bldsjksbList;
	}

	public String getBldsjkRequetType() {
		return bldsjkRequetType;
	}

	public void setBldsjkRequetType(String bldsjkRequetType) {
		this.bldsjkRequetType = bldsjkRequetType;
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

	public String getQyzflbm() {
		return qyzflbm;
	}

	public void setQyzflbm(String qyzflbm) {
		this.qyzflbm = qyzflbm;
	}

	public String getQyzflmc() {
		return qyzflmc;
	}

	public void setQyzflmc(String qyzflmc) {
		this.qyzflmc = qyzflmc;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getTyyy() {
		return tyyy;
	}

	public void setTyyy(String tyyy) {
		this.tyyy = tyyy;
	}

	public Date getTysj() {
		return tysj;
	}

	public void setTysj(Date tysj) {
		this.tysj = tysj;
	}

	public String getJibr() {
		return jibr;
	}

	public void setJibr(String jibr) {
		this.jibr = jibr;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}
}
