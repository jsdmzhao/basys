package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Qyzlxx;
import com.aisino2.publicsystem.domain.Qyzlxxfj;

public interface IQyzlxxDao {
	/** @param 企业质量信息(t_qyzlxx) 增加 */
	Qyzlxx insertQyzlxx(Qyzlxx qyzlxx);

	/** @param 企业质量信息(t_qyzlxx) 删除 */
	int deleteQyzlxx(Qyzlxx qyzlxx);

	/** @param 企业质量信息(t_qyzlxx) 修改 */
	int updateQyzlxx(Qyzlxx qyzlxx);

	/** @param 企业质量信息(t_qyzlxx) 查询单条 */
	Qyzlxx getQyzlxx(Qyzlxx qyzlxx);

	/** @param 企业质量信息(t_qyzlxx) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 企业质量信息(t_qyzlxx) 多条查询 */
	List getListQyzlxx(Qyzlxx qyzlxx);
	
	/**下载附件*/
	Qyzlxxfj downloadFJ(Qyzlxxfj fjobj);
}
