package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Pmt;

public interface IPmtService {
	/** @param 平面图(t_pmt) 增加 */
	Pmt insertPmt(Pmt pmt);

	/** @param 平面图(t_pmt) 删除 */
	boolean deletePmt(Pmt pmt);

	/** @param 平面图(t_pmt) 修改 */
	boolean updatePmt(Pmt pmt);

	/** @param 平面图(t_pmt) 查询单条 */
	Pmt getPmt(Pmt pmt);

	/** @param 平面图(t_pmt) 查询单条 不查询BLOB*/
	Pmt getPmtNoBlob(Pmt pmt);
	
	/** @param 平面图(t_pmt) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 平面图(t_pmt) 多条查询 */
	List getListPmt(Pmt pmt);
}
