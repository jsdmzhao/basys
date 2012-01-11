package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkwpkbxxkzDao;
import com.aisino2.basicsystem.domain.Bkwpkbxxkz;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BkwpkbxxkzDaoImpl extends BaseDao implements IBkwpkbxxkzDao {
	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 增加 */
	public Bkwpkbxxkz insertBkwpkbxxkz(Bkwpkbxxkz bkwpkbxxkz){
		// TODO: implement
		bkwpkbxxkz.setBkwpjbxxkzid(getNextID("Bkwpjbxxkzid"));
		return (Bkwpkbxxkz)insert("insertBkwpkbxxkz", bkwpkbxxkz);
	}

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 删除 */
	public int deleteBkwpkbxxkz(Bkwpkbxxkz bkwpkbxxkz){
		// TODO: implement
		return delete("deleteBkwpkbxxkz", bkwpkbxxkz);
	}

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 修改 */
	public int updateBkwpkbxxkz(Bkwpkbxxkz bkwpkbxxkz){
		// TODO: implement
		return update("updateBkwpkbxxkz", bkwpkbxxkz);
	}

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 查询单条 */
	public Bkwpkbxxkz getBkwpkbxxkz(Bkwpkbxxkz bkwpkbxxkz){
		// TODO: implement
		return (Bkwpkbxxkz)queryForObject("getBkwpkbxxkz", bkwpkbxxkz);
	}

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bjxxid2 desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBkwpkbxxkzList", map, pageNo,pageSize);
	}

	/** @param 布控物品基本信息快照(t_bkwpkbxxkz) 多条查询 */
	public List getListBkwpkbxxkz(Bkwpkbxxkz bkwpkbxxkz){
		// TODO: implement
		return queryForList("getBkwpkbxxkzListNoPage", bkwpkbxxkz);
	}
}
