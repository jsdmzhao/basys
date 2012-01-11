package com.aisino2.techsupport.service;

import com.aisino2.techsupport.domain.SupportTicket;

public interface ArchiveSerivce {
	
	/**
	 * 归档结单
	 * @param st 技术支持单 
	 * @param taskId 任务号
	 */
	void inserArchive(String taskId,SupportTicket st);
}
