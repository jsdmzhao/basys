package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Clyjxx;
import com.aisino2.core.dao.Page;

public interface IClyjxxService {
	/** @param 车辆预警信息(t_clyjxx) 增加 */
	Clyjxx insertClyjxx(Clyjxx clyjxx);
	
	/** @param 车辆预警信息(t_clyjxx) 增加 superbWhere
	 * 用于有自己的车辆表的行业
	 */
	Clyjxx insertOtherClyjxx(Clyjxx clyjxx, Map paramsMap);

	/** @param 车辆预警信息(t_clyjxx) 删除 */
	boolean deleteClyjxx(Clyjxx clyjxx);

	/** @param 车辆预警信息(t_clyjxx) 修改 */
	boolean updateClyjxx(Clyjxx clyjxx);

	/** @param 车辆预警信息(t_clyjxx) 查询单条 */
	Clyjxx getClyjxx(Clyjxx clyjxx);

	/** @param 车辆预警信息(t_clyjxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 车辆预警信息(t_clyjxx) 多条查询 */
	List getListClyjxx(Clyjxx clyjxx);
}
