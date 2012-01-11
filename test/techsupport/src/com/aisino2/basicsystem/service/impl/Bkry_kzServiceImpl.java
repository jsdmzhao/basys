package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkry_kzDao;
import com.aisino2.basicsystem.domain.Bkry_kz;
import com.aisino2.basicsystem.service.IBkry_kzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class Bkry_kzServiceImpl extends BaseService implements IBkry_kzService {

	private IBkry_kzDao bkry_kzDao;

	/** @param 布控人员快照(t_bkry_kz) 增加 */
	public Bkry_kz insertBkry_kz(Bkry_kz bkry_kz){
		// TODO: implement
		return (Bkry_kz)bkry_kzDao.insertBkry_kz(bkry_kz);
	}

	/** @param 布控人员快照(t_bkry_kz) 删除 */
	public boolean deleteBkry_kz(Bkry_kz bkry_kz){
		// TODO: implement
		return bkry_kzDao.deleteBkry_kz(bkry_kz)>0;
	}

	/** @param 布控人员快照(t_bkry_kz) 修改 */
	public boolean updateBkry_kz(Bkry_kz bkry_kz){
		// TODO: implement
		return bkry_kzDao.updateBkry_kz(bkry_kz)>0;
	}

	/** @param 布控人员快照(t_bkry_kz) 查询单条 */
	public Bkry_kz getBkry_kz(Bkry_kz bkry_kz){
		// TODO: implement
		return (Bkry_kz)bkry_kzDao.getBkry_kz(bkry_kz);
	}

	/** @param 布控人员快照(t_bkry_kz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bkry_kzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 布控人员快照(t_bkry_kz) 多条查询 */
	public List getListBkry_kz(Bkry_kz bkry_kz){
		// TODO: implement
		return bkry_kzDao.getListBkry_kz(bkry_kz);
	}

	public IBkry_kzDao getBkry_kzDao() {
		return bkry_kzDao;
	}

	public void setBkry_kzDao(IBkry_kzDao bkry_kzDao) {
		this.bkry_kzDao = bkry_kzDao;
	}
}
