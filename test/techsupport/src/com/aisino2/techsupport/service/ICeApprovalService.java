package com.aisino2.techsupport.service;

import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;

/**
 * 技术支持单总工批复环节服务
 *
 */
public interface ICeApprovalService {
	/**
	 * 添加总工审批信息
	 * @param taskId 支持单任务号
	 * @param st 支持单实体
	 * @param tracking 意见与追踪
	 */
	void insertCeApproval(String taskId,SupportTicket st, Tracking tracking);
}
