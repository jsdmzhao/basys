package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyzjbDao;
import com.aisino2.publicsystem.domain.Qyzjb;

public class QyzjbDaoImpl extends BaseDao implements IQyzjbDao {
	/** @param 企业证件表(t_qyzjb) 增加 */
	public Qyzjb insertQyzjb(Qyzjb qyzjb){
		// TODO: implement
		qyzjb.setZjid(getNextID("Zjid"));
		insert("insertQyzjb", qyzjb);
		return qyzjb;
	}

	/** @param 企业证件表(t_qyzjb) 删除 */
	public int deleteQyzjb(Qyzjb qyzjb){
		// TODO: implement
		return delete("deleteQyzjb", qyzjb);
	}

	/** @param 企业证件表(t_qyzjb) 修改 */
	public int updateQyzjb(Qyzjb qyzjb){
		// TODO: implement
		return update("updateQyzjb", qyzjb);
	}

	/** @param 企业证件表(t_qyzjb) 查询单条 */
	public Qyzjb getQyzjb(Qyzjb qyzjb){
		// TODO: implement
		return (Qyzjb)queryForObject("getQyzjb", qyzjb);
	}

	/** @param 企业证件表(t_qyzjb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Zjid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyzjbList", map, pageNo,pageSize);
	}

	/** @param 企业证件表(t_qyzjb) 多条查询 */
	public List getListQyzjb(Qyzjb qyzjb){
		// TODO: implement
		return queryForList("getQyzjbListNoPage", qyzjb);
	}
}
