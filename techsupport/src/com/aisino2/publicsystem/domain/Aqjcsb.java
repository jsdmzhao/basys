package com.aisino2.publicsystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Aqjcsb  {

	/** @param 安全检查设备(t_aqjcsb) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --安全检查设备ID--anjcsbid--Integer--10-- */
	private Integer anjcsbid;

	/** @ --安全检查设备种类编码--aqjcsbzlbm--String--20-- */
	private String aqjcsbzlbm;

	/** @ --安全检查设备种类名称--aqjcsbzlmc--String--100-- */
	private String aqjcsbzlmc;
	
	/** @ --安全检查设备ID--oldanjcsbid--Integer--10-- */
	private Integer oldanjcsbid;

	/** @ --设备序号--sbxh--String--20-- */
	private String sbxh;

	/** @ --规格型号--ggxh--String--100-- */
	private String ggxh;

	/** @ --设备名称--sbmc--String--100-- */
	private String sbmc;

	/** @ --安装数量--azsl--Integer--6-- */
	private Integer azsl;

	/** 分页排序 */
	private String pageSort;

	private List lAqjcsbList;
	/** @ --请求动作：查看、修改 - 查看则不给删除按钮(非数据库字段)- */
	private String aqjcsbRequetType;

	/** @ --企业编码-- */
	private String qybm;
	
	/** @ --企业行业类别代码-- */
	private String hylbdm;
	
	/** @ --企业行业类别代码-- */
	private String hylb;

	/** @ --企业名称--csmc */
	private String qymc;
	
	/** @ --企业主分类编码-- */
	private String qyzflbm;

	/** @ --企业主分类名称-- */
	private String qyzflmc;
	
	private String listtype;// 列表类型
	
	/** @ --停用原因--tyyy--String--200-- */
	private String tyyy;

	/** @ --停用时间--tysj--Date---- */
	private Date tysj;
	
	/** @ --备注--bz--String--2000-- */
	private String bz;

	/** @ --状态--zt--String--10-- */
	private String zt;
	
	/** @ --经办人--jibr--String--30 */
	private String jibr;

	/** @ --录入人--lrr--String--100-- */
	private String lrr;

	/** @ --录入时间--lrsj--Date---- */
	private Date lrsj;
	
	public String getListtype() {
		return listtype;
	}

	public void setListtype(String listtype) {
		this.listtype = listtype;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 安全检查设备ID(anjcsbid) */
	public Integer getAnjcsbid() {
		return anjcsbid;
	}

	public void setAnjcsbid(Integer anjcsbid) {
		this.anjcsbid = anjcsbid;
	}

	/** @ 安全检查设备种类编码(aqjcsbzlbm) */
	public String getAqjcsbzlbm() {
		return aqjcsbzlbm;
	}

	public void setAqjcsbzlbm(String aqjcsbzlbm) {
		this.aqjcsbzlbm = aqjcsbzlbm;
	}

	/** @ 安全检查设备种类名称(aqjcsbzlmc) */
	public String getAqjcsbzlmc() {
		return aqjcsbzlmc;
	}

	public void setAqjcsbzlmc(String aqjcsbzlmc) {
		this.aqjcsbzlmc = aqjcsbzlmc;
	}
	public String getSbxh() {
		return sbxh;
	}

	public void setSbxh(String sbxh) {
		this.sbxh = sbxh;
	}

	/** @ 规格型号(ggxh) */
	public String getGgxh() {
		return ggxh;
	}

	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}

	/** @ 设备名称(sbmc) */
	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	/** @ 安装数量(azsl) */
	public Integer getAzsl() {
		return azsl;
	}

	public void setAzsl(Integer azsl) {
		this.azsl = azsl;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public List getLAqjcsbList() {
		return lAqjcsbList;
	}

	public void setLAqjcsbList(List aqjcsbList) {
		lAqjcsbList = aqjcsbList;
	}

	public String getAqjcsbRequetType() {
		return aqjcsbRequetType;
	}

	public void setAqjcsbRequetType(String aqjcsbRequetType) {
		this.aqjcsbRequetType = aqjcsbRequetType;
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

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
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

	public String getJibr() {
		return jibr;
	}

	public void setJibr(String jibr) {
		this.jibr = jibr;
	}

	public Integer getOldanjcsbid() {
		return oldanjcsbid;
	}

	public void setOldanjcsbid(Integer oldanjcsbid) {
		this.oldanjcsbid = oldanjcsbid;
	}
}
