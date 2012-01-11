package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkclkzDao;
import com.aisino2.basicsystem.domain.Bkclkz;
import com.aisino2.basicsystem.service.IBkclkzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BkclkzServiceImpl extends BaseService implements IBkclkzService {

	private IBkclkzDao bkclkzDao;

	/** @param 布控车辆快照(t_bkclkz) 增加 */
	public Bkclkz insertBkclkz(Bkclkz bkclkz){
		// TODO: implement
		return (Bkclkz)bkclkzDao.insertBkclkz(bkclkz);
	}

	/** @param 布控车辆快照(t_bkclkz) 删除 */
	public boolean deleteBkclkz(Bkclkz bkclkz){
		// TODO: implement
		return bkclkzDao.deleteBkclkz(bkclkz)>0;
	}

	/** @param 布控车辆快照(t_bkclkz) 修改 */
	public boolean updateBkclkz(Bkclkz bkclkz){
		// TODO: implement
		return bkclkzDao.updateBkclkz(bkclkz)>0;
	}

	/** @param 布控车辆快照(t_bkclkz) 查询单条 */
	public Bkclkz getBkclkz(Bkclkz bkclkz){
		// TODO: implement
		return (Bkclkz)bkclkzDao.getBkclkz(bkclkz);
	}

	/** @param 布控车辆快照(t_bkclkz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bkclkzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 布控车辆快照(t_bkclkz) 多条查询 */
	public List getListBkclkz(Bkclkz bkclkz){
		// TODO: implement
		return bkclkzDao.getListBkclkz(bkclkz);
	}

	public IBkclkzDao getBkclkzDao() {
		return bkclkzDao;
	}

	public void setBkclkzDao(IBkclkzDao bkclkzDao) {
		this.bkclkzDao = bkclkzDao;
	}
}
