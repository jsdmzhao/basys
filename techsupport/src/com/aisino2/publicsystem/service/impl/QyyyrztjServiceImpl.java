package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IQyyyrztjDao;
import com.aisino2.publicsystem.domain.Qyyyrztj;
import com.aisino2.publicsystem.service.IQyyyrztjService;

public class QyyyrztjServiceImpl extends BaseService implements IQyyyrztjService {

	private IQyyyrztjDao qyyyrztjDao;

	/** @param 企业营业日志统计(t_qyyyrztj) 增加 */
	public Qyyyrztj insertQyyyrztj(Qyyyrztj qyyyrztj){
		// TODO: implement
		return (Qyyyrztj)qyyyrztjDao.insertQyyyrztj(qyyyrztj);
	}

	/** @param 企业营业日志统计(t_qyyyrztj) 删除 */
	public boolean deleteQyyyrztj(Qyyyrztj qyyyrztj){
		// TODO: implement
		return qyyyrztjDao.deleteQyyyrztj(qyyyrztj)>0;
	}

	/** @param 企业营业日志统计(t_qyyyrztj) 修改 */
	public boolean updateQyyyrztj(Qyyyrztj qyyyrztj){
		// TODO: implement
		return qyyyrztjDao.updateQyyyrztj(qyyyrztj)>0;
	}

	/** @param 企业营业日志统计(t_qyyyrztj) 查询单条 */
	public Qyyyrztj getQyyyrztj(Qyyyrztj qyyyrztj){
		// TODO: implement
		return (Qyyyrztj)qyyyrztjDao.getQyyyrztj(qyyyrztj);
	}

	/** @param 企业营业日志统计(t_qyyyrztj) 统计查询 */
	public Page getListForPagetj(Map map, int pageNo,int pageSize,String sort,String desc){
		String dsjg="nvl(tj.dsjgdm,substr(dept.departcode,0,K)||'L') dsjgdm," +
		"nvl(tj.dsjgmc,(select departname from t_department where departcode=substr(dept.departcode,0,K)||'L')) dsjgmc,";
		String fxj="nvl(tj.fxjdm,substr(dept.departcode,0,K)||'L') fxjdm," +
		"nvl(tj.fxjmc,(select departname from t_department where departcode=substr(dept.departcode,0,K)||'L')) fxjmc,";
		String gxdw="nvl(tj.gxdwdm,dept.departcode) gxdwdm,nvl(tj.gxdwmc,dept.departname) gxdwmc";
		String groupBy = "";
		String selectConditon = "";
		String selectTab="";
		String whereFlg="";
		if (map.get("iszxs")=="1") 
			dsjg=dsjg.replace("K", "2").replace("L", "0000000000");
		else 
			dsjg=dsjg.replace("K", "4").replace("L", "00000000");
		fxj=fxj.replace("K", "6").replace("L", "000000");
		
		if(((String)map.get("gxdwbz")).equalsIgnoreCase("1"))
		{
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc,gxdwdm,gxdwmc";
			selectConditon = groupBy;
			selectTab=dsjg+fxj+gxdw;
			whereFlg=" and dept.departcode =tj.gxdwdm(+)";
		}else if(((String)map.get("fxjbz")).equalsIgnoreCase("1"))
		{
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc";
			selectConditon = groupBy + ",'' as gxdwdm,'' as gxdwmc";
			selectTab=dsjg+fxj+"'' as gxdwdm,'' as gxdwmc";
			whereFlg=" and dept.departcode =tj.fxjdm(+)";
		}else if(((String)map.get("dsjgbz")).equalsIgnoreCase("1"))
		{
			groupBy = "dsjgdm,dsjgmc";
			selectConditon = groupBy + ",'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
			selectTab=dsjg+"'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
			whereFlg=" and dept.departcode =tj.dsjgdm(+)";
		}else{
			groupBy="";
			selectConditon="'' as dsjgdm,'' as dsjgmc,'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
			selectTab=selectConditon;
			whereFlg="";
		}
		map.put("groupBy", groupBy);
		map.put("selectTab", selectTab);
		map.put("selectConditon", selectConditon);
		map.put("whereFlg", whereFlg);
		return qyyyrztjDao.getListForPagetj(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 企业营业日志统计(t_qyyyrztj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String selectConditon = "";
		String groupBy = "";
		if(((String)map.get("gxdwbz")).equalsIgnoreCase("1"))
		{
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc,gxdwdm,gxdwmc";
			selectConditon = groupBy;
		}else if(((String)map.get("fxjbz")).equalsIgnoreCase("1"))
		{
			groupBy = "dsjgdm,dsjgmc,fxjdm,fxjmc";
			selectConditon = groupBy + ",'' as gxdwdm,'' as gxdwmc";
		}else if(((String)map.get("dsjgbz")).equalsIgnoreCase("1"))
		{
			groupBy = "dsjgdm,dsjgmc";
			selectConditon = groupBy + ",'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
		}else{
			groupBy="";
			selectConditon="'' as dsjgdm,'' as dsjgmc,'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
		}
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
		return qyyyrztjDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 企业营业日志统计(t_qyyyrztj) 营业日志明细查询 */
	public Page getrzmxList(Map map, int pageNo,int pageSize,String sort,String desc){
		
		return qyyyrztjDao.getrzmxList(map,pageNo,pageSize,sort,desc);
	}
	
	
	/** @param 企业营业日志统计(t_qyyyrztj) 多条查询 */
	public List getListQyyyrztj(Map map){
		// TODO: implement
		return qyyyrztjDao.getListQyyyrztj(map);
	}

	public IQyyyrztjDao getQyyyrztjDao() {
		return qyyyrztjDao;
	}

	public void setQyyyrztjDao(IQyyyrztjDao qyyyrztjDao) {
		this.qyyyrztjDao = qyyyrztjDao;
	}
}
