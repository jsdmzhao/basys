package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Baryxx;

public interface IBaryxxService {
	/** @param 保安人员信息(t_baryxx) 增加 */
	Baryxx insertBaryxx(Baryxx baryxx);

	/** @param 保安人员信息(t_baryxx) 删除 */
	boolean deleteBaryxx(Baryxx baryxx);

	/** @param 保安人员信息(t_baryxx) 修改 */
	boolean updateBaryxx(Baryxx baryxx);

	/** @param 保安人员信息(t_baryxx) 查询单条 */
	Baryxx getBaryxx(Baryxx baryxx);

	/** @param 保安人员信息(t_baryxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 保安人员信息(t_baryxx) 多条查询 */
	List getListBaryxx(Baryxx baryxx);
}
