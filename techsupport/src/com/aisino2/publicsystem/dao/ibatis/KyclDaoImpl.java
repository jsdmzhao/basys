package com.aisino2.publicsystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.publicsystem.dao.IKyclDao;
import com.aisino2.publicsystem.domain.Kycl;

public class KyclDaoImpl extends BaseDao implements IKyclDao {
	
	/** @param 可疑车辆(t_kycl) 增加 */
	public Kycl insertKycl(Kycl kycl){
		kycl.setKyqkclid(getNextID("Kyclid"));
		insert("insertKycl", kycl);
		return kycl;
	}

	/** @param 可疑车辆(t_kycl) 删除 */
	public int deleteKycl(Kycl kycl){
		return delete("deleteKycl", kycl);
	}

	/** @param 可疑车辆(t_kycl) 修改 */
	public int updateKycl(Kycl kycl){
		return update("updateKycl", kycl);
	}

	/** @param 可疑车辆(t_kycl) 查询单条 */
	public Kycl getKycl(Kycl kycl){
		return (Kycl)queryForObject("getKycl", kycl);
	}

	/** @param 可疑车辆(t_kycl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Cljbxxid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getKyclList", map, pageNo,pageSize);
	}

	/** @param 可疑车辆(t_kycl) 多条查询 */
	public List getListKycl(Kycl kycl){
		return queryForList("getKyclListNoPage", kycl);
	}
}
