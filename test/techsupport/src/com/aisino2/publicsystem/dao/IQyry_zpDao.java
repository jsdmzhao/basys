package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyry_zp;
public interface IQyry_zpDao {
	/** @param 企业人员_照片(t_qyry_zp) 增加 */
	Qyry_zp insertQyry_zp(Qyry_zp qyry_zp);

	/** @param 企业人员_照片(t_qyry_zp) 删除 */
	int deleteQyry_zp(Qyry_zp qyry_zp);

	/** @param 企业人员_照片(t_qyry_zp) 修改 */
	int updateQyry_zp(Qyry_zp qyry_zp);

	/** @param 企业人员_照片(t_qyry_zp) 查询单条 */
	Qyry_zp getQyry_zp(Qyry_zp qyry_zp);

	/** @param 企业人员_照片(t_qyry_zp) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业人员_照片(t_qyry_zp) 多条查询 */
	List getListQyry_zp(Qyry_zp qyry_zp);
}
