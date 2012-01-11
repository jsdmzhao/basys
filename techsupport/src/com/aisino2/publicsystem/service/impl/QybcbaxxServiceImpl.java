package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQybaxxDao;
import com.aisino2.publicsystem.dao.IQybcbaxxDao;
import com.aisino2.publicsystem.dao.ITjclxxDao;
import com.aisino2.publicsystem.domain.Qybaxx;
import com.aisino2.publicsystem.domain.Qybcbaxx;
import com.aisino2.publicsystem.domain.Tjclxx;
import com.aisino2.publicsystem.service.IQybcbaxxService;

public class QybcbaxxServiceImpl extends BaseService implements IQybcbaxxService {

	private IQybcbaxxDao qybcbaxxDao;
	private IQybaxxDao qybaxxDao;
	private ITjclxxDao tjclxxDao;
	/** @param 企业补充备案信息(t_qybcbaxx) 增加 */
	public Qybcbaxx insertQybcbaxx(Qybcbaxx qybcbaxx){
		// TODO: implement
		return (Qybcbaxx)qybcbaxxDao.insertQybcbaxx(qybcbaxx);
	}

	/** @param 企业补充备案信息(t_qybcbaxx) 删除 */
	public boolean deleteQybcbaxx(Qybcbaxx qybcbaxx){
		// TODO: implement
		return qybcbaxxDao.deleteQybcbaxx(qybcbaxx)>0;
	}

	/** @param 企业补充备案信息(t_qybcbaxx) 修改 */
	public boolean updateQybcbaxx(Qybcbaxx qybcbaxx){

		// TODO: implement
		//return csbcbaxxDao.updateCsbcbaxx(csbcbaxx)>0;
		boolean isSuccess = false;
		Qybcbaxx qybcbaxxOld = new Qybcbaxx();
		Qybaxx qybaxx = new Qybaxx();
		Tjclxx tjclxx = new Tjclxx();
		qybcbaxxOld.setQybaxxid(qybcbaxx.getQybaxxid());
		//若补充备案信息不存在，则新增一条补充备案信息,否则修改该补充备案信息
		qybcbaxxOld = qybcbaxxDao.getQybcbaxx(qybcbaxxOld);
		if(qybcbaxxOld == null)
		{
			qybcbaxxDao.insertQybcbaxx(qybcbaxx);
		}
		else
			qybcbaxxDao.updateQybcbaxx(qybcbaxx);
		//修改场所备案信息
		if(qybcbaxx.getQybaxx()!= null)
		{
			qybaxx = qybcbaxx.getQybaxx();
			qybaxxDao.updateQybaxx(qybaxx);
		}
		//删除原有提交材料信息
		tjclxx.setQybaxxid(qybcbaxx.getQybaxxid());
		tjclxxDao.deleteTjclxx(tjclxx);
		//新增提交材料信息
		if(qybcbaxx.getLTjclxx()!=null)
		{
			for(int i = 0;i<qybcbaxx.getLTjclxx().size();i++)
			{
				tjclxx = null;
				tjclxx = new Tjclxx();
				tjclxx = (Tjclxx)qybcbaxx.getLTjclxx().get(i);
				tjclxx.setQybaxxid(qybcbaxx.getQybaxxid());
				tjclxx.setQyid(qybcbaxx.getQyid());
				tjclxxDao.insertTjclxx(tjclxx);
			}
		}
		isSuccess = true;
		return isSuccess;
	}

	/** @param 企业补充备案信息(t_qybcbaxx) 查询单条 */
	public Qybcbaxx getQybcbaxx(Qybcbaxx qybcbaxx){
		// TODO: implement
		return (Qybcbaxx)qybcbaxxDao.getQybcbaxx(qybcbaxx);
	}

	/** @param 企业补充备案信息(t_qybcbaxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qybcbaxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业补充备案信息(t_qybcbaxx) 多条查询 */
	public List getListQybcbaxx(Qybcbaxx qybcbaxx){
		// TODO: implement
		return qybcbaxxDao.getListQybcbaxx(qybcbaxx);
	}

	public IQybcbaxxDao getQybcbaxxDao() {
		return qybcbaxxDao;
	}

	public void setQybcbaxxDao(IQybcbaxxDao qybcbaxxDao) {
		this.qybcbaxxDao = qybcbaxxDao;
	}

	public IQybaxxDao getQybaxxDao() {
		return qybaxxDao;
	}

	public void setQybaxxDao(IQybaxxDao qybaxxDao) {
		this.qybaxxDao = qybaxxDao;
	}

	public ITjclxxDao getTjclxxDao() {
		return tjclxxDao;
	}

	public void setTjclxxDao(ITjclxxDao tjclxxDao) {
		this.tjclxxDao = tjclxxDao;
	}
}
