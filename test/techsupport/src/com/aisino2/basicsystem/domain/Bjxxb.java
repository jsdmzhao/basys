package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Bjxxb  {
	private Integer bjgzid;
	private Integer bjxxid;
	private String ssqymc;
	private String ssqydz;
	private String gxdwbm;
	private String gxdwmc;
	private String bjlxdm;
	private String bjlx;
	private Date bjsj;
	private Date bjsj1;
	private Date bjsj2;
	private String bdbm;
	private String ywbm;
	private String hylbdm;
	private String hylb;
	private String xm;
	private String gmsfhm;
	private String jyaq;
	private String ladwbm;
	private String ladwmc;
	private Integer gxbbh;
	private String ywlbdm;
	private String ywlb;
	private String pjbmbm;
	private String pjbmmc;
	private String pjr;
	private Date pjsj;
	private String jqztdm;
	private String jqzt;
	private String cjbmbm;
	private String cjbm;
	private Date chjsj;
	private String cjfzr;
	private String lxdh;
	private String cjfklbdm;
	private String cjfklb;
	private String cjfkbz;
	private String fkdwbm;
	private String fkdw;
	private Date fkrq;
	private String fkr;
	private String cjjg;
	private String cjjgdm;
	private String chjjg;
	private Date zhsj;
	private Date zhsj1;
	private Date zhsj2;
	private String wxyy;
	private String wxyydm;
	private String sfyxbjdm;
	private String sfyxbj;
	private String show_sfqrbj;
	private String show_sfcj;
	private String fjh;
	private String canModify; // 处警回复修改过期时间（天）
	private String tjlx;
	private String ywbzj;
	private String gxdwbm_full;
	
	private Integer gxdwlevel;//管辖单位级别
	private String isleaf;//是否叶子节点

	private Date ruzhusj; // //入住时间
	private String bdtjSql;//报警条件sql
	private String bdbzj;//比对表主键
	private String y_gxdwbm;//原管辖单位编码
	private String y_gxdwmc;//原管辖单位名称
	
	private Integer ywbzj1;//报警比对时的业务表主键1
	private Integer ywbzj2;//报警比对时的业务表主键2
	private String zjhm;//报警比对时的业务表与比对表关联字段
    private String sfpj;//是否派警  0没有派警  1派警
    
    private String usertype; //用户类别
	/** 分页排序 */
	private String pageSort;
	
	private String state;//根据统计类型判断使用何种查询条件的状态属性

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFkr() {
		return fkr;
	}

	public Integer getGxdwlevel() {
		return gxdwlevel;
	}

	public void setGxdwlevel(Integer gxdwlevel) {
		this.gxdwlevel = gxdwlevel;
	}

	public String getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}

	public void setFkr(String fkr) {
		this.fkr = fkr;
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

	public String getSfyxbjdm() {
		return sfyxbjdm;
	}

	public void setSfyxbjdm(String sfyxbjdm) {
		this.sfyxbjdm = sfyxbjdm;
	}

	public String getSfyxbj() {
		return sfyxbj;
	}

	public void setSfyxbj(String sfyxbj) {
		this.sfyxbj = sfyxbj;
	}

	public String getGxdwmc() {
		return gxdwmc;
	}

	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}

	public String getBjlxdm() {
		return bjlxdm;
	}

	public void setBjlxdm(String bjlxdm) {
		this.bjlxdm = bjlxdm;
	}

	public String getBjlx() {
		return bjlx;
	}

	public void setBjlx(String bjlx) {
		this.bjlx = bjlx;
	}

	public Date getBjsj() {
		return bjsj;
	}

	public void setBjsj(Date bjsj) {
		this.bjsj = bjsj;
	}

	public Date getBjsj1() {
		return bjsj1;
	}

	public void setBjsj1(Date bjsj1) {
		this.bjsj1 = bjsj1;
	}

	public Date getBjsj2() {
		return bjsj2;
	}

	public void setBjsj2(Date bjsj2) {
		this.bjsj2 = bjsj2;
	}

	public String getBdbm() {
		return bdbm;
	}

	public void setBdbm(String bdbm) {
		this.bdbm = bdbm;
	}

	public String getYwbm() {
		return ywbm;
	}

	public void setYwbm(String ywbm) {
		this.ywbm = ywbm;
	}

	public String getHylbdm() {
		return hylbdm;
	}

	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	public String getJyaq() {
		return jyaq;
	}

	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}

	public String getLadwbm() {
		return ladwbm;
	}

	public void setLadwbm(String ladwbm) {
		this.ladwbm = ladwbm;
	}

	public String getLadwmc() {
		return ladwmc;
	}

	public void setLadwmc(String ladwmc) {
		this.ladwmc = ladwmc;
	}

	public Integer getGxbbh() {
		return gxbbh;
	}

	public void setGxbbh(Integer gxbbh) {
		this.gxbbh = gxbbh;
	}

	public String getYwlbdm() {
		return ywlbdm;
	}

	public void setYwlbdm(String ywlbdm) {
		this.ywlbdm = ywlbdm;
	}

	public String getYwlb() {
		return ywlb;
	}

	public void setYwlb(String ywlb) {
		this.ywlb = ywlb;
	}

	public String getPjbmbm() {
		return pjbmbm;
	}

	public void setPjbmbm(String pjbmbm) {
		this.pjbmbm = pjbmbm;
	}

	public String getPjbmmc() {
		return pjbmmc;
	}

	public void setPjbmmc(String pjbmmc) {
		this.pjbmmc = pjbmmc;
	}

	public String getPjr() {
		return pjr;
	}

	public void setPjr(String pjr) {
		this.pjr = pjr;
	}

	public Date getPjsj() {
		return pjsj;
	}

	public void setPjsj(Date pjsj) {
		this.pjsj = pjsj;
	}

	public String getJqztdm() {
		return jqztdm;
	}

	public void setJqztdm(String jqztdm) {
		this.jqztdm = jqztdm;
	}

	public String getJqzt() {
		return jqzt;
	}

	public void setJqzt(String jqzt) {
		this.jqzt = jqzt;
	}

	public String getCjbmbm() {
		return cjbmbm;
	}

	public void setCjbmbm(String cjbmbm) {
		this.cjbmbm = cjbmbm;
	}

	public String getCjbm() {
		return cjbm;
	}

	public void setCjbm(String cjbm) {
		this.cjbm = cjbm;
	}

	public Date getChjsj() {
		return chjsj;
	}

	public void setChjsj(Date chjsj) {
		this.chjsj = chjsj;
	}

	public String getCjfzr() {
		return cjfzr;
	}

	public void setCjfzr(String cjfzr) {
		this.cjfzr = cjfzr;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getCjfklbdm() {
		return cjfklbdm;
	}

	public void setCjfklbdm(String cjfklbdm) {
		this.cjfklbdm = cjfklbdm;
	}

	public String getCjfklb() {
		return cjfklb;
	}

	public void setCjfklb(String cjfklb) {
		this.cjfklb = cjfklb;
	}

	public String getCjfkbz() {
		return cjfkbz;
	}

	public void setCjfkbz(String cjfkbz) {
		this.cjfkbz = cjfkbz;
	}

	public String getFkdwbm() {
		return fkdwbm;
	}

	public void setFkdwbm(String fkdwbm) {
		this.fkdwbm = fkdwbm;
	}

	public String getFkdw() {
		return fkdw;
	}

	public void setFkdw(String fkdw) {
		this.fkdw = fkdw;
	}

	public Date getFkrq() {
		return fkrq;
	}

	public void setFkrq(Date fkrq) {
		this.fkrq = fkrq;
	}

	public String getCjjg() {
		return cjjg;
	}

	public void setCjjg(String cjjg) {
		this.cjjg = cjjg;
	}

	public String getCjjgdm() {
		return cjjgdm;
	}

	public void setCjjgdm(String cjjgdm) {
		this.cjjgdm = cjjgdm;
	}

	public String getChjjg() {
		return chjjg;
	}

	public void setChjjg(String chjjg) {
		this.chjjg = chjjg;
	}

	public Date getZhsj() {
		return zhsj;
	}

	public void setZhsj(Date zhsj) {
		this.zhsj = zhsj;
	}

	public String getWxyy() {
		return wxyy;
	}

	public void setWxyy(String wxyy) {
		this.wxyy = wxyy;
	}

	public Integer getBjgzid() {
		return bjgzid;
	}

	public void setBjgzid(Integer bjgzid) {
		this.bjgzid = bjgzid;
	}

	public Integer getBjxxid() {
		return bjxxid;
	}

	public void setBjxxid(Integer bjxxid) {
		this.bjxxid = bjxxid;
	}

	public String getSsqymc() {
		return ssqymc;
	}

	public void setSsqymc(String ssqymc) {
		this.ssqymc = ssqymc;
	}

	public String getSsqydz() {
		return ssqydz;
	}

	public void setSsqydz(String ssqydz) {
		this.ssqydz = ssqydz;
	}

	public String getGxdwbm() {
		return gxdwbm;
	}

	public void setGxdwbm(String gxdwbm) {
		this.gxdwbm = gxdwbm;
	}

	public String getWxyydm() {
		return wxyydm;
	}

	public void setWxyydm(String wxyydm) {
		this.wxyydm = wxyydm;
	}

	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public String getFjh() {
		return fjh;
	}

	public void setFjh(String fjh) {
		this.fjh = fjh;
	}

	public String getCanModify() {
		return canModify;
	}

	public void setCanModify(String canModify) {
		this.canModify = canModify;
	}

	public Date getZhsj1() {
		return zhsj1;
	}

	public void setZhsj1(Date zhsj1) {
		this.zhsj1 = zhsj1;
	}

	public Date getZhsj2() {
		return zhsj2;
	}

	public void setZhsj2(Date zhsj2) {
		this.zhsj2 = zhsj2;
	}

	public String getTjlx() {
		return tjlx;
	}

	public void setTjlx(String tjlx) {
		this.tjlx = tjlx;
	}

	public String getYwbzj() {
		return ywbzj;
	}

	public void setYwbzj(String ywbzj) {
		this.ywbzj = ywbzj;
	}

	public Date getRuzhusj() {
		return ruzhusj;
	}

	public void setRuzhusj(Date ruzhusj) {
		this.ruzhusj = ruzhusj;
	}

	public String getGxdwbm_full() {
		return gxdwbm_full;
	}

	public void setGxdwbm_full(String gxdwbm_full) {
		this.gxdwbm_full = gxdwbm_full;
	}

	public String getBdtjSql() {
		return bdtjSql;
	}

	public void setBdtjSql(String bdtjSql) {
		this.bdtjSql = bdtjSql;
	}

	public String getBdbzj() {
		return bdbzj;
	}

	public void setBdbzj(String bdbzj) {
		this.bdbzj = bdbzj;
	}

	public String getY_gxdwbm() {
		return y_gxdwbm;
	}

	public void setY_gxdwbm(String y_gxdwbm) {
		this.y_gxdwbm = y_gxdwbm;
	}

	public String getY_gxdwmc() {
		return y_gxdwmc;
	}

	public void setY_gxdwmc(String y_gxdwmc) {
		this.y_gxdwmc = y_gxdwmc;
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

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getSfpj() {
		return sfpj;
	}

	public void setSfpj(String sfpj) {
		this.sfpj = sfpj;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
}