package com.aisino2.techsupport.domain;

import org.jbpm.pvm.internal.task.TaskImpl;


public class Worksheet {
	private TaskImpl task;
	private SupportTicket st;
	
	//------------------用于page------------------------------//
	private String taskId;//任务ID
	private String activityName;//环节名称
	private String formResourceName;//提交路径
	
	private String stNo;//支持单编号
	private String regionName;//地区名称
	private String applicantName="";//申请人名称
	private String supportLeaderName="";//技术负责人名称
	private String supportDeptName="";//技术负责单位名称
	private String stStatusName="";//支持单状态名称
	
	private String regionCode;//地区代码
	private Integer supportLeaderId;//技术负责人ID
	private String supportDeptCode;//技术负责单位代码
	private String stStatusCode;//支持单状态代码
	
	
	public TaskImpl getTask() {
		return task;
	}
	public void setTask(TaskImpl task) {
		this.task = task;
	}
	public SupportTicket getSt() {
		return st;
	}
	public void setSt(SupportTicket st) {
		this.st = st;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getStNo() {
		return stNo;
	}
	public void setStNo(String stNo) {
		this.stNo = stNo;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getSupportLeaderName() {
		return supportLeaderName;
	}
	public void setSupportLeaderName(String supportLeaderName) {
		this.supportLeaderName = supportLeaderName;
	}
	public String getSupportDeptName() {
		return supportDeptName;
	}
	public void setSupportDeptName(String supportDeptName) {
		this.supportDeptName = supportDeptName;
	}
	public String getStStatusName() {
		return stStatusName;
	}
	public void setStStatusName(String stStatusName) {
		this.stStatusName = stStatusName;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public Integer getSupportLeaderId() {
		return supportLeaderId;
	}
	public void setSupportLeaderId(Integer supportLeaderId) {
		this.supportLeaderId = supportLeaderId;
	}
	public String getSupportDeptCode() {
		return supportDeptCode;
	}
	public void setSupportDeptCode(String supportDeptCode) {
		this.supportDeptCode = supportDeptCode;
	}
	public String getStStatusCode() {
		return stStatusCode;
	}
	public void setStStatusCode(String stStatusCode) {
		this.stStatusCode = stStatusCode;
	}
	public String getFormResourceName() {
		return formResourceName;
	}
	public void setFormResourceName(String formResourceName) {
		this.formResourceName = formResourceName;
	}
	
	
}
