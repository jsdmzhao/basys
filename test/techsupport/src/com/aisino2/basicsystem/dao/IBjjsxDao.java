package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bjjsx;
import com.aisino2.core.dao.Page;
public interface IBjjsxDao {
	/** @param 报警机刷新(t_bjjsx) 增加 */
	Bjjsx insertBjjsx(Bjjsx bjjsx);

	/** @param 报警机刷新(t_bjjsx) 删除 */
	int deleteBjjsx(Bjjsx bjjsx);

	/** @param 报警机刷新(t_bjjsx) 修改 */
	int updateBjjsx(Bjjsx bjjsx);

	/** @param 报警机刷新(t_bjjsx) 查询单条 */
	Bjjsx getBjjsx(Bjjsx bjjsx);

	/** @param 报警机刷新(t_bjjsx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 报警机刷新(t_bjjsx) 多条查询 */
	List getListBjjsx(Bjjsx bjjsx);
}
