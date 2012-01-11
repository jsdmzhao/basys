package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Bdqclxxlsb  {

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) */

	/** @ --被盗抢车辆信息ID--bdqclxxid--Integer--10-- */
	private Integer bdqclxxid;

	/** @ --序号--id--String--46-- */
	private String id;

	/** @ --案件编号--ajbh--String--60-- */
	private String ajbh;

	/** @ --案件性质代码--ajxzdm--String--6-- */
	private String ajxzdm;

	/** @ --案件性质--ajxz--String--60-- */
	private String ajxz;

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

	/** @ --是否参加被盗抢险--sfbx--String--4-- */
	private String sfbx;

	/** @ --报案人--bar--String--128-- */
	private String bar;

	/** @ --立案单位区划编码--ladwqhbm--String--20-- */
	private String ladwqhbm;

	/** @ --立案单位区划--ladwqh--String--24-- */
	private String ladwqh;

	/** @ --立案单位编码--ladwbm--String--20-- */
	private String ladwbm;

	/** @ --立案单位名称--ladwmc--String--100-- */
	private String ladwmc;

	/** @ --立案时间--lasj--Date---- */
	private Date lasj;

	/** @ --立案经办人--lajbr--String--128-- */
	private String lajbr;

	/** @ --立案单位联系电话--ladh--String--128-- */
	private String ladh;

	/** @ --受理单位区划编码--sldwqhbm--String--20-- */
	private String sldwqhbm;

	/** @ --受理单位区划--sldwqh--String--24-- */
	private String sldwqh;

	/** @ --受理单位编码--sldwbm--String--24-- */
	private String sldwbm;

	/** @ --受理单位名称--sldwmc--String--128-- */
	private String sldwmc;

	/** @ --受理时间--slsj--Date---- */
	private Date slsj;

	/** @ --受理经办人--sljbr--String--128-- */
	private String sljbr;

	/** @ --受理单位联系电话--sldh--String--128-- */
	private String sldh;

	/** @ --备注--bz--String--2000-- */
	private String bz;

	/** @ --填报单位区划编码--tbdwqhbm--String--24-- */
	private String tbdwqhbm;

	/** @ --填报单位区划--tbdwqh--String--24-- */
	private String tbdwqh;

	/** @ --填报单位编码--tbdwbm--String--24-- */
	private String tbdwbm;

	/** @ --填报单位名称--tbdwmc--String--128-- */
	private String tbdwmc;

	/** @ --填表人--tbtbr--String--128-- */
	private String tbtbr;

	/** @ --填表时间--tbsj3--Date---- */
	private Date tbsj3;

	/** @ --状态--zt--String--2-- */
	private String zt;

	/** @ --删除标志--scbz--Integer--2-- */
	private Integer scbz;

	/** @ --录入单位编码--lrdwbm--String--20-- */
	private String lrdwbm;

	/** @ --录入单位--lrdw--String--128-- */
	private String lrdw;

	/** @ --录入人--lrr--String--30-- */
	private String lrr;

	/** @ --录入时间--lrsj--Date---- */
	private Date lrsj;

	/** @ --修改单位编码--xgdwbm--String--24-- */
	private String xgdwbm;

	/** @ --修改单位--xgdw--String--128-- */
	private String xgdw;

	/** @ --修改人--xgr--String--128-- */
	private String xgr;

	/** @ --修改时间--xgsj--Date---- */
	private Date xgsj;

	/** @ --审批人--spr3--String--128-- */
	private String spr3;

	/** @ --审批意见--spyj--String--512-- */
	private String spyj;

	/** @ --使用单位编码--sydwbm--String--24-- */
	private String sydwbm;

	/** @ --使用单位--sydw--String--128-- */
	private String sydw;

	/** 分页排序 */
	private String pageSort;

	/** @ 被盗抢车辆信息ID(bdqclxxid) */
	public Integer getBdqclxxid() {
		return bdqclxxid;
	}

	public void setBdqclxxid(Integer bdqclxxid) {
		this.bdqclxxid = bdqclxxid;
	}

	/** @ 序号(id) */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/** @ 案件编号(ajbh) */
	public String getAjbh() {
		return ajbh;
	}

	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
	}

	/** @ 案件性质代码(ajxzdm) */
	public String getAjxzdm() {
		return ajxzdm;
	}

	public void setAjxzdm(String ajxzdm) {
		this.ajxzdm = ajxzdm;
	}

	/** @ 案件性质(ajxz) */
	public String getAjxz() {
		return ajxz;
	}

	public void setAjxz(String ajxz) {
		this.ajxz = ajxz;
	}

	/** @ 车辆类型代码(cllxdm) */
	public String getCllxdm() {
		return cllxdm;
	}

	public void setCllxdm(String cllxdm) {
		this.cllxdm = cllxdm;
	}

	/** @ 车辆类型(cllx) */
	public String getCllx() {
		return cllx;
	}

	public void setCllx(String cllx) {
		this.cllx = cllx;
	}

	/** @ 车辆品牌(clpp) */
	public String getClpp() {
		return clpp;
	}

	public void setClpp(String clpp) {
		this.clpp = clpp;
	}

	/** @ 车辆型号(clxh) */
	public String getClxh() {
		return clxh;
	}

	public void setClxh(String clxh) {
		this.clxh = clxh;
	}

	/** @ 号牌种类代码(hpzldm) */
	public String getHpzldm() {
		return hpzldm;
	}

	public void setHpzldm(String hpzldm) {
		this.hpzldm = hpzldm;
	}

	/** @ 号牌种类(hpzl) */
	public String getHpzl() {
		return hpzl;
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	/** @ 号牌号码(hphm) */
	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	/** @ 车身颜色(csys) */
	public String getCsys() {
		return csys;
	}

	public void setCsys(String csys) {
		this.csys = csys;
	}

	/** @ 机动车所有人(syr) */
	public String getSyr() {
		return syr;
	}

	public void setSyr(String syr) {
		this.syr = syr;
	}

	/** @ 初次登记时间(ccdjrq) */
	public Date getCcdjrq() {
		return ccdjrq;
	}

	public void setCcdjrq(Date ccdjrq) {
		this.ccdjrq = ccdjrq;
	}

	/** @ 发动机号(fdjh) */
	public String getFdjh() {
		return fdjh;
	}

	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}

	/** @ 车辆识别代号(clsbdh) */
	public String getClsbdh() {
		return clsbdh;
	}

	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}

	/** @ 车架号(cjh) */
	public String getCjh() {
		return cjh;
	}

	public void setCjh(String cjh) {
		this.cjh = cjh;
	}

	/** @ 是否参加被盗抢险(sfbx) */
	public String getSfbx() {
		return sfbx;
	}

	public void setSfbx(String sfbx) {
		this.sfbx = sfbx;
	}

	/** @ 报案人(bar) */
	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	/** @ 立案单位区划编码(ladwqhbm) */
	public String getLadwqhbm() {
		return ladwqhbm;
	}

	public void setLadwqhbm(String ladwqhbm) {
		this.ladwqhbm = ladwqhbm;
	}

	/** @ 立案单位区划(ladwqh) */
	public String getLadwqh() {
		return ladwqh;
	}

	public void setLadwqh(String ladwqh) {
		this.ladwqh = ladwqh;
	}

	/** @ 立案单位编码(ladwbm) */
	public String getLadwbm() {
		return ladwbm;
	}

	public void setLadwbm(String ladwbm) {
		this.ladwbm = ladwbm;
	}

	/** @ 立案单位名称(ladwmc) */
	public String getLadwmc() {
		return ladwmc;
	}

	public void setLadwmc(String ladwmc) {
		this.ladwmc = ladwmc;
	}

	/** @ 立案时间(lasj) */
	public Date getLasj() {
		return lasj;
	}

	public void setLasj(Date lasj) {
		this.lasj = lasj;
	}

	/** @ 立案经办人(lajbr) */
	public String getLajbr() {
		return lajbr;
	}

	public void setLajbr(String lajbr) {
		this.lajbr = lajbr;
	}

	/** @ 立案单位联系电话(ladh) */
	public String getLadh() {
		return ladh;
	}

	public void setLadh(String ladh) {
		this.ladh = ladh;
	}

	/** @ 受理单位区划编码(sldwqhbm) */
	public String getSldwqhbm() {
		return sldwqhbm;
	}

	public void setSldwqhbm(String sldwqhbm) {
		this.sldwqhbm = sldwqhbm;
	}

	/** @ 受理单位区划(sldwqh) */
	public String getSldwqh() {
		return sldwqh;
	}

	public void setSldwqh(String sldwqh) {
		this.sldwqh = sldwqh;
	}

	/** @ 受理单位编码(sldwbm) */
	public String getSldwbm() {
		return sldwbm;
	}

	public void setSldwbm(String sldwbm) {
		this.sldwbm = sldwbm;
	}

	/** @ 受理单位名称(sldwmc) */
	public String getSldwmc() {
		return sldwmc;
	}

	public void setSldwmc(String sldwmc) {
		this.sldwmc = sldwmc;
	}

	/** @ 受理时间(slsj) */
	public Date getSlsj() {
		return slsj;
	}

	public void setSlsj(Date slsj) {
		this.slsj = slsj;
	}

	/** @ 受理经办人(sljbr) */
	public String getSljbr() {
		return sljbr;
	}

	public void setSljbr(String sljbr) {
		this.sljbr = sljbr;
	}

	/** @ 受理单位联系电话(sldh) */
	public String getSldh() {
		return sldh;
	}

	public void setSldh(String sldh) {
		this.sldh = sldh;
	}

	/** @ 备注(bz) */
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	/** @ 填报单位区划编码(tbdwqhbm) */
	public String getTbdwqhbm() {
		return tbdwqhbm;
	}

	public void setTbdwqhbm(String tbdwqhbm) {
		this.tbdwqhbm = tbdwqhbm;
	}

	/** @ 填报单位区划(tbdwqh) */
	public String getTbdwqh() {
		return tbdwqh;
	}

	public void setTbdwqh(String tbdwqh) {
		this.tbdwqh = tbdwqh;
	}

	/** @ 填报单位编码(tbdwbm) */
	public String getTbdwbm() {
		return tbdwbm;
	}

	public void setTbdwbm(String tbdwbm) {
		this.tbdwbm = tbdwbm;
	}

	/** @ 填报单位名称(tbdwmc) */
	public String getTbdwmc() {
		return tbdwmc;
	}

	public void setTbdwmc(String tbdwmc) {
		this.tbdwmc = tbdwmc;
	}

	/** @ 填表人(tbtbr) */
	public String getTbtbr() {
		return tbtbr;
	}

	public void setTbtbr(String tbtbr) {
		this.tbtbr = tbtbr;
	}

	/** @ 填表时间(tbsj3) */
	public Date getTbsj3() {
		return tbsj3;
	}

	public void setTbsj3(Date tbsj3) {
		this.tbsj3 = tbsj3;
	}

	/** @ 状态(zt) */
	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	/** @ 删除标志(scbz) */
	public Integer getScbz() {
		return scbz;
	}

	public void setScbz(Integer scbz) {
		this.scbz = scbz;
	}

	/** @ 录入单位编码(lrdwbm) */
	public String getLrdwbm() {
		return lrdwbm;
	}

	public void setLrdwbm(String lrdwbm) {
		this.lrdwbm = lrdwbm;
	}

	/** @ 录入单位(lrdw) */
	public String getLrdw() {
		return lrdw;
	}

	public void setLrdw(String lrdw) {
		this.lrdw = lrdw;
	}

	/** @ 录入人(lrr) */
	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	/** @ 录入时间(lrsj) */
	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	/** @ 修改单位编码(xgdwbm) */
	public String getXgdwbm() {
		return xgdwbm;
	}

	public void setXgdwbm(String xgdwbm) {
		this.xgdwbm = xgdwbm;
	}

	/** @ 修改单位(xgdw) */
	public String getXgdw() {
		return xgdw;
	}

	public void setXgdw(String xgdw) {
		this.xgdw = xgdw;
	}

	/** @ 修改人(xgr) */
	public String getXgr() {
		return xgr;
	}

	public void setXgr(String xgr) {
		this.xgr = xgr;
	}

	/** @ 修改时间(xgsj) */
	public Date getXgsj() {
		return xgsj;
	}

	public void setXgsj(Date xgsj) {
		this.xgsj = xgsj;
	}

	/** @ 审批人(spr3) */
	public String getSpr3() {
		return spr3;
	}

	public void setSpr3(String spr3) {
		this.spr3 = spr3;
	}

	/** @ 审批意见(spyj) */
	public String getSpyj() {
		return spyj;
	}

	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}

	/** @ 使用单位编码(sydwbm) */
	public String getSydwbm() {
		return sydwbm;
	}

	public void setSydwbm(String sydwbm) {
		this.sydwbm = sydwbm;
	}

	/** @ 使用单位(sydw) */
	public String getSydw() {
		return sydw;
	}

	public void setSydw(String sydw) {
		this.sydw = sydw;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}
}
