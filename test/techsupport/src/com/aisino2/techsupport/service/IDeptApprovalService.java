package com.aisino2.techsupport.service;

import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;


/**
 *
 * 单位审核服务
 *
 */
public interface IDeptApprovalService {
	void insertDeptApproval(String taskId, SupportTicket st,Tracking tracking);
}
