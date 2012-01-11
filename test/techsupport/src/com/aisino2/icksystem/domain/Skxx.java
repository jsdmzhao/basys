package com.aisino2.icksystem.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;

/**
 * 刷卡信息
 * 
 * @author z
 * 
 */
public class Skxx  {

	private String xm;// 姓名
	private String cyrybh;// 从业人员编号
	private Date sksj;// 刷卡时间
	private Date scsj;// 上传时间
	private String qybm;// 场所编码

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getCyrybh() {
		return cyrybh;
	}

	public void setCyrybh(String cyrybh) {
		this.cyrybh = cyrybh;
	}

	public Date getSksj() {
		return sksj;
	}

	public void setSksj(Date sksj) {
		this.sksj = sksj;
	}

	public Date getScsj() {
		return scsj;
	}

	public void setScsj(Date scsj) {
		this.scsj = scsj;
	}

	public String getQybm() {
		return qybm;
	}

	public void setQybm(String qybm) {
		this.qybm = qybm;
	}
}
