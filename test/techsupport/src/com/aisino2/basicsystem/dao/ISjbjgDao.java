package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Sjbjg;
import com.aisino2.core.dao.Page;
public interface ISjbjgDao {
	/** @param 数据表结构(t_sjbjg) 增加 */
	Sjbjg insertSjbjg(Sjbjg sjbjg);

	/** @param 数据表结构(t_sjbjg) 删除 */
	int deleteSjbjg(Sjbjg sjbjg);

	/** @param 数据表结构(t_sjbjg) 修改 */
	int updateSjbjg(Sjbjg sjbjg);

	/** @param 数据表结构(t_sjbjg) 查询单条 */
	Sjbjg getSjbjg(Sjbjg sjbjg);

	/** @param 数据表结构(t_sjbjg) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 数据表结构(t_sjbjg) 多条查询 */
	List getListSjbjg(Sjbjg sjbjg);
}
