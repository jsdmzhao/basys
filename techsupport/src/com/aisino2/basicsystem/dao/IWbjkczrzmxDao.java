package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Wbjkczrzmx;
import com.aisino2.core.dao.Page;
public interface IWbjkczrzmxDao {
	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 增加 */
	Wbjkczrzmx insertWbjkczrzmx(Wbjkczrzmx wbjkczrzmx);

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 删除 */
	int deleteWbjkczrzmx(Wbjkczrzmx wbjkczrzmx);

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 修改 */
	int updateWbjkczrzmx(Wbjkczrzmx wbjkczrzmx);

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 查询单条 */
	Wbjkczrzmx getWbjkczrzmx(Wbjkczrzmx wbjkczrzmx);

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) 多条查询 */
	List getListWbjkczrzmx(Wbjkczrzmx wbjkczrzmx);
}
