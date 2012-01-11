package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IQgztjx_kzDao;
import com.aisino2.basicsystem.domain.Qgztjx_kz;
import com.aisino2.basicsystem.service.IQgztjx_kzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class Qgztjx_kzServiceImpl extends BaseService implements IQgztjx_kzService {

	private IQgztjx_kzDao qgztjx_kzDao;

	/** @param 全国在逃简项快照(t_qgztjx_kz) 增加 */
	public Qgztjx_kz insertQgztjx_kz(Qgztjx_kz qgztjx_kz){
		// TODO: implement
		return (Qgztjx_kz)qgztjx_kzDao.insertQgztjx_kz(qgztjx_kz);
	}

	/** @param 全国在逃简项快照(t_qgztjx_kz) 删除 */
	public boolean deleteQgztjx_kz(Qgztjx_kz qgztjx_kz){
		// TODO: implement
		return qgztjx_kzDao.deleteQgztjx_kz(qgztjx_kz)>0;
	}

	/** @param 全国在逃简项快照(t_qgztjx_kz) 修改 */
	public boolean updateQgztjx_kz(Qgztjx_kz qgztjx_kz){
		// TODO: implement
		return qgztjx_kzDao.updateQgztjx_kz(qgztjx_kz)>0;
	}

	/** @param 全国在逃简项快照(t_qgztjx_kz) 查询单条 */
	public Qgztjx_kz getQgztjx_kz(Qgztjx_kz qgztjx_kz){
		// TODO: implement
		return (Qgztjx_kz)qgztjx_kzDao.getQgztjx_kz(qgztjx_kz);
	}

	/** @param 全国在逃简项快照(t_qgztjx_kz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qgztjx_kzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 全国在逃简项快照(t_qgztjx_kz) 多条查询 */
	public List getListQgztjx_kz(Qgztjx_kz qgztjx_kz){
		// TODO: implement
		return qgztjx_kzDao.getListQgztjx_kz(qgztjx_kz);
	}

	public IQgztjx_kzDao getQgztjx_kzDao() {
		return qgztjx_kzDao;
	}

	public void setQgztjx_kzDao(IQgztjx_kzDao qgztjx_kzDao) {
		this.qgztjx_kzDao = qgztjx_kzDao;
	}
}
