package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Bafwht;

public interface IBafwhtService {
	/** @param 保安服务合同(t_bafwht) 增加 */
	Bafwht insertBafwht(Bafwht bafwht);

	/** @param 保安服务合同(t_bafwht) 删除 */
	boolean deleteBafwht(Bafwht bafwht);

	/** @param 保安服务合同(t_bafwht) 修改 */
	boolean updateBafwht(Bafwht bafwht);

	/** @param 保安服务合同(t_bafwht) 查询单条 */
	Bafwht getBafwht(Bafwht bafwht);

	/** @param 保安服务合同(t_bafwht) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 保安服务合同(t_bafwht) 多条查询 */
	List getListBafwht(Bafwht bafwht);
}
