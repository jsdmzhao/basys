package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyry_zpDao;
import com.aisino2.publicsystem.domain.Qyry_zp;

public class Qyry_zpDaoImpl extends BaseDao implements IQyry_zpDao {
	/** @param 企业人员_照片(t_qyry_zp) 增加 */
	public Qyry_zp insertQyry_zp(Qyry_zp qyry_zp){
		// TODO: implement
		qyry_zp.setZpid(getNextID("Ggzpid"));
		insert("insertQyry_zp", qyry_zp);
		 return qyry_zp;
	}

	/** @param 企业人员_照片(t_qyry_zp) 删除 */
	public int deleteQyry_zp(Qyry_zp qyry_zp){
		// TODO: implement
		return delete("deleteQyry_zp", qyry_zp);
	}

	/** @param 企业人员_照片(t_qyry_zp) 修改 */
	public int updateQyry_zp(Qyry_zp qyry_zp){
		// TODO: implement
		return update("updateQyry_zp", qyry_zp);
	}

	/** @param 企业人员_照片(t_qyry_zp) 查询单条 */
	public Qyry_zp getQyry_zp(Qyry_zp qyry_zp){
		// TODO: implement
		return (Qyry_zp)queryForObject("getQyry_zp", qyry_zp);
	}

	/** @param 企业人员_照片(t_qyry_zp) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyry_zpList", map, pageNo,pageSize);
	}

	/** @param 企业人员_照片(t_qyry_zp) 多条查询 */
	public List getListQyry_zp(Qyry_zp qyry_zp){
		// TODO: implement
		return queryForList("getQyry_zpListNoPage", qyry_zp);
	}
}
