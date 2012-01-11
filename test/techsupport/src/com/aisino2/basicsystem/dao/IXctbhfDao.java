package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Xctbhf;
import com.aisino2.core.dao.Page;
public interface IXctbhfDao {
	/** @param 协查通报回复(t_xctbhf) 增加 */
	Xctbhf insertXctbhf(Xctbhf xctbhf);

	/** @param 协查通报回复(t_xctbhf) 删除 */
	int deleteXctbhf(Xctbhf xctbhf);

	/** @param 协查通报回复(t_xctbhf) 修改 */
	int updateXctbhf(Xctbhf xctbhf);

	/** @param 协查通报回复(t_xctbhf) 查询单条 */
	Xctbhf getXctbhf(Xctbhf xctbhf);

	/** @param 协查通报回复(t_xctbhf) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 协查通报回复(t_xctbhf) 多条查询 */
	List getListXctbhf(Xctbhf xctbhf);
	
	/** @param 协查通报回复场所(t_xctbhf) 分页查询 */
	Page getcsListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
