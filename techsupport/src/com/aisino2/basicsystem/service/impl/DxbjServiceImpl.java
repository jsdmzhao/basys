package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IDxbjDao;
import com.aisino2.basicsystem.domain.Dxbj;
import com.aisino2.basicsystem.service.IDxbjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class DxbjServiceImpl extends BaseService implements IDxbjService {

	private IDxbjDao dxbjDao;

	/** @param 短信报警(t_dxbj) 增加 */
	public Dxbj insertDxbj(Dxbj dxbj){
		// TODO: implement
		return (Dxbj)dxbjDao.insertDxbj(dxbj);
	}

	/** @param 短信报警(t_dxbj) 删除 */
	public boolean deleteDxbj(Dxbj dxbj){
		// TODO: implement
		return dxbjDao.deleteDxbj(dxbj)>0;
	}

	/** @param 短信报警(t_dxbj) 修改 */
	public boolean updateDxbj(Dxbj dxbj){
		// TODO: implement
		return dxbjDao.updateDxbj(dxbj)>0;
	}

	/** @param 短信报警(t_dxbj) 查询单条 */
	public Dxbj getDxbj(Dxbj dxbj){
		// TODO: implement
		return (Dxbj)dxbjDao.getDxbj(dxbj);
	}

	/** @param 短信报警(t_dxbj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return dxbjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 短信报警(t_dxbj) 多条查询 */
	public List getListDxbj(Dxbj dxbj){
		// TODO: implement
		return dxbjDao.getListDxbj(dxbj);
	}

	public IDxbjDao getDxbjDao() {
		return dxbjDao;
	}

	public void setDxbjDao(IDxbjDao dxbjDao) {
		this.dxbjDao = dxbjDao;
	}
}
