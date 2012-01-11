package com.aisino2.basicsystem.service.impl;

import com.aisino2.basicsystem.dao.IDpyDao;
import com.aisino2.basicsystem.domain.DoublePY;
import com.aisino2.basicsystem.service.IDpyService;
import com.aisino2.core.service.BaseService;

public class DpyServiceImpl extends BaseService implements IDpyService {

	private IDpyDao dpyDao;
	
	/**
	 * 获得名字的双拼
	 * @return
	 */
	public String getDoublepy(DoublePY doublePY){
		
		return dpyDao.getDoublepy(doublePY);
	}

	public void setDpyDao(IDpyDao dpyDao) {
		this.dpyDao = dpyDao;
	}

	


}
