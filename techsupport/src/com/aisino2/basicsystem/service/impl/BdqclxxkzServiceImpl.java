package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBdqclxxkzDao;
import com.aisino2.basicsystem.domain.Bdqclxxkz;
import com.aisino2.basicsystem.service.IBdqclxxkzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BdqclxxkzServiceImpl extends BaseService implements IBdqclxxkzService {

	private IBdqclxxkzDao bdqclxxkzDao;

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 增加 */
	public Bdqclxxkz insertBdqclxxkz(Bdqclxxkz bdqclxxkz){
		// TODO: implement
		return (Bdqclxxkz)bdqclxxkzDao.insertBdqclxxkz(bdqclxxkz);
	}

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 删除 */
	public boolean deleteBdqclxxkz(Bdqclxxkz bdqclxxkz){
		// TODO: implement
		return bdqclxxkzDao.deleteBdqclxxkz(bdqclxxkz)>0;
	}

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 修改 */
	public boolean updateBdqclxxkz(Bdqclxxkz bdqclxxkz){
		// TODO: implement
		return bdqclxxkzDao.updateBdqclxxkz(bdqclxxkz)>0;
	}

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 查询单条 */
	public Bdqclxxkz getBdqclxxkz(Bdqclxxkz bdqclxxkz){
		// TODO: implement
		return (Bdqclxxkz)bdqclxxkzDao.getBdqclxxkz(bdqclxxkz);
	}

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bdqclxxkzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 被盗抢车辆信息_快照(t_bdqclxxkz) 多条查询 */
	public List getListBdqclxxkz(Bdqclxxkz bdqclxxkz){
		// TODO: implement
		return bdqclxxkzDao.getListBdqclxxkz(bdqclxxkz);
	}

	public IBdqclxxkzDao getBdqclxxkzDao() {
		return bdqclxxkzDao;
	}

	public void setBdqclxxkzDao(IBdqclxxkzDao bdqclxxkzDao) {
		this.bdqclxxkzDao = bdqclxxkzDao;
	}
}
