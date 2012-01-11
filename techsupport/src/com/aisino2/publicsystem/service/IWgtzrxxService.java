package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Wgtzrxx;

public interface IWgtzrxxService {
	/** @param 外国投资人信息(t_wgtzrxx) 增加 */
	Wgtzrxx insertWgtzrxx(Wgtzrxx wgtzrxx);

	/** @param 外国投资人信息(t_wgtzrxx) 删除 */
	boolean deleteWgtzrxx(Wgtzrxx wgtzrxx);

	/** @param 外国投资人信息(t_wgtzrxx) 修改 */
	boolean updateWgtzrxx(Wgtzrxx wgtzrxx);

	/** @param 外国投资人信息(t_wgtzrxx) 查询单条 */
	Wgtzrxx getWgtzrxx(Wgtzrxx wgtzrxx);

	/** @param 外国投资人信息(t_wgtzrxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 外国投资人信息(t_wgtzrxx) 多条查询 */
	List getListWgtzrxx(Wgtzrxx wgtzrxx);
}
