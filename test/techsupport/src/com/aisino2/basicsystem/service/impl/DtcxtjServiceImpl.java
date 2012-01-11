package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IDtcxtjDao;
import com.aisino2.basicsystem.domain.Dtcxtj;
import com.aisino2.basicsystem.service.IDtcxtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class DtcxtjServiceImpl extends BaseService implements IDtcxtjService {

	private IDtcxtjDao dtcxtjDao;

	/** @param 动态查询条件(t_dtcxtj) 增加 */
	public Dtcxtj insertDtcxtj(Dtcxtj dtcxtj){
		// TODO: implement
		return (Dtcxtj)dtcxtjDao.insertDtcxtj(dtcxtj);
	}

	/** @param 动态查询条件(t_dtcxtj) 删除 */
	public boolean deleteDtcxtj(Dtcxtj dtcxtj){
		// TODO: implement
		return dtcxtjDao.deleteDtcxtj(dtcxtj)>0;
	}

	/** @param 动态查询条件(t_dtcxtj) 修改 */
	public boolean updateDtcxtj(Dtcxtj dtcxtj){
		// TODO: implement
		return dtcxtjDao.updateDtcxtj(dtcxtj)>0;
	}

	/** @param 动态查询条件(t_dtcxtj) 查询单条 */
	public Dtcxtj getDtcxtj(Dtcxtj dtcxtj){
		// TODO: implement
		return (Dtcxtj)dtcxtjDao.getDtcxtj(dtcxtj);
	}

	/** @param 动态查询条件(t_dtcxtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return dtcxtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 动态查询条件(t_dtcxtj) 多条查询 */
	public List getListDtcxtj(Dtcxtj dtcxtj){
		// TODO: implement
		return dtcxtjDao.getListDtcxtj(dtcxtj);
	}

	public IDtcxtjDao getDtcxtjDao() {
		return dtcxtjDao;
	}

	public void setDtcxtjDao(IDtcxtjDao dtcxtjDao) {
		this.dtcxtjDao = dtcxtjDao;
	}
}
