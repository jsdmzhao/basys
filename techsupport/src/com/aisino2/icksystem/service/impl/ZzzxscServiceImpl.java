package com.aisino2.icksystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IZzzxscDao;
import com.aisino2.icksystem.domain.Zzzxsc;
import com.aisino2.icksystem.service.IZzzxscService;

public class ZzzxscServiceImpl extends BaseService implements IZzzxscService {

	private IZzzxscDao zzzxscDao;

	/** @param 制证中心上传(t_zzzxsc) 增加 */
	public Zzzxsc insertZzzxsc(Zzzxsc zzzxsc){
		// TODO: implement
		return (Zzzxsc)zzzxscDao.insertZzzxsc(zzzxsc);
	}

	/** @param 制证中心上传(t_zzzxsc) 删除 */
	public boolean deleteZzzxsc(Zzzxsc zzzxsc){
		// TODO: implement
		return zzzxscDao.deleteZzzxsc(zzzxsc)>0;
	}

	/** @param 制证中心上传(t_zzzxsc) 修改 */
	public boolean updateZzzxsc(Zzzxsc zzzxsc){
		// TODO: implement
		return zzzxscDao.updateZzzxsc(zzzxsc)>0;
	}

	/** @param 制证中心上传(t_zzzxsc) 查询单条 */
	public Zzzxsc getZzzxsc(Zzzxsc zzzxsc){
		// TODO: implement
		return (Zzzxsc)zzzxscDao.getZzzxsc(zzzxsc);
	}

	/** @param 制证中心上传(t_zzzxsc) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return zzzxscDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 制证中心上传(t_zzzxsc) 多条查询 */
	public List getListZzzxsc(Zzzxsc zzzxsc){
		// TODO: implement
		return zzzxscDao.getListZzzxsc(zzzxsc);
	}

	public IZzzxscDao getZzzxscDao() {
		return zzzxscDao;
	}

	public void setZzzxscDao(IZzzxscDao zzzxscDao) {
		this.zzzxscDao = zzzxscDao;
	}
}
