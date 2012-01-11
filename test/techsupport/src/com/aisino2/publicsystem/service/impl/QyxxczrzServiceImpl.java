package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyxxczrzDao;
import com.aisino2.publicsystem.domain.Qyxxczrz;
import com.aisino2.publicsystem.service.IQyxxczrzService;

public class QyxxczrzServiceImpl extends BaseService implements IQyxxczrzService {

	private IQyxxczrzDao qyxxczrzDao;

	/** @param 企业信息操作日志(t_qyxxczrz) 增加 */
	public Qyxxczrz insertQyxxczrz(Qyxxczrz qyxxczrz){
		// TODO: implement
		return (Qyxxczrz)qyxxczrzDao.insertQyxxczrz(qyxxczrz);
	}

	/** @param 企业信息操作日志(t_qyxxczrz) 删除 */
	public boolean deleteQyxxczrz(Qyxxczrz qyxxczrz){
		// TODO: implement
		return qyxxczrzDao.deleteQyxxczrz(qyxxczrz)>0;
	}

	/** @param 企业信息操作日志(t_qyxxczrz) 修改 */
	public boolean updateQyxxczrz(Qyxxczrz qyxxczrz){
		// TODO: implement
		return qyxxczrzDao.updateQyxxczrz(qyxxczrz)>0;
	}

	/** @param 企业信息操作日志(t_qyxxczrz) 查询单条 */
	public Qyxxczrz getQyxxczrz(Qyxxczrz qyxxczrz){
		// TODO: implement
		return (Qyxxczrz)qyxxczrzDao.getQyxxczrz(qyxxczrz);
	}

	/** @param 企业信息操作日志(t_qyxxczrz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyxxczrzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业信息操作日志(t_qyxxczrz) 多条查询 */
	public List getListQyxxczrz(Qyxxczrz qyxxczrz){
		// TODO: implement
		return qyxxczrzDao.getListQyxxczrz(qyxxczrz);
	}

	public IQyxxczrzDao getQyxxczrzDao() {
		return qyxxczrzDao;
	}

	public void setQyxxczrzDao(IQyxxczrzDao qyxxczrzDao) {
		this.qyxxczrzDao = qyxxczrzDao;
	}
}
