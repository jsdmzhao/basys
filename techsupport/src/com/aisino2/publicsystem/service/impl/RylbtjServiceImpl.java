package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IRylbtjDao;
import com.aisino2.publicsystem.domain.Rylbtj;
import com.aisino2.publicsystem.service.IRylbtjService;

public class RylbtjServiceImpl extends BaseService implements IRylbtjService {

	private IRylbtjDao rylbtjDao;

	/** @param 人员类别统计(t_rylbtj) 增加 */
	public Rylbtj insertRylbtj(Rylbtj rylbtj){
		// TODO: implement
		return (Rylbtj)rylbtjDao.insertRylbtj(rylbtj);
	}

	/** @param 人员类别统计(t_rylbtj) 删除 */
	public boolean deleteRylbtj(Rylbtj rylbtj){
		// TODO: implement
		return rylbtjDao.deleteRylbtj(rylbtj)>0;
	}

	/** @param 人员类别统计(t_rylbtj) 修改 */
	public boolean updateRylbtj(Rylbtj rylbtj){
		// TODO: implement
		return rylbtjDao.updateRylbtj(rylbtj)>0;
	}

	/** @param 人员类别统计(t_rylbtj) 查询单条 */
	public Rylbtj getRylbtj(Rylbtj rylbtj){
		// TODO: implement
		return (Rylbtj)rylbtjDao.getRylbtj(rylbtj);
	}

	/** @param 人员类别统计(t_rylbtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		getConditions(map);
		return rylbtjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 人员类别统计(t_rylbtj) 多条查询 */
	public List getListRylbtj(Rylbtj rylbtj){
		// TODO: implement
		return rylbtjDao.getListRylbtj(rylbtj);
	}

	public IRylbtjDao getRylbtjDao() {
		return rylbtjDao;
	}

	public void setRylbtjDao(IRylbtjDao rylbtjDao) {
		this.rylbtjDao = rylbtjDao;
	}
	
	private void getConditions(Map map) {
		boolean dsjgbz = ((String) map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String) map.get("fxjbz")).equalsIgnoreCase("1");
		boolean gxdwbz = ((String) map.get("gxdwbz")).equalsIgnoreCase("1");
		boolean qybz = ((String) map.get("qybz")).equalsIgnoreCase("1");
		String groupBy = "";
		String selectConditon = "";
		if (qybz) {
			groupBy = "dsjgdm,dsjgmc" +
					",fxjdm,fxjmc" +
					",gxdwdm,gxdwmc" +
					",qybm,qymc";
			selectConditon = groupBy;
		} else if (gxdwbz) {

			groupBy = "dsjgdm,dsjgmc" +
					",fxjdm,fxjmc" +
					",gxdwdm,gxdwmc";
			selectConditon = groupBy 
					+ ",'' as qybm,'' as qymc";
		} else if (fxjbz) {
			groupBy = "dsjgdm,dsjgmc" +
					",fxjdm,fxjmc";
			selectConditon = groupBy 
					+ ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as qybm,'' as qymc";
		} else if (dsjgbz) {
			groupBy = "dsjgdm,dsjgmc";
			selectConditon = groupBy
					+ ",'' as fxjdm,'' as fxjmc" 
					+ ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as qybm,'' as qymc";
		} else {
			groupBy = "";
			selectConditon = "'' as dsjgdm,'' as dsjgmc" 
					+ ",'' as fxjdm,'' as fxjmc" 
					+ ",'' as gxdwdm,'' as gxdwmc"
					+ ",'' as qybm,'' as qymc";
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
	}
	
	/** @param 人员类别统计(t_rylbtj) 信息采集 */
	public Page getListForPageRY(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String dsjg="(case when tj.dsjgdm is null then substr(dept.departcode,0,K)||'L'  else tj.dsjgdm end) dsjgdm," +
				"(case when tj.dsjgmc is null then (select departname from t_department where departcode=substr(dept.departcode,0,K)||'L')  else tj.dsjgmc end)dsjgmc,";
		String fxj="(case when tj.fxjdm is null then substr(dept.departcode,0,K)||'L'  else tj.fxjdm end) fxjdm," +
				"(case when tj.fxjmc is null then (select departname from t_department where departcode=substr(dept.departcode,0,K)||'L')  else tj.fxjmc end)fxjmc,";
		String gxdw="(case when tj.gxdwdm is null then dept.departcode else tj.gxdwdm end)  gxdwdm,(case when tj.gxdwmc is null then dept.departname else tj.gxdwmc end)   gxdwmc";
		boolean dsjgbz = ((String) map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String) map.get("fxjbz")).equalsIgnoreCase("1");
		boolean gxdwbz = ((String) map.get("gxdwbz")).equalsIgnoreCase("1");
		String groupBy = "";
		String selectConditon = "";
		String selectTab="";
		String whereFlg="";
		if(gxdwbz)
		{
		
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc,gxdwdm,gxdwmc";
			selectConditon = groupBy;
			selectTab=dsjg.replace("K", "4").replace("L", "00000000")
						+fxj.replace("K", "6").replace("L", "000000")+gxdw+",'' as qybm,'' as qymc";
			whereFlg=" and dept.departcode =tj.gxdwdm(+)";
		}else if(fxjbz)
		{
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc";
			selectConditon = groupBy + ",'' as gxdwdm,'' as gxdwmc";
			selectTab=dsjg.replace("K", "4").replace("L", "00000000")
						+fxj.replace("K", "8").replace("L", "0000")+"'' as gxdwdm,'' as gxdwmc,'' as qybm,'' as qymc";
			whereFlg=" and dept.departcode =tj.fxjdm(+)";
		}else if(dsjgbz)
		{
			groupBy = "dsjgdm,dsjgmc";
			selectConditon = groupBy + ",'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
			selectTab=dsjg.replace("K", "8").replace("L", "0000")+"'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc,'' as qybm,'' as qymc";
			whereFlg=" and dept.departcode =tj.dsjgdm(+)";
		}else{
			groupBy="";
			selectConditon="'' as dsjgdm,'' as dsjgmc,'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
			selectTab="'' as dsjgdm,'' as dsjgmc,'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc,'' as qybm,'' as qymc";
			whereFlg="";
		}
		map.put("groupBy", groupBy);
		map.put("selectTab", selectTab);
		map.put("selectConditon", selectConditon);
		map.put("whereFlg", whereFlg);
		return rylbtjDao.getListForPageRY(map,pageNo,pageSize,sort,desc);
	}
}
