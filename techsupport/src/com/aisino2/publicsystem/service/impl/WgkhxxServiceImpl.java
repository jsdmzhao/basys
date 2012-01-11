package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IWgkhxxDao;
import com.aisino2.publicsystem.domain.Wgkhxx;
import com.aisino2.publicsystem.service.IWgkhxxService;

public class WgkhxxServiceImpl extends BaseService implements IWgkhxxService {

	private IWgkhxxDao wgkhxxDao;

	/** @param 外国客户信息(t_wgkhxx) 增加 */
	public Wgkhxx insertWgkhxx(Wgkhxx wgkhxx){
		// TODO: implement
		return (Wgkhxx)wgkhxxDao.insertWgkhxx(wgkhxx);
	}

	/** @param 外国客户信息(t_wgkhxx) 删除 */
	public boolean deleteWgkhxx(Wgkhxx wgkhxx){
		// TODO: implement
		return wgkhxxDao.deleteWgkhxx(wgkhxx)>0;
	}

	/** @param 外国客户信息(t_wgkhxx) 修改 */
	public boolean updateWgkhxx(Wgkhxx wgkhxx){
		// TODO: implement
		return wgkhxxDao.updateWgkhxx(wgkhxx)>0;
	}

	/** @param 外国客户信息(t_wgkhxx) 查询单条 */
	public Wgkhxx getWgkhxx(Wgkhxx wgkhxx){
		// TODO: implement
		return (Wgkhxx)wgkhxxDao.getWgkhxx(wgkhxx);
	}

	/** @param 外国客户信息(t_wgkhxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wgkhxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 外国客户信息(t_wgkhxx) 多条查询 */
	public List getListWgkhxx(Wgkhxx wgkhxx){
		// TODO: implement
		return wgkhxxDao.getListWgkhxx(wgkhxx);
	}

	public IWgkhxxDao getWgkhxxDao() {
		return wgkhxxDao;
	}

	public void setWgkhxxDao(IWgkhxxDao wgkhxxDao) {
		this.wgkhxxDao = wgkhxxDao;
	}
}
