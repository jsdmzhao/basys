package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyryxx_lsxxDao;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;
import com.aisino2.publicsystem.service.IQyryxx_lsxxService;

public class Qyryxx_lsxxServiceImpl extends BaseService implements IQyryxx_lsxxService {

	private IQyryxx_lsxxDao qyryxx_lsxxDao;

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 增加 */
	public Qyryxx_lsxx insertQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		// TODO: implement
		return (Qyryxx_lsxx)qyryxx_lsxxDao.insertQyryxx_lsxx(qyryxx_lsxx);
	}

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 删除 */
	public boolean deleteQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		// TODO: implement
		return qyryxx_lsxxDao.deleteQyryxx_lsxx(qyryxx_lsxx)>0;
	}

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 修改 */
	public boolean updateQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		// TODO: implement
		return qyryxx_lsxxDao.updateQyryxx_lsxx(qyryxx_lsxx)>0;
	}

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 查询单条 */
	public Qyryxx_lsxx getQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		// TODO: implement
		return (Qyryxx_lsxx)qyryxx_lsxxDao.getQyryxx_lsxx(qyryxx_lsxx);
	}

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyryxx_lsxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 多条查询 */
	public List getListQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		// TODO: implement
		return qyryxx_lsxxDao.getListQyryxx_lsxx(qyryxx_lsxx);
	}

	public IQyryxx_lsxxDao getQyryxx_lsxxDao() {
		return qyryxx_lsxxDao;
	}

	public void setQyryxx_lsxxDao(IQyryxx_lsxxDao qyryxx_lsxxDao) {
		this.qyryxx_lsxxDao = qyryxx_lsxxDao;
	}

	/** @param 从业人员历史信息(t_cyryxx_lsxx) 企业端国内人员历史查询 */
	public Page getCyryxx_lsxxListQydGnForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryxx_lsxxDao.getCyryxx_lsxxListQydGnForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 企业端境外人员历史查询 */
	public Page getCyryxx_lsxxListQydJwForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryxx_lsxxDao.getCyryxx_lsxxListQydJwForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 公安端国内人员历史查询 */
	public Page getCyryxx_lsxxListGadGnForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryxx_lsxxDao.getCyryxx_lsxxListGadGnForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 公安端境外人员历史查询 */
	public Page getCyryxx_lsxxListGadJwForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		return qyryxx_lsxxDao.getCyryxx_lsxxListGadJwForPage(map, pageNo, pageSize, sort, desc);
	}
	
	/**
	 * 判断是否为指定从业人员的操作类型为变更的最新一条历史记录
	 * @param qyryxx_lsxx(ryid,rylsid)
	 * @return 0-不是最新历史记录 1-是最新历史记录
	 */
	public String isLatestBgQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		String isLatestBgQyjbxx_lsFlag = "0";
		Qyryxx_lsxx qyryxx_lsLatest = new Qyryxx_lsxx();
		qyryxx_lsLatest = qyryxx_lsxxDao.getLatestBgQyryxx_lsxx(qyryxx_lsxx);
		if(qyryxx_lsLatest != null) 
			isLatestBgQyjbxx_lsFlag = "1";
		return isLatestBgQyjbxx_lsFlag;
	}
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 查询指定从业人员且操作类型为变更的某条历史记录的下一条记录(即rylsid较大的一条) */
	public Qyryxx_lsxx getNextBgQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx){
		return qyryxx_lsxxDao.getNextBgQyryxx_lsxx(qyryxx_lsxx);
	}
}
