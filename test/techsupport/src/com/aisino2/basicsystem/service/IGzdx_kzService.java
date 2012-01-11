package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Gzdx_kz;
import com.aisino2.core.dao.Page;

public interface IGzdx_kzService {
	/** @param 关注对象快照(t_gzdx_kz) 增加 */
	Gzdx_kz insertGzdx_kz(Gzdx_kz gzdx_kz);
	
	/** @param 关注对象快照(t_gzdx_kz)比对报警 增加 */
	Gzdx_kz insertGzdx_kzBDBJ(Gzdx_kz gzdx_kz);

	/** @param 关注对象快照(t_gzdx_kz) 删除 */
	boolean deleteGzdx_kz(Gzdx_kz gzdx_kz);

	/** @param 关注对象快照(t_gzdx_kz) 修改 */
	boolean updateGzdx_kz(Gzdx_kz gzdx_kz);

	/** @param 关注对象快照(t_gzdx_kz) 查询单条 */
	Gzdx_kz getGzdx_kz(Gzdx_kz gzdx_kz);

	/** @param 关注对象快照(t_gzdx_kz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 关注对象快照(t_gzdx_kz) 多条查询 */
	List getListGzdx_kz(Gzdx_kz gzdx_kz);
}
