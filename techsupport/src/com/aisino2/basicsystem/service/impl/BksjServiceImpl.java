package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBksjDao;
import com.aisino2.basicsystem.domain.Bksj;
import com.aisino2.basicsystem.service.IBksjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BksjServiceImpl extends BaseService implements IBksjService {

	private IBksjDao bksjDao;

	/** @param 布控手机(t_bksj) 增加 */
	public Bksj insertBksj(Bksj bksj){
		// TODO: implement
		return (Bksj)bksjDao.insertBksj(bksj);
	}

	/** @param 布控手机(t_bksj) 删除 */
	public boolean deleteBksj(Bksj bksj){
		// TODO: implement
		return bksjDao.deleteBksj(bksj)>0;
	}

	/** @param 布控手机(t_bksj) 修改 */
	public boolean updateBksj(Bksj bksj){
		// TODO: implement
		return bksjDao.updateBksj(bksj)>0;
	}

	/** @param 布控手机(t_bksj) 查询单条 */
	public Bksj getBksj(Bksj bksj){
		// TODO: implement
		return (Bksj)bksjDao.getBksj(bksj);
	}

	/** @param 布控手机(t_bksj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bksjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 布控手机(t_bksj) 多条查询 */
	public List getListBksj(Bksj bksj){
		// TODO: implement
		return bksjDao.getListBksj(bksj);
	}

	public IBksjDao getBksjDao() {
		return bksjDao;
	}

	public void setBksjDao(IBksjDao bksjDao) {
		this.bksjDao = bksjDao;
	}
}
