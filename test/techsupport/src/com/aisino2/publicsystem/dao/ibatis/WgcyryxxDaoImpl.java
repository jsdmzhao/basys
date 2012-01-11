package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IWgcyryxxDao;
import com.aisino2.publicsystem.domain.Wgcyryxx;

public class WgcyryxxDaoImpl extends BaseDao implements IWgcyryxxDao {
	/** @param 外国从业人员信息(t_wgcyryxx) 增加 */
	public Wgcyryxx insertWgcyryxx(Wgcyryxx wgcyryxx){
		// TODO: implement
		//wgcyryxx.setQyid(getNextID("Qyid"));
		insert("insertWgcyryxxGg", wgcyryxx);
		return wgcyryxx;
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 删除 */
	public int deleteWgcyryxx(Wgcyryxx wgcyryxx){
		// TODO: implement
		return delete("deleteWgcyryxxGg", wgcyryxx);
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 修改 */
	public int updateWgcyryxx(Wgcyryxx wgcyryxx){
		// TODO: implement
		return update("updateWgcyryxxGg", wgcyryxx);
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 查询单条 */
	public Wgcyryxx getWgcyryxx(Wgcyryxx wgcyryxx){
		// TODO: implement
		return (Wgcyryxx)queryForObject("getWgcyryxxGg", wgcyryxx);
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getWgcyryxxGgList", map, pageNo, pageSize);
		}
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
				sCol = " a.gj "+ desc;
			else if(sort.equals("5"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("6"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zt "+ desc;
			else if(sort.equals("8"))
			    sCol = " a.cyryztdm "+ desc;
		
		
			
			else
				sCol = " a.ryid desc ";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWgcyryxxGgList", map, pageNo,pageSize);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 多条查询 */
	public List getListWgcyryxx(Wgcyryxx wgcyryxx){
		// TODO: implement
		return queryForList("getWgcyryxxGgListNoPage", wgcyryxx);
	}

	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 人员查询、注销查询*/
	public Page getListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getWgyryxxGgListGad", map, pageNo, pageSize);
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
				sCol = " a.gj "+ desc;
			else if(sort.equals("5"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("6"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zxbz "+ desc;
			else if(sort.equals("8"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.ryid desc ";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWgyryxxGgListGad", map, pageNo,pageSize);
	}
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  公安端 派出所审核查询 市局审核查询*/
	public Page getListGadForPageRysh(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getWgyryxxGgListGad", map, pageNo, pageSize);
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
				sCol = " a.gj "+ desc;
			else if(sort.equals("5"))
				sCol = " a.gwbh "+ desc;
			else if(sort.equals("6"))
				sCol = " b.qymc "+ desc;
			else if(sort.equals("7"))
				sCol = " a.zt "+ desc;
			else if(sort.equals("8"))
			    sCol = " a.cyryztdm "+ desc;
			else
				sCol = " a.ryid desc ";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWgyryxxGgListGad", map, pageNo,pageSize);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 企业人员查询*/
	public Page getListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc)
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
				sCol = " a.zjhm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.xbdm "+ desc;
			else if(sort.equals("3"))
				sCol = " a.gjdm "+ desc;
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
				sCol = " a.ryid  desc";
		}else{
			sCol="a.ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWgyryxxGgListQyd", map, pageNo,pageSize);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询  由场所ID或场所编码获得该场所下从业人员*/
	public Page getCyryxxListByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc)
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
		return queryForPage("getWgyryxxGgListGad", map, pageNo,pageSize);
	}
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 删除查询*/
	public Page getScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getWgyryxxGgListGad", map, pageNo, pageSize);
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
				sCol = " a.gj "+ desc;
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
		return queryForPage("getWgyryxxGgListGad", map, pageNo,pageSize);
	}
}
