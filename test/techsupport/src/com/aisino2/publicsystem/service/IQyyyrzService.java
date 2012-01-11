package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyyyrz;

public interface IQyyyrzService {
	/** @param 企业营业日志(t_qyyyrz) 增加 */
	Qyyyrz insertQyyyrz(Qyyyrz qyyyrz);

	/** @param 企业营业日志(t_qyyyrz) 删除 */
	boolean deleteQyyyrz(Qyyyrz qyyyrz);

	/** @param 企业营业日志(t_qyyyrz) 修改 */
	boolean updateQyyyrz(Qyyyrz qyyyrz);

	/** @param 企业营业日志(t_qyyyrz) 查询单条 */
	Qyyyrz getQyyyrz(Qyyyrz qyyyrz);

	/** @param 企业营业日志(t_qyyyrz) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** 企业营业日志 公安端查询 标准化公安端*/
	Page getListForPageYlyBzhGad(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业营业日志(t_qyyyrz) 多条查询 */
	List getListQyyyrz(Qyyyrz qyyyrz);
	
	/** @param 企业营业日志(t_qyyyrz) 根据qybm查询负责人信息 */
	Qyyyrz getQyyyrzFzry(Qyyyrz qyyyrz);
}
