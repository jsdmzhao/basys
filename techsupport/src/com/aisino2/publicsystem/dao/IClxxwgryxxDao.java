package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Clxxwgryxx;
public interface IClxxwgryxxDao {
	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 增加 */
	Clxxwgryxx insertClxxwgryxx(Clxxwgryxx clxxwgryxx);

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 删除 */
	int deleteClxxwgryxx(Clxxwgryxx clxxwgryxx);

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 修改 */
	int updateClxxwgryxx(Clxxwgryxx clxxwgryxx);

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 查询单条 */
	Clxxwgryxx getClxxwgryxx(Clxxwgryxx clxxwgryxx);

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 车辆信息外国人员信息(t_clxxwgryxx) 多条查询 */
	List getListClxxwgryxx(Clxxwgryxx clxxwgryxx);
}
