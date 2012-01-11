package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.basicsystem.domain.Wpbjxxb;
import com.aisino2.core.dao.Page;
public interface IWpbjxxbDao {
	/** @param 物品报警信息表(t_wpbjxxb) 增加 */
	Wpbjxxb insertWpbjxxb(Wpbjxxb wpbjxxb);

	/** @param 物品报警信息表(t_wpbjxxb) 删除 */
	int deleteWpbjxxb(Wpbjxxb wpbjxxb);

	/** @param 物品报警信息表(t_wpbjxxb) 修改 */
	int updateWpbjxxb(Wpbjxxb wpbjxxb);

	/** @param 物品报警信息表(t_wpbjxxb) 查询单条 */
	Wpbjxxb getWpbjxxb(Wpbjxxb wpbjxxb);

	/** @param 物品报警信息表(t_wpbjxxb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 物品报警信息表(t_wpbjxxb) 多条查询 */
	List getListWpbjxxb(Wpbjxxb wpbjxxb);
	
	List getWpBaojingTempList(Wpbjgz wpbjgz, Integer recordNum);
	
	/**
	 * 照比对规则SQL执行查询，返回报警信息
	 * @param sql
	 * @return
	 */
	List getWpBaoJingXX(String sql);
	
}
