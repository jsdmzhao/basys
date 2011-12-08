package com.aisino2.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.aisino2.sysadmin.domain.Globalpar;
import com.opensymphony.module.sitemesh.Page;

public interface IGlobalparService {
	/** @param 全局参数(t_globalpar) 增加 */
	Globalpar insertGlobalpar(Globalpar globalpar);

	/** @param 全局参数(t_globalpar) 删除 */
	boolean deleteGlobalpar(Globalpar globalpar);

	/** @param 全局参数(t_globalpar) 修改 */
	boolean updateGlobalpar(Globalpar globalpar);

	/** @param 全局参数(t_globalpar) 查询单条 */
	Globalpar getGlobalpar(Globalpar globalpar);

	/** @param 全局参数(t_globalpar) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 全局参数(t_globalpar) 多条查询 */
	List getListGlobalpar(Globalpar globalpar);
}
