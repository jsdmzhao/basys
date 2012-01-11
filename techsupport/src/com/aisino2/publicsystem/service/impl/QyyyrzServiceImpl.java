package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyyyrzDao;
import com.aisino2.publicsystem.domain.Qyyyrz;
import com.aisino2.publicsystem.service.IQyyyrzService;

public class QyyyrzServiceImpl extends BaseService implements IQyyyrzService {

	private IQyyyrzDao qyyyrzDao;

	/** @param 企业营业日志(t_qyyyrz) 增加 */
	public Qyyyrz insertQyyyrz(Qyyyrz qyyyrz){
		// TODO: implement
		return (Qyyyrz)qyyyrzDao.insertQyyyrz(qyyyrz);
	}

	/** @param 企业营业日志(t_qyyyrz) 删除 */
	public boolean deleteQyyyrz(Qyyyrz qyyyrz){
		// TODO: implement
		return qyyyrzDao.deleteQyyyrz(qyyyrz)>0;
	}

	/** @param 企业营业日志(t_qyyyrz) 修改 */
	public boolean updateQyyyrz(Qyyyrz qyyyrz){
		// TODO: implement
		return qyyyrzDao.updateQyyyrz(qyyyrz)>0;
	}

	/** @param 企业营业日志(t_qyyyrz) 查询单条 */
	public Qyyyrz getQyyyrz(Qyyyrz qyyyrz){
		// TODO: implement
		return (Qyyyrz)qyyyrzDao.getQyyyrz(qyyyrz);
	}

	/** @param 企业营业日志(t_qyyyrz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return qyyyrzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** 企业营业日志 公安端查询 标准化公安端*/
	public Page getListForPageYlyBzhGad(Map map, int pageNo,int pageSize,String sort,String desc){
		return qyyyrzDao.getListForPageYlyBzhGad(map, pageNo, pageSize, sort, desc);
	}

	/** @param 企业营业日志(t_qyyyrz) 多条查询 */
	public List getListQyyyrz(Qyyyrz qyyyrz){
		// TODO: implement
		return qyyyrzDao.getListQyyyrz(qyyyrz);
	}
	
	/** @param 企业营业日志(t_qyyyrz) 根据qybm查询负责人信息  */
	public Qyyyrz getQyyyrzFzry(Qyyyrz qyyyrz){
		// TODO: implement
		return (Qyyyrz)qyyyrzDao.getQyyyrzFzry(qyyyrz);
	}
	
	public IQyyyrzDao getQyyyrzDao() {
		return qyyyrzDao;
	}

	public void setQyyyrzDao(IQyyyrzDao qyyyrzDao) {
		this.qyyyrzDao = qyyyrzDao;
	}
}
