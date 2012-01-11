package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bdqclxx;
import com.aisino2.core.dao.Page;
public interface IBdqclxxDao {
	/** @param 被盗抢车辆信息(t_bdqclxx) 增加 */
	Bdqclxx insertBdqclxx(Bdqclxx bdqclxx);

	/** @param 被盗抢车辆信息(t_bdqclxx) 删除 */
	int deleteBdqclxx(Bdqclxx bdqclxx);

	/** @param 被盗抢车辆信息(t_bdqclxx) 修改 */
	int updateBdqclxx(Bdqclxx bdqclxx);

	/** @param 被盗抢车辆信息(t_bdqclxx) 查询单条 */
	Bdqclxx getBdqclxx(Bdqclxx bdqclxx);

	/** @param 被盗抢车辆信息(t_bdqclxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 被盗抢车辆信息(t_bdqclxx) 多条查询 */
	List getListBdqclxx(Bdqclxx bdqclxx);
}
