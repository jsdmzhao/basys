package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Ickyj;
public interface IIckyjDao {
	/** @param IC卡预警(t_ickyj) 增加 */
	Ickyj insertIckyj(Ickyj ickyj);

	/** @param IC卡预警(t_ickyj) 删除 */
	int deleteIckyj(Ickyj ickyj);

	/** @param IC卡预警(t_ickyj) 修改 */
	int updateIckyj(Ickyj ickyj);

	/** @param IC卡预警(t_ickyj) 查询单条 */
	Ickyj getIckyj(Ickyj ickyj);

	/** @param IC卡预警(t_ickyj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param IC卡预警(t_ickyj) 多条查询 */
	List getListIckyj(Ickyj ickyj);
}
