package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IClxx_zpDao;
import com.aisino2.publicsystem.domain.Clxx_zp;
import com.aisino2.publicsystem.service.IClxx_zpService;

public class Clxx_zpServiceImpl extends BaseService implements IClxx_zpService {

	private IClxx_zpDao clxx_zpDao;

	/** @param 车辆信息_照片(t_clxx_zp) 增加 */
	public Clxx_zp insertClxx_zp(Clxx_zp clxx_zp){
		// TODO: implement
		return (Clxx_zp)clxx_zpDao.insertClxx_zp(clxx_zp);
	}

	/** @param 车辆信息_照片(t_clxx_zp) 删除 */
	public boolean deleteClxx_zp(Clxx_zp clxx_zp){
		// TODO: implement
		return clxx_zpDao.deleteClxx_zp(clxx_zp)>0;
	}

	/** @param 车辆信息_照片(t_clxx_zp) 修改 */
	public boolean updateClxx_zp(Clxx_zp clxx_zp){
		// TODO: implement
		return clxx_zpDao.updateClxx_zp(clxx_zp)>0;
	}

	/** @param 车辆信息_照片(t_clxx_zp) 查询单条 */
	public Clxx_zp getClxx_zp(Clxx_zp clxx_zp){
		// TODO: implement
		return (Clxx_zp)clxx_zpDao.getClxx_zp(clxx_zp);
	}

	/** @param 车辆信息_照片(t_clxx_zp) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return clxx_zpDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 车辆信息_照片(t_clxx_zp) 多条查询 */
	public List getListClxx_zp(Clxx_zp clxx_zp){
		// TODO: implement
		return clxx_zpDao.getListClxx_zp(clxx_zp);
	}
	
	/** @param 车辆信息_照片(t_clxx_zp) 多条查询(无照片)  */
	public List getListClxx_zpNoTp(Clxx_zp clxx_zp){
		// TODO: implement
		return clxx_zpDao.getListClxx_zpNoTp(clxx_zp);
	}

	public IClxx_zpDao getClxx_zpDao() {
		return clxx_zpDao;
	}

	public void setClxx_zpDao(IClxx_zpDao clxx_zpDao) {
		this.clxx_zpDao = clxx_zpDao;
	}
}
