package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IYjxxbDao;
import com.aisino2.basicsystem.domain.Yjxxb;
import com.aisino2.basicsystem.service.IYjxxbService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class YjxxbServiceImpl extends BaseService implements IYjxxbService {

	private IYjxxbDao yjxxbDao;

	/** @param 预警信息表(t_yjxxb) 增加 */
	public Yjxxb insertYjxxb(Yjxxb yjxxb){
		// TODO: implement
		return (Yjxxb)yjxxbDao.insertYjxxb(yjxxb);
	}

	/** @param 预警信息表(t_yjxxb) 删除 */
	public boolean deleteYjxxb(Yjxxb yjxxb){
		// TODO: implement
		return yjxxbDao.deleteYjxxb(yjxxb)>0;
	}

	/** @param 预警信息表(t_yjxxb) 修改 */
	public boolean updateYjxxb(Yjxxb yjxxb){
		// TODO: implement
		return yjxxbDao.updateYjxxb(yjxxb)>0;
	}

	/** @param 预警信息表(t_yjxxb) 查询单条 */
	public Yjxxb getYjxxb(Yjxxb yjxxb){
		// TODO: implement
		return (Yjxxb)yjxxbDao.getYjxxb(yjxxb);
	}

	/** @param 预警信息表(t_yjxxb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return yjxxbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 预警信息表(t_yjxxb) 多条查询 */
	public List getListYjxxb(Yjxxb yjxxb){
		// TODO: implement
		return yjxxbDao.getListYjxxb(yjxxb);
	}

	public IYjxxbDao getYjxxbDao() {
		return yjxxbDao;
	}

	public void setYjxxbDao(IYjxxbDao yjxxbDao) {
		this.yjxxbDao = yjxxbDao;
	}

	public List<Yjxxb> getListYjxxbBDBJ(Yjxxb yjxxb) {
		return yjxxbDao.getListYjxxbBDBJ(yjxxb);
	}

	public Yjxxb insertYjxxbBDBJ(Yjxxb yjxxb) {
		return yjxxbDao.insertYjxxbBDBJ(yjxxb);
	}
}
