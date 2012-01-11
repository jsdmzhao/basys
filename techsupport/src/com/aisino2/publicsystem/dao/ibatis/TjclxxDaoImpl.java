package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.ITjclxxDao;
import com.aisino2.publicsystem.domain.Tjclxx;

public class TjclxxDaoImpl extends BaseDao implements ITjclxxDao {
	/** @param 提交材料信息(t_tjclxx) 增加 */
	public Tjclxx insertTjclxx(Tjclxx tjclxx){
		// TODO: implement
		tjclxx.setTjclxxid(getNextID("Tjclxxid"));
		return (Tjclxx)insert("insertTjclxx", tjclxx);
	}

	/** @param 提交材料信息(t_tjclxx) 删除 */
	public int deleteTjclxx(Tjclxx tjclxx){
		// TODO: implement
		return delete("deleteTjclxx", tjclxx);
	}

	/** @param 提交材料信息(t_tjclxx) 修改 */
	public int updateTjclxx(Tjclxx tjclxx){
		// TODO: implement
		return update("updateTjclxx", tjclxx);
	}

	/** @param 提交材料信息(t_tjclxx) 查询单条 */
	public Tjclxx getTjclxx(Tjclxx tjclxx){
		// TODO: implement
		return (Tjclxx)queryForObject("getTjclxx", tjclxx);
	}

	/** @param 提交材料信息(t_tjclxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Tjclxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getTjclxxList", map, pageNo,pageSize);
	}

	/** @param 提交材料信息(t_tjclxx) 多条查询 */
	public List getListTjclxx(Tjclxx tjclxx){
		// TODO: implement
		return queryForList("getTjclxxListNoPage", tjclxx);
	}
}
