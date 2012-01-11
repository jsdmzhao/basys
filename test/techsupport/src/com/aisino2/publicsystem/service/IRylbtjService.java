package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Rylbtj;

public interface IRylbtjService {
	/** @param 人员类别统计(t_rylbtj) 增加 */
	Rylbtj insertRylbtj(Rylbtj rylbtj);

	/** @param 人员类别统计(t_rylbtj) 删除 */
	boolean deleteRylbtj(Rylbtj rylbtj);

	/** @param 人员类别统计(t_rylbtj) 修改 */
	boolean updateRylbtj(Rylbtj rylbtj);

	/** @param 人员类别统计(t_rylbtj) 查询单条 */
	Rylbtj getRylbtj(Rylbtj rylbtj);

	/** @param 人员类别统计(t_rylbtj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 人员类别统计(t_rylbtj) 多条查询 */
	List getListRylbtj(Rylbtj rylbtj);
	
	/** @param 人员类别统计(t_rylbtj) 信息采集 */
	Page getListForPageRY(Map map, int pageNo,int pageSize,String sort,String desc);
}
