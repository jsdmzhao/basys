package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.common.DateToString;
import com.aisino2.core.domain.BaseObject;

public class Qysctj  {

	/** @param 企业上传统计表(t_qysctj) */

	/** @ --企业上传统计ID--qysctjid--Integer--10-- */
	private Integer qysctjid;

	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

	/** @ --统计日期--tjrq--Date---- */
	private Date tjrq;

	/** @ --地市机关代码--dsjgdm--String--20-- */
	private String dsjgdm;

	/** @ --地市机关名称--dsjgmc--String--60-- */
	private String dsjgmc;

	/** @ --分县局代码--fxjdm--String--20-- */
	private String fxjdm;

	/** @ --分县局名称--fxjmc--String--60-- */
	private String fxjmc;

	/** @ --管辖单位名称--gxdwmc--String--60-- */
	private String gxdwmc;

	/** @ --管辖单位代码--gxdwdm--String--20-- */
	private String gxdwdm;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --企业名称--qymc--String--120-- */
	private String qymc;

	/** @ --联系电话--lxdh--String--30-- */
	private String lxdh;

	/** @ --是否达标--sfdb--Integer--2-- */
	private Integer sfdb;

	/** @ --总人数--zrs--Integer--6-- */
	private Integer zrs;

	/** @ --工作人数--gzrs--Integer--6-- */
	private Integer gzrs;

	/** @ --实刷卡人数--sskrs--Integer--6-- */
	private Integer sskrs;

	/** @ --最低刷卡比--zdskb--Float--5,2-- */
	private Float zdskb;

	/** @ --一次刷卡人数--ycskrs--Integer--6-- */
	private Integer ycskrs;

	/** @ --多次刷卡人数--dcskrs--Integer--6-- */
	private Integer dcskrs;

	/** @ --本场所刷卡人数--bcsskrs--Integer--6-- */
	private Integer bcsskrs;

	/** @ --走台刷卡人数--ztskrs--Integer--6-- */
	private Integer ztskrs;

	/** @ --总刷卡比--zskb--Float--5,2-- */
	private Float zskb;

	/** @ --一次刷卡率--ycskb--Float--5,2-- */
	private Float ycskb;

	/** @ --多次刷卡率--dcskb--Float--5,2-- */
	private Float dcskb;

	/** 分页排序 */
	private String pageSort;
	
	
	private String zskbstring;//总刷卡比字符串
	private String ycskbstring;//一次刷卡率
	private String dcskbstring;//多次刷卡率
	
	private String tjrqString;//统计日期格式化
	
	
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
	private String csbz;
	private String csbm;//场所编码
	
	
	
	private String  zskbdxdy;//查询条件中的总刷卡比 大于，小于，等于
	private String  zskbbfb;//查询条件中的总刷卡比 ：值
	
	
	
	private String ztjbdm;//走台级别代码
	private Date sksj;
	private String xm;
	private String cyrybh;//从业人员编号
	private Integer ryid;// 人员id
	private String cyrylbdm;//从业人员类别 ，0国内，1，国外
	private Integer ssqyid;//所属场所id
	private String  ssqybm;//所属场所编码
	private String  ssqymc;//所属场所名称
	private Integer qyid;//场所id
	private String  zjhm;//证件号码
	private String  qzhm;//签证号码
	private Integer skcs;//单人单天刷卡次数
	
	private Date zttjrq;//走台统计日期。刷卡统计详细中一天的走台人
	private String zttjrqString;
	
	public String getSsqybm() {
		return ssqybm;
	}

	public void setSsqybm(String ssqybm) {
		this.ssqybm = ssqybm;
	}

	public Integer getSkcs() {
		return skcs;
	}

	public void setSkcs(Integer skcs) {
		this.skcs = skcs;
	}

	public String getZttjrqString() {
		return zttjrqString;
	}

	public void setZttjrqString(String zttjrqString) {
		this.zttjrqString = zttjrqString;
	}

	public Date getZttjrq() {
		return zttjrq;
	}

	public void setZttjrq(Date zttjrq) {
		this.zttjrq = zttjrq;
	}

	public String getZtjbdm() {
		return ztjbdm;
	}

	public void setZtjbdm(String ztjbdm) {
		this.ztjbdm = ztjbdm;
	}

	public String getTjrqString() {
		if(this.getTjrq()!=null){
		return DateToString.getDateEn(this.getTjrq());
		}else{
			return null;
		}
	}

	public void setTjrqString(String tjrqString) {
		this.tjrqString = tjrqString;
	}

	/** @ 企业上传统计ID(qysctjid) */
	public Integer getQysctjid() {
		return qysctjid;
	}

	public void setQysctjid(Integer qysctjid) {
		this.qysctjid = qysctjid;
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

	/** @ 统计日期(tjrq) */
	public Date getTjrq() {
		return tjrq;
	}

	public void setTjrq(Date tjrq) {
		this.tjrq = tjrq;
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

	/** @ 管辖单位名称(gxdwmc) */
	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	/** @ 管辖单位代码(gxdwdm) */
	public String getGxdwdm() {
		return gxdwdm;
	}

	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
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

	/** @ 是否达标(sfdb) */
	public Integer getSfdb() {
		return sfdb;
	}

	public void setSfdb(Integer sfdb) {
		this.sfdb = sfdb;
	}

	/** @ 总人数(zrs) */
	public Integer getZrs() {
		return zrs;
	}

	public void setZrs(Integer zrs) {
		this.zrs = zrs;
	}

	/** @ 工作人数(gzrs) */
	public Integer getGzrs() {
		return gzrs;
	}

	public void setGzrs(Integer gzrs) {
		this.gzrs = gzrs;
	}

	/** @ 实刷卡人数(sskrs) */
	public Integer getSskrs() {
		return sskrs;
	}

	public void setSskrs(Integer sskrs) {
		this.sskrs = sskrs;
	}

	/** @ 最低刷卡比(zdskb) */
	public Float getZdskb() {
		return zdskb;
	}

	public void setZdskb(Float zdskb) {
		this.zdskb = zdskb;
	}

	/** @ 一次刷卡人数(ycskrs) */
	public Integer getYcskrs() {
		return ycskrs;
	}

	public void setYcskrs(Integer ycskrs) {
		this.ycskrs = ycskrs;
	}

	/** @ 多次刷卡人数(dcskrs) */
	public Integer getDcskrs() {
		return dcskrs;
	}

	public void setDcskrs(Integer dcskrs) {
		this.dcskrs = dcskrs;
	}

	/** @ 本场所刷卡人数(bcsskrs) */
	public Integer getBcsskrs() {
		return bcsskrs;
	}

	public void setBcsskrs(Integer bcsskrs) {
		this.bcsskrs = bcsskrs;
	}

	/** @ 走台刷卡人数(ztskrs) */
	public Integer getZtskrs() {
		return ztskrs;
	}

	public void setZtskrs(Integer ztskrs) {
		this.ztskrs = ztskrs;
	}

	/** @ 总刷卡比(zskb) */
	public Float getZskb() {
		return zskb;
	}

	public void setZskb(Float zskb) {
		this.zskb = zskb;
	}

	/** @ 一次刷卡率(ycskb) */
	public Float getYcskb() {
		return ycskb;
	}

	public void setYcskb(Float ycskb) {
		this.ycskb = ycskb;
	}

	/** @ 多次刷卡率(dcskb) */
	public Float getDcskb() {
		return dcskb;
	}

	public void setDcskb(Float dcskb) {
		this.dcskb = dcskb;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getZskbstring() {
		if(zskbstring!=null){
			if(zskbstring.startsWith(".")){
				zskbstring="0"+zskbstring;
			}
		}
		return zskbstring;
	}

	public void setZskbstring(String zskbstring) {
		this.zskbstring = zskbstring;
	}

	public String getYcskbstring() {
		if(ycskbstring!=null){
			if(ycskbstring.startsWith(".")){
				ycskbstring="0"+ycskbstring;
			}
		}
		return ycskbstring;
	}

	public void setYcskbstring(String ycskbstring) {
		this.ycskbstring = ycskbstring;
	}

	public String getDcskbstring() {
		if(dcskbstring!=null){
			if(dcskbstring.startsWith(".")){
				dcskbstring="0"+dcskbstring;
			}
		}
		return dcskbstring;
	}

	public void setDcskbstring(String dcskbstring) {
		this.dcskbstring = dcskbstring;
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

	public String getCsbz() {
		return csbz;
	}

	public void setCsbz(String csbz) {
		this.csbz = csbz;
	}

	public String getCsbm() {
		return csbm;
	}

	public void setCsbm(String csbm) {
		this.csbm = csbm;
	}

	public String getZskbdxdy() {
		return zskbdxdy;
	}

	public void setZskbdxdy(String zskbdxdy) {
		this.zskbdxdy = zskbdxdy;
	}

	public String getZskbbfb() {
		return zskbbfb;
	}

	public void setZskbbfb(String zskbbfb) {
		this.zskbbfb = zskbbfb;
	}

	public Date getSksj() {
		return sksj;
	}

	public void setSksj(Date sksj) {
		this.sksj = sksj;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	public Integer getRyid() {
		return ryid;
	}

	public void setRyid(Integer ryid) {
		this.ryid = ryid;
	}



	

	public Integer getSsqyid() {
		return ssqyid;
	}

	public void setSsqyid(Integer ssqyid) {
		this.ssqyid = ssqyid;
	}

	public String getSsqymc() {
		return ssqymc;
	}

	public void setSsqymc(String ssqymc) {
		this.ssqymc = ssqymc;
	}

	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getQzhm() {
		return qzhm;
	}

	public void setQzhm(String qzhm) {
		this.qzhm = qzhm;
	}

	public String getCyrylbdm() {
		return cyrylbdm;
	}

	public void setCyrylbdm(String cyrylbdm) {
		this.cyrylbdm = cyrylbdm;
	}


}
