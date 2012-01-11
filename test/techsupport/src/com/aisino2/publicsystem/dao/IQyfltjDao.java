package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyfltj;
public interface IQyfltjDao {
	/** @param 企业分类统计(t_qyfltj) 增加 */
	Qyfltj insertQyfltj(Qyfltj qyfltj);

	/** @param 企业分类统计(t_qyfltj) 删除 */
	int deleteQyfltj(Qyfltj qyfltj);

	/** @param 企业分类统计(t_qyfltj) 修改 */
	int updateQyfltj(Qyfltj qyfltj);

	/** @param 企业分类统计(t_qyfltj) 查询单条 */
	Qyfltj getQyfltj(Qyfltj qyfltj);

	/** @param 企业分类统计(t_qyfltj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业分类统计(t_qyfltj) 多条查询 */
	List getListQyfltj(Qyfltj qyfltj);
	
	/** @param 企业分类统计(t_qyfltj) 信息采集 */
	Page getListForPageQY(Map map, int pageNo,int pageSize,String sort,String desc);
}
