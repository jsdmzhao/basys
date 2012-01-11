package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.TyRcjc;
import com.aisino2.core.dao.Page;

public interface IRcjcService {
	/** @param 日常检查(t_rcjc) 增加 */
	TyRcjc insertRcjc(TyRcjc rcjc);

	/** @param 日常检查(t_rcjc) 删除 */
	boolean deleteRcjc(TyRcjc rcjc);

	/** @param 日常检查(t_rcjc) 修改 */
	boolean updateRcjc(TyRcjc rcjc);

	/** @param 日常检查(t_rcjc) 查询单条 */
	TyRcjc getRcjc(TyRcjc rcjc);

	/** @param 日常检查(t_rcjc) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 日常检查(t_rcjc) 多条查询 */
	List getListRcjc(TyRcjc rcjc);
}
