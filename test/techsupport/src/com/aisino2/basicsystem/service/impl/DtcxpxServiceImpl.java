package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IDtcxpxDao;
import com.aisino2.basicsystem.domain.Dtcxpx;
import com.aisino2.basicsystem.service.IDtcxpxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class DtcxpxServiceImpl extends BaseService implements IDtcxpxService {

	private IDtcxpxDao dtcxpxDao;

	/** @param 动态查询排序(t_dtcxpx) 增加 */
	public Dtcxpx insertDtcxpx(Dtcxpx dtcxpx){
		// TODO: implement
		return (Dtcxpx)dtcxpxDao.insertDtcxpx(dtcxpx);
	}

	/** @param 动态查询排序(t_dtcxpx) 删除 */
	public boolean deleteDtcxpx(Dtcxpx dtcxpx){
		// TODO: implement
		return dtcxpxDao.deleteDtcxpx(dtcxpx)>0;
	}

	/** @param 动态查询排序(t_dtcxpx) 修改 */
	public boolean updateDtcxpx(Dtcxpx dtcxpx){
		// TODO: implement
		return dtcxpxDao.updateDtcxpx(dtcxpx)>0;
	}

	/** @param 动态查询排序(t_dtcxpx) 查询单条 */
	public Dtcxpx getDtcxpx(Dtcxpx dtcxpx){
		// TODO: implement
		return (Dtcxpx)dtcxpxDao.getDtcxpx(dtcxpx);
	}

	/** @param 动态查询排序(t_dtcxpx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return dtcxpxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 动态查询排序(t_dtcxpx) 多条查询 */
	public List getListDtcxpx(Dtcxpx dtcxpx){
		// TODO: implement
		return dtcxpxDao.getListDtcxpx(dtcxpx);
	}

	public IDtcxpxDao getDtcxpxDao() {
		return dtcxpxDao;
	}

	public void setDtcxpxDao(IDtcxpxDao dtcxpxDao) {
		this.dtcxpxDao = dtcxpxDao;
	}
}
