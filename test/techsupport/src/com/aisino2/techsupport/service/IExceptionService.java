package com.aisino2.techsupport.service;

import com.aisino2.techsupport.domain.SupportTicket;
import com.aisino2.techsupport.domain.Tracking;

/**
 * 
 *
 *
 */
public interface IExceptionService {
	void insertExceptionAndGo(String taskid,SupportTicket st, Tracking tracking);
	
}
