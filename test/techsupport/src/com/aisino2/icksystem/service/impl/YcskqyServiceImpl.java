package com.aisino2.icksystem.service.impl;

import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IYcskqyDao;
import com.aisino2.icksystem.service.IYcskqyService;

public class YcskqyServiceImpl extends BaseService implements IYcskqyService {

	private IYcskqyDao ycskqyDao;
	public Page getSkxx(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		
		return ycskqyDao.getSkxx(map, pageNo, pageSize, sort, desc);
	}

	public Page getYcskqy(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		
		return ycskqyDao.getYcskqy(map, pageNo, pageSize, sort, desc);
	}

	public IYcskqyDao getYcskqyDao() {
		return ycskqyDao;
	}

	public void setYcskqyDao(IYcskqyDao ycskqyDao) {
		this.ycskqyDao = ycskqyDao;
	}

}
