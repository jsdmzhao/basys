package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.ISjbdqxxkzDao;
import com.aisino2.basicsystem.domain.Sjbdqxxkz;
import com.aisino2.basicsystem.service.ISjbdqxxkzService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class SjbdqxxkzServiceImpl extends BaseService implements ISjbdqxxkzService {

	private ISjbdqxxkzDao sjbdqxxkzDao;

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 增加 */
	public Sjbdqxxkz insertSjbdqxxkz(Sjbdqxxkz sjbdqxxkz){
		// TODO: implement
		return (Sjbdqxxkz)sjbdqxxkzDao.insertSjbdqxxkz(sjbdqxxkz);
	}

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 删除 */
	public boolean deleteSjbdqxxkz(Sjbdqxxkz sjbdqxxkz){
		// TODO: implement
		return sjbdqxxkzDao.deleteSjbdqxxkz(sjbdqxxkz)>0;
	}

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 修改 */
	public boolean updateSjbdqxxkz(Sjbdqxxkz sjbdqxxkz){
		// TODO: implement
		return sjbdqxxkzDao.updateSjbdqxxkz(sjbdqxxkz)>0;
	}

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 查询单条 */
	public Sjbdqxxkz getSjbdqxxkz(Sjbdqxxkz sjbdqxxkz){
		// TODO: implement
		return (Sjbdqxxkz)sjbdqxxkzDao.getSjbdqxxkz(sjbdqxxkz);
	}

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return sjbdqxxkzDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 手机被盗抢信息_快照(t_sjbdqxxkz) 多条查询 */
	public List getListSjbdqxxkz(Sjbdqxxkz sjbdqxxkz){
		// TODO: implement
		return sjbdqxxkzDao.getListSjbdqxxkz(sjbdqxxkz);
	}

	public ISjbdqxxkzDao getSjbdqxxkzDao() {
		return sjbdqxxkzDao;
	}

	public void setSjbdqxxkzDao(ISjbdqxxkzDao sjbdqxxkzDao) {
		this.sjbdqxxkzDao = sjbdqxxkzDao;
	}
}
