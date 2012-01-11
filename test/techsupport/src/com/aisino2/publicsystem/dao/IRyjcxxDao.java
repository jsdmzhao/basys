package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Ryjcxx;
public interface IRyjcxxDao {
	/** @param 人员奖惩信息(t_ryjcxx) 增加 */
	Ryjcxx insertRyjcxx(Ryjcxx ryjcxx);

	/** @param 人员奖惩信息(t_ryjcxx) 删除 */
	int deleteRyjcxx(Ryjcxx ryjcxx);

	/** @param 人员奖惩信息(t_ryjcxx) 修改 */
	int updateRyjcxx(Ryjcxx ryjcxx);

	/** @param 人员奖惩信息(t_ryjcxx) 查询单条 */
	Ryjcxx getRyjcxx(Ryjcxx ryjcxx);

	/** @param 人员奖惩信息(t_ryjcxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 人员奖惩信息(t_ryjcxx) 多条查询 */
	List getListRyjcxx(Ryjcxx ryjcxx);
	
	/** @param 人员处罚信息中从业人员的(t_rycfxx) 分页查询 */
	Page getRyListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
