package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Dxyj;
import com.aisino2.core.dao.Page;
public interface IDxyjDao {
	/** @param 短信预警(t_dxyj) 增加 */
	Dxyj insertDxyj(Dxyj dxyj);

	/** @param 短信预警(t_dxyj) 删除 */
	int deleteDxyj(Dxyj dxyj);

	/** @param 短信预警(t_dxyj) 修改 */
	int updateDxyj(Dxyj dxyj);

	/** @param 短信预警(t_dxyj) 查询单条 */
	Dxyj getDxyj(Dxyj dxyj);

	/** @param 短信预警(t_dxyj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 短信预警(t_dxyj) 多条查询 */
	List getListDxyj(Dxyj dxyj);
}
