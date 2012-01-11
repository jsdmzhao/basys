package com.aisino2.basicsystem.dao.ibatis;

import com.aisino2.basicsystem.dao.IDpyDao;
import com.aisino2.basicsystem.domain.DoublePY;
import com.aisino2.core.dao.BaseDao;


public class DpyDaoImpl  extends BaseDao implements IDpyDao {

	/**
	 * 获得名字的双拼
	 * @return
	 */
	public String getDoublepy(DoublePY doublePY){
		DoublePY doublePY1 = (DoublePY)this.queryForObject("getDoublePY", doublePY);
		return (String)doublePY1.getDoublepy();
	}

}
