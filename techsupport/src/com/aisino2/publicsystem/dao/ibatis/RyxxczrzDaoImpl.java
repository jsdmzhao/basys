package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IRyxxczrzDao;
import com.aisino2.publicsystem.domain.Ryxxczrz;

public class RyxxczrzDaoImpl extends BaseDao implements IRyxxczrzDao {
	/** @param 人员信息操作日志(t_ryxxczrz) 增加 */
	public Ryxxczrz insertRyxxczrz(Ryxxczrz ryxxczrz){
		// TODO: implement
		ryxxczrz.setRyxxczrzid(getNextID("Ggryxxczrzid"));
		insert("insertRyxxczrz", ryxxczrz);
		return ryxxczrz;
	}

	/** @param 人员信息操作日志(t_ryxxczrz) 删除 */
	public int deleteRyxxczrz(Ryxxczrz ryxxczrz){
		// TODO: implement
		return delete("deleteRyxxczrz", ryxxczrz);
	}

	/** @param 人员信息操作日志(t_ryxxczrz) 修改 */
	public int updateRyxxczrz(Ryxxczrz ryxxczrz){
		// TODO: implement
		return update("updateRyxxczrz", ryxxczrz);
	}

	/** @param 人员信息操作日志(t_ryxxczrz) 查询单条 */
	public Ryxxczrz getRyxxczrz(Ryxxczrz ryxxczrz){
		// TODO: implement
		return (Ryxxczrz)queryForObject("getRyxxczrz", ryxxczrz);
	}

	/** @param 人员信息操作日志(t_ryxxczrz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Ryxxczrzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getRyxxczrzList", map, pageNo,pageSize);
	}

	/** @param 人员信息操作日志(t_ryxxczrz) 多条查询 */
	public List getListRyxxczrz(Ryxxczrz ryxxczrz){
		// TODO: implement
		return queryForList("getRyxxczrzListNoPage", ryxxczrz);
	}
}
