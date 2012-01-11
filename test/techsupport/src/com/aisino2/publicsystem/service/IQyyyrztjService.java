package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyyyrztj;

public interface IQyyyrztjService {
	/** @param 企业营业日志统计(t_qyyyrztj) 增加 */
	Qyyyrztj insertQyyyrztj(Qyyyrztj qyyyrztj);

	/** @param 企业营业日志统计(t_qyyyrztj) 删除 */
	boolean deleteQyyyrztj(Qyyyrztj qyyyrztj);

	/** @param 企业营业日志统计(t_qyyyrztj) 修改 */
	boolean updateQyyyrztj(Qyyyrztj qyyyrztj);

	/** @param 企业营业日志统计(t_qyyyrztj) 查询单条 */
	Qyyyrztj getQyyyrztj(Qyyyrztj qyyyrztj);

	/** @param 企业营业日志统计(t_qyyyrztj) 分页查询 */
	Page getListForPagetj(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业营业日志统计(t_qyyyrztj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业营业日志统计(t_qyyyrztj) 多条查询 */
	List getListQyyyrztj(Map map);
	
	/** @param 企业营业日志统计(t_qyyyrztj) 营业日志明细查询 */
	Page getrzmxList(Map map, int pageNo,int pageSize,String sort,String desc);
	
}
