package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyry_tjxx;
public interface IQyry_tjxxDao {
	/** @param 企业人员体检信息(t_qyry_tjxx) 增加 */
	Qyry_tjxx insertQyry_tjxx(Qyry_tjxx qyry_tjxx);

	/** @param 企业人员体检信息(t_qyry_tjxx) 删除 */
	int deleteQyry_tjxx(Qyry_tjxx qyry_tjxx);

	/** @param 企业人员体检信息(t_qyry_tjxx) 修改 */
	int updateQyry_tjxx(Qyry_tjxx qyry_tjxx);

	/** @param 企业人员体检信息(t_qyry_tjxx) 查询单条 */
	Qyry_tjxx getQyry_tjxx(Qyry_tjxx qyry_tjxx);

	/** @param 企业人员体检信息(t_qyry_tjxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员体检信息(t_qyry_tjxx) 多条查询 */
	List getListQyry_tjxx(Qyry_tjxx qyry_tjxx);
}
