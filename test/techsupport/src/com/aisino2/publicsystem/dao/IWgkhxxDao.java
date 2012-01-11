package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Wgkhxx;
public interface IWgkhxxDao {
	/** @param 外国客户信息(t_wgkhxx) 增加 */
	Wgkhxx insertWgkhxx(Wgkhxx wgkhxx);

	/** @param 外国客户信息(t_wgkhxx) 删除 */
	int deleteWgkhxx(Wgkhxx wgkhxx);

	/** @param 外国客户信息(t_wgkhxx) 修改 */
	int updateWgkhxx(Wgkhxx wgkhxx);

	/** @param 外国客户信息(t_wgkhxx) 查询单条 */
	Wgkhxx getWgkhxx(Wgkhxx wgkhxx);

	/** @param 外国客户信息(t_wgkhxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 外国客户信息(t_wgkhxx) 多条查询 */
	List getListWgkhxx(Wgkhxx wgkhxx);
}
