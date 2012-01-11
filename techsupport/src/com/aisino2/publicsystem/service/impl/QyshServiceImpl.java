package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyshDao;
import com.aisino2.publicsystem.domain.Qysh;
import com.aisino2.publicsystem.service.IQyshService;

public class QyshServiceImpl extends BaseService implements IQyshService {

	private IQyshDao qyshDao;

	/** @param 企业审核(t_qysh) 增加 */
	public Qysh insertQysh(Qysh qysh){
		// TODO: implement
		return (Qysh)qyshDao.insertQysh(qysh);
	}

	/** @param 企业审核(t_qysh) 删除 */
	public boolean deleteQysh(Qysh qysh){
		// TODO: implement
		return qyshDao.deleteQysh(qysh)>0;
	}

	/** @param 企业审核(t_qysh) 修改 */
	public boolean updateQysh(Qysh qysh){
		// TODO: implement
		return qyshDao.updateQysh(qysh)>0;
	}

	/** @param 企业审核(t_qysh) 查询单条 */
	public Qysh getQysh(Qysh qysh){
		// TODO: implement
		return (Qysh)qyshDao.getQysh(qysh);
	}

	/** @param 企业审核(t_qysh) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyshDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 企业审核(t_qysh) 多条查询 */
	public List getListQysh(Qysh qysh)
	{
		return qyshDao.getListQysh(qysh);
	}
	
	/** 获得上级审核id，即最后一次审核的qyshid */
	public Qysh getSjshid(Qysh qysh){
		// TODO: implement
		return qyshDao.getSjshid(qysh);
	}

	public IQyshDao getQyshDao() {
		return qyshDao;
	}

	public void setQyshDao(IQyshDao qyshDao) {
		this.qyshDao = qyshDao;
	}
}
