package com.aisino2.techsupport.service;

import com.aisino2.techsupport.domain.SupportTicket;

public interface ApplyService {
	void insertApplyAndGo(SupportTicket st);
	/**
	 * 检查支持单编号是否存在
	 * @param stNo 支持的编号
	 * @return true or false
	 */
	boolean checkStNoIsExist(String stNo);
}
