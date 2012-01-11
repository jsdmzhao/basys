package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGatztbDao;
import com.aisino2.basicsystem.domain.Gatztb;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class GatztbDaoImpl extends BaseDao implements IGatztbDao {
	/** @param 公安通知通报(t_gatztb) 增加 */
	public Gatztb insertGatztb(Gatztb gatztb){
		// TODO: implement
		gatztb.setGatbid(getNextID("Gatbid"));
		return (Gatztb)insert("insertGatztb", gatztb);
	}

	/** @param 公安通知通报(t_gatztb) 删除 */
	public int deleteGatztb(Gatztb gatztb){
		// TODO: implement
		return delete("deleteGatztb", gatztb);
	}

	/** @param 公安通知通报(t_gatztb) 修改 */
	public int updateGatztb(Gatztb gatztb){
		// TODO: implement
		return update("updateGatztb", gatztb);
	}

	/** @param 公安通知通报(t_gatztb) 查询单条 */
	public Gatztb getGatztb(Gatztb gatztb){
		// TODO: implement
		return (Gatztb)queryForObject("getGatztb", gatztb);
	}

	/** @param 公安通知通报(t_gatztb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Gatbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getGatztbList", map, pageNo,pageSize);
	}

	/** @param 公安通知通报(t_gatztb) 多条查询 */
	public List getListGatztb(Gatztb gatztb){
		// TODO: implement
		return queryForList("getGatztbListNoPage", gatztb);
	}
}
