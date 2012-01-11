package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.ISjbjgDao;
import com.aisino2.basicsystem.domain.Sjbjg;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class SjbjgDaoImpl extends BaseDao implements ISjbjgDao {
	/** @param 数据表结构(t_sjbjg) 增加 */
	public Sjbjg insertSjbjg(Sjbjg sjbjg){
		// TODO: implement
		sjbjg.setSjbjgid(getNextID("Sjbjgid"));
		return (Sjbjg)insert("insertSjbjg", sjbjg);
	}

	/** @param 数据表结构(t_sjbjg) 删除 */
	public int deleteSjbjg(Sjbjg sjbjg){
		// TODO: implement
		return delete("deleteSjbjg", sjbjg);
	}

	/** @param 数据表结构(t_sjbjg) 修改 */
	public int updateSjbjg(Sjbjg sjbjg){
		// TODO: implement
		return update("updateSjbjg", sjbjg);
	}

	/** @param 数据表结构(t_sjbjg) 查询单条 */
	public Sjbjg getSjbjg(Sjbjg sjbjg){
		// TODO: implement
		return (Sjbjg)queryForObject("getSjbjg", sjbjg);
	}

	/** @param 数据表结构(t_sjbjg) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Sjbjgid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getSjbjgList", map, pageNo,pageSize);
	}

	/** @param 数据表结构(t_sjbjg) 多条查询 */
	public List getListSjbjg(Sjbjg sjbjg){
		// TODO: implement
		return queryForList("getSjbjgListNoPage", sjbjg);
	}
}
