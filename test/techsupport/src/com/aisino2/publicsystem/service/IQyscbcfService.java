package com.aisino2.publicsystem.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyscbcf;

public interface IQyscbcfService {
	/** @param 企业上传不充分(t_qyscbcf) 增加 */
	Qyscbcf insertQyscbcf(Qyscbcf qyscbcf);

	/** @param 企业上传不充分(t_qyscbcf) 删除 */
	boolean deleteQyscbcf(Qyscbcf qyscbcf);

	/** @param 企业上传不充分(t_qyscbcf) 修改 */
	boolean updateQyscbcf(Qyscbcf qyscbcf);

	/** @param 企业上传不充分(t_qyscbcf) 查询单条 */
	Qyscbcf getQyscbcf(Qyscbcf qyscbcf);

	/** @param 企业上传不充分(t_qyscbcf) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业上传详细不充分(t_qyscbcf) 分页查询 */
	Page getXxListForPage(Map map, int pageNo,int pageSize,String sort,String desc);
	/** @param 企业上传不充分(t_qyscbcf) 多条查询 */
	List getListQyscbcf(Qyscbcf qyscbcf);
}
