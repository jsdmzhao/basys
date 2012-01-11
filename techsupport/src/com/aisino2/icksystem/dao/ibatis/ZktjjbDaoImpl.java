package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IZktjjbDao;
import com.aisino2.icksystem.domain.Zktjjb;

public class ZktjjbDaoImpl extends BaseDao implements IZktjjbDao {
	/** @param 制卡统计季报(t_zktjjb) 增加 */
	public Zktjjb insertZktjjb(Zktjjb zktjjb){
		// TODO: implement
		zktjjb.setZktjjbid(getNextID("Zktjjbid"));
		return (Zktjjb)insert("insertZktjjb", zktjjb);
	}

	/** @param 制卡统计季报(t_zktjjb) 删除 */
	public int deleteZktjjb(Zktjjb zktjjb){
		// TODO: implement
		return delete("deleteZktjjb", zktjjb);
	}

	/** @param 制卡统计季报(t_zktjjb) 修改 */
	public int updateZktjjb(Zktjjb zktjjb){
		// TODO: implement
		return update("updateZktjjb", zktjjb);
	}

	/** @param 制卡统计季报(t_zktjjb) 查询单条 */
	public Zktjjb getZktjjb(Zktjjb zktjjb){
		// TODO: implement
		return (Zktjjb)queryForObject("getZktjjb", zktjjb);
	}

	/** @param 制卡统计季报(t_zktjjb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Zktjjbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getZktjjbList", map, pageNo,pageSize);
	}

	/** @param 制卡统计季报(t_zktjjb) 多条查询 */
	public List getListZktjjb(Zktjjb zktjjb){
		// TODO: implement
		return queryForList("getZktjjbListNoPage", zktjjb);
	}
}
