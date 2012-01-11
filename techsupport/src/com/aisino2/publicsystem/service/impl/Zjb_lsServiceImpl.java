package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IZjb_lsDao;
import com.aisino2.publicsystem.domain.Zjb_ls;
import com.aisino2.publicsystem.service.IZjb_lsService;

public class Zjb_lsServiceImpl extends BaseService implements IZjb_lsService {

	private IZjb_lsDao zjb_lsDao;

	/** @param 证件历史表(t_zjb_ls) 增加 */
	public Zjb_ls insertZjb_ls(Zjb_ls zjb_ls){
		// TODO: implement
		return (Zjb_ls)zjb_lsDao.insertZjb_ls(zjb_ls);
	}

	/** @param 证件历史表(t_zjb_ls) 删除 */
	public boolean deleteZjb_ls(Zjb_ls zjb_ls){
		// TODO: implement
		return zjb_lsDao.deleteZjb_ls(zjb_ls)>0;
	}

	/** @param 证件历史表(t_zjb_ls) 修改 */
	public boolean updateZjb_ls(Zjb_ls zjb_ls){
		// TODO: implement
		return zjb_lsDao.updateZjb_ls(zjb_ls)>0;
	}

	/** @param 证件历史表(t_zjb_ls) 查询单条 */
	public Zjb_ls getZjb_ls(Zjb_ls zjb_ls){
		// TODO: implement
		return (Zjb_ls)zjb_lsDao.getZjb_ls(zjb_ls);
	}

	/** @param 证件历史表(t_zjb_ls) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return zjb_lsDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 证件历史表(t_zjb_ls) 多条查询 */
	public List getListZjb_ls(Zjb_ls zjb_ls){
		// TODO: implement
		return zjb_lsDao.getListZjb_ls(zjb_ls);
	}

	public IZjb_lsDao getZjb_lsDao() {
		return zjb_lsDao;
	}

	public void setZjb_lsDao(IZjb_lsDao zjb_lsDao) {
		this.zjb_lsDao = zjb_lsDao;
	}
}
