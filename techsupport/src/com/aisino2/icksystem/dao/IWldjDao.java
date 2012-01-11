package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Wldj;
public interface IWldjDao {
	/** @param 物流登记信息(t_wldj) 增加 */
	Wldj insertWldj(Wldj wldj);

	/** @param 物流登记信息(t_wldj) 删除 */
	int deleteWldj(Wldj wldj);

	/** @param 物流登记信息(t_wldj) 修改 */
	int updateWldj(Wldj wldj);

	/** @param 物流登记信息(t_wldj) 查询单条 */
	Wldj getWldj(Wldj wldj);

	/** @param 物流登记信息(t_wldj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 物流登记信息(t_wldj) 分页查询 制卡端*/
	Page getListZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 物流登记信息(t_wldj) 分页查询 制卡端台账*/
	Page getListZkdTzForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 物流登记信息(t_wldj) 多条查询 */
	List getListWldj(Wldj wldj);
	
	/**制证中心上传物流登记*/
	Wldj insertWldjWs(Wldj wldj);
}
