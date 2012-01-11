package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IWgcyryxxDao;
import com.aisino2.publicsystem.domain.Wgcyryxx;
import com.aisino2.publicsystem.service.IWgcyryxxService;

public class WgcyryxxServiceImpl extends BaseService implements IWgcyryxxService {

	private IWgcyryxxDao wgcyryxxDao;

	/** @param 外国从业人员信息(t_wgcyryxx) 增加 */
	public Wgcyryxx insertWgcyryxx(Wgcyryxx wgcyryxx){
		// TODO: implement
		return (Wgcyryxx)wgcyryxxDao.insertWgcyryxx(wgcyryxx);
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 删除 */
	public boolean deleteWgcyryxx(Wgcyryxx wgcyryxx){
		// TODO: implement
		return wgcyryxxDao.deleteWgcyryxx(wgcyryxx)>0;
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 修改 */
	public boolean updateWgcyryxx(Wgcyryxx wgcyryxx){
		// TODO: implement
		return wgcyryxxDao.updateWgcyryxx(wgcyryxx)>0;
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 查询单条 */
	public Wgcyryxx getWgcyryxx(Wgcyryxx wgcyryxx){
		// TODO: implement
		return (Wgcyryxx)wgcyryxxDao.getWgcyryxx(wgcyryxx);
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wgcyryxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 多条查询 */
	public List getListWgcyryxx(Wgcyryxx wgcyryxx){
		// TODO: implement
		return wgcyryxxDao.getListWgcyryxx(wgcyryxx);
	}

	public IWgcyryxxDao getWgcyryxxDao() {
		return wgcyryxxDao;
	}

	public void setWgcyryxxDao(IWgcyryxxDao wgcyryxxDao) {
		this.wgcyryxxDao = wgcyryxxDao;
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 人员查询、注销查询 */
	public Page getListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wgcyryxxDao.getListGadForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  公安端 派出所审核查询 市局审核查询*/
	public Page getListGadForPageRysh(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return wgcyryxxDao.getListGadForPageRysh(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 企业人员查询*/
	public Page getListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return wgcyryxxDao.getListQydForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param  外国从业人员信息(t_wgcyryxx) 分页查询  由场所ID或场所编码获得该场所下从业人员*/
	public Page getCyryxxListByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wgcyryxxDao.getCyryxxListByCsidForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 删除查询*/
	public Page getScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return wgcyryxxDao.getScListGadForPage(map,pageNo,pageSize,sort,desc);
	}
}
