package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Qycf;
import com.aisino2.core.dao.Page;
public interface IQycfDao {
	/** @param 企业处罚(t_qycf) 增加 */
	Qycf insertQycf(Qycf qycf);

	/** @param 企业处罚(t_qycf) 删除 */
	int deleteQycf(Qycf qycf);

	/** @param 企业处罚(t_qycf) 修改 */
	int updateQycf(Qycf qycf);

	/** @param 企业处罚(t_qycf) 查询单条 */
	Qycf getQycf(Qycf qycf);

	/** @param 企业处罚(t_qycf) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业处罚(t_qycf) 多条查询 */
	List getListQycf(Qycf qycf);

	List getListExportQycf(Map map, String sort, String desc);
}
