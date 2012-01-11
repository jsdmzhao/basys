package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBdqclxxDao;
import com.aisino2.basicsystem.domain.Bdqclxx;
import com.aisino2.basicsystem.service.IBdqclxxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BdqclxxServiceImpl extends BaseService implements IBdqclxxService {

	private IBdqclxxDao bdqclxxDao;

	/** @param 被盗抢车辆信息(t_bdqclxx) 增加 */
	public Bdqclxx insertBdqclxx(Bdqclxx bdqclxx){
		// TODO: implement
		return (Bdqclxx)bdqclxxDao.insertBdqclxx(bdqclxx);
	}

	/** @param 被盗抢车辆信息(t_bdqclxx) 删除 */
	public boolean deleteBdqclxx(Bdqclxx bdqclxx){
		// TODO: implement
		return bdqclxxDao.deleteBdqclxx(bdqclxx)>0;
	}

	/** @param 被盗抢车辆信息(t_bdqclxx) 修改 */
	public boolean updateBdqclxx(Bdqclxx bdqclxx){
		// TODO: implement
		return bdqclxxDao.updateBdqclxx(bdqclxx)>0;
	}

	/** @param 被盗抢车辆信息(t_bdqclxx) 查询单条 */
	public Bdqclxx getBdqclxx(Bdqclxx bdqclxx){
		// TODO: implement
		return (Bdqclxx)bdqclxxDao.getBdqclxx(bdqclxx);
	}

	/** @param 被盗抢车辆信息(t_bdqclxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bdqclxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 被盗抢车辆信息(t_bdqclxx) 多条查询 */
	public List getListBdqclxx(Bdqclxx bdqclxx){
		// TODO: implement
		return bdqclxxDao.getListBdqclxx(bdqclxx);
	}

	public IBdqclxxDao getBdqclxxDao() {
		return bdqclxxDao;
	}

	public void setBdqclxxDao(IBdqclxxDao bdqclxxDao) {
		this.bdqclxxDao = bdqclxxDao;
	}
}
