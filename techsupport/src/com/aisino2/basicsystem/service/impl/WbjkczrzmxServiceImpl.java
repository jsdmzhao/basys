package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IWbjkczrzmxDao;
import com.aisino2.basicsystem.domain.Wbjkczrzmx;
import com.aisino2.basicsystem.service.IWbjkczrzmxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class WbjkczrzmxServiceImpl extends BaseService implements IWbjkczrzmxService {

	private IWbjkczrzmxDao wbjkczrzmxDao;

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 增加 */
	public Wbjkczrzmx insertWbjkczrzmx(Wbjkczrzmx wbjkczrzmx){
		// TODO: implement
		return (Wbjkczrzmx)wbjkczrzmxDao.insertWbjkczrzmx(wbjkczrzmx);
	}

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 删除 */
	public boolean deleteWbjkczrzmx(Wbjkczrzmx wbjkczrzmx){
		// TODO: implement
		return wbjkczrzmxDao.deleteWbjkczrzmx(wbjkczrzmx)>0;
	}

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 修改 */
	public boolean updateWbjkczrzmx(Wbjkczrzmx wbjkczrzmx){
		// TODO: implement
		return wbjkczrzmxDao.updateWbjkczrzmx(wbjkczrzmx)>0;
	}

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 查询单条 */
	public Wbjkczrzmx getWbjkczrzmx(Wbjkczrzmx wbjkczrzmx){
		// TODO: implement
		return (Wbjkczrzmx)wbjkczrzmxDao.getWbjkczrzmx(wbjkczrzmx);
	}

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wbjkczrzmxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 多条查询 */
	public List getListWbjkczrzmx(Wbjkczrzmx wbjkczrzmx){
		// TODO: implement
		return wbjkczrzmxDao.getListWbjkczrzmx(wbjkczrzmx);
	}

	public IWbjkczrzmxDao getWbjkczrzmxDao() {
		return wbjkczrzmxDao;
	}

	public void setWbjkczrzmxDao(IWbjkczrzmxDao wbjkczrzmxDao) {
		this.wbjkczrzmxDao = wbjkczrzmxDao;
	}
}
