package com.aisino2.basicsystem.service.impl;

import java.util.Map;

import com.aisino2.basicsystem.dao.IAsjtjDao;
import com.aisino2.basicsystem.service.IAsjtjService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class AsjtjServiceImpl extends BaseService implements IAsjtjService {

	private IAsjtjDao asjtjDao;

	public Page getAsjtjList(Map map, int pageNo, int pageSize, String sort,
			String desc) {
		getConditions(map);
		return asjtjDao.getAsjtjList(map, pageNo, pageSize, sort, desc);
	}

	private void getConditions(Map map) {
		boolean dsjgbz = ((String) map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String) map.get("fxjbz")).equalsIgnoreCase("1");
		boolean gxdwbz = ((String) map.get("gxdwbz")).equalsIgnoreCase("1");
		boolean csbz = ((String) map.get("csbz")).equalsIgnoreCase("1");
		String groupBy = "";
		String selectConditon = "";
		if (csbz) {
			groupBy = "dsjgdm,dsjgmc" + ",fxjdm,fxjmc" + ",gxdwdm,gxdwmc"
					+ ",qybm,qymc" +",hylbdm,hylb";
			selectConditon = groupBy;
		} else if (gxdwbz) {

			groupBy = "dsjgdm,dsjgmc" + ",fxjdm,fxjmc" + ",gxdwdm,gxdwmc";
			selectConditon = groupBy + ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb";
		} else if (fxjbz) {
			groupBy = "dsjgdm,dsjgmc" + ",fxjdm,fxjmc";
			selectConditon = groupBy + ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb";
		} else if (dsjgbz) {
			groupBy = "dsjgdm,dsjgmc";
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

	public IAsjtjDao getAsjtjDao() {
		return asjtjDao;
	}

	public void setAsjtjDao(IAsjtjDao asjtjDao) {
		this.asjtjDao = asjtjDao;
	}
}
