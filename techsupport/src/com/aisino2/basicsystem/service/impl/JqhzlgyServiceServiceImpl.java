package com.aisino2.basicsystem.service.impl;

import java.util.Map;

import com.aisino2.basicsystem.dao.IJqhzlgyDao;
import com.aisino2.basicsystem.domain.Jqhzlgy;
import com.aisino2.basicsystem.service.IJqhzlgyService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class JqhzlgyServiceServiceImpl extends BaseService implements IJqhzlgyService{

	private IJqhzlgyDao jqhzlgyDao;

	public void setJqhzlgyDao(IJqhzlgyDao jqhzlgyDao) {
		this.jqhzlgyDao = jqhzlgyDao;
	}

	public Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {
		return jqhzlgyDao.getListForPage(map, pageNo, pageSize, sort, desc);
	}
	/**
	public List getListZtxx(Map map,String sort,String desc){
		// TODO: implement
		return ztxxDao.getListZtxx(map,sort,desc);
	}
	 **/
	public Jqhzlgy getJqhzlgyTotalNum(Map map){
		return jqhzlgyDao.getJqhzlgyTotalNum(map);
	}
    
	
}