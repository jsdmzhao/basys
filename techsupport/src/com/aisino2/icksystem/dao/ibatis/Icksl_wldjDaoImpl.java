package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IIcksl_wldjDao;
import com.aisino2.icksystem.domain.Icksl_wldj;

public class Icksl_wldjDaoImpl extends BaseDao implements IIcksl_wldjDao {
	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 增加 */
	public Icksl_wldj insertIcksl_wldj(Icksl_wldj icksl_wldj){
		// TODO: implement
		//icksl_wldj.setWlid(getNextID("Wlid"));
		insert("insertIcksl_wldj", icksl_wldj);
		return icksl_wldj;
	}

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 删除 */
	public int deleteIcksl_wldj(Icksl_wldj icksl_wldj){
		// TODO: implement
		return delete("deleteIcksl_wldj", icksl_wldj);
	}

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 修改 */
	public int updateIcksl_wldj(Icksl_wldj icksl_wldj){
		// TODO: implement
		return update("updateIcksl_wldj", icksl_wldj);
	}

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 查询单条 */
	public Icksl_wldj getIcksl_wldj(Icksl_wldj icksl_wldj){
		// TODO: implement
		return (Icksl_wldj)queryForObject("getIcksl_wldj", icksl_wldj);
	}

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Wlid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIcksl_wldjList", map, pageNo,pageSize);
	}

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 多条查询 */
	public List getListIcksl_wldj(Icksl_wldj icksl_wldj){
		// TODO: implement
		return queryForList("getIcksl_wldjListNoPage", icksl_wldj);
	}
}
