package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkry_kzDao;
import com.aisino2.basicsystem.domain.Bkry_kz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class Bkry_kzDaoImpl extends BaseDao implements IBkry_kzDao {
	/** @param 布控人员快照(t_bkry_kz) 增加 */
	public Bkry_kz insertBkry_kz(Bkry_kz bkry_kz){
		// TODO: implement
		bkry_kz.setBkrykzid(getNextID("Bkrykzid"));
		return (Bkry_kz)insert("insertBkry_kz", bkry_kz);
	}

	/** @param 布控人员快照(t_bkry_kz) 删除 */
	public int deleteBkry_kz(Bkry_kz bkry_kz){
		// TODO: implement
		return delete("deleteBkry_kz", bkry_kz);
	}

	/** @param 布控人员快照(t_bkry_kz) 修改 */
	public int updateBkry_kz(Bkry_kz bkry_kz){
		// TODO: implement
		return update("updateBkry_kz", bkry_kz);
	}

	/** @param 布控人员快照(t_bkry_kz) 查询单条 */
	public Bkry_kz getBkry_kz(Bkry_kz bkry_kz){
		// TODO: implement
		return (Bkry_kz)queryForObject("getBkry_kz", bkry_kz);
	}

	/** @param 布控人员快照(t_bkry_kz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjgzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBkry_kzList", map, pageNo,pageSize);
	}

	/** @param 布控人员快照(t_bkry_kz) 多条查询 */
	public List getListBkry_kz(Bkry_kz bkry_kz){
		// TODO: implement
		return queryForList("getBkry_kzListNoPage", bkry_kz);
	}
}
