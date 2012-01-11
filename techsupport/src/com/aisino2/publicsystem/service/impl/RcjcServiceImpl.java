package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IRcjcDao;
import com.aisino2.publicsystem.domain.Rcjc;
import com.aisino2.publicsystem.service.IRcjcService;

public class RcjcServiceImpl extends BaseService implements IRcjcService {

	private IRcjcDao rcjcDao;

	/** @param 日常检查(t_rcjc) 增加 */
	public Rcjc insertRcjc(Rcjc rcjc){
		// TODO: implement
		return (Rcjc)rcjcDao.insertRcjc(rcjc);
	}

	/** @param 日常检查(t_rcjc) 删除 */
	public boolean deleteRcjc(Rcjc rcjc){
		// TODO: implement
		return rcjcDao.deleteRcjc(rcjc)>0;
	}

	/** @param 日常检查(t_rcjc) 修改 */
	public boolean updateRcjc(Rcjc rcjc){
		// TODO: implement
		return rcjcDao.updateRcjc(rcjc)>0;
	}

	/** @param 日常检查(t_rcjc) 查询单条 */
	public Rcjc getRcjc(Rcjc rcjc){
		// TODO: implement
		return (Rcjc)rcjcDao.getRcjc(rcjc);
	}

	/** @param 日常检查(t_rcjc) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return rcjcDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 日常检查(t_rcjc) 多条查询 */
	public List getListRcjc(Rcjc rcjc){
		// TODO: implement
		return rcjcDao.getListRcjc(rcjc);
	}

	public IRcjcDao getRcjcDao() {
		return rcjcDao;
	}

	public void setRcjcDao(IRcjcDao rcjcDao) {
		this.rcjcDao = rcjcDao;
	}

	public Page getTjListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		getConditions(map);
		return rcjcDao.getTjListForPage(map, pageNo, pageSize, sort, desc);
	}
	private void getConditions(Map map) {
		boolean dsjgbz = ((String) map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String) map.get("fxjbz")).equalsIgnoreCase("1");
		boolean gxdwbz = ((String) map.get("gxdwbz")).equalsIgnoreCase("1");
		boolean csbz = ((String) map.get("csbz")).equalsIgnoreCase("1");
		String groupBy = "";
		String selectConditon = "";
		if (csbz) {
			groupBy = "a.dsjgdm,a.dsjgmc" + ",a.fxjdm,a.fxjmc" + ",a.gxdwdm,a.gxdwmc"
					+ ",qybm,qymc" +",hylbdm,hylb";
			selectConditon = groupBy;
		} else if (gxdwbz) {
			groupBy = "a.dsjgdm,a.dsjgmc" + ",a.fxjdm,a.fxjmc" + ",a.gxdwdm,a.gxdwmc";
			selectConditon = groupBy + ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb";
		} else if (fxjbz) {
			groupBy = "a.dsjgdm,a.dsjgmc" + ",a.fxjdm,a.fxjmc";
			selectConditon = groupBy + ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb";
		} else if (dsjgbz) {
			groupBy = "a.dsjgdm,a.dsjgmc";
			selectConditon = groupBy + ",'' as fxjdm,'' as fxjmc"
					+ ",'' as gxdwdm,'' as gxdwmc" + ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb";
		} else {
			groupBy = "";
			selectConditon = "'' as dsjgdm,'' as dsjgmc"
					+ ",'' as fxjdm,'' as fxjmc" + ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb";
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
	}

	public Page getTjxxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return rcjcDao.getTjxxListForPage(map, pageNo, pageSize, sort, desc);
	}

	public Page getRcjcycyjListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return rcjcDao.getRcjcycyjListForPage(map, pageNo, pageSize, sort, desc);
	}
}
