package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyrygzrzDao;
import com.aisino2.publicsystem.domain.Qyrygzrz;
import com.aisino2.publicsystem.service.IQyrygzrzService;

public class QyrygzrzServiceImpl extends BaseService implements IQyrygzrzService {

	private IQyrygzrzDao qyrygzrzDao;

	/** @param 企业人员工作日志(t_qyrygzrz) 增加 */
	public Qyrygzrz insertQyrygzrz(Qyrygzrz qyrygzrz){
		// TODO: implement
		return (Qyrygzrz)qyrygzrzDao.insertQyrygzrz(qyrygzrz);
	}

	/** @param 企业人员工作日志(t_qyrygzrz) 删除 */
	public boolean deleteQyrygzrz(Qyrygzrz qyrygzrz){
		// TODO: implement
		return qyrygzrzDao.deleteQyrygzrz(qyrygzrz)>0;
	}

	/** @param 企业人员工作日志(t_qyrygzrz) 修改 */
	public boolean updateQyrygzrz(Qyrygzrz qyrygzrz){
		// TODO: implement
		return qyrygzrzDao.updateQyrygzrz(qyrygzrz)>0;
	}

	/** @param 企业人员工作日志(t_qyrygzrz) 查询单条 */
	public Qyrygzrz getQyrygzrz(Qyrygzrz qyrygzrz){
		// TODO: implement
		return (Qyrygzrz)qyrygzrzDao.getQyrygzrz(qyrygzrz);
	}

	/** @param 企业人员工作日志(t_qyrygzrz) 分页查询  企业端查询*/
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return qyrygzrzDao.getListForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 企业人员工作日志(t_qyrygzrz) 分页查询  公安端查询*/
	public Page getListForPageGad(Map map, int pageNo,int pageSize,String sort,String desc){
		return qyrygzrzDao.getListForPageGad(map, pageNo, pageSize, sort, desc);
	}

	/** @param 企业人员工作日志(t_qyrygzrz) 多条查询 */
	public List getListQyrygzrz(Qyrygzrz qyrygzrz){
		// TODO: implement
		return qyrygzrzDao.getListQyrygzrz(qyrygzrz);
	}

	public IQyrygzrzDao getQyrygzrzDao() {
		return qyrygzrzDao;
	}

	public void setQyrygzrzDao(IQyrygzrzDao qyrygzrzDao) {
		this.qyrygzrzDao = qyrygzrzDao;
	}
}
