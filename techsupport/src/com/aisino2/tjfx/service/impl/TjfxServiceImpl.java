package com.aisino2.tjfx.service.impl;

import com.aisino2.core.service.BaseService;
import com.aisino2.tjfx.dao.ITjfxDao;
import com.aisino2.tjfx.service.ITjfxService;


public class TjfxServiceImpl extends BaseService implements ITjfxService {

	private ITjfxDao tjfxDao;

	/** @param  */
	public void insertPublicsystem() {
		// TODO: implement		
		tjfxDao.insertPublicsystem();
	}

	/** @param  */
	public void insertIcksystem() {
		// TODO: implement		
		tjfxDao.insertIcksystem();
	}
	
	/** @param  */
	public void insertMansys() {
		// TODO: implement		
		tjfxDao.insertMansys();
	}
	
	/** @param  */
	public void updateIckh() {
		// TODO: implement		
		tjfxDao.updateIckh();
	}

	public void setTjfxDao(ITjfxDao tjfxDao) {
		this.tjfxDao = tjfxDao;
	}
	
	
}
