package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyry_tjxxDao;
import com.aisino2.publicsystem.domain.Qyry_tjxx;

public class Qyry_tjxxDaoImpl extends BaseDao implements IQyry_tjxxDao {
	/** @param 企业人员体检信息(t_qyry_tjxx) 增加 */
	public Qyry_tjxx insertQyry_tjxx(Qyry_tjxx qyry_tjxx){
		// TODO: implement
	
		qyry_tjxx.setTjxxid(getNextID("GgTjxxid"));
		
		insert("insertQyry_tjxx", qyry_tjxx);
		return qyry_tjxx;
	}

	/** @param 企业人员体检信息(t_qyry_tjxx) 删除 */
	public int deleteQyry_tjxx(Qyry_tjxx qyry_tjxx){
		// TODO: implement
		return delete("deleteQyry_tjxx", qyry_tjxx);
	}

	/** @param 企业人员体检信息(t_qyry_tjxx) 修改 */
	public int updateQyry_tjxx(Qyry_tjxx qyry_tjxx){
		// TODO: implement
		return update("updateQyry_tjxx", qyry_tjxx);
	}

	/** @param 企业人员体检信息(t_qyry_tjxx) 查询单条 */
	public Qyry_tjxx getQyry_tjxx(Qyry_tjxx qyry_tjxx){
		// TODO: implement
		return (Qyry_tjxx)queryForObject("getQyry_tjxx", qyry_tjxx);
	}

	/** @param 企业人员体检信息(t_qyry_tjxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		
		String sCol="";
		if(desc == null)
			desc = "";
		else if(!desc.equals("asc") && !desc.equals("desc"))
			desc = " asc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " a.tijianrq "+ desc;
			else if(sort.equals("1"))
				sCol = " a.tjzkjms "+ desc;
			else if(sort.equals("2"))
				sCol = " a.lrr "+ desc;
			else if(sort.equals("3"))
				sCol = " a.lrrq "+ desc;
			else
				sCol = " a.tijianrq desc ";
		}else{
			sCol=" a.tijianrq desc ";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyry_tjxxList", map, pageNo,pageSize);
		
		
		
		
		
	}

	/** @param 企业人员体检信息(t_qyry_tjxx) 多条查询 */
	public List getListQyry_tjxx(Qyry_tjxx qyry_tjxx){
		// TODO: implement
		return queryForList("getQyry_tjxxListNoPage", qyry_tjxx);
	}
}
