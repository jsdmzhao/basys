package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkclkzDao;
import com.aisino2.basicsystem.domain.Bkclkz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BkclkzDaoImpl extends BaseDao implements IBkclkzDao {
	/** @param 布控车辆快照(t_bkclkz) 增加 */
	public Bkclkz insertBkclkz(Bkclkz bkclkz){
		// TODO: implement bkclkzid
		bkclkz.setBkclkzid(getNextID("Bkclkzid"));
		return (Bkclkz)insert("insertBkclkz", bkclkz);
	}

	/** @param 布控车辆快照(t_bkclkz) 删除 */
	public int deleteBkclkz(Bkclkz bkclkz){
		// TODO: implement
		return delete("deleteBkclkz", bkclkz);
	}

	/** @param 布控车辆快照(t_bkclkz) 修改 */
	public int updateBkclkz(Bkclkz bkclkz){
		// TODO: implement
		return update("updateBkclkz", bkclkz);
	}

	/** @param 布控车辆快照(t_bkclkz) 查询单条 */
	public Bkclkz getBkclkz(Bkclkz bkclkz){
		// TODO: implement
		return (Bkclkz)queryForObject("getBkclkz", bkclkz);
	}

	/** @param 布控车辆快照(t_bkclkz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjxxid2 desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBkclkzList", map, pageNo,pageSize);
	}

	/** @param 布控车辆快照(t_bkclkz) 多条查询 */
	public List getListBkclkz(Bkclkz bkclkz){
		// TODO: implement
		return queryForList("getBkclkzListNoPage", bkclkz);
	}
}
