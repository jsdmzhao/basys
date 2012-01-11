package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.ITjclxxDao;
import com.aisino2.publicsystem.domain.Tjclxx;
import com.aisino2.publicsystem.service.ITjclxxService;

public class TjclxxServiceImpl extends BaseService implements ITjclxxService {

	private ITjclxxDao tjclxxDao;

	/** @param 提交材料信息(t_tjclxx) 增加 */
	public Tjclxx insertTjclxx(Tjclxx tjclxx){
		// TODO: implement
		return (Tjclxx)tjclxxDao.insertTjclxx(tjclxx);
	}

	/** @param 提交材料信息(t_tjclxx) 删除 */
	public boolean deleteTjclxx(Tjclxx tjclxx){
		// TODO: implement
		return tjclxxDao.deleteTjclxx(tjclxx)>0;
	}

	/** @param 提交材料信息(t_tjclxx) 修改 */
	public boolean updateTjclxx(Tjclxx tjclxx){
		// TODO: implement
		return tjclxxDao.updateTjclxx(tjclxx)>0;
	}

	/** @param 提交材料信息(t_tjclxx) 查询单条 */
	public Tjclxx getTjclxx(Tjclxx tjclxx){
		// TODO: implement
		return (Tjclxx)tjclxxDao.getTjclxx(tjclxx);
	}

	/** @param 提交材料信息(t_tjclxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return tjclxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 提交材料信息(t_tjclxx) 多条查询 */
	public List getListTjclxx(Tjclxx tjclxx){
		// TODO: implement
		return tjclxxDao.getListTjclxx(tjclxx);
	}

	public ITjclxxDao getTjclxxDao() {
		return tjclxxDao;
	}

	public void setTjclxxDao(ITjclxxDao tjclxxDao) {
		this.tjclxxDao = tjclxxDao;
	}
}
