package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qybcbaxx;

public interface IQybcbaxxService {
	/** @param 企业补充备案信息(t_qybcbaxx) 增加 */
	Qybcbaxx insertQybcbaxx(Qybcbaxx qybcbaxx);

	/** @param 企业补充备案信息(t_qybcbaxx) 删除 */
	boolean deleteQybcbaxx(Qybcbaxx qybcbaxx);

	/** @param 企业补充备案信息(t_qybcbaxx) 修改 */
	boolean updateQybcbaxx(Qybcbaxx qybcbaxx);

	/** @param 企业补充备案信息(t_qybcbaxx) 查询单条 */
	Qybcbaxx getQybcbaxx(Qybcbaxx qybcbaxx);

	/** @param 企业补充备案信息(t_qybcbaxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业补充备案信息(t_qybcbaxx) 多条查询 */
	List getListQybcbaxx(Qybcbaxx qybcbaxx);
}
