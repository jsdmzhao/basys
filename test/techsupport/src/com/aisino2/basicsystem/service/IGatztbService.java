package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Gatztb;
import com.aisino2.core.dao.Page;

public interface IGatztbService {
	/** @param 公安通知通报(t_gatztb) 增加 */
	Gatztb insertGatztb(Gatztb gatztb);

	/** @param 公安通知通报(t_gatztb) 删除 */
	boolean deleteGatztb(Gatztb gatztb);

	/** @param 公安通知通报(t_gatztb) 修改 */
	boolean updateGatztb(Gatztb gatztb);

	/** @param 公安通知通报(t_gatztb) 查询单条 */
	Gatztb getGatztb(Gatztb gatztb);

	/** @param 公安通知通报(t_gatztb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 公安通知通报(t_gatztb) 多条查询 */
	List getListGatztb(Gatztb gatztb);
}
