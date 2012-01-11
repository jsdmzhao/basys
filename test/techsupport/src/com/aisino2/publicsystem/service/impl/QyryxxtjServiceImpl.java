package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyryxxtjDao;
import com.aisino2.publicsystem.domain.Qyryxxtj;
import com.aisino2.publicsystem.service.IQyryxxtjService;

public class QyryxxtjServiceImpl extends BaseService implements IQyryxxtjService {

	private IQyryxxtjDao qyryxxtjDao;

	/** @param 企业人员信息统计表(t_qyryxxtj) 增加 */
	public Qyryxxtj insertQyryxxtj(Qyryxxtj qyryxxtj){
		// TODO: implement
		return (Qyryxxtj)qyryxxtjDao.insertQyryxxtj(qyryxxtj);
	}

	/** @param 企业人员信息统计表(t_qyryxxtj) 删除 */
	public boolean deleteQyryxxtj(Qyryxxtj qyryxxtj){
		// TODO: implement
		return qyryxxtjDao.deleteQyryxxtj(qyryxxtj)>0;
	}

	/** @param 企业人员信息统计表(t_qyryxxtj) 修改 */
	public boolean updateQyryxxtj(Qyryxxtj qyryxxtj){
		// TODO: implement
		return qyryxxtjDao.updateQyryxxtj(qyryxxtj)>0;
	}

	/** @param 企业人员信息统计表(t_qyryxxtj) 查询单条 */
	public Qyryxxtj getQyryxxtj(Qyryxxtj qyryxxtj){
		// TODO: implement
		return (Qyryxxtj)qyryxxtjDao.getQyryxxtj(qyryxxtj);
	}

	/** @param 企业人员信息统计表(t_qyryxxtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		getConditions(map);
	
		return qyryxxtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
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
					+ ",a.qybm,a.qymc" +",a.hylbdm,a.hylb";
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
	/** @param 企业人员信息统计表(t_qyryxxtj) 多条查询 */
	public List getListQyryxxtj(Qyryxxtj qyryxxtj){
		// TODO: implement
		return qyryxxtjDao.getListQyryxxtj(qyryxxtj);
	}

	public IQyryxxtjDao getQyryxxtjDao() {
		return qyryxxtjDao;
	}

	public void setQyryxxtjDao(IQyryxxtjDao qyryxxtjDao) {
		this.qyryxxtjDao = qyryxxtjDao;
	}
}
