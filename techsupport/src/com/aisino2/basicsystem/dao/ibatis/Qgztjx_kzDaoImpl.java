package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IQgztjx_kzDao;
import com.aisino2.basicsystem.domain.Qgztjx_kz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class Qgztjx_kzDaoImpl extends BaseDao implements IQgztjx_kzDao {
	/** @param 全国在逃简项快照(t_qgztjx_kz) 增加 */
	public Qgztjx_kz insertQgztjx_kz(Qgztjx_kz qgztjx_kz){
		// TODO: implement
		qgztjx_kz.setQgztjxkzid(getNextID("Qgztjx_kzid"));
		return (Qgztjx_kz)insert("insertQgztjx_kz", qgztjx_kz);
	}

	/** @param 全国在逃简项快照(t_qgztjx_kz) 删除 */
	public int deleteQgztjx_kz(Qgztjx_kz qgztjx_kz){
		// TODO: implement
		return delete("deleteQgztjx_kz", qgztjx_kz);
	}

	/** @param 全国在逃简项快照(t_qgztjx_kz) 修改 */
	public int updateQgztjx_kz(Qgztjx_kz qgztjx_kz){
		// TODO: implement
		return update("updateQgztjx_kz", qgztjx_kz);
	}

	/** @param 全国在逃简项快照(t_qgztjx_kz) 查询单条 */
	public Qgztjx_kz getQgztjx_kz(Qgztjx_kz qgztjx_kz){
		// TODO: implement
		return (Qgztjx_kz)queryForObject("getQgztjx_kz", qgztjx_kz);
	}

	/** @param 全国在逃简项快照(t_qgztjx_kz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjgzid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getQgztjx_kzList", map, pageNo,pageSize);
	}

	/** @param 全国在逃简项快照(t_qgztjx_kz) 多条查询 */
	public List getListQgztjx_kz(Qgztjx_kz qgztjx_kz){
		// TODO: implement
		return queryForList("getQgztjx_kzListNoPage", qgztjx_kz);
	}
}
