package com.aisino2.techsupport.service;

import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;

public interface FeedbackService {
	/**
	 * 反馈环节 不与反馈
	 * @param taskId 任务号
	 * @param st 支持单
	 * @param tracking 进展
	 */
	void insertFeedbackAndGoback(String taskId,SupportTicket st, Tracking tracking);
	
	/**
	 * 反馈环节保存
	 * @param taskId 任务号
	 * @param st 支持单
	 * @param tracking 进展信息
	 */
	void insertFeedbackAndGo(String taskId,SupportTicket st,Tracking tracking);
}
