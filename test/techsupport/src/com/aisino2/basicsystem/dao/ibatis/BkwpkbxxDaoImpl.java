package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkwpkbxxDao;
import com.aisino2.basicsystem.domain.Bkwpkbxx;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BkwpkbxxDaoImpl extends BaseDao implements IBkwpkbxxDao {
	/** @param 布控物品基本信息(t_bkwpkbxx) 增加 */
	public Bkwpkbxx insertBkwpkbxx(Bkwpkbxx bkwpkbxx){
		// TODO: implement
		bkwpkbxx.setBkwpjbxxid(getNextID("Bkwpjbxxid"));
		insert("insertBkwpkbxx", bkwpkbxx);
		return bkwpkbxx;
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 删除 */
	public int deleteBkwpkbxx(Bkwpkbxx bkwpkbxx){
		// TODO: implement
		return delete("deleteBkwpkbxx", bkwpkbxx);
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 修改 */
	public int updateBkwpkbxx(Bkwpkbxx bkwpkbxx){
		// TODO: implement
		return update("updateBkwpkbxx", bkwpkbxx);
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 查询单条 */
	public Bkwpkbxx getBkwpkbxx(Bkwpkbxx bkwpkbxx){
		// TODO: implement
		return (Bkwpkbxx)queryForObject("getBkwpkbxx", bkwpkbxx);
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if (sort.equals("0"))
				sCol = "a.bkwpmc ";
			else if (sort.equals("1"))
				sCol = "a.bkwplxdm ";
			else if(sort.equals("2"))
				sCol = "a.fwdwbm ";
			else if(sort.equals("3"))
				sCol = "a.bkfwbm ";
			else if(sort.equals("4"))
				sCol = "a.bkczsj ";
			else if(sort.equals("5"))
				sCol = "a.bkdqsj ";
			else
				sCol="a.Bkwpjbxxid ";
				
		}else{
			sCol="a.Bkwpjbxxid ";
		}
		
		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";
		
		map.put("pageSort", sCol);
		return queryForPage("getBkwpkbxxList", map, pageNo,pageSize);
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 多条查询 */
	public List getListBkwpkbxx(Bkwpkbxx bkwpkbxx){
		// TODO: implement
		return queryForList("getBkwpkbxxListNoPage", bkwpkbxx);
	}
}
