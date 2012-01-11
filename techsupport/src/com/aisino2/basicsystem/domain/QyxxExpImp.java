package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class QyxxExpImp  {
	
	private Integer qyid;
	/** 企业编号 */
	private String qybm;
	/** 企业名称 */
	private String qymc;
	/** 法人姓名 */
	private String frxm;
	/** 联系电话 */
	private String lxdh;
	/** 管辖单位名称 */
	private String gxdwmc;
	/** 详细地址 */
	private String dizhi;
	
	/** 企业类型 */
	private String qylx;
	/** 企业产品类型编码 */
	private String qycplxbm;
	/** 总经理 */
	private String zjl;
	/** 治安负责人 */
	private String zafzr;
	/** 保安部电话 */
	private String babdh;
	/** 市级行政区划代码 */
	private String sjxzqhdm;
	/** 区县行政区划代码 */
	private String qxxzqhdm;
	/** 企业状态 */
	private String qyzt;
	/** 企业状态变更日期 */
	private String qyztgbrq;
	/** 机器编码 */
	private String jqbm;
	/** 上传时间 */
	private String scsj;
	/** 企业性质 */
	private String qyxz;
	/** 从业人员数 */
	private String cyrs;
	/** 治保人员数 */
	private String zbrys;
	/** 经培训数 */
	private String jpxrs;
	/** 业务人员 */
	private String ywry;
	/** 服务开始日期 */
	private String fwksrq;
	/** 服务结束日期 */
	private String fwjsrq;
	/** 合同编号 */
	private String htbh;
	/** 网络状况 */
	private String wlzk;
	/** 主分类编码 */
	private String zflbm;
	
	//旅馆业特殊信息开始
	/** 房间数 */
	private String fjs;
	/** 床位数 */
	private String cws;
	/** 宾馆星级 */
	private String bgxj;
	/** 宾馆等级 */
	private String bgdj;
	//旅馆业特殊信息结束
	
	//娱乐业特殊信息开始
	/** 包厢数量 */
	private String bxsl;
	/** 核定消费人数 */
	private String hdxfrs;
	/** 歌厅数 */
	private String gtsl;
	/** 舞池数 */
	private String wcsl;
	/** 出口数量 */
	private String cksl;
	
	/** 外网同步标志 */
	private String wwtbbz;
	//娱乐业特殊信息结束
	
	
	//参数用
	private String hylbdm;
	private String gxdwbm;
	private String checktab;
	private String selQyid;
	private String dcbs;
	private Date dcsj;
	private String cxtjDcbs; //查询条件
	private Date cxtjDcsj; //查询条件
	private String sqwjCon;
	
	private String stationid; //客户代码
	private String encodestr; //授权码
	
	public String getQybm() {
		return qybm;
	}
	public void setQybm(String qybm) {
		this.qybm = qybm;
	}
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc;
	}
	public String getFrxm() {
		return frxm;
	}
	public void setFrxm(String frxm) {
		this.frxm = frxm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getGxdwmc() {
		return gxdwmc;
	}
	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}
	public String getHylbdm() {
		return hylbdm;
	}
	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}
	public Integer getQyid() {
		return qyid;
	}
	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}
	public String getChecktab() {
		return checktab;
	}
	public void setChecktab(String checktab) {
		this.checktab = checktab;
	}
	public String getSelQyid() {
		return selQyid;
	}
	public void setSelQyid(String selQyid) {
		this.selQyid = selQyid;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getGxdwbm() {
		return gxdwbm;
	}
	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}
	public String getDcbs() {
		return dcbs;
	}
	public void setDcbs(String dcbs) {
		this.dcbs = dcbs;
	}
	public Date getDcsj() {
		return dcsj;
	}
	public void setDcsj(Date dcsj) {
		this.dcsj = dcsj;
	}
	public String getCxtjDcbs() {
		return cxtjDcbs;
	}
	public void setCxtjDcbs(String cxtjDcbs) {
		this.cxtjDcbs = cxtjDcbs;
	}
	public String getQylx() {
		return qylx;
	}
	public void setQylx(String qylx) {
		this.qylx = qylx;
	}
	public String getQycplxbm() {
		return qycplxbm;
	}
	public void setQycplxbm(String qycplxbm) {
		this.qycplxbm = qycplxbm;
	}
	public String getZjl() {
		return zjl;
	}
	public void setZjl(String zjl) {
		this.zjl = zjl;
	}
	public String getZafzr() {
		return zafzr;
	}
	public void setZafzr(String zafzr) {
		this.zafzr = zafzr;
	}
	public String getBabdh() {
		return babdh;
	}
	public void setBabdh(String babdh) {
		this.babdh = babdh;
	}
	public String getSjxzqhdm() {
		return sjxzqhdm;
	}
	public void setSjxzqhdm(String sjxzqhdm) {
		this.sjxzqhdm = sjxzqhdm;
	}
	public String getQxxzqhdm() {
		return qxxzqhdm;
	}
	public void setQxxzqhdm(String qxxzqhdm) {
		this.qxxzqhdm = qxxzqhdm;
	}
	public String getQyzt() {
		return qyzt;
	}
	public void setQyzt(String qyzt) {
		this.qyzt = qyzt;
	}
	public String getJqbm() {
		return jqbm;
	}
	public void setJqbm(String jqbm) {
		this.jqbm = jqbm;
	}
	public String getScsj() {
		return scsj;
	}
	public void setScsj(String scsj) {
		this.scsj = scsj;
	}
	public String getQyxz() {
		return qyxz;
	}
	public void setQyxz(String qyxz) {
		this.qyxz = qyxz;
	}
	public String getCyrs() {
		return cyrs;
	}
	public void setCyrs(String cyrs) {
		this.cyrs = cyrs;
	}
	public String getZbrys() {
		return zbrys;
	}
	public void setZbrys(String zbrys) {
		this.zbrys = zbrys;
	}
	public String getJpxrs() {
		return jpxrs;
	}
	public void setJpxrs(String jpxrs) {
		this.jpxrs = jpxrs;
	}
	public String getYwry() {
		return ywry;
	}
	public void setYwry(String ywry) {
		this.ywry = ywry;
	}
	public String getHtbh() {
		return htbh;
	}
	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}
	public String getWlzk() {
		return wlzk;
	}
	public void setWlzk(String wlzk) {
		this.wlzk = wlzk;
	}
	public String getFjs() {
		return fjs;
	}
	public void setFjs(String fjs) {
		this.fjs = fjs;
	}
	public String getCws() {
		return cws;
	}
	public void setCws(String cws) {
		this.cws = cws;
	}
	public String getBgxj() {
		return bgxj;
	}
	public void setBgxj(String bgxj) {
		this.bgxj = bgxj;
	}
	public String getBgdj() {
		return bgdj;
	}
	public void setBgdj(String bgdj) {
		this.bgdj = bgdj;
	}
	public String getBxsl() {
		return bxsl;
	}
	public void setBxsl(String bxsl) {
		this.bxsl = bxsl;
	}
	public String getHdxfrs() {
		return hdxfrs;
	}
	public void setHdxfrs(String hdxfrs) {
		this.hdxfrs = hdxfrs;
	}
	public String getGtsl() {
		return gtsl;
	}
	public void setGtsl(String gtsl) {
		this.gtsl = gtsl;
	}
	public String getWcsl() {
		return wcsl;
	}
	public void setWcsl(String wcsl) {
		this.wcsl = wcsl;
	}
	public String getCksl() {
		return cksl;
	}
	public void setCksl(String cksl) {
		this.cksl = cksl;
	}
	public String getQyztgbrq() {
		return qyztgbrq;
	}
	public void setQyztgbrq(String qyztgbrq) {
		this.qyztgbrq = qyztgbrq;
	}
	public String getFwksrq() {
		return fwksrq;
	}
	public void setFwksrq(String fwksrq) {
		this.fwksrq = fwksrq;
	}
	public String getFwjsrq() {
		return fwjsrq;
	}
	public void setFwjsrq(String fwjsrq) {
		this.fwjsrq = fwjsrq;
	}
	public String getSqwjCon() {
		return sqwjCon;
	}
	public void setSqwjCon(String sqwjCon) {
		this.sqwjCon = sqwjCon;
	}
	public String getStationid() {
		return stationid;
	}
	public void setStationid(String stationid) {
		this.stationid = stationid;
	}
	public String getEncodestr() {
		return encodestr;
	}
	public void setEncodestr(String encodestr) {
		this.encodestr = encodestr;
	}
	public Date getCxtjDcsj() {
		return cxtjDcsj;
	}
	public void setCxtjDcsj(Date cxtjDcsj) {
		this.cxtjDcsj = cxtjDcsj;
	}
	public String getZflbm() {
		return zflbm;
	}
	public void setZflbm(String zflbm) {
		this.zflbm = zflbm;
	}
	public String getWwtbbz() {
		return wwtbbz;
	}
	public void setWwtbbz(String wwtbbz) {
		this.wwtbbz = wwtbbz;
	}
}
