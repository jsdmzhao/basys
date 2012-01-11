package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IIckslbgDao;
import com.aisino2.icksystem.domain.Ickslbg;

public class IckslbgDaoImpl extends BaseDao implements IIckslbgDao {
	/** @param IC卡受理变更(t_ickslbg) 增加 */
	public Ickslbg insertIckslbg(Ickslbg ickslbg){
		// TODO: implement
		//ickslbg.setRyid(getNextID("Ickslbgid"));
		ickslbg.setIckslbgid(getNextID("Ickslbgid"));
		return (Ickslbg)insert("insertIckslbg", ickslbg);
	}

	/** @param IC卡受理变更(t_ickslbg) 删除 */
	public int deleteIckslbg(Ickslbg ickslbg){
		// TODO: implement
		return delete("deleteIckslbg", ickslbg);
	}

	/** @param IC卡受理变更(t_ickslbg) 修改 */
	public int updateIckslbg(Ickslbg ickslbg){
		// TODO: implement
		return update("updateIckslbg", ickslbg);
	}

	/** @param IC卡受理变更(t_ickslbg) 查询单条 */
	public Ickslbg getIckslbg(Ickslbg ickslbg){
		// TODO: implement
		return (Ickslbg)queryForObject("getIckslbg", ickslbg);
	}

	/** @param IC卡受理变更(t_ickslbg) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Ryid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getIckslbgList", map, pageNo,pageSize);
	}

	/** @param IC卡受理变更(t_ickslbg) 多条查询 */
	public List getListIckslbg(Ickslbg ickslbg){
		// TODO: implement
		return queryForList("getIckslbgListNoPage", ickslbg);
	}
}
