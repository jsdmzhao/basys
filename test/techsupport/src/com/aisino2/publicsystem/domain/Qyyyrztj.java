package com.aisino2.publicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Qyyyrztj  {

	/** @param 企业营业日志统计(t_qyyyrztj) */

	/** @ --企业ID--qyid--Integer--10-- */
	private Integer qyid;

	/** @ --营业日志ID--yyrzid--Integer--10-- */
	private Integer yyrzid;

	/** @ --营业日志统计ID--yyrztjid--Integer--10-- */
	private Integer yyrztjid;

	/** @ --日期--riqi--Date---- */
	private Date riqi;

	/** @ --开始营业时间--ksyysj--Date---- */
	private Date ksyysj;

	/** @ --结束营业时间--jsyysj--Date---- */
	private Date jsyysj;

	/** @ --场所负责人编号--csfzrbh--String--20-- */
	private String csfzrbh;

	/** @ --场所负责人姓名--csfe--String--30-- */
	private String csfe;

	/** @ --治安负责人编号--zafzrbh--String--20-- */
	private String zafzrbh;

	/** @ --治安负责人姓名--zafzrxm--String--30-- */
	private String zafzrxm;

	/** @ --是否有治安、刑事案件或事故发生--sffsaj--String--1-- */
	private String sffsaj;

	/** @ --是否有管理部门检查--sfglbmjc--String--1-- */
	private String sfglbmjc;

	/** @ --当日营业状况--dryysj--String--2000-- */
	private String dryysj;

	/** @ --行业类别代码--hylbdm--String--3-- */
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

	/** @ --经营范围（主营）--jyfwzy--String--2000-- */
	private String jyfwzy;

	/** @ --经营范围（兼营）--jyfwjy--String--2000-- */
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

	/** 分页排序 */
	private String pageSort;
	
	
	
	
	//工作日志统计变量
	/** @ 姓名(xm) */
	private String xm="";
	
	/** @ 姓名拼音(xmpy) */
	private String xmpy="";
	
	/** @ 从业人员编号(cyrybh) */
	private String cyrybh="";
	
	/** @ 外国人就业许可证(wgrjyxkz) */
	private String wgrjyxkz="";
	/** @ 英文名(ywm) */
	private String ywm="";
	/** @ 证件号码(zjhm) */
	private String zjhm="";
	/** @ 刷卡时间(sksj) */
	private Date sksj;
	/** @ 所属企业编码(ssqybm) */
	private String ssqybm;
	/** @ 所属企业名称(ssqymc) */
	private String ssqymc;
	/** @ 本企业从业人员编码(bqycyrybh) */
	private String bqycyrybh;
	
	/** @ 本企业从业人员名称(bqycyryxm) */
	private String bqycyryxm;
	
	/** @ 出入企业从业人员编码(crqycyrybh) */
	private String crqycyrybh;
	
	/** @ 出入企业从业人员名称(crqycyryxm) */
	private String crqycyryxm;

	/** @ 总行数(allRow) */
	private Integer allRow;
	
	/** @ 开始行(beginRow) */
	private Integer beginRow;
	
	/** @ 结束行(beginRow) */
	private Integer endRow;
	
	private String sort;//排序的字段
	
	private String dir;//排序方式
	
	//该类已用于工作日志统计
	
	//营业日志统计新增字段
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

	/** @ --地市机关 标志 非数据库字段 */
	private String dsjgbz;

	/** @ --分县局代码 标志 非数据库字段 */
	private String fxjbz;

	/** @ --管辖单位代码 标志 非数据库字段 */
	private String gxdwbz;
	
	/** @ --统计日期 非数据库字段 */
	private Date tjrq;
	
	private Integer qyzs;
	private Integer sccss;
	private Integer wsccss;
	private Integer cyrys;
	private Integer sbrs;
	private Integer xzrys;
	private Integer lzrys;
	private Date qsrq;
	private Date jzrq;
	private String mxlj;
	
	
	
	private Integer cyryzs;
	private Integer dtsbrs;
	private Integer dtxzrys;
	private Integer dtlzrs;
	
	public Integer getCyryzs() {
		return cyryzs;
	}

	public void setCyryzs(Integer cyryzs) {
		this.cyryzs = cyryzs;
	}

	public Integer getDtsbrs() {
		return dtsbrs;
	}

	public void setDtsbrs(Integer dtsbrs) {
		this.dtsbrs = dtsbrs;
	}

	public Integer getDtxzrys() {
		return dtxzrys;
	}

	public void setDtxzrys(Integer dtxzrys) {
		this.dtxzrys = dtxzrys;
	}

	public Integer getDtlzrs() {
		return dtlzrs;
	}

	public void setDtlzrs(Integer dtlzrs) {
		this.dtlzrs = dtlzrs;
	}

	private String tjrqString;
	
	public String getTjrqString() {
		return tjrqString;
	}

	public void setTjrqString(String tjrqString) {
		this.tjrqString = tjrqString;
	}

	public String getMxlj() {
		return mxlj;
	}

	public void setMxlj(String mxlj) {
		this.mxlj = mxlj;
	}

	public Date getQsrq() {
		return qsrq;
	}

	public void setQsrq(Date qsrq) {
		this.qsrq = qsrq;
	}

	public Date getJzrq() {
		return jzrq;
	}

	public void setJzrq(Date jzrq) {
		this.jzrq = jzrq;
	}

	public Integer getQyzs() {
		return qyzs;
	}

	public void setQyzs(Integer qyzs) {
		this.qyzs = qyzs;
	}

	public Integer getSccss() {
		return sccss;
	}

	public void setSccss(Integer sccss) {
		this.sccss = sccss;
	}

	public Integer getWsccss() {
		return wsccss;
	}

	public void setWsccss(Integer wsccss) {
		this.wsccss = wsccss;
	}

	public Integer getCyrys() {
		return cyrys;
	}

	public void setCyrys(Integer cyrys) {
		this.cyrys = cyrys;
	}

	public Integer getSbrs() {
		return sbrs;
	}

	public void setSbrs(Integer sbrs) {
		this.sbrs = sbrs;
	}

	public Integer getXzrys() {
		return xzrys;
	}

	public void setXzrys(Integer xzrys) {
		this.xzrys = xzrys;
	}

	public Integer getLzrys() {
		return lzrys;
	}

	public void setLzrys(Integer lzrys) {
		this.lzrys = lzrys;
	}

	public String getDsjgdm() {
		return dsjgdm;
	}

	public void setDsjgdm(String dsjgdm) {
		this.dsjgdm = dsjgdm;
	}

	public String getDsjgmc() {
		return dsjgmc;
	}

	public void setDsjgmc(String dsjgmc) {
		this.dsjgmc = dsjgmc;
	}

	public String getFxjdm() {
		return fxjdm;
	}

	public void setFxjdm(String fxjdm) {
		this.fxjdm = fxjdm;
	}

	public String getFxjmc() {
		return fxjmc;
	}

	public void setFxjmc(String fxjmc) {
		this.fxjmc = fxjmc;
	}

	public String getGxdwdm() {
		return gxdwdm;
	}

	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
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

	public Date getTjrq() {
		return tjrq;
	}

	public void setTjrq(Date tjrq) {
		this.tjrq = tjrq;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	/** @ 企业ID(qyid) */
	public Integer getQyid() {
		return qyid;
	}

	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}

	/** @ 营业日志ID(yyrzid) */
	public Integer getYyrzid() {
		return yyrzid;
	}

	public void setYyrzid(Integer yyrzid) {
		this.yyrzid = yyrzid;
	}

	/** @ 营业日志统计ID(yyrztjid) */
	public Integer getYyrztjid() {
		return yyrztjid;
	}

	public void setYyrztjid(Integer yyrztjid) {
		this.yyrztjid = yyrztjid;
	}

	/** @ 日期(riqi) */
	public Date getRiqi() {
		return riqi;
	}

	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}

	/** @ 开始营业时间(ksyysj) */
	public Date getKsyysj() {
		return ksyysj;
	}

	public void setKsyysj(Date ksyysj) {
		this.ksyysj = ksyysj;
	}

	/** @ 结束营业时间(jsyysj) */
	public Date getJsyysj() {
		return jsyysj;
	}

	public void setJsyysj(Date jsyysj) {
		this.jsyysj = jsyysj;
	}

	/** @ 场所负责人编号(csfzrbh) */
	public String getCsfzrbh() {
		return csfzrbh;
	}

	public void setCsfzrbh(String csfzrbh) {
		this.csfzrbh = csfzrbh;
	}

	/** @ 场所负责人姓名(csfe) */
	public String getCsfe() {
		return csfe;
	}

	public void setCsfe(String csfe) {
		this.csfe = csfe;
	}

	/** @ 治安负责人编号(zafzrbh) */
	public String getZafzrbh() {
		return zafzrbh;
	}

	public void setZafzrbh(String zafzrbh) {
		this.zafzrbh = zafzrbh;
	}

	/** @ 治安负责人姓名(zafzrxm) */
	public String getZafzrxm() {
		return zafzrxm;
	}

	public void setZafzrxm(String zafzrxm) {
		this.zafzrxm = zafzrxm;
	}

	/** @ 是否有治安、刑事案件或事故发生(sffsaj) */
	public String getSffsaj() {
		return sffsaj;
	}

	public void setSffsaj(String sffsaj) {
		this.sffsaj = sffsaj;
	}

	/** @ 是否有管理部门检查(sfglbmjc) */
	public String getSfglbmjc() {
		return sfglbmjc;
	}

	public void setSfglbmjc(String sfglbmjc) {
		this.sfglbmjc = sfglbmjc;
	}

	/** @ 当日营业状况(dryysj) */
	public String getDryysj() {
		return dryysj;
	}

	public void setDryysj(String dryysj) {
		this.dryysj = dryysj;
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

	/** @ 所属地地市机构代码(ssddsjgdm) */
	public String getSsddsjgdm() {
		return ssddsjgdm;
	}

	public void setSsddsjgdm(String ssddsjgdm) {
		this.ssddsjgdm = ssddsjgdm;
	}

	/** @ 所属地地市机构名称(ssddsjgmc) */
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

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXmpy() {
		return xmpy;
	}

	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}

	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	public String getWgrjyxkz() {
		return wgrjyxkz;
	}

	public void setWgrjyxkz(String wgrjyxkz) {
		this.wgrjyxkz = wgrjyxkz;
	}

	public String getYwm() {
		return ywm;
	}

	public void setYwm(String ywm) {
		this.ywm = ywm;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public Date getSksj() {
		return sksj;
	}

	public void setSksj(Date sksj) {
		this.sksj = sksj;
	}

	public String getSsqybm() {
		return ssqybm;
	}

	public void setSsqybm(String ssqybm) {
		this.ssqybm = ssqybm;
	}

	public String getSsqymc() {
		return ssqymc;
	}

	public void setSsqymc(String ssqymc) {
		this.ssqymc = ssqymc;
	}

	public String getBqycyrybh() {
		return bqycyrybh;
	}

	public void setBqycyrybh(String bqycyrybh) {
		this.bqycyrybh = bqycyrybh;
	}

	public String getBqycyryxm() {
		return bqycyryxm;
	}

	public void setBqycyryxm(String bqycyryxm) {
		this.bqycyryxm = bqycyryxm;
	}

	public String getCrqycyrybh() {
		return crqycyrybh;
	}

	public void setCrqycyrybh(String crqycyrybh) {
		this.crqycyrybh = crqycyrybh;
	}

	public String getCrqycyryxm() {
		return crqycyryxm;
	}

	public void setCrqycyryxm(String crqycyryxm) {
		this.crqycyryxm = crqycyryxm;
	}

	public Integer getAllRow() {
		return allRow;
	}

	public void setAllRow(Integer allRow) {
		this.allRow = allRow;
	}

	public Integer getBeginRow() {
		return beginRow;
	}

	public void setBeginRow(Integer beginRow) {
		this.beginRow = beginRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}


}
