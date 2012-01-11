package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Zjb_ls;
public interface IZjb_lsDao {
	/** @param 证件历史表(t_zjb_ls) 增加 */
	Zjb_ls insertZjb_ls(Zjb_ls zjb_ls);

	/** @param 证件历史表(t_zjb_ls) 删除 */
	int deleteZjb_ls(Zjb_ls zjb_ls);

	/** @param 证件历史表(t_zjb_ls) 修改 */
	int updateZjb_ls(Zjb_ls zjb_ls);

	/** @param 证件历史表(t_zjb_ls) 查询单条 */
	Zjb_ls getZjb_ls(Zjb_ls zjb_ls);

	/** @param 证件历史表(t_zjb_ls) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 证件历史表(t_zjb_ls) 多条查询 */
	List getListZjb_ls(Zjb_ls zjb_ls);
}
