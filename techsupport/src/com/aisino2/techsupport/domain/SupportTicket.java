package com.aisino2.techsupport.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aisino2.core.domain.BaseObject;
import com.aisino2.sysadmin.domain.Department;
import com.aisino2.sysadmin.domain.User;

public class SupportTicket {
	//支持单基本信息
	private String stNo;
	private User applicant;
	private String supportContent;
//	private User supportLeader;
//	@fixed 一个支持单指派多个负责人
	private List<User> lstSupportLeaders=new ArrayList<User>();
	private List<Department> supportDeptList;
	private Date devScheDate;
	private Date psgScheDate;
	private String stStatus;
	private String region;
	private Integer serialNumber;
	private Integer id;
	private Date devDsScheDate;
	private Date devDdScheDate;
	//新需求 技术开发部需要阶段时间，需要添加测试计划阶段
	private Date devDtScheDate;
	
	private Date psgDsScheDate;
	private Date psgIsScheDate;

	//
//	private String ceApprovalCode;
//	private String psgApprovalCode;
//	private String devApprovalCode;
	//追踪批复
	private Date psgCompDate;
	private Date devCompDate;
	private Date psgDsCompDate;
	private Date psgIsCompDate;
	private Date devDsCompDate;
	private Date devDdCompDate;
	//新需求 技术开发部需要阶段时间，需要添加测试完成阶段
	private Date devDtCompDate;
	private Date applyingFeedbackDate;
	
	//反馈确认
	private Date feedbackConfirmDate;
	
	//归档例外<旧舍弃>
	private String comments;
	private Date archiveDate;
	private User archiveUser;
	
	//进展与意见 ->>> 包含了总工批复等
	private List<Tracking> trackList;
//	用于查询的字段
//	当前进展
	private String trackingProcess;
//	区域名称
	private String regionName;
//	负责单位名称
	private String supportDeptName;
//	状态名称
	private String stStatusName;
//	申请人名称
	private String applicantName;
	private String checkbox;
	private String tag;
	private Integer applicantId;
	private String supportLeaderName;
	private Integer supportLeaderId;
	
	//附件信息
	private List<Attachment> attachment_list;

	//督办
	private List<Supervision> supervision_list;
	
	public List<Supervision> getSupervision_list() {
		return supervision_list;
	}
	public void setSupervision_list(List<Supervision> supervision_list) {
		this.supervision_list = supervision_list;
	}
	public String getStNo() {
		return stNo;
	}
	public void setStNo(String stNo) {
		this.stNo = stNo;
	}
	public String getSupportContent() {
		return supportContent;
	}
	public void setSupportContent(String supportContent) {
		this.supportContent = supportContent;
	}
	public Date getDevScheDate() {
		return devScheDate;
	}
	public void setDevScheDate(Date devScheDate) {
		this.devScheDate = devScheDate;
	}
	public Date getPsgScheDate() {
		return psgScheDate;
	}
	public void setPsgScheDate(Date psgScheDate) {
		this.psgScheDate = psgScheDate;
	}
	public String getStStatus() {
		return stStatus;
	}
	public void setStStatus(String stStatus) {
		this.stStatus = stStatus;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDevDsScheDate() {
		return devDsScheDate;
	}
	public void setDevDsScheDate(Date devDsScheDate) {
		this.devDsScheDate = devDsScheDate;
	}
	public Date getDevDdScheDate() {
		return devDdScheDate;
	}
	public void setDevDdScheDate(Date devDdScheDate) {
		this.devDdScheDate = devDdScheDate;
	}
	public Date getPsgDsScheDate() {
		return psgDsScheDate;
	}
	public void setPsgDsScheDate(Date psgDsScheDate) {
		this.psgDsScheDate = psgDsScheDate;
	}
	public Date getPsgIsScheDate() {
		return psgIsScheDate;
	}
	public void setPsgIsScheDate(Date psgIsScheDate) {
		this.psgIsScheDate = psgIsScheDate;
	}
	public Date getPsgCompDate() {
		return psgCompDate;
	}
	public void setPsgCompDate(Date psgCompDate) {
		this.psgCompDate = psgCompDate;
	}
	public Date getDevCompDate() {
		return devCompDate;
	}
	public void setDevCompDate(Date devCompDate) {
		this.devCompDate = devCompDate;
	}
	public Date getPsgDsCompDate() {
		return psgDsCompDate;
	}
	public void setPsgDsCompDate(Date psgDsCompDate) {
		this.psgDsCompDate = psgDsCompDate;
	}
	public Date getPsgIsCompDate() {
		return psgIsCompDate;
	}
	public void setPsgIsCompDate(Date psgIsCompDate) {
		this.psgIsCompDate = psgIsCompDate;
	}
	public Date getDevDsCompDate() {
		return devDsCompDate;
	}
	public void setDevDsCompDate(Date devDsCompDate) {
		this.devDsCompDate = devDsCompDate;
	}
	public Date getApplyingFeedbackDate() {
		return applyingFeedbackDate;
	}
	public void setApplyingFeedbackDate(Date applyingFeedbackDate) {
		this.applyingFeedbackDate = applyingFeedbackDate;
	}
	public Date getFeedbackConfirmDate() {
		return feedbackConfirmDate;
	}
	public void setFeedbackConfirmDate(Date feedbackConfirmDate) {
		this.feedbackConfirmDate = feedbackConfirmDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getArchiveDate() {
		return archiveDate;
	}
	public void setArchiveDate(Date archiveDate) {
		this.archiveDate = archiveDate;
	}
	public List<Tracking> getTrackList() {
		return trackList;
	}
	public void setTrackList(List<Tracking> trackList) {
		this.trackList = trackList;
	}
	public Date getDevDdCompDate() {
		return devDdCompDate;
	}
	public void setDevDdCompDate(Date devDdCompDate) {
		this.devDdCompDate = devDdCompDate;
	}
//	public String getCeApprovalCode() {
//		return ceApprovalCode;
//	}
//	public void setCeApprovalCode(String ceApprovalCode) {
//		this.ceApprovalCode = ceApprovalCode;
//	}
//	public String getPsgApprovalCode() {
//		return psgApprovalCode;
//	}
//	public void setPsgApprovalCode(String psgApprovalCode) {
//		this.psgApprovalCode = psgApprovalCode;
//	}
//	public String getDevApprovalCode() {
//		return devApprovalCode;
//	}
//	public void setDevApprovalCode(String devApprovalCode) {
//		this.devApprovalCode = devApprovalCode;
//	}
	public List<Department> getSupportDeptList() {
		return supportDeptList;
	}
	public void setSupportDeptList(List<Department> supportDeptList) {
		this.supportDeptList = supportDeptList;
	}
	public User getArchiveUser() {
		return archiveUser;
	}
	public void setArchiveUser(User archiveUser) {
		this.archiveUser = archiveUser;
	}
	public String getTrackingProcess() {
		return trackingProcess;
	}
	public void setTrackingProcess(String trackingProcess) {
		this.trackingProcess = trackingProcess;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
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
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public String getSupportLeaderName() {
		return supportLeaderName;
	}
	public void setSupportLeaderName(String supportLeaderName) {
		this.supportLeaderName = supportLeaderName;
	}
	public List<User> getLstSupportLeaders() {
		return lstSupportLeaders;
	}
	public void setLstSupportLeaders(List<User> lstSupportLeaders) {
		this.lstSupportLeaders = lstSupportLeaders;
	}
	public Integer getSupportLeaderId() {
		return supportLeaderId;
	}
	public void setSupportLeaderId(Integer supportLeaderId) {
		this.supportLeaderId = supportLeaderId;
	}
	public List<Attachment> getAttachment_list() {
		return attachment_list;
	}
	public void setAttachment_list(List<Attachment> attachment_list) {
		this.attachment_list = attachment_list;
	}
	public Date getDevDtScheDate() {
		return devDtScheDate;
	}
	public void setDevDtScheDate(Date devDtScheDate) {
		this.devDtScheDate = devDtScheDate;
	}
	public Date getDevDtCompDate() {
		return devDtCompDate;
	}
	public void setDevDtCompDate(Date devDtCompDate) {
		this.devDtCompDate = devDtCompDate;
	}
	
	
}
