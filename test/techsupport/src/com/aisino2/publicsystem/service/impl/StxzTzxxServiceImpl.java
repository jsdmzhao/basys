package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IStxzTzxxDao;
import com.aisino2.publicsystem.domain.StxzTzxx;
import com.aisino2.publicsystem.service.IStxzTzxxService;

public class StxzTzxxServiceImpl extends BaseService implements IStxzTzxxService {

	private IStxzTzxxDao stxzTzxxDao;

	/** @param 典当台帐信息(t_ddbafwht) 多条查询 */
	public List getListStxzTzxx(StxzTzxx stxzTzxx){
		return stxzTzxxDao.getListStxzTzxx(stxzTzxx);
	}
	/** @param 所有企业信息(企业总数、从业人员总数 点击查看) 
	 * 输入参数： gxdwbm ：管辖单位代码的前N位	N的意义见JxtzxxAction
	 * 分页查询 
	 */
	public Page getListAllQyxxForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return stxzTzxxDao.getListAllQyxxForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 未上传企业信息(未上传企业总数 点击查看) 
	 * 输入参数： gxdwbm ：管辖单位代码的前N位	N的意义见JxtzxxAction
	 * 分页查询 
	 */
	public Page getListWscQyxxForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return stxzTzxxDao.getListWscQyxxForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 上传企业信息(上传机修信息总数 点击查看) 
	 * 输入参数： gxdwbm ：管辖单位代码的前N位	N的意义见JxtzxxAction
	 * 分页查询 
	 */
	public Page getListScQyxxForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return stxzTzxxDao.getListScQyxxForPage(map, pageNo, pageSize, sort, desc);
	}

	public IStxzTzxxDao getStxzTzxxDao() {
		return stxzTzxxDao;
	}

	public void setStxzTzxxDao(IStxzTzxxDao stxzTzxxDao) {
		this.stxzTzxxDao = stxzTzxxDao;
	}
	
}
