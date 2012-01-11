package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IOperatelogDao;
import com.aisino2.sysadmin.domain.Operatelog;
import com.aisino2.sysadmin.service.IOperatelogService;

public class OperatelogServiceImpl extends BaseService implements IOperatelogService {

	private IOperatelogDao operatelogDao;

	/** @param 操作日志表(t_operatelog) 增加 */
	public Operatelog insertOperatelog(Operatelog operatelog){
		// TODO: implement
		return (Operatelog)operatelogDao.insertOperatelog(operatelog);
	}

	/** @param 操作日志表(t_operatelog) 删除 */
	public boolean deleteOperatelog(Operatelog operatelog){
		// TODO: implement
		return operatelogDao.deleteOperatelog(operatelog)>0;
	}

	/** @param 操作日志表(t_operatelog) 修改 */
	public boolean updateOperatelog(Operatelog operatelog){
		// TODO: implement
		return operatelogDao.updateOperatelog(operatelog)>0;
	}

	/** @param 操作日志表(t_operatelog) 查询单条 */
	public Operatelog getOperatelog(Operatelog operatelog){
		// TODO: implement
		return (Operatelog)operatelogDao.getOperatelog(operatelog);
	}

	/** @param 操作日志表(t_operatelog) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return operatelogDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 操作日志表(t_operatelog) 多条查询 */
	public List getListOperatelog(Operatelog operatelog){
		// TODO: implement
		return operatelogDao.getListOperatelog(operatelog);
	}

	public IOperatelogDao getOperatelogDao() {
		return operatelogDao;
	}

	public void setOperatelogDao(IOperatelogDao operatelogDao) {
		this.operatelogDao = operatelogDao;
	}
}
