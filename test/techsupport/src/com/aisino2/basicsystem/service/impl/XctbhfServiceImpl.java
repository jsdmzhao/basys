package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IXctbhfDao;
import com.aisino2.basicsystem.domain.Xctbhf;
import com.aisino2.basicsystem.service.IXctbhfService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class XctbhfServiceImpl extends BaseService implements IXctbhfService {

	private IXctbhfDao xctbhfDao;

	/** @param 协查通报回复(t_xctbhf) 增加 */
	public Xctbhf insertXctbhf(Xctbhf xctbhf){
		// TODO: implement
		return (Xctbhf)xctbhfDao.insertXctbhf(xctbhf);
	}

	/** @param 协查通报回复(t_xctbhf) 删除 */
	public boolean deleteXctbhf(Xctbhf xctbhf){
		// TODO: implement
		return xctbhfDao.deleteXctbhf(xctbhf)>0;
	}

	/** @param 协查通报回复(t_xctbhf) 修改 */
	public boolean updateXctbhf(Xctbhf xctbhf){
		// TODO: implement
		return xctbhfDao.updateXctbhf(xctbhf)>0;
	}

	/** @param 协查通报回复(t_xctbhf) 查询单条 */
	public Xctbhf getXctbhf(Xctbhf xctbhf){
		// TODO: implement
		return (Xctbhf)xctbhfDao.getXctbhf(xctbhf);
	}

	/** @param 协查通报回复(t_xctbhf) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return xctbhfDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 协查通报回复(t_xctbhf) 多条查询 */
	public List getListXctbhf(Xctbhf xctbhf){
		// TODO: implement
		return xctbhfDao.getListXctbhf(xctbhf);
	}

	public IXctbhfDao getXctbhfDao() {
		return xctbhfDao;
	}

	public void setXctbhfDao(IXctbhfDao xctbhfDao) {
		this.xctbhfDao = xctbhfDao;
	}
	
	/** @param 协查通报回复(t_xctbhf) 分页查询 */
	public Page getcsListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return xctbhfDao.getcsListForPage(map, pageNo, pageSize, sort, desc);
	}
}
