package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IRyjcxxDao;
import com.aisino2.publicsystem.domain.Ryjcxx;
import com.aisino2.publicsystem.service.IRyjcxxService;

public class RyjcxxServiceImpl extends BaseService implements IRyjcxxService {

	private IRyjcxxDao ryjcxxDao;

	/** @param 人员奖惩信息(t_ryjcxx) 增加 */
	public Ryjcxx insertRyjcxx(Ryjcxx ryjcxx){
		// TODO: implement
		ryjcxx.setScbz(0);
		return (Ryjcxx)ryjcxxDao.insertRyjcxx(ryjcxx);
	}

	/** @param 人员奖惩信息(t_ryjcxx) 删除 将至删除标志*/
	public boolean deleteRyjcxx(Ryjcxx ryjcxx){
		// TODO: implement
		//return ryjcxxDao.deleteRyjcxx(ryjcxx)>0;
		Ryjcxx ryjcxxdele = new Ryjcxx();
		ryjcxxdele.setScbz(1);
		ryjcxxdele.setRycfid(ryjcxx.getRycfid());
		return ryjcxxDao.updateRyjcxx(ryjcxxdele)>0;
	}

	/** @param 人员奖惩信息(t_ryjcxx) 修改 */
	public boolean updateRyjcxx(Ryjcxx ryjcxx){
		// TODO: implement
		return ryjcxxDao.updateRyjcxx(ryjcxx)>0;
	}

	/** @param 人员奖惩信息(t_ryjcxx) 查询单条 */
	public Ryjcxx getRyjcxx(Ryjcxx ryjcxx){
		// TODO: implement
		return (Ryjcxx)ryjcxxDao.getRyjcxx(ryjcxx);
	}

	/** @param 人员奖惩信息(t_ryjcxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return ryjcxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 人员奖惩信息(t_ryjcxx) 多条查询 */
	public List getListRyjcxx(Ryjcxx ryjcxx){
		// TODO: implement
		return ryjcxxDao.getListRyjcxx(ryjcxx);
	}

	public IRyjcxxDao getRyjcxxDao() {
		return ryjcxxDao;
	}

	public void setRyjcxxDao(IRyjcxxDao ryjcxxDao) {
		this.ryjcxxDao = ryjcxxDao;
	}

	public Page getRyListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return ryjcxxDao.getRyListForPage(map,pageNo,pageSize,sort,desc);
	}
}
