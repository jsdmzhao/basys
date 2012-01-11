package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IBaryxxDao;
import com.aisino2.publicsystem.domain.Baryxx;

public class BaryxxDaoImpl extends BaseDao implements IBaryxxDao {
	/** @param 保安人员信息(t_baryxx) 增加 */
	public Baryxx insertBaryxx(Baryxx baryxx){
		// TODO: implement
		baryxx.setBaryid(getNextID("Baryid"));
		return (Baryxx)insert("insertBaryxx", baryxx);
	}

	/** @param 保安人员信息(t_baryxx) 删除 */
	public int deleteBaryxx(Baryxx baryxx){
		// TODO: implement
		return delete("deleteBaryxx", baryxx);
	}

	/** @param 保安人员信息(t_baryxx) 修改 */
	public int updateBaryxx(Baryxx baryxx){
		// TODO: implement
		return update("updateBaryxx", baryxx);
	}

	/** @param 保安人员信息(t_baryxx) 查询单条 */
	public Baryxx getBaryxx(Baryxx baryxx){
		// TODO: implement
		return (Baryxx)queryForObject("getBaryxx", baryxx);
	}

	/** @param 保安人员信息(t_baryxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="a.lrsj desc";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.hylbdm " + desc + "," + sCol;
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
		return queryForPage("getBaryxxList", map, pageNo,pageSize);
	}

	/** @param 保安人员信息(t_baryxx) 多条查询 */
	public List getListBaryxx(Baryxx baryxx){
		// TODO: implement
		return queryForList("getBaryxxListNoPage", baryxx);
	}
	
	/** @param 保安人员信息(t_baryxx) 记录数查询 */
	public Integer getBaryxxCount(Baryxx baryxx){
		return (Integer)queryForObject("getBaryxxCount", baryxx);
	}
}
