package com.aisino2.basicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkclDao;
import com.aisino2.basicsystem.domain.Bkcl;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;

public class BkclDaoImpl extends BaseDao implements IBkclDao {
	/** @param 布控车辆(t_bkcl) 增加 */
	public Bkcl insertBkcl(Bkcl bkcl){
		// TODO: implement
		//bkcl.setBkwpjbxxid(getNextID("Bkwpjbxxid"));
		bkcl.setBkclid(getNextID("Bkclid"));
		insert("insertBkcl", bkcl);
		return bkcl;
	}

	/** @param 布控车辆(t_bkcl) 删除 */
	public int deleteBkcl(Bkcl bkcl){
		// TODO: implement
		return delete("deleteBkcl", bkcl);
	}

	/** @param 布控车辆(t_bkcl) 修改 */
	public int updateBkcl(Bkcl bkcl){
		// TODO: implement
		return update("updateBkcl", bkcl);
	}

	/** @param 布控车辆(t_bkcl) 查询单条 */
	public Bkcl getBkcl(Bkcl bkcl){
		// TODO: implement
		return (Bkcl)queryForObject("getBkcl", bkcl);
	}

	/** @param 布控车辆(t_bkcl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Bkwpjbxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getBkclList", map, pageNo,pageSize);
	}

	/** @param 布控车辆(t_bkcl) 多条查询 */
	public List getListBkcl(Bkcl bkcl){
		// TODO: implement
		return queryForList("getBkclListNoPage", bkcl);
	}
}
