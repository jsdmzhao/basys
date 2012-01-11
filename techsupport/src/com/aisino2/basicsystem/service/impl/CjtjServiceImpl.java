package com.aisino2.basicsystem.service.impl;

import java.util.Map;

import com.aisino2.basicsystem.dao.ICjtjDao;
import com.aisino2.basicsystem.domain.Cjtj;
import com.aisino2.basicsystem.service.ICjtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class CjtjServiceImpl extends BaseService implements ICjtjService {

	private ICjtjDao cjtjDao;

	public Page getListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {
		return cjtjDao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	public Cjtj getCjtjTotalNum(Map map) {
		return cjtjDao.getCjtjTotalNum(map);
	}

	public void setCjtjDao(ICjtjDao cjtjDao) {
		this.cjtjDao = cjtjDao;
	}

	public ICjtjDao getCjtjDao() {
		return cjtjDao;
	}
}