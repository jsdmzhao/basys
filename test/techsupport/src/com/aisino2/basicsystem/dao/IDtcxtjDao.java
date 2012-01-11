package com.aisino2.basicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Dtcxtj;
import com.aisino2.core.dao.Page;
public interface IDtcxtjDao {
	/** @param 动态查询条件(t_dtcxtj) 增加 */
	Dtcxtj insertDtcxtj(Dtcxtj dtcxtj);

	/** @param 动态查询条件(t_dtcxtj) 删除 */
	int deleteDtcxtj(Dtcxtj dtcxtj);

	/** @param 动态查询条件(t_dtcxtj) 修改 */
	int updateDtcxtj(Dtcxtj dtcxtj);

	/** @param 动态查询条件(t_dtcxtj) 查询单条 */
	Dtcxtj getDtcxtj(Dtcxtj dtcxtj);

	/** @param 动态查询条件(t_dtcxtj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 动态查询条件(t_dtcxtj) 多条查询 */
	List getListDtcxtj(Dtcxtj dtcxtj);
}
