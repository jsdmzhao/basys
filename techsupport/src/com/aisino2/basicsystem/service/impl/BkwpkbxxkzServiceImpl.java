package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkwpkbxxkzDao;
import com.aisino2.basicsystem.domain.Bkwpkbxxkz;
import com.aisino2.basicsystem.service.IBkwpkbxxkzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BkwpkbxxkzServiceImpl extends BaseService implements IBkwpkbxxkzService {

	private IBkwpkbxxkzDao bkwpkbxxkzDao;

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 增加 */
	public Bkwpkbxxkz insertBkwpkbxxkz(Bkwpkbxxkz bkwpkbxxkz){
		// TODO: implement
		return (Bkwpkbxxkz)bkwpkbxxkzDao.insertBkwpkbxxkz(bkwpkbxxkz);
	}

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 删除 */
	public boolean deleteBkwpkbxxkz(Bkwpkbxxkz bkwpkbxxkz){
		// TODO: implement
		return bkwpkbxxkzDao.deleteBkwpkbxxkz(bkwpkbxxkz)>0;
	}

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 修改 */
	public boolean updateBkwpkbxxkz(Bkwpkbxxkz bkwpkbxxkz){
		// TODO: implement
		return bkwpkbxxkzDao.updateBkwpkbxxkz(bkwpkbxxkz)>0;
	}

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 查询单条 */
	public Bkwpkbxxkz getBkwpkbxxkz(Bkwpkbxxkz bkwpkbxxkz){
		// TODO: implement
		return (Bkwpkbxxkz)bkwpkbxxkzDao.getBkwpkbxxkz(bkwpkbxxkz);
	}

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bkwpkbxxkzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 多条查询 */
	public List getListBkwpkbxxkz(Bkwpkbxxkz bkwpkbxxkz){
		// TODO: implement
		return bkwpkbxxkzDao.getListBkwpkbxxkz(bkwpkbxxkz);
	}

	public IBkwpkbxxkzDao getBkwpkbxxkzDao() {
		return bkwpkbxxkzDao;
	}

	public void setBkwpkbxxkzDao(IBkwpkbxxkzDao bkwpkbxxkzDao) {
		this.bkwpkbxxkzDao = bkwpkbxxkzDao;
	}
}
