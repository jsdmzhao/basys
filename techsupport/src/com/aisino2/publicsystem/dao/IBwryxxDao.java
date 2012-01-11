package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Bwryxx;
public interface IBwryxxDao {
	/** @param 保卫人员信息(t_bwryxx) 增加 */
	Bwryxx insertBwryxx(Bwryxx bwryxx);

	/** @param 保卫人员信息(t_bwryxx) 删除 */
	int deleteBwryxx(Bwryxx bwryxx);

	/** @param 保卫人员信息(t_bwryxx) 修改 */
	int updateBwryxx(Bwryxx bwryxx);

	/** @param 保卫人员信息(t_bwryxx) 查询单条 */
	Bwryxx getBwryxx(Bwryxx bwryxx);

	/** @param 保卫人员信息(t_bwryxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 保卫人员信息(t_bwryxx) 多条查询 */
	List getListBwryxx(Bwryxx bwryxx);
	
	/** @param 保卫人员信息(t_bwryxx) 记录数查询 */
	Integer getBwryxxCount(Bwryxx bwryxx);
}
