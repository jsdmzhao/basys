package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Dxbj;
import com.aisino2.core.dao.Page;
public interface IDxbjDao {
	/** @param 短信报警(t_dxbj) 增加 */
	Dxbj insertDxbj(Dxbj dxbj);

	/** @param 短信报警(t_dxbj) 删除 */
	int deleteDxbj(Dxbj dxbj);

	/** @param 短信报警(t_dxbj) 修改 */
	int updateDxbj(Dxbj dxbj);

	/** @param 短信报警(t_dxbj) 查询单条 */
	Dxbj getDxbj(Dxbj dxbj);

	/** @param 短信报警(t_dxbj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 短信报警(t_dxbj) 多条查询 */
	List getListDxbj(Dxbj dxbj);
}
