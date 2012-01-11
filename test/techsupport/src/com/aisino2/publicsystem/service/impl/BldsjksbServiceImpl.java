package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IBldsjksbDao;
import com.aisino2.publicsystem.domain.Bldsjksb;
import com.aisino2.publicsystem.service.IBldsjksbService;

public class BldsjksbServiceImpl extends BaseService implements IBldsjksbService {

	private IBldsjksbDao bldsjksbDao;

	/** @param 闭路电视监控设备(t_bldsjksb) 增加 */
	public Bldsjksb insertBldsjksb(Bldsjksb bldsjksb){
		// TODO: implement
		return (Bldsjksb)bldsjksbDao.insertBldsjksb(bldsjksb);
	}

	/** @param 闭路电视监控设备(t_bldsjksb) 删除 */
	public boolean deleteBldsjksb(Bldsjksb bldsjksb){
		// TODO: implement
		return bldsjksbDao.deleteBldsjksb(bldsjksb)>0;
	}

	/** @param 闭路电视监控设备(t_bldsjksb) 修改 */
	public boolean updateBldsjksb(Bldsjksb bldsjksb){
		// TODO: implement
		return bldsjksbDao.updateBldsjksb(bldsjksb)>0;
	}

	/** @param 闭路电视监控设备(t_bldsjksb) 查询单条 */
	public Bldsjksb getBldsjksb(Bldsjksb bldsjksb){
		// TODO: implement
		return (Bldsjksb)bldsjksbDao.getBldsjksb(bldsjksb);
	}

	/** @param 闭路电视监控设备(t_bldsjksb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bldsjksbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 闭路电视监控设备(t_bldsjksb) 多条查询 */
	public List getListBldsjksb(Bldsjksb bldsjksb){
		// TODO: implement
		return bldsjksbDao.getListBldsjksb(bldsjksb);
	}
	
	/** @param 闭路电视监控设备(t_bldsjksb) 分页查询 公安端闭路电视监控设备查询*/
	public Page getBldsjksbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return bldsjksbDao.getBldsjksbGadListForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** 公共 视频监控设备 公安端 分页查询 */
	public Page getSpjksbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return bldsjksbDao.getSpjksbGadListForPage(map, pageNo, pageSize, sort, desc);
	}

	public IBldsjksbDao getBldsjksbDao() {
		return bldsjksbDao;
	}

	public void setBldsjksbDao(IBldsjksbDao bldsjksbDao) {
		this.bldsjksbDao = bldsjksbDao;
	}
}
