package com.aisino2.tjfx.dao.ibatis;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.tjfx.dao.ITjfxDao;

public class TjfxDaoImpl extends BaseDao implements ITjfxDao {
	/** @param  */
	public void insertPublicsystem() {
		// TODO: implement		
		this.getSqlMapClientTemplate().insert("insertPublicsystem");
	}

	/** @param  */
	public void insertIcksystem() {
		// TODO: implement		
		this.getSqlMapClientTemplate().insert("insertIcksystem");
	}

	/** @param  */
	public void insertMansys() {
		// TODO: implement		
		this.getSqlMapClientTemplate().insert("insertMansys");
	}
	
	/** @param  */
	public void updateIckh() {
		// TODO: implement		
		this.getSqlMapClientTemplate().insert("updateIckh");
	}
	

}

