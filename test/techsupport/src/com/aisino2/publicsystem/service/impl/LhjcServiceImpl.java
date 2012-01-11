package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.ILhjcDao;
import com.aisino2.publicsystem.domain.Lhjc;
import com.aisino2.publicsystem.service.ILhjcService;

public class LhjcServiceImpl extends BaseService implements ILhjcService {

	private ILhjcDao lhjcDao;

	/** @param 联合检查(t_lhjc) 增加 */
	public Lhjc insertLhjc(Lhjc lhjc){
		// TODO: implement
		return (Lhjc)lhjcDao.insertLhjc(lhjc);
	}

	/** @param 联合检查(t_lhjc) 删除 */
	public boolean deleteLhjc(Lhjc lhjc){
		// TODO: implement
		return lhjcDao.deleteLhjc(lhjc)>0;
	}

	/** @param 联合检查(t_lhjc) 修改 */
	public boolean updateLhjc(Lhjc lhjc){
		// TODO: implement
		return lhjcDao.updateLhjc(lhjc)>0;
	}

	/** @param 联合检查(t_lhjc) 查询单条 */
	public Lhjc getLhjc(Lhjc lhjc){
		// TODO: implement
		return (Lhjc)lhjcDao.getLhjc(lhjc);
	}

	/** @param 联合检查(t_lhjc) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return lhjcDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 联合检查(t_lhjc) 多条查询 */
	public List getListLhjc(Lhjc lhjc){
		// TODO: implement
		return lhjcDao.getListLhjc(lhjc);
	}

	public ILhjcDao getLhjcDao() {
		return lhjcDao;
	}

	public void setLhjcDao(ILhjcDao lhjcDao) {
		this.lhjcDao = lhjcDao;
	}
}
