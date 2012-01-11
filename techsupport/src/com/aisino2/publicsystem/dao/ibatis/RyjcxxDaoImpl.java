package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IRyjcxxDao;
import com.aisino2.publicsystem.domain.Ryjcxx;

public class RyjcxxDaoImpl extends BaseDao implements IRyjcxxDao {
	/** @param 人员奖惩信息(t_ryjcxx) 增加 */
	public Ryjcxx insertRyjcxx(Ryjcxx ryjcxx){
		// TODO: implement
		//ryjcxx.setQyid(getNextID("Qyid"));
		ryjcxx.setRycfid(getNextID("Ggrycfid"));
		
		insert("insertRyjcxx", ryjcxx);
		return ryjcxx;
	}

	/** @param 人员奖惩信息(t_ryjcxx) 删除 */
	public int deleteRyjcxx(Ryjcxx ryjcxx){
		// TODO: implement
		return delete("deleteRyjcxx", ryjcxx);
	}

	/** @param 人员奖惩信息(t_ryjcxx) 修改 */
	public int updateRyjcxx(Ryjcxx ryjcxx){
		// TODO: implement
		return update("updateRyjcxx", ryjcxx);
	}

	/** @param 人员奖惩信息(t_ryjcxx) 查询单条 */
	public Ryjcxx getRyjcxx(Ryjcxx ryjcxx){
		// TODO: implement
		return (Ryjcxx)queryForObject("getRyjcxx", ryjcxx);
	}

	/** @param 人员奖惩信息(t_ryjcxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement

		
		String sCol = "a.Rycfid ";

		if (sort != null) {
			if (sort.equals("0"))
				sCol = "b.qybm ";
			else if (sort.equals("1"))
				sCol = "b.qymc ";
			else if (sort.equals("2"))
				sCol = "c.xm ";
			else if (sort.equals("3"))
				sCol = "a.cflbbm ";
			else if (sort.equals("4"))
				sCol = "a.jcmxlbdm ";
			else if (sort.equals("5"))
				sCol = "a.pzjg ";
			else if (sort.equals("6"))
				sCol = "a.pzrxm ";
			else if (sort.equals("7"))
				sCol = "a.zxrxm ";
			else if (sort.equals("8"))
				sCol = "a.ryjcrq ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";
		map.put("pageSort", sCol);
		return queryForPage("getRyjcxxList", map, pageNo,pageSize);
		
		
		
		
		
		
		
		
		
	}

	/** @param 人员奖惩信息(t_ryjcxx) 多条查询 */
	public List getListRyjcxx(Ryjcxx ryjcxx){
		// TODO: implement
		return queryForList("getRyjcxxListNoPage", ryjcxx);
	}

	public Page getRyListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		String sCol = "a.Ryid ";

		if (sort != null) {
			if (sort.equals("0"))
				sCol = "a.xm ";
			else if (sort.equals("1"))
				sCol = "a.cyrybh ";
			else if (sort.equals("2"))
				sCol = "a.zjhm ";
			else if (sort.equals("3"))
				sCol = "a.xb ";
			else if (sort.equals("4"))
				sCol = "a.gwmc ";
			else if (sort.equals("5"))
				sCol = "b.qymc ";
			else if (sort.equals("6"))
				sCol = "b.gxdwmc ";
		}

		if (desc != null)
			sCol += desc;
		else
			sCol += " desc";
		map.put("pageSort", sCol);
		return queryForPage("getRycfxxListForRy", map, pageNo,pageSize);
	}
}
