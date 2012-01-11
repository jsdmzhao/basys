package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBdqclxxDao;
import com.aisino2.basicsystem.domain.Bdqclxx;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BdqclxxDaoImpl extends BaseDao implements IBdqclxxDao {
	/** @param 被盗抢车辆信息(t_bdqclxx) 增加 */
	public Bdqclxx insertBdqclxx(Bdqclxx bdqclxx){
		// TODO: implement
		bdqclxx.setBdqclxxid(getNextID("Bdqclxxid"));
		return (Bdqclxx)insert("insertBdqclxx", bdqclxx);
	}

	/** @param 被盗抢车辆信息(t_bdqclxx) 删除 */
	public int deleteBdqclxx(Bdqclxx bdqclxx){
		// TODO: implement
		return delete("deleteBdqclxx", bdqclxx);
	}

	/** @param 被盗抢车辆信息(t_bdqclxx) 修改 */
	public int updateBdqclxx(Bdqclxx bdqclxx){
		// TODO: implement
		return update("updateBdqclxx", bdqclxx);
	}

	/** @param 被盗抢车辆信息(t_bdqclxx) 查询单条 */
	public Bdqclxx getBdqclxx(Bdqclxx bdqclxx){
		// TODO: implement
		return (Bdqclxx)queryForObject("getBdqclxx", bdqclxx);
	}

	/** @param 被盗抢车辆信息(t_bdqclxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals("")))
		{
			map.put("pageSort", map.get("superbOrderBy"));
			return queryForPage("getBdqclxxList", map, pageNo, pageSize);
		}
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.syr "+ desc;
			else if(sort.equals("1"))
				sCol = " a.hphm "+ desc;
			else if(sort.equals("2"))
				sCol = " a.clpp "+ desc;
			else if(sort.equals("3"))
				sCol = " a.clxh "+ desc;
			else if(sort.equals("4"))
				sCol = " a.fdjh "+ desc;
			else if(sort.equals("5"))
				sCol = " a.cjh "+ desc;
			else if(sort.equals("6"))
				sCol = " a.ccdjrq "+ desc;
			else if(sort.equals("7"))
				sCol = " a.ajbh "+ desc;
			else
				sCol = " a.Bdqclxxid desc ";
		}else{
			sCol="a.Bdqclxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBdqclxxList", map, pageNo,pageSize);
	}

	/** @param 被盗抢车辆信息(t_bdqclxx) 多条查询 */
	public List getListBdqclxx(Bdqclxx bdqclxx){
		// TODO: implement
		return queryForList("getBdqclxxListNoPage", bdqclxx);
	}
}
