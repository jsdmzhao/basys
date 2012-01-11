package com.aisino2.basicsystem.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkryDao;
import com.aisino2.basicsystem.dao.IScbmDao;
import com.aisino2.basicsystem.domain.Bkry;
import com.aisino2.basicsystem.service.IBkryService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BkryServiceImpl extends BaseService implements IBkryService {

	private IBkryDao bkryDao;
	private IScbmDao scbmDao;

	/** @param 布控人员(t_bkry) 增加 */
	public Bkry insertBkry(Bkry bkry){
//		 TODO:将姓名的拼音加入
		String xm = bkry.getXm();
		String xmpy = "";
		if(xm != null && !"".equals(xm)){
			xmpy = com.aisino2.core.util.PinYinUtil.getHanyuPingYin(xm);
		}
		
		bkry.setXmpy(xmpy);
		Map scbmMap = new HashMap();
		scbmMap.put("p_bmfl", "BKRY");
		scbmMap.put("p_xzqh",bkry.getTbbh());
		scbmMap.put("p_sssf", "hn");
		scbmMap.put("p_scgz", 0);
		bkry.setTbbh(scbmDao.getScbm(scbmMap));

		return (Bkry)bkryDao.insertBkry(bkry);
	}

	/** @param 布控人员(t_bkry) 删除 */
	public boolean deleteBkry(Bkry bkry){
		// TODO: implement
		return bkryDao.deleteBkry(bkry)>0;
	}

	/** @param 布控人员(t_bkry) 修改 */
	public boolean updateBkry(Bkry bkry){
		String xm = bkry.getXm();
		String xmpy = "";
		if(xm != null && !"".equals(xm)){
			xmpy = com.aisino2.core.util.PinYinUtil.getHanyuPingYin(xm);
		}
		bkry.setXmpy(xmpy);
		
		return bkryDao.updateBkry(bkry)>0;
	}

	/** @param 布控人员(t_bkry) 查询单条 */
	public Bkry getBkry(Bkry bkry){
		// TODO: implement
		return (Bkry)bkryDao.getBkry(bkry);
	}

	/** @param 布控人员(t_bkry) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		
		return bkryDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 布控人员(t_bkry) 多条查询 */
	public List getListBkry(Bkry bkry){
		// TODO: implement
		return bkryDao.getListBkry(bkry);
	}

	public IBkryDao getBkryDao() {
		return bkryDao;
	}

	public void setBkryDao(IBkryDao bkryDao) {
		this.bkryDao = bkryDao;
	}
	
	/**验证*/
	public boolean validateZjhm(Bkry bkry) {
		// TODO Auto-generated method stub
		return bkryDao.validateZjhm(bkry)>0;
	}

	public IScbmDao getScbmDao() {
		return scbmDao;
	}

	public void setScbmDao(IScbmDao scbmDao) {
		this.scbmDao = scbmDao;
	}

	public Page getJwListForPage(Map map, int pageNo, int pageSize, String sort, String desc) {
		return bkryDao.getJwListForPage(map,pageNo,pageSize,sort,desc);
	}

}
