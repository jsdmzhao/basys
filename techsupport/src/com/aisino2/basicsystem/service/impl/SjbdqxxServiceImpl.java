package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.ISjbdqxxDao;
import com.aisino2.basicsystem.domain.Sjbdqxx;
import com.aisino2.basicsystem.service.ISjbdqxxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class SjbdqxxServiceImpl extends BaseService implements ISjbdqxxService {

	private ISjbdqxxDao sjbdqxxDao;

	/** @param 手机被盗抢信息(t_sjbdqxx) 增加 */
	public Sjbdqxx insertSjbdqxx(Sjbdqxx sjbdqxx){
		// TODO: implement
		return (Sjbdqxx)sjbdqxxDao.insertSjbdqxx(sjbdqxx);
	}

	/** @param 手机被盗抢信息(t_sjbdqxx) 删除 */
	public boolean deleteSjbdqxx(Sjbdqxx sjbdqxx){
		// TODO: implement
		return sjbdqxxDao.deleteSjbdqxx(sjbdqxx)>0;
	}

	/** @param 手机被盗抢信息(t_sjbdqxx) 修改 */
	public boolean updateSjbdqxx(Sjbdqxx sjbdqxx){
		// TODO: implement
		return sjbdqxxDao.updateSjbdqxx(sjbdqxx)>0;
	}

	/** @param 手机被盗抢信息(t_sjbdqxx) 查询单条 */
	public Sjbdqxx getSjbdqxx(Sjbdqxx sjbdqxx){
		// TODO: implement
		return (Sjbdqxx)sjbdqxxDao.getSjbdqxx(sjbdqxx);
	}

	/** @param 手机被盗抢信息(t_sjbdqxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return sjbdqxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 手机被盗抢信息(t_sjbdqxx) 多条查询 */
	public List getListSjbdqxx(Sjbdqxx sjbdqxx){
		// TODO: implement
		return sjbdqxxDao.getListSjbdqxx(sjbdqxx);
	}
	
	/** 判断手机被盗抢信息 是否已存在 */
	public String isSjbdqxxExist(Sjbdqxx sjbdqxx){
		String result = "1";
		if(sjbdqxxDao.isSjbdqxxExist(sjbdqxx)==null){
			result = "0";
		}
		return result;
	}

	public ISjbdqxxDao getSjbdqxxDao() {
		return sjbdqxxDao;
	}

	public void setSjbdqxxDao(ISjbdqxxDao sjbdqxxDao) {
		this.sjbdqxxDao = sjbdqxxDao;
	}
}
