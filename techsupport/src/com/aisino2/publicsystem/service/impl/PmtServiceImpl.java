package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IPmtDao;
import com.aisino2.publicsystem.domain.Pmt;
import com.aisino2.publicsystem.service.IPmtService;

public class PmtServiceImpl extends BaseService implements IPmtService {

	private IPmtDao pmtDao;

	/** @param 平面图(t_pmt) 增加 */
	public Pmt insertPmt(Pmt pmt){
		// TODO: implement
		return (Pmt)pmtDao.insertPmt(pmt);
	}

	/** @param 平面图(t_pmt) 删除 */
	public boolean deletePmt(Pmt pmt){
		// TODO: implement
		return pmtDao.deletePmt(pmt)>0;
	}

	/** @param 平面图(t_pmt) 修改 */
	public boolean updatePmt(Pmt pmt){
		// TODO: implement
		return pmtDao.updatePmt(pmt)>0;
	}

	/** @param 平面图(t_pmt) 查询单条 */
	public Pmt getPmt(Pmt pmt){
		// TODO: implement
		return (Pmt)pmtDao.getPmt(pmt);
	}

	/** @param 平面图(t_pmt) 查询单条 不查询BLOB*/
	public Pmt getPmtNoBlob(Pmt pmt){
		// TODO: implement
		return (Pmt)pmtDao.getPmtNoBlob(pmt);
	}
	
	/** @param 平面图(t_pmt) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return pmtDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 平面图(t_pmt) 多条查询 */
	public List getListPmt(Pmt pmt){
		// TODO: implement
		return pmtDao.getListPmt(pmt);
	}

	public IPmtDao getPmtDao() {
		return pmtDao;
	}

	public void setPmtDao(IPmtDao pmtDao) {
		this.pmtDao = pmtDao;
	}
}
