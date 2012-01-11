package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyzlxxDao;
import com.aisino2.publicsystem.dao.IQyzlxxfjDao;
import com.aisino2.publicsystem.domain.Qyzlxx;
import com.aisino2.publicsystem.domain.Qyzlxxfj;
import com.aisino2.publicsystem.service.IQyzlxxService;
public class QyzlxxServiceImpl extends BaseService implements IQyzlxxService {

	private IQyzlxxDao qyzlxxDao;
	private IQyzlxxfjDao qyzlxxfjDao;
	
	/** @param 企业质量信息(t_qyzlxx) 增加 */
	public Qyzlxx insertQyzlxx(Qyzlxx qyzlxx){
		// TODO: implement
		Qyzlxx qyzlxxBAK=qyzlxxDao.insertQyzlxx(qyzlxx);
		int qyzlxxid=qyzlxxBAK.getQyzlxxid();
		List list=qyzlxx.getFj_obj();
		if(list!=null){
			for(int a=0;a<list.size();a++){
				Qyzlxxfj qyzlxx_fjs=(Qyzlxxfj)list.get(a);
				qyzlxx_fjs.setQyzlxxid(qyzlxxid);
				qyzlxxfjDao.insertQyzlxxfj(qyzlxx_fjs);				
			}
			
		}
		return qyzlxxBAK;
		//return (Qyzlxx)qyzlxxDao.insertQyzlxx(qyzlxx);
	}

	/** @param 企业质量信息(t_qyzlxx) 删除 */
	public boolean deleteQyzlxx(Qyzlxx qyzlxx){
		// TODO: implement
		return qyzlxxDao.deleteQyzlxx(qyzlxx)>0;
	}

	/** @param 企业质量信息(t_qyzlxx) 修改 */
	public boolean updateQyzlxx(Qyzlxx qyzlxx){
		// TODO: implement
		return qyzlxxDao.updateQyzlxx(qyzlxx)>0;
	}

	/** @param 企业质量信息(t_qyzlxx) 查询单条 */
	public Qyzlxx getQyzlxx(Qyzlxx qyzlxx){
		// TODO: implement
		return (Qyzlxx)qyzlxxDao.getQyzlxx(qyzlxx);
	}

	/** @param 企业质量信息(t_qyzlxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qyzlxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业质量信息(t_qyzlxx) 多条查询 */
	public List getListQyzlxx(Qyzlxx qyzlxx){
		// TODO: implement
		return qyzlxxDao.getListQyzlxx(qyzlxx);
	}

	public IQyzlxxDao getQyzlxxDao() {
		return qyzlxxDao;
	}

	public void setQyzlxxDao(IQyzlxxDao qyzlxxDao) {
		this.qyzlxxDao = qyzlxxDao;
	}

	public IQyzlxxfjDao getQyzlxxfjDao() {
		return qyzlxxfjDao;
	}

	public void setQyzlxxfjDao(IQyzlxxfjDao qyzlxxfjDao) {
		this.qyzlxxfjDao = qyzlxxfjDao;
	}

	public Qyzlxxfj downloadFJ(Qyzlxxfj fjobj) {
		// TODO Auto-generated method stub
		
		return qyzlxxDao.downloadFJ(fjobj);
	}
	
}
