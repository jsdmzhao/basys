package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.ICjdtjrbDao;
import com.aisino2.icksystem.domain.Cjdtjrb;
import com.aisino2.icksystem.service.ICjdtjrbService;

public class CjdtjrbServiceImpl extends BaseService implements ICjdtjrbService {

	private ICjdtjrbDao cjdtjrbDao;

	/** @param 采集端统计日报(t_cjdtjrb) 增加 */
	public Cjdtjrb insertCjdtjrb(Cjdtjrb cjdtjrb){
		// TODO: implement
		return (Cjdtjrb)cjdtjrbDao.insertCjdtjrb(cjdtjrb);
	}

	/** @param 采集端统计日报(t_cjdtjrb) 删除 */
	public boolean deleteCjdtjrb(Cjdtjrb cjdtjrb){
		// TODO: implement
		return cjdtjrbDao.deleteCjdtjrb(cjdtjrb)>0;
	}

	/** @param 采集端统计日报(t_cjdtjrb) 修改 */
	public boolean updateCjdtjrb(Cjdtjrb cjdtjrb){
		// TODO: implement
		return cjdtjrbDao.updateCjdtjrb(cjdtjrb)>0;
	}

	/** @param 采集端统计日报(t_cjdtjrb) 查询单条 */
	public Cjdtjrb getCjdtjrb(Cjdtjrb cjdtjrb){
		// TODO: implement
		return (Cjdtjrb)cjdtjrbDao.getCjdtjrb(cjdtjrb);
	}

	/** @param 采集端统计日报(t_cjdtjrb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		getConditions(map);
		return cjdtjrbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	private void getConditions(Map map) {
		boolean dsbz = ((String) map.get("ssdsbz")).equalsIgnoreCase("1");
		boolean cjdbz = ((String) map.get("cjdbz")).equalsIgnoreCase("1");
	
		String groupBy = "";
		String selectConditon = "";
		if (cjdbz) {
			groupBy = "ssdsbm,ssdsmc,cjdbm,cjdmc";
			selectConditon = groupBy;
		} else if (dsbz) {

			groupBy = "ssdsbm,ssdsmc";
			selectConditon = groupBy 
					+ ",'' as cjdbm,'' as cjdmc";
		} else
		{
			selectConditon = "'' as ssdsbm,'' as ssdsmc,'' as cjdbm,'' as cjdmc";
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
	}
	/** @param 采集端统计日报-企业端(t_cjdtjrb) 分页查询 */
	public Page getListForPageQyd(Map map, int pageNo,int pageSize,String sort,String desc){
		return cjdtjrbDao.getListForPageQyd(map,pageNo,pageSize,sort,desc);
	}
	/** @param 采集端统计日报(t_cjdtjrb) 多条查询 */
	public List getListCjdtjrb(Cjdtjrb cjdtjrb){
		// TODO: implement
		return cjdtjrbDao.getListCjdtjrb(cjdtjrb);
	}

	public ICjdtjrbDao getCjdtjrbDao() {
		return cjdtjrbDao;
	}

	public void setCjdtjrbDao(ICjdtjrbDao cjdtjrbDao) {
		this.cjdtjrbDao = cjdtjrbDao;
	}
	/** @param 采集端日报(t_cjdtjrb) 分页查询 */
	public Page getCjdrbListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return cjdtjrbDao.getCjdrbListForPage(map,pageNo,pageSize,sort,desc);
	}
}
