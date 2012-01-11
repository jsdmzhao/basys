package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyffl;

public interface IQyfflService {
	/** @param 企业副分类(t_qyffl) 增加 */
	Qyffl insertQyffl(Qyffl qyffl);

	/** @param 企业副分类(t_qyffl) 删除 */
	boolean deleteQyffl(Qyffl qyffl);

	/** @param 企业副分类(t_qyffl) 修改 */
	boolean updateQyffl(Qyffl qyffl);

	/** @param 企业副分类(t_qyffl) 查询单条 */
	Qyffl getQyffl(Qyffl qyffl);

	/** @param 企业副分类(t_qyffl) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业副分类(t_qyffl) 多条查询 */
	List getListQyffl(Qyffl qyffl);
}
