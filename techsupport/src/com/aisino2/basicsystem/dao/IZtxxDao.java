package com.aisino2.basicsystem.dao;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Ztxx;
import com.aisino2.core.dao.Page;

public interface IZtxxDao {
	Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc);

	Ztxx getZtxxTotalNum(Map map);
	
	List getListZtxx(Map map,String sort,String desc);
}
