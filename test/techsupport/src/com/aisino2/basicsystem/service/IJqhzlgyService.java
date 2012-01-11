package com.aisino2.basicsystem.service;

import java.util.Map;

import com.aisino2.basicsystem.domain.Jqhzlgy;
import com.aisino2.core.dao.Page;

public interface IJqhzlgyService {
	Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc);

	Jqhzlgy getJqhzlgyTotalNum(Map map);
	
	//List getListZtxx(Map map,String sort,String desc);
}
