package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qysh;

public interface IQyshService {
	/** @param 企业审核(t_qysh) 增加 */
	Qysh insertQysh(Qysh qysh);

	/** @param 企业审核(t_qysh) 删除 */
	boolean deleteQysh(Qysh qysh);

	/** @param 企业审核(t_qysh) 修改 */
	boolean updateQysh(Qysh qysh);

	/** @param 企业审核(t_qysh) 查询单条 */
	Qysh getQysh(Qysh qysh);

	/** @param 企业审核(t_qysh) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业审核(t_qysh) 多条查询 */
	List getListQysh(Qysh qysh);
	
	/** 获得上级审核id，即最后一次审核的qyshid */
	Qysh getSjshid(Qysh qysh);
}
