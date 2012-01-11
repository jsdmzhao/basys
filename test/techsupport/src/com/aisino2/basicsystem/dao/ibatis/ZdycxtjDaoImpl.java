package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IZdycxtjDao;
import com.aisino2.basicsystem.domain.Zdycxtj;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class ZdycxtjDaoImpl extends BaseDao implements IZdycxtjDao {
	/** @param 自定义查询条件(t_zdycxtj) 增加 */
	public Zdycxtj insertZdycxtj(Zdycxtj zdycxtj){
		// TODO: implement
		zdycxtj.setZdycxtjid(getNextID("Zdycxtjid"));
		return (Zdycxtj)insert("insertZdycxtj", zdycxtj);
	}

	/** @param 自定义查询条件(t_zdycxtj) 删除 */
	public int deleteZdycxtj(Zdycxtj zdycxtj){
		// TODO: implement
		return delete("deleteZdycxtj", zdycxtj);
	}

	/** @param 自定义查询条件(t_zdycxtj) 修改 */
	public int updateZdycxtj(Zdycxtj zdycxtj){
		// TODO: implement
		return update("updateZdycxtj", zdycxtj);
	}

	/** @param 自定义查询条件(t_zdycxtj) 查询单条 */
	public Zdycxtj getZdycxtj(Zdycxtj zdycxtj){
		// TODO: implement
		return (Zdycxtj)queryForObject("getZdycxtj", zdycxtj);
	}

	/** @param 自定义查询条件(t_zdycxtj) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Zdycxtjid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getZdycxtjList", map, pageNo,pageSize);
	}

	/** @param 自定义查询条件(t_zdycxtj) 多条查询 */
	public List getListZdycxtj(Zdycxtj zdycxtj){
		// TODO: implement
		return queryForList("getZdycxtjListNoPage", zdycxtj);
	}
}
