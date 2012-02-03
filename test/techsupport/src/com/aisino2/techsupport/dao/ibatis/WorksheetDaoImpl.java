package com.aisino2.techsupport.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Dict_item;
import com.aisino2.techsupport.dao.WorksheetDao;

public class WorksheetDaoImpl extends BaseDao implements WorksheetDao {

	public List<Dict_item> get_region_with_userrole(Map user) {
		return this.queryForList("get_region_with_userrole", user);
	}

	public Page get_region_with_userrole_for_page(Map user, int pageNo,
			int pagesize, String dir, String sort) {
		String sCol="";
		if(sort == null)
			sort = "";
		else if(!sort.equals("asc") && !sort.equals("desc"))
			sort = " asc ";
		if (dir!=null){
			if(dir.equals("0"))
				sCol = " t.display_name "+ sort;
			else if(dir.equals("1"))
				sCol = " t.item_simplepin "+ sort;
			else if(dir.equals("2"))
				sCol = " t.item_allpin "+ sort;
			else if(dir.equals("3"))
				sCol = " t.fact_value "+ sort;
			else
				sCol = " t.display_name ";
		}else{
			sCol=" t.display_name ";
		}
		user.put("pageSort", sCol);
		
		return this.queryForPage("get_region_with_userrole_for_page", user,
				pageNo,pagesize);
	}


	public Page get_region_with_deptcode_for_page(Map map,int pageno, int pagesize,String dir, String sort) {
		String sCol="";
		if(sort == null)
			sort = "";
		else if(!sort.equals("asc") && !sort.equals("desc"))
			sort = " asc ";
		if (dir!=null){
			if(dir.equals("0"))
				sCol = " t.display_name "+ sort;
			else if(dir.equals("1"))
				sCol = " t.item_simplepin "+ sort;
			else if(dir.equals("2"))
				sCol = " t.item_allpin "+ sort;
			else if(dir.equals("3"))
				sCol = " t.fact_value "+ sort;
			else
				sCol = " t.display_name ";
		}else{
			sCol=" t.display_name ";
		}
		map.put("pageSort", sCol);
		
		return this.queryForPage("get_region_with_deptcode_for_page", map,
				pageno,pagesize);
	}

	public List<Dict_item> get_region_with_deptcode(Map map) {
		return this.queryForList("get_region_with_deptcode", map);
	}

}
