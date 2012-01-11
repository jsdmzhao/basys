package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyxxczrz;
public interface IQyxxczrzDao {
	/** @param 企业信息操作日志(t_qyxxczrz) 增加 */
	Qyxxczrz insertQyxxczrz(Qyxxczrz qyxxczrz);

	/** @param 企业信息操作日志(t_qyxxczrz) 删除 */
	int deleteQyxxczrz(Qyxxczrz qyxxczrz);

	/** @param 企业信息操作日志(t_qyxxczrz) 修改 */
	int updateQyxxczrz(Qyxxczrz qyxxczrz);

	/** @param 企业信息操作日志(t_qyxxczrz) 查询单条 */
	Qyxxczrz getQyxxczrz(Qyxxczrz qyxxczrz);

	/** @param 企业信息操作日志(t_qyxxczrz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业信息操作日志(t_qyxxczrz) 多条查询 */
	List getListQyxxczrz(Qyxxczrz qyxxczrz);
}
