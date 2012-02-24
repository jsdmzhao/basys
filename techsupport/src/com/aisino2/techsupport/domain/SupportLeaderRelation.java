package com.aisino2.techsupport.domain;

import java.util.List;

/**
 * 技术负责人关联
 *
 */
public class SupportLeaderRelation {
	private Integer stId;
	private Integer supportLeaderId;
	private Integer departid;
	
	private List<Integer> deleteNotDepartid;
	
	public List<Integer> getDeleteNotDepartid() {
		return deleteNotDepartid;
	}
	public void setDeleteNotDepartid(List<Integer> deleteNotDepartid) {
		this.deleteNotDepartid = deleteNotDepartid;
	}
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
