package com.aisino2.techsupport.domain;

import java.util.Date;

public class Recipient {
	//收件人姓名
	private String rName;
	//收件人地址
	private String rAddress;
	//技术支持单编号
	private String st_NO;
	//最后操作时间
	private Date lastEditTime;
	
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	public String getSt_NO() {
		return st_NO;
	}
	public void setSt_NO(String st_NO) {
		this.st_NO = st_NO;
	}
	public Date getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	

}
