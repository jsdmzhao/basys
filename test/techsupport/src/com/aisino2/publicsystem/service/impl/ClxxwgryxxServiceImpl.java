package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IClxxwgryxxDao;
import com.aisino2.publicsystem.domain.Clxxwgryxx;
import com.aisino2.publicsystem.service.IClxxwgryxxService;

public class ClxxwgryxxServiceImpl extends BaseService implements IClxxwgryxxService {

	private IClxxwgryxxDao clxxwgryxxDao;

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 增加 */
	public Clxxwgryxx insertClxxwgryxx(Clxxwgryxx clxxwgryxx){
		// TODO: implement
		return (Clxxwgryxx)clxxwgryxxDao.insertClxxwgryxx(clxxwgryxx);
	}

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 删除 */
	public boolean deleteClxxwgryxx(Clxxwgryxx clxxwgryxx){
		// TODO: implement
		return clxxwgryxxDao.deleteClxxwgryxx(clxxwgryxx)>0;
	}

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 修改 */
	public boolean updateClxxwgryxx(Clxxwgryxx clxxwgryxx){
		// TODO: implement
		return clxxwgryxxDao.updateClxxwgryxx(clxxwgryxx)>0;
	}

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 查询单条 */
	public Clxxwgryxx getClxxwgryxx(Clxxwgryxx clxxwgryxx){
		// TODO: implement
		return (Clxxwgryxx)clxxwgryxxDao.getClxxwgryxx(clxxwgryxx);
	}

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return clxxwgryxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 多条查询 */
	public List getListClxxwgryxx(Clxxwgryxx clxxwgryxx){
		// TODO: implement
		return clxxwgryxxDao.getListClxxwgryxx(clxxwgryxx);
	}

	public IClxxwgryxxDao getClxxwgryxxDao() {
		return clxxwgryxxDao;
	}

	public void setClxxwgryxxDao(IClxxwgryxxDao clxxwgryxxDao) {
		this.clxxwgryxxDao = clxxwgryxxDao;
	}
}
