package com.aisino2.publicsystem.domain;

import com.aisino2.core.domain.BaseObject;
/**
 * 企业帐号同步
 * @author mds
 *
 */
public class Qyzhtb   {
	
	private String qybm;
	private String cwxx;
	private Integer cwbz;
	public String getQybm() {
		return qybm;
	}
	public void setQybm(String qybm) {
		if(qybm!=null &&!"".equals(qybm))
			this.qybm = qybm.toUpperCase();
		else 
			this.qybm = qybm;
	}
	public String getCwxx() {
		return cwxx;
	}
	public void setCwxx(String cwxx) {
		this.cwxx = cwxx;
	}
	public Integer getCwbz() {
		return cwbz;
	}
	public void setCwbz(Integer cwbz) {
		this.cwbz = cwbz;
	} 
	
	

}
