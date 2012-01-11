package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkclDao;
import com.aisino2.basicsystem.domain.Bkcl;
import com.aisino2.basicsystem.service.IBkclService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BkclServiceImpl extends BaseService implements IBkclService {

	private IBkclDao bkclDao;

	/** @param 布控车辆(t_bkcl) 增加 */
	public Bkcl insertBkcl(Bkcl bkcl){
		// TODO: implement
		return (Bkcl)bkclDao.insertBkcl(bkcl);
	}

	/** @param 布控车辆(t_bkcl) 删除 */
	public boolean deleteBkcl(Bkcl bkcl){
		// TODO: implement
		return bkclDao.deleteBkcl(bkcl)>0;
	}

	/** @param 布控车辆(t_bkcl) 修改 */
	public boolean updateBkcl(Bkcl bkcl){
		// TODO: implement
		return bkclDao.updateBkcl(bkcl)>0;
	}

	/** @param 布控车辆(t_bkcl) 查询单条 */
	public Bkcl getBkcl(Bkcl bkcl){
		// TODO: implement
		return (Bkcl)bkclDao.getBkcl(bkcl);
	}

	/** @param 布控车辆(t_bkcl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bkclDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 布控车辆(t_bkcl) 多条查询 */
	public List getListBkcl(Bkcl bkcl){
		// TODO: implement
		return bkclDao.getListBkcl(bkcl);
	}

	public IBkclDao getBkclDao() {
		return bkclDao;
	}

	public void setBkclDao(IBkclDao bkclDao) {
		this.bkclDao = bkclDao;
	}
}
