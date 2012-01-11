package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IZktjjbDao;
import com.aisino2.icksystem.domain.Zktjjb;
import com.aisino2.icksystem.service.IZktjjbService;

public class ZktjjbServiceImpl extends BaseService implements IZktjjbService {

	private IZktjjbDao zktjjbDao;

	/** @param 制卡统计季报(t_zktjjb) 增加 */
	public Zktjjb insertZktjjb(Zktjjb zktjjb){
		// TODO: implement
		return (Zktjjb)zktjjbDao.insertZktjjb(zktjjb);
	}

	/** @param 制卡统计季报(t_zktjjb) 删除 */
	public boolean deleteZktjjb(Zktjjb zktjjb){
		// TODO: implement
		return zktjjbDao.deleteZktjjb(zktjjb)>0;
	}

	/** @param 制卡统计季报(t_zktjjb) 修改 */
	public boolean updateZktjjb(Zktjjb zktjjb){
		// TODO: implement
		return zktjjbDao.updateZktjjb(zktjjb)>0;
	}

	/** @param 制卡统计季报(t_zktjjb) 查询单条 */
	public Zktjjb getZktjjb(Zktjjb zktjjb){
		// TODO: implement
		return (Zktjjb)zktjjbDao.getZktjjb(zktjjb);
	}

	/** @param 制卡统计季报(t_zktjjb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return zktjjbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 制卡统计季报(t_zktjjb) 多条查询 */
	public List getListZktjjb(Zktjjb zktjjb){
		// TODO: implement
		return zktjjbDao.getListZktjjb(zktjjb);
	}

	public IZktjjbDao getZktjjbDao() {
		return zktjjbDao;
	}

	public void setZktjjbDao(IZktjjbDao zktjjbDao) {
		this.zktjjbDao = zktjjbDao;
	}
}
