package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyry_zp;

public interface IQyry_zpService {
	/** @param 企业人员_照片(t_qyry_zp) 增加 */
	Qyry_zp insertQyry_zp(Qyry_zp qyry_zp);

	/** @param 企业人员_照片(t_qyry_zp) 删除 */
	boolean deleteQyry_zp(Qyry_zp qyry_zp);

	/** @param 企业人员_照片(t_qyry_zp) 修改 */
	boolean updateQyry_zp(Qyry_zp qyry_zp);

	/** @param 企业人员_照片(t_qyry_zp) 查询单条 */
	Qyry_zp getQyry_zp(Qyry_zp qyry_zp);

	/** @param 企业人员_照片(t_qyry_zp) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员_照片(t_qyry_zp) 多条查询 */
	List getListQyry_zp(Qyry_zp qyry_zp);
	
	/** 企业人员_照片(t_qyry_zp) 通过人员id判断照片是否存在
	 * @param 需传入将ryid放在qyry_zp中传入
	 * @return boolean true-该人员存在照片 false-该人员不存在照片
	 */
	boolean isZpExist(Qyry_zp qyry_zp);
}
