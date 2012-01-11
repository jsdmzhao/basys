package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IZktjhjrbDao;
import com.aisino2.icksystem.domain.Zktjhjrb;

public class ZktjhjrbDaoImpl extends BaseDao implements IZktjhjrbDao {
	/** @param 制卡统计汇总日报(t_zktjhjrb) 增加 */
	public Zktjhjrb insertZktjhjrb(Zktjhjrb zktjhjrb){
		// TODO: implement
		zktjhjrb.setZktjhzrbid(getNextID("Zktjhzrbid"));
		return (Zktjhjrb)insert("insertZktjhjrb", zktjhjrb);
	}

	/** @param 制卡统计汇总日报(t_zktjhjrb) 删除 */
	public int deleteZktjhjrb(Zktjhjrb zktjhjrb){
		// TODO: implement
		return delete("deleteZktjhjrb", zktjhjrb);
	}

	/** @param 制卡统计汇总日报(t_zktjhjrb) 修改 */
	public int updateZktjhjrb(Zktjhjrb zktjhjrb){
		// TODO: implement
		return update("updateZktjhjrb", zktjhjrb);
	}

	/** @param 制卡统计汇总日报(t_zktjhjrb) 查询单条 */
	public Zktjhjrb getZktjhjrb(Zktjhjrb zktjhjrb){
		// TODO: implement
		return (Zktjhjrb)queryForObject("getZktjhjrb", zktjhjrb);
	}

	/** @param 制卡统计汇总日报(t_zktjhjrb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Zktjhzrbid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getZktjhjrbList", map, pageNo,pageSize);
	}

	/** @param 制卡统计汇总日报(t_zktjhjrb) 多条查询 */
	public List getListZktjhjrb(Zktjhjrb zktjhjrb){
		// TODO: implement
		return queryForList("getZktjhjrbListNoPage", zktjhjrb);
	}
}
