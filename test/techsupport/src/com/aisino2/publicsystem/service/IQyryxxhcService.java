package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyryxxhc;


public interface IQyryxxhcService {
	/** @param 企业人员信息核查(t_qyryxxhc) 增加 */
	Qyryxxhc insertQyryxxhc(Qyryxxhc qyryxxhc);

	/** @param 企业人员信息核查(t_qyryxxhc) 删除 */
	boolean deleteQyryxxhc(Qyryxxhc qyryxxhc);

	/** @param 企业人员信息核查(t_qyryxxhc) 修改 */
	boolean updateQyryxxhc(Qyryxxhc qyryxxhc);

	/** @param 企业人员信息核查(t_qyryxxhc) 查询单条 */
	Qyryxxhc getQyryxxhc(Qyryxxhc qyryxxhc);

	/** @param 企业人员信息核查(t_qyryxxhc) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员信息核查(t_qyryxxhc) 多条查询 */
	List getListQyryxxhc(Qyryxxhc qyryxxhc);
	
	/** @param 从业人员信息核查(t_Qyryxxhc) 增加 传入ryid、garkktbsjid及核查问题,获得相应数据增加到核查表*/
	Qyryxxhc insertQyryxxhcByRyid(Qyryxxhc qyryxxhc);
	
	/** @param 企业人员信息核查(t_qyryxxhc) 未核查总数查询 */
	int getDhcryCount(Map map);
	

}
