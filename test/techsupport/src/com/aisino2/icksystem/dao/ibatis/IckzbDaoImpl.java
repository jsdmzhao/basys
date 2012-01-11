package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IIckzbDao;
import com.aisino2.icksystem.domain.Ickzb;

public class IckzbDaoImpl extends BaseDao implements IIckzbDao {
	/** @param IC卡组包(t_ickzb) 增加 */
	public Ickzb insertIckzb(Ickzb ickzb){
		// TODO: implement
		ickzb.setZbid(getNextID("Zbid"));
		insert("insertIckzb", ickzb);
		return ickzb;
	}

	/** @param IC卡组包(t_ickzb) 删除 */
	public int deleteIckzb(Ickzb ickzb){
		// TODO: implement
		return delete("deleteIckzb", ickzb);
	}

	/** @param IC卡组包(t_ickzb) 修改 */
	public int updateIckzb(Ickzb ickzb){
		// TODO: implement
		return update("updateIckzb", ickzb);
	}

	/** @param IC卡组包(t_ickzb) 查询单条 */
	public Ickzb getIckzb(Ickzb ickzb){
		// TODO: implement
		return (Ickzb)queryForObject("getIckzb", ickzb);
	}

	/** @param IC卡组包(t_ickzb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.pch "+ desc;
			else if(sort.equals("1"))
				sCol = " a.zbsl "+ desc;
			else if(sort.equals("2"))
				sCol = " a.zbr "+ desc;
			else if(sort.equals("3"))
				sCol = " a.zbsj "+ desc;
			else
				sCol = " a.zbid desc ";
		}else{
			sCol="a.zbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIckzbList", map, pageNo,pageSize);
	}

	/** @param IC卡组包(t_ickzb) 多条查询 */
	public List getListIckzb(Ickzb ickzb){
		// TODO: implement
		return queryForList("getIckzbListNoPage", ickzb);
	}
	
	/** @param IC卡组包(t_ickzb) 印刷信息查询 */
	public Ickzb getIckzbYsxx(Ickzb ickzb)
	{
		return (Ickzb)queryForObject("getIckzbYsxx", ickzb);
	}
	
	/** @param IC卡组包(t_ickzb) 电写入信息查询 */
	public Ickzb getIckzbDxrxx(Ickzb ickzb)
	{
		return (Ickzb)queryForObject("getIckzbDxrxx", ickzb);
	}
	
	/** @param IC卡组包(t_ickzb) 分页查询 查询包内需打印的卡的信息*/
	public Page getIckzbYsListForPage(Map map, int pageNo,int pageSize,String sort,String desc)
	{
		String sCol="";
		if (sort!=null){
		}else{
			sCol=" sxh ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIckzbYsList", map, pageNo,pageSize);
	}
	
	/** @param IC卡组包(t_ickzb) 多条查询 需电写入的IC卡查询*/
	public List getIckzbDxrList(Ickzb ickzb)
	{
		return queryForList("getIckzbDxrList", ickzb);
	}
	
	/**
	 * 获得下一个pch
	 * @param map 
	 * @return
	 */
	public String getNextPch(Map map)
	{
		return (String)queryForObject("getNextPch", map);
	}
}
