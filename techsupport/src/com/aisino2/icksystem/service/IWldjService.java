package com.aisino2.icksystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Wldj;

public interface IWldjService {
	/** @param 物流登记信息(t_wldj) 增加 */
	Wldj insertWldj(Wldj wldj) throws Exception;

	/** @param 物流登记信息(t_wldj) 删除 */
	boolean deleteWldj(Wldj wldj) throws Exception;
	
	/** @param 物流登记信息(t_wldj) 删除物流包时，包内IC卡复位及IC卡受理物流登记删除 公用服务*/
	boolean deleteWldjCommon(Wldj wldj) throws Exception;

	/** @param 物流登记信息(t_wldj) 修改 */
	boolean updateWldj(Wldj wldj) throws Exception;
	
	/** 物流发送 */
	boolean updateWldjWlfs(Wldj wldj) throws Exception;
		
	/**  物流接收*/
	boolean updateWldjWljs(Wldj wldj) throws Exception;
	
	/**  物流反馈*/
	boolean updateWldjWlfk(Wldj wldj) throws Exception;

	/** @param 物流登记信息(t_wldj) 查询单条 */
	Wldj getWldj(Wldj wldj);

	/** @param 物流登记信息(t_wldj) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 物流登记信息(t_wldj) 分页查询 制卡端*/
	Page getListZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 物流登记信息(t_wldj) 分页查询 制卡端台账*/
	Page getListZkdTzForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 物流登记信息(t_wldj) 多条查询 */
	List getListWldj(Wldj wldj);
}
