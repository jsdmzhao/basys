package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IWbjkczrzmxDao;
import com.aisino2.basicsystem.domain.Wbjkczrzmx;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class WbjkczrzmxDaoImpl extends BaseDao implements IWbjkczrzmxDao {
	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 增加 */
	public Wbjkczrzmx insertWbjkczrzmx(Wbjkczrzmx wbjkczrzmx){
		// TODO: implement
		wbjkczrzmx.setMxid(getNextID("Mxid"));
		insert("insertWbjkczrzmx", wbjkczrzmx);
		 return wbjkczrzmx;
	}

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 删除 */
	public int deleteWbjkczrzmx(Wbjkczrzmx wbjkczrzmx){
		// TODO: implement
		return delete("deleteWbjkczrzmx", wbjkczrzmx);
	}

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 修改 */
	public int updateWbjkczrzmx(Wbjkczrzmx wbjkczrzmx){
		// TODO: implement
		return update("updateWbjkczrzmx", wbjkczrzmx);
	}

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 查询单条 */
	public Wbjkczrzmx getWbjkczrzmx(Wbjkczrzmx wbjkczrzmx){
		// TODO: implement
		return (Wbjkczrzmx)queryForObject("getWbjkczrzmx", wbjkczrzmx);
	}

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Czrzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWbjkczrzmxList", map, pageNo,pageSize);
	}

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 多条查询 */
	public List getListWbjkczrzmx(Wbjkczrzmx wbjkczrzmx){
		// TODO: implement
		return queryForList("getWbjkczrzmxListNoPage", wbjkczrzmx);
	}
}
