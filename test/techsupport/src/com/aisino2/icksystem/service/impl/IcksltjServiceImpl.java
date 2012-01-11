package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIcksltjDao;
import com.aisino2.icksystem.domain.Icksltj;
import com.aisino2.icksystem.service.IIcksltjService;

public class IcksltjServiceImpl extends BaseService implements IIcksltjService {

	private IIcksltjDao icksltjDao;

	/** @param IC卡受理统计(t_icksltj) 增加 */
	public Icksltj insertIcksltj(Icksltj icksltj){
		// TODO: implement
		return (Icksltj)icksltjDao.insertIcksltj(icksltj);
	}

	/** @param IC卡受理统计(t_icksltj) 删除 */
	public boolean deleteIcksltj(Icksltj icksltj){
		// TODO: implement
		return icksltjDao.deleteIcksltj(icksltj)>0;
	}

	/** @param IC卡受理统计(t_icksltj) 修改 */
	public boolean updateIcksltj(Icksltj icksltj){
		// TODO: implement
		return icksltjDao.updateIcksltj(icksltj)>0;
	}

	/** @param IC卡受理统计(t_icksltj) 查询单条 */
	public Icksltj getIcksltj(Icksltj icksltj){
		// TODO: implement
		return (Icksltj)icksltjDao.getIcksltj(icksltj);
	}

	/** @param IC卡受理统计(t_icksltj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return icksltjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param IC卡受理统计(t_icksltj) 多条查询 */
	public List getListIcksltj(Icksltj icksltj){
		// TODO: implement
		return icksltjDao.getListIcksltj(icksltj);
	}

	public IIcksltjDao getIcksltjDao() {
		return icksltjDao;
	}

	public void setIcksltjDao(IIcksltjDao icksltjDao) {
		this.icksltjDao = icksltjDao;
	}
}
