package com.aisino2.icksystem.service.impl;

import java.util.List;

import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IGzrztjDao;
import com.aisino2.icksystem.service.IGzrztjService;
import com.aisino2.publicsystem.domain.Qyyyrztj;

public class GzrztjServiceImpl extends BaseService implements IGzrztjService {

	private IGzrztjDao gzrztjDao;

	public IGzrztjDao getGzrztjDao() {
		return gzrztjDao;
	}

	public void setGzrztjDao(IGzrztjDao gzrztjDao) {
		this.gzrztjDao = gzrztjDao;
	}

	public List getListForPagePeop(Qyyyrztj qyyyrztj) {
		// TODO Auto-generated method stub
		return gzrztjDao.getListForPagePeop(qyyyrztj);
	}

	public List getListForPageUnit(Qyyyrztj qyyyrztj) {
		// TODO Auto-generated method stub
		return gzrztjDao.getListForPageUnit(qyyyrztj);
	}

	public Integer getPeopRows(Qyyyrztj qyyyrztj) {
		// TODO Auto-generated method stub
		return gzrztjDao.getPeopRows(qyyyrztj);
	}

	public Integer getUnitRows(Qyyyrztj qyyyrztj) {
		// TODO Auto-generated method stub
		return gzrztjDao.getUnitRows(qyyyrztj);
	}

}
