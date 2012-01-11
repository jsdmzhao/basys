package com.aisino2.icksystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Cjdtjrb;

public interface ICjdtjrbService {
	/** @param 采集端统计日报(t_cjdtjrb) 增加 */
	Cjdtjrb insertCjdtjrb(Cjdtjrb cjdtjrb);

	/** @param 采集端统计日报(t_cjdtjrb) 删除 */
	boolean deleteCjdtjrb(Cjdtjrb cjdtjrb);

	/** @param 采集端统计日报(t_cjdtjrb) 修改 */
	boolean updateCjdtjrb(Cjdtjrb cjdtjrb);

	/** @param 采集端统计日报(t_cjdtjrb) 查询单条 */
	Cjdtjrb getCjdtjrb(Cjdtjrb cjdtjrb);

	/** @param 采集端统计日报(t_cjdtjrb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 采集端统计日报-企业端(t_cjdtjrb) 分页查询 */
	Page getListForPageQyd(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 采集端统计日报(t_cjdtjrb) 多条查询 */
	List getListCjdtjrb(Cjdtjrb cjdtjrb);
	/** @param 采集端日报(t_cjdtjrb) 分页查询 */
	Page getCjdrbListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
