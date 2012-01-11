package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IZdycxtjDao;
import com.aisino2.basicsystem.domain.Zdycxtj;
import com.aisino2.basicsystem.service.IZdycxtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class ZdycxtjServiceImpl extends BaseService implements IZdycxtjService {

	private IZdycxtjDao zdycxtjDao;

	/** @param 自定义查询条件(t_zdycxtj) 增加 */
	public Zdycxtj insertZdycxtj(Zdycxtj zdycxtj){
		// TODO: implement
		return (Zdycxtj)zdycxtjDao.insertZdycxtj(zdycxtj);
	}

	/** @param 自定义查询条件(t_zdycxtj) 删除 */
	public boolean deleteZdycxtj(Zdycxtj zdycxtj){
		// TODO: implement
		return zdycxtjDao.deleteZdycxtj(zdycxtj)>0;
	}

	/** @param 自定义查询条件(t_zdycxtj) 修改 */
	public boolean updateZdycxtj(Zdycxtj zdycxtj){
		// TODO: implement
		return zdycxtjDao.updateZdycxtj(zdycxtj)>0;
	}

	/** @param 自定义查询条件(t_zdycxtj) 查询单条 */
	public Zdycxtj getZdycxtj(Zdycxtj zdycxtj){
		// TODO: implement
		return (Zdycxtj)zdycxtjDao.getZdycxtj(zdycxtj);
	}

	/** @param 自定义查询条件(t_zdycxtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return zdycxtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 自定义查询条件(t_zdycxtj) 多条查询 */
	public List getListZdycxtj(Zdycxtj zdycxtj){
		// TODO: implement
		return zdycxtjDao.getListZdycxtj(zdycxtj);
	}

	public IZdycxtjDao getZdycxtjDao() {
		return zdycxtjDao;
	}

	public void setZdycxtjDao(IZdycxtjDao zdycxtjDao) {
		this.zdycxtjDao = zdycxtjDao;
	}
}
