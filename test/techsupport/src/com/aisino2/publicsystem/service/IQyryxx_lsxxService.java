package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyryxx_lsxx;

public interface IQyryxx_lsxxService {
	/** @param 企业人员历史信息(t_qyryxx_lsxx) 增加 */
	Qyryxx_lsxx insertQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx);

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 删除 */
	boolean deleteQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx);

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 修改 */
	boolean updateQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx);

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 查询单条 */
	Qyryxx_lsxx getQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx);

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员历史信息(t_qyryxx_lsxx) 多条查询 */
	List getListQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx);
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 企业端国内人员历史查询 */
	Page getCyryxx_lsxxListQydGnForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 企业端境外人员历史查询 */
	Page getCyryxx_lsxxListQydJwForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 公安端国内人员历史查询 */
	Page getCyryxx_lsxxListGadGnForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 公安端境外人员历史查询 */
	Page getCyryxx_lsxxListGadJwForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/**
	 * 判断是否为指定从业人员的操作类型为变更的最新一条历史记录
	 * @param qyryxx_lsxx(ryid,rylsid)
	 * @return 0-不是最新历史记录 1-是最新历史记录
	 */
	String isLatestBgQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx);
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 查询指定从业人员且操作类型为变更的某条历史记录的下一条记录(即rylsid较大的一条) */
	Qyryxx_lsxx getNextBgQyryxx_lsxx(Qyryxx_lsxx qyryxx_lsxx);
}
