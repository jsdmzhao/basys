package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Wpbjxxb  {

	/** @param 物品报警信息表(t_wpbjxxb) */

	/** @ --报警信息ID--bjxxid2--Integer--10-- */
	private Integer bjxxid2;
	
	private Integer wpbjgzid;   ////报警规则id

	/** @ --所属企业名称--ssqymc--String--100-- */
	private String ssqymc;

	/** @ --所属企业地址--ssqydz--String--200-- */
	private String ssqydz;

	/** @ --管辖单位代码--gxdwbm--String--20-- */
	private String gxdwbm;

	/** @ --管辖单位名称--gxdwmc--String--60-- */
	private String gxdwmc;

	/** @ --报警类型代码--bjlxdm--String--4-- */
	private String bjlxdm;

	/** @ --报警类型--bjlx--String--60-- */
	private String bjlx;

	/** @ --报警时间--bjsj--Date---- */
	private Date bjsj;
	
	private Date bjsjks;   //报警时间开始
	
	private Date bjsjjs;   //报警时间结束
	

	/** @ --比对表名--bdbm--String--100-- */
	private String bdbm;

	/** @ --业务表名--ywbm--String--100-- */
	private String ywbm;

	/** @ --行业类别代码--hylbdm--String--2-- */
	private String hylbdm;

	/** @ --行业类别--hylb--String--100-- */
	private String hylb;

	/** @ --简要案情--jyaq--String--2000-- */
	private String jyaq;

	/** @ --立案单位编码--ladwbm--String--20-- */
	private String ladwbm;

	/** @ --立案单位名称--ladwmc--String--100-- */
	private String ladwmc;

	/** @ --更新版本号--gxbbh--Integer--6-- */
	private Integer gxbbh;

	/** @ --业务类别代码--ywlbdm--String--2-- */
	private String ywlbdm;

	/** @ --业务类别--ywlb--String--30-- */
	private String ywlb;

	/** @ --派警部门编码--pjbmbm--String--20-- */
	private String pjbmbm;

	/** @ --派警部门名称--pjbmmc--String--100-- */
	private String pjbmmc;

	/** @ --派警人--pjr--String--100-- */
	private String pjr;

	/** @ --派警时间--pjsj--Date---- */
	private Date pjsj;

	/** @ --警情状态代码--jqztdm--String--2-- */
	private String jqztdm;

	/** @ --警情状态--jqzt--String--2-- */
	private String jqzt;

	/** @ --出警部门编码--cjbmbm--String--20-- */
	private String cjbmbm;

	/** @ --出警部门--cjbm--String--100-- */
	private String cjbm;

	/** @ --出警时间--chjsj--Date---- */
	private Date chjsj;
	
	private Date chjsjks; //出警开始时间
	
	private Date chjsjjs;  //出警结束时间

	/** @ --出警负责人--cjfzr--String--100-- */
	private String cjfzr;

	/** @ --联系电话--lxdh--String--30-- */
	private String lxdh;

	/** @ --处警反馈类别代码--cjfklbdm--String--2-- */
	private String cjfklbdm;

	/** @ --处警反馈类别--cjfklb--String--60-- */
	private String cjfklb;

	/** @ --处警反馈备注--cjfkbz--String--2000-- */
	private String cjfkbz;

	/** @ --反馈单位编码--fkdwbm--String--20-- */
	private String fkdwbm;

	/** @ --反馈单位--fkdw--String--100-- */
	private String fkdw;

	/** @ --反馈日期--fkrq--Date---- */
	private Date fkrq;

	/** @ --处警经过--cjjg--String--2000-- */
	private String cjjg;

	/** @ --处警结果代码--cjjgdm--String--2-- */
	private String cjjgdm;

	/** @ --处警结果--chjjg--String--60-- */
	private String chjjg;

	/** @ --抓获时间--zhsj--Date---- */
	private Date zhsj;

	/** @ --无效原因代码--wxyydm--String--2-- */
	private String wxyydm;

	/** @ --无效原因--wxyy--String--60-- */
	private String wxyy;

	/** @ --是否有效报警代码--sfyxbjdm--String--2-- */
	private String sfyxbjdm;

	/** @ --是否有效报警--sfyxbj--String--30-- */
	private String sfyxbj;

	/** @ --反馈人--fkr--String--60-- */
	private String fkr;

	/** @ --业务表主键--ywbzj--String--30-- */
	private String ywbzj;

	/** @ --比对表主键--bdbzj--String--30-- */
	private String bdbzj;
	
	private String wpmc;   // 物品名称
	
	private String wpjp;  // 物品简拼
	
	private String wpqp;   // 物品全拼
	
	private String show_sfqrbj; // 是否确认报警
	
	private String show_sfcj; // 是否出警
	
	private String show_sfcx; // 是否撤销
	
	private Date show_cxsj; // 撤销时间
	
	private String show_sflw; // 是否漏网
	
	private String tyCheck; // 同音检索check
	
	private String canModify; // 处警回复修改过期时间（天）
	
	private String bdtjSql;  ////临时sql字段
	
	private Integer ywbzj1;//比对报警时的业务表主键1 (物品ID)
	private Integer ywbzj2;//比对报警时的业务表主键2 (企业ID)
	
	//private String wpmc;
	//private String wpjp;
	//private String wpqp;
	/** @ --号牌号码--hphm--String--32-- */
	private String hphm;
	/** @ --发动机号--fdjh--String--60-- */
	private String fdjh;

	/** @ --车辆识别代号--clsbdh--String--50-- */
	private String clsbdh;

	/** @ --车架号--cjh--String--50-- */
	private String cjh;
	/** @ --手机串号--sjch--String--30-- */
	private String sjch;
	
	

	/** 分页排序 */
	private String pageSort;

	/** @ 报警信息ID(bjxxid2) */
	public Integer getBjxxid2() {
		return bjxxid2;
	}

	public void setBjxxid2(Integer bjxxid2) {
		this.bjxxid2 = bjxxid2;
	}

	/** @ 所属企业名称(ssqymc) */
	public String getSsqymc() {
		return ssqymc;
	}

	public void setSsqymc(String ssqymc) {
		this.ssqymc = ssqymc;
	}

	/** @ 所属企业地址(ssqydz) */
	public String getSsqydz() {
		return ssqydz;
	}

	public void setSsqydz(String ssqydz) {
		this.ssqydz = ssqydz;
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

	/** @ 报警类型代码(bjlxdm) */
	public String getBjlxdm() {
		return bjlxdm;
	}

	public void setBjlxdm(String bjlxdm) {
		this.bjlxdm = bjlxdm;
	}

	/** @ 报警类型(bjlx) */
	public String getBjlx() {
		return bjlx;
	}

	public void setBjlx(String bjlx) {
		this.bjlx = bjlx;
	}

	/** @ 报警时间(bjsj) */
	public Date getBjsj() {
		return bjsj;
	}

	public void setBjsj(Date bjsj) {
		this.bjsj = bjsj;
	}

	/** @ 比对表名(bdbm) */
	public String getBdbm() {
		return bdbm;
	}

	public void setBdbm(String bdbm) {
		this.bdbm = bdbm;
	}

	/** @ 业务表名(ywbm) */
	public String getYwbm() {
		return ywbm;
	}

	public void setYwbm(String ywbm) {
		this.ywbm = ywbm;
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

	/** @ 简要案情(jyaq) */
	public String getJyaq() {
		return jyaq;
	}

	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
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

	/** @ 更新版本号(gxbbh) */
	public Integer getGxbbh() {
		return gxbbh;
	}

	public void setGxbbh(Integer gxbbh) {
		this.gxbbh = gxbbh;
	}

	/** @ 业务类别代码(ywlbdm) */
	public String getYwlbdm() {
		return ywlbdm;
	}

	public void setYwlbdm(String ywlbdm) {
		this.ywlbdm = ywlbdm;
	}

	/** @ 业务类别(ywlb) */
	public String getYwlb() {
		return ywlb;
	}

	public void setYwlb(String ywlb) {
		this.ywlb = ywlb;
	}

	/** @ 派警部门编码(pjbmbm) */
	public String getPjbmbm() {
		return pjbmbm;
	}

	public void setPjbmbm(String pjbmbm) {
		this.pjbmbm = pjbmbm;
	}

	/** @ 派警部门名称(pjbmmc) */
	public String getPjbmmc() {
		return pjbmmc;
	}

	public void setPjbmmc(String pjbmmc) {
		this.pjbmmc = pjbmmc;
	}

	/** @ 派警人(pjr) */
	public String getPjr() {
		return pjr;
	}

	public void setPjr(String pjr) {
		this.pjr = pjr;
	}

	/** @ 派警时间(pjsj) */
	public Date getPjsj() {
		return pjsj;
	}

	public void setPjsj(Date pjsj) {
		this.pjsj = pjsj;
	}

	/** @ 警情状态代码(jqztdm) */
	public String getJqztdm() {
		return jqztdm;
	}

	public void setJqztdm(String jqztdm) {
		this.jqztdm = jqztdm;
	}

	/** @ 警情状态(jqzt) */
	public String getJqzt() {
		return jqzt;
	}

	public void setJqzt(String jqzt) {
		this.jqzt = jqzt;
	}

	/** @ 出警部门编码(cjbmbm) */
	public String getCjbmbm() {
		return cjbmbm;
	}

	public void setCjbmbm(String cjbmbm) {
		this.cjbmbm = cjbmbm;
	}

	/** @ 出警部门(cjbm) */
	public String getCjbm() {
		return cjbm;
	}

	public void setCjbm(String cjbm) {
		this.cjbm = cjbm;
	}

	/** @ 出警时间(chjsj) */
	public Date getChjsj() {
		return chjsj;
	}

	public void setChjsj(Date chjsj) {
		this.chjsj = chjsj;
	}

	/** @ 出警负责人(cjfzr) */
	public String getCjfzr() {
		return cjfzr;
	}

	public void setCjfzr(String cjfzr) {
		this.cjfzr = cjfzr;
	}

	/** @ 联系电话(lxdh) */
	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	/** @ 处警反馈类别代码(cjfklbdm) */
	public String getCjfklbdm() {
		return cjfklbdm;
	}

	public void setCjfklbdm(String cjfklbdm) {
		this.cjfklbdm = cjfklbdm;
	}

	/** @ 处警反馈类别(cjfklb) */
	public String getCjfklb() {
		return cjfklb;
	}

	public void setCjfklb(String cjfklb) {
		this.cjfklb = cjfklb;
	}

	/** @ 处警反馈备注(cjfkbz) */
	public String getCjfkbz() {
		return cjfkbz;
	}

	public void setCjfkbz(String cjfkbz) {
		this.cjfkbz = cjfkbz;
	}

	/** @ 反馈单位编码(fkdwbm) */
	public String getFkdwbm() {
		return fkdwbm;
	}

	public void setFkdwbm(String fkdwbm) {
		this.fkdwbm = fkdwbm;
	}

	/** @ 反馈单位(fkdw) */
	public String getFkdw() {
		return fkdw;
	}

	public void setFkdw(String fkdw) {
		this.fkdw = fkdw;
	}

	/** @ 反馈日期(fkrq) */
	public Date getFkrq() {
		return fkrq;
	}

	public void setFkrq(Date fkrq) {
		this.fkrq = fkrq;
	}

	/** @ 处警经过(cjjg) */
	public String getCjjg() {
		return cjjg;
	}

	public void setCjjg(String cjjg) {
		this.cjjg = cjjg;
	}

	/** @ 处警结果代码(cjjgdm) */
	public String getCjjgdm() {
		return cjjgdm;
	}

	public void setCjjgdm(String cjjgdm) {
		this.cjjgdm = cjjgdm;
	}

	/** @ 处警结果(chjjg) */
	public String getChjjg() {
		return chjjg;
	}

	public void setChjjg(String chjjg) {
		this.chjjg = chjjg;
	}

	/** @ 抓获时间(zhsj) */
	public Date getZhsj() {
		return zhsj;
	}

	public void setZhsj(Date zhsj) {
		this.zhsj = zhsj;
	}

	/** @ 无效原因代码(wxyydm) */
	public String getWxyydm() {
		return wxyydm;
	}

	public void setWxyydm(String wxyydm) {
		this.wxyydm = wxyydm;
	}

	/** @ 无效原因(wxyy) */
	public String getWxyy() {
		return wxyy;
	}

	public void setWxyy(String wxyy) {
		this.wxyy = wxyy;
	}

	/** @ 是否有效报警代码(sfyxbjdm) */
	public String getSfyxbjdm() {
		return sfyxbjdm;
	}

	public void setSfyxbjdm(String sfyxbjdm) {
		this.sfyxbjdm = sfyxbjdm;
	}

	/** @ 是否有效报警(sfyxbj) */
	public String getSfyxbj() {
		return sfyxbj;
	}

	public void setSfyxbj(String sfyxbj) {
		this.sfyxbj = sfyxbj;
	}

	/** @ 反馈人(fkr) */
	public String getFkr() {
		return fkr;
	}

	public void setFkr(String fkr) {
		this.fkr = fkr;
	}

	/** @ 业务表主键(ywbzj) */
	public String getYwbzj() {
		return ywbzj;
	}

	public void setYwbzj(String ywbzj) {
		this.ywbzj = ywbzj;
	}

	/** @ 比对表主键(bdbzj) */
	public String getBdbzj() {
		return bdbzj;
	}

	public void setBdbzj(String bdbzj) {
		this.bdbzj = bdbzj;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Integer getWpbjgzid() {
		return wpbjgzid;
	}

	public void setWpbjgzid(Integer wpbjgzid) {
		this.wpbjgzid = wpbjgzid;
	}

	public String getBdtjSql() {
		return bdtjSql;
	}

	public void setBdtjSql(String bdtjSql) {
		this.bdtjSql = bdtjSql;
	}

	public String getWpmc() {
		return wpmc;
	}

	public void setWpmc(String wpmc) {
		this.wpmc = wpmc;
	}

	public String getWpjp() {
		return wpjp;
	}

	public void setWpjp(String wpjp) {
		this.wpjp = wpjp;
	}

	public String getWpqp() {
		return wpqp;
	}

	public void setWpqp(String wpqp) {
		this.wpqp = wpqp;
	}

	public Date getBjsjks() {
		return bjsjks;
	}

	public void setBjsjks(Date bjsjks) {
		this.bjsjks = bjsjks;
	}

	public Date getBjsjjs() {
		return bjsjjs;
	}

	public void setBjsjjs(Date bjsjjs) {
		this.bjsjjs = bjsjjs;
	}

	public Date getChjsjks() {
		return chjsjks;
	}

	public void setChjsjks(Date chjsjks) {
		this.chjsjks = chjsjks;
	}

	public Date getChjsjjs() {
		return chjsjjs;
	}

	public void setChjsjjs(Date chjsjjs) {
		this.chjsjjs = chjsjjs;
	}

	public String getTyCheck() {
		return tyCheck;
	}

	public void setTyCheck(String tyCheck) {
		this.tyCheck = tyCheck;
	}

	public String getShow_sfqrbj() {
		return show_sfqrbj;
	}

	public void setShow_sfqrbj(String show_sfqrbj) {
		this.show_sfqrbj = show_sfqrbj;
	}

	public String getShow_sfcj() {
		return show_sfcj;
	}

	public void setShow_sfcj(String show_sfcj) {
		this.show_sfcj = show_sfcj;
	}

	public String getShow_sfcx() {
		return show_sfcx;
	}

	public void setShow_sfcx(String show_sfcx) {
		this.show_sfcx = show_sfcx;
	}

	public Date getShow_cxsj() {
		return show_cxsj;
	}

	public void setShow_cxsj(Date show_cxsj) {
		this.show_cxsj = show_cxsj;
	}

	public String getShow_sflw() {
		return show_sflw;
	}

	public void setShow_sflw(String show_sflw) {
		this.show_sflw = show_sflw;
	}

	public String getCanModify() {
		return canModify;
	}

	public void setCanModify(String canModify) {
		this.canModify = canModify;
	}


	public Integer getYwbzj1() {
		return ywbzj1;
	}

	public void setYwbzj1(Integer ywbzj1) {
		this.ywbzj1 = ywbzj1;
	}

	public Integer getYwbzj2() {
		return ywbzj2;
	}

	public void setYwbzj2(Integer ywbzj2) {
		this.ywbzj2 = ywbzj2;
	}

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getFdjh() {
		return fdjh;
	}

	public void setFdjh(String fdjh) {
		this.fdjh = fdjh;
	}

	public String getClsbdh() {
		return clsbdh;
	}

	public void setClsbdh(String clsbdh) {
		this.clsbdh = clsbdh;
	}

	public String getCjh() {
		return cjh;
	}

	public void setCjh(String cjh) {
		this.cjh = cjh;
	}

	public String getSjch() {
		return sjch;
	}

	public void setSjch(String sjch) {
		this.sjch = sjch;
	}
}
