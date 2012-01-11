package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyryxx;

public interface ICyryxxService {
	
	/** @param 企业人员信息(t_qyryxx) 增加 */
	Qyryxx insertQyryxx(Qyryxx qyryxx) throws Exception ;
	
	/** @param 从业人员信息(t_qyryxx) 修改 */
	boolean updateQyryxx(Qyryxx qyryxx) throws Exception;
	
	/** @param 从业人员信息(t_qyryxx) 删除 */
	boolean deleteQyryxx(Qyryxx qyryxx) throws Exception;
	
	/** @param 从业人员信息(t_qyryxx) 注销 */
	boolean updateQyryxxZx(Qyryxx qyryxx) throws Exception;
	
	/** @param 从业人员信息(t_qyryxx) 注销恢复 */
	boolean updateQyryxxZxhf(Qyryxx qyryxx) throws Exception;
	
	/** @param 从业人员信息(t_qyryxx) 修改与t_qyryxx表有外键关联的表的qyid字段 */
	boolean updateQyryxxForeignKey(Qyryxx qyryxx,Qyryxx qyryxx_bak);
	
	/** @param 娱乐场所基本信息(qyryxx:ryid,czr)  采集点提交 */
	boolean updateQyryxxTj(List qyryxxList) throws Exception;
	
	/** @param 娱乐场所基本信息(qyryxx 存放页面查询参数及lrdwbm和czr,hylbdm)  采集点全部提交 */
	boolean updateQyryxxQbtj(Qyryxx qyryxx) throws Exception;

	/** @param 从业人员信息(t_qyryxx) 分页查询 采集点查询*/
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  采集点提交*/
	Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  公安端人员查询 注销查询*/
	Page getListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  采集端台账 已采集人员查询*/
	Page getYcjCyryListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  公安端 派出所审核查询 市局审核查询*/
	Page getListGadForPageRysh(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  企业端人员查询*/
	Page getListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_qyryxx) 多条查询 获得需进行公安人口库比对的人员(只比对国内人员)*/
	List getDhdQyryxxList(Qyryxx qyryxx);
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 企业端国内人员历史查询 */
	Page getCyryxx_lsxxListQydGnForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息核查(t_cyryxxhc) 分页查询 */
	Page getCyryxxhcListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/**======================境外人员==============================*/
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 采集点查询*/
	Page getJwListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 人员查询、注销查询*/
	Page getJwListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  公安端 派出所审核查询 市局审核查询*/
	Page getJwListGadForPageRysh(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 企业人员查询*/
	Page getJwListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 删除查询*/
	Page getScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 外国从业人员信息(t_wgcyryxx) 分页查询 公安端 删除查询*/
	Page getJwScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员历史信息(t_cyryxx_lsxx) 企业端境外人员历史查询 */
	Page getCyryxx_lsxxListQydJwForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/**======================国内境外公用==============================*/
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  根据江苏老版14位人员编号查询人员信息 20101109 mds*/
	Page getQyryxxByOldcyrybh(Map map, int pageNo,int pageSize,String sort,String desc);
}
