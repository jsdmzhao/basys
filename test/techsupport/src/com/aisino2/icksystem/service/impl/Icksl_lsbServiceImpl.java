package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIcksl_lsbDao;
import com.aisino2.icksystem.domain.Icksl_lsb;
import com.aisino2.icksystem.service.IIcksl_lsbService;

public class Icksl_lsbServiceImpl extends BaseService implements IIcksl_lsbService {

	private IIcksl_lsbDao icksl_lsbDao;

	/** @param IC卡受理临时表(t_icksl_lsb) 增加 */
	public Icksl_lsb insertIcksl_lsb(Icksl_lsb icksl_lsb){
		// TODO: implement
		return (Icksl_lsb)icksl_lsbDao.insertIcksl_lsb(icksl_lsb);
	}

	/** @param IC卡受理临时表(t_icksl_lsb) 删除 */
	public boolean deleteIcksl_lsb(Icksl_lsb icksl_lsb){
		// TODO: implement
		return icksl_lsbDao.deleteIcksl_lsb(icksl_lsb)>0;
	}

	/** @param IC卡受理临时表(t_icksl_lsb) 修改 */
	public boolean updateIcksl_lsb(Icksl_lsb icksl_lsb){
		// TODO: implement
		return icksl_lsbDao.updateIcksl_lsb(icksl_lsb)>0;
	}

	/** @param IC卡受理临时表(t_icksl_lsb) 查询单条 */
	public Icksl_lsb getIcksl_lsb(Icksl_lsb icksl_lsb){
		// TODO: implement
		return (Icksl_lsb)icksl_lsbDao.getIcksl_lsb(icksl_lsb);
	}

	/** @param IC卡受理临时表(t_icksl_lsb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return icksl_lsbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param IC卡受理临时表(t_icksl_lsb) 多条查询 */
	public List getListIcksl_lsb(Icksl_lsb icksl_lsb){
		// TODO: implement
		return icksl_lsbDao.getListIcksl_lsb(icksl_lsb);
	}

	public IIcksl_lsbDao getIcksl_lsbDao() {
		return icksl_lsbDao;
	}

	public void setIcksl_lsbDao(IIcksl_lsbDao icksl_lsbDao) {
		this.icksl_lsbDao = icksl_lsbDao;
	}
}
