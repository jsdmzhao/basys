package com.aisino2.publicsystem.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyryxxDao;
import com.aisino2.publicsystem.domain.Qyryxx;


public class QyryxxDaoImpl extends BaseDao implements IQyryxxDao {
	/** @param 企业人员信息(t_qyryxx) 增加 */
	public Qyryxx insertQyryxx(Qyryxx qyryxx){
		// TODO: implement
		qyryxx.setRyid(getNextID("Ggryid"));
		insert("insertQyryxx", qyryxx);
		return qyryxx;
	}


	/** @param 企业人员信息(t_qyryxx) 删除 */
	public int deleteQyryxx(Qyryxx qyryxx){
		// TODO: implement
		return delete("deleteQyryxx", qyryxx);
	}

	/** @param 企业人员信息(t_qyryxx) 修改 */
	public int updateQyryxx(Qyryxx qyryxx){
		// TODO: implement
		return update("updateQyryxx", qyryxx);
	}

	/** @param 企业人员信息(t_qyryxx) 查询单条 */
	public Qyryxx getQyryxx(Qyryxx qyryxx){
		// TODO: implement
		return (Qyryxx)queryForObject("getQyryxx", qyryxx);
	}

	/** @param 企业人员信息(t_qyryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getQyryxxList", map, pageNo, pageSize);
		}
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.mzdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("6"))
				sCol = " a.zt "+ desc;
			
			//else if(sort.equals("5"))
				//sCol = " b.qymc "+ desc;
			//else if(sort.equals("6"))
			//	sCol = " a.lrsj "+ desc;
		
			
			else if(sort.equals("7"))
				sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.ryid desc ";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxList", map, pageNo,pageSize);
		
		
	}

	/** @param 企业人员信息(t_qyryxx) 多条查询 */
	public List getListQyryxx(Qyryxx qyryxx){
		// TODO: implement
		return queryForList("getQyryxxListNoPage", qyryxx);
	}
	
	/** @param 企业人员信息(t_qyryxx) 多条查询 获得需进行公安人口库比对的人员*/
	public List getDhdQyryxxList(Qyryxx qyryxx)
	{
		return queryForList("getDhdQyryxxList", qyryxx);
	}

	public Qyryxx getHjdxzqh(Qyryxx qyryxx) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("zjhm", qyryxx.getZjhm());
		return (Qyryxx)queryForObject("getHjdxzqhGg", map);
	}

	public List getIsQyryxxExist(Map map) {
		// TODO Auto-generated method stub
		return queryForList("getIsQyryxxExist", map);
	}

	public Page getListCfForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " b.gxdwbm "+ desc;
			else if(sort.equals("7"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.ryid desc";
		}else{
			sCol=" a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxCfList", map, pageNo,pageSize);
	}

	public Page getListGadForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getQyryxxListGad", map, pageNo, pageSize);
		}
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.hjdxzqhdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("6"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zt "+ desc;
			else if(sort.equals("8"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.ryid desc";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxListGad", map, pageNo,pageSize);

	}

	/** @param 从业人员信息(t_cyryxx) 多条查询 获得未提交从业人员*/
	public List getWtjListQyryxx(Qyryxx qyryxx)
	{
		return queryForList("getWtjQyryxxListNoPage", qyryxx);
	}

	public Page getListQydForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			
			 if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.mzdm "+ desc;
			 
			else if(sort.equals("4"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.gwbh "+ desc;
			 
			else if(sort.equals("6"))
				sCol = " a.rzrq "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zt "+ desc;
			 
			else if(sort.equals("8"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.ryid desc";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxListQyd", map, pageNo,pageSize);
	}

	public Page getQyryxxListByCsidForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("5"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.ryid  desc";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxListGad", map, pageNo,pageSize);
	}
	public Page getQyryxxListQydDictForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("2"))
				sCol = " a.gwmc "+ desc;
			else
				sCol = " a.ryid  desc";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxListQydDict", map, pageNo,pageSize);
	}

	public Page getScListGadForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getQyryxxListGad", map, pageNo, pageSize);
		}
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.hjdxzqhdm "+ desc;
			else if(sort.equals("5"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("6"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zxr "+ desc;
			else if(sort.equals("8"))
				sCol = " a.zxsj "+ desc;
			else if(sort.equals("9"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.ryid  desc";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxListGad", map, pageNo,pageSize);
	}
	
	public Page getBgListGadForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("7"))
				sCol = " a.rzrq "+ desc;
			else if(sort.equals("8"))
				sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.ryid  desc";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxListGad", map, pageNo,pageSize);
	}


	public List getMakeRyLzList(Qyryxx qyryxx) {
		// TODO Auto-generated method stub
		return queryForList("getMakeRyLzListGg", qyryxx);
	}


	public int updateQyryxxLzByqyzxGg(Qyryxx qyryxx) {
		// TODO Auto-generated method stub
		return update("updateQyryxxLzByqyzxGg", qyryxx);
	}

	/** @param 从业人员信息(t_qyryxx) 分页查询  采集点提交*/
	public Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		// TODO: implement
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("1"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("5"))
				sCol = " a.lrsj "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cylbdm "+ desc;
			else if(sort.equals("7"))
				sCol = " a.cyryzt "+ desc;
			else
				sCol = " a.ryid desc ";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWtjQyryxxList", map, pageNo,pageSize);
	}
	/** @param 从业人员信息(t_cyryxx) 分页查询  制卡端关联查询*/
	public Page getListZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("2"))
				sCol = " a.gj "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.cylb "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.cyryzt "+ desc;
			else
				sCol = " a.ryid  desc";
		}else{
			sCol=" a.ryid  desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxZkdList", map, pageNo,pageSize);
	}
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  制卡端关联查询 场所所属人员*/
	public Page getListZkdByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.xm "+ desc;
			else if(sort.equals("1"))
				sCol = " a.cyrybh "+ desc;
			else if(sort.equals("2"))
				sCol = " a.gj "+ desc;
			else if(sort.equals("3"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("4"))
				sCol = " a.cylb "+ desc;
			else if(sort.equals("5"))
				sCol = " a.cyryzt "+ desc;
			else
				sCol = " a.ryid  desc";
		}else{
			sCol=" a.ryid  desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyryxxZkdList", map, pageNo,pageSize);
	}

	/** @param 从业人员信息(t_qyryxx) 多条查询 获得已进行公安人口库比对的人员（人员状态为1、4、5的记录）*/
	public List getYhcCyryxxList(Qyryxx qyryxx)
	{
		return queryForList("getYhcCyryxxList", qyryxx);
	}

}
