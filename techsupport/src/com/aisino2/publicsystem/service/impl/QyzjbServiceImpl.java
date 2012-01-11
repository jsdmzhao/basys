package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyzjbDao;
import com.aisino2.publicsystem.domain.Qyzjb;
import com.aisino2.publicsystem.service.IQyzjbService;

public class QyzjbServiceImpl extends BaseService implements IQyzjbService {

	private IQyzjbDao qyzjbDao;

	/** @param 企业证件表(t_qyzjb) 增加 */
	public Qyzjb insertQyzjb(Qyzjb qyzjb){
		// TODO: implement
		return (Qyzjb)qyzjbDao.insertQyzjb(qyzjb);
	}

	/** @param 企业证件表(t_qyzjb) 删除 */
	public boolean deleteQyzjb(Qyzjb qyzjb){
		// TODO: implement
		return qyzjbDao.deleteQyzjb(qyzjb)>0;
	}

	/** @param 企业证件表(t_qyzjb) 修改 */
	public boolean updateQyzjb(Qyzjb qyzjb){
		// TODO: implement
		return qyzjbDao.updateQyzjb(qyzjb)>0;
	}

	/** @param 企业证件表(t_qyzjb) 查询单条 */
	public Qyzjb getQyzjb(Qyzjb qyzjb){
		// TODO: implement
		return (Qyzjb)qyzjbDao.getQyzjb(qyzjb);
	}

	/** @param 企业证件表(t_qyzjb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyzjbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业证件表(t_qyzjb) 多条查询 */
	public List getListQyzjb(Qyzjb qyzjb){
		// TODO: implement
		return qyzjbDao.getListQyzjb(qyzjb);
	}

	public IQyzjbDao getQyzjbDao() {
		return qyzjbDao;
	}

	public void setQyzjbDao(IQyzjbDao qyzjbDao) {
		this.qyzjbDao = qyzjbDao;
	}
}
