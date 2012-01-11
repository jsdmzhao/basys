package com.aisino2.publicsystem.service.impl;

import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IGgQyyhDao;
import com.aisino2.publicsystem.domain.GgQyyh;
import com.aisino2.publicsystem.service.IGgQyyhService;


public class GgQyyhServiceImpl extends BaseService implements IGgQyyhService {
private IGgQyyhDao ggQyyhDao;
	public IGgQyyhDao getGgQyyhDao() {
	return ggQyyhDao;
}

public void setGgQyyhDao(IGgQyyhDao ggQyyhDao) {
	this.ggQyyhDao = ggQyyhDao;
}

	
	
	
	/** 同步增加企业员工用户 */
	public int insertQyYgyh(GgQyyh qyyh){
		return ggQyyhDao.insertQyYgyh(qyyh);
	}
	
	/** 同步修改企业员工用户 */
	public int updateQyYgyh(GgQyyh qyyh){
		return ggQyyhDao.updateQyYgyh(qyyh);
	}

	/** 同步注销典当企业员工用户 */
	public int zhuxQyYgyh(GgQyyh qyyh){
		return ggQyyhDao.zhuxQyYgyh(qyyh);
	}

	/** 同步删除典当企业员工用户 */
	public int delQyYgyh(GgQyyh qyyh){
		return ggQyyhDao.delQyYgyh(qyyh);
	}

	

	
}
