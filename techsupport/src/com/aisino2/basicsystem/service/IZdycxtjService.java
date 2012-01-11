package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Zdycxtj;
import com.aisino2.core.dao.Page;

public interface IZdycxtjService {
	/** @param 自定义查询条件(t_zdycxtj) 增加 */
	Zdycxtj insertZdycxtj(Zdycxtj zdycxtj);

	/** @param 自定义查询条件(t_zdycxtj) 删除 */
	boolean deleteZdycxtj(Zdycxtj zdycxtj);

	/** @param 自定义查询条件(t_zdycxtj) 修改 */
	boolean updateZdycxtj(Zdycxtj zdycxtj);

	/** @param 自定义查询条件(t_zdycxtj) 查询单条 */
	Zdycxtj getZdycxtj(Zdycxtj zdycxtj);

	/** @param 自定义查询条件(t_zdycxtj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 自定义查询条件(t_zdycxtj) 多条查询 */
	List getListZdycxtj(Zdycxtj zdycxtj);
}
