package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IQycfDao;
import com.aisino2.basicsystem.domain.Qycf;
import com.aisino2.basicsystem.service.IQycfService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class QycfServiceImpl extends BaseService implements IQycfService {

	private IQycfDao qycfDao;

	/** @param 企业处罚(t_qycf) 增加 */
	public Qycf insertQycf(Qycf qycf){
		// TODO: implement
		return (Qycf)qycfDao.insertQycf(qycf);
	}

	/** @param 企业处罚(t_qycf) 删除 */
	public boolean deleteQycf(Qycf qycf){
		// TODO: implement
		return qycfDao.deleteQycf(qycf)>0;
	}

	/** @param 企业处罚(t_qycf) 修改 */
	public boolean updateQycf(Qycf qycf){
		// TODO: implement
		return qycfDao.updateQycf(qycf)>0;
	}

	/** @param 企业处罚(t_qycf) 查询单条 */
	public Qycf getQycf(Qycf qycf){
		// TODO: implement
		return (Qycf)qycfDao.getQycf(qycf);
	}

	/** @param 企业处罚(t_qycf) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qycfDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业处罚(t_qycf) 多条查询 */
	public List getListQycf(Qycf qycf){
		// TODO: implement
		return qycfDao.getListQycf(qycf);
	}

	public IQycfDao getQycfDao() {
		return qycfDao;
	}

	public void setQycfDao(IQycfDao qycfDao) {
		this.qycfDao = qycfDao;
	}

	public List getListExportQycf(Map map, String sort, String desc) {
		return qycfDao.getListExportQycf(map, sort, desc);
	}
}
