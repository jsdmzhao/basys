package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGatztbhfDao;
import com.aisino2.basicsystem.domain.Gatztbhf;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class GatztbhfDaoImpl extends BaseDao implements IGatztbhfDao {
	/** @param 公安通知通报回复(t_gatztbhf) 增加 */
	public Gatztbhf insertGatztbhf(Gatztbhf gatztbhf){
		// TODO: implement
		gatztbhf.setGatztbhfid(getNextID("Gatztbhfid"));
		return (Gatztbhf)insert("insertGatztbhf", gatztbhf);
	}

	/** @param 公安通知通报回复(t_gatztbhf) 删除 */
	public int deleteGatztbhf(Gatztbhf gatztbhf){
		// TODO: implement
		return delete("deleteGatztbhf", gatztbhf);
	}

	/** @param 公安通知通报回复(t_gatztbhf) 修改 */
	public int updateGatztbhf(Gatztbhf gatztbhf){
		// TODO: implement
		return update("updateGatztbhf", gatztbhf);
	}

	/** @param 公安通知通报回复(t_gatztbhf) 查询单条 */
	public Gatztbhf getGatztbhf(Gatztbhf gatztbhf){
		// TODO: implement
		return (Gatztbhf)queryForObject("getGatztbhf", gatztbhf);
	}

	/** @param 公安通知通报回复(t_gatztbhf) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Gatbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getGatztbhfList", map, pageNo,pageSize);
	}

	/** @param 公安通知通报回复(t_gatztbhf) 多条查询 */
	public List getListGatztbhf(Gatztbhf gatztbhf){
		// TODO: implement
		return queryForList("getGatztbhfListNoPage", gatztbhf);
	}
}
