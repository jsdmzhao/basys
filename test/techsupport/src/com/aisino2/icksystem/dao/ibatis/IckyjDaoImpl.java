package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IIckyjDao;
import com.aisino2.icksystem.domain.Ickyj;

public class IckyjDaoImpl extends BaseDao implements IIckyjDao {
	/** @param IC卡预警(t_ickyj) 增加 */
	public Ickyj insertIckyj(Ickyj ickyj){
		// TODO: implement
		ickyj.setIckyjid(getNextID("Ickyjid"));
		return (Ickyj)insert("insertIckyj", ickyj);
	}

	/** @param IC卡预警(t_ickyj) 删除 */
	public int deleteIckyj(Ickyj ickyj){
		// TODO: implement
		return delete("deleteIckyj", ickyj);
	}

	/** @param IC卡预警(t_ickyj) 修改 */
	public int updateIckyj(Ickyj ickyj){
		// TODO: implement
		return update("updateIckyj", ickyj);
	}

	/** @param IC卡预警(t_ickyj) 查询单条 */
	public Ickyj getIckyj(Ickyj ickyj){
		// TODO: implement
		return (Ickyj)queryForObject("getIckyj", ickyj);
	}

	/** @param IC卡预警(t_ickyj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Ickyjid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIckyjList", map, pageNo,pageSize);
	}

	/** @param IC卡预警(t_ickyj) 多条查询 */
	public List getListIckyj(Ickyj ickyj){
		// TODO: implement
		return queryForList("getIckyjListNoPage", ickyj);
	}
}
