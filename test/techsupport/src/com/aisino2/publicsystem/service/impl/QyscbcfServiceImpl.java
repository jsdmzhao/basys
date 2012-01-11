package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyscbcfDao;
import com.aisino2.publicsystem.domain.Qyscbcf;
import com.aisino2.publicsystem.service.IQyscbcfService;

public class QyscbcfServiceImpl extends BaseService implements IQyscbcfService {

	private IQyscbcfDao qyscbcfDao;

	/** @param 企业上传不充分(t_qyscbcf) 增加 */
	public Qyscbcf insertQyscbcf(Qyscbcf qyscbcf){
		// TODO: implement
		return (Qyscbcf)qyscbcfDao.insertQyscbcf(qyscbcf);
	}

	/** @param 企业上传不充分(t_qyscbcf) 删除 */
	public boolean deleteQyscbcf(Qyscbcf qyscbcf){
		// TODO: implement
		return qyscbcfDao.deleteQyscbcf(qyscbcf)>0;
	}

	/** @param 企业上传不充分(t_qyscbcf) 修改 */
	public boolean updateQyscbcf(Qyscbcf qyscbcf){
		// TODO: implement
		return qyscbcfDao.updateQyscbcf(qyscbcf)>0;
	}

	/** @param 企业上传不充分(t_qyscbcf) 查询单条 */
	public Qyscbcf getQyscbcf(Qyscbcf qyscbcf){
		// TODO: implement
		return (Qyscbcf)qyscbcfDao.getQyscbcf(qyscbcf);
	}

	/** @param 企业上传不充分(t_qyscbcf) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		getConditions(map);
		
		return qyscbcfDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	private void getConditions(Map map) {
		String groupBy = "";
		String selectConditon = "";
			groupBy = "a.dsjgdm,a.dsjgmc" + ",a.fxjdm,a.fxjmc" + ",a.gxdwdm,a.gxdwmc"
					+ ",a.qybm,a.qymc" +",a.hylbdm,a.hylb";
			selectConditon = groupBy;
		
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
	}
	
	
	

	/** @param 企业上传不充分(t_qyscbcf) 多条查询 */
	public List getListQyscbcf(Qyscbcf qyscbcf){
		// TODO: implement
		return qyscbcfDao.getListQyscbcf(qyscbcf);
	}

	public IQyscbcfDao getQyscbcfDao() {
		return qyscbcfDao;
	}

	public void setQyscbcfDao(IQyscbcfDao qyscbcfDao) {
		this.qyscbcfDao = qyscbcfDao;
	}

	public Page getXxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return qyscbcfDao.getXxListForPage(map,pageNo,pageSize,sort,desc);
	}
}
