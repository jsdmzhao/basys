package com.aisino2.icksystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;
import com.aisino2.publicsystem.domain.Qyryxx;

public class Icksl  {

	/** @param IC卡受理(t_icksl) */

	/** @ --IC卡受理ID--ickslid--Integer--10-- */
	private Integer ickslid;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --从业人员ID--ryid--Integer--10-- */
	private Integer ryid;

	/** @ --行业类别代码--hylbdm--String--3-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

	/** @ --卡号--kh--String--20-- */
	private String kh;

	/** @ --卡ID号--ickh--String--100-- */
	private String ickh;

	/** @ --申领原因--slyy--String--200-- */
	private String slyy;

	/** @ --受理人--slr--String--30-- */
	private String slr;

	/** @ --受理时间--slsj--Date---- */
	private Date slsj;

	/** @ --有效期开始日期--yxsksrq--Date---- */
	private Date yxsksrq;

	/** @ --有效期截至日期--yxqhzrq--Date---- */
	private Date yxqhzrq;
	
	/** @ --新有效期截至日期--xyxqhzrq--Date---- */
	private Date xyxqhzrq;

	/** @ --采集时间--cjsj--Date---- */
	private Date cjsj;

	/** @ --采集人--cjr--String--30-- */
	private String cjr;

	/** @ --采集点编码--cjdbm--String--20-- */
	private String cjdbm;

	/** @ --采集点名称--cjdmc--String--100-- */
	private String cjdmc;

	/** @ --接收时间--jssj--Date---- */
	private Date jssj;

	/** @ --接收包名称--jsbmc--String--20-- */
	private String jsbmc;

	/** @ --发放人--ffr--String--30-- */
	private String ffr;

	/** @ --发放时间--ffsj--Date---- */
	private Date ffsj;

	/** @ --领取人--lqr--String--30-- */
	private String lqr;

	/** @ --领取时间--lqsj--Date---- */
	private Date lqsj;

	/** @ --领取人证件类型--lqrzjlx--String--40-- */
	private String lqrzjlx;

	/** @ --领取人证件号码--lqrzjhm--String--20-- */
	private String lqrzjhm;

	/** @ --IC卡注销人--ickzxr--String--30-- */
	private String ickzxr;

	/** @ --IC卡注销时间--ickzxsj--Date---- */
	private Date ickzxsj;

	/** @ --IC卡注销原因--ickzxyy--String--200-- */
	private String ickzxyy;

	/** @ --年检人--njr--String--30-- */
	private String njr;

	/** @ --年检时间--njsj--Date---- */
	private Date njsj;

	/** @ --制卡状态标识--zkztbs--String--2-- */
	private String zkztbs;

	/** @ --是否确认--sfqr--String--1-- */
	private String sfqr;

	/** @ --印刷人--ysr--String--100-- */
	private String ysr;

	/** @ --印刷时间--yssj--Date---- */
	private Date yssj;

	/** @ --电写入人--dxrr--String--100-- */
	private String dxrr;

	/** @ --电写入时间--dxrsj--Date---- */
	private Date dxrsj;

	/** @ --重印刷时间--cyssj--Date---- */
	private Date cyssj;

	/** @ --重印刷原因--cysyy--String--200-- */
	private String cysyy;

	/** @ --重电写入时间--cdxrsj--Date---- */
	private Date cdxrsj;

	/** @ --重电写入原因--cdxryy--String--200-- */
	private String cdxryy;

	/** @ --补换卡原因--bhkyy--String--200-- */
	private String bhkyy;

	/** @ --原卡是否收回--yksfsh--String--1-- */
	private String yksfsh;

	/** 分页排序 */
	private String pageSort;
	
	/** 照片审核是否通过 0-不通过，1-通过*/
	private String sftg;
	
	/** 照片审核是否全部审核通过 0-不通过，1-通过*/
	private String sfqbtg;
	
	/** 照片不通过原因*/
	private String zpwtgyy;
	
	/** 从业人员信息 */
	private Qyryxx qyryxx;
	
	/** 从业人员编号串 ,可存放多个从业人员编号*/
	private String cyrybhSet;
	
	/** 卡号串 ,可存放多个卡号*/
	private String khSet;
	
	//以下属性用于查询条件或显示结果
	
	/** 从业人员编号*/
	private String cyrybh;

	/** 从业类别代码*/
	private String cylbdm;
	
	/** 从业类别*/
	private String cylb;
	
	/** @ --从业人员类别代码-- */
	private String cyrylbdm;

	/** @ --从业人员类别名称-- */
	private String cyrylbmc;
	
	/** 企业名称*/
	private String qymc;
	
	/**  姓名*/
	private String xm;
	
	/**  性别代码*/
	private String xbdm;
	
	/**  性别名称*/
	private String xb;
	
	/** @ --民族代码---- */
	private String mzdm;

	/** @ --民族---- */
	private String minzu;
	
	/**  证件类型代码*/
	private String cyzjdm;
	
	/**  证件类型名称*/
	private String cyzj;
	
	/**  证件号码*/
	private String zjhm;
	
	/** @ --采集起始时间 */
	private Date cjsjf;
	
	/** @ --采集截止时间 */
	private Date cjsjt;
	
	/**  从业人员状态*/
	private String zt;
	
	/** @ --出生日期-- */
	private Date csrq;

	/** @ --户籍地行政区划-- */
	private String hjdxzqh;

	/** @ --户籍地行政区划代码-- */
	private String hjdxzqhdm;
	
	/** @ --户籍地详址---- */
	private String hjdxz;
	
	/** @ --国籍代码-- */
	private String gjdm;

	/** @ --国籍-- */
	private String gj;
	
	/** @ --英文姓-- */
	private String ywx;

	/** @ --英文名-- */
	private String ywm;

	/** @ --外国人就业许可证号-- */
	private String wgrjyxkz;
	
	/** @ --签证号码-- */
	private String qzhm;
	
	/** @ --IC卡在ICKZB中的顺序号-- */
	private String sxh;
	
	/** @ --管辖单位编码-- */
	private String gxdwbm;
	
	/** 物流批次*/
	private String wlpc;
	
	/** @ --制卡状态名称 -- 非数据库字段 */
	private String zkztmc;
	
	/** @ --操作人 用于IC卡日志记录*/
	private String czr;
	
	/** @ --操作类型*/
	private String czlx;
	
	/** @ --是否注销*/
	private String sfzx;
	
	/** @ --是否注销名称*/
	private String sfzxmc;
	
	/** @ --受理起始时间*/
	private Date slsjf;
	
	/** @ --受理结束时间*/
	private Date slsjt;
	
	/** @ --物流ID-- */
	private Integer wlid;
	
	/** @ IC卡受理列表 */
	private List lIcksl;
	
	/** @ 从业人员列表 */
	private List lQyryxx;
	
	/** @ --是否进行公安人口库比对*/
	private String sfjxgarkkbd;
	
	/** @ 图片内容 */
	private byte[] tpnr;
	
	/**人员ID集合*/
	private String ryidSet;

	/**IC卡ID集合*/
	private String ickslidSet;
	
	/**企业ID集合*/
	private String qyidSet;
	
	/**IC卡ID集合*/
	private String zpsftgSet;
	
	/**场所ID集合*/
	private String wtgyySet;
	
	/** 批次号*/
	private String pch;
	
	/**是否同音*/
	private String sfty;
	
	/** @ --所属省份--*/
	private String sssf;
	
	/** @ --是否按采集点排序 用于查询IC卡未组包数据--*/
	private String orderByCjdbm;
	
	/** @ --制卡端从业信息 IC卡查询 标志 非数据库字段--*/
	private String zkdCyryIck;
	
	/** 已采集三天及以上*/
	private String moreThan3days;
	
	/** 二级审核开关 0-关 1-开*/
	private String ejshkg;
	
	private String applyid;//大河webservice每条记录的唯一标示符
	
	private String stringkh;//大河webservice的，多个kh连成的字符串
	
	private String zxbz;//是否注销标志 0-未注销 1-已注销（包括卡注销、人注销、补换卡注销）
	private String dqzt;//当前状态 1为选中 
	
	
	
	//一下属性用于第三方制卡统计功能
	private String ssdsbm;//所属地市编码
	private String ssdsmc;//所属地市名称
	private String yfssl;//已发送到制卡中心数量
	private String yfksl;//制卡中心已反馈数量
	private String yzksl;//制卡中心已制卡数量
	private String fksbsl;//制卡中心反馈失败数量
	private String yffsl;//已发放数量
	private String ssdsbz;//所属地市标识
	private String cjdbz;//所属采集点标识
	private String deptCode;
	private String zqsjx;
	
	private Date qssj;
	private Date jzsj;
	
	private Date lrsj;// 录入时间
	private String cyryzt;// 从业人员状态
	private String gwbh;// 岗位编号
	private String gwmc;// 岗位名称
	
	//制卡端--台账信息统计
	private String yshzpsl;//已审核照片信息
	private String yzbsl;//已组包
	private String yyssl;//已印刷
	private String ydxrsl;//已点写入
	private String ickwlyfssl;//IC卡物流已发送
	private String ickwlyzbsl;//IC卡物流已组包
	private String ickwlyjssl;//IC卡物流已接收
	
	private String dshzpsl;//待审核照片信息
	private String dzbsl;//待组包信息
	private String dyssl;//待印刷信息
	private String ddxrsl;//待点写入信息
	
	//采集端--台账第三方制卡统计
	private String qysl;//企业数量
	private String rysl;//人员数量
	private String yslick;//已受理ic卡
	
	private String ycjcssl;//已采集场所
	private String ycjrysl;//已采集人员
	private String ytjcssl;//已提交场所
	private String ytjrysl;//已提交人员
	private String yjswlbsl;//已接受物流包
	private String yzxicksl;//已注销ic卡数量
	private String bhicksl;//补换卡数量
	private String wtjcssl;//未统计场所数量
	private String wtjrysl;//未统计人员数量
	private String dfficksl;//待发放IC卡数量
	private String dbhicksl;//待补换IC卡数量
	private String wlbbfjs;//物流包部分接收
	private String wlbjsbcg;//物流包接收不成功
	/** @ --物流包制卡状态标识 制卡状态的冗余字段--wlbzkztbs--String--2-- */
	private String wlbzkztbs;
	
	private String allhylbdm;
	
	private String hjlbdm; //户籍类别代码
	private String hjlbmc; //户籍类别名称
	
	

	public String getWlbzkztbs() {
		return wlbzkztbs;
	}

	public void setWlbzkztbs(String wlbzkztbs) {
		this.wlbzkztbs = wlbzkztbs;
	}

	public String getWlbbfjs() {
		return wlbbfjs;
	}

	public void setWlbbfjs(String wlbbfjs) {
		this.wlbbfjs = wlbbfjs;
	}

	public String getWlbjsbcg() {
		return wlbjsbcg;
	}

	public void setWlbjsbcg(String wlbjsbcg) {
		this.wlbjsbcg = wlbjsbcg;
	}

	public String getWtjcssl() {
		return wtjcssl;
	}

	public void setWtjcssl(String wtjcssl) {
		this.wtjcssl = wtjcssl;
	}

	public String getWtjrysl() {
		return wtjrysl;
	}

	public void setWtjrysl(String wtjrysl) {
		this.wtjrysl = wtjrysl;
	}

	public String getDfficksl() {
		return dfficksl;
	}

	public void setDfficksl(String dfficksl) {
		this.dfficksl = dfficksl;
	}

	public String getDbhicksl() {
		return dbhicksl;
	}

	public void setDbhicksl(String dbhicksl) {
		this.dbhicksl = dbhicksl;
	}

	public String getQysl() {
		return qysl;
	}

	public void setQysl(String qysl) {
		this.qysl = qysl;
	}

	public String getRysl() {
		return rysl;
	}

	public void setRysl(String rysl) {
		this.rysl = rysl;
	}

	public String getYslick() {
		return yslick;
	}

	public void setYslick(String yslick) {
		this.yslick = yslick;
	}

	public String getGwbh() {
		return gwbh;
	}

	public void setGwbh(String gwbh) {
		this.gwbh = gwbh;
	}

	public String getGwmc() {
		return gwmc;
	}

	public void setGwmc(String gwmc) {
		this.gwmc = gwmc;
	}

	public String getCyryzt() {
		return cyryzt;
	}

	public void setCyryzt(String cyryzt) {
		this.cyryzt = cyryzt;
	}

	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	/** @ IC卡受理ID(ickslid) */
	public Integer getIckslid() {
		return ickslid;
	}

	public void setIckslid(Integer ickslid) {
		this.ickslid = ickslid;
	}

	/** @ 企业编码(qybm) */
	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		this.qybm = qybm;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 从业人员ID(ryid) */
	public Integer getRyid() {
		return ryid;
	}

	public void setRyid(Integer ryid) {
		this.ryid = ryid;
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

	/** @ 卡号(kh) */
	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	/** @ 卡ID号(ickh) */
	public String getIckh() {
		return ickh;
	}

	public void setIckh(String ickh) {
		this.ickh = ickh;
	}

	/** @ 申领原因(slyy) */
	public String getSlyy() {
		return slyy;
	}

	public void setSlyy(String slyy) {
		this.slyy = slyy;
	}

	/** @ 受理人(slr) */
	public String getSlr() {
		return slr;
	}

	public void setSlr(String slr) {
		this.slr = slr;
	}

	/** @ 受理时间(slsj) */
	public Date getSlsj() {
		return slsj;
	}

	public void setSlsj(Date slsj) {
		this.slsj = slsj;
	}

	/** @ 有效期开始日期(yxsksrq) */
	public Date getYxsksrq() {
		return yxsksrq;
	}

	public void setYxsksrq(Date yxsksrq) {
		this.yxsksrq = yxsksrq;
	}

	/** @ 有效期截至日期(yxqhzrq) */
	public Date getYxqhzrq() {
		return yxqhzrq;
	}

	public void setYxqhzrq(Date yxqhzrq) {
		this.yxqhzrq = yxqhzrq;
	}

	/** @ 采集时间(cjsj) */
	public Date getCjsj() {
		return cjsj;
	}

	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}

	/** @ 采集人(cjr) */
	public String getCjr() {
		return cjr;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	/** @ 采集点编码(cjdbm) */
	public String getCjdbm() {
		return cjdbm;
	}

	public void setCjdbm(String cjdbm) {
		this.cjdbm = cjdbm;
	}

	/** @ 采集点名称(cjdmc) */
	public String getCjdmc() {
		return cjdmc;
	}

	public void setCjdmc(String cjdmc) {
		this.cjdmc = cjdmc;
	}

	/** @ 接收时间(jssj) */
	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	/** @ 接收包名称(jsbmc) */
	public String getJsbmc() {
		return jsbmc;
	}

	public void setJsbmc(String jsbmc) {
		this.jsbmc = jsbmc;
	}

	/** @ 发放人(ffr) */
	public String getFfr() {
		return ffr;
	}

	public void setFfr(String ffr) {
		this.ffr = ffr;
	}

	/** @ 发放时间(ffsj) */
	public Date getFfsj() {
		return ffsj;
	}

	public void setFfsj(Date ffsj) {
		this.ffsj = ffsj;
	}

	/** @ 领取人(lqr) */
	public String getLqr() {
		return lqr;
	}

	public void setLqr(String lqr) {
		this.lqr = lqr;
	}

	/** @ 领取时间(lqsj) */
	public Date getLqsj() {
		return lqsj;
	}

	public void setLqsj(Date lqsj) {
		this.lqsj = lqsj;
	}

	/** @ 领取人证件类型(lqrzjlx) */
	public String getLqrzjlx() {
		return lqrzjlx;
	}

	public void setLqrzjlx(String lqrzjlx) {
		this.lqrzjlx = lqrzjlx;
	}

	/** @ 领取人证件号码(lqrzjhm) */
	public String getLqrzjhm() {
		return lqrzjhm;
	}

	public void setLqrzjhm(String lqrzjhm) {
		this.lqrzjhm = lqrzjhm;
	}

	/** @ IC卡注销人(ickzxr) */
	public String getIckzxr() {
		return ickzxr;
	}

	public void setIckzxr(String ickzxr) {
		this.ickzxr = ickzxr;
	}

	/** @ IC卡注销时间(ickzxsj) */
	public Date getIckzxsj() {
		return ickzxsj;
	}

	public void setIckzxsj(Date ickzxsj) {
		this.ickzxsj = ickzxsj;
	}

	/** @ IC卡注销原因(ickzxyy) */
	public String getIckzxyy() {
		return ickzxyy;
	}

	public void setIckzxyy(String ickzxyy) {
		this.ickzxyy = ickzxyy;
	}

	/** @ 年检人(njr) */
	public String getNjr() {
		return njr;
	}

	public void setNjr(String njr) {
		this.njr = njr;
	}

	/** @ 年检时间(njsj) */
	public Date getNjsj() {
		return njsj;
	}

	public void setNjsj(Date njsj) {
		this.njsj = njsj;
	}

	/** @ 制卡状态标识(zkztbs) */
	public String getZkztbs() {
		return zkztbs;
	}

	public void setZkztbs(String zkztbs) {
		this.zkztbs = zkztbs;
	}

	/** @ 是否确认(sfqr) */
	public String getSfqr() {
		return sfqr;
	}

	public void setSfqr(String sfqr) {
		this.sfqr = sfqr;
	}

	/** @ 印刷人(ysr) */
	public String getYsr() {
		return ysr;
	}

	public void setYsr(String ysr) {
		this.ysr = ysr;
	}

	/** @ 印刷时间(yssj) */
	public Date getYssj() {
		return yssj;
	}

	public void setYssj(Date yssj) {
		this.yssj = yssj;
	}

	/** @ 电写入人(dxrr) */
	public String getDxrr() {
		return dxrr;
	}

	public void setDxrr(String dxrr) {
		this.dxrr = dxrr;
	}

	/** @ 电写入时间(dxrsj) */
	public Date getDxrsj() {
		return dxrsj;
	}

	public void setDxrsj(Date dxrsj) {
		this.dxrsj = dxrsj;
	}

	/** @ 重印刷时间(cyssj) */
	public Date getCyssj() {
		return cyssj;
	}

	public void setCyssj(Date cyssj) {
		this.cyssj = cyssj;
	}

	/** @ 重印刷原因(cysyy) */
	public String getCysyy() {
		return cysyy;
	}

	public void setCysyy(String cysyy) {
		this.cysyy = cysyy;
	}

	/** @ 重电写入时间(cdxrsj) */
	public Date getCdxrsj() {
		return cdxrsj;
	}

	public void setCdxrsj(Date cdxrsj) {
		this.cdxrsj = cdxrsj;
	}

	/** @ 重电写入原因(cdxryy) */
	public String getCdxryy() {
		return cdxryy;
	}

	public void setCdxryy(String cdxryy) {
		this.cdxryy = cdxryy;
	}

	/** @ 补换卡原因(bhkyy) */
	public String getBhkyy() {
		return bhkyy;
	}

	public void setBhkyy(String bhkyy) {
		this.bhkyy = bhkyy;
	}

	/** @ 原卡是否收回(yksfsh) */
	public String getYksfsh() {
		return yksfsh;
	}

	public void setYksfsh(String yksfsh) {
		this.yksfsh = yksfsh;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getSftg() {
		return sftg;
	}

	public void setSftg(String sftg) {
		this.sftg = sftg;
	}

	public String getSfqbtg() {
		return sfqbtg;
	}

	public void setSfqbtg(String sfqbtg) {
		this.sfqbtg = sfqbtg;
	}

	public String getZpwtgyy() {
		return zpwtgyy;
	}

	public void setZpwtgyy(String zpwtgyy) {
		this.zpwtgyy = zpwtgyy;
	}

	public Qyryxx getQyryxx() {
		return qyryxx;
	}

	public void setQyryxx(Qyryxx qyryxx) {
		this.qyryxx = qyryxx;
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

	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	public String getCylbdm() {
		return cylbdm;
	}

	public void setCylbdm(String cylbdm) {
		this.cylbdm = cylbdm;
	}

	public String getCylb() {
		return cylb;
	}

	public void setCylb(String cylb) {
		this.cylb = cylb;
	}

	public String getCyrylbdm() {
		return cyrylbdm;
	}

	public void setCyrylbdm(String cyrylbdm) {
		this.cyrylbdm = cyrylbdm;
	}

	public String getCyrylbmc() {
		return cyrylbmc;
	}

	public void setCyrylbmc(String cyrylbmc) {
		this.cyrylbmc = cyrylbmc;
	}

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	public String getMinzu() {
		return minzu;
	}

	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}

	public String getCyzjdm() {
		return cyzjdm;
	}

	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}

	public String getCyzj() {
		return cyzj;
	}

	public void setCyzj(String cyzj) {
		this.cyzj = cyzj;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public Date getCjsjf() {
		return cjsjf;
	}

	public void setCjsjf(Date cjsjf) {
		this.cjsjf = cjsjf;
	}

	public Date getCjsjt() {
		return cjsjt;
	}

	public void setCjsjt(Date cjsjt) {
		this.cjsjt = cjsjt;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getHjdxzqh() {
		return hjdxzqh;
	}

	public void setHjdxzqh(String hjdxzqh) {
		this.hjdxzqh = hjdxzqh;
	}

	public String getHjdxzqhdm() {
		return hjdxzqhdm;
	}

	public void setHjdxzqhdm(String hjdxzqhdm) {
		this.hjdxzqhdm = hjdxzqhdm;
	}

	public String getHjdxz() {
		return hjdxz;
	}

	public void setHjdxz(String hjdxz) {
		this.hjdxz = hjdxz;
	}

	public String getGjdm() {
		return gjdm;
	}

	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
	}

	public String getGj() {
		return gj;
	}

	public void setGj(String gj) {
		this.gj = gj;
	}

	public String getYwx() {
		return ywx;
	}

	public void setYwx(String ywx) {
		this.ywx = ywx;
	}

	public String getYwm() {
		return ywm;
	}

	public void setYwm(String ywm) {
		this.ywm = ywm;
	}

	public String getWgrjyxkz() {
		return wgrjyxkz;
	}

	public void setWgrjyxkz(String wgrjyxkz) {
		this.wgrjyxkz = wgrjyxkz;
	}

	public String getQzhm() {
		return qzhm;
	}

	public void setQzhm(String qzhm) {
		this.qzhm = qzhm;
	}

	public String getSxh() {
		return sxh;
	}

	public void setSxh(String sxh) {
		this.sxh = sxh;
	}

	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}

	public String getWlpc() {
		return wlpc;
	}

	public void setWlpc(String wlpc) {
		this.wlpc = wlpc;
	}

	public String getZkztmc() {
		return zkztmc;
	}

	public void setZkztmc(String zkztmc) {
		this.zkztmc = zkztmc;
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

	public String getSfzx() {
		return sfzx;
	}

	public void setSfzx(String sfzx) {
		this.sfzx = sfzx;
	}

	public String getSfzxmc() {
		return sfzxmc;
	}

	public void setSfzxmc(String sfzxmc) {
		this.sfzxmc = sfzxmc;
	}

	public Date getSlsjf() {
		return slsjf;
	}

	public void setSlsjf(Date slsjf) {
		this.slsjf = slsjf;
	}

	public Date getSlsjt() {
		return slsjt;
	}

	public void setSlsjt(Date slsjt) {
		this.slsjt = slsjt;
	}

	public Integer getWlid() {
		return wlid;
	}

	public void setWlid(Integer wlid) {
		this.wlid = wlid;
	}

	public List getLIcksl() {
		return lIcksl;
	}

	public void setLIcksl(List icksl) {
		lIcksl = icksl;
	}

	public List getLQyryxx() {
		return lQyryxx;
	}

	public void setLQyryxx(List qyryxx) {
		lQyryxx = qyryxx;
	}

	public String getSfjxgarkkbd() {
		return sfjxgarkkbd;
	}

	public void setSfjxgarkkbd(String sfjxgarkkbd) {
		this.sfjxgarkkbd = sfjxgarkkbd;
	}

	public byte[] getTpnr() {
		return tpnr;
	}

	public void setTpnr(byte[] tpnr) {
		this.tpnr = tpnr;
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

	public String getQyidSet() {
		return qyidSet;
	}

	public void setQyidSet(String qyidSet) {
		this.qyidSet = qyidSet;
	}

	public String getZpsftgSet() {
		return zpsftgSet;
	}

	public void setZpsftgSet(String zpsftgSet) {
		this.zpsftgSet = zpsftgSet;
	}

	public String getWtgyySet() {
		return wtgyySet;
	}

	public void setWtgyySet(String wtgyySet) {
		this.wtgyySet = wtgyySet;
	}

	public String getPch() {
		return pch;
	}

	public void setPch(String pch) {
		this.pch = pch;
	}

	public String getSfty() {
		return sfty;
	}

	public void setSfty(String sfty) {
		this.sfty = sfty;
	}

	public String getSssf() {
		return sssf;
	}

	public void setSssf(String sssf) {
		this.sssf = sssf;
	}

	public String getOrderByCjdbm() {
		return orderByCjdbm;
	}

	public void setOrderByCjdbm(String orderByCjdbm) {
		this.orderByCjdbm = orderByCjdbm;
	}

	public String getZkdCyryIck() {
		return zkdCyryIck;
	}

	public void setZkdCyryIck(String zkdCyryIck) {
		this.zkdCyryIck = zkdCyryIck;
	}

	public String getMoreThan3days() {
		return moreThan3days;
	}

	public void setMoreThan3days(String moreThan3days) {
		this.moreThan3days = moreThan3days;
	}

	public String getEjshkg() {
		return ejshkg;
	}

	public void setEjshkg(String ejshkg) {
		this.ejshkg = ejshkg;
	}

	public String getApplyid() {
		return applyid;
	}

	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}

	public String getStringkh() {
		return stringkh;
	}

	public void setStringkh(String stringkh) {
		this.stringkh = stringkh;
	}

	public String getSsdsbm() {
		return ssdsbm;
	}

	public void setSsdsbm(String ssdsbm) {
		this.ssdsbm = ssdsbm;
	}

	public String getSsdsmc() {
		return ssdsmc;
	}

	public void setSsdsmc(String ssdsmc) {
		this.ssdsmc = ssdsmc;
	}

	public String getYfssl() {
		return yfssl;
	}

	public void setYfssl(String yfssl) {
		this.yfssl = yfssl;
	}

	public String getYfksl() {
		return yfksl;
	}

	public void setYfksl(String yfksl) {
		this.yfksl = yfksl;
	}

	public String getYzksl() {
		return yzksl;
	}

	public void setYzksl(String yzksl) {
		this.yzksl = yzksl;
	}

	public String getFksbsl() {
		return fksbsl;
	}

	public void setFksbsl(String fksbsl) {
		this.fksbsl = fksbsl;
	}

	public String getYffsl() {
		return yffsl;
	}

	public void setYffsl(String yffsl) {
		this.yffsl = yffsl;
	}

	public String getSsdsbz() {
		return ssdsbz;
	}

	public void setSsdsbz(String ssdsbz) {
		this.ssdsbz = ssdsbz;
	}

	public String getCjdbz() {
		return cjdbz;
	}

	public void setCjdbz(String cjdbz) {
		this.cjdbz = cjdbz;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getZqsjx() {
		return zqsjx;
	}

	public void setZqsjx(String zqsjx) {
		this.zqsjx = zqsjx;
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

	public String getYshzpsl() {
		return yshzpsl;
	}

	public void setYshzpsl(String yshzpsl) {
		this.yshzpsl = yshzpsl;
	}

	public String getYzbsl() {
		return yzbsl;
	}

	public void setYzbsl(String yzbsl) {
		this.yzbsl = yzbsl;
	}

	public String getYyssl() {
		return yyssl;
	}

	public void setYyssl(String yyssl) {
		this.yyssl = yyssl;
	}

	public String getYdxrsl() {
		return ydxrsl;
	}

	public void setYdxrsl(String ydxrsl) {
		this.ydxrsl = ydxrsl;
	}

	public String getIckwlyfssl() {
		return ickwlyfssl;
	}

	public void setIckwlyfssl(String ickwlyfssl) {
		this.ickwlyfssl = ickwlyfssl;
	}

	public String getIckwlyzbsl() {
		return ickwlyzbsl;
	}

	public void setIckwlyzbsl(String ickwlyzbsl) {
		this.ickwlyzbsl = ickwlyzbsl;
	}

	public String getIckwlyjssl() {
		return ickwlyjssl;
	}

	public void setIckwlyjssl(String ickwlyjssl) {
		this.ickwlyjssl = ickwlyjssl;
	}

	public String getDshzpsl() {
		return dshzpsl;
	}

	public void setDshzpsl(String dshzpsl) {
		this.dshzpsl = dshzpsl;
	}

	public String getDzbsl() {
		return dzbsl;
	}

	public void setDzbsl(String dzbsl) {
		this.dzbsl = dzbsl;
	}

	public String getDyssl() {
		return dyssl;
	}

	public void setDyssl(String dyssl) {
		this.dyssl = dyssl;
	}

	public String getDdxrsl() {
		return ddxrsl;
	}

	public void setDdxrsl(String ddxrsl) {
		this.ddxrsl = ddxrsl;
	}

	public String getYtjcssl() {
		return ytjcssl;
	}

	public void setYtjcssl(String ytjcssl) {
		this.ytjcssl = ytjcssl;
	}

	public String getYtjrysl() {
		return ytjrysl;
	}

	public void setYtjrysl(String ytjrysl) {
		this.ytjrysl = ytjrysl;
	}

	public String getYjswlbsl() {
		return yjswlbsl;
	}

	public void setYjswlbsl(String yjswlbsl) {
		this.yjswlbsl = yjswlbsl;
	}

	public String getYzxicksl() {
		return yzxicksl;
	}

	public void setYzxicksl(String yzxicksl) {
		this.yzxicksl = yzxicksl;
	}

	public String getBhicksl() {
		return bhicksl;
	}

	public void setBhicksl(String bhicksl) {
		this.bhicksl = bhicksl;
	}

	public String getZxbz() {
		return zxbz;
	}

	public void setZxbz(String zxbz) {
		this.zxbz = zxbz;
	}

	public String getYcjcssl() {
		return ycjcssl;
	}

	public void setYcjcssl(String ycjcssl) {
		this.ycjcssl = ycjcssl;
	}

	public String getYcjrysl() {
		return ycjrysl;
	}

	public void setYcjrysl(String ycjrysl) {
		this.ycjrysl = ycjrysl;
	}

	public String getDqzt() {
		return dqzt;
	}

	public void setDqzt(String dqzt) {
		this.dqzt = dqzt;
	}

	public String getAllhylbdm() {
		return allhylbdm;
	}

	public void setAllhylbdm(String allhylbdm) {
		this.allhylbdm = allhylbdm;
	}

	public String getHjlbdm() {
		return hjlbdm;
	}

	public void setHjlbdm(String hjlbdm) {
		this.hjlbdm = hjlbdm;
	}

	public String getHjlbmc() {
		return hjlbmc;
	}

	public void setHjlbmc(String hjlbmc) {
		this.hjlbmc = hjlbmc;
	}

	public Date getXyxqhzrq() {
		return xyxqhzrq;
	}

	public void setXyxqhzrq(Date xyxqhzrq) {
		this.xyxqhzrq = xyxqhzrq;
	}
}
