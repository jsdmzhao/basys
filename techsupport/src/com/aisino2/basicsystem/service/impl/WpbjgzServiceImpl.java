package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IWpbjgzDao;
import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.basicsystem.service.IWpbjgzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class WpbjgzServiceImpl extends BaseService implements IWpbjgzService {

	private IWpbjgzDao wpbjgzDao;

	/** @param 物品报警规则(t_wpbjgz) 增加 */
	public Wpbjgz insertWpbjgz(Wpbjgz wpbjgz){
		// TODO: implement
		return (Wpbjgz)wpbjgzDao.insertWpbjgz(wpbjgz);
	}

	/** @param 物品报警规则(t_wpbjgz) 删除 */
	public boolean deleteWpbjgz(Wpbjgz wpbjgz){
		// TODO: implement
		return wpbjgzDao.deleteWpbjgz(wpbjgz)>0;
	}

	/** @param 物品报警规则(t_wpbjgz) 修改 */
	public boolean updateWpbjgz(Wpbjgz wpbjgz){
		// TODO: implement
		return wpbjgzDao.updateWpbjgz(wpbjgz)>0;
	}

	/** @param 物品报警规则(t_wpbjgz) 查询单条 */
	public Wpbjgz getWpbjgz(Wpbjgz wpbjgz){
		// TODO: implement
		return (Wpbjgz)wpbjgzDao.getWpbjgz(wpbjgz);
	}

	/** @param 物品报警规则(t_wpbjgz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wpbjgzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 物品报警规则(t_wpbjgz) 多条查询 */
	public List getListWpbjgz(Wpbjgz wpbjgz){
		// TODO: implement
		return wpbjgzDao.getListWpbjgz(wpbjgz);
	}

	public IWpbjgzDao getWpbjgzDao() {
		return wpbjgzDao;
	}

	public void setWpbjgzDao(IWpbjgzDao wpbjgzDao) {
		this.wpbjgzDao = wpbjgzDao;
	}
}
