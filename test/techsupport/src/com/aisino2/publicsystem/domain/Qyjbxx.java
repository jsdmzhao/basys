package com.aisino2.publicsystem.domain;

import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;

public class Qyjbxx  {

	/** @param 企业基本信息(t_qyjbxx) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--40-- */
	private String hylb;

	/** @ --企业编码--qybm--String--20-- */
	private String qybm;

	/** @ --企业名称--qymc--String--120-- */
	private String qymc;

	/** @ --企业全拼--qyqp--String--100-- */
	private String qyqp;

	/** @ --企业简拼--qyjp--String--30-- */
	private String qyjp;

	/** @ --企业主分类编码--qyzflbm--String--30-- */
	private String qyzflbm;

	/** @ --企业主分类名称--qyzflmc--String--300-- */
	private String qyzflmc;

	/** @ --企业副分类编码--qyfflbm--String--200-- */
	private String qyfflbm;

	/** @ --企业副分类名称--qyfflmc--String--300-- */
	private String qyfflmc;

	/** @ --管辖单位代码--gxdwbm--String--20-- */
	private String gxdwbm;

	/** @ --管辖单位名称--gxdwmc--String--60-- */
	private String gxdwmc;

	/** @ --所属地县级公安机关机构代码--ssdxjgajgdm--String--20-- */
	private String ssdxjgajgdm;

	/** @ --所属地县级公安机关名称--ssdxjgajgmc--String--200-- */
	private String ssdxjgajgmc;

	/** @ --所属地地市机构代码--ssddsjgdm--String--20-- */
	private String ssddsjgdm;

	/** @ --所属地地市机构名称--ssddsjgmc--String--200-- */
	private String ssddsjgmc;

	/** @ --企业组织机构代码--qyzzjgdm--String--10-- */
	private String qyzzjgdm;

	/** @ --联系电话--lxdh--String--30-- */
	private String lxdh;

	/** @ --邮政编码--yzbm--String--20-- */
	private String yzbm;

	/** @ --传真--chzh--String--30-- */
	private String chzh;

	/** @ --经纬度坐标--jwdzb--String--100-- */
	private String jwdzb;

	/** @ --经济类型编码--jjlxbm--String--4-- */
	private String jjlxbm;

	/** @ --经济类型名称--jjlxmc--String--60-- */
	private String jjlxmc;

	/** @ --经营范围（主营）--jyfwzy--String--200-- */
	private String jyfwzy;

	/** @ --经营范围（兼营）--jyfwjy--String--200-- */
	private String jyfwjy;

	/** @ --注册资金--zczj--Float--10,2-- */
	private Float zczj;

	/** @ --经营面积--jymj--Float--10,2-- */
	private Float jymj;

	/** @ --治安级别代码--zabdm--String--4-- */
	private String zabdm;

	/** @ --治安级别名称--zajbmc--String--20-- */
	private String zajbmc;

	/** @ --营业状态代码--yyztdm--String--2-- */
	private String yyztdm;

	/** @ --营业状态名称--yyztmc--String--20-- */
	private String yyztmc;

	/** @ --装机状态名称--zjztdm--String--2-- */
	private String zjztdm;

	/** @ --装机状态名称--zjztmc--String--20-- */
	private String zjztmc;

	/** @ --法人代表姓名--frdb--String--30-- */
	private String frdb;

	/** @ --法人代表证件类别--frdbzjlb--String--40-- */
	private String frdbzjlb;

	/** @ --法人代表证件号码--frdbzjhm--String--30-- */
	private String frdbzjhm;

	/** @ --法人代表联系方式--frdblxfs--String--30-- */
	private String frdblxfs;

	/** @ --开业日期--kyrq--Date---- */
	private Date kyrq;

	/** @ --营业时间--yysj--String--20-- */
	private String yysj;

	/** @ --备案编号--babh--String--30-- */
	private String babh;

	/** @ --备案日期--barq--Date---- */
	private Date barq;

	/** @ --停业日期--tyrq--Date---- */
	private Date tyrq;

	/** @ --经营方式--jyfs--String--20-- */
	private String jyfs;

	/** @ --经营地址--jydz--String--200-- */
	private String jydz;

	/** @ --单位负责人证件类别--dwfzrzjlb--String--40-- */
	private String dwfzrzjlb;

	/** @ --单位负责人证件号码--dwfzrzjhm--String--30-- */
	private String dwfzrzjhm;

	/** @ --单位负责人姓名--dwfzr--String--30-- */
	private String dwfzr;

	/** @ --单位负责人联系方式--dwfzrlxfs--String--30-- */
	private String dwfzrlxfs;

	/** @ --消防审核单位--xfshdw--String--200-- */
	private String xfshdw;

	/** @ --消防合格证号--xfhgzh--String--20-- */
	private String xfhgzh;

	/** @ --核查单位--hcdw--String--100-- */
	private String hcdw;

	/** @ --核查人--hcr--String--30-- */
	private String hcr;

	/** @ --核查时间--hcsj--Date---- */
	private Date hcsj;

	/** @ --股东信息--gdxx--String--2000-- */
	private String gdxx;

	/** @ --总人数--zrs--Integer--6-- */
	private Integer zrs;

	/** @ --核定人数--hdrs--Integer--6-- */
	private Integer hdrs;

	/** @ --保安公司名称--bagsmc--String--60-- */
	private String bagsmc;

	/** @ --保安负责人公民身份号码--bafzrgmsfhm--String--20-- */
	private String bafzrgmsfhm;

	/** @ --保安负责人姓名--bafzrxm--String--30-- */
	private String bafzrxm;

	/** @ --保安负责人电话--bafzrdh--String--30-- */
	private String bafzrdh;

	/** @ --保安人数--bars--Integer--6-- */
	private Integer bars;

	/** @ --经岗位培训人数--jgpxrs--Integer--6-- */
	private Integer jgpxrs;

	/** @ --保安公司意见--bagsyj--String--2000-- */
	private String bagsyj;

	/** @ --出口数量--cksl--Integer--6-- */
	private Integer cksl;

	/** @ --包厢包间数量--bxbjsl--Integer--6-- */
	private Integer bxbjsl;

	/** @ --备注--bz--String--2000-- */
	private String bz;

	/** @ --导出标识--dcbs--Integer--2-- */
	private Integer dcbs;

	/** @ --导出时间--dcsj--Date---- */
	private Date dcsj;

	/** @ --状态--zt--String--10-- */
	private String zt;

	/** @ --状态改变日期--ztgbrq--Date---- */
	private Date ztgbrq;

	/** @ --删除标志--scbz--Integer--2-- */
	private Integer scbz;

	/** @ --机器编码--jqbm--String--10-- */
	private String jqbm;

	/** @ --注销标志--zxbz--String--2-- */
	private String zxbz;

	/** @ --注销原因--zxyy--String--200-- */
	private String zxyy;

	/** @ --最低刷卡比--zdskb--Float--5,2-- */
	private Float zdskb;

	/** @ --保存时间--bcsj--Date---- */
	private Date bcsj;

	/** @ --录入时间--lrsj--Date---- */
	private Date lrsj;

	/** @ --录入人--lrr--String--100-- */
	private String lrr;

	/** @ --录入单位编码--lrdwbm--String--20-- */
	private String lrdwbm;

	/** @ --录入单位名称--lrdwmc--String--60-- */
	private String lrdwmc;

	/** @ --年审日期--nsrq--Date-- */
	private Date nsrq;
	
	private String query_simplepin;
	/** 分页排序 */
	private String pageSort;
	
	private List qybgxxList;
	
	/** 证件表 */
	private List lQyzjbList;
	/** 企业副分类 */
	private List lQyfflList;
	/** 外国投资人 */
	private List lWgtzrxxList;
	/** 保安服务合同 */
	private List lBafwhtList;
	/** 闭路电视监控设备 */
	private List lBldsjksbList;
	/** 安全检查设备 */
	private List lAqjcsbList;
	/** 平面图 */
	private List lPmtList;
	/** 保安人员 */
	private List lBaryxxList;
	/** 保卫人员 */
	private List lBwryxxList;
	
	/** @ --状态名称-- */
	private String ztmc;
	/** @ --证件编号-- */
	private String zjbh;
	/** @ --操作类型-- */
	private String czlx;
	/** @ --操作人-- */
	private String czr;
	/** @ --变更登记序号-- */
	private String bgdjxh;
	/** @ --变更原因-- */
	private String bgyy;
	/** @ --变更类别代码-- */
	private String bglbdm;
	/** @ --变更类别-- */
	private String bglb;
	/** 是否点击过第二个页签 包含：保安服务合同、平面图、闭路电视、安全检查设备 0-页签未点击 1-页签已点击*/
	private String activePageTwo;
	/** 是否点击过第三个页签 包含：外国投资人  0-页签未点击 1-页签已点击*/
	private String activePageThree;
	/** 比较运算符 1-大于等于，2-小于等于，3-等于，4-大于，5-小于 */
	private String relation;
	/** 备案日期标识 */
	private String isBarqNull;
	/** 停业日期标识 */
	private String isTyrqNull;
	/** 二级审核是否通过  0-不通过 1-通过*/
	private String sftg;
	/** 停业日期标识 */
	private Qysh qysh;
	/** 保存至时间 非数据库字段 */
	private Date bcsjt;
	
	/** 登记日期 起始日期 非数据库字段 */
	private Date djrq;
	private Date djrqf;
	/** 登记日期 截止日期 非数据库字段 */
	private Date djrqt;
	private String sfyx;
	private String sfhc;
	
	private String bwbmdh; //保安部门电话
	private String thbajgdm; //特行备案机构代码
	private String thbajg; //特行备案机构
	private String sfazsxt; //是否安装摄像头
	private String azsxtsl; //安装摄像头数量
	
	private String flagTj;//娱乐场所查询统计中用到的（原于江苏公安端统计）;
	
	private String ymgn;//页面功能，用于根据不同的功能查询不同的企业 目前用到的：ickff-IC卡发放
	private String allhylbdm;
	private String applyid;//大河webservice每条记录的唯一标示符
	private Integer barysl; // 保安人员数量
	private Integer bwrysl; // 保卫人员数量
	private Integer sxtsl; // 摄像头数量
	private Integer jfsbsl; // 技防设备数量
	
	private String qyjc;
	private String qyjcqp;
	private String qyjcjp;
	
	private String sgscxfjjs;
	private String jhltlxdm;
	private String jhltlxmc;
	
	private String dwfzrcyrybh;
	
	private String webserviceFlag;//webservice调用service的标示
	
	public String getWebserviceFlag() {
		return webserviceFlag;
	}

	public void setWebserviceFlag(String webserviceFlag) {
		this.webserviceFlag = webserviceFlag;
	}

	public String getApplyid() {
		return applyid;
	}

	public void setApplyid(String applyid) {
		this.applyid = applyid;
	}

	public List getLBwryxxList() {
		return lBwryxxList;
	}

	public void setLBwryxxList(List bwryxxList) {
		lBwryxxList = bwryxxList;
	}

	public Date getNsrq() {
		return nsrq;
	}

	public void setNsrq(Date nsrq) {
		this.nsrq = nsrq;
	}

	public Date getBcsjt() {
		return bcsjt;
	}

	public void setBcsjt(Date bcsjt) {
		this.bcsjt = bcsjt;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
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

	/** @ 企业全拼(qyqp) */
	public String getQyqp() {
		return qyqp;
	}

	public void setQyqp(String qyqp) {
		this.qyqp = qyqp;
	}

	/** @ 企业简拼(qyjp) */
	public String getQyjp() {
		return qyjp;
	}

	public void setQyjp(String qyjp) {
		this.qyjp = qyjp;
	}

	/** @ 企业主分类编码(qyzflbm) */
	public String getQyzflbm() {
		return qyzflbm;
	}

	public void setQyzflbm(String qyzflbm) {
		this.qyzflbm = qyzflbm;
	}

	/** @ 企业主分类名称(qyzflmc) */
	public String getQyzflmc() {
		return qyzflmc;
	}

	public void setQyzflmc(String qyzflmc) {
		this.qyzflmc = qyzflmc;
	}

	/** @ 企业副分类编码(qyfflbm) */
	public String getQyfflbm() {
		return qyfflbm;
	}

	public void setQyfflbm(String qyfflbm) {
		this.qyfflbm = qyfflbm;
	}

	/** @ 企业副分类名称(qyfflmc) */
	public String getQyfflmc() {
		return qyfflmc;
	}

	public void setQyfflmc(String qyfflmc) {
		this.qyfflmc = qyfflmc;
	}

	/** @ 管辖单位代码(gxdwbm) */
	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}

	/** @ 管辖单位名称(gxdwmc) */
	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	/** @ 所属地县级公安机关机构代码(ssdxjgajgdm) */
	public String getSsdxjgajgdm() {
		return ssdxjgajgdm;
	}

	public void setSsdxjgajgdm(String ssdxjgajgdm) {
		this.ssdxjgajgdm = ssdxjgajgdm;
	}

	/** @ 所属地县级公安机关名称(ssdxjgajgmc) */
	public String getSsdxjgajgmc() {
		return ssdxjgajgmc;
	}

	public void setSsdxjgajgmc(String ssdxjgajgmc) {
		this.ssdxjgajgmc = ssdxjgajgmc;
	}

	/** @ 所属地派出所机构代码(ssddsjgdm) */
	public String getSsddsjgdm() {
		return ssddsjgdm;
	}

	public void setSsddsjgdm(String ssddsjgdm) {
		this.ssddsjgdm = ssddsjgdm;
	}

	/** @ 所属地派出所机构名称(ssddsjgmc) */
	public String getSsddsjgmc() {
		return ssddsjgmc;
	}

	public void setSsddsjgmc(String ssddsjgmc) {
		this.ssddsjgmc = ssddsjgmc;
	}

	/** @ 企业组织机构代码(qyzzjgdm) */
	public String getQyzzjgdm() {
		return qyzzjgdm;
	}

	public void setQyzzjgdm(String qyzzjgdm) {
		this.qyzzjgdm = qyzzjgdm;
	}

	/** @ 联系电话(lxdh) */
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	/** @ 邮政编码(yzbm) */
	public String getYzbm() {
		return yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	/** @ 传真(chzh) */
	public String getChzh() {
		return chzh;
	}

	public void setChzh(String chzh) {
		this.chzh = chzh;
	}

	/** @ 经纬度坐标(jwdzb) */
	public String getJwdzb() {
		return jwdzb;
	}

	public void setJwdzb(String jwdzb) {
		this.jwdzb = jwdzb;
	}

	/** @ 经济类型编码(jjlxbm) */
	public String getJjlxbm() {
		return jjlxbm;
	}

	public void setJjlxbm(String jjlxbm) {
		this.jjlxbm = jjlxbm;
	}

	/** @ 经济类型名称(jjlxmc) */
	public String getJjlxmc() {
		return jjlxmc;
	}

	public void setJjlxmc(String jjlxmc) {
		this.jjlxmc = jjlxmc;
	}

	/** @ 经营范围（主营）(jyfwzy) */
	public String getJyfwzy() {
		return jyfwzy;
	}

	public void setJyfwzy(String jyfwzy) {
		this.jyfwzy = jyfwzy;
	}

	/** @ 经营范围（兼营）(jyfwjy) */
	public String getJyfwjy() {
		return jyfwjy;
	}

	public void setJyfwjy(String jyfwjy) {
		this.jyfwjy = jyfwjy;
	}

	/** @ 注册资金(zczj) */
	public Float getZczj() {
		return zczj;
	}

	public void setZczj(Float zczj) {
		this.zczj = zczj;
	}

	/** @ 经营面积(jymj) */
	public Float getJymj() {
		return jymj;
	}

	public void setJymj(Float jymj) {
		this.jymj = jymj;
	}

	/** @ 治安级别代码(zabdm) */
	public String getZabdm() {
		return zabdm;
	}

	public void setZabdm(String zabdm) {
		this.zabdm = zabdm;
	}

	/** @ 治安级别名称(zajbmc) */
	public String getZajbmc() {
		return zajbmc;
	}

	public void setZajbmc(String zajbmc) {
		this.zajbmc = zajbmc;
	}

	/** @ 营业状态代码(yyztdm) */
	public String getYyztdm() {
		return yyztdm;
	}

	public void setYyztdm(String yyztdm) {
		this.yyztdm = yyztdm;
	}

	/** @ 营业状态名称(yyztmc) */
	public String getYyztmc() {
		return yyztmc;
	}

	public void setYyztmc(String yyztmc) {
		this.yyztmc = yyztmc;
	}

	public String getZjztdm() {
		return zjztdm;
	}

	public void setZjztdm(String zjztdm) {
		this.zjztdm = zjztdm;
	}

	public String getZjztmc() {
		return zjztmc;
	}

	public void setZjztmc(String zjztmc) {
		this.zjztmc = zjztmc;
	}

	/** @ 法人代表姓名(frdb) */
	public String getFrdb() {
		return frdb;
	}

	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}

	/** @ 法人代表证件类别(frdbzjlb) */
	public String getFrdbzjlb() {
		return frdbzjlb;
	}

	public void setFrdbzjlb(String frdbzjlb) {
		this.frdbzjlb = frdbzjlb;
	}

	/** @ 法人代表证件号码(frdbzjhm) */
	public String getFrdbzjhm() {
		return frdbzjhm;
	}

	public void setFrdbzjhm(String frdbzjhm) {
		this.frdbzjhm = frdbzjhm;
	}

	/** @ 法人代表联系方式(frdblxfs) */
	public String getFrdblxfs() {
		return frdblxfs;
	}

	public void setFrdblxfs(String frdblxfs) {
		this.frdblxfs = frdblxfs;
	}

	/** @ 开业日期(kyrq) */
	public Date getKyrq() {
		return kyrq;
	}

	public void setKyrq(Date kyrq) {
		this.kyrq = kyrq;
	}

	/** @ 营业时间(yysj) */
	public String getYysj() {
		return yysj;
	}

	public void setYysj(String yysj) {
		this.yysj = yysj;
	}

	/** @ 备案编号(babh) */
	public String getBabh() {
		return babh;
	}

	public void setBabh(String babh) {
		this.babh = babh;
	}

	/** @ 备案日期(barq) */
	public Date getBarq() {
		return barq;
	}

	public void setBarq(Date barq) {
		this.barq = barq;
	}

	/** @ 停业日期(tyrq) */
	public Date getTyrq() {
		return tyrq;
	}

	public void setTyrq(Date tyrq) {
		this.tyrq = tyrq;
	}

	/** @ 经营方式(jyfs) */
	public String getJyfs() {
		return jyfs;
	}

	public void setJyfs(String jyfs) {
		this.jyfs = jyfs;
	}

	/** @ 经营地址(jydz) */
	public String getJydz() {
		return jydz;
	}

	public void setJydz(String jydz) {
		this.jydz = jydz;
	}

	/** @ 单位负责人证件类别(dwfzrzjlb) */
	public String getDwfzrzjlb() {
		return dwfzrzjlb;
	}

	public void setDwfzrzjlb(String dwfzrzjlb) {
		this.dwfzrzjlb = dwfzrzjlb;
	}

	/** @ 单位负责人证件号码(dwfzrzjhm) */
	public String getDwfzrzjhm() {
		return dwfzrzjhm;
	}

	public void setDwfzrzjhm(String dwfzrzjhm) {
		this.dwfzrzjhm = dwfzrzjhm;
	}

	/** @ 单位负责人姓名(dwfzr) */
	public String getDwfzr() {
		return dwfzr;
	}

	public void setDwfzr(String dwfzr) {
		this.dwfzr = dwfzr;
	}

	/** @ 单位负责人联系方式(dwfzrlxfs) */
	public String getDwfzrlxfs() {
		return dwfzrlxfs;
	}

	public void setDwfzrlxfs(String dwfzrlxfs) {
		this.dwfzrlxfs = dwfzrlxfs;
	}

	/** @ 消防审核单位(xfshdw) */
	public String getXfshdw() {
		return xfshdw;
	}

	public void setXfshdw(String xfshdw) {
		this.xfshdw = xfshdw;
	}

	/** @ 消防合格证号(xfhgzh) */
	public String getXfhgzh() {
		return xfhgzh;
	}

	public void setXfhgzh(String xfhgzh) {
		this.xfhgzh = xfhgzh;
	}

	/** @ 核查单位(hcdw) */
	public String getHcdw() {
		return hcdw;
	}

	public void setHcdw(String hcdw) {
		this.hcdw = hcdw;
	}

	/** @ 核查人(hcr) */
	public String getHcr() {
		return hcr;
	}

	public void setHcr(String hcr) {
		this.hcr = hcr;
	}

	/** @ 核查时间(hcsj) */
	public Date getHcsj() {
		return hcsj;
	}

	public void setHcsj(Date hcsj) {
		this.hcsj = hcsj;
	}

	/** @ 股东信息(gdxx) */
	public String getGdxx() {
		return gdxx;
	}

	public void setGdxx(String gdxx) {
		this.gdxx = gdxx;
	}

	/** @ 总人数(zrs) */
	public Integer getZrs() {
		return zrs;
	}

	public void setZrs(Integer zrs) {
		this.zrs = zrs;
	}

	/** @ 核定人数(hdrs) */
	public Integer getHdrs() {
		return hdrs;
	}

	public void setHdrs(Integer hdrs) {
		this.hdrs = hdrs;
	}

	/** @ 保安公司名称(bagsmc) */
	public String getBagsmc() {
		return bagsmc;
	}

	public void setBagsmc(String bagsmc) {
		this.bagsmc = bagsmc;
	}

	/** @ 保安负责人公民身份号码(bafzrgmsfhm) */
	public String getBafzrgmsfhm() {
		return bafzrgmsfhm;
	}

	public void setBafzrgmsfhm(String bafzrgmsfhm) {
		this.bafzrgmsfhm = bafzrgmsfhm;
	}

	/** @ 保安负责人姓名(bafzrxm) */
	public String getBafzrxm() {
		return bafzrxm;
	}

	public void setBafzrxm(String bafzrxm) {
		this.bafzrxm = bafzrxm;
	}

	/** @ 保安负责人电话(bafzrdh) */
	public String getBafzrdh() {
		return bafzrdh;
	}

	public void setBafzrdh(String bafzrdh) {
		this.bafzrdh = bafzrdh;
	}

	/** @ 保安人数(bars) */
	public Integer getBars() {
		return bars;
	}

	public void setBars(Integer bars) {
		this.bars = bars;
	}

	/** @ 经岗位培训人数(jgpxrs) */
	public Integer getJgpxrs() {
		return jgpxrs;
	}

	public void setJgpxrs(Integer jgpxrs) {
		this.jgpxrs = jgpxrs;
	}

	/** @ 保安公司意见(bagsyj) */
	public String getBagsyj() {
		return bagsyj;
	}

	public void setBagsyj(String bagsyj) {
		this.bagsyj = bagsyj;
	}

	/** @ 出口数量(cksl) */
	public Integer getCksl() {
		return cksl;
	}

	public void setCksl(Integer cksl) {
		this.cksl = cksl;
	}

	/** @ 包厢包间数量(bxbjsl) */
	public Integer getBxbjsl() {
		return bxbjsl;
	}

	public void setBxbjsl(Integer bxbjsl) {
		this.bxbjsl = bxbjsl;
	}

	/** @ 备注(bz) */
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	/** @ 导出标识(dcbs) */
	public Integer getDcbs() {
		return dcbs;
	}

	public void setDcbs(Integer dcbs) {
		this.dcbs = dcbs;
	}

	/** @ 导出时间(dcsj) */
	public Date getDcsj() {
		return dcsj;
	}

	public void setDcsj(Date dcsj) {
		this.dcsj = dcsj;
	}

	/** @ 状态(zt) */
	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	/** @ 状态改变日期(ztgbrq) */
	public Date getZtgbrq() {
		return ztgbrq;
	}

	public void setZtgbrq(Date ztgbrq) {
		this.ztgbrq = ztgbrq;
	}

	/** @ 删除标志(scbz) */
	public Integer getScbz() {
		return scbz;
	}

	public void setScbz(Integer scbz) {
		this.scbz = scbz;
	}

	/** @ 机器编码(jqbm) */
	public String getJqbm() {
		return jqbm;
	}

	public void setJqbm(String jqbm) {
		this.jqbm = jqbm;
	}

	/** @ 注销标志(zxbz) */
	public String getZxbz() {
		return zxbz;
	}

	public void setZxbz(String zxbz) {
		this.zxbz = zxbz;
	}

	/** @ 注销原因(zxyy) */
	public String getZxyy() {
		return zxyy;
	}

	public void setZxyy(String zxyy) {
		this.zxyy = zxyy;
	}

	/** @ 最低刷卡比(zdskb) */
	public Float getZdskb() {
		return zdskb;
	}

	public void setZdskb(Float zdskb) {
		this.zdskb = zdskb;
	}

	/** @ 保存时间(bcsj) */
	public Date getBcsj() {
		return bcsj;
	}

	public void setBcsj(Date bcsj) {
		this.bcsj = bcsj;
	}

	/** @ 录入时间(lrsj) */
	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	/** @ 录入人(lrr) */
	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	/** @ 录入单位编码(lrdwbm) */
	public String getLrdwbm() {
		return lrdwbm;
	}

	public void setLrdwbm(String lrdwbm) {
		this.lrdwbm = lrdwbm;
	}

	/** @ 录入单位名称(lrdwmc) */
	public String getLrdwmc() {
		return lrdwmc;
	}

	public void setLrdwmc(String lrdwmc) {
		this.lrdwmc = lrdwmc;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public List getLQyzjbList() {
		return lQyzjbList;
	}

	public void setLQyzjbList(List qyzjbList) {
		lQyzjbList = qyzjbList;
	}

	public List getLQyfflList() {
		return lQyfflList;
	}

	public void setLQyfflList(List qyfflList) {
		lQyfflList = qyfflList;
	}

	public List getLWgtzrxxList() {
		return lWgtzrxxList;
	}

	public void setLWgtzrxxList(List wgtzrxxList) {
		lWgtzrxxList = wgtzrxxList;
	}

	public List getLBafwhtList() {
		return lBafwhtList;
	}

	public void setLBafwhtList(List bafwhtList) {
		lBafwhtList = bafwhtList;
	}

	public List getLBldsjksbList() {
		return lBldsjksbList;
	}

	public void setLBldsjksbList(List bldsjksbList) {
		lBldsjksbList = bldsjksbList;
	}

	public List getLAqjcsbList() {
		return lAqjcsbList;
	}

	public void setLAqjcsbList(List aqjcsbList) {
		lAqjcsbList = aqjcsbList;
	}

	public List getLPmtList() {
		return lPmtList;
	}

	public void setLPmtList(List pmtList) {
		lPmtList = pmtList;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public String getZjbh() {
		return zjbh;
	}

	public void setZjbh(String zjbh) {
		this.zjbh = zjbh;
	}

	public String getCzlx() {
		return czlx;
	}

	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}

	public String getBgyy() {
		return bgyy;
	}

	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}

	public String getActivePageTwo() {
		return activePageTwo;
	}

	public void setActivePageTwo(String activePageTwo) {
		this.activePageTwo = activePageTwo;
	}

	public String getActivePageThree() {
		return activePageThree;
	}

	public void setActivePageThree(String activePageThree) {
		this.activePageThree = activePageThree;
	}

	public String getCzr() {
		return czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public String getBglbdm() {
		return bglbdm;
	}

	public void setBglbdm(String bglbdm) {
		this.bglbdm = bglbdm;
	}

	public String getBglb() {
		return bglb;
	}

	public void setBglb(String bglb) {
		this.bglb = bglb;
	}

	public String getBgdjxh() {
		return bgdjxh;
	}

	public void setBgdjxh(String bgdjxh) {
		this.bgdjxh = bgdjxh;
	}

	public String getQuery_simplepin() {
		return query_simplepin;
	}

	public void setQuery_simplepin(String query_simplepin) {
		this.query_simplepin = query_simplepin;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getIsBarqNull() {
		return isBarqNull;
	}

	public void setIsBarqNull(String isBarqNull) {
		this.isBarqNull = isBarqNull;
	}

	public String getIsTyrqNull() {
		return isTyrqNull;
	}

	public void setIsTyrqNull(String isTyrqNull) {
		this.isTyrqNull = isTyrqNull;
	}

	public String getSftg() {
		return sftg;
	}

	public void setSftg(String sftg) {
		this.sftg = sftg;
	}

	public Qysh getQysh() {
		return qysh;
	}

	public void setQysh(Qysh qysh) {
		this.qysh = qysh;
	}

	public Date getDjrqf() {
		return djrqf;
	}

	public void setDjrqf(Date djrqf) {
		this.djrqf = djrqf;
	}

	public Date getDjrqt() {
		return djrqt;
	}

	public void setDjrqt(Date djrqt) {
		this.djrqt = djrqt;
	}

	public List getQybgxxList() {
		return qybgxxList;
	}

	public void setQybgxxList(List qybgxxList) {
		this.qybgxxList = qybgxxList;
	}

	public String getBwbmdh() {
		return bwbmdh;
	}

	public void setBwbmdh(String bwbmdh) {
		this.bwbmdh = bwbmdh;
	}

	public String getThbajgdm() {
		return thbajgdm;
	}

	public void setThbajgdm(String thbajgdm) {
		this.thbajgdm = thbajgdm;
	}

	public String getThbajg() {
		return thbajg;
	}

	public void setThbajg(String thbajg) {
		this.thbajg = thbajg;
	}

	public String getSfazsxt() {
		return sfazsxt;
	}

	public void setSfazsxt(String sfazsxt) {
		this.sfazsxt = sfazsxt;
	}

	public String getAzsxtsl() {
		return azsxtsl;
	}

	public void setAzsxtsl(String azsxtsl) {
		this.azsxtsl = azsxtsl;
	}

	public String getFlagTj() {
		return flagTj;
	}

	public void setFlagTj(String flagTj) {
		this.flagTj = flagTj;
	}

	public String getSfyx() {
		return sfyx;
	}

	public void setSfyx(String sfyx) {
		this.sfyx = sfyx;
	}
	
	public String getSfhc() {
		return sfhc;
	}

	public void setSfhc(String sfhc) {
		this.sfhc = sfhc;
	}

	public String getYmgn() {
		return ymgn;
	}

	public void setYmgn(String ymgn) {
		this.ymgn = ymgn;
	}

	public Date getDjrq() {
		return djrq;
	}

	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}

	public String getAllhylbdm() {
		return allhylbdm;
	}

	public void setAllhylbdm(String allhylbdm) {
		this.allhylbdm = allhylbdm;
	}

	public List getLBaryxxList() {
		return lBaryxxList;
	}

	public void setLBaryxxList(List baryxxList) {
		lBaryxxList = baryxxList;
	}

	public Integer getBarysl() {
		return barysl;
	}

	public void setBarysl(Integer barysl) {
		this.barysl = barysl;
	}

	public Integer getBwrysl() {
		return bwrysl;
	}

	public void setBwrysl(Integer bwrysl) {
		this.bwrysl = bwrysl;
	}

	public Integer getSxtsl() {
		return sxtsl;
	}

	public void setSxtsl(Integer sxtsl) {
		this.sxtsl = sxtsl;
	}

	public Integer getJfsbsl() {
		return jfsbsl;
	}

	public void setJfsbsl(Integer jfsbsl) {
		this.jfsbsl = jfsbsl;
	}

	public String getQyjc() {
		return qyjc;
	}

	public void setQyjc(String qyjc) {
		this.qyjc = qyjc;
	}

	public String getQyjcqp() {
		return qyjcqp;
	}

	public void setQyjcqp(String qyjcqp) {
		this.qyjcqp = qyjcqp;
	}

	public String getQyjcjp() {
		return qyjcjp;
	}

	public void setQyjcjp(String qyjcjp) {
		this.qyjcjp = qyjcjp;
	}

	public String getSgscxfjjs() {
		return sgscxfjjs;
	}

	public void setSgscxfjjs(String sgscxfjjs) {
		this.sgscxfjjs = sgscxfjjs;
	}

	public String getJhltlxdm() {
		return jhltlxdm;
	}

	public void setJhltlxdm(String jhltlxdm) {
		this.jhltlxdm = jhltlxdm;
	}

	public String getJhltlxmc() {
		return jhltlxmc;
	}

	public void setJhltlxmc(String jhltlxmc) {
		this.jhltlxmc = jhltlxmc;
	}

	public String getDwfzrcyrybh() {
		return dwfzrcyrybh;
	}

	public void setDwfzrcyrybh(String dwfzrcyrybh) {
		this.dwfzrcyrybh = dwfzrcyrybh;
	}
	
}
