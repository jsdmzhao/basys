package com.aisino2.icksystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Ickzb;

public interface IIckzbService {
	/** @param IC卡组包(t_ickzb) IC卡组包公用服务 */
	Ickzb insertIckzb(Ickzb ickzb)throws Exception;
	
	/** @param IC卡组包(t_ickzb) IC卡自定义组包 */
	Ickzb insertIckzbCustom(Ickzb ickzb)throws Exception;
	
	/** @param IC卡组包(t_ickzb) IC卡自由组包 @return int:0-没有组包数据，1-组包成功，2-组包失败 */
	int insertIckzbFree(Ickzb ickzb)throws Exception;

	/** @param IC卡组包(t_ickzb) IC卡自由组包 自动程序调用方法*/
	void insertIckzbFreeAuto()throws Exception;
	/** @param IC卡组包(t_ickzb) 删除 */
	boolean deleteIckzb(Ickzb ickzb)throws Exception;

	/** @param IC卡组包(t_ickzb) 修改 */
	boolean updateIckzb(Ickzb ickzb)throws Exception;
	
	/** @param IC卡组包(t_ickzb) 印刷 */
	boolean updateIckzbYs(Ickzb ickzb)throws Exception;

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
