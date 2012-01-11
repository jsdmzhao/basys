package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyfflDao;
import com.aisino2.publicsystem.domain.Qyffl;

public class QyfflDaoImpl extends BaseDao implements IQyfflDao {
	/** @param 企业副分类(t_qyffl) 增加 */
	public Qyffl insertQyffl(Qyffl qyffl){
		// TODO: implement
		qyffl.setQyflid(getNextID("Qyflid"));
		insert("insertQyffl", qyffl);
		return qyffl;
	}

	/** @param 企业副分类(t_qyffl) 删除 */
	public int deleteQyffl(Qyffl qyffl){
		// TODO: implement
		return delete("deleteQyffl", qyffl);
	}

	/** @param 企业副分类(t_qyffl) 修改 */
	public int updateQyffl(Qyffl qyffl){
		// TODO: implement
		return update("updateQyffl", qyffl);
	}

	/** @param 企业副分类(t_qyffl) 查询单条 */
	public Qyffl getQyffl(Qyffl qyffl){
		// TODO: implement
		return (Qyffl)queryForObject("getQyffl", qyffl);
	}

	/** @param 企业副分类(t_qyffl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyflid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyfflList", map, pageNo,pageSize);
	}

	/** @param 企业副分类(t_qyffl) 多条查询 */
	public List getListQyffl(Qyffl qyffl){
		// TODO: implement
		return queryForList("getQyfflListNoPage", qyffl);
	}
}
