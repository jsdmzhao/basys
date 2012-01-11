package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qysctj;
public interface IQysctjDao {
	/** @param 企业上传统计表(t_qysctj) 增加 */
	Qysctj insertQysctj(Qysctj qysctj);

	/** @param 企业上传统计表(t_qysctj) 删除 */
	int deleteQysctj(Qysctj qysctj);

	/** @param 企业上传统计表(t_qysctj) 修改 */
	int updateQysctj(Qysctj qysctj);

	/** @param 企业上传统计表(t_qysctj) 查询单条 */
	Qysctj getQysctj(Qysctj qysctj);

	/** @param 企业上传统计表(t_qysctj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业上传统计表(t_qysctj) 多条查询 */
	List getListQysctj(Qysctj qysctj);
	/** @param 企业刷卡统计(t_qysctj) 分页查询 */
	Page getSktjListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业刷卡统计(t_qysctj) 分页查询 */
	Page getSktjxxListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 走台人员(t_qysctj) 分页查询 */
	Page getZtxxListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 一次/多次刷卡人员(t_qysctj) 分页查询 */
	Page getYcskxxListForPage(Map map, int pageNo, int pageSize, String sort,String desc);
}
