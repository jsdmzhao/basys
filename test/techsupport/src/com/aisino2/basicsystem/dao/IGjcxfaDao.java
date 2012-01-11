package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Gjcxfa;
import com.aisino2.core.dao.Page;
public interface IGjcxfaDao {
	/** @param 高级查询方案(t_gjcxfa) 增加 */
	Gjcxfa insertGjcxfa(Gjcxfa gjcxfa);

	/** @param 高级查询方案(t_gjcxfa) 删除 */
	int deleteGjcxfa(Gjcxfa gjcxfa);

	/** @param 高级查询方案(t_gjcxfa) 修改 */
	int updateGjcxfa(Gjcxfa gjcxfa);
	/** 
	 * @param 高级查询方案(t_gjcxfa) 修改方案名称
	 */
	int updateGjcxfamc(Gjcxfa gjcxfa);
	/** @param 高级查询方案(t_gjcxfa) 查询单条 */
	Gjcxfa getGjcxfa(Gjcxfa gjcxfa);

	/** @param 高级查询方案(t_gjcxfa) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 高级查询方案(t_gjcxfa) 多条查询 */
	List getListGjcxfa(Gjcxfa gjcxfa);
}
