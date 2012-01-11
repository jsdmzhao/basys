package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIckrzjlDao;
import com.aisino2.icksystem.domain.Ickrzjl;
import com.aisino2.icksystem.service.IIckrzjlService;

public class IckrzjlServiceImpl extends BaseService implements IIckrzjlService {

	private IIckrzjlDao ickrzjlDao;

	/** @param IC卡日志记录(t_ickrzjl) 增加 */
	public Ickrzjl insertIckrzjl(Ickrzjl ickrzjl){
		// TODO: implement
		return (Ickrzjl)ickrzjlDao.insertIckrzjl(ickrzjl);
	}

	/** @param IC卡日志记录(t_ickrzjl) 删除 */
	public boolean deleteIckrzjl(Ickrzjl ickrzjl){
		// TODO: implement
		return ickrzjlDao.deleteIckrzjl(ickrzjl)>0;
	}

	/** @param IC卡日志记录(t_ickrzjl) 修改 */
	public boolean updateIckrzjl(Ickrzjl ickrzjl){
		// TODO: implement
		return ickrzjlDao.updateIckrzjl(ickrzjl)>0;
	}

	/** @param IC卡日志记录(t_ickrzjl) 查询单条 */
	public Ickrzjl getIckrzjl(Ickrzjl ickrzjl){
		// TODO: implement
		return (Ickrzjl)ickrzjlDao.getIckrzjl(ickrzjl);
	}

	/** @param IC卡日志记录(t_ickrzjl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return ickrzjlDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param IC卡日志记录(t_ickrzjl) 多条查询 */
	public List getListIckrzjl(Ickrzjl ickrzjl){
		// TODO: implement
		return ickrzjlDao.getListIckrzjl(ickrzjl);
	}

	public IIckrzjlDao getIckrzjlDao() {
		return ickrzjlDao;
	}

	public void setIckrzjlDao(IIckrzjlDao ickrzjlDao) {
		this.ickrzjlDao = ickrzjlDao;
	}
}
