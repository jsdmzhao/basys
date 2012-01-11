package com.aisino2.basicsystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class Bkry  {

	/** @param 布控人员(t_bkry) */

	/** @ --布控人员ID--bkryid--Integer--10-- */
	private Integer bkryid;

	/** @ --通报编号--tbbh--String--20-- */
	private String tbbh;

	/** @ --姓名--xm--String--100-- */
	private String xm;

	/** @ --曾用名--cym--String--100-- */
	private String cym;

	/** @ --公民身份号码--gmsfhm--String--20-- */
	private String gmsfhm;

	/** @ --姓名拼音--xmpy--String--60-- */
	private String xmpy;

	/** @ --籍贯代码--jgdm--String--6-- */
	private String jgdm;

	/** @ --籍贯--jg--String--100-- */
	private String jg;

	/** @ --出生日期--csrq--Date---- */
	private Date csrq;
	
	/** @ --出生日期--csrq--Date---- */
	private Date csrq2;

	/** @ --性别代码--xbdm--String--2-- */
	private String xbdm;

	/** @ --性别--xb--String--2-- */
	private String xb;

	/** @ --民族代码--mzdm--String--40-- */
	private String mzdm;

	/** @ --民族--minzu--String--20-- */
	private String minzu;

	/** @ --口音编码--kybm--String--6-- */
	private String kybm;

	/** @ --口音--ky--String--100-- */
	private String ky;

	/** @ --身高--shengao--Float--5,2-- */
	private Float shengao;

	/** @ --体征编码--tzbm--String--10-- */
	private String tzbm;

	/** @ --体征--tz--String--100-- */
	private String tz;

	/** @ --体态编码--ttbm--String--20-- */
	private String ttbm;

	/** @ --体态--tt--String--100-- */
	private String tt;

	/** @ --衣着--yz--String--200-- */
	private String yz;

	/** @ --住址--zz--String--300-- */
	private String zz;

	/** @ --发文单位--fwdw--String--100-- */
	private String fwdw;

	/** @ --发文单位编码--fwdwbm--String--60-- */
	private String fwdwbm;

	/** @ --案件类别编码--ajlbbm--String--20-- */
	private String ajlbbm;

	/** @ --案件类别--ajlb--String--60-- */
	private String ajlb;

	/** @ --通报时间--tbsj--Date---- */
	private Date tbsj;

	/** @ --简要案情--jyaq--String--2000-- */
	private String jyaq;

	/** @ --处理结果--cljg--String--2000-- */
	private String cljg;

	/** @ --布控人--bkr--String--100-- */
	private String bkr;

	/** @ --布控操作员--bkczy--String--100-- */
	private String bkczy;

	/** @ --布控操作时间--bkczsj--Date---- */
	private Date bkczsj;
	
	/** @ --布控操作时间--bkczsj--Date---- */
	private Date bkczsj2;

	/** @ --布控到期时间--bkdqsj--Date---- */
	private Date bkdqsj;

	/** @ --布控范围编码--bkfwbm--String--2-- */
	private String bkfwbm;

	/** @ --布控范围--bkfw--String--300-- */
	private String bkfw;

	/** @ --布控审批意见--bkspyj--String--2000-- */
	private String bkspyj;

	/** @ --联系人--lxr--String--100-- */
	private String lxr;

	/** @ --联系方式--lxfs--String--60-- */
	private String lxfs;

	/** @ --是否同意发布--sftyfb--String--2-- */
	private String sftyfb;

	/** @ --审批单位--spdw--String--100-- */
	private String spdw;

	/** @ --审批人--spr--String--100-- */
	private String spr;

	/** @ --审批日期--sprq--Date---- */
	private Date sprq;

	/** @ --请求撤控标识--qqckbs--String--2-- */
	private String qqckbs;

	/** @ --撤控标识--ckbs--String--2-- */
	private String ckbs;

	/** @ --撤控原因--ckyy--String--2000-- */
	private String ckyy;

	/** @ --撤控时间--cksj--Date---- */
	private Date cksj;

	/** @ --撤控人--ckr--String--100-- */
	private String ckr;

	/** @ --撤控操作员--ckczy--String--100-- */
	private String ckczy;

	/** @ --撤控操作时间--ckczsj--Date---- */
	private Date ckczsj;

	/** @ --撤控部门编码--ckbmbm--String--60-- */
	private String ckbmbm;

	/** @ --撤控部门名称--ckbmmc--String--100-- */
	private String ckbmmc;

	/** @ --撤控审批单位--ckspdw--String--100-- */
	private String ckspdw;

	/** @ --撤控审批人--ckspr--String--100-- */
	private String ckspr;

	/** @ --撤控审批意见--ckspyj--String--2000-- */
	private String ckspyj;

	/** @ --撤控审批日期--cksprq--Date---- */
	private Date cksprq;

	/** @ --行政区划--xzqh--String--100-- */
	private String xzqh;

	/** @ --发送标识--fsbs--String--2-- */
	private String fsbs;

	/** @ --布控对象照片--bkdxzp--byte[]---- */
	private byte[] bkdxzp;
	
	/** 人员图片内容 */
	private String fileload;

	/** 分页排序 */
	private String pageSort;
	
	
	
	/** 为操作那列传的参数 */
	private String flag;
	

	/** 同音查询 */
	private String tyCheck;
	
	
	
	private String hylbdm;  ///行业类别代码
	
	private String hylb;    ///行业类别名称
	
	private String fwdwbmde; //发布单位简项编码
	
	
	/** 境外人员要的*/
	
	

	/** 中文名*/
	private String zwm;
	
	/** 英文名*/
	private String ywm;
	
	public String getFwdwbmde() {
		return fwdwbmde;
	}

	public void setFwdwbmde(String fwdwbmde) {
		this.fwdwbmde = fwdwbmde;
	}

	/** 英文姓*/
	private String ywx;
	
	/** 国籍代码*/
	private String gjdm;
	
	/** 国籍*/
	private String gj;
	
	/** 证件号码*/
	private String zjhm;
	
	/**证件类型*/
	private String zjlx;
	
	/**证件类型代码*/
	private String zjlxdm;
	
	/** 布控人员类型*/
	private String bkrylx;

	/** 布控人员类型代码*/
	private String bkrylxdm;
	
	
	/** 登陆用户的 级别*/
	private String deptLeve;
	/** 是否需要审核*/
	private String sfxysh;
	/** 是否需要审核*/
	private String shsftg;
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTyCheck() {
		return tyCheck;
	}

	public void setTyCheck(String tyCheck) {
		this.tyCheck = tyCheck;
	}

	/** @ 布控人员ID(bkryid) */
	public Integer getBkryid() {
		return bkryid;
	}

	public void setBkryid(Integer bkryid) {
		this.bkryid = bkryid;
	}

	/** @ 通报编号(tbbh) */
	public String getTbbh() {
		return tbbh;
	}

	public void setTbbh(String tbbh) {
		this.tbbh = tbbh;
	}

	/** @ 姓名(xm) */
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	/** @ 曾用名(cym) */
	public String getCym() {
		return cym;
	}

	public void setCym(String cym) {
		this.cym = cym;
	}

	/** @ 公民身份号码(gmsfhm) */
	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	/** @ 姓名拼音(xmpy) */
	public String getXmpy() {
		return xmpy;
	}

	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
	}

	/** @ 籍贯代码(jgdm) */
	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	/** @ 籍贯(jg) */
	public String getJg() {
		return jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

	/** @ 出生日期(csrq) */
	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	/** @ 性别代码(xbdm) */
	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	/** @ 性别(xb) */
	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	/** @ 民族代码(mzdm) */
	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	/** @ 民族(minzu) */
	public String getMinzu() {
		return minzu;
	}

	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}

	/** @ 口音编码(kybm) */
	public String getKybm() {
		return kybm;
	}

	public void setKybm(String kybm) {
		this.kybm = kybm;
	}

	/** @ 口音(ky) */
	public String getKy() {
		return ky;
	}

	public void setKy(String ky) {
		this.ky = ky;
	}

	/** @ 身高(shengao) */
	public Float getShengao() {
		return shengao;
	}

	public void setShengao(Float shengao) {
		this.shengao = shengao;
	}

	/** @ 体征编码(tzbm) */
	public String getTzbm() {
		return tzbm;
	}

	public void setTzbm(String tzbm) {
		this.tzbm = tzbm;
	}

	/** @ 体征(tz) */
	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	/** @ 体态编码(ttbm) */
	public String getTtbm() {
		return ttbm;
	}

	public void setTtbm(String ttbm) {
		this.ttbm = ttbm;
	}

	/** @ 体态(tt) */
	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	/** @ 衣着(yz) */
	public String getYz() {
		return yz;
	}

	public void setYz(String yz) {
		this.yz = yz;
	}

	/** @ 住址(zz) */
	public String getZz() {
		return zz;
	}

	public void setZz(String zz) {
		this.zz = zz;
	}

	/** @ 发文单位(fwdw) */
	public String getFwdw() {
		return fwdw;
	}

	public void setFwdw(String fwdw) {
		this.fwdw = fwdw;
	}

	/** @ 发文单位编码(fwdwbm) */
	public String getFwdwbm() {
		return fwdwbm;
	}

	public void setFwdwbm(String fwdwbm) {
		this.fwdwbm = fwdwbm;
	}

	/** @ 案件类别编码(ajlbbm) */
	public String getAjlbbm() {
		return ajlbbm;
	}

	public void setAjlbbm(String ajlbbm) {
		this.ajlbbm = ajlbbm;
	}

	/** @ 案件类别(ajlb) */
	public String getAjlb() {
		return ajlb;
	}

	public void setAjlb(String ajlb) {
		this.ajlb = ajlb;
	}

	/** @ 通报时间(tbsj) */
	public Date getTbsj() {
		return tbsj;
	}

	public void setTbsj(Date tbsj) {
		this.tbsj = tbsj;
	}

	/** @ 简要案情(jyaq) */
	public String getJyaq() {
		return jyaq;
	}

	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}

	/** @ 处理结果(cljg) */
	public String getCljg() {
		return cljg;
	}

	public void setCljg(String cljg) {
		this.cljg = cljg;
	}

	/** @ 布控人(bkr) */
	public String getBkr() {
		return bkr;
	}

	public void setBkr(String bkr) {
		this.bkr = bkr;
	}

	/** @ 布控操作员(bkczy) */
	public String getBkczy() {
		return bkczy;
	}

	public void setBkczy(String bkczy) {
		this.bkczy = bkczy;
	}

	/** @ 布控操作时间(bkczsj) */
	public Date getBkczsj() {
		return bkczsj;
	}

	public void setBkczsj(Date bkczsj) {
		this.bkczsj = bkczsj;
	}

	/** @ 布控到期时间(bkdqsj) */
	public Date getBkdqsj() {
		return bkdqsj;
	}

	public void setBkdqsj(Date bkdqsj) {
		this.bkdqsj = bkdqsj;
	}

	/** @ 布控范围编码(bkfwbm) */
	public String getBkfwbm() {
		return bkfwbm;
	}

	public void setBkfwbm(String bkfwbm) {
		this.bkfwbm = bkfwbm;
	}

	/** @ 布控范围(bkfw) */
	public String getBkfw() {
		return bkfw;
	}

	public void setBkfw(String bkfw) {
		this.bkfw = bkfw;
	}

	/** @ 布控审批意见(bkspyj) */
	public String getBkspyj() {
		return bkspyj;
	}

	public void setBkspyj(String bkspyj) {
		this.bkspyj = bkspyj;
	}

	/** @ 联系人(lxr) */
	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	/** @ 联系方式(lxfs) */
	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	/** @ 是否同意发布(sftyfb) */
	public String getSftyfb() {
		return sftyfb;
	}

	public void setSftyfb(String sftyfb) {
		this.sftyfb = sftyfb;
	}

	/** @ 审批单位(spdw) */
	public String getSpdw() {
		return spdw;
	}

	public void setSpdw(String spdw) {
		this.spdw = spdw;
	}

	/** @ 审批人(spr) */
	public String getSpr() {
		return spr;
	}

	public void setSpr(String spr) {
		this.spr = spr;
	}

	/** @ 审批日期(sprq) */
	public Date getSprq() {
		return sprq;
	}

	public void setSprq(Date sprq) {
		this.sprq = sprq;
	}

	/** @ 请求撤控标识(qqckbs) */
	public String getQqckbs() {
		return qqckbs;
	}

	public void setQqckbs(String qqckbs) {
		this.qqckbs = qqckbs;
	}

	/** @ 撤控标识(ckbs) */
	public String getCkbs() {
		return ckbs;
	}

	public void setCkbs(String ckbs) {
		this.ckbs = ckbs;
	}

	/** @ 撤控原因(ckyy) */
	public String getCkyy() {
		return ckyy;
	}

	public void setCkyy(String ckyy) {
		this.ckyy = ckyy;
	}

	/** @ 撤控时间(cksj) */
	public Date getCksj() {
		return cksj;
	}

	public void setCksj(Date cksj) {
		this.cksj = cksj;
	}

	/** @ 撤控人(ckr) */
	public String getCkr() {
		return ckr;
	}

	public void setCkr(String ckr) {
		this.ckr = ckr;
	}

	/** @ 撤控操作员(ckczy) */
	public String getCkczy() {
		return ckczy;
	}

	public void setCkczy(String ckczy) {
		this.ckczy = ckczy;
	}

	/** @ 撤控操作时间(ckczsj) */
	public Date getCkczsj() {
		return ckczsj;
	}

	public void setCkczsj(Date ckczsj) {
		this.ckczsj = ckczsj;
	}

	/** @ 撤控部门编码(ckbmbm) */
	public String getCkbmbm() {
		return ckbmbm;
	}

	public void setCkbmbm(String ckbmbm) {
		this.ckbmbm = ckbmbm;
	}

	/** @ 撤控部门名称(ckbmmc) */
	public String getCkbmmc() {
		return ckbmmc;
	}

	public void setCkbmmc(String ckbmmc) {
		this.ckbmmc = ckbmmc;
	}

	/** @ 撤控审批单位(ckspdw) */
	public String getCkspdw() {
		return ckspdw;
	}

	public void setCkspdw(String ckspdw) {
		this.ckspdw = ckspdw;
	}

	/** @ 撤控审批人(ckspr) */
	public String getCkspr() {
		return ckspr;
	}

	public void setCkspr(String ckspr) {
		this.ckspr = ckspr;
	}

	/** @ 撤控审批意见(ckspyj) */
	public String getCkspyj() {
		return ckspyj;
	}

	public void setCkspyj(String ckspyj) {
		this.ckspyj = ckspyj;
	}

	/** @ 撤控审批日期(cksprq) */
	public Date getCksprq() {
		return cksprq;
	}

	public void setCksprq(Date cksprq) {
		this.cksprq = cksprq;
	}

	/** @ 行政区划(xzqh) */
	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	/** @ 发送标识(fsbs) */
	public String getFsbs() {
		return fsbs;
	}

	public void setFsbs(String fsbs) {
		this.fsbs = fsbs;
	}

	/** @ 布控对象照片(bkdxzp) */
	public byte[] getBkdxzp() {
		return bkdxzp;
	}

	public void setBkdxzp(byte[] bkdxzp) {
		this.bkdxzp = bkdxzp;
	}

	/** 分页排序 */
	public String getPageSort() {
		return pageSort;
	}

	public void setPageSort(String pageSort) {
		this.pageSort = pageSort;
	}

	public Date getBkczsj2() {
		return bkczsj2;
	}

	public void setBkczsj2(Date bkczsj2) {
		this.bkczsj2 = bkczsj2;
	}

	public Date getCsrq2() {
		return csrq2;
	}

	public void setCsrq2(Date csrq2) {
		this.csrq2 = csrq2;
	}

	public String getFileload() {
		return fileload;
	}

	public void setFileload(String fileload) {
		this.fileload = fileload;
	}

	public String getBkrylx() {
		return bkrylx;
	}

	public void setBkrylx(String bkrylx) {
		this.bkrylx = bkrylx;
	}

	public String getBkrylxdm() {
		return bkrylxdm;
	}

	public void setBkrylxdm(String bkrylxdm) {
		this.bkrylxdm = bkrylxdm;
	}

	public String getGj() {
		return gj;
	}

	public void setGj(String gj) {
		this.gj = gj;
	}

	public String getGjdm() {
		return gjdm;
	}

	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
	}

	public String getYwm() {
		return ywm;
	}

	public void setYwm(String ywm) {
		this.ywm = ywm;
	}

	public String getYwx() {
		return ywx;
	}

	public void setYwx(String ywx) {
		this.ywx = ywx;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getZjlx() {
		return zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	public String getZwm() {
		return zwm;
	}

	public void setZwm(String zwm) {
		this.zwm = zwm;
	}

	public String getZjlxdm() {
		return zjlxdm;
	}

	public void setZjlxdm(String zjlxdm) {
		this.zjlxdm = zjlxdm;
	}

	public String getDeptLeve() {
		return deptLeve;
	}

	public void setDeptLeve(String deptLeve) {
		this.deptLeve = deptLeve;
	}

	public String getSfxysh() {
		return sfxysh;
	}

	public void setSfxysh(String sfxysh) {
		this.sfxysh = sfxysh;
	}

	public String getShsftg() {
		return shsftg;
	}

	public void setShsftg(String shsftg) {
		this.shsftg = shsftg;
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

	
}
