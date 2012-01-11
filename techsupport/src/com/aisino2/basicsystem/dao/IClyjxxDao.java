package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Clyjxx;
import com.aisino2.core.dao.Page;
public interface IClyjxxDao {
	/** @param 车辆预警信息(t_clyjxx) 增加 */
	Clyjxx insertClyjxx(Clyjxx clyjxx);

	/** @param 车辆预警信息(t_clyjxx) 删除 */
	int deleteClyjxx(Clyjxx clyjxx);

	/** @param 车辆预警信息(t_clyjxx) 修改 */
	int updateClyjxx(Clyjxx clyjxx);

	/** @param 车辆预警信息(t_clyjxx) 查询单条 */
	Clyjxx getClyjxx(Clyjxx clyjxx);

	/** @param 车辆预警信息(t_clyjxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 车辆预警信息(t_clyjxx) 多条查询 */
	List getListClyjxx(Clyjxx clyjxx);

	/** @param 检查车辆是否存在预警 */
	Integer checkOtherYjxxExist(Map map);

	/** @param 检查车辆是否存在(汽车租赁行业中)
	 * 返回clyjxx列表
	 * clyjxx包含值:byjclid,byjclhylbbm,byjclhylb
	 *  */
	List checkClxxExist(Map map);
	
}
