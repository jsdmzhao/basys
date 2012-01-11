package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.ISjbDao;
import com.aisino2.basicsystem.domain.Sjb;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class SjbDaoImpl extends BaseDao implements ISjbDao {
	/** @param 数据表(t_sjb) 增加 */
	public Sjb insertSjb(Sjb sjb){
		// TODO: implement
		sjb.setSjbid(getNextID("Sjbid"));
		return (Sjb)insert("insertSjb", sjb);
	}

	/** @param 数据表(t_sjb) 删除 */
	public int deleteSjb(Sjb sjb){
		// TODO: implement
		return delete("deleteSjb", sjb);
	}

	/** @param 数据表(t_sjb) 修改 */
	public int updateSjb(Sjb sjb){
		// TODO: implement
		return update("updateSjb", sjb);
	}

	/** @param 数据表(t_sjb) 查询单条 */
	public Sjb getSjb(Sjb sjb){
		// TODO: implement
		return (Sjb)queryForObject("getSjb", sjb);
	}

	/** @param 数据表(t_sjb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Sjbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getSjbList", map, pageNo,pageSize);
	}

	/** @param 数据表(t_sjb) 多条查询 */
	public List getListSjb(Sjb sjb){
		// TODO: implement
		return queryForList("getSjbListNoPage", sjb);
	}
}
