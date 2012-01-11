package com.aisino2.techsupport.domain;

import java.util.Date;

import com.aisino2.core.domain.BaseObject;
import com.aisino2.sysadmin.domain.User;

public class Tracking  {
	private Integer id;
	private Date trackingDate;
	private String newProcess;
	private User processor;
	private Integer stId;
	private String type;
	
	//for page
	private Integer processorId;
	private String processorName;
	private Date trackingDateFrom;
	private Date trackingDateTo;
	
	//审核标识
	private String approvalCode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTrackingDate() {
		return trackingDate;
	}
	public void setTrackingDate(Date trackingDate) {
		this.trackingDate = trackingDate;
	}
	public String getNewProcess() {
		return newProcess;
	}
	public void setNewProcess(String newProcess) {
		this.newProcess = newProcess;
	}
	public User getProcessor() {
		return processor;
	}
	public void setProcessor(User processor) {
		this.processor = processor;
	}
	public Integer getStId() {
		return stId;
	}
	public void setStId(Integer stId) {
		this.stId = stId;
	}
	public Integer getProcessorId() {
		return processorId;
	}
	public void setProcessorId(Integer processorId) {
		this.processorId = processorId;
	}
	public String getProcessorName() {
		return processorName;
	}
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getApprovalCode() {
		return approvalCode;
	}
	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}
	public Date getTrackingDateFrom() {
		return trackingDateFrom;
	}
	public void setTrackingDateFrom(Date trackingDateFrom) {
		this.trackingDateFrom = trackingDateFrom;
	}
	public Date getTrackingDateTo() {
		return trackingDateTo;
	}
	public void setTrackingDateTo(Date trackingDateTo) {
		this.trackingDateTo = trackingDateTo;
	}
	

}
