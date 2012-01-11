package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IZktjrbDao;
import com.aisino2.icksystem.domain.Zktjrb;

public class ZktjrbDaoImpl extends BaseDao implements IZktjrbDao {
	/** @param 制卡统计日报(t_zktjrb) 增加 */
	public Zktjrb insertZktjrb(Zktjrb zktjrb){
		// TODO: implement
		zktjrb.setZktjrbid(getNextID("Zktjrbid"));
		return (Zktjrb)insert("insertZktjrb", zktjrb);
	}

	/** @param 制卡统计日报(t_zktjrb) 删除 */
	public int deleteZktjrb(Zktjrb zktjrb){
		// TODO: implement
		return delete("deleteZktjrb", zktjrb);
	}

	/** @param 制卡统计日报(t_zktjrb) 修改 */
	public int updateZktjrb(Zktjrb zktjrb){
		// TODO: implement
		return update("updateZktjrb", zktjrb);
	}

	/** @param 制卡统计日报(t_zktjrb) 查询单条 */
	public Zktjrb getZktjrb(Zktjrb zktjrb){
		// TODO: implement
		return (Zktjrb)queryForObject("getZktjrb", zktjrb);
	}

	/** @param 制卡统计日报(t_zktjrb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Zktjrbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getZktjrbList", map, pageNo,pageSize);
	}

	/** @param 制卡统计日报(t_zktjrb) 多条查询 */
	public List getListZktjrb(Zktjrb zktjrb){
		// TODO: implement
		return queryForList("getZktjrbListNoPage", zktjrb);
	}
}
