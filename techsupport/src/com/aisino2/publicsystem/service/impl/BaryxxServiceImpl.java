package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IBaryxxDao;
import com.aisino2.publicsystem.domain.Baryxx;
import com.aisino2.publicsystem.service.IBaryxxService;

public class BaryxxServiceImpl extends BaseService implements IBaryxxService {

	private IBaryxxDao baryxxDao;

	/** @param 保安人员信息(t_baryxx) 增加 */
	public Baryxx insertBaryxx(Baryxx baryxx){
		// TODO: implement
		return (Baryxx)baryxxDao.insertBaryxx(baryxx);
	}

	/** @param 保安人员信息(t_baryxx) 删除 */
	public boolean deleteBaryxx(Baryxx baryxx){
		// TODO: implement
		return baryxxDao.deleteBaryxx(baryxx)>0;
	}

	/** @param 保安人员信息(t_baryxx) 修改 */
	public boolean updateBaryxx(Baryxx baryxx){
		// TODO: implement
		return baryxxDao.updateBaryxx(baryxx)>0;
	}

	/** @param 保安人员信息(t_baryxx) 查询单条 */
	public Baryxx getBaryxx(Baryxx baryxx){
		// TODO: implement
		return (Baryxx)baryxxDao.getBaryxx(baryxx);
	}

	/** @param 保安人员信息(t_baryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return baryxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 保安人员信息(t_baryxx) 多条查询 */
	public List getListBaryxx(Baryxx baryxx){
		// TODO: implement
		return baryxxDao.getListBaryxx(baryxx);
	}

	public IBaryxxDao getBaryxxDao() {
		return baryxxDao;
	}

	public void setBaryxxDao(IBaryxxDao baryxxDao) {
		this.baryxxDao = baryxxDao;
	}
}
