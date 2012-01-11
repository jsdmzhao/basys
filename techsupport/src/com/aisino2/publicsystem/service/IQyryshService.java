package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyrysh;


public interface IQyryshService {
	/** @param 企业人员审核(t_qyrysh) 增加 */
	Qyrysh insertQyrysh(Qyrysh qyrysh);

	/** @param 企业人员审核(t_qyrysh) 删除 */
	boolean deleteQyrysh(Qyrysh qyrysh);

	/** @param 企业人员审核(t_qyrysh) 修改 */
	boolean updateQyrysh(Qyrysh qyrysh);

	/** @param 企业人员审核(t_qyrysh) 查询单条 */
	Qyrysh getQyrysh(Qyrysh qyrysh);

	/** @param 企业人员审核(t_qyrysh) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员审核(t_qyrysh) 多条查询 */
	List getListQyrysh(Qyrysh qyrysh);
	
	/** @param 从业人员审核信息(t_cyrysh) 获得上级审核id */
	int getSjshid(Qyrysh qyrysh);
}
