package com.aisino2.publicsystem.dao.ibatis;

import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.publicsystem.dao.IQyZrsProcDao;


public class QyZrsProcDaoImpl  extends BaseDao implements IQyZrsProcDao {
	/**
	 * 计算场所总人数
	 * @return
	 */
	public void updateQyzrs(Map map){
		this.queryForObject("updateQyzrs", map);
	} 

}
