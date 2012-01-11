package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IZjb_lsDao;
import com.aisino2.publicsystem.domain.Zjb_ls;

public class Zjb_lsDaoImpl extends BaseDao implements IZjb_lsDao {
	/** @param 证件历史表(t_zjb_ls) 增加 */
	public Zjb_ls insertZjb_ls(Zjb_ls zjb_ls){
		// TODO: implement
		zjb_ls.setZjlsid(getNextID("Qyzjlsid"));
		insert("insertZjb_ls", zjb_ls);
		return zjb_ls;
	}

	/** @param 证件历史表(t_zjb_ls) 删除 */
	public int deleteZjb_ls(Zjb_ls zjb_ls){
		// TODO: implement
		return delete("deleteZjb_ls", zjb_ls);
	}

	/** @param 证件历史表(t_zjb_ls) 修改 */
	public int updateZjb_ls(Zjb_ls zjb_ls){
		// TODO: implement
		return update("updateZjb_ls", zjb_ls);
	}

	/** @param 证件历史表(t_zjb_ls) 查询单条 */
	public Zjb_ls getZjb_ls(Zjb_ls zjb_ls){
		// TODO: implement
		return (Zjb_ls)queryForObject("getZjb_ls", zjb_ls);
	}

	/** @param 证件历史表(t_zjb_ls) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Qyid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getZjb_lsList", map, pageNo,pageSize);
	}

	/** @param 证件历史表(t_zjb_ls) 多条查询 */
	public List getListZjb_ls(Zjb_ls zjb_ls){
		// TODO: implement
		return queryForList("getZjb_lsListNoPage", zjb_ls);
	}
}
