package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Icksl_lsb;
public interface IIcksl_lsbDao {
	/** @param IC卡受理临时表(t_icksl_lsb) 增加 */
	Icksl_lsb insertIcksl_lsb(Icksl_lsb icksl_lsb);

	/** @param IC卡受理临时表(t_icksl_lsb) 删除 */
	int deleteIcksl_lsb(Icksl_lsb icksl_lsb);

	/** @param IC卡受理临时表(t_icksl_lsb) 修改 */
	int updateIcksl_lsb(Icksl_lsb icksl_lsb);

	/** @param IC卡受理临时表(t_icksl_lsb) 查询单条 */
	Icksl_lsb getIcksl_lsb(Icksl_lsb icksl_lsb);

	/** @param IC卡受理临时表(t_icksl_lsb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param IC卡受理临时表(t_icksl_lsb) 多条查询 */
	List getListIcksl_lsb(Icksl_lsb icksl_lsb);
}
