package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyjbxx_lsDao;
import com.aisino2.publicsystem.domain.Qyjbxx_ls;

public class Qyjbxx_lsDaoImpl extends BaseDao implements IQyjbxx_lsDao {
	/** @param 企业基本信息—历史(t_qyjbxx_ls) 增加 */
	public Qyjbxx_ls insertQyjbxx_ls(Qyjbxx_ls qyjbxx_ls){
		// TODO: implement
		qyjbxx_ls.setQylsid(getNextID("Qylsid"));
		insert("insertQyjbxx_ls", qyjbxx_ls);
		return qyjbxx_ls;
	}

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 删除 */
	public int deleteQyjbxx_ls(Qyjbxx_ls qyjbxx_ls){
		// TODO: implement
		return delete("deleteQyjbxx_ls", qyjbxx_ls);
	}

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 修改 */
	public int updateQyjbxx_ls(Qyjbxx_ls qyjbxx_ls){
		// TODO: implement
		return update("updateQyjbxx_ls", qyjbxx_ls);
	}

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 查询单条 */
	public Qyjbxx_ls getQyjbxx_ls(Qyjbxx_ls qyjbxx_ls){
		// TODO: implement
		return (Qyjbxx_ls)queryForObject("getQyjbxx_ls", qyjbxx_ls);
	}

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyjbxx_lsList", map, pageNo,pageSize);
	}

	/** @param 企业基本信息—历史(t_qyjbxx_ls) 多条查询 */
	public List getListQyjbxx_ls(Qyjbxx_ls qyjbxx_ls){
		// TODO: implement
		return queryForList("getQyjbxx_lsListNoPage", qyjbxx_ls);
	}
	
	/** @param 企业基本信息—历史(t_qyjbxx_ls) 查询指定企业的操作类型为变更的最新一条历史记录 */
	public Qyjbxx_ls getLatestBgQyjbxx_ls(Qyjbxx_ls qyjbxx_ls)
	{
		return (Qyjbxx_ls)queryForObject("getLatestBgQyjbxx_ls", qyjbxx_ls);
	}
	
	/** @param 企业基本信息—历史(t_Qyjbxx_ls) 查询指定企业且操作类型为变更的某条历史记录的下一条记录(即qylsid较大的一条) */
	public Qyjbxx_ls getNextBgQyjbxx_ls(Qyjbxx_ls qyjbxx_ls)
	{
		return (Qyjbxx_ls)queryForObject("getNextBgQyjbxx_ls", qyjbxx_ls);
	}
}
