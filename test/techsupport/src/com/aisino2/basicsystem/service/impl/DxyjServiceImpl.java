package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IDxyjDao;
import com.aisino2.basicsystem.domain.Dxyj;
import com.aisino2.basicsystem.service.IDxyjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class DxyjServiceImpl extends BaseService implements IDxyjService {

	private IDxyjDao dxyjDao;

	/** @param 短信预警(t_dxyj) 增加 */
	public Dxyj insertDxyj(Dxyj dxyj){
		// TODO: implement
		return (Dxyj)dxyjDao.insertDxyj(dxyj);
	}

	/** @param 短信预警(t_dxyj) 删除 */
	public boolean deleteDxyj(Dxyj dxyj){
		// TODO: implement
		return dxyjDao.deleteDxyj(dxyj)>0;
	}

	/** @param 短信预警(t_dxyj) 修改 */
	public boolean updateDxyj(Dxyj dxyj){
		// TODO: implement
		return dxyjDao.updateDxyj(dxyj)>0;
	}

	/** @param 短信预警(t_dxyj) 查询单条 */
	public Dxyj getDxyj(Dxyj dxyj){
		// TODO: implement
		return (Dxyj)dxyjDao.getDxyj(dxyj);
	}

	/** @param 短信预警(t_dxyj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return dxyjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 短信预警(t_dxyj) 多条查询 */
	public List getListDxyj(Dxyj dxyj){
		// TODO: implement
		return dxyjDao.getListDxyj(dxyj);
	}

	public IDxyjDao getDxyjDao() {
		return dxyjDao;
	}

	public void setDxyjDao(IDxyjDao dxyjDao) {
		this.dxyjDao = dxyjDao;
	}
}
