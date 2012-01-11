package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IWbjkdyczrzDao;
import com.aisino2.basicsystem.domain.Wbjkdyczrz;
import com.aisino2.basicsystem.service.IWbjkdyczrzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class WbjkdyczrzServiceImpl extends BaseService implements IWbjkdyczrzService {

	private IWbjkdyczrzDao wbjkdyczrzDao;

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 增加 */
	public Wbjkdyczrz insertWbjkdyczrz(Wbjkdyczrz wbjkdyczrz){
		// TODO: implement
		return (Wbjkdyczrz)wbjkdyczrzDao.insertWbjkdyczrz(wbjkdyczrz);
	}

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 删除 */
	public boolean deleteWbjkdyczrz(Wbjkdyczrz wbjkdyczrz){
		// TODO: implement
		return wbjkdyczrzDao.deleteWbjkdyczrz(wbjkdyczrz)>0;
	}

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 修改 */
	public boolean updateWbjkdyczrz(Wbjkdyczrz wbjkdyczrz){
		// TODO: implement
		return wbjkdyczrzDao.updateWbjkdyczrz(wbjkdyczrz)>0;
	}

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 查询单条 */
	public Wbjkdyczrz getWbjkdyczrz(Wbjkdyczrz wbjkdyczrz){
		// TODO: implement
		return (Wbjkdyczrz)wbjkdyczrzDao.getWbjkdyczrz(wbjkdyczrz);
	}

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wbjkdyczrzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 多条查询 */
	public List getListWbjkdyczrz(Wbjkdyczrz wbjkdyczrz){
		// TODO: implement
		return wbjkdyczrzDao.getListWbjkdyczrz(wbjkdyczrz);
	}

	public IWbjkdyczrzDao getWbjkdyczrzDao() {
		return wbjkdyczrzDao;
	}

	public void setWbjkdyczrzDao(IWbjkdyczrzDao wbjkdyczrzDao) {
		this.wbjkdyczrzDao = wbjkdyczrzDao;
	}
}
