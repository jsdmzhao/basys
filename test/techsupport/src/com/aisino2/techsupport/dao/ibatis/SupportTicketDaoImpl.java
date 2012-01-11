package com.aisino2.techsupport.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.dao.SupportTicketDao;
import com.aisino2.techsupport.domain.SupportTicket;

@Component("SupportTicketDaoImpl")
public class SupportTicketDaoImpl extends TechSupportBaseDao implements SupportTicketDao {


	public int updateSupportTicket(SupportTicket st) {
		return update("SupportTicket.update",st);
	}

	public int deleteSupportTicket(SupportTicket st) {
		return delete("SupportTicket.delete", st);
	}

	@SuppressWarnings("unchecked")
	public List<SupportTicket> getListSupportTickets(SupportTicket st) {
		return queryForList("SupportTicket.getList", st);
	}

	public SupportTicket getSupportTicket(SupportTicket st) {
		return (SupportTicket) queryForObject("SupportTicket.get", st);
	}

	public SupportTicket insertSupportTicket(SupportTicket st) {
		st.setId(getNextID("SEQ_TS_ST"));
		insert("SupportTicket.insert", st);
		return st;
	}


	public Page getSupportTicketListForPage(Map<String, Object> map,
			int pageno, int pagesize, String sort, String desc) {
		
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " t.st_no "+ desc;
			else if(sort.equals("1"))
				sCol = " t.region "+ desc;
			else if(sort.equals("2"))
				sCol = " t.applicant "+ desc;
			else if(sort.equals("3"))
				sCol = " ssmap.sl_id "+ desc;
			else
				sCol = " t.st_no ";
		}else{
			sCol=" t.st_no ";
		}
		map.put("pageSort", sCol);
		return this.queryForPage("SupportTicket.getListForPage", map, pageno, pagesize);
	}
	
}
