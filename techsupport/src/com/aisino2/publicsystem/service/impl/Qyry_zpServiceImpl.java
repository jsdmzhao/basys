package com.aisino2.publicsystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyry_zpDao;
import com.aisino2.publicsystem.domain.Qyry_zp;
import com.aisino2.publicsystem.service.IQyry_zpService;

public class Qyry_zpServiceImpl extends BaseService implements IQyry_zpService {

	private IQyry_zpDao qyry_zpDao;

	/** @param 企业人员_照片(t_qyry_zp) 增加 */
	public Qyry_zp insertQyry_zp(Qyry_zp qyry_zp){
		// TODO: implement
		return (Qyry_zp)qyry_zpDao.insertQyry_zp(qyry_zp);
	}

	/** @param 企业人员_照片(t_qyry_zp) 删除 */
	public boolean deleteQyry_zp(Qyry_zp qyry_zp){
		// TODO: implement
		return qyry_zpDao.deleteQyry_zp(qyry_zp)>0;
	}

	/** @param 企业人员_照片(t_qyry_zp) 修改 */
	public boolean updateQyry_zp(Qyry_zp qyry_zp){
		// TODO: implement
		return qyry_zpDao.updateQyry_zp(qyry_zp)>0;
	}

	/** @param 企业人员_照片(t_qyry_zp) 查询单条 */
	public Qyry_zp getQyry_zp(Qyry_zp qyry_zp){
		// TODO: implement
		return (Qyry_zp)qyry_zpDao.getQyry_zp(qyry_zp);
	}

	/** @param 企业人员_照片(t_qyry_zp) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyry_zpDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业人员_照片(t_qyry_zp) 多条查询 */
	public List getListQyry_zp(Qyry_zp qyry_zp){
		// TODO: implement
		return qyry_zpDao.getListQyry_zp(qyry_zp);
	}
	
	/** 企业人员_照片(t_qyry_zp) 通过人员id判断照片是否存在
	 * @param 需传入将ryid放在qyry_zp中传入
	 * @return boolean true-该人员存在照片 false-该人员不存在照片
	 */
	public boolean isZpExist(Qyry_zp qyry_zp)
	{
		boolean isZpExist = false;
		qyry_zp.setTplx("0");
		qyry_zp.setIsZpExist("1");
		List qyry_zpExistList = new ArrayList();
		qyry_zpExistList = qyry_zpDao.getListQyry_zp(qyry_zp);
		if(qyry_zpExistList!=null)
			if(qyry_zpExistList.size()>0)
				isZpExist = true;
		return isZpExist;
	}

	public IQyry_zpDao getQyry_zpDao() {
		return qyry_zpDao;
	}

	public void setQyry_zpDao(IQyry_zpDao qyry_zpDao) {
		this.qyry_zpDao = qyry_zpDao;
	}
}
