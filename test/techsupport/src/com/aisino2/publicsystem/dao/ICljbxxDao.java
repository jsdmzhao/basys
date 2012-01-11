package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Cljbxx;
public interface ICljbxxDao {
	/** @param 车辆基本信息(t_cljbxx) 增加 */
	Cljbxx insertCljbxx(Cljbxx cljbxx);

	/** @param 车辆基本信息(t_cljbxx) 删除 */
	int deleteCljbxx(Cljbxx cljbxx);

	/** @param 车辆基本信息(t_cljbxx) 修改 */
	int updateCljbxx(Cljbxx cljbxx);

	/** @param 车辆基本信息(t_cljbxx) 查询单条 */
	Cljbxx getCljbxx(Cljbxx cljbxx);

	/** @param 车辆基本信息(t_cljbxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 车辆基本信息(t_cljbxx) 多条查询 */
	List getListCljbxx(Cljbxx cljbxx);
	
	/** @param 检测车辆是否可用 */
	Integer jianChaClsfky(Cljbxx cljbxx);

	/** @param 车辆基本信息(t_cljbxx) 分页查询筛选框 */
	Page getSelListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
