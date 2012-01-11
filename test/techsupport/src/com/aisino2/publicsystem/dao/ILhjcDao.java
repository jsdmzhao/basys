package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Lhjc;
public interface ILhjcDao {
	/** @param 联合检查(t_lhjc) 增加 */
	Lhjc insertLhjc(Lhjc lhjc);

	/** @param 联合检查(t_lhjc) 删除 */
	int deleteLhjc(Lhjc lhjc);

	/** @param 联合检查(t_lhjc) 修改 */
	int updateLhjc(Lhjc lhjc);

	/** @param 联合检查(t_lhjc) 查询单条 */
	Lhjc getLhjc(Lhjc lhjc);

	/** @param 联合检查(t_lhjc) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 联合检查(t_lhjc) 多条查询 */
	List getListLhjc(Lhjc lhjc);
}
