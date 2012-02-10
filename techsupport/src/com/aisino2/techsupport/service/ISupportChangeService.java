package com.aisino2.techsupport.service;

import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;
/**
 * 支持变更
 *
 *
 */
public interface ISupportChangeService {
	void change_support_department(String taskId,SupportTicket st,Tracking tracking);
	void change_support_leader(String taskId, SupportTicket st, Tracking tracking);
}
