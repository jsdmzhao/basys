package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGatztbjsdwDao;
import com.aisino2.basicsystem.domain.Gatztbjsdw;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class GatztbjsdwDaoImpl extends BaseDao implements IGatztbjsdwDao {
	/** @param 公安通知通报接收单位(t_gatztbjsdw) 增加 */
	public Gatztbjsdw insertGatztbjsdw(Gatztbjsdw gatztbjsdw){
		// TODO: implement
		gatztbjsdw.setGajsdwid(getNextID("Gajsdwid"));
		return (Gatztbjsdw)insert("insertGatztbjsdw", gatztbjsdw);
	}

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 删除 */
	public int deleteGatztbjsdw(Gatztbjsdw gatztbjsdw){
		// TODO: implement
		return delete("deleteGatztbjsdw", gatztbjsdw);
	}

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 修改 */
	public int updateGatztbjsdw(Gatztbjsdw gatztbjsdw){
		// TODO: implement
		return update("updateGatztbjsdw", gatztbjsdw);
	}

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 查询单条 */
	public Gatztbjsdw getGatztbjsdw(Gatztbjsdw gatztbjsdw){
		// TODO: implement
		return (Gatztbjsdw)queryForObject("getGatztbjsdw", gatztbjsdw);
	}

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Gatbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getGatztbjsdwList", map, pageNo,pageSize);
	}

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 多条查询 */
	public List getListGatztbjsdw(Gatztbjsdw gatztbjsdw){
		// TODO: implement
		return queryForList("getGatztbjsdwListNoPage", gatztbjsdw);
	}
}
