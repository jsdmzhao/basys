package com.aisino2.icksystem.dao.ibatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.util.PinYinUtil;
import com.aisino2.icksystem.dao.IGzrztjDao;
import com.aisino2.publicsystem.domain.Qyyyrztj;


public class GzrztjDaoImpl extends BaseDao implements IGzrztjDao {
	/** @param 工作日志统计按人员 多条查询 */
	public List getListForPagePeop(Qyyyrztj qyyyrztj) {
		Map map = new HashMap();
		//对同音的处理
		map.put("hylbdm", qyyyrztj.getHylbdm());
		
		if(!qyyyrztj.getXm().equals("")&&qyyyrztj.getXmpy().equals("yes")){
				map.put("xm", null);
				String xmpy=PinYinUtil.getHanyuPingYin(qyyyrztj.getXm());
				map.put("xmpy", xmpy);
		}else{
			map.put("xm", qyyyrztj.getXm());
			map.put("xmpy", null);
		}
		map.put("cyrybh",qyyyrztj.getCyrybh());
		map.put("wgrjyxkz", qyyyrztj.getWgrjyxkz());
		map.put("ywm", qyyyrztj.getYwm());
		map.put("zjhm",  qyyyrztj.getZjhm());
		map.put("ksyysj", qyyyrztj.getKsyysj());
		map.put("jsyysj", qyyyrztj.getJsyysj());
		map.put("beginRow",qyyyrztj.getBeginRow());
		map.put("endRow",qyyyrztj.getEndRow());
		map.put("gxdwbm",qyyyrztj.getGxdwbm());
		
		String sCol="";
		String sort=qyyyrztj.getSort();
		String desc=qyyyrztj.getDir();
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " xm "+ desc;
			else if(sort.equals("2"))
				sCol = " sksj "+ desc;
			else if(sort.equals("3"))
				sCol = " qybm "+ desc;
			else if(sort.equals("4"))
				sCol = " gxdwbm "+ desc;
			else
				sCol = " sksj desc ";
		}else{
			sCol="sksj desc ";
		}
		map.put("pageSort", sCol);
		
		this.queryForObject("getQyyyrztjPeopPro", map);
		List list = (List) map.get("result");
		if (list == null || list.size() == 0) list = new ArrayList();
		return list;

	}


	/** @param 工作日志统计按人员 多条查询行数*/
	public Integer getPeopRows(Qyyyrztj qyyyrztj) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("hylbdm", qyyyrztj.getHylbdm());
		//对同音的处理
		if(!qyyyrztj.getXm().equals("")&&qyyyrztj.getXmpy().equals("yes")){
				map.put("xm", null);
				String xmpy=PinYinUtil.getHanyuPingYin(qyyyrztj.getXm());
				map.put("xmpy", xmpy);
		}else{
			map.put("xm", qyyyrztj.getXm());
			map.put("xmpy", null);
		}
		map.put("cyrybh",qyyyrztj.getCyrybh());
		map.put("wgrjyxkz", qyyyrztj.getWgrjyxkz());
		map.put("ywm", qyyyrztj.getYwm());
		map.put("zjhm",  qyyyrztj.getZjhm());
		map.put("ksyysj", qyyyrztj.getKsyysj());
		map.put("jsyysj", qyyyrztj.getJsyysj());
		map.put("gxdwbm",qyyyrztj.getGxdwbm());
		 this.queryForObject("getQyyyrztjPeopRowsPro", map);
			List list = (List) map.get("result");
		if (list == null || list.size() == 0)
		   list = new ArrayList();
		return ((Qyyyrztj)list.get(0)).getAllRow();
	}
	
	/** @param 工作日志统计按场所 多条查询 */
	public List getListForPageUnit(Qyyyrztj qyyyrztj) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("hylbdm", qyyyrztj.getHylbdm());
		if(qyyyrztj.getQybm()==null||qyyyrztj.getQybm().equals("") ){
			map.put("qybm",null);
		}else{
			map.put("qybm", qyyyrztj.getQybm());
		}
		map.put("ksyysj", qyyyrztj.getKsyysj());
		map.put("jsyysj", qyyyrztj.getJsyysj());
		map.put("beginRow",qyyyrztj.getBeginRow());
		map.put("endRow",qyyyrztj.getEndRow());
		map.put("gxdwbm",qyyyrztj.getGxdwbm());
		
		String sCol="";
		String sort=qyyyrztj.getSort();
		String desc=qyyyrztj.getDir();
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " bqycyryxm "+ desc;
			else if(sort.equals("1"))
				sCol = " bqycyrybh "+ desc;
			else if(sort.equals("2"))
				sCol = " crqycyryxm "+ desc;
			else if(sort.equals("3"))
				sCol = " crqycyrybh "+ desc;
			else if(sort.equals("4"))
				sCol = " sksj "+ desc;
			else
				sCol = " sksj desc ";
		}else{
			sCol="sksj desc ";
		}
		map.put("pageSort", sCol);
		
		 this.queryForObject("getQyyyrztjUnitPro", map);
			List list = (List) map.get("result");
		if (list == null || list.size() == 0)
		   list = new ArrayList();
	 	return list;
	}
	/** @param 工作日志统计按场所 多条查询 行数*/
	public Integer getUnitRows(Qyyyrztj qyyyrztj) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("hylbdm", qyyyrztj.getHylbdm());
		if(qyyyrztj.getQybm()==null||qyyyrztj.getQybm().equals("") ){
			map.put("qybm",null);
		}else{
			map.put("qybm", qyyyrztj.getQybm());
		}
		map.put("ksyysj", qyyyrztj.getKsyysj());
		map.put("jsyysj", qyyyrztj.getJsyysj());
		map.put("gxdwbm",qyyyrztj.getGxdwbm());
		 this.queryForObject("getQyyyrztjUnitRowsPro", map);
			List list = (List) map.get("result");
		if (list == null || list.size() == 0)
		   list = new ArrayList();
		return ((Qyyyrztj)list.get(0)).getAllRow();
	}
	
}
