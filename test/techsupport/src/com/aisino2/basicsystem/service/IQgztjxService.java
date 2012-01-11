package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Qgztjx;
import com.aisino2.core.dao.Page;

public interface IQgztjxService {
	/** @param 全国在逃简项(t_qgztjx) 增加 */
	Qgztjx insertQgztjx(Qgztjx qgztjx);

	/** @param 全国在逃简项(t_qgztjx) 删除 */
	boolean deleteQgztjx(Qgztjx qgztjx);

	/** @param 全国在逃简项(t_qgztjx) 修改 */
	boolean updateQgztjx(Qgztjx qgztjx);

	/** @param 全国在逃简项(t_qgztjx) 查询单条 */
	Qgztjx getQgztjx(Qgztjx qgztjx);

	/** @param 全国在逃简项(t_qgztjx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 全国在逃简项(t_qgztjx) 多条查询 */
	List getListQgztjx(Qgztjx qgztjx);
	
	String getFtpUpdate();
	
	List getDictitem();

	List getListExportQgztjx(Map map, String sort, String desc);
}
