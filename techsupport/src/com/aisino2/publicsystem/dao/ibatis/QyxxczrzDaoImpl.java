package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IQyxxczrzDao;
import com.aisino2.publicsystem.domain.Qyxxczrz;

public class QyxxczrzDaoImpl extends BaseDao implements IQyxxczrzDao {
	/** @param 企业信息操作日志(t_qyxxczrz) 增加 */
	public Qyxxczrz insertQyxxczrz(Qyxxczrz qyxxczrz){
		// TODO: implement
		qyxxczrz.setQyxxczrzid(getNextID("Qyxxczrzid"));
		insert("insertQyxxczrz", qyxxczrz);
		return qyxxczrz;
	}

	/** @param 企业信息操作日志(t_qyxxczrz) 删除 */
	public int deleteQyxxczrz(Qyxxczrz qyxxczrz){
		// TODO: implement
		return delete("deleteQyxxczrz", qyxxczrz);
	}

	/** @param 企业信息操作日志(t_qyxxczrz) 修改 */
	public int updateQyxxczrz(Qyxxczrz qyxxczrz){
		// TODO: implement
		return update("updateQyxxczrz", qyxxczrz);
	}

	/** @param 企业信息操作日志(t_qyxxczrz) 查询单条 */
	public Qyxxczrz getQyxxczrz(Qyxxczrz qyxxczrz){
		// TODO: implement
		return (Qyxxczrz)queryForObject("getQyxxczrz", qyxxczrz);
	}

	/** @param 企业信息操作日志(t_qyxxczrz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyxxczrzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQyxxczrzList", map, pageNo,pageSize);
	}

	/** @param 企业信息操作日志(t_qyxxczrz) 多条查询 */
	public List getListQyxxczrz(Qyxxczrz qyxxczrz){
		// TODO: implement
		return queryForList("getQyxxczrzListNoPage", qyxxczrz);
	}
}
