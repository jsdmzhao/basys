package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IBwryxxDao;
import com.aisino2.publicsystem.domain.Bwryxx;
import com.aisino2.publicsystem.service.IBwryxxService;

public class BwryxxServiceImpl extends BaseService implements IBwryxxService {

	private IBwryxxDao bwryxxDao;

	/** @param 保卫人员信息(t_bwryxx) 增加 */
	public Bwryxx insertBwryxx(Bwryxx bwryxx){
		// TODO: implement
		return (Bwryxx)bwryxxDao.insertBwryxx(bwryxx);
	}

	/** @param 保卫人员信息(t_bwryxx) 删除 */
	public boolean deleteBwryxx(Bwryxx bwryxx){
		// TODO: implement
		return bwryxxDao.deleteBwryxx(bwryxx)>0;
	}

	/** @param 保卫人员信息(t_bwryxx) 修改 */
	public boolean updateBwryxx(Bwryxx bwryxx){
		// TODO: implement
		return bwryxxDao.updateBwryxx(bwryxx)>0;
	}

	/** @param 保卫人员信息(t_bwryxx) 查询单条 */
	public Bwryxx getBwryxx(Bwryxx bwryxx){
		// TODO: implement
		return (Bwryxx)bwryxxDao.getBwryxx(bwryxx);
	}

	/** @param 保卫人员信息(t_bwryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bwryxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 保卫人员信息(t_bwryxx) 多条查询 */
	public List getListBwryxx(Bwryxx bwryxx){
		// TODO: implement
		return bwryxxDao.getListBwryxx(bwryxx);
	}

	public IBwryxxDao getBwryxxDao() {
		return bwryxxDao;
	}

	public void setBwryxxDao(IBwryxxDao bwryxxDao) {
		this.bwryxxDao = bwryxxDao;
	}
}
