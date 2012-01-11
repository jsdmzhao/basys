package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IWscqyDao;
import com.aisino2.publicsystem.domain.Wscqy;

public class WscqyDaoImpl extends BaseDao implements IWscqyDao {
	/** @param 未上传企业(t_wscqy) 增加 */
	public Wscqy insertWscqy(Wscqy wscqy){
		// TODO: implement
		wscqy.setWscqyid(getNextID("Wscqyid"));
		return (Wscqy)insert("insertWscqy", wscqy);
	}

	/** @param 未上传企业(t_wscqy) 删除 */
	public int deleteWscqy(Wscqy wscqy){
		// TODO: implement
		return delete("deleteWscqy", wscqy);
	}

	/** @param 未上传企业(t_wscqy) 修改 */
	public int updateWscqy(Wscqy wscqy){
		// TODO: implement
		return update("updateWscqy", wscqy);
	}

	/** @param 未上传企业(t_wscqy) 查询单条 */
	public Wscqy getWscqy(Wscqy wscqy){
		// TODO: implement
		return (Wscqy)queryForObject("getWscqy", wscqy);
	}

	/** @param 未上传企业(t_wscqy) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if("0".equals(map.get("dsjgbz"))&&"0".equals(map.get("fxjbz"))&&"0".equals(map.get("gxdwbz")))
			{sort=String.valueOf(Integer.parseInt(sort)+1);}
			if(sort.equals("3"))
				sCol = " wscts "+ desc;
			else if(sort.equals("4"))
				sCol = " yljts "+ desc;
			else if(sort.equals("5"))
				sCol = " nljts "+ desc;
			else
				sCol = " a.gxdwdm asc  ";
		}else{
			sCol="a.gxdwdm asc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWscqyList", map, pageNo,pageSize);
	}

	/** @param 未上传企业(t_wscqy) 多条查询 */
	public List getListWscqy(Wscqy wscqy){
		// TODO: implement
		return queryForList("getWscqyListNoPage", wscqy);
	}

	public Page getXxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Wscqyid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWscqyXxList", map, pageNo,pageSize);
	}
	/** @param 未上传企业(t_wscqy) 分页查询 采集点台账用*/
	public Page getWscqyListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return queryForPage("getWscCsqkList", map, pageNo,pageSize);
	}
	
	/** @param 未上传企业(t_wscqy) 分页查询 采集点台账用*/
	public Page getSkcstjListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = "a.dsjgdm "+ desc;
			else if(sort.equals("1"))
				sCol = "a.fxjdm "+ desc;
			else if(sort.equals("2"))
				sCol = "a.gwdwdm "+ desc;
			else if(sort.equals("3"))
				sCol = "qyzs "+ desc;
			else if(sort.equals("4"))
				sCol = "wscqys "+ desc;
			else if(sort.equals("5"))
				sCol = "scqys "+ desc;
			else
				sCol = (String)map.get("groupBy");
		}else{
				sCol = (String)map.get("groupBy");
		}
		map.put("pageSort", sCol);
		return queryForPage("getSkcstjList", map, pageNo,pageSize);
	}
	
	/** @param 未上传企业(t_wscqy) 分页查询 企业刷卡未上传明细*/
	public Page getSkwscmxListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = "b.wscrq "+ desc;
			else if(sort.equals("1"))
				sCol = "b.qymc "+ desc;
			else if(sort.equals("2"))
				sCol = "b.qybm "+ desc;
			else if(sort.equals("3"))
				sCol = "c.zrs "+ desc;
			else if(sort.equals("4"))
				sCol = "c.lxdh "+ desc;
			else if(sort.equals("5"))
				sCol = "c.qyzflbm "+ desc;
			else if(sort.equals("6"))
				sCol = "c.yyztdm "+ desc;
			else if(sort.equals("7"))
				sCol = "c.zabdm "+ desc;
			else
				sCol = "b.wscqyid desc";
		}else{
				sCol = "b.wscqyid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getSkwscmxList", map, pageNo,pageSize);
	}
}
