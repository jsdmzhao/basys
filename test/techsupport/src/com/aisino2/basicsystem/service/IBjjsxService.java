package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bjjsx;
import com.aisino2.core.dao.Page;

public interface IBjjsxService {
	/** @param 报警机刷新(t_bjjsx) 增加 */
	Bjjsx insertBjjsx(Bjjsx bjjsx);

	/** @param 报警机刷新(t_bjjsx) 删除 */
	boolean deleteBjjsx(Bjjsx bjjsx);

	/** @param 报警机刷新(t_bjjsx) 修改 */
	boolean updateBjjsx(Bjjsx bjjsx);

	/** @param 报警机刷新(t_bjjsx) 查询单条 */
	Bjjsx getBjjsx(Bjjsx bjjsx);

	/** @param 报警机刷新(t_bjjsx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 报警机刷新(t_bjjsx) 多条查询 */
	List getListBjjsx(Bjjsx bjjsx);
}
