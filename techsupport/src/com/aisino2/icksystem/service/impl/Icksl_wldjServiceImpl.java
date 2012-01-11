package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIcksl_wldjDao;
import com.aisino2.icksystem.domain.Icksl_wldj;
import com.aisino2.icksystem.service.IIcksl_wldjService;

public class Icksl_wldjServiceImpl extends BaseService implements IIcksl_wldjService {

	private IIcksl_wldjDao icksl_wldjDao;

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 增加 */
	public Icksl_wldj insertIcksl_wldj(Icksl_wldj icksl_wldj){
		// TODO: implement
		return (Icksl_wldj)icksl_wldjDao.insertIcksl_wldj(icksl_wldj);
	}

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 删除 */
	public boolean deleteIcksl_wldj(Icksl_wldj icksl_wldj){
		// TODO: implement
		return icksl_wldjDao.deleteIcksl_wldj(icksl_wldj)>0;
	}

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 修改 */
	public boolean updateIcksl_wldj(Icksl_wldj icksl_wldj){
		// TODO: implement
		return icksl_wldjDao.updateIcksl_wldj(icksl_wldj)>0;
	}

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 查询单条 */
	public Icksl_wldj getIcksl_wldj(Icksl_wldj icksl_wldj){
		// TODO: implement
		return (Icksl_wldj)icksl_wldjDao.getIcksl_wldj(icksl_wldj);
	}

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return icksl_wldjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 多条查询 */
	public List getListIcksl_wldj(Icksl_wldj icksl_wldj){
		// TODO: implement
		return icksl_wldjDao.getListIcksl_wldj(icksl_wldj);
	}

	public IIcksl_wldjDao getIcksl_wldjDao() {
		return icksl_wldjDao;
	}

	public void setIcksl_wldjDao(IIcksl_wldjDao icksl_wldjDao) {
		this.icksl_wldjDao = icksl_wldjDao;
	}
}
