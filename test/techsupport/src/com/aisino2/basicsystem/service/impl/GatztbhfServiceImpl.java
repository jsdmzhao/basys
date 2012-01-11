package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGatztbhfDao;
import com.aisino2.basicsystem.domain.Gatztbhf;
import com.aisino2.basicsystem.service.IGatztbhfService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class GatztbhfServiceImpl extends BaseService implements IGatztbhfService {

	private IGatztbhfDao gatztbhfDao;

	/** @param 公安通知通报回复(t_gatztbhf) 增加 */
	public Gatztbhf insertGatztbhf(Gatztbhf gatztbhf){
		// TODO: implement
		return (Gatztbhf)gatztbhfDao.insertGatztbhf(gatztbhf);
	}

	/** @param 公安通知通报回复(t_gatztbhf) 删除 */
	public boolean deleteGatztbhf(Gatztbhf gatztbhf){
		// TODO: implement
		return gatztbhfDao.deleteGatztbhf(gatztbhf)>0;
	}

	/** @param 公安通知通报回复(t_gatztbhf) 修改 */
	public boolean updateGatztbhf(Gatztbhf gatztbhf){
		// TODO: implement
		return gatztbhfDao.updateGatztbhf(gatztbhf)>0;
	}

	/** @param 公安通知通报回复(t_gatztbhf) 查询单条 */
	public Gatztbhf getGatztbhf(Gatztbhf gatztbhf){
		// TODO: implement
		return (Gatztbhf)gatztbhfDao.getGatztbhf(gatztbhf);
	}

	/** @param 公安通知通报回复(t_gatztbhf) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return gatztbhfDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 公安通知通报回复(t_gatztbhf) 多条查询 */
	public List getListGatztbhf(Gatztbhf gatztbhf){
		// TODO: implement
		return gatztbhfDao.getListGatztbhf(gatztbhf);
	}

	public IGatztbhfDao getGatztbhfDao() {
		return gatztbhfDao;
	}

	public void setGatztbhfDao(IGatztbhfDao gatztbhfDao) {
		this.gatztbhfDao = gatztbhfDao;
	}
}
