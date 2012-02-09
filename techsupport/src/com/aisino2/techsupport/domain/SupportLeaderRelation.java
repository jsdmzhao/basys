package com.aisino2.techsupport.domain;

/**
 * 技术负责人关联
 *
 */
public class SupportLeaderRelation {
	private Integer stId;
	private Integer supportLeaderId;
	private Integer departid;
	
	public Integer getDepartid() {
		return departid;
	}
	public void setDepartid(Integer departid) {
		this.departid = departid;
	}
	public Integer getStId() {
		return stId;
	}
	public void setStId(Integer stId) {
		this.stId = stId;
	}
	public Integer getSupportLeaderId() {
		return supportLeaderId;
	}
	public void setSupportLeaderId(Integer supportLeaderId) {
		this.supportLeaderId = supportLeaderId;
	}
	
	
}
