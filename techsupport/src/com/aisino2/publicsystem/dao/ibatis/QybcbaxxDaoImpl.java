package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQybcbaxxDao;
import com.aisino2.publicsystem.domain.Qybcbaxx;

public class QybcbaxxDaoImpl extends BaseDao implements IQybcbaxxDao {
	/** @param 企业补充备案信息(t_qybcbaxx) 增加 */
	public Qybcbaxx insertQybcbaxx(Qybcbaxx qybcbaxx){
		// TODO: implement
		//qybcbaxx.getq.setQyid(getNextID("Qyid"));
		return (Qybcbaxx)insert("insertQybcbaxx", qybcbaxx);
	}

	/** @param 企业补充备案信息(t_qybcbaxx) 删除 */
	public int deleteQybcbaxx(Qybcbaxx qybcbaxx){
		// TODO: implement
		return delete("deleteQybcbaxx", qybcbaxx);
	}

	/** @param 企业补充备案信息(t_qybcbaxx) 修改 */
	public int updateQybcbaxx(Qybcbaxx qybcbaxx){
		// TODO: implement
		return update("updateQybcbaxx", qybcbaxx);
	}

	/** @param 企业补充备案信息(t_qybcbaxx) 查询单条 */
	public Qybcbaxx getQybcbaxx(Qybcbaxx qybcbaxx){
		// TODO: implement
		return (Qybcbaxx)queryForObject("getQybcbaxx", qybcbaxx);
	}

	/** @param 企业补充备案信息(t_qybcbaxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQybcbaxxList", map, pageNo,pageSize);
	}

	/** @param 企业补充备案信息(t_qybcbaxx) 多条查询 */
	public List getListQybcbaxx(Qybcbaxx qybcbaxx){
		// TODO: implement
		return queryForList("getQybcbaxxListNoPage", qybcbaxx);
	}
}
