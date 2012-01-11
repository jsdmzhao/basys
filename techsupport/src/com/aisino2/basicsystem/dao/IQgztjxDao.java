package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Qgztjx;
import com.aisino2.core.dao.Page;
public interface IQgztjxDao {
	/** @param 全国在逃简项(t_qgztjx) 增加 */
	Qgztjx insertQgztjx(Qgztjx qgztjx);
	
	/** @param 全国在逃简项(t_qgztjx) 表转换 */
	int insertQgztjxIn();
	
	/** @param 全国在逃简项临时表(t_qgztjx_lsb) 增加 */
	Qgztjx insertQgztjxlsb(Qgztjx qgztjx);

	/** @param 全国在逃简项(t_qgztjx) 删除 */
	int deleteQgztjx(Qgztjx qgztjx);
	
	/** @param 全国在逃简项临时表(t_qgztjx_lsb) 删除 */
	int deleteQgztjxlsb(Qgztjx qgztjx);

	/** @param 全国在逃简项(t_qgztjx) 修改 */
	int updateQgztjx(Qgztjx qgztjx);

	/** @param 全国在逃简项(t_qgztjx) 查询单条 */
	Qgztjx getQgztjx(Qgztjx qgztjx);

	/** @param 全国在逃简项(t_qgztjx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 全国在逃简项(t_qgztjx) 多条查询 */
	List getListQgztjx(Qgztjx qgztjx);

	List getListExportQgztjx(Map map, String sort, String desc);
}
