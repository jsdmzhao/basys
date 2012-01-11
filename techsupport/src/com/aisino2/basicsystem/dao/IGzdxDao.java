package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Gzdx;
import com.aisino2.core.dao.Page;
public interface IGzdxDao {
	/** @param 关注对象(t_gzdx) 增加 */
	Gzdx insertGzdx(Gzdx gzdx);

	/** @param 关注对象(t_gzdx) 删除 */
	int deleteGzdx(Gzdx gzdx);

	/** @param 关注对象(t_gzdx) 修改 */
	int updateGzdx(Gzdx gzdx);

	/** @param 关注对象(t_gzdx) 查询单条 */
	Gzdx getGzdx(Gzdx gzdx);

	/** @param 关注对象(t_gzdx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 关注对象(t_gzdx) 多条查询 */
	List getListGzdx(Gzdx gzdx);
	
	List validateZjhm(Gzdx gzdx);

	List getListExportGzdx(Map map, String sort, String dir);
}
