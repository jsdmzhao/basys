package com.aisino2.basicsystem.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IRcjcDao;
import com.aisino2.basicsystem.dao.IScbmDao;
import com.aisino2.basicsystem.domain.TyRcjc;
import com.aisino2.basicsystem.service.IRcjcService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class RcjcServiceImpl extends BaseService implements IRcjcService {

	private IRcjcDao tyrcjcDao;
	private IScbmDao scbmDao;

	/** @param 日常检查(t_rcjc) 增加 */
	public TyRcjc insertRcjc(TyRcjc rcjc){
		// TODO: implement
		//获得日常检查编号
		Map scbmMap = new HashMap();
		scbmMap.put("p_bmfl", "RCJC");
		scbmMap.put("p_xzqh", rcjc.getQybm());
		String sssf = "hn";//所属省份
		if(rcjc.getSssf()!=null)
			if(!"".equals(rcjc.getSssf()))
				sssf = rcjc.getSssf();
		scbmMap.put("p_sssf", sssf);
		scbmMap.put("p_scgz", 2);
		rcjc.setRcjcbh(scbmDao.getScbm(scbmMap));
		
		return (TyRcjc)tyrcjcDao.insertRcjc(rcjc);
	}

	/** @param 日常检查(t_rcjc) 删除 */
	public boolean deleteRcjc(TyRcjc rcjc){
		// TODO: implement
		return tyrcjcDao.deleteRcjc(rcjc)>0;
	}

	/** @param 日常检查(t_rcjc) 修改 */
	public boolean updateRcjc(TyRcjc rcjc){
		// TODO: implement
		return tyrcjcDao.updateRcjc(rcjc)>0;
	}

	/** @param 日常检查(t_rcjc) 查询单条 */
	public TyRcjc getRcjc(TyRcjc rcjc){
		// TODO: implement
		return (TyRcjc)tyrcjcDao.getRcjc(rcjc);
	}

	/** @param 日常检查(t_rcjc) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return tyrcjcDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 日常检查(t_rcjc) 多条查询 */
	public List getListRcjc(TyRcjc rcjc){
		// TODO: implement
		return tyrcjcDao.getListRcjc(rcjc);
	}

	public IRcjcDao getTyrcjcDao() {
		return tyrcjcDao;
	}

	public void setTyrcjcDao(IRcjcDao tyrcjcDao) {
		this.tyrcjcDao = tyrcjcDao;
	}

	public IScbmDao getScbmDao() {
		return scbmDao;
	}

	public void setScbmDao(IScbmDao scbmDao) {
		this.scbmDao = scbmDao;
	}
}
