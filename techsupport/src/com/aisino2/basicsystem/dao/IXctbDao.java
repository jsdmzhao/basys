package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Xctb;
import com.aisino2.core.dao.Page;
public interface IXctbDao {
	/** @param 协查通报(t_xctb) 增加 */
	Xctb insertXctb(Xctb xctb);

	/** @param 协查通报(t_xctb) 删除 */
	int deleteXctb(Xctb xctb);

	/** @param 协查通报(t_xctb) 修改 */
	int updateXctb(Xctb xctb);

	/** @param 协查通报(t_xctb) 查询单条 */
	Xctb getXctb(Xctb xctb);

	/** @param 协查通报(t_xctb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 协查通报(t_xctb) 多条查询 */
	List getListXctb(Xctb xctb);
	
	/** @param 协查通报(t_xctb) 多条查询 */
	List getXctbListForBt(Map map);
	
	/** @param 协查通报(t_xctb) 多条查询 查询未阅读的协查通报*/
	List getXctbWydList(Xctb xctb);
	
	/** @param 协查通报场所(t_xctb) 分页查询 */
	Page getcsListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 协查通报企业单位(t_xctb) 分页查询 */
	Page getQydwListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 协查通报企业单位(t_xctb) 列表查询 */
	List getQydwList(Map map);
}
