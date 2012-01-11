package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGzdxDao;
import com.aisino2.basicsystem.domain.Gzdx;
import com.aisino2.basicsystem.service.IGzdxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class GzdxServiceImpl extends BaseService implements IGzdxService {

	private IGzdxDao gzdxDao;

	/** @param 关注对象(t_gzdx) 增加 */
	public Gzdx insertGzdx(Gzdx gzdx){
		// TODO:将姓名的拼音加入
		String xm = gzdx.getXm();
		String xmpy = "";
		if(xm != null && !"".equals(xm)){
			xmpy = com.aisino2.core.util.PinYinUtil.getHanyuPingYin(xm);
		}
		gzdx.setXmpy(xmpy);
		return (Gzdx)gzdxDao.insertGzdx(gzdx);
	}

	/** @param 关注对象(t_gzdx) 删除 */
	public boolean deleteGzdx(Gzdx gzdx){
		// TODO: implement
		return gzdxDao.deleteGzdx(gzdx)>0;
	}

	/** @param 关注对象(t_gzdx) 修改 */
	public boolean updateGzdx(Gzdx gzdx){
//		 TODO:将姓名的拼音加入
		String xm = gzdx.getXm();
		String xmpy = "";
		if(xm != null && !"".equals(xm)){
			xmpy = com.aisino2.core.util.PinYinUtil.getHanyuPingYin(xm);
		}
		gzdx.setXmpy(xmpy);
		return gzdxDao.updateGzdx(gzdx)>0;
	}

	/** @param 关注对象(t_gzdx) 查询单条 */
	public Gzdx getGzdx(Gzdx gzdx){
		// TODO: implement
		return (Gzdx)gzdxDao.getGzdx(gzdx);
	}

	/** @param 关注对象(t_gzdx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return gzdxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 关注对象(t_gzdx) 多条查询 */
	public List getListGzdx(Gzdx gzdx){
		// TODO: implement
		return gzdxDao.getListGzdx(gzdx);
	}

	public IGzdxDao getGzdxDao() {
		return gzdxDao;
	}

	public void setGzdxDao(IGzdxDao gzdxDao) {
		this.gzdxDao = gzdxDao;
	}
/**验证*/
	public String validateZjhm(Gzdx gzdx) {
		// TODO Auto-generated method stub
		List list = gzdxDao.validateZjhm(gzdx);
		for (java.util.Iterator iter = list.iterator(); iter.hasNext();){
			Gzdx oneGzdx = (Gzdx)iter.next();
			if(oneGzdx.getNum() > 0){
				return oneGzdx.getFlag();
			}
		}
		return "OK";
	}

public List getListExportGzdx(Map map, String sort, String dir) {
	// TODO Auto-generated method stub
	return gzdxDao.getListExportGzdx(map, sort, dir);
}
}
