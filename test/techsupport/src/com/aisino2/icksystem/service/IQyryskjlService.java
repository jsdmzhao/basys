package com.aisino2.icksystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Qyryskjl;

public interface IQyryskjlService {
	/** @param 企业人员刷卡记录(t_csryskjl) 增加 */
	Qyryskjl insertQyryskjl(Qyryskjl qyryskjl);
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 增加 用于手动输入卡号、从业人员编号或证件号码*/
	Qyryskjl insertQyryskjlSdsr(Icksl icksl);

	/** @param 企业人员刷卡记录(t_qyryskjl) 删除 */
	boolean deleteQyryskjl(Qyryskjl qyryskjl);

	/** @param 企业人员刷卡记录(t_qyryskjl) 修改 */
	boolean updateQyryskjl(Qyryskjl qyryskjl);

	/** @param 企业人员刷卡记录(t_qyryskjl) 查询单条 */
	Qyryskjl getQyryskjl(Qyryskjl qyryskjl);

	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询  企业端人员工作日志*/
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 公安端企业刷卡记录查询*/
	Page getQyryskjlGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 公安端从业人员工作日志*/
	Page getCyrygzrzForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员刷卡记录(t_qyryskjl) 多条查询 */
	List getListQyryskjl(Qyryskjl qyryskjl);
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 频繁刷卡*/
	Page getPfskForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业人员刷卡记录(t_qyryskjl) 分页查询 频繁刷卡轨迹*/
	Page getPfskGjForPage(Map map, int pageNo,int pageSize,String sort,String desc);
}
