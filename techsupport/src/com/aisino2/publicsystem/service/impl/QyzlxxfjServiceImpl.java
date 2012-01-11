package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyzlxxfjDao;
import com.aisino2.publicsystem.domain.Qyzlxxfj;
import com.aisino2.publicsystem.service.IQyzlxxfjService;

public class QyzlxxfjServiceImpl extends BaseService implements IQyzlxxfjService {

	private IQyzlxxfjDao qyzlxxfjDao;

	/** @param 企业质量信息附件(t_qyzlxxfj) 增加 */
	public Qyzlxxfj insertQyzlxxfj(Qyzlxxfj qyzlxxfj){
		// TODO: implement
		return (Qyzlxxfj)qyzlxxfjDao.insertQyzlxxfj(qyzlxxfj);
	}

	/** @param 企业质量信息附件(t_qyzlxxfj) 删除 */
	public boolean deleteQyzlxxfj(Qyzlxxfj qyzlxxfj){
		// TODO: implement
		return qyzlxxfjDao.deleteQyzlxxfj(qyzlxxfj)>0;
	}

	/** @param 企业质量信息附件(t_qyzlxxfj) 修改 */
	public boolean updateQyzlxxfj(Qyzlxxfj qyzlxxfj){
		// TODO: implement
		return qyzlxxfjDao.updateQyzlxxfj(qyzlxxfj)>0;
	}

	/** @param 企业质量信息附件(t_qyzlxxfj) 查询单条 */
	public Qyzlxxfj getQyzlxxfj(Qyzlxxfj qyzlxxfj){
		// TODO: implement
		return (Qyzlxxfj)qyzlxxfjDao.getQyzlxxfj(qyzlxxfj);
	}

	/** @param 企业质量信息附件(t_qyzlxxfj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyzlxxfjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业质量信息附件(t_qyzlxxfj) 多条查询 */
	public List getListQyzlxxfj(Qyzlxxfj qyzlxxfj){
		// TODO: implement
		return qyzlxxfjDao.getListQyzlxxfj(qyzlxxfj);
	}

	public IQyzlxxfjDao getQyzlxxfjDao() {
		return qyzlxxfjDao;
	}

	public void setQyzlxxfjDao(IQyzlxxfjDao qyzlxxfjDao) {
		this.qyzlxxfjDao = qyzlxxfjDao;
	}
}
