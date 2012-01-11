package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyzjb;

public interface IQyzjbService {
	/** @param 企业证件表(t_qyzjb) 增加 */
	Qyzjb insertQyzjb(Qyzjb qyzjb);

	/** @param 企业证件表(t_qyzjb) 删除 */
	boolean deleteQyzjb(Qyzjb qyzjb);

	/** @param 企业证件表(t_qyzjb) 修改 */
	boolean updateQyzjb(Qyzjb qyzjb);

	/** @param 企业证件表(t_qyzjb) 查询单条 */
	Qyzjb getQyzjb(Qyzjb qyzjb);

	/** @param 企业证件表(t_qyzjb) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业证件表(t_qyzjb) 多条查询 */
	List getListQyzjb(Qyzjb qyzjb);
}
