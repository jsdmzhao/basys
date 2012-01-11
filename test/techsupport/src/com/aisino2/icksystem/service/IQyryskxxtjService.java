package com.aisino2.icksystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Qyryskxxtj;

public interface IQyryskxxtjService {
	/** @param 刷卡信息统计明细(t_qyryskxxtj) 增加 */
	Qyryskxxtj insertQyryskxxtj(Qyryskxxtj qyryskxxtj);

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 删除 */
	boolean deleteQyryskxxtj(Qyryskxxtj qyryskxxtj);

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 修改 */
	boolean updateQyryskxxtj(Qyryskxxtj qyryskxxtj);

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 查询单条 */
	Qyryskxxtj getQyryskxxtj(Qyryskxxtj qyryskxxtj);

	/** @param 刷卡信息统计明细(t_qyryskxxtj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 刷卡分析统计 分页查询 */
	Page getStatistics(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 刷卡信息统计明细(t_qyryskxxtj) 多条查询 */
	List getListQyryskxxtj(Qyryskxxtj qyryskxxtj);
	
	/** @param 从业人员信息(t_qyryskxxtj) 分页查询  公安端 从业轨迹查询*/
	Page getCygjForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_qyryskxxtj) 分页查询  公安端 频繁变换场所统计查询*/
	Page getPfbhcsForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
