package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIckslbgDao;
import com.aisino2.icksystem.domain.Ickslbg;
import com.aisino2.icksystem.service.IIckslbgService;

public class IckslbgServiceImpl extends BaseService implements IIckslbgService {

	private IIckslbgDao ickslbgDao;

	/** @param IC卡受理变更(t_ickslbg) 增加 */
	public Ickslbg insertIckslbg(Ickslbg ickslbg){
		// TODO: implement
		return (Ickslbg)ickslbgDao.insertIckslbg(ickslbg);
	}

	/** @param IC卡受理变更(t_ickslbg) 删除 */
	public boolean deleteIckslbg(Ickslbg ickslbg){
		// TODO: implement
		return ickslbgDao.deleteIckslbg(ickslbg)>0;
	}

	/** @param IC卡受理变更(t_ickslbg) 修改 */
	public boolean updateIckslbg(Ickslbg ickslbg){
		// TODO: implement
		return ickslbgDao.updateIckslbg(ickslbg)>0;
	}

	/** @param IC卡受理变更(t_ickslbg) 查询单条 */
	public Ickslbg getIckslbg(Ickslbg ickslbg){
		// TODO: implement
		return (Ickslbg)ickslbgDao.getIckslbg(ickslbg);
	}

	/** @param IC卡受理变更(t_ickslbg) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return ickslbgDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param IC卡受理变更(t_ickslbg) 多条查询 */
	public List getListIckslbg(Ickslbg ickslbg){
		// TODO: implement
		return ickslbgDao.getListIckslbg(ickslbg);
	}

	public IIckslbgDao getIckslbgDao() {
		return ickslbgDao;
	}

	public void setIckslbgDao(IIckslbgDao ickslbgDao) {
		this.ickslbgDao = ickslbgDao;
	}
}
