package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIckyjDao;
import com.aisino2.icksystem.domain.Ickyj;
import com.aisino2.icksystem.service.IIckyjService;

public class IckyjServiceImpl extends BaseService implements IIckyjService {

	private IIckyjDao ickyjDao;

	/** @param IC卡预警(t_ickyj) 增加 */
	public Ickyj insertIckyj(Ickyj ickyj){
		// TODO: implement
		return (Ickyj)ickyjDao.insertIckyj(ickyj);
	}

	/** @param IC卡预警(t_ickyj) 删除 */
	public boolean deleteIckyj(Ickyj ickyj){
		// TODO: implement
		return ickyjDao.deleteIckyj(ickyj)>0;
	}

	/** @param IC卡预警(t_ickyj) 修改 */
	public boolean updateIckyj(Ickyj ickyj){
		// TODO: implement
		return ickyjDao.updateIckyj(ickyj)>0;
	}

	/** @param IC卡预警(t_ickyj) 查询单条 */
	public Ickyj getIckyj(Ickyj ickyj){
		// TODO: implement
		return (Ickyj)ickyjDao.getIckyj(ickyj);
	}

	/** @param IC卡预警(t_ickyj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return ickyjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param IC卡预警(t_ickyj) 多条查询 */
	public List getListIckyj(Ickyj ickyj){
		// TODO: implement
		return ickyjDao.getListIckyj(ickyj);
	}

	public IIckyjDao getIckyjDao() {
		return ickyjDao;
	}

	public void setIckyjDao(IIckyjDao ickyjDao) {
		this.ickyjDao = ickyjDao;
	}
}
