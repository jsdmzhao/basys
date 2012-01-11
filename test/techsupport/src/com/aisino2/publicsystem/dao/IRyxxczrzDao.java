package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Ryxxczrz;
public interface IRyxxczrzDao {
	/** @param 人员信息操作日志(t_ryxxczrz) 增加 */
	Ryxxczrz insertRyxxczrz(Ryxxczrz ryxxczrz);

	/** @param 人员信息操作日志(t_ryxxczrz) 删除 */
	int deleteRyxxczrz(Ryxxczrz ryxxczrz);

	/** @param 人员信息操作日志(t_ryxxczrz) 修改 */
	int updateRyxxczrz(Ryxxczrz ryxxczrz);

	/** @param 人员信息操作日志(t_ryxxczrz) 查询单条 */
	Ryxxczrz getRyxxczrz(Ryxxczrz ryxxczrz);

	/** @param 人员信息操作日志(t_ryxxczrz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 人员信息操作日志(t_ryxxczrz) 多条查询 */
	List getListRyxxczrz(Ryxxczrz ryxxczrz);
}
