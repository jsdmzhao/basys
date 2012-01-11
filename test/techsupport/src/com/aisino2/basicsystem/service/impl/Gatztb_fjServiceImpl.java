package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGatztb_fjDao;
import com.aisino2.basicsystem.domain.Gatztb_fj;
import com.aisino2.basicsystem.service.IGatztb_fjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class Gatztb_fjServiceImpl extends BaseService implements IGatztb_fjService {

	private IGatztb_fjDao gatztb_fjDao;

	/** @param 公安通知通报_附件(t_gatztb_fj) 增加 */
	public Gatztb_fj insertGatztb_fj(Gatztb_fj gatztb_fj){
		// TODO: implement
		return (Gatztb_fj)gatztb_fjDao.insertGatztb_fj(gatztb_fj);
	}

	/** @param 公安通知通报_附件(t_gatztb_fj) 删除 */
	public boolean deleteGatztb_fj(Gatztb_fj gatztb_fj){
		// TODO: implement
		return gatztb_fjDao.deleteGatztb_fj(gatztb_fj)>0;
	}

	/** @param 公安通知通报_附件(t_gatztb_fj) 修改 */
	public boolean updateGatztb_fj(Gatztb_fj gatztb_fj){
		// TODO: implement
		return gatztb_fjDao.updateGatztb_fj(gatztb_fj)>0;
	}

	/** @param 公安通知通报_附件(t_gatztb_fj) 查询单条 */
	public Gatztb_fj getGatztb_fj(Gatztb_fj gatztb_fj){
		// TODO: implement
		return (Gatztb_fj)gatztb_fjDao.getGatztb_fj(gatztb_fj);
	}

	/** @param 公安通知通报_附件(t_gatztb_fj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return gatztb_fjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 公安通知通报_附件(t_gatztb_fj) 多条查询 */
	public List getListGatztb_fj(Gatztb_fj gatztb_fj){
		// TODO: implement
		return gatztb_fjDao.getListGatztb_fj(gatztb_fj);
	}

	public IGatztb_fjDao getGatztb_fjDao() {
		return gatztb_fjDao;
	}

	public void setGatztb_fjDao(IGatztb_fjDao gatztb_fjDao) {
		this.gatztb_fjDao = gatztb_fjDao;
	}
}
