package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQybgxxDao;
import com.aisino2.publicsystem.domain.Qybgxx;
import com.aisino2.publicsystem.service.IQybgxxService;

public class QybgxxServiceImpl extends BaseService implements IQybgxxService {

	private IQybgxxDao qybgxxDao;

	/** @param 企业变更信息(t_qybgxx) 增加 */
	public Qybgxx insertQybgxx(Qybgxx qybgxx){
		// TODO: implement
		return (Qybgxx)qybgxxDao.insertQybgxx(qybgxx);
	}

	/** @param 企业变更信息(t_qybgxx) 删除 */
	public boolean deleteQybgxx(Qybgxx qybgxx){
		// TODO: implement
		return qybgxxDao.deleteQybgxx(qybgxx)>0;
	}

	/** @param 企业变更信息(t_qybgxx) 修改 */
	public boolean updateQybgxx(Qybgxx qybgxx){
		// TODO: implement
		return qybgxxDao.updateQybgxx(qybgxx)>0;
	}

	/** @param 企业变更信息(t_qybgxx) 查询单条 */
	public Qybgxx getQybgxx(Qybgxx qybgxx){
		// TODO: implement
		return (Qybgxx)qybgxxDao.getQybgxx(qybgxx);
	}

	/** @param 企业变更信息(t_qybgxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qybgxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业变更信息(t_qybgxx) 多条查询 */
	public List getListQybgxx(Qybgxx qybgxx){
		// TODO: implement
		return qybgxxDao.getListQybgxx(qybgxx);
	}

	public IQybgxxDao getQybgxxDao() {
		return qybgxxDao;
	}

	public void setQybgxxDao(IQybgxxDao qybgxxDao) {
		this.qybgxxDao = qybgxxDao;
	}
}
