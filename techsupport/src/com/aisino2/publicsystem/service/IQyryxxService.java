package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyjbxx;
import com.aisino2.publicsystem.domain.Qyryxx;


public interface IQyryxxService {
	/** @param 企业人员信息(t_qyryxx) 增加 */
	Qyryxx insertQyryxx(Qyryxx qyryxx) throws Exception;

	/** @param 企业人员信息(t_qyryxx) 删除 */
	boolean deleteQyryxx(Qyryxx qyryxx)throws Exception;

	/** @param 企业人员信息(t_qyryxx) 修改 */
	boolean updateQyryxx(Qyryxx qyryxx)throws Exception;
	
	/**
	 * @author mds 其他人请不要修改此方法，或在修改之前通知我！！
	 * 公用方法 修改主表  不包含修改所属企业，不能修改人员姓名
	 */
	boolean updateQyryxxOnly(Qyryxx qyryxx) throws Exception;

	/** @param 企业人员信息(t_qyryxx) 查询单条 */
	Qyryxx getQyryxx(Qyryxx qyryxx);

	/** @param 企业人员信息(t_qyryxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员信息(t_qyryxx) 多条查询 */
	List getListQyryxx(Qyryxx qyryxx);
	
	/** @param 企业人员信息(t_qyryxx) 多条查询 获得需进行公安人口库比对的人员*/
	List getDhdQyryxxList(Qyryxx qyryxx);
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  制卡端关联查询*/
	Page getListZkdForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_cyryxx) 分页查询  制卡端关联查询 场所所属人员*/
	Page getListZkdByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_cyryxx) 多条查询 获得未提交从业人员*/
	List getWtjListQyryxx(Qyryxx qyryxx);
	
	/** @param 娱乐场所基本信息(qyryxx:ryid,czr)  人员提交 */
	boolean updateQyryxxTj(List qyryxxList) throws Exception;
	
	/** @param 娱乐场所基本信息(qyryxx 存放页面查询参数及lrdwbm和czr,hylbdm)  人员全部提交 */
	boolean updateQyryxxQbtj(Qyryxx qyryxxOrigin) throws Exception;
	
	
	//以下是新增的
	
	
	/** @param 从业人员信息(t_Qyryxx) 修改与t_Qyryxx表有外键关联的表的csid字段 */
	boolean updateQyryxxForeignKey(Qyryxx qyryxx,Qyryxx qyryxx_bak);
	/** @param 从业人员信息(t_Qyryxx) 注销 */
	boolean updateQyryxxZx(Qyryxx qyryxx)throws Exception;
	/** @param 从业人员信息(t_Qyryxx) 注销恢复 */
	boolean updateQyryxxZxhf(Qyryxx qyryxx) throws Exception;
	/** @param 从业人员信息(t_Qyryxx) 修改 公用服务*/
	boolean updateQyryxxCommon(Qyryxx qyryxx)throws Exception;
	
	/** @param 从业人员信息(t_Qyryxx) 分页查询  公安端人员查询 注销查询*/
	Page getListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 从业人员信息(t_Qyryxx) 分页查询  企业段筛选框查询*/
	Page getQyryxxListQydDictForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 从业人员信息(t_Qyryxx) 分页查询  企业端人员查询*/
	Page getListQydForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 从业人员信息(t_Qyryxx) 分页查询  由场所ID或场所编码获得该场所下从业人员*/
	Page getQyryxxListByCsidForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 从业人员信息(t_Qyryxx) 分页查询  公安端 删除查询*/
	Page getScListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 从业人员信息(t_Qyryxx) 分页查询  公安端 变更查询*/
	Page getBgListGadForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 从业人员信息(t_Qyryxx) 分页查询  公安端人员处罚信息查询*/
	Page getListCfForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 由身份证号码获得户籍代码及名称 */
	Qyryxx getHjdxzqh(Qyryxx qyryxx);
	/** @param 由证件号码判断从业人员是否已录入(修改时，需判断不同ryid的证件号码不能重复) */
	List getIsQyryxxExist(Qyryxx qyryxx);
	
	
	/**
	  * 企业注销导致 从业人员离职并同步账号注销
	  * @param jxqyxx
	  */
	boolean makeCyryxxLizhiByqyZx(Qyjbxx qyjbxx)throws Exception;
	
	/** @param 从业人员信息(t_qyryxx) 分页查询  采集点提交*/
	Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 从业人员信息(t_qyryxx) 多条查询 获得已进行公安人口库比对的人员（人员状态为1、4、5的记录）*/
	List getYhcCyryxxList(Qyryxx qyryxx);
	/** @param 企业人员信息导出标识(t_qyryxx) 修改 */
	boolean updateQyryxxDcgs(Qyryxx qyryxx)throws Exception;
}
