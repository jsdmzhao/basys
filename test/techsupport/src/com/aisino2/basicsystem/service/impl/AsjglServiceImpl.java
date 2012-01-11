package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IAsjglDao;
import com.aisino2.basicsystem.domain.Asjgl;
import com.aisino2.basicsystem.service.IAsjglService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class AsjglServiceImpl extends BaseService implements IAsjglService {

	private IAsjglDao asjglDao;

	/** @param 案事件管理(t_asjgl) 增加 */
	public Asjgl insertAsjgl(Asjgl asjgl){
		// TODO: implement
		return (Asjgl)asjglDao.insertAsjgl(asjgl);
	}

	/** @param 案事件管理(t_asjgl) 删除 */
	public boolean deleteAsjgl(Asjgl asjgl){
		// TODO: implement
		return asjglDao.deleteAsjgl(asjgl)>0;
	}

	/** @param 案事件管理(t_asjgl) 修改 */
	public boolean updateAsjgl(Asjgl asjgl){
		// TODO: implement
		return asjglDao.updateAsjgl(asjgl)>0;
	}

	/** @param 案事件管理(t_asjgl) 查询单条 */
	public Asjgl getAsjgl(Asjgl asjgl){
		// TODO: implement
		return (Asjgl)asjglDao.getAsjgl(asjgl);
	}

	/** @param 案事件管理(t_asjgl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return asjglDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 案事件管理(t_asjgl) 多条查询 */
	public List getListAsjgl(Asjgl asjgl){
		// TODO: implement
		return asjglDao.getListAsjgl(asjgl);
	}

	public IAsjglDao getAsjglDao() {
		return asjglDao;
	}

	public void setAsjglDao(IAsjglDao asjglDao) {
		this.asjglDao = asjglDao;
	}

	public List getListExportAsjgl(Map map, String sort, String desc) {
		// TODO Auto-generated method stub
		return asjglDao.getListExportAsjgl(map, sort, desc);
	}
}
