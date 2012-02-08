package com.aisino2.techsupport.dao.ibatis;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.dao.ISupervisionDao;
import com.aisino2.techsupport.domain.Supervision;

@Component("SupervisionDaoImpl")
public class SupervisionDaoImpl extends TechSupportBaseDao implements
		ISupervisionDao {

	public void insert(Supervision supervision) {
		supervision.setId(this.getNextID("seq_ts_supervision"));
		this.insert("supervision.insert", supervision);
	}

	public Page query_for_page(Map map, int pageno, int pagesize, String dir,
			String sort) {
		
		String sCol="";
		if(sort == null)
			sort = "";
		else if(!sort.equals("asc") && !sort.equals("desc"))
			sort = " asc ";
		if (dir!=null){
			if(dir.equals("0"))
				sCol = " u.username "+ sort;
			else if(dir.equals("1"))
				sCol = " t.supervision_suggestion "+ sort;
			else if(dir.equals("2"))
				sCol = " t.supervision_date "+ sort;
			else
				sCol = " u.username ";
		}else{
			sCol=" u.username ";
		}
		map.put("pageSort", sCol);
		
		return this.queryForPage("supervision.query_for_page", map, pageno,pagesize);
	}

	public Supervision get(Supervision supervision) {
		return (Supervision) this.queryForObject("supervision.get", supervision);
	}

}
