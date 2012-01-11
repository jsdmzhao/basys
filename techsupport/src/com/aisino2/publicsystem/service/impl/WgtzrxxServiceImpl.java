package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IWgtzrxxDao;
import com.aisino2.publicsystem.domain.Wgtzrxx;
import com.aisino2.publicsystem.service.IWgtzrxxService;

public class WgtzrxxServiceImpl extends BaseService implements IWgtzrxxService {

	private IWgtzrxxDao wgtzrxxDao;

	/** @param 外国投资人信息(t_wgtzrxx) 增加 */
	public Wgtzrxx insertWgtzrxx(Wgtzrxx wgtzrxx){
		// TODO: implement
		return (Wgtzrxx)wgtzrxxDao.insertWgtzrxx(wgtzrxx);
	}

	/** @param 外国投资人信息(t_wgtzrxx) 删除 */
	public boolean deleteWgtzrxx(Wgtzrxx wgtzrxx){
		// TODO: implement
		return wgtzrxxDao.deleteWgtzrxx(wgtzrxx)>0;
	}

	/** @param 外国投资人信息(t_wgtzrxx) 修改 */
	public boolean updateWgtzrxx(Wgtzrxx wgtzrxx){
		// TODO: implement
		return wgtzrxxDao.updateWgtzrxx(wgtzrxx)>0;
	}

	/** @param 外国投资人信息(t_wgtzrxx) 查询单条 */
	public Wgtzrxx getWgtzrxx(Wgtzrxx wgtzrxx){
		// TODO: implement
		return (Wgtzrxx)wgtzrxxDao.getWgtzrxx(wgtzrxx);
	}

	/** @param 外国投资人信息(t_wgtzrxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wgtzrxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 外国投资人信息(t_wgtzrxx) 多条查询 */
	public List getListWgtzrxx(Wgtzrxx wgtzrxx){
		// TODO: implement
		return wgtzrxxDao.getListWgtzrxx(wgtzrxx);
	}

	public IWgtzrxxDao getWgtzrxxDao() {
		return wgtzrxxDao;
	}

	public void setWgtzrxxDao(IWgtzrxxDao wgtzrxxDao) {
		this.wgtzrxxDao = wgtzrxxDao;
	}
}
