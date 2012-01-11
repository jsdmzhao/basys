package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyfflDao;
import com.aisino2.publicsystem.domain.Qyffl;
import com.aisino2.publicsystem.service.IQyfflService;

public class QyfflServiceImpl extends BaseService implements IQyfflService {

	private IQyfflDao qyfflDao;

	/** @param 企业副分类(t_qyffl) 增加 */
	public Qyffl insertQyffl(Qyffl qyffl){
		// TODO: implement
		return (Qyffl)qyfflDao.insertQyffl(qyffl);
	}

	/** @param 企业副分类(t_qyffl) 删除 */
	public boolean deleteQyffl(Qyffl qyffl){
		// TODO: implement
		return qyfflDao.deleteQyffl(qyffl)>0;
	}

	/** @param 企业副分类(t_qyffl) 修改 */
	public boolean updateQyffl(Qyffl qyffl){
		// TODO: implement
		return qyfflDao.updateQyffl(qyffl)>0;
	}

	/** @param 企业副分类(t_qyffl) 查询单条 */
	public Qyffl getQyffl(Qyffl qyffl){
		// TODO: implement
		return (Qyffl)qyfflDao.getQyffl(qyffl);
	}

	/** @param 企业副分类(t_qyffl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyfflDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业副分类(t_qyffl) 多条查询 */
	public List getListQyffl(Qyffl qyffl){
		// TODO: implement
		return qyfflDao.getListQyffl(qyffl);
	}

	public IQyfflDao getQyfflDao() {
		return qyfflDao;
	}

	public void setQyfflDao(IQyfflDao qyfflDao) {
		this.qyfflDao = qyfflDao;
	}
}
