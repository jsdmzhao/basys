package com.aisino2.techsupport.dao;

import java.util.List;
import java.util.Map;

import org.drools.lang.dsl.DSLMapParser.mapping_file_return;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.domain.SupportTicket;

public interface SupportTicketDao {
	SupportTicket insertSupportTicket(SupportTicket st);
	int updateSupportTicket(SupportTicket st);
	int deleteSupportTicket(SupportTicket st);
	List<SupportTicket> getListSupportTickets(SupportTicket st);
	SupportTicket getSupportTicket(SupportTicket st);
	Page getSupportTicketListForPage(Map<String, Object> map,int pageno,int pagesize,String sort , String desc);
}
