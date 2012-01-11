package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IYjgzDao;
import com.aisino2.basicsystem.domain.Yjgz;
import com.aisino2.basicsystem.service.IYjgzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class YjgzServiceImpl extends BaseService implements IYjgzService {

	private IYjgzDao yjgzDao;

	/** @param 预警规则(t_yjgz) 增加 */
	public Yjgz insertYjgz(Yjgz yjgz){
		// TODO: implement
		return (Yjgz)yjgzDao.insertYjgz(yjgz);
	}

	/** @param 预警规则(t_yjgz) 删除 */
	public boolean deleteYjgz(Yjgz yjgz){
		// TODO: implement
		return yjgzDao.deleteYjgz(yjgz)>0;
	}

	/** @param 预警规则(t_yjgz) 修改 */
	public boolean updateYjgz(Yjgz yjgz){
		// TODO: implement
		return yjgzDao.updateYjgz(yjgz)>0;
	}

	/** @param 预警规则(t_yjgz) 查询单条 */
	public Yjgz getYjgz(Yjgz yjgz){
		// TODO: implement
		return (Yjgz)yjgzDao.getYjgz(yjgz);
	}

	/** @param 预警规则(t_yjgz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return yjgzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 预警规则(t_yjgz) 多条查询 */
	public List getListYjgz(Yjgz yjgz){
		// TODO: implement
		return yjgzDao.getListYjgz(yjgz);
	}

	public IYjgzDao getYjgzDao() {
		return yjgzDao;
	}

	public void setYjgzDao(IYjgzDao yjgzDao) {
		this.yjgzDao = yjgzDao;
	}
}
