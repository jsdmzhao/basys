package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IZktjybDao;
import com.aisino2.icksystem.domain.Zktjyb;

public class ZktjybDaoImpl extends BaseDao implements IZktjybDao {
	/** @param 制卡统计月报(t_zktjyb) 增加 */
	public Zktjyb insertZktjyb(Zktjyb zktjyb){
		// TODO: implement
		zktjyb.setZktjybid(getNextID("Zktjybid"));
		return (Zktjyb)insert("insertZktjyb", zktjyb);
	}

	/** @param 制卡统计月报(t_zktjyb) 删除 */
	public int deleteZktjyb(Zktjyb zktjyb){
		// TODO: implement
		return delete("deleteZktjyb", zktjyb);
	}

	/** @param 制卡统计月报(t_zktjyb) 修改 */
	public int updateZktjyb(Zktjyb zktjyb){
		// TODO: implement
		return update("updateZktjyb", zktjyb);
	}

	/** @param 制卡统计月报(t_zktjyb) 查询单条 */
	public Zktjyb getZktjyb(Zktjyb zktjyb){
		// TODO: implement
		return (Zktjyb)queryForObject("getZktjyb", zktjyb);
	}

	/** @param 制卡统计月报(t_zktjyb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Zktjybid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getZktjybList", map, pageNo,pageSize);
	}

	/** @param 制卡统计月报(t_zktjyb) 多条查询 */
	public List getListZktjyb(Zktjyb zktjyb){
		// TODO: implement
		return queryForList("getZktjybListNoPage", zktjyb);
	}
}
