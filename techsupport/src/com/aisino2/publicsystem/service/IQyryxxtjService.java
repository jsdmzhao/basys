package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyryxxtj;

public interface IQyryxxtjService {
	/** @param 企业人员信息统计表(t_qyryxxtj) 增加 */
	Qyryxxtj insertQyryxxtj(Qyryxxtj qyryxxtj);

	/** @param 企业人员信息统计表(t_qyryxxtj) 删除 */
	boolean deleteQyryxxtj(Qyryxxtj qyryxxtj);

	/** @param 企业人员信息统计表(t_qyryxxtj) 修改 */
	boolean updateQyryxxtj(Qyryxxtj qyryxxtj);

	/** @param 企业人员信息统计表(t_qyryxxtj) 查询单条 */
	Qyryxxtj getQyryxxtj(Qyryxxtj qyryxxtj);

	/** @param 企业人员信息统计表(t_qyryxxtj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员信息统计表(t_qyryxxtj) 多条查询 */
	List getListQyryxxtj(Qyryxxtj qyryxxtj);
}
