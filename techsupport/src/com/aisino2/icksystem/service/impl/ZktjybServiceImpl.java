package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IZktjybDao;
import com.aisino2.icksystem.domain.Zktjyb;
import com.aisino2.icksystem.service.IZktjybService;

public class ZktjybServiceImpl extends BaseService implements IZktjybService {

	private IZktjybDao zktjybDao;

	/** @param 制卡统计月报(t_zktjyb) 增加 */
	public Zktjyb insertZktjyb(Zktjyb zktjyb){
		// TODO: implement
		return (Zktjyb)zktjybDao.insertZktjyb(zktjyb);
	}

	/** @param 制卡统计月报(t_zktjyb) 删除 */
	public boolean deleteZktjyb(Zktjyb zktjyb){
		// TODO: implement
		return zktjybDao.deleteZktjyb(zktjyb)>0;
	}

	/** @param 制卡统计月报(t_zktjyb) 修改 */
	public boolean updateZktjyb(Zktjyb zktjyb){
		// TODO: implement
		return zktjybDao.updateZktjyb(zktjyb)>0;
	}

	/** @param 制卡统计月报(t_zktjyb) 查询单条 */
	public Zktjyb getZktjyb(Zktjyb zktjyb){
		// TODO: implement
		return (Zktjyb)zktjybDao.getZktjyb(zktjyb);
	}

	/** @param 制卡统计月报(t_zktjyb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return zktjybDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 制卡统计月报(t_zktjyb) 多条查询 */
	public List getListZktjyb(Zktjyb zktjyb){
		// TODO: implement
		return zktjybDao.getListZktjyb(zktjyb);
	}

	public IZktjybDao getZktjybDao() {
		return zktjybDao;
	}

	public void setZktjybDao(IZktjybDao zktjybDao) {
		this.zktjybDao = zktjybDao;
	}
}
