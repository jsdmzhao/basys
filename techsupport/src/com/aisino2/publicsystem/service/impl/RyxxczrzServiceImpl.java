package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IRyxxczrzDao;
import com.aisino2.publicsystem.domain.Ryxxczrz;
import com.aisino2.publicsystem.service.IRyxxczrzService;

public class RyxxczrzServiceImpl extends BaseService implements IRyxxczrzService {

	private IRyxxczrzDao ryxxczrzDao;

	/** @param 人员信息操作日志(t_ryxxczrz) 增加 */
	public Ryxxczrz insertRyxxczrz(Ryxxczrz ryxxczrz){
		// TODO: implement
		return (Ryxxczrz)ryxxczrzDao.insertRyxxczrz(ryxxczrz);
	}

	/** @param 人员信息操作日志(t_ryxxczrz) 删除 */
	public boolean deleteRyxxczrz(Ryxxczrz ryxxczrz){
		// TODO: implement
		return ryxxczrzDao.deleteRyxxczrz(ryxxczrz)>0;
	}

	/** @param 人员信息操作日志(t_ryxxczrz) 修改 */
	public boolean updateRyxxczrz(Ryxxczrz ryxxczrz){
		// TODO: implement
		return ryxxczrzDao.updateRyxxczrz(ryxxczrz)>0;
	}

	/** @param 人员信息操作日志(t_ryxxczrz) 查询单条 */
	public Ryxxczrz getRyxxczrz(Ryxxczrz ryxxczrz){
		// TODO: implement
		return (Ryxxczrz)ryxxczrzDao.getRyxxczrz(ryxxczrz);
	}

	/** @param 人员信息操作日志(t_ryxxczrz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return ryxxczrzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 人员信息操作日志(t_ryxxczrz) 多条查询 */
	public List getListRyxxczrz(Ryxxczrz ryxxczrz){
		// TODO: implement
		return ryxxczrzDao.getListRyxxczrz(ryxxczrz);
	}

	public IRyxxczrzDao getRyxxczrzDao() {
		return ryxxczrzDao;
	}

	public void setRyxxczrzDao(IRyxxczrzDao ryxxczrzDao) {
		this.ryxxczrzDao = ryxxczrzDao;
	}
}
