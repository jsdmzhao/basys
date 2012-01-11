package com.aisino2.icksystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Icksl_ickzb;

public interface IIcksl_ickzbService {
	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 增加 */
	Icksl_ickzb insertIcksl_ickzb(Icksl_ickzb icksl_ickzb);

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 删除 */
	boolean deleteIcksl_ickzb(Icksl_ickzb icksl_ickzb);

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 修改 */
	boolean updateIcksl_ickzb(Icksl_ickzb icksl_ickzb);

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 查询单条 */
	Icksl_ickzb getIcksl_ickzb(Icksl_ickzb icksl_ickzb);

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) 多条查询 */
	List getListIcksl_ickzb(Icksl_ickzb icksl_ickzb);
}
