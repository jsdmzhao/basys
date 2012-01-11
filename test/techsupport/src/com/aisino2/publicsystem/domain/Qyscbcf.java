package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyscbcf  {

	/** @param 企业上传不充分(t_qyscbcf) */

	/** @ --企业上传不充分ID--qyscbcfid--Integer--10-- */
	private Integer qyscbcfid;

	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

	/** @ --未达标日期--wdbrq--Date---- */
	private Date wdbrq;

	/** @ --地市机关代码--dsjgdm--String--20-- */
	private String dsjgdm;

	/** @ --地市机关名称--dsjgmc--String--60-- */
	private String dsjgmc;

	/** @ --分县局代码--fxjdm--String--20-- */
	private String fxjdm;

	/** @ --分县局名称--fxjmc--String--60-- */
	private String fxjmc;

	/** @ --管辖单位代码--gxdwdm--String--20-- */
	private String gxdwdm;

	/** @ --管辖单位名称--gxdwmc--String--60-- */
	private String gxdwmc;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --企业名称--qymc--String--120-- */
	private String qymc;

	/** @ --联系电话--lxdh--String--30-- */
	private String lxdh;

	/** @ --总人数--zrs--Integer--6-- */
	private Integer zrs;

	/** @ --实刷卡人数--sskrs--Integer--6-- */
	private Integer sskrs;

	/** @ --核定刷卡比--hdskb--Float--5,2-- */
	private Float hdskb;

	/** @ --实际刷卡比--sjsrb--Float--5,2-- */
	private Float sjsrb;

	/** @ --状态代码--ztdm--String--2-- */
	private String ztdm;
	
	/** @ --工作人数--gzrs--Integer--6-- */
	private String gzrs;

	/** 分页排序 */
	private String pageSort;
	
	
	

	/** @ --起始时间--qssj--String---- */
	private Date qssj;
	/** @ --截止时间--jzsj--String---- */
	private Date jzsj;
	
	/** 地市机关标志 非数据库字段 */
	private String dsjgbz;
	/** 分县局标志 非数据库字段 */
	private String fxjbz;
	/** 科所队标志 非数据库字段 */
	private String gxdwbz;
	/** 场所标志 非数据库字段 */
	private String hdskbstring;//核定刷卡比
	private String sjsrbstring;//实际刷卡比
	
	

	
	
	/** @ --未达标天数--zrs--Integer--6-- */
	private Integer wdbts;
	/** @ --月累计天数--zrs--Integer--6-- */
	private Integer yljts;
	/** @ --年累计天数--zrs--Integer--6-- */
	private Integer nljts;
	

	

	/** @ 企业上传不充分ID(qyscbcfid) */
	public Integer getQyscbcfid() {
		return qyscbcfid;
	}

	public void setQyscbcfid(Integer qyscbcfid) {
		this.qyscbcfid = qyscbcfid;
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

	/** @ 未达标日期(wdbrq) */
	public Date getWdbrq() {
		return wdbrq;
	}

	public void setWdbrq(Date wdbrq) {
		this.wdbrq = wdbrq;
	}

	/** @ 地市机关代码(dsjgdm) */
	public String getDsjgdm() {
		return dsjgdm;
	}

	public void setDsjgdm(String dsjgdm) {
		this.dsjgdm = dsjgdm;
	}

	/** @ 地市机关名称(dsjgmc) */
	public String getDsjgmc() {
		return dsjgmc;
	}

	public void setDsjgmc(String dsjgmc) {
		this.dsjgmc = dsjgmc;
	}

	/** @ 分县局代码(fxjdm) */
	public String getFxjdm() {
		return fxjdm;
	}

	public void setFxjdm(String fxjdm) {
		this.fxjdm = fxjdm;
	}

	/** @ 分县局名称(fxjmc) */
	public String getFxjmc() {
		return fxjmc;
	}

	public void setFxjmc(String fxjmc) {
		this.fxjmc = fxjmc;
	}

	/** @ 管辖单位代码(gxdwdm) */
	public String getGxdwdm() {
		return gxdwdm;
	}

	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
	}

	/** @ 管辖单位名称(gxdwmc) */
	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	/** @ 企业编码(qybm) */
	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}

	/** @ 企业名称(qymc) */
	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	/** @ 联系电话(lxdh) */
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	/** @ 总人数(zrs) */
	public Integer getZrs() {
		return zrs;
	}

	public void setZrs(Integer zrs) {
		this.zrs = zrs;
	}

	/** @ 实刷卡人数(sskrs) */
	public Integer getSskrs() {
		return sskrs;
	}

	public void setSskrs(Integer sskrs) {
		this.sskrs = sskrs;
	}

	/** @ 核定刷卡比(hdskb) */
	public Float getHdskb() {
		return hdskb;
	}

	public void setHdskb(Float hdskb) {
		this.hdskb = hdskb;
	}

	/** @ 实际刷卡比(sjsrb) */
	public Float getSjsrb() {
		return sjsrb;
	}

	public void setSjsrb(Float sjsrb) {
		this.sjsrb = sjsrb;
	}

	/** @ 状态代码(ztdm) */
	public String getZtdm() {
		return ztdm;
	}

	public void setZtdm(String ztdm) {
		this.ztdm = ztdm;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getGzrs() {
		return gzrs;
	}

	public void setGzrs(String gzrs) {
		this.gzrs = gzrs;
	}

	public Date getQssj() {
		return qssj;
	}

	public void setQssj(Date qssj) {
		this.qssj = qssj;
	}

	public Date getJzsj() {
		return jzsj;
	}

	public void setJzsj(Date jzsj) {
		this.jzsj = jzsj;
	}

	public String getDsjgbz() {
		return dsjgbz;
	}

	public void setDsjgbz(String dsjgbz) {
		this.dsjgbz = dsjgbz;
	}

	public String getFxjbz() {
		return fxjbz;
	}

	public void setFxjbz(String fxjbz) {
		this.fxjbz = fxjbz;
	}

	public String getGxdwbz() {
		return gxdwbz;
	}

	public void setGxdwbz(String gxdwbz) {
		this.gxdwbz = gxdwbz;
	}

	public String getHdskbstring() {
		
		if(hdskbstring!=null){
			if(hdskbstring.startsWith(".")){
				hdskbstring="0"+hdskbstring;
			}
		}
		return hdskbstring;
		
	
	}

	public void setHdskbstring(String hdskbstring) {
		this.hdskbstring = hdskbstring;
	}

	public String getSjsrbstring() {
		if(sjsrbstring!=null){
			if(sjsrbstring.startsWith(".")){
				sjsrbstring="0"+sjsrbstring;
			}
		}
	
		return sjsrbstring;
	}

	public void setSjsrbstring(String sjsrbstring) {
		this.sjsrbstring = sjsrbstring;
	}



	public Integer getWdbts() {
		return wdbts;
	}

	public void setWdbts(Integer wdbts) {
		this.wdbts = wdbts;
	}

	public Integer getYljts() {
		return yljts;
	}

	public void setYljts(Integer yljts) {
		this.yljts = yljts;
	}

	public Integer getNljts() {
		return nljts;
	}

	public void setNljts(Integer nljts) {
		this.nljts = nljts;
	}
}
