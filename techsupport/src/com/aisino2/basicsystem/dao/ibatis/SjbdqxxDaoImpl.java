package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.ISjbdqxxDao;
import com.aisino2.basicsystem.domain.Sjbdqxx;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class SjbdqxxDaoImpl extends BaseDao implements ISjbdqxxDao {
	/** @param 手机被盗抢信息(t_sjbdqxx) 增加 */
	public Sjbdqxx insertSjbdqxx(Sjbdqxx sjbdqxx){
		// TODO: implement
		sjbdqxx.setSjbdqxxid(getNextID("Sjbdqxxid"));
		return (Sjbdqxx)insert("insertSjbdqxx", sjbdqxx);
	}

	/** @param 手机被盗抢信息(t_sjbdqxx) 删除 */
	public int deleteSjbdqxx(Sjbdqxx sjbdqxx){
		// TODO: implement
		return delete("deleteSjbdqxx", sjbdqxx);
	}

	/** @param 手机被盗抢信息(t_sjbdqxx) 修改 */
	public int updateSjbdqxx(Sjbdqxx sjbdqxx){
		// TODO: implement
		return update("updateSjbdqxx", sjbdqxx);
	}

	/** @param 手机被盗抢信息(t_sjbdqxx) 查询单条 */
	public Sjbdqxx getSjbdqxx(Sjbdqxx sjbdqxx){
		// TODO: implement
		return (Sjbdqxx)queryForObject("getSjbdqxx", sjbdqxx);
	}

	/** @param 手机被盗抢信息(t_sjbdqxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol = " a.sjbdqxxid desc ";
		if(map.get("superbOrderBy") != null && !(map.get("superbOrderBy").equals(""))){
			map.put("pageSort", map.get("superbOrderBy"));
		} else {
			if (sort!=null){
				if(sort.equals("0"))
					sCol = " a.sjch " + desc + "," + sCol;
				else if(sort.equals("1"))
					sCol = " a.pp " + desc + "," + sCol;
				else if(sort.equals("2"))
					sCol = " a.xh " + desc + "," + sCol;
				else if(sort.equals("3"))
					sCol = " a.ys " + desc + "," + sCol;
				else if(sort.equals("4"))
					sCol = " a.djrq " + desc + "," + sCol;
				else if(sort.equals("5"))
					sCol = " a.lxr " + desc + "," + sCol;
				else if(sort.equals("6"))
					sCol = " a.ajjb " + desc + "," + sCol;
			}
		}
		map.put("pageSort", sCol);
		return queryForPage("getSjbdqxxList", map, pageNo,pageSize);
	}

	/** @param 手机被盗抢信息(t_sjbdqxx) 多条查询 */
	public List getListSjbdqxx(Sjbdqxx sjbdqxx){
		// TODO: implement
		return queryForList("getSjbdqxxListNoPage", sjbdqxx);
	}
	
	/** 判断手机被盗抢信息 是否已存在 */
	public Sjbdqxx isSjbdqxxExist(Sjbdqxx sjbdqxx){
		return (Sjbdqxx)queryForObject("isSjbdqxxExist", sjbdqxx);
	}
}
