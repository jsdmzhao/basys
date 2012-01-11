package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyjcxxDao;
import com.aisino2.publicsystem.domain.Qyjcxx;
import com.aisino2.publicsystem.service.IQyjcxxService;

public class QyjcxxServiceImpl extends BaseService implements IQyjcxxService {

	private IQyjcxxDao qyjcxxDao;

	/** @param 企业奖惩信息(t_qyjcxx) 增加 */
	public Qyjcxx insertQyjcxx(Qyjcxx qyjcxx){
		// TODO: implement
		return (Qyjcxx)qyjcxxDao.insertQyjcxx(qyjcxx);
	}

	/** @param 企业奖惩信息(t_qyjcxx) 删除 */
	public boolean deleteQyjcxx(Qyjcxx qyjcxx){
		// TODO: implement
		return qyjcxxDao.deleteQyjcxx(qyjcxx)>0;
	}

	/** @param 企业奖惩信息(t_qyjcxx) 修改 */
	public boolean updateQyjcxx(Qyjcxx qyjcxx){
		// TODO: implement
		return qyjcxxDao.updateQyjcxx(qyjcxx)>0;
	}

	/** @param 企业奖惩信息(t_qyjcxx) 查询单条 */
	public Qyjcxx getQyjcxx(Qyjcxx qyjcxx){
		// TODO: implement
		return (Qyjcxx)qyjcxxDao.getQyjcxx(qyjcxx);
	}

	/** @param 企业奖惩信息(t_qyjcxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyjcxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业奖惩信息(t_qyjcxx) 多条查询 */
	public List getListQyjcxx(Qyjcxx qyjcxx){
		// TODO: implement
		return qyjcxxDao.getListQyjcxx(qyjcxx);
	}

	public IQyjcxxDao getQyjcxxDao() {
		return qyjcxxDao;
	}

	public void setQyjcxxDao(IQyjcxxDao qyjcxxDao) {
		this.qyjcxxDao = qyjcxxDao;
	}
}
