package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyjcxx;

public interface IQyjcxxService {
	/** @param 企业奖惩信息(t_qyjcxx) 增加 */
	Qyjcxx insertQyjcxx(Qyjcxx qyjcxx);

	/** @param 企业奖惩信息(t_qyjcxx) 删除 */
	boolean deleteQyjcxx(Qyjcxx qyjcxx);

	/** @param 企业奖惩信息(t_qyjcxx) 修改 */
	boolean updateQyjcxx(Qyjcxx qyjcxx);

	/** @param 企业奖惩信息(t_qyjcxx) 查询单条 */
	Qyjcxx getQyjcxx(Qyjcxx qyjcxx);

	/** @param 企业奖惩信息(t_qyjcxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业奖惩信息(t_qyjcxx) 多条查询 */
	List getListQyjcxx(Qyjcxx qyjcxx);
}
