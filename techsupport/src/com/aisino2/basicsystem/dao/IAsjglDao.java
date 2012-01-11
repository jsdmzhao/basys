package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Asjgl;
import com.aisino2.core.dao.Page;
public interface IAsjglDao {
	/** @param 案事件管理(t_asjgl) 增加 */
	Asjgl insertAsjgl(Asjgl asjgl);

	/** @param 案事件管理(t_asjgl) 删除 */
	int deleteAsjgl(Asjgl asjgl);

	/** @param 案事件管理(t_asjgl) 修改 */
	int updateAsjgl(Asjgl asjgl);

	/** @param 案事件管理(t_asjgl) 查询单条 */
	Asjgl getAsjgl(Asjgl asjgl);

	/** @param 案事件管理(t_asjgl) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 案事件管理(t_asjgl) 多条查询 */
	List getListAsjgl(Asjgl asjgl);
	
	List getListExportAsjgl(Map map, String sort, String desc);
}
