package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bksjkz;
import com.aisino2.core.dao.Page;
public interface IBksjkzDao {
	/** @param 布控手机快照(t_bksjkz) 增加 */
	Bksjkz insertBksjkz(Bksjkz bksjkz);

	/** @param 布控手机快照(t_bksjkz) 删除 */
	int deleteBksjkz(Bksjkz bksjkz);

	/** @param 布控手机快照(t_bksjkz) 修改 */
	int updateBksjkz(Bksjkz bksjkz);

	/** @param 布控手机快照(t_bksjkz) 查询单条 */
	Bksjkz getBksjkz(Bksjkz bksjkz);

	/** @param 布控手机快照(t_bksjkz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 布控手机快照(t_bksjkz) 多条查询 */
	List getListBksjkz(Bksjkz bksjkz);
}
