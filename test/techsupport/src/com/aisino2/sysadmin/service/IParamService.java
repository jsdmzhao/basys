package com.aisino2.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Param;

public interface IParamService {
	/** @param 参数设置(t_param) 增加 */
	Param insertParam(Param param);

	/** @param 参数设置(t_param) 删除 */
	boolean deleteParam(Param param);

	/** @param 参数设置(t_param) 修改 */
	boolean updateParam(Param param);

	/** @param 参数设置(t_param) 查询单条 */
	Param getParam(Param param);

	/** @param 参数设置(t_param) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 参数设置(t_param) 多条查询 */
	List getListParam(Param param);
}
