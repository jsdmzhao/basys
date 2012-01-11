package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyjbxx;

public interface IQyjbxxService {
	/** @param 企业基本信息(t_qyjbxx) 增加 */
	Qyjbxx insertQyjbxx(Qyjbxx qyjbxx);

	/** @param 企业基本信息(t_qyjbxx) 删除 */
	boolean deleteQyjbxx(Qyjbxx qyjbxx);

	/** @param 企业基本信息(t_qyjbxx) 修改 */
	boolean updateQyjbxx(Qyjbxx qyjbxx) throws Exception;
	/** @param 企业基本信息导出标识(t_qyjbxx) 修改 */
	boolean updateQyjbxxDcbs(Qyjbxx qyjbxx) throws Exception;
	
	/** @param 企业基本信息(t_qyjbxx) 修改  只修改场所主表*/
	boolean updateQyjbxxOnly(Qyjbxx qyjbxx) throws Exception;
	
	/** @param 企业基本信息(t_qyjbxx) 企业核查*/
	boolean updateQyjbxxHc(Qyjbxx qyjbxx) throws Exception;
	
	/** @param 企业基本信息(t_qyjbxx) 派出所审核 qyjbxx中存放qyid、sftg及qysh*/
	boolean updateQyjbxxsh_pcs(Qyjbxx qyjbxx) throws Exception;
	
	/** @param 企业基本信息(t_qyjbxx) 市局审核 qyjbxx中存放qyid、sftg及qysh*/
	boolean updateQyjbxxsh_sj(Qyjbxx qyjbxx) throws Exception;
	
	/** @param 企业基本信息(t_qyjbxx) 企业变更*/
	boolean updateQyjbxxBg(Qyjbxx qyjbxx) throws Exception;
	
	/** @param 企业基本信息(t_qyjbxx) 企业注销*/
	boolean updateQyjbxxZx(Qyjbxx qyjbxx) throws Exception;
	
	/** @param 获得企业副分类串，以"|" 分隔。
	 * @param  qyfflList 企业副分类list
	 * @param  flag 标识：0-返回副分类编码串，1-返回副分类名称串*/
	String getQyfflStr(List qyfflList,String flag);

	/** @param 企业基本信息(t_qyjbxx) 查询单条 */
	Qyjbxx getQyjbxx(Qyjbxx qyjbxx);
	
	/** @param 企业基本信息usbkey专用(t_qyjbxx) 查询单条 */
	Qyjbxx getQyjbxxUsbkey(Qyjbxx qyjbxx);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询 采集点提交  */
	Page getWtjListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业基本信息(t_qyjbxx) 分页查询 采集点管理，公安端企业管理页面*/
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业核查(即信息确认)、派出所审核查询、市局审核查询*/
	Page getListForPageHc(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  公安端企业查询 企业营业日志查询*/
	Page getListForPageQycx(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业变更、注销查询*/
	Page getListForPageQybg(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询  企业变更详情查询*/
	Page getListForPageQybgxq(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/** @param 企业基本信息(t_qyjbxx) 分页查询 制卡端关联查询*/
	Page getListForPageZkd(Map map, int pageNo,int pageSize,String sort,String desc);
	
	/**
	 * 判断企业是否已存在
	 * @param qyjbxx(qyid,zjbh)
	 * @return 0-不存在，1-存在
	 */
	String isQyjbxxExist(Qyjbxx qyjbxx);

	/** @param 企业基本信息(t_qyjbxx) 多条查询 */
	List getListQyjbxx(Qyjbxx qyjbxx);
	
	/** 根据企业主分类 公安端查询场所数量 娱乐业标准化 */
	List getQyzflCountList(Map map);
	
	/** 待核查场所数 娱乐业标准化 */
	int getDhccsCount(Map map);
	
	/** @param 企业基本信息(t_qyjbxx) 查询单条(包含保安人员数量、保卫人员数量、视频设备数量、技防设备数量) */
	Qyjbxx getQyjbxxAll(Qyjbxx qyjbxx);
}
