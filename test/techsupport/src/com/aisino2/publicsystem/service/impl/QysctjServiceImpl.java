package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQysctjDao;
import com.aisino2.publicsystem.domain.Qysctj;
import com.aisino2.publicsystem.service.IQysctjService;

public class QysctjServiceImpl extends BaseService implements IQysctjService {

	private IQysctjDao qysctjDao;

	/** @param 企业上传统计表(t_qysctj) 增加 */
	public Qysctj insertQysctj(Qysctj qysctj){
		// TODO: implement
		return (Qysctj)qysctjDao.insertQysctj(qysctj);
	}

	/** @param 企业上传统计表(t_qysctj) 删除 */
	public boolean deleteQysctj(Qysctj qysctj){
		// TODO: implement
		return qysctjDao.deleteQysctj(qysctj)>0;
	}

	/** @param 企业上传统计表(t_qysctj) 修改 */
	public boolean updateQysctj(Qysctj qysctj){
		// TODO: implement
		return qysctjDao.updateQysctj(qysctj)>0;
	}

	/** @param 企业上传统计表(t_qysctj) 查询单条 */
	public Qysctj getQysctj(Qysctj qysctj){
		// TODO: implement
		return (Qysctj)qysctjDao.getQysctj(qysctj);
	}

	/** @param 企业上传统计表(t_qysctj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return qysctjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业上传统计表(t_qysctj) 多条查询 */
	public List getListQysctj(Qysctj qysctj){
		// TODO: implement
		return qysctjDao.getListQysctj(qysctj);
	}

	public IQysctjDao getQysctjDao() {
		return qysctjDao;
	}

	public void setQysctjDao(IQysctjDao qysctjDao) {
		this.qysctjDao = qysctjDao;
	}

	public Page getSktjListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		getConditions(map);
		return qysctjDao.getSktjListForPage(map, pageNo, pageSize, sort, desc);
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
			selectConditon = groupBy+",'0' as lxdh,'0' as sfdb";
		} else if (gxdwbz) {

			groupBy = "a.dsjgdm,a.dsjgmc" + ",a.fxjdm,a.fxjmc" + ",a.gxdwdm,a.gxdwmc";
			selectConditon = groupBy + ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb"+",'0' as lxdh,'0' as sfdb";
		} else if (fxjbz) {
			groupBy = "a.dsjgdm,a.dsjgmc" + ",a.fxjdm,a.fxjmc";
			selectConditon = groupBy + ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb"+",'0' as lxdh,'0' as sfdb";
		} else if (dsjgbz) {
			groupBy = "a.dsjgdm,a.dsjgmc";
			selectConditon = groupBy + ",'' as fxjdm,'' as fxjmc"
					+ ",'' as gxdwdm,'' as gxdwmc" + ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb"+",'0' as lxdh,'0' as sfdb";
		} else {
			groupBy = "";
			selectConditon = "'' as dsjgdm,'' as dsjgmc"
					+ ",'' as fxjdm,'' as fxjmc" + ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb"+",'0' as lxdh,'0' as sfdb";
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
	}

	public Page getSktjxxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		getConditionsxx(map);
		return qysctjDao.getSktjxxListForPage(map, pageNo, pageSize, sort, desc);
	}
	private void getConditionsxx(Map map) {
		boolean dsjgbz = ((String) map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String) map.get("fxjbz")).equalsIgnoreCase("1");
		boolean gxdwbz = ((String) map.get("gxdwbz")).equalsIgnoreCase("1");
		boolean csbz = ((String) map.get("csbz")).equalsIgnoreCase("1");
		String groupBy = "";
		String selectConditon = "";
		if (csbz) {
			groupBy = "a.dsjgdm,a.dsjgmc" + ",a.fxjdm,a.fxjmc" + ",a.gxdwdm,a.gxdwmc"
					+ ",a.qybm,a.qymc" +",a.hylbdm,a.hylb, a.tjrq";
			selectConditon = groupBy+",'0' as lxdh,'0' as sfdb";
		} else if (gxdwbz) {

			groupBy = "a.dsjgdm,a.dsjgmc" + ",a.fxjdm,a.fxjmc" + ",a.gxdwdm,a.gxdwmc, a.tjrq";
			selectConditon = groupBy + ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb"+",'0' as lxdh,'0' as sfdb";
		} else if (fxjbz) {
			groupBy = "a.dsjgdm,a.dsjgmc" + ",a.fxjdm,a.fxjmc, a.tjrq";
			selectConditon = groupBy + ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb"+",'0' as lxdh,'0' as sfdb";
		} else if (dsjgbz) {
			groupBy = "a.dsjgdm,a.dsjgmc , a.tjrq";
			selectConditon = groupBy + ",'' as fxjdm,'' as fxjmc"
					+ ",'' as gxdwdm,'' as gxdwmc" + ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb"+",'0' as lxdh,'0' as sfdb";
		} else {
			groupBy = "";
			selectConditon = "'' as dsjgdm,'' as dsjgmc, a.tjrq"
					+ ",'' as fxjdm,'' as fxjmc" + ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as qybm,'' as qymc,'' as hylbdm,'' as hylb"+",'0' as lxdh,'0' as sfdb";
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
	}

	public Page getZtxxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		 return qysctjDao.getZtxxListForPage(map, pageNo, pageSize, sort, desc);
	}
	//一次/多次刷卡人员信息
	public Page getYcskxxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		 return qysctjDao.getYcskxxListForPage(map, pageNo, pageSize, sort, desc);
	}
}
