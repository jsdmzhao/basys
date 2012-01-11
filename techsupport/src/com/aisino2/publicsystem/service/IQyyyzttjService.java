package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyyyzttj;

public interface IQyyyzttjService {
	/** @param 企业营业状态统计(t_qyyyzttj) 增加 */
	Qyyyzttj insertQyyyzttj(Qyyyzttj qyyyzttj);

	/** @param 企业营业状态统计(t_qyyyzttj) 删除 */
	boolean deleteQyyyzttj(Qyyyzttj qyyyzttj);

	/** @param 企业营业状态统计(t_qyyyzttj) 修改 */
	boolean updateQyyyzttj(Qyyyzttj qyyyzttj);

	/** @param 企业营业状态统计(t_qyyyzttj) 查询单条 */
	Qyyyzttj getQyyyzttj(Qyyyzttj qyyyzttj);

	/** @param 企业营业状态统计(t_qyyyzttj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业营业状态统计(t_qyyyzttj) 多条查询 */
	List getListQyyyzttj(Qyyyzttj qyyyzttj);
}
