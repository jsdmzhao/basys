package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Icksltj;
public interface IIcksltjDao {
	/** @param IC卡受理统计(t_icksltj) 增加 */
	Icksltj insertIcksltj(Icksltj icksltj);

	/** @param IC卡受理统计(t_icksltj) 删除 */
	int deleteIcksltj(Icksltj icksltj);

	/** @param IC卡受理统计(t_icksltj) 修改 */
	int updateIcksltj(Icksltj icksltj);

	/** @param IC卡受理统计(t_icksltj) 查询单条 */
	Icksltj getIcksltj(Icksltj icksltj);

	/** @param IC卡受理统计(t_icksltj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param IC卡受理统计(t_icksltj) 多条查询 */
	List getListIcksltj(Icksltj icksltj);
}
