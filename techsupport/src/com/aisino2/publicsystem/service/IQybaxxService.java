package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qybaxx;

public interface IQybaxxService {
	/** @param 企业备案信息(t_qybaxx) 增加 */
	Qybaxx insertQybaxx(Qybaxx qybaxx);

	/** @param 企业备案信息(t_qybaxx) 删除 */
	boolean deleteQybaxx(Qybaxx qybaxx);

	/** @param 企业备案信息(t_qybaxx) 修改 */
	boolean updateQybaxx(Qybaxx qybaxx);

	/** @param 企业备案信息(t_qybaxx) 查询单条 */
	Qybaxx getQybaxx(Qybaxx qybaxx);

	/** @param 企业备案信息(t_qybaxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业备案信息(t_qybaxx) 多条查询 */
	List getListQybaxx(Qybaxx qybaxx);
	/** @param 企业基本信息(t_ylcsjbxx) 分页查询 企业备案查询*/
	Page getListForPageCsba(Map map, int pageNo,int pageSize,String sort,String desc);
}
