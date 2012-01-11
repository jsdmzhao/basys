package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyzlxxDao;
import com.aisino2.publicsystem.domain.Qyzlxx;
import com.aisino2.publicsystem.domain.Qyzlxxfj;

public class QyzlxxDaoImpl extends BaseDao implements IQyzlxxDao {
	/** @param 企业质量信息(t_qyzlxx) 增加 */
	public Qyzlxx insertQyzlxx(Qyzlxx qyzlxx){
		// TODO: implement
		qyzlxx.setQyzlxxid(getNextID("Qyzlxxid"));
		insert("insertQyzlxx", qyzlxx);
		return qyzlxx;
	}

	/** @param 企业质量信息(t_qyzlxx) 删除 */
	public int deleteQyzlxx(Qyzlxx qyzlxx){
		// TODO: implement
		return delete("deleteQyzlxx", qyzlxx);
	}

	/** @param 企业质量信息(t_qyzlxx) 修改 */
	public int updateQyzlxx(Qyzlxx qyzlxx){
		// TODO: implement
		return update("updateQyzlxx", qyzlxx);
	}

	/** @param 企业质量信息(t_qyzlxx) 查询单条 */
	public Qyzlxx getQyzlxx(Qyzlxx qyzlxx){
		// TODO: implement
		return (Qyzlxx)queryForObject("getQyzlxx", qyzlxx);
	}

	/** @param 企业质量信息(t_qyzlxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
			if(sort.equals("0"))
				sCol="a.fbdwmc "+desc;
			else if(sort.equals("1"))
			sCol="a.fbsj "+desc;
			else if(sort.equals("2"))
				sCol="t.fjmc "+desc;
			else
				sCol="a.qyzlxxid "+desc;
		}else{
			sCol="a.Qyzlxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyzlxxList", map, pageNo,pageSize);
	}

	/** @param 企业质量信息(t_qyzlxx) 多条查询 */
	public List getListQyzlxx(Qyzlxx qyzlxx){
		// TODO: implement
		return queryForList("getQyzlxxListNoPage", qyzlxx);
	}

	public Qyzlxxfj downloadFJ(Qyzlxxfj fjobj) {
		// TODO Auto-generated method stub
		return (Qyzlxxfj)queryForObject("getQyzlxxfj", fjobj);
	}
}
