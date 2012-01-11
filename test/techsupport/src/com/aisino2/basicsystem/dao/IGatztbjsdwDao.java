package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Gatztbjsdw;
import com.aisino2.core.dao.Page;
public interface IGatztbjsdwDao {
	/** @param 公安通知通报接收单位(t_gatztbjsdw) 增加 */
	Gatztbjsdw insertGatztbjsdw(Gatztbjsdw gatztbjsdw);

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 删除 */
	int deleteGatztbjsdw(Gatztbjsdw gatztbjsdw);

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 修改 */
	int updateGatztbjsdw(Gatztbjsdw gatztbjsdw);

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 查询单条 */
	Gatztbjsdw getGatztbjsdw(Gatztbjsdw gatztbjsdw);

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 公安通知通报接收单位(t_gatztbjsdw) 多条查询 */
	List getListGatztbjsdw(Gatztbjsdw gatztbjsdw);
}
