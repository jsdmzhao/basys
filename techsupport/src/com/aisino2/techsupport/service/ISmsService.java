package com.aisino2.techsupport.service;

import java.util.List;

import com.aisino2.sysadmin.domain.User;
import com.aisino2.techsupport.domain.SupportTicket;


public interface ISmsService {
	void sendSms(List<SupportTicket> lSt,String receivePhone,String senderName);
	String[] getSmsRoleStatus(User curUser);
}
