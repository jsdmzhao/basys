package com.aisino2.techsupport.dao;

import com.aisino2.techsupport.domain.SmsBoxSending;

/**
 *
 * 短信发件箱 数据层
 */
public interface ISmsBoxSendingDao {
	/**
	 * 插入
	 * @param sms
	 */
	void insert(SmsBoxSending sms);
	
}
