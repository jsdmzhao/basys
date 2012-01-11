package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyryjctjDao;
import com.aisino2.publicsystem.domain.Qyryjctj;
import com.aisino2.publicsystem.service.IQyryjctjService;

public class QyryjctjServiceImpl extends BaseService implements IQyryjctjService {

	private IQyryjctjDao qyryjctjDao;

	/** @param 企业人员奖惩统计表(t_qyryjctj) 增加 */
	public Qyryjctj insertQyryjctj(Qyryjctj qyryjctj){
		// TODO: implement
		return (Qyryjctj)qyryjctjDao.insertQyryjctj(qyryjctj);
	}

	/** @param 企业人员奖惩统计表(t_qyryjctj) 删除 */
	public boolean deleteQyryjctj(Qyryjctj qyryjctj){
		// TODO: implement
		return qyryjctjDao.deleteQyryjctj(qyryjctj)>0;
	}

	/** @param 企业人员奖惩统计表(t_qyryjctj) 修改 */
	public boolean updateQyryjctj(Qyryjctj qyryjctj){
		// TODO: implement
		return qyryjctjDao.updateQyryjctj(qyryjctj)>0;
	}

	/** @param 企业人员奖惩统计表(t_qyryjctj) 查询单条 */
	public Qyryjctj getQyryjctj(Qyryjctj qyryjctj){
		// TODO: implement
		return (Qyryjctj)qyryjctjDao.getQyryjctj(qyryjctj);
	}

	/** @param 企业人员奖惩统计表(t_qyryjctj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		getConditions(map);
		return qyryjctjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业人员奖惩统计表(t_qyryjctj) 多条查询 */
	public List getListQyryjctj(Qyryjctj qyryjctj){
		// TODO: implement
		return qyryjctjDao.getListQyryjctj(qyryjctj);
	}

	public IQyryjctjDao getQyryjctjDao() {
		return qyryjctjDao;
	}

	public void setQyryjctjDao(IQyryjctjDao qyryjctjDao) {
		this.qyryjctjDao = qyryjctjDao;
	}
	private void getConditions(Map map) {
		boolean dsjgbz = ((String)map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String)map.get("fxjbz")).equalsIgnoreCase("1"); 
		boolean gxdwbz = ((String)map.get("gxdwbz")).equalsIgnoreCase("1");
		String pageSort = "";
		String groupBy = "";
		String selectConditon = "";
		if(gxdwbz){
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc,gxdwdm,gxdwmc";
			selectConditon = groupBy;
			pageSort = " a.gxdwmc ";
		}else if(fxjbz){
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc";
			selectConditon = groupBy + ",'' as gxdwdm,'' as gxdwmc";
			pageSort = " a.fxjmc ";
		}else if(dsjgbz){
			groupBy = "dsjgdm,dsjgmc";
			selectConditon = groupBy + ",'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
			pageSort = " a.dsjgdm ";
		}else{
			groupBy = "";
			selectConditon = "'' as dsjgdm,'' as dsjgmc,'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
		map.put("pageSort", pageSort);
	}
}
