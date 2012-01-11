package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBksjkzDao;
import com.aisino2.basicsystem.domain.Bksjkz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BksjkzDaoImpl extends BaseDao implements IBksjkzDao {
	/** @param 布控手机快照(t_bksjkz) 增加 */
	public Bksjkz insertBksjkz(Bksjkz bksjkz){
		// TODO: implement
		bksjkz.setBksjkzid(getNextID("Bksjkzid"));
		return (Bksjkz)insert("insertBksjkz", bksjkz);
	}

	/** @param 布控手机快照(t_bksjkz) 删除 */
	public int deleteBksjkz(Bksjkz bksjkz){
		// TODO: implement
		return delete("deleteBksjkz", bksjkz);
	}

	/** @param 布控手机快照(t_bksjkz) 修改 */
	public int updateBksjkz(Bksjkz bksjkz){
		// TODO: implement
		return update("updateBksjkz", bksjkz);
	}

	/** @param 布控手机快照(t_bksjkz) 查询单条 */
	public Bksjkz getBksjkz(Bksjkz bksjkz){
		// TODO: implement
		return (Bksjkz)queryForObject("getBksjkz", bksjkz);
	}

	/** @param 布控手机快照(t_bksjkz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjxxid2 desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBksjkzList", map, pageNo,pageSize);
	}

	/** @param 布控手机快照(t_bksjkz) 多条查询 */
	public List getListBksjkz(Bksjkz bksjkz){
		// TODO: implement
		return queryForList("getBksjkzListNoPage", bksjkz);
	}
}
