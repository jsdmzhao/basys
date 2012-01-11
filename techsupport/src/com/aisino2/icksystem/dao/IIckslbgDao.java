package com.aisino2.icksystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Ickslbg;
public interface IIckslbgDao {
	/** @param IC卡受理变更(t_ickslbg) 增加 */
	Ickslbg insertIckslbg(Ickslbg ickslbg);

	/** @param IC卡受理变更(t_ickslbg) 删除 */
	int deleteIckslbg(Ickslbg ickslbg);

	/** @param IC卡受理变更(t_ickslbg) 修改 */
	int updateIckslbg(Ickslbg ickslbg);

	/** @param IC卡受理变更(t_ickslbg) 查询单条 */
	Ickslbg getIckslbg(Ickslbg ickslbg);

	/** @param IC卡受理变更(t_ickslbg) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param IC卡受理变更(t_ickslbg) 多条查询 */
	List getListIckslbg(Ickslbg ickslbg);
}
