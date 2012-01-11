package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Qycftj;
import com.aisino2.core.dao.Page;
public interface IQycftjDao {
	/** @param 企业处罚统计表(t_qycftj) 增加 */
	Qycftj insertQycftj(Qycftj qycftj);

	/** @param 企业处罚统计表(t_qycftj) 删除 */
	int deleteQycftj(Qycftj qycftj);

	/** @param 企业处罚统计表(t_qycftj) 修改 */
	int updateQycftj(Qycftj qycftj);

	/** @param 企业处罚统计表(t_qycftj) 查询单条 */
	Qycftj getQycftj(Qycftj qycftj);

	/** @param 企业处罚统计表(t_qycftj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业处罚统计表(t_qycftj) 多条查询 */
	List getListQycftj(Qycftj qycftj);
	
	
	Page getListForPageAlldw(Map map, int pageNo,int pageSize,String sort,String desc);
	/**
	 * 企业处罚统计 用到接口
	 * @param map
	 * @return
	 */
	Qycftj getQycftjTotalNum(Map map);
	
	/** @param 企业处罚统计表(t_qycftj) 分页查询--标准号 */
	Page getListForPageBzh(Map map, int pageNo,int pageSize,String sort,String desc);
}
