package com.aisino2.icksystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Ickzb  {

	/** @param IC卡组包(t_ickzb) */

	/** @ --组包ID--zbid--Integer--10-- */
	private Integer zbid;

	/** @ --批次号--pch--String--20-- */
	private String pch;

	/** @ --组包数量--zbsl--Integer--6-- */
	private Integer zbsl;

	/** @ --组包人--zbr--String--30-- */
	private String zbr;

	/** @ --组包时间--zbsj--Date---- */
	private Date zbsj;

	/** @ --包中所含的受理点数--slds--Integer--6-- */
	private Integer slds;

	/** 分页排序 */
	private String pageSort;
	
	/** IC卡受理IC卡组包列表 */
	private List lIcksl_ickzb;
	
	/** IC卡受理列表 */
	private List lIcksl;
	
	/** 从业人员信息列表 */
	private List lCyryxx;
	
	/** 每页最大排版号 */
	private Integer maxRowsOfPage;
	
	/** 已印刷数量 */
	private String yyssl;
	
	/** 包内卡是否已全部印刷 */
	private String sfqbys;
	
	/**人员ID集合*/
	private String ryidSet;
	
	/**IC卡ID集合*/
	private String ickslidSet;
	
	/**场所ID集合*/
	private String qyidSet;
	
	/**采集点集合*/
	private String cjdbmSet;

	/**印刷页码数*/
	private Integer ysyms;
	
	/**开始顺序号*/
	private Integer kssxh;
	
	/**最大顺序号*/
	private Integer zdsxh;
	
	/**本次印刷数量*/
	private Integer bcyssl;
	
	/**本次印刷数量(不考虑卡是否已印刷)*/
	private Integer bcysslByPage;
	
	/**本次电写入数量*/
	private Integer bcdxrsl;
	
	/**本次印刷页码*/
	private Integer bcysym;
	
	/**采集点编码*/
	private String cjdbm;
	
	/**IC卡受理ID*/
	private Integer ickslid;
	
	/**每包记录数*/
	private Integer mbjls;
	
	/**卡号*/
	private String kh;
	
	/**有效开始日期*/
	private Date yxsksrq;
	
	/**有效结束日期*/
	private Date yxqhzrq;
	
	/**从业类别代码*/
	private String cylbdm;
	
	/**从业人员编号*/
	private String cyrybh;
	
	/** @ --图片内容-- */
	private byte[] tpnr;
	
	/** @ --操作人-- */
	private String czr;
	
	/** @ --人员ID- */
	private Integer ryid;
	
	/** @ --电写入标志- */
	private Integer dxrbz;
	
	/** @ --批次号列表显示 */
	private String pchSel;
	
	/** 已采集三天及以上*/
	private String moreThan3days;
	
	private String gwbh;// 岗位编号
	
	/** @ --批次号+%-- */
	private String likepch;//pch%
	
	/** @ --组包后所处的页码--zbhsuym--Integer--10-- */
	private Integer zbhsuym;
	
	private String sfbx;//是否补写，为1时表示补写，为空或其他值表示正常电写入
	
	private String cylb;//从业类别
	
	private String sxh;//顺序号
	
	private String allhylbdm;//in方式行业类别代码
	
	private String xm;//姓名
	
	private String bm;//别名

	public Integer getZbhsuym() {
		return zbhsuym;
	}

	public void setZbhsuym(Integer zbhsuym) {
		this.zbhsuym = zbhsuym;
	}

	public String getGwbh() {
		return gwbh;
	}

	public void setGwbh(String gwbh) {
		this.gwbh = gwbh;
	}

	/** @ 组包ID(zbid) */
	public Integer getZbid() {
		return zbid;
	}

	public void setZbid(Integer zbid) {
		this.zbid = zbid;
	}

	/** @ 批次号(pch) */
	public String getPch() {
		return pch;
	}

	public void setPch(String pch) {
		this.pch = pch;
	}

	/** @ 组包数量(zbsl) */
	public Integer getZbsl() {
		return zbsl;
	}

	public void setZbsl(Integer zbsl) {
		this.zbsl = zbsl;
	}

	/** @ 组包人(zbr) */
	public String getZbr() {
		return zbr;
	}

	public void setZbr(String zbr) {
		this.zbr = zbr;
	}

	/** @ 组包时间(zbsj) */
	public Date getZbsj() {
		return zbsj;
	}

	public void setZbsj(Date zbsj) {
		this.zbsj = zbsj;
	}

	/** @ 包中所含的受理点数(slds) */
	public Integer getSlds() {
		return slds;
	}

	public void setSlds(Integer slds) {
		this.slds = slds;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public List getLIcksl_ickzb() {
		return lIcksl_ickzb;
	}

	public void setLIcksl_ickzb(List icksl_ickzb) {
		lIcksl_ickzb = icksl_ickzb;
	}

	public List getLIcksl() {
		return lIcksl;
	}

	public void setLIcksl(List icksl) {
		lIcksl = icksl;
	}

	public List getLCyryxx() {
		return lCyryxx;
	}

	public void setLCyryxx(List cyryxx) {
		lCyryxx = cyryxx;
	}

	public Integer getMaxRowsOfPage() {
		return maxRowsOfPage;
	}

	public void setMaxRowsOfPage(Integer maxRowsOfPage) {
		this.maxRowsOfPage = maxRowsOfPage;
	}

	public String getYyssl() {
		return yyssl;
	}

	public void setYyssl(String yyssl) {
		this.yyssl = yyssl;
	}

	public String getSfqbys() {
		return sfqbys;
	}

	public void setSfqbys(String sfqbys) {
		this.sfqbys = sfqbys;
	}

	public String getRyidSet() {
		return ryidSet;
	}

	public void setRyidSet(String ryidSet) {
		this.ryidSet = ryidSet;
	}

	public String getIckslidSet() {
		return ickslidSet;
	}

	public void setIckslidSet(String ickslidSet) {
		this.ickslidSet = ickslidSet;
	}

	public String getCjdbmSet() {
		return cjdbmSet;
	}

	public void setCjdbmSet(String cjdbmSet) {
		this.cjdbmSet = cjdbmSet;
	}

	public Integer getYsyms() {
		return ysyms;
	}

	public void setYsyms(Integer ysyms) {
		this.ysyms = ysyms;
	}

	public Integer getKssxh() {
		return kssxh;
	}

	public void setKssxh(Integer kssxh) {
		this.kssxh = kssxh;
	}

	public Integer getZdsxh() {
		return zdsxh;
	}

	public void setZdsxh(Integer zdsxh) {
		this.zdsxh = zdsxh;
	}

	public Integer getBcyssl() {
		return bcyssl;
	}

	public void setBcyssl(Integer bcyssl) {
		this.bcyssl = bcyssl;
	}

	public Integer getBcysslByPage() {
		return bcysslByPage;
	}

	public void setBcysslByPage(Integer bcysslByPage) {
		this.bcysslByPage = bcysslByPage;
	}

	public Integer getBcdxrsl() {
		return bcdxrsl;
	}

	public void setBcdxrsl(Integer bcdxrsl) {
		this.bcdxrsl = bcdxrsl;
	}

	public Integer getBcysym() {
		return bcysym;
	}

	public void setBcysym(Integer bcysym) {
		this.bcysym = bcysym;
	}

	public String getCjdbm() {
		return cjdbm;
	}

	public void setCjdbm(String cjdbm) {
		this.cjdbm = cjdbm;
	}

	public Integer getIckslid() {
		return ickslid;
	}

	public void setIckslid(Integer ickslid) {
		this.ickslid = ickslid;
	}

	public Integer getMbjls() {
		return mbjls;
	}

	public void setMbjls(Integer mbjls) {
		this.mbjls = mbjls;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public Date getYxsksrq() {
		return yxsksrq;
	}

	public void setYxsksrq(Date yxsksrq) {
		this.yxsksrq = yxsksrq;
	}

	public Date getYxqhzrq() {
		return yxqhzrq;
	}

	public void setYxqhzrq(Date yxqhzrq) {
		this.yxqhzrq = yxqhzrq;
	}

	public String getCylbdm() {
		return cylbdm;
	}

	public void setCylbdm(String cylbdm) {
		this.cylbdm = cylbdm;
	}

	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	public byte[] getTpnr() {
		return tpnr;
	}

	public void setTpnr(byte[] tpnr) {
		this.tpnr = tpnr;
	}

	public String getCzr() {
		return czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public Integer getRyid() {
		return ryid;
	}

	public void setRyid(Integer ryid) {
		this.ryid = ryid;
	}

	public Integer getDxrbz() {
		return dxrbz;
	}

	public void setDxrbz(Integer dxrbz) {
		this.dxrbz = dxrbz;
	}

	public String getPchSel() {
		return pchSel;
	}

	public void setPchSel(String pchSel) {
		this.pchSel = pchSel;
	}

	public String getMoreThan3days() {
		return moreThan3days;
	}

	public void setMoreThan3days(String moreThan3days) {
		this.moreThan3days = moreThan3days;
	}

	public String getQyidSet() {
		return qyidSet;
	}

	public void setQyidSet(String qyidSet) {
		this.qyidSet = qyidSet;
	}

	public String getLikepch() {
		return likepch;
	}

	public void setLikepch(String likepch) {
		this.likepch = likepch;
	}

	public String getSfbx() {
		return sfbx;
	}

	public void setSfbx(String sfbx) {
		this.sfbx = sfbx;
	}

	public String getCylb() {
		return cylb;
	}

	public void setCylb(String cylb) {
		this.cylb = cylb;
	}

	public String getSxh() {
		return sxh;
	}

	public void setSxh(String sxh) {
		this.sxh = sxh;
	}

	public String getAllhylbdm() {
		return allhylbdm;
	}

	public void setAllhylbdm(String allhylbdm) {
		this.allhylbdm = allhylbdm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}
	
}
