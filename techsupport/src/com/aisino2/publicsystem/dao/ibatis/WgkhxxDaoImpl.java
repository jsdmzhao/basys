package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IWgkhxxDao;
import com.aisino2.publicsystem.domain.Wgkhxx;

public class WgkhxxDaoImpl extends BaseDao implements IWgkhxxDao {
	/** @param 外国客户信息(t_wgkhxx) 增加 */
	public Wgkhxx insertWgkhxx(Wgkhxx wgkhxx){
		// TODO: implement
		//wgkhxx.setKhxxid(getNextID("Khxxid"));
		insert("insertWgkhxx", wgkhxx);
		return wgkhxx;
	}

	/** @param 外国客户信息(t_wgkhxx) 删除 */
	public int deleteWgkhxx(Wgkhxx wgkhxx){
		// TODO: implement
		return delete("deleteWgkhxx", wgkhxx);
	}

	/** @param 外国客户信息(t_wgkhxx) 修改 */
	public int updateWgkhxx(Wgkhxx wgkhxx){
		// TODO: implement
		return update("updateWgkhxx", wgkhxx);
	}

	/** @param 外国客户信息(t_wgkhxx) 查询单条 */
	public Wgkhxx getWgkhxx(Wgkhxx wgkhxx){
		// TODO: implement
		return (Wgkhxx)queryForObject("getWgkhxx", wgkhxx);
	}

	/** @param 外国客户信息(t_wgkhxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Khxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWgkhxxList", map, pageNo,pageSize);
	}

	/** @param 外国客户信息(t_wgkhxx) 多条查询 */
	public List getListWgkhxx(Wgkhxx wgkhxx){
		// TODO: implement
		return queryForList("getWgkhxxListNoPage", wgkhxx);
	}
}
