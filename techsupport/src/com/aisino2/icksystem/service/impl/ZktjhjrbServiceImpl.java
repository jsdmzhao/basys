package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IZktjhjrbDao;
import com.aisino2.icksystem.domain.Zktjhjrb;
import com.aisino2.icksystem.service.IZktjhjrbService;

public class ZktjhjrbServiceImpl extends BaseService implements IZktjhjrbService {

	private IZktjhjrbDao zktjhjrbDao;

	/** @param 制卡统计汇总日报(t_zktjhjrb) 增加 */
	public Zktjhjrb insertZktjhjrb(Zktjhjrb zktjhjrb){
		// TODO: implement
		return (Zktjhjrb)zktjhjrbDao.insertZktjhjrb(zktjhjrb);
	}

	/** @param 制卡统计汇总日报(t_zktjhjrb) 删除 */
	public boolean deleteZktjhjrb(Zktjhjrb zktjhjrb){
		// TODO: implement
		return zktjhjrbDao.deleteZktjhjrb(zktjhjrb)>0;
	}

	/** @param 制卡统计汇总日报(t_zktjhjrb) 修改 */
	public boolean updateZktjhjrb(Zktjhjrb zktjhjrb){
		// TODO: implement
		return zktjhjrbDao.updateZktjhjrb(zktjhjrb)>0;
	}

	/** @param 制卡统计汇总日报(t_zktjhjrb) 查询单条 */
	public Zktjhjrb getZktjhjrb(Zktjhjrb zktjhjrb){
		// TODO: implement
		return (Zktjhjrb)zktjhjrbDao.getZktjhjrb(zktjhjrb);
	}

	/** @param 制卡统计汇总日报(t_zktjhjrb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return zktjhjrbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 制卡统计汇总日报(t_zktjhjrb) 多条查询 */
	public List getListZktjhjrb(Zktjhjrb zktjhjrb){
		// TODO: implement
		return zktjhjrbDao.getListZktjhjrb(zktjhjrb);
	}

	public IZktjhjrbDao getZktjhjrbDao() {
		return zktjhjrbDao;
	}

	public void setZktjhjrbDao(IZktjhjrbDao zktjhjrbDao) {
		this.zktjhjrbDao = zktjhjrbDao;
	}
}
