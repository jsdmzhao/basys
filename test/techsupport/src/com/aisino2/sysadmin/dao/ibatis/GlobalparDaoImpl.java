package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IGlobalparDao;
import com.aisino2.sysadmin.domain.Globalpar;

public class GlobalparDaoImpl extends BaseDao implements IGlobalparDao {
	/** @param 全局参数(t_globalpar) 增加 */
	public Globalpar insertGlobalpar(Globalpar globalpar){
		// TODO: implement
		return insertCacheGlobalpar(globalpar);
	}
	
	/** @param 全局参数(t_globalpar) 增加 */
	public Globalpar insertCacheGlobalpar(Globalpar globalpar){
		// TODO: implement
		insert("insertGlobalpar", globalpar);
		return globalpar;
	}

	/** @param 全局参数(t_globalpar) 删除 */
	public int deleteGlobalpar(Globalpar globalpar){
		// TODO: implement
		return deleteCacheGlobalpar(globalpar);
	}
	
	/** @param 全局参数(t_globalpar) 删除 */
	public int deleteCacheGlobalpar(Globalpar globalpar){
		// TODO: implement
		return delete("deleteGlobalpar", globalpar);
	}

	/** @param 全局参数(t_globalpar) 修改 */
	public int updateGlobalpar(Globalpar globalpar){
		// TODO: implement
		return updateCacheGlobalpar(globalpar);
	}
	
	/** @param 全局参数(t_globalpar) 修改 */
	public int updateCacheGlobalpar(Globalpar globalpar){
		// TODO: implement
		return update("updateGlobalpar", globalpar);
	}

	/** @param 全局参数(t_globalpar) 查询单条 */
	public Globalpar getGlobalpar(Globalpar globalpar){
		// TODO: implement
		return (Globalpar)queryForObject("getGlobalpar", globalpar);
	}

	/** @param 全局参数(t_globalpar) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if("0".equals(sort))
				sCol = " a.globalparcode "+ desc;
			else if("1".equals(sort))
				sCol = " a.globalparname "+ desc;
			else if("2".equals(sort))
				sCol = " a.globalparvalue "+ desc;
			else 
				sCol=" a.globalparcode ";
		}else{
			sCol="a.globalparcode desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getGlobalparList", map, pageNo,pageSize);
	}

	/** @param 全局参数(t_globalpar) 多条查询 */
	public List getListGlobalpar(Globalpar globalpar){
		// TODO: implement
		return queryForList("getGlobalparListNoPage", globalpar);
	}
}
