package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Garkktbsj;

public interface IGarkktbsjService {
	/** @param 公安人口库同步数据(t_garkktbsj) 增加 */
	Garkktbsj insertGarkktbsj(Garkktbsj garkktbsj);

	/** @param 公安人口库同步数据(t_garkktbsj) 删除 */
	boolean deleteGarkktbsj(Garkktbsj garkktbsj);

	/** @param 公安人口库同步数据(t_garkktbsj) 修改 */
	boolean updateGarkktbsj(Garkktbsj garkktbsj);

	/** @param 公安人口库同步数据(t_garkktbsj) 查询单条 */
	Garkktbsj getGarkktbsj(Garkktbsj garkktbsj);

	/** @param 公安人口库同步数据(t_garkktbsj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 公安人口库同步数据(t_garkktbsj) 多条查询 */
	List getListGarkktbsj(Garkktbsj garkktbsj);
}
