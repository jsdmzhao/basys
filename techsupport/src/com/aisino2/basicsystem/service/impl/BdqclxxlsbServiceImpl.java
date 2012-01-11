package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBdqclxxlsbDao;
import com.aisino2.basicsystem.domain.Bdqclxxlsb;
import com.aisino2.basicsystem.service.IBdqclxxlsbService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BdqclxxlsbServiceImpl extends BaseService implements IBdqclxxlsbService {

	private IBdqclxxlsbDao bdqclxxlsbDao;

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 增加 */
	public Bdqclxxlsb insertBdqclxxlsb(Bdqclxxlsb bdqclxxlsb){
		// TODO: implement
		return (Bdqclxxlsb)bdqclxxlsbDao.insertBdqclxxlsb(bdqclxxlsb);
	}

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 删除 */
	public boolean deleteBdqclxxlsb(Bdqclxxlsb bdqclxxlsb){
		// TODO: implement
		return bdqclxxlsbDao.deleteBdqclxxlsb(bdqclxxlsb)>0;
	}

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 修改 */
	public boolean updateBdqclxxlsb(Bdqclxxlsb bdqclxxlsb){
		// TODO: implement
		return bdqclxxlsbDao.updateBdqclxxlsb(bdqclxxlsb)>0;
	}

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 查询单条 */
	public Bdqclxxlsb getBdqclxxlsb(Bdqclxxlsb bdqclxxlsb){
		// TODO: implement
		return (Bdqclxxlsb)bdqclxxlsbDao.getBdqclxxlsb(bdqclxxlsb);
	}

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bdqclxxlsbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 多条查询 */
	public List getListBdqclxxlsb(Bdqclxxlsb bdqclxxlsb){
		// TODO: implement
		return bdqclxxlsbDao.getListBdqclxxlsb(bdqclxxlsb);
	}

	public IBdqclxxlsbDao getBdqclxxlsbDao() {
		return bdqclxxlsbDao;
	}

	public void setBdqclxxlsbDao(IBdqclxxlsbDao bdqclxxlsbDao) {
		this.bdqclxxlsbDao = bdqclxxlsbDao;
	}
}
