package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Rcjc;
public interface IRcjcDao {
	/** @param 日常检查(t_rcjc) 增加 */
	Rcjc insertRcjc(Rcjc rcjc);

	/** @param 日常检查(t_rcjc) 删除 */
	int deleteRcjc(Rcjc rcjc);

	/** @param 日常检查(t_rcjc) 修改 */
	int updateRcjc(Rcjc rcjc);

	/** @param 日常检查(t_rcjc) 查询单条 */
	Rcjc getRcjc(Rcjc rcjc);

	/** @param 日常检查(t_rcjc) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 日常检查(t_rcjc) 多条查询 */
	List getListRcjc(Rcjc rcjc);
	
	/** @param 日常检查统计(t_rcjc) 分页查询 */
	Page getTjListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 日常检查统计详细(t_rcjc) 分页查询 */
	Page getTjxxListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 日常检查异常预警(t_rcjc) 分页查询 */
	Page getRcjcycyjListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
