package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBksjkzDao;
import com.aisino2.basicsystem.domain.Bksjkz;
import com.aisino2.basicsystem.service.IBksjkzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BksjkzServiceImpl extends BaseService implements IBksjkzService {

	private IBksjkzDao bksjkzDao;

	/** @param 布控手机快照(t_bksjkz) 增加 */
	public Bksjkz insertBksjkz(Bksjkz bksjkz){
		// TODO: implement
		return (Bksjkz)bksjkzDao.insertBksjkz(bksjkz);
	}

	/** @param 布控手机快照(t_bksjkz) 删除 */
	public boolean deleteBksjkz(Bksjkz bksjkz){
		// TODO: implement
		return bksjkzDao.deleteBksjkz(bksjkz)>0;
	}

	/** @param 布控手机快照(t_bksjkz) 修改 */
	public boolean updateBksjkz(Bksjkz bksjkz){
		// TODO: implement
		return bksjkzDao.updateBksjkz(bksjkz)>0;
	}

	/** @param 布控手机快照(t_bksjkz) 查询单条 */
	public Bksjkz getBksjkz(Bksjkz bksjkz){
		// TODO: implement
		return (Bksjkz)bksjkzDao.getBksjkz(bksjkz);
	}

	/** @param 布控手机快照(t_bksjkz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bksjkzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 布控手机快照(t_bksjkz) 多条查询 */
	public List getListBksjkz(Bksjkz bksjkz){
		// TODO: implement
		return bksjkzDao.getListBksjkz(bksjkz);
	}

	public IBksjkzDao getBksjkzDao() {
		return bksjkzDao;
	}

	public void setBksjkzDao(IBksjkzDao bksjkzDao) {
		this.bksjkzDao = bksjkzDao;
	}
}
