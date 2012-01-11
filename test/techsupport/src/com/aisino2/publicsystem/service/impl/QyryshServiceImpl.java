package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyryshDao;
import com.aisino2.publicsystem.domain.Qyrysh;
import com.aisino2.publicsystem.service.IQyryshService;

public class QyryshServiceImpl extends BaseService implements IQyryshService {

	private IQyryshDao qyryshDao;

	/** @param 企业人员审核(t_qyrysh) 增加 */
	public Qyrysh insertQyrysh(Qyrysh qyrysh){
		// TODO: implement
		return (Qyrysh)qyryshDao.insertQyrysh(qyrysh);
	}

	/** @param 企业人员审核(t_qyrysh) 删除 */
	public boolean deleteQyrysh(Qyrysh qyrysh){
		// TODO: implement
		return qyryshDao.deleteQyrysh(qyrysh)>0;
	}

	/** @param 企业人员审核(t_qyrysh) 修改 */
	public boolean updateQyrysh(Qyrysh qyrysh){
		// TODO: implement
		return qyryshDao.updateQyrysh(qyrysh)>0;
	}

	/** @param 企业人员审核(t_qyrysh) 查询单条 */
	public Qyrysh getQyrysh(Qyrysh qyrysh){
		// TODO: implement
		return (Qyrysh)qyryshDao.getQyrysh(qyrysh);
	}

	/** @param 企业人员审核(t_qyrysh) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyryshDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业人员审核(t_qyrysh) 多条查询 */
	public List getListQyrysh(Qyrysh qyrysh){
		// TODO: implement
		return qyryshDao.getListQyrysh(qyrysh);
	}

	public IQyryshDao getQyryshDao() {
		return qyryshDao;
	}

	public void setQyryshDao(IQyryshDao qyryshDao) {
		this.qyryshDao = qyryshDao;
	}

	public int getSjshid(Qyrysh qyrysh) {
		// TODO Auto-generated method stub
		int sjshid = 0;
		qyrysh = qyryshDao.getSjshid(qyrysh);
		if(qyrysh!=null)
		{
			sjshid = qyrysh.getSjshid();
		}
		return sjshid;
	}
}
