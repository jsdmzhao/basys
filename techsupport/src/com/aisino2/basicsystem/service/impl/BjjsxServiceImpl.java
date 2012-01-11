package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBjjsxDao;
import com.aisino2.basicsystem.domain.Bjjsx;
import com.aisino2.basicsystem.service.IBjjsxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BjjsxServiceImpl extends BaseService implements IBjjsxService {

	private IBjjsxDao bjjsxDao;

	/** @param 报警机刷新(t_bjjsx) 增加 */
	public Bjjsx insertBjjsx(Bjjsx bjjsx){
		// TODO: implement
		return (Bjjsx)bjjsxDao.insertBjjsx(bjjsx);
	}

	/** @param 报警机刷新(t_bjjsx) 删除 */
	public boolean deleteBjjsx(Bjjsx bjjsx){
		// TODO: implement
		return bjjsxDao.deleteBjjsx(bjjsx)>0;
	}

	/** @param 报警机刷新(t_bjjsx) 修改 */
	public boolean updateBjjsx(Bjjsx bjjsx){
		// TODO: implement
		return bjjsxDao.updateBjjsx(bjjsx)>0;
	}

	/** @param 报警机刷新(t_bjjsx) 查询单条 */
	public Bjjsx getBjjsx(Bjjsx bjjsx){
		// TODO: implement
		return (Bjjsx)bjjsxDao.getBjjsx(bjjsx);
	}

	/** @param 报警机刷新(t_bjjsx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bjjsxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 报警机刷新(t_bjjsx) 多条查询 */
	public List getListBjjsx(Bjjsx bjjsx){
		// TODO: implement
		return bjjsxDao.getListBjjsx(bjjsx);
	}

	public IBjjsxDao getBjjsxDao() {
		return bjjsxDao;
	}

	public void setBjjsxDao(IBjjsxDao bjjsxDao) {
		this.bjjsxDao = bjjsxDao;
	}
}
