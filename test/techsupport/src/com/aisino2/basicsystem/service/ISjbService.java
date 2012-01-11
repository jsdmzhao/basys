package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Sjb;
import com.aisino2.core.dao.Page;

public interface ISjbService {
	/** @param 数据表(t_sjb) 增加 */
	Sjb insertSjb(Sjb sjb);

	/** @param 数据表(t_sjb) 删除 */
	boolean deleteSjb(Sjb sjb);

	/** @param 数据表(t_sjb) 修改 */
	boolean updateSjb(Sjb sjb);

	/** @param 数据表(t_sjb) 查询单条 */
	Sjb getSjb(Sjb sjb);

	/** @param 数据表(t_sjb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 数据表(t_sjb) 多条查询 */
	List getListSjb(Sjb sjb);
}
