package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IGzdx_kzDao;
import com.aisino2.basicsystem.domain.Gzdx_kz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class Gzdx_kzDaoImpl extends BaseDao implements IGzdx_kzDao {
	/** @param 关注对象快照(t_gzdx_kz) 增加 */
	public Gzdx_kz insertGzdx_kz(Gzdx_kz gzdx_kz){
		// TODO: implement
		gzdx_kz.setGzdxid(getNextID("Gzdxid"));
		return (Gzdx_kz)insert("insertGzdx_kz", gzdx_kz);
	}

	/** @param 关注对象快照(t_gzdx_kz) 删除 */
	public int deleteGzdx_kz(Gzdx_kz gzdx_kz){
		// TODO: implement
		return delete("deleteGzdx_kz", gzdx_kz);
	}

	/** @param 关注对象快照(t_gzdx_kz) 修改 */
	public int updateGzdx_kz(Gzdx_kz gzdx_kz){
		// TODO: implement
		return update("updateGzdx_kz", gzdx_kz);
	}

	/** @param 关注对象快照(t_gzdx_kz) 查询单条 */
	public Gzdx_kz getGzdx_kz(Gzdx_kz gzdx_kz){
		// TODO: implement
		return (Gzdx_kz)queryForObject("getGzdx_kz", gzdx_kz);
	}

	/** @param 关注对象快照(t_gzdx_kz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Gzdxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getGzdx_kzList", map, pageNo,pageSize);
	}

	/** @param 关注对象快照(t_gzdx_kz) 多条查询 */
	public List getListGzdx_kz(Gzdx_kz gzdx_kz){
		// TODO: implement
		return queryForList("getGzdx_kzListNoPage", gzdx_kz);
	}

	public Gzdx_kz insertGzdx_kzBDBJ(Gzdx_kz gzdxKz) {
		gzdxKz.setGzdxkzid(getNextID("Gzdxkzid"));
		insert("insertGzdx_kzBDBJ", gzdxKz);
		return gzdxKz;
	}
}
