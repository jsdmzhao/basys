package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IKyclDao;
import com.aisino2.publicsystem.domain.Kycl;
import com.aisino2.publicsystem.service.IKyclService;

public class KyclServiceImpl extends BaseService implements IKyclService {

	private IKyclDao kyclDao;

	/** @param 可疑车辆(t_kycl) 增加 */
	public Kycl insertKycl(Kycl kycl){
		// TODO: implement
		return (Kycl)kyclDao.insertKycl(kycl);
	}

	/** @param 可疑车辆(t_kycl) 删除 */
	public boolean deleteKycl(Kycl kycl){
		// TODO: implement
		return kyclDao.deleteKycl(kycl)>0;
	}

	/** @param 可疑车辆(t_kycl) 修改 */
	public boolean updateKycl(Kycl kycl){
		// TODO: implement
		return kyclDao.updateKycl(kycl)>0;
	}

	/** @param 可疑车辆(t_kycl) 查询单条 */
	public Kycl getKycl(Kycl kycl){
		// TODO: implement
		return (Kycl)kyclDao.getKycl(kycl);
	}

	/** @param 可疑车辆(t_kycl) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return kyclDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 可疑车辆(t_kycl) 多条查询 */
	public List getListKycl(Kycl kycl){
		// TODO: implement
		return kyclDao.getListKycl(kycl);
	}

	public IKyclDao getKyclDao() {
		return kyclDao;
	}

	public void setKyclDao(IKyclDao kyclDao) {
		this.kyclDao = kyclDao;
	}
}
