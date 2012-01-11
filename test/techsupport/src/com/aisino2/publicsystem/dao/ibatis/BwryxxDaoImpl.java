package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IBwryxxDao;
import com.aisino2.publicsystem.domain.Bwryxx;

public class BwryxxDaoImpl extends BaseDao implements IBwryxxDao {
	/** @param 保卫人员信息(t_bwryxx) 增加 */
	public Bwryxx insertBwryxx(Bwryxx bwryxx){
		// TODO: implement
		bwryxx.setBwryid(getNextID("Bwryxxid"));
		return (Bwryxx)insert("insertBwryxx", bwryxx);
	}

	/** @param 保卫人员信息(t_bwryxx) 删除 */
	public int deleteBwryxx(Bwryxx bwryxx){
		// TODO: implement
		return delete("deleteBwryxx", bwryxx);
	}

	/** @param 保卫人员信息(t_bwryxx) 修改 */
	public int updateBwryxx(Bwryxx bwryxx){
		// TODO: implement
		return update("updateBwryxx", bwryxx);
	}

	/** @param 保卫人员信息(t_bwryxx) 查询单条 */
	public Bwryxx getBwryxx(Bwryxx bwryxx){
		// TODO: implement
		return (Bwryxx)queryForObject("getBwryxx", bwryxx);
	}

	/** @param 保卫人员信息(t_bwryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="a.lrsj desc";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.hylb " + desc + "," + sCol;
			else if(sort.equals("1"))
				sCol = " b.qymc " + desc + "," + sCol;
			else if(sort.equals("2"))
				sCol = " a.xm " + desc + "," + sCol;
			else if(sort.equals("3"))
				sCol = " a.gmsfhm " + desc + "," + sCol;
			else if(sort.equals("4"))
				sCol = " a.hjdxzqh " + desc + "," + sCol;
			else if(sort.equals("5"))
				sCol = " a.hjdxz " + desc + "," + sCol;
			else if(sort.equals("6"))
				sCol = " a.zt " + desc + "," + sCol;
		}
		map.put("pageSort", sCol);
		return queryForPage("getBwryxxList", map, pageNo,pageSize);
	}

	/** @param 保卫人员信息(t_bwryxx) 多条查询 */
	public List getListBwryxx(Bwryxx bwryxx){
		// TODO: implement
		return queryForList("getBwryxxListNoPage", bwryxx);
	}
	
	/** @param 保卫人员信息(t_bwryxx) 记录数查询 */
	public Integer getBwryxxCount(Bwryxx bwryxx){
		return (Integer)queryForObject("getBwryxxCount", bwryxx);
	}
}
