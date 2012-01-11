package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bdbjtj;
import com.aisino2.core.dao.Page;

public interface IBdbjtjDao {
	/** @param 比对报警统计表(t_bdbjtj) 增加 */
	Bdbjtj insertBdbjtj(Bdbjtj bdbjtj);

	/** @param 比对报警统计表(t_bdbjtj) 删除 */
	int deleteBdbjtj(Bdbjtj bdbjtj);

	/** @param 比对报警统计表(t_bdbjtj) 修改 */
	int updateBdbjtj(Bdbjtj bdbjtj);

	/** @param 比对报警统计表(t_bdbjtj) 查询单条 */
	Bdbjtj getBdbjtj(Bdbjtj bdbjtj);

	/** @param 比对报警统计表(t_bdbjtj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 比对报警统计表(t_bdbjtj) 多条查询 */
	List getListBdbjtj(Bdbjtj bdbjtj);
}
