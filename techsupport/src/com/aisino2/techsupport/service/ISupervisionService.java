package com.aisino2.techsupport.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.techsupport.domain.Supervision;

public interface ISupervisionService {
	void insert_supervision(Supervision supervision);
	Page query_supervision_for_page(Map map, int pageno, int pagesize, String dir, String sort);
	Supervision get_supervision(Supervision supervision);
	List<Supervision> query_supervision(Supervision supervision);
}
