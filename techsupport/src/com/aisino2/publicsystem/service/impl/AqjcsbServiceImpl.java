package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IAqjcsbDao;
import com.aisino2.publicsystem.domain.Aqjcsb;
import com.aisino2.publicsystem.service.IAqjcsbService;

public class AqjcsbServiceImpl extends BaseService implements IAqjcsbService {

	private IAqjcsbDao aqjcsbDao;

	/** @param 安全检查设备(t_aqjcsb) 增加 */
	public Aqjcsb insertAqjcsb(Aqjcsb aqjcsb){
		// TODO: implement
		return (Aqjcsb)aqjcsbDao.insertAqjcsb(aqjcsb);
	}

	/** @param 安全检查设备(t_aqjcsb) 删除 */
	public boolean deleteAqjcsb(Aqjcsb aqjcsb){
		// TODO: implement
		return aqjcsbDao.deleteAqjcsb(aqjcsb)>0;
	}

	/** @param 安全检查设备(t_aqjcsb) 修改 */
	public boolean updateAqjcsb(Aqjcsb aqjcsb){
		// TODO: implement
		return aqjcsbDao.updateAqjcsb(aqjcsb)>0;
	}

	/** @param 安全检查设备(t_aqjcsb) 查询单条 */
	public Aqjcsb getAqjcsb(Aqjcsb aqjcsb){
		// TODO: implement
		return (Aqjcsb)aqjcsbDao.getAqjcsb(aqjcsb);
	}

	/** @param 安全检查设备(t_aqjcsb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return aqjcsbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 安全检查设备(t_aqjcsb) 多条查询 */
	public List getListAqjcsb(Aqjcsb aqjcsb){
		// TODO: implement
		return aqjcsbDao.getListAqjcsb(aqjcsb);
	}
	
	/** @param 安全检查设备(t_aqjcsb) 分页查询  安全检查设备信息查询*/
	public Page getAqjcsbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return aqjcsbDao.getAqjcsbGadListForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** 公共 技防设备 公安端 分页查询 */
	public Page getjfsbGadListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return aqjcsbDao.getjfsbGadListForPage(map, pageNo, pageSize, sort, desc);
	}

	public IAqjcsbDao getAqjcsbDao() {
		return aqjcsbDao;
	}

	public void setAqjcsbDao(IAqjcsbDao aqjcsbDao) {
		this.aqjcsbDao = aqjcsbDao;
	}
}
