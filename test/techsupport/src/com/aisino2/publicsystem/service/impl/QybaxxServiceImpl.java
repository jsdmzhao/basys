package com.aisino2.publicsystem.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IScbmDao;
import com.aisino2.common.StringUtil;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQybaxxDao;
import com.aisino2.publicsystem.dao.IQyjbxxDao;
import com.aisino2.publicsystem.dao.ITjclxxDao;
import com.aisino2.publicsystem.domain.Qybaxx;
import com.aisino2.publicsystem.domain.Qybcbaxx;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Tjclxx;
import com.aisino2.publicsystem.service.IQybaxxService;

public class QybaxxServiceImpl extends BaseService implements IQybaxxService {
	private ITjclxxDao tjclxxDao;
	private IQybaxxDao qybaxxDao;
	private IQyjbxxDao qyjbxxDao;
	private IScbmDao scbmDao;
	/** @param 企业备案信息(t_qybaxx) 增加 */
	public Qybaxx insertQybaxx(Qybaxx qybaxx){
		// TODO: implement
		//return (qybaxx)qybaxxDao.insertqybaxx(qybaxx);
		Qybcbaxx qybcbaxx = new Qybcbaxx();
		Tjclxx tjclxx = null;
		Qybaxx qybaxxNew = new Qybaxx();
		
		//增加场所备案信息
		//获得场所备案编码
		Map scbmMap = new HashMap();
		scbmMap.put("p_bmfl", "J");
		scbmMap.put("p_xzqh", StringUtil.add0(qybaxx.getBabmbm(), 6).substring(0, 6));
		String sssf = "hn";//所属省份
		if(qybaxx.getSssf()!=null)
			if(!"".equals(qybaxx.getSssf()))
				sssf = qybaxx.getSssf();
		scbmMap.put("p_sssf", sssf);
		scbmMap.put("p_scgz", 3);
		qybaxx.setQybabm(scbmDao.getScbm(scbmMap));
		qybaxxDao.insertQybaxx(qybaxx);
		qybaxxNew =qybaxx;
		//增加提交材料信息信息
		if(qybaxx.getLTjclxx()!= null)
		{
			for(int i = 0;i<qybaxx.getLTjclxx().size();i++)
			{
				tjclxx = new Tjclxx();
				tjclxx = (Tjclxx)qybaxx.getLTjclxx().get(i);
				tjclxx.setQyid(qybaxxNew.getQyid());
				tjclxx.setQybaxxid(qybaxxNew.getQybaxxid());
				tjclxxDao.insertTjclxx(tjclxx);
				tjclxx = null;
			}
		}
		try {
			Qyjbxx qyjbxx = new Qyjbxx();
			qyjbxx.setQyid(qybaxx.getQyid());
			qyjbxx.setBarq(qybaxx.getBarq());
			qyjbxxDao.updateQyjbxx(qyjbxx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return qybaxxNew;
	}

	/** @param 企业备案信息(t_qybaxx) 删除 */
	public boolean deleteQybaxx(Qybaxx qybaxx){
		// TODO: implement
		return qybaxxDao.deleteQybaxx(qybaxx)>0;
	}

	/** @param 企业备案信息(t_qybaxx) 修改 */
	public boolean updateQybaxx(Qybaxx qybaxx){
		// TODO: implement
		Tjclxx tjclxx = new Tjclxx();
		tjclxx.setQybaxxid(qybaxx.getQybaxxid());
		tjclxxDao.deleteTjclxx(tjclxx);
		//增加提交材料信息信息
		if(qybaxx.getLTjclxx()!= null)
		{
			for(int i = 0;i<qybaxx.getLTjclxx().size();i++)
			{
				tjclxx = new Tjclxx();
				tjclxx = (Tjclxx)qybaxx.getLTjclxx().get(i);
				tjclxx.setQyid(qybaxx.getQyid());
				tjclxx.setQybaxxid(qybaxx.getQybaxxid());
				tjclxxDao.insertTjclxx(tjclxx);
				tjclxx = null;
			}
		}
		try {
			Qyjbxx qyjbxx = new Qyjbxx();
			Integer qyid = qybaxx.getQyid();
			if(qyid!=null){
				qyjbxx.setQyid(qyid);
				qyjbxx.setBarq(qybaxx.getBarq());
				qyjbxxDao.updateQyjbxx(qyjbxx);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return qybaxxDao.updateQybaxx(qybaxx)>0;
	}

	/** @param 企业备案信息(t_qybaxx) 查询单条 */
	public Qybaxx getQybaxx(Qybaxx qybaxx){
		// TODO: implement
		return (Qybaxx)qybaxxDao.getQybaxx(qybaxx);
	}

	/** @param 企业备案信息(t_qybaxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qybaxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	/** @param 企业基本信息(t_ylcsjbxx) 分页查询  企业备案查询*/
	public Page getListForPageCsba(Map map, int pageNo,int pageSize,String sort,String desc){
		return qybaxxDao.getListForPageCsba(map, pageNo, pageSize, sort, desc);
	}
	/** @param 企业备案信息(t_qybaxx) 多条查询 */
	public List getListQybaxx(Qybaxx qybaxx){
		// TODO: implement
		return qybaxxDao.getListQybaxx(qybaxx);
	}


	public IQyjbxxDao getQyjbxxDao() {
		return qyjbxxDao;
	}

	public void setQyjbxxDao(IQyjbxxDao qyjbxxDao) {
		this.qyjbxxDao = qyjbxxDao;
	}

	public IQybaxxDao getQybaxxDao() {
		return qybaxxDao;
	}

	public void setQybaxxDao(IQybaxxDao qybaxxDao) {
		this.qybaxxDao = qybaxxDao;
	}
	public IScbmDao getScbmDao() {
		return scbmDao;
	}

	public void setScbmDao(IScbmDao scbmDao) {
		this.scbmDao = scbmDao;
	}
	public ITjclxxDao getTjclxxDao() {
		return tjclxxDao;
	}

	public void setTjclxxDao(ITjclxxDao tjclxxDao) {
		this.tjclxxDao = tjclxxDao;
	}
}
