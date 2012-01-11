package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Zktjjb;
public interface IZktjjbDao {
	/** @param 制卡统计季报(t_zktjjb) 增加 */
	Zktjjb insertZktjjb(Zktjjb zktjjb);

	/** @param 制卡统计季报(t_zktjjb) 删除 */
	int deleteZktjjb(Zktjjb zktjjb);

	/** @param 制卡统计季报(t_zktjjb) 修改 */
	int updateZktjjb(Zktjjb zktjjb);

	/** @param 制卡统计季报(t_zktjjb) 查询单条 */
	Zktjjb getZktjjb(Zktjjb zktjjb);

	/** @param 制卡统计季报(t_zktjjb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 制卡统计季报(t_zktjjb) 多条查询 */
	List getListZktjjb(Zktjjb zktjjb);
}
