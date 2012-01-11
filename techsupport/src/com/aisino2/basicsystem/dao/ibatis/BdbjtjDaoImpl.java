package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBdbjtjDao;
import com.aisino2.basicsystem.domain.Bdbjtj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;


public class BdbjtjDaoImpl extends BaseDao implements IBdbjtjDao {
	/** @param 比对报警统计表(t_bdbjtj) 增加 */
	public Bdbjtj insertBdbjtj(Bdbjtj bdbjtj){
		// TODO: implement
		bdbjtj.setBdbjtjid(getNextID("Bdbjtjid"));
		return (Bdbjtj)insert("insertBdbjtj", bdbjtj);
	}

	/** @param 比对报警统计表(t_bdbjtj) 删除 */
	public int deleteBdbjtj(Bdbjtj bdbjtj){
		// TODO: implement
		return delete("deleteBdbjtj", bdbjtj);
	}

	/** @param 比对报警统计表(t_bdbjtj) 修改 */
	public int updateBdbjtj(Bdbjtj bdbjtj){
		// TODO: implement
		return update("updateBdbjtj", bdbjtj);
	}

	/** @param 比对报警统计表(t_bdbjtj) 查询单条 */
	public Bdbjtj getBdbjtj(Bdbjtj bdbjtj){
		// TODO: implement
		return (Bdbjtj)queryForObject("getBdbjtj", bdbjtj);
	}

	/** @param 比对报警统计表(t_bdbjtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol = " ";
		
		boolean csbz =false;
		if(map.get("csbz")!=null){
			csbz = ((String)map.get("csbz")).equalsIgnoreCase("1");
		}
		if(csbz){
			if(sort==null||sort.equals("")) sort="5"; 
		}else{
		    if(sort==null||sort.equals("")) sort="0"; 
		}
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " z.clbjcs " + desc ;
			else if(sort.equals("1"))
				sCol = " z.cyrybjcs " + desc ;
			else if(sort.equals("2"))
				sCol = " z.scrybjcs " + desc ;
			else if(sort.equals("3"))
				sCol = " z.kyclbjcs " + desc ;
			else if(sort.equals("4"))
				sCol = " z.xiaoji " + desc ;
			else if(sort.equals("5"))
				sCol = " z.csbm " + desc ;
	}
	map.put("pageSort", sCol);
		return queryForPage("getBdbjtjList", map, pageNo,pageSize);
	}

	/** @param 比对报警统计表(t_bdbjtj) 多条查询 */
	public List getListBdbjtj(Bdbjtj bdbjtj){
		// TODO: implement
		return queryForList("getBdbjtjListNoPage", bdbjtj);
	}
}
