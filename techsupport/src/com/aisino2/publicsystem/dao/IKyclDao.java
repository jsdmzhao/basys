package com.aisino2.publicsystem.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.domain.Kycl;
public interface IKyclDao {
	/** @param 可疑车辆(t_kycl) 增加 */
	Kycl insertKycl(Kycl kycl);

	/** @param 可疑车辆(t_kycl) 删除 */
	int deleteKycl(Kycl kycl);

	/** @param 可疑车辆(t_kycl) 修改 */
	int updateKycl(Kycl kycl);

	/** @param 可疑车辆(t_kycl) 查询单条 */
	Kycl getKycl(Kycl kycl);

	/** @param 可疑车辆(t_kycl) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 可疑车辆(t_kycl) 多条查询 */
	List getListKycl(Kycl kycl);
}
