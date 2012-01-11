package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Ickzb;
public interface IIckzbDao {
	/** @param IC卡组包(t_ickzb) 增加 */
	Ickzb insertIckzb(Ickzb ickzb);

	/** @param IC卡组包(t_ickzb) 删除 */
	int deleteIckzb(Ickzb ickzb);

	/** @param IC卡组包(t_ickzb) 修改 */
	int updateIckzb(Ickzb ickzb);

	/** @param IC卡组包(t_ickzb) 查询单条 */
	Ickzb getIckzb(Ickzb ickzb);

	/** @param IC卡组包(t_ickzb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param IC卡组包(t_ickzb) 多条查询 */
	List getListIckzb(Ickzb ickzb);
	
	/** @param IC卡组包(t_ickzb) 印刷信息查询 */
	Ickzb getIckzbYsxx(Ickzb ickzb);
	
	/** @param IC卡组包(t_ickzb) 电写入信息查询 */
	Ickzb getIckzbDxrxx(Ickzb ickzb);

	/** @param IC卡组包(t_ickzb) 分页查询 查询包内需打印的卡的信息*/
	Page getIckzbYsListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param IC卡组包(t_ickzb) 多条查询 需电写入的IC卡查询*/
	List getIckzbDxrList(Ickzb ickzb);
	
	/**
	 * 获得下一个pch
	 * @param map 
	 * @return
	 */
	String getNextPch(Map map);
}
