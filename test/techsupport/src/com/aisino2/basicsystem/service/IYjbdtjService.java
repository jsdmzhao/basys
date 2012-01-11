package com.aisino2.basicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.domain.Yjbdtj;
import com.aisino2.core.dao.Page;

public interface IYjbdtjService {
	/** @param 预警比对条件(t_yjbdtj) 增加 */
	Yjbdtj insertYjbdtj(Yjbdtj yjbdtj);

	/** @param 预警比对条件(t_yjbdtj) 删除 */
	boolean deleteYjbdtj(Yjbdtj yjbdtj);

	/** @param 预警比对条件(t_yjbdtj) 修改 */
	boolean updateYjbdtj(Yjbdtj yjbdtj);

	/** @param 预警比对条件(t_yjbdtj) 查询单条 */
	Yjbdtj getYjbdtj(Yjbdtj yjbdtj);

	/** @param 预警比对条件(t_yjbdtj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 预警比对条件(t_yjbdtj) 多条查询 */
	List getListYjbdtj(Yjbdtj yjbdtj);
}
