package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qybgxx;

public interface IQybgxxService {
	/** @param 企业变更信息(t_qybgxx) 增加 */
	Qybgxx insertQybgxx(Qybgxx qybgxx);

	/** @param 企业变更信息(t_qybgxx) 删除 */
	boolean deleteQybgxx(Qybgxx qybgxx);

	/** @param 企业变更信息(t_qybgxx) 修改 */
	boolean updateQybgxx(Qybgxx qybgxx);

	/** @param 企业变更信息(t_qybgxx) 查询单条 */
	Qybgxx getQybgxx(Qybgxx qybgxx);

	/** @param 企业变更信息(t_qybgxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业变更信息(t_qybgxx) 多条查询 */
	List getListQybgxx(Qybgxx qybgxx);
}
