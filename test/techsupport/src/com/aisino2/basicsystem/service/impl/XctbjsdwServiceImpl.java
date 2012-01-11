package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IXctbjsdwDao;
import com.aisino2.basicsystem.domain.Xctbjsdw;
import com.aisino2.basicsystem.service.IXctbjsdwService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class XctbjsdwServiceImpl extends BaseService implements IXctbjsdwService {

	private IXctbjsdwDao xctbjsdwDao;

	/** @param 协查通报接收单位(t_xctbjsdw) 增加 */
	public Xctbjsdw insertXctbjsdw(Xctbjsdw xctbjsdw){
		// TODO: implement
		return (Xctbjsdw)xctbjsdwDao.insertXctbjsdw(xctbjsdw);
	}

	/** @param 协查通报接收单位(t_xctbjsdw) 删除 */
	public boolean deleteXctbjsdw(Xctbjsdw xctbjsdw){
		// TODO: implement
		return xctbjsdwDao.deleteXctbjsdw(xctbjsdw)>0;
	}

	/** @param 协查通报接收单位(t_xctbjsdw) 修改 */
	public boolean updateXctbjsdw(Xctbjsdw xctbjsdw){
		// TODO: implement
		return xctbjsdwDao.updateXctbjsdw(xctbjsdw)>0;
	}

	/** @param 协查通报接收单位(t_xctbjsdw) 查询单条 */
	public Xctbjsdw getXctbjsdw(Xctbjsdw xctbjsdw){
		// TODO: implement
		return (Xctbjsdw)xctbjsdwDao.getXctbjsdw(xctbjsdw);
	}

	/** @param 协查通报接收单位(t_xctbjsdw) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return xctbjsdwDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	
	/** @param 协查通报接收单位(t_xctbjsdw) 分页查询 */
	public Page getListForPageHf(Map map, int pageNo,int pageSize,String sort,String desc){
		return xctbjsdwDao.getListForPageHf(map, pageNo, pageSize, sort, desc);
	}

	/** @param 协查通报接收单位(t_xctbjsdw) 多条查询 */
	public List getListXctbjsdw(Xctbjsdw xctbjsdw){
		// TODO: implement
		return xctbjsdwDao.getListXctbjsdw(xctbjsdw);
	}

	public IXctbjsdwDao getXctbjsdwDao() {
		return xctbjsdwDao;
	}

	public void setXctbjsdwDao(IXctbjsdwDao xctbjsdwDao) {
		this.xctbjsdwDao = xctbjsdwDao;
	}
}
