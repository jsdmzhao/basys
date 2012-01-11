package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IWbjkdyczrzDao;
import com.aisino2.basicsystem.domain.Wbjkdyczrz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class WbjkdyczrzDaoImpl extends BaseDao implements IWbjkdyczrzDao {
	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 增加 */
	public Wbjkdyczrz insertWbjkdyczrz(Wbjkdyczrz wbjkdyczrz){
		// TODO: implement
		wbjkdyczrz.setCzrzid(getNextID("Czrzid"));
		insert("insertWbjkdyczrz", wbjkdyczrz);
		 return wbjkdyczrz;
	}

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 删除 */
	public int deleteWbjkdyczrz(Wbjkdyczrz wbjkdyczrz){
		// TODO: implement
		return delete("deleteWbjkdyczrz", wbjkdyczrz);
	}

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 修改 */
	public int updateWbjkdyczrz(Wbjkdyczrz wbjkdyczrz){
		// TODO: implement
		return update("updateWbjkdyczrz", wbjkdyczrz);
	}

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 查询单条 */
	public Wbjkdyczrz getWbjkdyczrz(Wbjkdyczrz wbjkdyczrz){
		// TODO: implement
		return (Wbjkdyczrz)queryForObject("getWbjkdyczrz", wbjkdyczrz);
	}

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Czrzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWbjkdyczrzList", map, pageNo,pageSize);
	}

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 多条查询 */
	public List getListWbjkdyczrz(Wbjkdyczrz wbjkdyczrz){
		// TODO: implement
		return queryForList("getWbjkdyczrzListNoPage", wbjkdyczrz);
	}
}
