package com.aisino2.techsupport.dao;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Dict_item;

public interface WorksheetDao {
	List<Dict_item> get_region_with_userrole(Map user);
	Page get_region_with_userrole_for_page(Map user,int pageno, int pagesize,String dir, String sort);
	List<Dict_item> get_region_with_deptcode(Map map);
	Page get_region_with_deptcode_for_page(Map map, int pageno, int pagesize,String dir, String sort);
	
	Page getWorksheetTaskForPage(Map<String, Object> map, int pageno, int pagesize, String dir, String sort);
}
