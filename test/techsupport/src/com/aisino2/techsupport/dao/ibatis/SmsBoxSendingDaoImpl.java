package com.aisino2.techsupport.dao.ibatis;

import org.springframework.stereotype.Component;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.techsupport.dao.ISmsBoxSendingDao;
import com.aisino2.techsupport.domain.SmsBoxSending;

/**
 * 短信发件箱实现
 *
 */
@Component
public class SmsBoxSendingDaoImpl extends TechSupportBaseDao implements ISmsBoxSendingDao {

	/* (non-Javadoc)
	 * @see com.aisino2.techsupport.dao.ISmsBoxSendingDao#insert(com.aisino2.techsupport.domain.SmsBoxSending)
	 */
	public void insert(SmsBoxSending sms) {
		sms.setId(this.getNextID("SMS_SEQ_MESSAGEID"));
		this.insert("SmsBoxSending.insert", sms);
	}

}
