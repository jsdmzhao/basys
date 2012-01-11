package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyry_tjxxDao;
import com.aisino2.publicsystem.domain.Qyry_tjxx;
import com.aisino2.publicsystem.service.IQyry_tjxxService;

public class Qyry_tjxxServiceImpl extends BaseService implements IQyry_tjxxService {

	private IQyry_tjxxDao qyry_tjxxDao;

	/** @param 企业人员体检信息(t_qyry_tjxx) 增加 */
	public Qyry_tjxx insertQyry_tjxx(Qyry_tjxx qyry_tjxx){
		// TODO: implement
		return (Qyry_tjxx)qyry_tjxxDao.insertQyry_tjxx(qyry_tjxx);
	}

	/** @param 企业人员体检信息(t_qyry_tjxx) 删除 */
	public boolean deleteQyry_tjxx(Qyry_tjxx qyry_tjxx){
		// TODO: implement
		return qyry_tjxxDao.deleteQyry_tjxx(qyry_tjxx)>0;
	}

	/** @param 企业人员体检信息(t_qyry_tjxx) 修改 */
	public boolean updateQyry_tjxx(Qyry_tjxx qyry_tjxx){
		// TODO: implement
		return qyry_tjxxDao.updateQyry_tjxx(qyry_tjxx)>0;
	}

	/** @param 企业人员体检信息(t_qyry_tjxx) 查询单条 */
	public Qyry_tjxx getQyry_tjxx(Qyry_tjxx qyry_tjxx){
		// TODO: implement
		return (Qyry_tjxx)qyry_tjxxDao.getQyry_tjxx(qyry_tjxx);
	}

	/** @param 企业人员体检信息(t_qyry_tjxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyry_tjxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业人员体检信息(t_qyry_tjxx) 多条查询 */
	public List getListQyry_tjxx(Qyry_tjxx qyry_tjxx){
		// TODO: implement
		return qyry_tjxxDao.getListQyry_tjxx(qyry_tjxx);
	}

	public IQyry_tjxxDao getQyry_tjxxDao() {
		return qyry_tjxxDao;
	}

	public void setQyry_tjxxDao(IQyry_tjxxDao qyry_tjxxDao) {
		this.qyry_tjxxDao = qyry_tjxxDao;
	}
}
