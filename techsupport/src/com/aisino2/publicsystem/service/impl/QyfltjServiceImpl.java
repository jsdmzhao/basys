package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyfltjDao;
import com.aisino2.publicsystem.domain.Qyfltj;
import com.aisino2.publicsystem.service.IQyfltjService;

public class QyfltjServiceImpl extends BaseService implements IQyfltjService {

	private IQyfltjDao qyfltjDao;

	/** @param 企业分类统计(t_qyfltj) 增加 */
	public Qyfltj insertQyfltj(Qyfltj qyfltj){
		// TODO: implement
		return (Qyfltj)qyfltjDao.insertQyfltj(qyfltj);
	}

	/** @param 企业分类统计(t_qyfltj) 删除 */
	public boolean deleteQyfltj(Qyfltj qyfltj){
		// TODO: implement
		return qyfltjDao.deleteQyfltj(qyfltj)>0;
	}

	/** @param 企业分类统计(t_qyfltj) 修改 */
	public boolean updateQyfltj(Qyfltj qyfltj){
		// TODO: implement
		return qyfltjDao.updateQyfltj(qyfltj)>0;
	}

	/** @param 企业分类统计(t_qyfltj) 查询单条 */
	public Qyfltj getQyfltj(Qyfltj qyfltj){
		// TODO: implement
		return (Qyfltj)qyfltjDao.getQyfltj(qyfltj);
	}

	/** @param 企业分类统计(t_qyfltj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		getConditions(map);
		return qyfltjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 企业分类统计(t_qyfltj) 多条查询 */
	public List getListQyfltj(Qyfltj qyfltj){
		// TODO: implement
		return qyfltjDao.getListQyfltj(qyfltj);
	}

	public IQyfltjDao getQyfltjDao() {
		return qyfltjDao;
	}

	public void setQyfltjDao(IQyfltjDao qyfltjDao) {
		this.qyfltjDao = qyfltjDao;
	}
	
	private void getConditions(Map map) {
		String dsjg="(case when tj.dsjgdm is null then substr(dept.departcode,0,K)||'L'  else tj.dsjgdm end) dsjgdm," +
				"(case when tj.dsjgmc is null then (select departname from t_department where departcode=substr(dept.departcode,0,K)||'L')  else tj.dsjgmc end)dsjgmc,";
		String fxj="(case when tj.fxjdm is null then substr(dept.departcode,0,K)||'L'   else tj.fxjdm end) fxjdm," +
				"(case when tj.fxjmc is null then (select departname from t_department where departcode=substr(dept.departcode,0,K)||'L')  else tj.fxjmc end)fxjmc,";
		String gxdw="(case when tj.gxdwdm is null then dept.departcode else tj.gxdwdm end)  gxdwdm,(case when tj.gxdwmc is null then dept.departname else tj.gxdwmc end)   gxdwmc";
		boolean dsjgbz = ((String)map.get("dsjgbz")).equalsIgnoreCase("1");
		boolean fxjbz = ((String)map.get("fxjbz")).equalsIgnoreCase("1"); 
		boolean gxdwbz = ((String)map.get("gxdwbz")).equalsIgnoreCase("1");
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
	}
	
	/** @param 企业分类统计(t_qyfltj) 信息采集 */
	public Page getListForPageQY(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		getConditions(map);
		return qyfltjDao.getListForPageQY(map,pageNo,pageSize,sort,desc);
	}
}
