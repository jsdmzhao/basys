package com.aisino2.techsupport.domain;

import java.util.Date;

/**
 * 附件
 *
 */
public class Attachment {
//	主键
	private Integer attachmentId;
//	附件名称
	private String attachmentName;
//	附件备注
	private String attachmentComment;
//	附件大小
	private Long attachmentSize;
//	关联支持单ID
	private Integer stId;
//	附件内容
	private byte[] attachmentContent;
	private String tempPath;
	//附件类型
	private String attachmentContentType;
	//附件存放路径
	private String attachmentPath;
	
	//上传时间
	private Date uploadTime;
	//上传批号，通过批号确定上传的批次，把同批次的数据添加到业务数据表中
	private String batchNumber;
	
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public Integer getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getAttachmentComment() {
		return attachmentComment;
	}
	public void setAttachmentComment(String attachmentComment) {
		this.attachmentComment = attachmentComment;
	}
	public Integer getStId() {
		return stId;
	}
	public void setStId(Integer stId) {
		this.stId = stId;
	}
	public byte[] getAttachmentContent() {
		return attachmentContent;
	}
	public void setAttachmentContent(byte[] attachmentContent) {
		this.attachmentContent = attachmentContent;
	}
	public String getTempPath() {
		return tempPath;
	}
	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}
	public Long getAttachmentSize() {
		return attachmentSize;
	}
	public void setAttachmentSize(Long attachmentSize) {
		this.attachmentSize = attachmentSize;
	}
	public String getAttachmentContentType() {
		return attachmentContentType;
	}
	public void setAttachmentContentType(String attachmentContentType) {
		this.attachmentContentType = attachmentContentType;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	
}
