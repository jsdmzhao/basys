package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IWgtzrxxDao;
import com.aisino2.publicsystem.domain.Wgtzrxx;

public class WgtzrxxDaoImpl extends BaseDao implements IWgtzrxxDao {
	/** @param 外国投资人信息(t_wgtzrxx) 增加 */
	public Wgtzrxx insertWgtzrxx(Wgtzrxx wgtzrxx){
		// TODO: implement
		wgtzrxx.setWgtzrxxid(getNextID("Wgtzrxxid"));
		return (Wgtzrxx)insert("insertWgtzrxx", wgtzrxx);
	}

	/** @param 外国投资人信息(t_wgtzrxx) 删除 */
	public int deleteWgtzrxx(Wgtzrxx wgtzrxx){
		// TODO: implement
		return delete("deleteWgtzrxx", wgtzrxx);
	}

	/** @param 外国投资人信息(t_wgtzrxx) 修改 */
	public int updateWgtzrxx(Wgtzrxx wgtzrxx){
		// TODO: implement
		return update("updateWgtzrxx", wgtzrxx);
	}

	/** @param 外国投资人信息(t_wgtzrxx) 查询单条 */
	public Wgtzrxx getWgtzrxx(Wgtzrxx wgtzrxx){
		// TODO: implement
		return (Wgtzrxx)queryForObject("getWgtzrxx", wgtzrxx);
	}

	/** @param 外国投资人信息(t_wgtzrxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Wgtzrxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getWgtzrxxList", map, pageNo,pageSize);
	}

	/** @param 外国投资人信息(t_wgtzrxx) 多条查询 */
	public List getListWgtzrxx(Wgtzrxx wgtzrxx){
		// TODO: implement
		return queryForList("getWgtzrxxListNoPage", wgtzrxx);
	}
}
