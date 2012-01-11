package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Zktjhjrb;
public interface IZktjhjrbDao {
	/** @param 制卡统计汇总日报(t_zktjhjrb) 增加 */
	Zktjhjrb insertZktjhjrb(Zktjhjrb zktjhjrb);

	/** @param 制卡统计汇总日报(t_zktjhjrb) 删除 */
	int deleteZktjhjrb(Zktjhjrb zktjhjrb);

	/** @param 制卡统计汇总日报(t_zktjhjrb) 修改 */
	int updateZktjhjrb(Zktjhjrb zktjhjrb);

	/** @param 制卡统计汇总日报(t_zktjhjrb) 查询单条 */
	Zktjhjrb getZktjhjrb(Zktjhjrb zktjhjrb);

	/** @param 制卡统计汇总日报(t_zktjhjrb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 制卡统计汇总日报(t_zktjhjrb) 多条查询 */
	List getListZktjhjrb(Zktjhjrb zktjhjrb);
}
