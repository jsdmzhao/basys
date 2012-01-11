package com.aisino2.icksystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Ickrzjl;

public interface IIckrzjlService {
	/** @param IC卡日志记录(t_ickrzjl) 增加 */
	Ickrzjl insertIckrzjl(Ickrzjl ickrzjl);

	/** @param IC卡日志记录(t_ickrzjl) 删除 */
	boolean deleteIckrzjl(Ickrzjl ickrzjl);

	/** @param IC卡日志记录(t_ickrzjl) 修改 */
	boolean updateIckrzjl(Ickrzjl ickrzjl);

	/** @param IC卡日志记录(t_ickrzjl) 查询单条 */
	Ickrzjl getIckrzjl(Ickrzjl ickrzjl);

	/** @param IC卡日志记录(t_ickrzjl) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param IC卡日志记录(t_ickrzjl) 多条查询 */
	List getListIckrzjl(Ickrzjl ickrzjl);
}
