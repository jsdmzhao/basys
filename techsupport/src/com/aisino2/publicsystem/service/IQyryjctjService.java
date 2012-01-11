package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyryjctj;

public interface IQyryjctjService {
	/** @param 企业人员奖惩统计表(t_qyryjctj) 增加 */
	Qyryjctj insertQyryjctj(Qyryjctj qyryjctj);

	/** @param 企业人员奖惩统计表(t_qyryjctj) 删除 */
	boolean deleteQyryjctj(Qyryjctj qyryjctj);

	/** @param 企业人员奖惩统计表(t_qyryjctj) 修改 */
	boolean updateQyryjctj(Qyryjctj qyryjctj);

	/** @param 企业人员奖惩统计表(t_qyryjctj) 查询单条 */
	Qyryjctj getQyryjctj(Qyryjctj qyryjctj);

	/** @param 企业人员奖惩统计表(t_qyryjctj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员奖惩统计表(t_qyryjctj) 多条查询 */
	List getListQyryjctj(Qyryjctj qyryjctj);
}
