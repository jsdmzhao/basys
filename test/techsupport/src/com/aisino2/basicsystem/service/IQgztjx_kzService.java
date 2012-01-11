package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Qgztjx_kz;
import com.aisino2.core.dao.Page;

public interface IQgztjx_kzService {
	/** @param 全国在逃简项快照(t_qgztjx_kz) 增加 */
	Qgztjx_kz insertQgztjx_kz(Qgztjx_kz qgztjx_kz);

	/** @param 全国在逃简项快照(t_qgztjx_kz) 删除 */
	boolean deleteQgztjx_kz(Qgztjx_kz qgztjx_kz);

	/** @param 全国在逃简项快照(t_qgztjx_kz) 修改 */
	boolean updateQgztjx_kz(Qgztjx_kz qgztjx_kz);

	/** @param 全国在逃简项快照(t_qgztjx_kz) 查询单条 */
	Qgztjx_kz getQgztjx_kz(Qgztjx_kz qgztjx_kz);

	/** @param 全国在逃简项快照(t_qgztjx_kz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 全国在逃简项快照(t_qgztjx_kz) 多条查询 */
	List getListQgztjx_kz(Qgztjx_kz qgztjx_kz);
}
