package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.ISjbjgDao;
import com.aisino2.basicsystem.domain.Sjbjg;
import com.aisino2.basicsystem.service.ISjbjgService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class SjbjgServiceImpl extends BaseService implements ISjbjgService {

	private ISjbjgDao sjbjgDao;

	/** @param 数据表结构(t_sjbjg) 增加 */
	public Sjbjg insertSjbjg(Sjbjg sjbjg){
		// TODO: implement
		return (Sjbjg)sjbjgDao.insertSjbjg(sjbjg);
	}

	/** @param 数据表结构(t_sjbjg) 删除 */
	public boolean deleteSjbjg(Sjbjg sjbjg){
		// TODO: implement
		return sjbjgDao.deleteSjbjg(sjbjg)>0;
	}

	/** @param 数据表结构(t_sjbjg) 修改 */
	public boolean updateSjbjg(Sjbjg sjbjg){
		// TODO: implement
		return sjbjgDao.updateSjbjg(sjbjg)>0;
	}

	/** @param 数据表结构(t_sjbjg) 查询单条 */
	public Sjbjg getSjbjg(Sjbjg sjbjg){
		// TODO: implement
		return (Sjbjg)sjbjgDao.getSjbjg(sjbjg);
	}

	/** @param 数据表结构(t_sjbjg) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return sjbjgDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 数据表结构(t_sjbjg) 多条查询 */
	public List getListSjbjg(Sjbjg sjbjg){
		// TODO: implement
		return sjbjgDao.getListSjbjg(sjbjg);
	}

	public ISjbjgDao getSjbjgDao() {
		return sjbjgDao;
	}

	public void setSjbjgDao(ISjbjgDao sjbjgDao) {
		this.sjbjgDao = sjbjgDao;
	}
}
