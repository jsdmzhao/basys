package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IIcksltjDao;
import com.aisino2.icksystem.domain.Icksltj;

public class IcksltjDaoImpl extends BaseDao implements IIcksltjDao {
	/** @param IC卡受理统计(t_icksltj) 增加 */
	public Icksltj insertIcksltj(Icksltj icksltj){
		// TODO: implement
		icksltj.setIcksltjid(getNextID("Icksltjid"));
		return (Icksltj)insert("insertIcksltj", icksltj);
	}

	/** @param IC卡受理统计(t_icksltj) 删除 */
	public int deleteIcksltj(Icksltj icksltj){
		// TODO: implement
		return delete("deleteIcksltj", icksltj);
	}

	/** @param IC卡受理统计(t_icksltj) 修改 */
	public int updateIcksltj(Icksltj icksltj){
		// TODO: implement
		return update("updateIcksltj", icksltj);
	}

	/** @param IC卡受理统计(t_icksltj) 查询单条 */
	public Icksltj getIcksltj(Icksltj icksltj){
		// TODO: implement
		return (Icksltj)queryForObject("getIcksltj", icksltj);
	}

	/** @param IC卡受理统计(t_icksltj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Icksltjid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIcksltjList", map, pageNo,pageSize);
	}

	/** @param IC卡受理统计(t_icksltj) 多条查询 */
	public List getListIcksltj(Icksltj icksltj){
		// TODO: implement
		return queryForList("getIcksltjListNoPage", icksltj);
	}
}
