package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGzdx_kzDao;
import com.aisino2.basicsystem.domain.Gzdx_kz;
import com.aisino2.basicsystem.service.IGzdx_kzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class Gzdx_kzServiceImpl extends BaseService implements IGzdx_kzService {

	private IGzdx_kzDao gzdx_kzDao;

	/** @param 关注对象快照(t_gzdx_kz) 增加 */
	public Gzdx_kz insertGzdx_kz(Gzdx_kz gzdx_kz){
		// TODO: implement
		return (Gzdx_kz)gzdx_kzDao.insertGzdx_kz(gzdx_kz);
	}

	/** @param 关注对象快照(t_gzdx_kz) 删除 */
	public boolean deleteGzdx_kz(Gzdx_kz gzdx_kz){
		// TODO: implement
		return gzdx_kzDao.deleteGzdx_kz(gzdx_kz)>0;
	}

	/** @param 关注对象快照(t_gzdx_kz) 修改 */
	public boolean updateGzdx_kz(Gzdx_kz gzdx_kz){
		// TODO: implement
		return gzdx_kzDao.updateGzdx_kz(gzdx_kz)>0;
	}

	/** @param 关注对象快照(t_gzdx_kz) 查询单条 */
	public Gzdx_kz getGzdx_kz(Gzdx_kz gzdx_kz){
		// TODO: implement
		return (Gzdx_kz)gzdx_kzDao.getGzdx_kz(gzdx_kz);
	}

	/** @param 关注对象快照(t_gzdx_kz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return gzdx_kzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 关注对象快照(t_gzdx_kz) 多条查询 */
	public List getListGzdx_kz(Gzdx_kz gzdx_kz){
		// TODO: implement
		return gzdx_kzDao.getListGzdx_kz(gzdx_kz);
	}

	public IGzdx_kzDao getGzdx_kzDao() {
		return gzdx_kzDao;
	}

	public void setGzdx_kzDao(IGzdx_kzDao gzdx_kzDao) {
		this.gzdx_kzDao = gzdx_kzDao;
	}

	public Gzdx_kz insertGzdx_kzBDBJ(Gzdx_kz gzdxKz) {
		return gzdx_kzDao.insertGzdx_kzBDBJ(gzdxKz);
	}
}
