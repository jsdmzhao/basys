package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGatztbjsdwDao;
import com.aisino2.basicsystem.domain.Gatztbjsdw;
import com.aisino2.basicsystem.service.IGatztbjsdwService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class GatztbjsdwServiceImpl extends BaseService implements IGatztbjsdwService {

	private IGatztbjsdwDao gatztbjsdwDao;

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 增加 */
	public Gatztbjsdw insertGatztbjsdw(Gatztbjsdw gatztbjsdw){
		// TODO: implement
		return (Gatztbjsdw)gatztbjsdwDao.insertGatztbjsdw(gatztbjsdw);
	}

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 删除 */
	public boolean deleteGatztbjsdw(Gatztbjsdw gatztbjsdw){
		// TODO: implement
		return gatztbjsdwDao.deleteGatztbjsdw(gatztbjsdw)>0;
	}

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 修改 */
	public boolean updateGatztbjsdw(Gatztbjsdw gatztbjsdw){
		// TODO: implement
		return gatztbjsdwDao.updateGatztbjsdw(gatztbjsdw)>0;
	}

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 查询单条 */
	public Gatztbjsdw getGatztbjsdw(Gatztbjsdw gatztbjsdw){
		// TODO: implement
		return (Gatztbjsdw)gatztbjsdwDao.getGatztbjsdw(gatztbjsdw);
	}

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return gatztbjsdwDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 多条查询 */
	public List getListGatztbjsdw(Gatztbjsdw gatztbjsdw){
		// TODO: implement
		return gatztbjsdwDao.getListGatztbjsdw(gatztbjsdw);
	}

	public IGatztbjsdwDao getGatztbjsdwDao() {
		return gatztbjsdwDao;
	}

	public void setGatztbjsdwDao(IGatztbjsdwDao gatztbjsdwDao) {
		this.gatztbjsdwDao = gatztbjsdwDao;
	}
}
