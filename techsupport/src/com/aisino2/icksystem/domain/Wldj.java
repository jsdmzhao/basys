package com.aisino2.icksystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Wldj  {

	/** @param 物流登记信息(t_wldj) */

	/** @ --物流ID--wlid--Integer--10-- */
	private Integer wlid;

	/** @ --物流批次--wlpc--String--30-- */
	private String wlpc;

	/** @ --登记人--djr--String--30-- */
	private String djr;

	/** @ --组包时间--zbsj--Date---- */
	private Date zbsj;

	/** @ --目标受理点编号--mbsldbh--String--10-- */
	private String mbsldbh;

	/** @ --目标受理点名称--mbsldmc--String--100-- */
	private String mbsldmc;

	/** @ --状态代码--ztdm--String--3-- */
	private String ztdm;

	/** @ --状态代码名称--ztdmmc--String--20-- */
	private String ztdmmc;

	/** @ --反馈信息--fkxx--String--2000-- */
	private String fkxx;

	/** @ --反馈时间--fksj--Date---- */
	private Date fksj;

	/** @ --发送人--fsr--String--30-- */
	private String fsr;

	/** @ --发送时间--fssj--Date---- */
	private Date fssj;

	/** @ --所在地市编码--szdsbm--String--60-- */
	private String szdsbm;

	/** @ --所在地市--szds--String--200-- */
	private String szds;

	/** @ --接收人--jsr--String--30-- */
	private String jsr;

	/** @ --接收时间--jssj--Date---- */
	private Date jssj;

	/** @ --备注--bz--String--2000-- */
	private String bz;

	/** @ --物流公司--wlgs--String--200-- */
	private String wlgs;

	/** @ --包内卡数量--bnksl--Integer--6-- */
	private Integer bnksl;

	/** 分页排序 */
	private String pageSort;
	
	/** 从业人员编号串 */
	private String cyrybhSet;
	
	/** 卡号串 */
	private String khSet;
	
	/** 本次确认刷卡数量 */
	private Integer bcqrsksl;
	
	/** 本次确认刷卡数量 */
	private Integer yjssl;
	
	/** 操作人 */
	private String czr;
	
	/** 操作类型 */
	private String czlx;
	
	/** 发送起始时间 非数据库字段 */
	private Date fssjf;
	
	/** 发送截止时间 非数据库字段 */
	private Date fssjt;
	
	/** 接收起始时间 非数据库字段 */
	private Date jssjf;
	
	/** 接收截止时间 非数据库字段 */
	private Date jssjt;
	
	/** IC卡受理物流登记列表 */
	private List lIcksl_wldj;

	/** @ --行业类别代码--hylbdm--String--3-- */
	private String hylbdm;
	
	/** @ --运单号码--ydh--String--200-- */
	private String ydh;
	
	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	/** @ 物流ID(wlid) */
	public Integer getWlid() {
		return wlid;
	}

	public void setWlid(Integer wlid) {
		this.wlid = wlid;
	}

	/** @ 物流批次(wlpc) */
	public String getWlpc() {
		return wlpc;
	}

	public void setWlpc(String wlpc) {
		this.wlpc = wlpc;
	}

	/** @ 登记人(djr) */
	public String getDjr() {
		return djr;
	}

	public void setDjr(String djr) {
		this.djr = djr;
	}

	/** @ 组包时间(zbsj) */
	public Date getZbsj() {
		return zbsj;
	}

	public void setZbsj(Date zbsj) {
		this.zbsj = zbsj;
	}

	/** @ 目标受理点编号(mbsldbh) */
	public String getMbsldbh() {
		return mbsldbh;
	}

	public void setMbsldbh(String mbsldbh) {
		this.mbsldbh = mbsldbh;
	}

	/** @ 目标受理点名称(mbsldmc) */
	public String getMbsldmc() {
		return mbsldmc;
	}

	public void setMbsldmc(String mbsldmc) {
		this.mbsldmc = mbsldmc;
	}

	/** @ 状态代码(ztdm) */
	public String getZtdm() {
		return ztdm;
	}

	public void setZtdm(String ztdm) {
		this.ztdm = ztdm;
	}

	/** @ 状态代码名称(ztdmmc) */
	public String getZtdmmc() {
		return ztdmmc;
	}

	public void setZtdmmc(String ztdmmc) {
		this.ztdmmc = ztdmmc;
	}

	/** @ 反馈信息(fkxx) */
	public String getFkxx() {
		return fkxx;
	}

	public void setFkxx(String fkxx) {
		this.fkxx = fkxx;
	}

	/** @ 反馈时间(fksj) */
	public Date getFksj() {
		return fksj;
	}

	public void setFksj(Date fksj) {
		this.fksj = fksj;
	}

	/** @ 发送人(fsr) */
	public String getFsr() {
		return fsr;
	}

	public void setFsr(String fsr) {
		this.fsr = fsr;
	}

	/** @ 发送时间(fssj) */
	public Date getFssj() {
		return fssj;
	}

	public void setFssj(Date fssj) {
		this.fssj = fssj;
	}

	/** @ 所在地市编码(szdsbm) */
	public String getSzdsbm() {
		return szdsbm;
	}

	public void setSzdsbm(String szdsbm) {
		this.szdsbm = szdsbm;
	}

	/** @ 所在地市(szds) */
	public String getSzds() {
		return szds;
	}

	public void setSzds(String szds) {
		this.szds = szds;
	}

	/** @ 接收人(jsr) */
	public String getJsr() {
		return jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}

	/** @ 接收时间(jssj) */
	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	/** @ 备注(bz) */
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	/** @ 物流公司(wlgs) */
	public String getWlgs() {
		return wlgs;
	}

	public void setWlgs(String wlgs) {
		this.wlgs = wlgs;
	}

	/** @ 包内卡数量(bnksl) */
	public Integer getBnksl() {
		return bnksl;
	}

	public void setBnksl(Integer bnksl) {
		this.bnksl = bnksl;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getCyrybhSet() {
		return cyrybhSet;
	}

	public void setCyrybhSet(String cyrybhSet) {
		this.cyrybhSet = cyrybhSet;
	}

	public String getKhSet() {
		return khSet;
	}

	public void setKhSet(String khSet) {
		this.khSet = khSet;
	}

	public Integer getBcqrsksl() {
		return bcqrsksl;
	}

	public void setBcqrsksl(Integer bcqrsksl) {
		this.bcqrsksl = bcqrsksl;
	}

	public Integer getYjssl() {
		return yjssl;
	}

	public void setYjssl(Integer yjssl) {
		this.yjssl = yjssl;
	}

	public String getCzr() {
		return czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public String getCzlx() {
		return czlx;
	}

	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}

	public Date getFssjf() {
		return fssjf;
	}

	public void setFssjf(Date fssjf) {
		this.fssjf = fssjf;
	}

	public Date getFssjt() {
		return fssjt;
	}

	public void setFssjt(Date fssjt) {
		this.fssjt = fssjt;
	}

	public Date getJssjf() {
		return jssjf;
	}

	public void setJssjf(Date jssjf) {
		this.jssjf = jssjf;
	}

	public Date getJssjt() {
		return jssjt;
	}

	public void setJssjt(Date jssjt) {
		this.jssjt = jssjt;
	}

	public List getLIcksl_wldj() {
		return lIcksl_wldj;
	}

	public void setLIcksl_wldj(List icksl_wldj) {
		lIcksl_wldj = icksl_wldj;
	}

	public String getYdh() {
		return ydh;
	}

	public void setYdh(String ydh) {
		this.ydh = ydh;
	}

}
