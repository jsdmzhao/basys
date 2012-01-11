package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IYjbdtjDao;
import com.aisino2.basicsystem.domain.Yjbdtj;
import com.aisino2.basicsystem.service.IYjbdtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class YjbdtjServiceImpl extends BaseService implements IYjbdtjService {

	private IYjbdtjDao yjbdtjDao;

	/** @param 预警比对条件(t_yjbdtj) 增加 */
	public Yjbdtj insertYjbdtj(Yjbdtj yjbdtj){
		// TODO: implement
		return (Yjbdtj)yjbdtjDao.insertYjbdtj(yjbdtj);
	}

	/** @param 预警比对条件(t_yjbdtj) 删除 */
	public boolean deleteYjbdtj(Yjbdtj yjbdtj){
		// TODO: implement
		return yjbdtjDao.deleteYjbdtj(yjbdtj)>0;
	}

	/** @param 预警比对条件(t_yjbdtj) 修改 */
	public boolean updateYjbdtj(Yjbdtj yjbdtj){
		// TODO: implement
		return yjbdtjDao.updateYjbdtj(yjbdtj)>0;
	}

	/** @param 预警比对条件(t_yjbdtj) 查询单条 */
	public Yjbdtj getYjbdtj(Yjbdtj yjbdtj){
		// TODO: implement
		return (Yjbdtj)yjbdtjDao.getYjbdtj(yjbdtj);
	}

	/** @param 预警比对条件(t_yjbdtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return yjbdtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 预警比对条件(t_yjbdtj) 多条查询 */
	public List getListYjbdtj(Yjbdtj yjbdtj){
		// TODO: implement
		return yjbdtjDao.getListYjbdtj(yjbdtj);
	}

	public IYjbdtjDao getYjbdtjDao() {
		return yjbdtjDao;
	}

	public void setYjbdtjDao(IYjbdtjDao yjbdtjDao) {
		this.yjbdtjDao = yjbdtjDao;
	}
}
