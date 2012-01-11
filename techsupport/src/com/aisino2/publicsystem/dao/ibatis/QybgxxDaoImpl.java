package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQybgxxDao;
import com.aisino2.publicsystem.domain.Qybgxx;

public class QybgxxDaoImpl extends BaseDao implements IQybgxxDao {
	
	/** @param 企业变更信息(t_qybgxx) 增加 */
	public Qybgxx insertQybgxx(Qybgxx qybgxx){
		qybgxx.setQybgxxid(getNextID("Qybgxxid"));
		insert("insertQybgxx", qybgxx);
		return qybgxx;
	}

	/** @param 企业变更信息(t_qybgxx) 删除 */
	public int deleteQybgxx(Qybgxx qybgxx){
		// TODO: implement
		return delete("deleteQybgxx", qybgxx);
	}

	/** @param 企业变更信息(t_qybgxx) 修改 */
	public int updateQybgxx(Qybgxx qybgxx){
		// TODO: implement
		return update("updateQybgxx", qybgxx);
	}

	/** @param 企业变更信息(t_qybgxx) 查询单条 */
	public Qybgxx getQybgxx(Qybgxx qybgxx){
		// TODO: implement
		return (Qybgxx)queryForObject("getQybgxx", qybgxx);
	}

	/** @param 企业变更信息(t_qybgxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol=" a.qyid desc ";
		if (sort!=null){
			if(sort.equals("0"))
				sCol = " b.qybm " + desc + "," + sCol;
			if(sort.equals("1"))
				sCol = " b.qymc " + desc + "," + sCol;
			if(sort.equals("2"))
				sCol = " b.qyzflmc " + desc + "," + sCol;
			if(sort.equals("3"))
				sCol = " a.bgdjxh " + desc + "," + sCol;
			if(sort.equals("4"))
				sCol = " a.bglx " + desc + "," + sCol;
			if(sort.equals("5"))
				sCol = " a.bgyy " + desc + "," + sCol;
			if(sort.equals("6"))
				sCol = " a.bgrq " + desc + "," + sCol;
		}
		map.put("pageSort", sCol);
		return queryForPage("getQybgxxList", map, pageNo,pageSize);
	}

	/** @param 企业变更信息(t_qybgxx) 多条查询 */
	public List getListQybgxx(Qybgxx qybgxx){
		// TODO: implement
		return queryForList("getQybgxxListNoPage", qybgxx);
	}
}
