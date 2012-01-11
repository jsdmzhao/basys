package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IIcksl_ickzbDao;
import com.aisino2.icksystem.domain.Icksl_ickzb;

public class Icksl_ickzbDaoImpl extends BaseDao implements IIcksl_ickzbDao {
	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 增加 */
	public Icksl_ickzb insertIcksl_ickzb(Icksl_ickzb icksl_ickzb){
		// TODO: implement
		//icksl_ickzb.setZbid(getNextID("Zbid"));
		insert("insertIcksl_ickzb", icksl_ickzb);
		return icksl_ickzb;
	}

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 删除 */
	public int deleteIcksl_ickzb(Icksl_ickzb icksl_ickzb){
		// TODO: implement
		return delete("deleteIcksl_ickzb", icksl_ickzb);
	}

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 修改 */
	public int updateIcksl_ickzb(Icksl_ickzb icksl_ickzb){
		// TODO: implement
		return update("updateIcksl_ickzb", icksl_ickzb);
	}

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 查询单条 */
	public Icksl_ickzb getIcksl_ickzb(Icksl_ickzb icksl_ickzb){
		// TODO: implement
		return (Icksl_ickzb)queryForObject("getIcksl_ickzb", icksl_ickzb);
	}

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Zbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIcksl_ickzbList", map, pageNo,pageSize);
	}

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 多条查询 */
	public List getListIcksl_ickzb(Icksl_ickzb icksl_ickzb){
		// TODO: implement
		return queryForList("getIcksl_ickzbListNoPage", icksl_ickzb);
	}
}
