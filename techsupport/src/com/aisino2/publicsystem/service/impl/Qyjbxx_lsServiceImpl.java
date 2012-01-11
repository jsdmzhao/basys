package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyjbxx_lsDao;
import com.aisino2.publicsystem.domain.Qyjbxx_ls;
import com.aisino2.publicsystem.service.IQyjbxx_lsService;

public class Qyjbxx_lsServiceImpl extends BaseService implements IQyjbxx_lsService {

	private IQyjbxx_lsDao qyjbxx_lsDao;

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 增加 */
	public Qyjbxx_ls insertQyjbxx_ls(Qyjbxx_ls qyjbxx_ls){
		// TODO: implement
		return (Qyjbxx_ls)qyjbxx_lsDao.insertQyjbxx_ls(qyjbxx_ls);
	}

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 删除 */
	public boolean deleteQyjbxx_ls(Qyjbxx_ls qyjbxx_ls){
		// TODO: implement
		return qyjbxx_lsDao.deleteQyjbxx_ls(qyjbxx_ls)>0;
	}

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 修改 */
	public boolean updateQyjbxx_ls(Qyjbxx_ls qyjbxx_ls){
		// TODO: implement
		return qyjbxx_lsDao.updateQyjbxx_ls(qyjbxx_ls)>0;
	}

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 查询单条 */
	public Qyjbxx_ls getQyjbxx_ls(Qyjbxx_ls qyjbxx_ls){
		// TODO: implement
		return (Qyjbxx_ls)qyjbxx_lsDao.getQyjbxx_ls(qyjbxx_ls);
	}

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyjbxx_lsDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 多条查询 */
	public List getListQyjbxx_ls(Qyjbxx_ls qyjbxx_ls){
		// TODO: implement
		return qyjbxx_lsDao.getListQyjbxx_ls(qyjbxx_ls);
	}
	
	/**
	 * 判断是否为指定企业的操作类型为变更的最新一条历史记录
	 * @param qyjbxx_ls(qyid,qylsid)
	 * @return 0-不是最新历史记录 1-是最新历史记录
	 */
	public String isLatestBgQyjbxx_ls(Qyjbxx_ls qyjbxx_ls)
	{
		String isLatestBgQyjbxx_lsFlag = "0";
		Qyjbxx_ls qyjbxx_lsLatest = new Qyjbxx_ls();
		qyjbxx_lsLatest = qyjbxx_lsDao.getLatestBgQyjbxx_ls(qyjbxx_ls);
		if(qyjbxx_lsLatest != null) 
			isLatestBgQyjbxx_lsFlag = "1";
		return isLatestBgQyjbxx_lsFlag;
	}
	
	/** @param 企业基本信息—历史(t_qyjbxx_ls) 查询指定企业且操作类型为变更的某条历史记录的下一条记录(即qylsid较大的一条) */
	public Qyjbxx_ls getNextBgQyjbxx_ls(Qyjbxx_ls qyjbxx_ls)
	{
		return qyjbxx_lsDao.getNextBgQyjbxx_ls(qyjbxx_ls);
	}

	public IQyjbxx_lsDao getQyjbxx_lsDao() {
		return qyjbxx_lsDao;
	}

	public void setQyjbxx_lsDao(IQyjbxx_lsDao qyjbxx_lsDao) {
		this.qyjbxx_lsDao = qyjbxx_lsDao;
	}
}
