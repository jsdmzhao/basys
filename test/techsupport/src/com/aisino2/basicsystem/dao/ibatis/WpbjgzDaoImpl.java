package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IWpbjgzDao;
import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class WpbjgzDaoImpl extends BaseDao implements IWpbjgzDao {
	/** @param 物品报警规则(t_wpbjgz) 增加 */
	public Wpbjgz insertWpbjgz(Wpbjgz wpbjgz){
		// TODO: implement
		wpbjgz.setBjxxid2(getNextID("Bjxxid2"));
		return (Wpbjgz)insert("insertWpbjgz", wpbjgz);
	}

	/** @param 物品报警规则(t_wpbjgz) 删除 */
	public int deleteWpbjgz(Wpbjgz wpbjgz){
		// TODO: implement
		return delete("deleteWpbjgz", wpbjgz);
	}

	/** @param 物品报警规则(t_wpbjgz) 修改 */
	public int updateWpbjgz(Wpbjgz wpbjgz){
		// TODO: implement
		return update("updateWpbjgz", wpbjgz);
	}

	/** @param 物品报警规则(t_wpbjgz) 查询单条 */
	public Wpbjgz getWpbjgz(Wpbjgz wpbjgz){
		// TODO: implement
		return (Wpbjgz)queryForObject("getWpbjgz", wpbjgz);
	}

	/** @param 物品报警规则(t_wpbjgz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjxxid2 desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWpbjgzList", map, pageNo,pageSize);
	}

	/** @param 物品报警规则(t_wpbjgz) 多条查询 */
	public List getListWpbjgz(Wpbjgz wpbjgz){
		// TODO: implement
		return queryForList("getWpbjgzListNoPage", wpbjgz);
	}
}
