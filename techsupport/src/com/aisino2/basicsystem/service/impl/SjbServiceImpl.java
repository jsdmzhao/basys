package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.ISjbDao;
import com.aisino2.basicsystem.domain.Sjb;
import com.aisino2.basicsystem.service.ISjbService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class SjbServiceImpl extends BaseService implements ISjbService {

	private ISjbDao sjbDao;

	/** @param 数据表(t_sjb) 增加 */
	public Sjb insertSjb(Sjb sjb){
		// TODO: implement
		return (Sjb)sjbDao.insertSjb(sjb);
	}

	/** @param 数据表(t_sjb) 删除 */
	public boolean deleteSjb(Sjb sjb){
		// TODO: implement
		return sjbDao.deleteSjb(sjb)>0;
	}

	/** @param 数据表(t_sjb) 修改 */
	public boolean updateSjb(Sjb sjb){
		// TODO: implement
		return sjbDao.updateSjb(sjb)>0;
	}

	/** @param 数据表(t_sjb) 查询单条 */
	public Sjb getSjb(Sjb sjb){
		// TODO: implement
		return (Sjb)sjbDao.getSjb(sjb);
	}

	/** @param 数据表(t_sjb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return sjbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 数据表(t_sjb) 多条查询 */
	public List getListSjb(Sjb sjb){
		// TODO: implement
		return sjbDao.getListSjb(sjb);
	}

	public ISjbDao getSjbDao() {
		return sjbDao;
	}

	public void setSjbDao(ISjbDao sjbDao) {
		this.sjbDao = sjbDao;
	}
}
