package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIcksl_ickzbDao;
import com.aisino2.icksystem.domain.Icksl_ickzb;
import com.aisino2.icksystem.service.IIcksl_ickzbService;

public class Icksl_ickzbServiceImpl extends BaseService implements IIcksl_ickzbService {

	private IIcksl_ickzbDao icksl_ickzbDao;

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 增加 */
	public Icksl_ickzb insertIcksl_ickzb(Icksl_ickzb icksl_ickzb){
		// TODO: implement
		return (Icksl_ickzb)icksl_ickzbDao.insertIcksl_ickzb(icksl_ickzb);
	}

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 删除 */
	public boolean deleteIcksl_ickzb(Icksl_ickzb icksl_ickzb){
		// TODO: implement
		return icksl_ickzbDao.deleteIcksl_ickzb(icksl_ickzb)>0;
	}

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 修改 */
	public boolean updateIcksl_ickzb(Icksl_ickzb icksl_ickzb){
		// TODO: implement
		return icksl_ickzbDao.updateIcksl_ickzb(icksl_ickzb)>0;
	}

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 查询单条 */
	public Icksl_ickzb getIcksl_ickzb(Icksl_ickzb icksl_ickzb){
		// TODO: implement
		return (Icksl_ickzb)icksl_ickzbDao.getIcksl_ickzb(icksl_ickzb);
	}

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return icksl_ickzbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 多条查询 */
	public List getListIcksl_ickzb(Icksl_ickzb icksl_ickzb){
		// TODO: implement
		return icksl_ickzbDao.getListIcksl_ickzb(icksl_ickzb);
	}

	public IIcksl_ickzbDao getIcksl_ickzbDao() {
		return icksl_ickzbDao;
	}

	public void setIcksl_ickzbDao(IIcksl_ickzbDao icksl_ickzbDao) {
		this.icksl_ickzbDao = icksl_ickzbDao;
	}
}
