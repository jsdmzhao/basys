package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.core.dao.Page;

public interface IWpbjgzService {
	/** @param 物品报警规则(t_wpbjgz) 增加 */
	Wpbjgz insertWpbjgz(Wpbjgz wpbjgz);

	/** @param 物品报警规则(t_wpbjgz) 删除 */
	boolean deleteWpbjgz(Wpbjgz wpbjgz);

	/** @param 物品报警规则(t_wpbjgz) 修改 */
	boolean updateWpbjgz(Wpbjgz wpbjgz);

	/** @param 物品报警规则(t_wpbjgz) 查询单条 */
	Wpbjgz getWpbjgz(Wpbjgz wpbjgz);

	/** @param 物品报警规则(t_wpbjgz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 物品报警规则(t_wpbjgz) 多条查询 */
	List getListWpbjgz(Wpbjgz wpbjgz);
}
