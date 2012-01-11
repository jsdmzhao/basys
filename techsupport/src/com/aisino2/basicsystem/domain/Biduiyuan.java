package com.aisino2.basicsystem.domain;

import com.aisino2.core.domain.BaseObject;
/**
 * 比对源
 *
 */
public class Biduiyuan  
{
	private String xingming;//比对源姓名
	private String zhengjianhm;//证件号码
	private String dir;//比对源位置，对文件则为其路径
	private String hylb;//行业类别
	private String base64;//比对源文件base64编码
	
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getZhengjianhm() {
		return zhengjianhm;
	}
	public void setZhengjianhm(String zhengjianhm) {
		this.zhengjianhm = zhengjianhm;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getHylb() {
		return hylb;
	}
	public void setHylb(String hylb) {
		this.hylb = hylb;
	}
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	
	
}
