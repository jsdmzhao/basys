package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IClxxry_zpDao;
import com.aisino2.publicsystem.domain.Clxxry_zp;
import com.aisino2.publicsystem.service.IClxxry_zpService;

public class Clxxry_zpServiceImpl extends BaseService implements IClxxry_zpService {

	private IClxxry_zpDao clxxry_zpDao;

	/** @param 车辆信息人员_照片(t_clxxry_zp) 增加 */
	public Clxxry_zp insertClxxry_zp(Clxxry_zp clxxry_zp){
		// TODO: implement
		return (Clxxry_zp)clxxry_zpDao.insertClxxry_zp(clxxry_zp);
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 删除 */
	public boolean deleteClxxry_zp(Clxxry_zp clxxry_zp){
		// TODO: implement
		return clxxry_zpDao.deleteClxxry_zp(clxxry_zp)>0;
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 修改 */
	public boolean updateClxxry_zp(Clxxry_zp clxxry_zp){
		// TODO: implement
		return clxxry_zpDao.updateClxxry_zp(clxxry_zp)>0;
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 查询单条 */
	public Clxxry_zp getClxxry_zp(Clxxry_zp clxxry_zp){
		// TODO: implement
		return (Clxxry_zp)clxxry_zpDao.getClxxry_zp(clxxry_zp);
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return clxxry_zpDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 车辆信息人员_照片(t_clxxry_zp) 多条查询 */
	public List getListClxxry_zp(Clxxry_zp clxxry_zp){
		// TODO: implement
		return clxxry_zpDao.getListClxxry_zp(clxxry_zp);
	}

	public IClxxry_zpDao getClxxry_zpDao() {
		return clxxry_zpDao;
	}

	public void setClxxry_zpDao(IClxxry_zpDao clxxry_zpDao) {
		this.clxxry_zpDao = clxxry_zpDao;
	}
}
