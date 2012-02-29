package com.aisino2.techsupport.dao;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.domain.Supervision;

/**
 * 督办数据层
 *
 *
 */
public interface ISupervisionDao {
	void insert(Supervision supervision);
	Page query_for_page(Map map,int pageno, int pagesize, String dir, String sort);
	Supervision get(Supervision supervision);
	List<Supervision> query(Supervision supervision);
}
