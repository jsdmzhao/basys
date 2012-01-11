package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IZtxxDao;
import com.aisino2.basicsystem.domain.Ztxx;
import com.aisino2.basicsystem.service.IZtxxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class ZtxxServiceImpl extends BaseService implements IZtxxService {

	private IZtxxDao ztxxDao;

	public Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {
		return ztxxDao.getListForPage(map, pageNo, pageSize, sort, desc);
	}
	
	public List getListZtxx(Map map,String sort,String desc){
		// TODO: implement
		return ztxxDao.getListZtxx(map,sort,desc);
	}
	
	public Ztxx getZtxxTotalNum(Map map) {
		return ztxxDao.getZtxxTotalNum(map);
	}

	public void setZtxxDao(IZtxxDao ztxxDao) {
		this.ztxxDao = ztxxDao;
	}

	public IZtxxDao getZtxxDao() {
		return ztxxDao;
	}
}