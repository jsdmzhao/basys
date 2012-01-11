package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bdqclxxlsb;
import com.aisino2.core.dao.Page;
public interface IBdqclxxlsbDao {
	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 增加 */
	Bdqclxxlsb insertBdqclxxlsb(Bdqclxxlsb bdqclxxlsb);

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 删除 */
	int deleteBdqclxxlsb(Bdqclxxlsb bdqclxxlsb);

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 修改 */
	int updateBdqclxxlsb(Bdqclxxlsb bdqclxxlsb);

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 查询单条 */
	Bdqclxxlsb getBdqclxxlsb(Bdqclxxlsb bdqclxxlsb);

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 被盗抢车辆信息临时表(t_bdqclxxlsb) 多条查询 */
	List getListBdqclxxlsb(Bdqclxxlsb bdqclxxlsb);
}
