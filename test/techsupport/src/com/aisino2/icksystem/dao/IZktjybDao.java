package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Zktjyb;
public interface IZktjybDao {
	/** @param 制卡统计月报(t_zktjyb) 增加 */
	Zktjyb insertZktjyb(Zktjyb zktjyb);

	/** @param 制卡统计月报(t_zktjyb) 删除 */
	int deleteZktjyb(Zktjyb zktjyb);

	/** @param 制卡统计月报(t_zktjyb) 修改 */
	int updateZktjyb(Zktjyb zktjyb);

	/** @param 制卡统计月报(t_zktjyb) 查询单条 */
	Zktjyb getZktjyb(Zktjyb zktjyb);

	/** @param 制卡统计月报(t_zktjyb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 制卡统计月报(t_zktjyb) 多条查询 */
	List getListZktjyb(Zktjyb zktjyb);
}
