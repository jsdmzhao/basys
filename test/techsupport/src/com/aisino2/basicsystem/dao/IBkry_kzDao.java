package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bkry_kz;
import com.aisino2.core.dao.Page;
public interface IBkry_kzDao {
	/** @param 布控人员快照(t_bkry_kz) 增加 */
	Bkry_kz insertBkry_kz(Bkry_kz bkry_kz);

	/** @param 布控人员快照(t_bkry_kz) 删除 */
	int deleteBkry_kz(Bkry_kz bkry_kz);

	/** @param 布控人员快照(t_bkry_kz) 修改 */
	int updateBkry_kz(Bkry_kz bkry_kz);

	/** @param 布控人员快照(t_bkry_kz) 查询单条 */
	Bkry_kz getBkry_kz(Bkry_kz bkry_kz);

	/** @param 布控人员快照(t_bkry_kz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 布控人员快照(t_bkry_kz) 多条查询 */
	List getListBkry_kz(Bkry_kz bkry_kz);
}
