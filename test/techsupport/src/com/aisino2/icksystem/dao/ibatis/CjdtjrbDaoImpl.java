package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.ICjdtjrbDao;
import com.aisino2.icksystem.domain.Cjdtjrb;

public class CjdtjrbDaoImpl extends BaseDao implements ICjdtjrbDao {
	/** @param 采集端统计日报(t_cjdtjrb) 增加 */
	public Cjdtjrb insertCjdtjrb(Cjdtjrb cjdtjrb){
		// TODO: implement
		cjdtjrb.setCjdtjrbid(getNextID("Cjdtjrbid"));
		return (Cjdtjrb)insert("insertCjdtjrb", cjdtjrb);
	}

	/** @param 采集端统计日报(t_cjdtjrb) 删除 */
	public int deleteCjdtjrb(Cjdtjrb cjdtjrb){
		// TODO: implement
		return delete("deleteCjdtjrb", cjdtjrb);
	}

	/** @param 采集端统计日报(t_cjdtjrb) 修改 */
	public int updateCjdtjrb(Cjdtjrb cjdtjrb){
		// TODO: implement
		return update("updateCjdtjrb", cjdtjrb);
	}

	/** @param 采集端统计日报(t_cjdtjrb) 查询单条 */
	public Cjdtjrb getCjdtjrb(Cjdtjrb cjdtjrb){
		// TODO: implement
		return (Cjdtjrb)queryForObject("getCjdtjrb", cjdtjrb);
	}

	/** @param 采集端统计日报(t_cjdtjrb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="ssdsbm";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCjdtjrbList", map, pageNo,pageSize);
	}
	
	/** @param 采集端统计日报-企业端(t_cjdtjrb) 分页查询 */
	public Page getListForPageQyd(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="ssdsbm";
		}
		map.put("pageSort", sCol);
		return queryForPage("getCjdtjrbListQyd", map, pageNo,pageSize);
	}

	/** @param 采集端统计日报(t_cjdtjrb) 多条查询 */
	public List getListCjdtjrb(Cjdtjrb cjdtjrb){
		// TODO: implement
		return queryForList("getCjdtjrbListNoPage", cjdtjrb);
	}
	
	/** @param 采集端日报(t_cjdtjrb) 分页查询 */
	public Page getCjdrbListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		map.put("pageSort", "a.cjdtjrq desc");
		return queryForPage("getCjdrbList", map, pageNo,pageSize);
	}
}
