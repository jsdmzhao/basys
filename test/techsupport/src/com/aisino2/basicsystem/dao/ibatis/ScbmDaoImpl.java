package com.aisino2.basicsystem.dao.ibatis;

import java.util.Map;

import com.aisino2.basicsystem.dao.IScbmDao;
import com.aisino2.core.dao.BaseDao;


public class ScbmDaoImpl  extends BaseDao implements IScbmDao {

	/**
	 * 获得从业人员编号
	 * @return
	 */
	public String getScbm(Map map){
		this.queryForObject("getScbm", map);
		return (String)map.get("p_scbm");
	}

}
