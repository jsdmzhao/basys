package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IZktjrbDao;
import com.aisino2.icksystem.domain.Zktjrb;
import com.aisino2.icksystem.service.IZktjrbService;

public class ZktjrbServiceImpl extends BaseService implements IZktjrbService {

	private IZktjrbDao zktjrbDao;

	/** @param 制卡统计日报(t_zktjrb) 增加 */
	public Zktjrb insertZktjrb(Zktjrb zktjrb){
		// TODO: implement
		return (Zktjrb)zktjrbDao.insertZktjrb(zktjrb);
	}

	/** @param 制卡统计日报(t_zktjrb) 删除 */
	public boolean deleteZktjrb(Zktjrb zktjrb){
		// TODO: implement
		return zktjrbDao.deleteZktjrb(zktjrb)>0;
	}

	/** @param 制卡统计日报(t_zktjrb) 修改 */
	public boolean updateZktjrb(Zktjrb zktjrb){
		// TODO: implement
		return zktjrbDao.updateZktjrb(zktjrb)>0;
	}

	/** @param 制卡统计日报(t_zktjrb) 查询单条 */
	public Zktjrb getZktjrb(Zktjrb zktjrb){
		// TODO: implement
		return (Zktjrb)zktjrbDao.getZktjrb(zktjrb);
	}

	/** @param 制卡统计日报(t_zktjrb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return zktjrbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 制卡统计日报(t_zktjrb) 多条查询 */
	public List getListZktjrb(Zktjrb zktjrb){
		// TODO: implement
		return zktjrbDao.getListZktjrb(zktjrb);
	}

	public IZktjrbDao getZktjrbDao() {
		return zktjrbDao;
	}

	public void setZktjrbDao(IZktjrbDao zktjrbDao) {
		this.zktjrbDao = zktjrbDao;
	}
}
