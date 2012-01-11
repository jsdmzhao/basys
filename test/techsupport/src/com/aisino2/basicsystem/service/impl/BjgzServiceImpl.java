package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBjgzDao;
import com.aisino2.basicsystem.domain.Bjgz;
import com.aisino2.basicsystem.service.IBjgzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BjgzServiceImpl extends BaseService implements IBjgzService {

	private IBjgzDao bjgzDao;

	/** @param 报警规则(t_bjgz) 增加 */
	public Bjgz insertBjgz(Bjgz bjgz){
		// TODO: implement
		return (Bjgz)bjgzDao.insertBjgz(bjgz);
	}

	/** @param 报警规则(t_bjgz) 删除 */
	public boolean deleteBjgz(Bjgz bjgz){
		// TODO: implement
		return bjgzDao.deleteBjgz(bjgz)>0;
	}

	/** @param 报警规则(t_bjgz) 修改 */
	public boolean updateBjgz(Bjgz bjgz){
		// TODO: implement
		return bjgzDao.updateBjgz(bjgz)>0;
	}

	/** @param 报警规则(t_bjgz) 查询单条 */
	public Bjgz getBjgz(Bjgz bjgz){
		// TODO: implement
		return (Bjgz)bjgzDao.getBjgz(bjgz);
	}

	/** @param 报警规则(t_bjgz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bjgzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 报警规则(t_bjgz) 多条查询 */
	public List getListBjgz(Bjgz bjgz){
		// TODO: implement
		return bjgzDao.getListBjgz(bjgz);
	}

	public IBjgzDao getBjgzDao() {
		return bjgzDao;
	}

	public void setBjgzDao(IBjgzDao bjgzDao) {
		this.bjgzDao = bjgzDao;
	}
}
