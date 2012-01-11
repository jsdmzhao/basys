package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Icksl_wldj;
public interface IIcksl_wldjDao {
	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 增加 */
	Icksl_wldj insertIcksl_wldj(Icksl_wldj icksl_wldj);

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 删除 */
	int deleteIcksl_wldj(Icksl_wldj icksl_wldj);

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 修改 */
	int updateIcksl_wldj(Icksl_wldj icksl_wldj);

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 查询单条 */
	Icksl_wldj getIcksl_wldj(Icksl_wldj icksl_wldj);

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) 多条查询 */
	List getListIcksl_wldj(Icksl_wldj icksl_wldj);
}
