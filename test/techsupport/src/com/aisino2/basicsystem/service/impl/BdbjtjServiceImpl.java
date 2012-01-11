package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBdbjtjDao;
import com.aisino2.basicsystem.domain.Bdbjtj;
import com.aisino2.basicsystem.service.IBdbjtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;


public class BdbjtjServiceImpl extends BaseService implements IBdbjtjService {

	private IBdbjtjDao bdbjtjDao;

	/** @param 比对报警统计表(t_bdbjtj) 增加 */
	public Bdbjtj insertBdbjtj(Bdbjtj bdbjtj){
		// TODO: implement
		return (Bdbjtj)bdbjtjDao.insertBdbjtj(bdbjtj);
	}

	/** @param 比对报警统计表(t_bdbjtj) 删除 */
	public boolean deleteBdbjtj(Bdbjtj bdbjtj){
		// TODO: implement
		return bdbjtjDao.deleteBdbjtj(bdbjtj)>0;
	}

	/** @param 比对报警统计表(t_bdbjtj) 修改 */
	public boolean updateBdbjtj(Bdbjtj bdbjtj){
		// TODO: implement
		return bdbjtjDao.updateBdbjtj(bdbjtj)>0;
	}

	/** @param 比对报警统计表(t_bdbjtj) 查询单条 */
	public Bdbjtj getBdbjtj(Bdbjtj bdbjtj){
		// TODO: implement
		return (Bdbjtj)bdbjtjDao.getBdbjtj(bdbjtj);
	}

	/** @param 比对报警统计表(t_bdbjtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		map =CtreatPageMapTongJiBasic.getConditionsTongjiChaXun(map);
		return bdbjtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 比对报警统计表(t_bdbjtj) 多条查询 */
	public List getListBdbjtj(Bdbjtj bdbjtj){
		// TODO: implement
		return bdbjtjDao.getListBdbjtj(bdbjtj);
	}

	public IBdbjtjDao getBdbjtjDao() {
		return bdbjtjDao;
	}

	public void setBdbjtjDao(IBdbjtjDao bdbjtjDao) {
		this.bdbjtjDao = bdbjtjDao;
	}
}
