package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IGarkktbsjDao;
import com.aisino2.publicsystem.domain.Garkktbsj;
import com.aisino2.publicsystem.service.IGarkktbsjService;

public class GarkktbsjServiceImpl extends BaseService implements IGarkktbsjService {

	private IGarkktbsjDao garkktbsjDao;

	/** @param 公安人口库同步数据(t_garkktbsj) 增加 */
	public Garkktbsj insertGarkktbsj(Garkktbsj garkktbsj){
		// TODO: implement
		return (Garkktbsj)garkktbsjDao.insertGarkktbsj(garkktbsj);
	}

	/** @param 公安人口库同步数据(t_garkktbsj) 删除 */
	public boolean deleteGarkktbsj(Garkktbsj garkktbsj){
		// TODO: implement
		return garkktbsjDao.deleteGarkktbsj(garkktbsj)>0;
	}

	/** @param 公安人口库同步数据(t_garkktbsj) 修改 */
	public boolean updateGarkktbsj(Garkktbsj garkktbsj){
		// TODO: implement
		return garkktbsjDao.updateGarkktbsj(garkktbsj)>0;
	}

	/** @param 公安人口库同步数据(t_garkktbsj) 查询单条 */
	public Garkktbsj getGarkktbsj(Garkktbsj garkktbsj){
		// TODO: implement
		return (Garkktbsj)garkktbsjDao.getGarkktbsj(garkktbsj);
	}

	/** @param 公安人口库同步数据(t_garkktbsj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return garkktbsjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 公安人口库同步数据(t_garkktbsj) 多条查询 */
	public List getListGarkktbsj(Garkktbsj garkktbsj){
		// TODO: implement
		return garkktbsjDao.getListGarkktbsj(garkktbsj);
	}

	public IGarkktbsjDao getGarkktbsjDao() {
		return garkktbsjDao;
	}

	public void setGarkktbsjDao(IGarkktbsjDao garkktbsjDao) {
		this.garkktbsjDao = garkktbsjDao;
	}
}
