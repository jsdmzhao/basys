package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IScbmDao;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IKyqkDao;
import com.aisino2.publicsystem.domain.Kyqk;
import com.aisino2.publicsystem.service.IKyqkService;

public class KyqkServiceImpl extends BaseService implements IKyqkService {

	private IKyqkDao kyqkDao;

	/** @param 可疑情况(t_kyqk) 增加 */
	public Kyqk insertKyqk(Kyqk kyqk){
		// TODO: implement
		return (Kyqk)kyqkDao.insertKyqk(kyqk);
	}
	private IScbmDao scbmDao;

	public void setScbmDao(IScbmDao scbmDao) {
		this.scbmDao = scbmDao;
	}

	/** @param 可疑情况(t_kyqk) 删除 */
	public boolean deleteKyqk(Kyqk kyqk){
		// TODO: implement
		return kyqkDao.deleteKyqk(kyqk)>0;
	}

	/** @param 可疑情况(t_kyqk) 修改 */
	public boolean updateKyqk(Kyqk kyqk){
		// TODO: implement
		return kyqkDao.updateKyqk(kyqk)>0;
	}

	/** @param 可疑情况(t_kyqk) 查询单条 */
	public Kyqk getKyqk(Kyqk kyqk){
		// TODO: implement
		return (Kyqk)kyqkDao.getKyqk(kyqk);
	}

	/** @param 可疑情况(t_kyqk) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return kyqkDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	/** @param 可疑情况(t_kyqk) 分页查询 */
	public Page getListForPageGAD(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return kyqkDao.getListForPageGAD(map,pageNo,pageSize,sort,desc);
	}

	/** @param 可疑情况(t_kyqk) 多条查询 */
	public List getListKyqk(Kyqk kyqk){
		// TODO: implement
		return kyqkDao.getListKyqk(kyqk);
	}

	public IKyqkDao getKyqkDao() {
		return kyqkDao;
	}

	public void setKyqkDao(IKyqkDao kyqkDao) {
		this.kyqkDao = kyqkDao;
	}
	/**
	 * 得到通报编码
	 * @param map
	 * @return
	 */
	public String getScbm(Map map){
		
		return scbmDao.getScbm(map);
	}
	
	/** @param 可疑情况(t_kyqk) 总数查询 */
	public int getKyqkCount(Map map){
		return kyqkDao.getKyqkCount(map);
	}
}
