package com.aisino2.sysadmin.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Operatelog;
public interface IOperatelogDao {
	/** @param 操作日志表(t_operatelog) 增加 */
	Operatelog insertOperatelog(Operatelog operatelog);

	/** @param 操作日志表(t_operatelog) 删除 */
	int deleteOperatelog(Operatelog operatelog);

	/** @param 操作日志表(t_operatelog) 修改 */
	int updateOperatelog(Operatelog operatelog);

	/** @param 操作日志表(t_operatelog) 查询单条 */
	Operatelog getOperatelog(Operatelog operatelog);

	/** @param 操作日志表(t_operatelog) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 操作日志表(t_operatelog) 多条查询 */
	List getListOperatelog(Operatelog operatelog);
}
