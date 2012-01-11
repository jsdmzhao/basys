package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

public class SendIckInfoWs  {
	private int ickslid; //制卡记录编号   icksl
	private String cjdbm;//采集点编码  t_cyryxx
	private String cjdmc;//采集点名称 t_cyryxx
	private String cjr;//采集人 t_cyryxx
	private String ickslh  ;//从业人员卡号---ick受理号  icksl
	private String xingming   ;//从业人员姓名
	private String xb; //从业人员性别 code
	private String ywm;///从业人员英文名
	private String ywx;//从业人员英文性
	private Date csrq;//从业人员出生日期
	private byte[] wjnr=null;//照片内容；t_cyry_zp
	private String gj;//国籍代码；
	private String minzu; //民族代码
	private String hjsx;//从业人员户籍所在地行政区划代码
    private String hjdxz;//从业人员户籍所在详细地址
    private String  zjhm ;//身份号
	private String zzzhm; //暂住证
	private String xzd; //从业人员住址
	private String wgrjyxkz ; //外国人就业许可证号 t_wgcyryxx
	private String cyrylb;//从业人员类别代码
	private Date yxsksrq ; //有效期开始日期��Ч�ڿ�ʼ����
	private Date yxqhzrq;  //有效期截至日期
	private String beizhu; //备注
	private String zkztbs; //制卡状态标识
	private Integer qyid;
	private Integer ryid;

	public Integer getRyid() {
		return ryid;
	}
	public void setRyid(Integer ryid) {
		this.ryid = ryid;
	}
	
	private Zzzxsc zzzxsc=null;
	public Zzzxsc getZzzxsc() {
		return zzzxsc;
	}
	public void setZzzxsc(Zzzxsc zzzxsc) {
		this.zzzxsc = zzzxsc;
	}
	public String getZkztbs() {
		return zkztbs;
	}
	public void setZkztbs(String zkztbs) {
		this.zkztbs = zkztbs;
	}
	private  Date fszkzxsj; //发送制卡中心时间
		private  Date jszkzxsj   ;//接受制卡中心时间
		private  String cyrybh    ;//从业人员编号
	 
	public String getCyrybh() {
			return cyrybh;
		}
		public void setCyrybh(String cyrybh) {
			this.cyrybh = cyrybh;
		}
	public int getIckslid() {
		return ickslid;
	}
	public void setIckslid(int ickslid) {
		this.ickslid = ickslid;
	}
	public String getCjdbm() {
		return cjdbm;
	}
	public void setCjdbm(String cjdbm) {
		this.cjdbm = cjdbm;
	}
	public String getCjdmc() {
		return cjdmc;
	}
	public void setCjdmc(String cjdmc) {
		this.cjdmc = cjdmc;
	}
	public String getCjr() {
		return cjr;
	}
	public void setCjr(String cjr) {
		this.cjr = cjr;
	}
	public String getIckslh() {
		return ickslh;
	}
	public void setIckslh(String ickslh) {
		this.ickslh = ickslh;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
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
	public Date getCsrq() {
		return csrq;
	}
	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}
	public byte[] getWjnr() {
		return wjnr;
	}
	public void setWjnr(byte[] wjnr) {
		this.wjnr = wjnr;
	}
	public String getGj() {
		return gj;
	}
	public void setGj(String gj) {
		this.gj = gj;
	}
	public String getMinzu() {
		return minzu;
	}
	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}
	public String getHjsx() {
		return hjsx;
	}
	public void setHjsx(String hjsx) {
		this.hjsx = hjsx;
	}
	public String getHjdxz() {
		return hjdxz;
	}
	public void setHjdxz(String hjdxz) {
		this.hjdxz = hjdxz;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getZzzhm() {
		return zzzhm;
	}
	public void setZzzhm(String zzzhm) {
		this.zzzhm = zzzhm;
	}
	public String getXzd() {
		return xzd;
	}
	public void setXzd(String xzd) {
		this.xzd = xzd;
	}
	public String getWgrjyxkz() {
		return wgrjyxkz;
	}
	public void setWgrjyxkz(String wgrjyxkz) {
		this.wgrjyxkz = wgrjyxkz;
	}
	public String getCyrylb() {
		return cyrylb;
	}
	public void setCyrylb(String cyrylb) {
		this.cyrylb = cyrylb;
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
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public Date getFszkzxsj() {
		return fszkzxsj;
	}
	public void setFszkzxsj(Date fszkzxsj) {
		this.fszkzxsj = fszkzxsj;
	}
	public Date getJszkzxsj() {
		return jszkzxsj;
	}
	public void setJszkzxsj(Date jszkzxsj) {
		this.jszkzxsj = jszkzxsj;
	}
	public Integer getQyid() {
		return qyid;
	}
	public void setQyid(Integer qyid) {
		this.qyid = qyid;
	}
}
