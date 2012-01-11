package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Bjgz;
import com.aisino2.core.dao.Page;
public interface IBjgzDao {
	/** @param 报警规则(t_bjgz) 增加 */
	Bjgz insertBjgz(Bjgz bjgz);

	/** @param 报警规则(t_bjgz) 删除 */
	int deleteBjgz(Bjgz bjgz);

	/** @param 报警规则(t_bjgz) 修改 */
	int updateBjgz(Bjgz bjgz);

	/** @param 报警规则(t_bjgz) 查询单条 */
	Bjgz getBjgz(Bjgz bjgz);

	/** @param 报警规则(t_bjgz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 报警规则(t_bjgz) 多条查询 */
	List getListBjgz(Bjgz bjgz);
}
