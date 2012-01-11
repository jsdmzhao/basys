package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IBafwhtDao;
import com.aisino2.publicsystem.domain.Bafwht;
import com.aisino2.publicsystem.service.IBafwhtService;

public class BafwhtServiceImpl extends BaseService implements IBafwhtService {

	private IBafwhtDao bafwhtDao;

	/** @param 保安服务合同(t_bafwht) 增加 */
	public Bafwht insertBafwht(Bafwht bafwht){
		// TODO: implement
		return (Bafwht)bafwhtDao.insertBafwht(bafwht);
	}

	/** @param 保安服务合同(t_bafwht) 删除 */
	public boolean deleteBafwht(Bafwht bafwht){
		// TODO: implement
		return bafwhtDao.deleteBafwht(bafwht)>0;
	}

	/** @param 保安服务合同(t_bafwht) 修改 */
	public boolean updateBafwht(Bafwht bafwht){
		// TODO: implement
		return bafwhtDao.updateBafwht(bafwht)>0;
	}

	/** @param 保安服务合同(t_bafwht) 查询单条 */
	public Bafwht getBafwht(Bafwht bafwht){
		// TODO: implement
		return (Bafwht)bafwhtDao.getBafwht(bafwht);
	}

	/** @param 保安服务合同(t_bafwht) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bafwhtDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 保安服务合同(t_bafwht) 多条查询 */
	public List getListBafwht(Bafwht bafwht){
		// TODO: implement
		return bafwhtDao.getListBafwht(bafwht);
	}

	public IBafwhtDao getBafwhtDao() {
		return bafwhtDao;
	}

	public void setBafwhtDao(IBafwhtDao bafwhtDao) {
		this.bafwhtDao = bafwhtDao;
	}
}
