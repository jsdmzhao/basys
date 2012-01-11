package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IWpbjbdtjDao;
import com.aisino2.basicsystem.domain.Wpbjbdtj;
import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.basicsystem.domain.Wpbjxxb;
import com.aisino2.basicsystem.service.IWpbjbdtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class WpbjbdtjServiceImpl extends BaseService implements IWpbjbdtjService {

	private IWpbjbdtjDao wpbjbdtjDao;

	/** @param 物品报警比对条件(t_wpbjbdtj) 增加 */
	public Wpbjbdtj insertWpbjbdtj(Wpbjbdtj wpbjbdtj){
		// TODO: implement
		return (Wpbjbdtj)wpbjbdtjDao.insertWpbjbdtj(wpbjbdtj);
	}

	/** @param 物品报警比对条件(t_wpbjbdtj) 删除 */
	public boolean deleteWpbjbdtj(Wpbjbdtj wpbjbdtj){
		// TODO: implement
		return wpbjbdtjDao.deleteWpbjbdtj(wpbjbdtj)>0;
	}

	/** @param 物品报警比对条件(t_wpbjbdtj) 修改 */
	public boolean updateWpbjbdtj(Wpbjbdtj wpbjbdtj){
		// TODO: implement
		return wpbjbdtjDao.updateWpbjbdtj(wpbjbdtj)>0;
	}

	/** @param 物品报警比对条件(t_wpbjbdtj) 查询单条 */
	public Wpbjbdtj getWpbjbdtj(Wpbjbdtj wpbjbdtj){
		// TODO: implement
		return (Wpbjbdtj)wpbjbdtjDao.getWpbjbdtj(wpbjbdtj);
	}

	/** @param 物品报警比对条件(t_wpbjbdtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wpbjbdtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 物品报警比对条件(t_wpbjbdtj) 多条查询 */
	public List getListWpbjbdtj(Wpbjbdtj wpbjbdtj){
		// TODO: implement
		return wpbjbdtjDao.getListWpbjbdtj(wpbjbdtj);
	}

	public IWpbjbdtjDao getWpbjbdtjDao() {
		return wpbjbdtjDao;
	}

	public void setWpbjbdtjDao(IWpbjbdtjDao wpbjbdtjDao) {
		this.wpbjbdtjDao = wpbjbdtjDao;
	}
	/**
	 * 得到查询的信息
	 */
	public String getBjbdtjSql(Wpbjgz wpbjgz,Wpbjxxb wpbjxxbIn){
		
		return wpbjbdtjDao.getBjbdtjSql(wpbjgz,wpbjxxbIn);
	}
}
