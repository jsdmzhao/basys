package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IGlobalparDao;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.service.IGlobalparService;

public class GlobalparServiceImpl extends BaseService implements IGlobalparService {

	private IGlobalparDao globalparDao;
	
	/** @param 全局参数(t_globalpar) 增加*/
	public Globalpar insertGlobalpar(Globalpar globalpar){
		// TODO: implement
		return (Globalpar)globalparDao.insertCacheGlobalpar(globalpar);
	}
	
	/** @param 全局参数(t_globalpar) 删除*/
	public boolean deleteGlobalpar(Globalpar globalpar){
		// TODO: implement
		return globalparDao.deleteCacheGlobalpar(globalpar)>0;
	}
	
	/** @param 全局参数(t_globalpar) 修改*/
	public boolean updateGlobalpar(Globalpar globalpar){
		// TODO: implement
		return globalparDao.updateCacheGlobalpar(globalpar)>0;
	}

	/** @param 全局参数(t_globalpar) 查询单条 */
	public Globalpar getGlobalpar(Globalpar globalpar){
		// TODO: implement
		return (Globalpar)globalparDao.getGlobalpar(globalpar);
	}

	/** @param 全局参数(t_globalpar) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return globalparDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 全局参数(t_globalpar) 多条查询 */
	public List getListGlobalpar(Globalpar globalpar){
		// TODO: implement
		return globalparDao.getListGlobalpar(globalpar);
	}

	public IGlobalparDao getGlobalparDao() {
		return globalparDao;
	}

	public void setGlobalparDao(IGlobalparDao globalparDao) {
		this.globalparDao = globalparDao;
	}
}
