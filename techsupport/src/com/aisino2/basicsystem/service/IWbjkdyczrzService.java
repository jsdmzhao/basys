package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Wbjkdyczrz;
import com.aisino2.core.dao.Page;

public interface IWbjkdyczrzService {
	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 增加 */
	Wbjkdyczrz insertWbjkdyczrz(Wbjkdyczrz wbjkdyczrz);

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 删除 */
	boolean deleteWbjkdyczrz(Wbjkdyczrz wbjkdyczrz);

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 修改 */
	boolean updateWbjkdyczrz(Wbjkdyczrz wbjkdyczrz);

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 查询单条 */
	Wbjkdyczrz getWbjkdyczrz(Wbjkdyczrz wbjkdyczrz);

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 外部接口调用操作日志(t_wbjkdyczrz) 多条查询 */
	List getListWbjkdyczrz(Wbjkdyczrz wbjkdyczrz);
}
