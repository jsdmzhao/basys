package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IQycftjDao;
import com.aisino2.basicsystem.domain.Qycftj;
import com.aisino2.basicsystem.service.IQycftjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;



public class QycftjServiceImpl extends BaseService implements IQycftjService {

	private IQycftjDao qycftjDao;

	/** @param 企业处罚统计表(t_qycftj) 增加 */
	public Qycftj insertQycftj(Qycftj qycftj){
		// TODO: implement
		return (Qycftj)qycftjDao.insertQycftj(qycftj);
	}

	/** @param 企业处罚统计表(t_qycftj) 删除 */
	public boolean deleteQycftj(Qycftj qycftj){
		// TODO: implement
		return qycftjDao.deleteQycftj(qycftj)>0;
	}

	/** @param 企业处罚统计表(t_qycftj) 修改 */
	public boolean updateQycftj(Qycftj qycftj){
		// TODO: implement
		return qycftjDao.updateQycftj(qycftj)>0;
	}

	/** @param 企业处罚统计表(t_qycftj) 查询单条 */
	public Qycftj getQycftj(Qycftj qycftj){
		// TODO: implement
		return (Qycftj)qycftjDao.getQycftj(qycftj);
	}

	/** @param 企业处罚统计表(t_qycftj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		map =CtreatPageMapTongJiBasic.getConditionsTongjiChaXun(map);
		return qycftjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业处罚统计表(t_qycftj) 多条查询 */
	public List getListQycftj(Qycftj qycftj){
		// TODO: implement
		return qycftjDao.getListQycftj(qycftj);
	}

	public IQycftjDao getQycftjDao() {
		return qycftjDao;
	}

	public void setQycftjDao(IQycftjDao qycftjDao) {
		this.qycftjDao = qycftjDao;
	}
	
	public Page getListForPageAlldw(Map map, int pageNo,int pageSize,String sort,String desc){
		
		return qycftjDao.getListForPageAlldw(map, pageNo, pageSize, sort, desc);
	}
	
	public Qycftj getQycftjTotalNum(Map map){
		return qycftjDao.getQycftjTotalNum(map);
	}
	/** @param 企业处罚统计表(t_qycftj) 分页查询--标准化 */
	public Page getListForPageBzh(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		boolean dsjgbz = ((String) map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String) map.get("fxjbz")).equalsIgnoreCase("1");
		boolean gxdwbz = ((String) map.get("gxdwbz")).equalsIgnoreCase("1");
		boolean csbz = ((String) map.get("csbz")).equalsIgnoreCase("1");
		String groupBy = "";
		String selectConditon = "";
		if (csbz) {
			groupBy = "dsjgdm,dsjgmc" + ",fxjdm,fxjmc" + ",gxdwdm,gxdwmc"
					+ ",csbm,csmc" +",hylbdm,hylb";
			selectConditon = groupBy;
		} else if (gxdwbz) {
			groupBy = "dsjgdm,dsjgmc" + ",fxjdm,fxjmc" + ",gxdwdm,gxdwmc";
			selectConditon = groupBy + ",'' as csbm,'' as csmc,'' as hylbdm,'' as hylb";
		} else if (fxjbz) {
			groupBy = "dsjgdm,dsjgmc" + ",fxjdm,fxjmc";
			selectConditon = groupBy + ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as csbm,'' as csmc,'' as hylbdm,'' as hylb";
		} else if (dsjgbz) {
			groupBy = "dsjgdm,dsjgmc";
			selectConditon = groupBy + ",'' as fxjdm,'' as fxjmc"
					+ ",'' as gxdwdm,'' as gxdwmc" + ",'' as csbm,'' as csmc,'' as hylbdm,'' as hylb";
		} else {
			groupBy = "";
			selectConditon = "'' as dsjgdm,'' as dsjgmc"
					+ ",'' as fxjdm,'' as fxjmc" + ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as csbm,'' as csmc,'' as hylbdm,'' as hylb";
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
		return qycftjDao.getListForPageBzh(map,pageNo,pageSize,sort,desc);
	}
}
