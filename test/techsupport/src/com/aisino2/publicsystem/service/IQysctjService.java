package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qysctj;

public interface IQysctjService {
	/** @param 企业上传统计表(t_qysctj) 增加 */
	Qysctj insertQysctj(Qysctj qysctj);

	/** @param 企业上传统计表(t_qysctj) 删除 */
	boolean deleteQysctj(Qysctj qysctj);

	/** @param 企业上传统计表(t_qysctj) 修改 */
	boolean updateQysctj(Qysctj qysctj);

	/** @param 企业上传统计表(t_qysctj) 查询单条 */
	Qysctj getQysctj(Qysctj qysctj);

	/** @param 企业上传统计表(t_qysctj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业上传统计表(t_qysctj) 多条查询 */
	List getListQysctj(Qysctj qysctj);
	
	/** @param 企业刷卡统计(t_qysctj) 分页查询 */
	Page getSktjListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 企业刷卡统计详细(t_qysctj) 分页查询 */
	Page getSktjxxListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 走台人员(t_qysctj) 分页查询 */
	Page getZtxxListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 一次/多次刷卡人员(t_qysctj) 分页查询 */
	Page getYcskxxListForPage(Map map, int pagesize, int pagerow, String sort,String dir);
	
}
