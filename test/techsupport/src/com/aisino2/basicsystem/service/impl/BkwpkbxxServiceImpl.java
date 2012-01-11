package com.aisino2.basicsystem.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.basicsystem.dao.IBkclDao;
import com.aisino2.basicsystem.dao.IBksjDao;
import com.aisino2.basicsystem.dao.IBkwpkbxxDao;
import com.aisino2.basicsystem.domain.Bkcl;
import com.aisino2.basicsystem.domain.Bksj;
import com.aisino2.basicsystem.domain.Bkwpkbxx;
import com.aisino2.basicsystem.service.IBkwpkbxxService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class BkwpkbxxServiceImpl extends BaseService implements IBkwpkbxxService {

	private IBkwpkbxxDao bkwpkbxxDao;
	
	private IBksjDao bksjDao;
	
	private IBkclDao bkclDao;

	public void setBksjDao(IBksjDao bksjDao) {
		this.bksjDao = bksjDao;
	}

	public void setBkclDao(IBkclDao bkclDao) {
		this.bkclDao = bkclDao;
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 增加 */
	public Bkwpkbxx insertBkwpkbxx(Bkwpkbxx bkwpkbxx){
		// TODO: implement
		
		Bksj bksj = bkwpkbxx.getBksj();
		Bkcl bkcl = bkwpkbxx.getBkcl();
		Date currentDate = new Date();
		bkwpkbxx.setBkczsj(currentDate);
		bkwpkbxx = bkwpkbxxDao.insertBkwpkbxx(bkwpkbxx);
		if(bksj!=null){
			bksj.setBkwpjbxxid(bkwpkbxx.getBkwpjbxxid());
			bksjDao.insertBksj(bksj);
		}
		if(bkcl!=null){
			bkcl.setBkwpjbxxid(bkwpkbxx.getBkwpjbxxid());
			bkclDao.insertBkcl(bkcl);
		}
		return bkwpkbxx;
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 删除 */
	public boolean deleteBkwpkbxx(Bkwpkbxx bkwpkbxx){
		// TODO: implement
		
		Bksj bksj = bkwpkbxx.getBksj();
		Bkcl bkcl = bkwpkbxx.getBkcl();
		
		if(bksj!=null){
			bksj.setBkwpjbxxid(bkwpkbxx.getBkwpjbxxid());
			bksjDao.deleteBksj(bksj);
		}
		if(bkcl!=null){
			bkcl.setBkwpjbxxid(bkwpkbxx.getBkwpjbxxid());
			bkclDao.deleteBkcl(bkcl);
		}
		return bkwpkbxxDao.deleteBkwpkbxx(bkwpkbxx)>0;
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 修改 */
	public boolean updateBkwpkbxx(Bkwpkbxx bkwpkbxx){
		// TODO: implement
		
		Bksj bksj = bkwpkbxx.getBksj();
		Bkcl bkcl = bkwpkbxx.getBkcl();
		
		if(bksj!=null){
			///如果不为空 删除再添加
			bksj.setBkwpjbxxid(bkwpkbxx.getBkwpjbxxid());
			bksjDao.deleteBksj(bksj);
			bksjDao.insertBksj(bksj);
		}else{
			///如果为空 直接删除
			bksj =new Bksj();
			bksj.setBkwpjbxxid(bkwpkbxx.getBkwpjbxxid());
			bksjDao.deleteBksj(bksj);
		}
		if(bkcl!=null){
			bkcl.setBkwpjbxxid(bkwpkbxx.getBkwpjbxxid());
			bkclDao.deleteBkcl(bkcl);
			bkclDao.insertBkcl(bkcl);
		}else{
			bkcl = new Bkcl();
			bkcl.setBkwpjbxxid(bkwpkbxx.getBkwpjbxxid());
			bkclDao.deleteBkcl(bkcl);
		}
		return bkwpkbxxDao.updateBkwpkbxx(bkwpkbxx)>0;
	}
	
	
	/** @param 布控物品基本信息(t_bkwpkbxx) 修改(只修改单条数据) */
	public boolean updateBkwpkbxxOne(Bkwpkbxx bkwpkbxx){
		return bkwpkbxxDao.updateBkwpkbxx(bkwpkbxx)>0;
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 查询单条 */
	public Bkwpkbxx getBkwpkbxx(Bkwpkbxx bkwpkbxx){
		// TODO: implement
		return (Bkwpkbxx)bkwpkbxxDao.getBkwpkbxx(bkwpkbxx);
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return bkwpkbxxDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 布控物品基本信息(t_bkwpkbxx) 多条查询 */
	public List getListBkwpkbxx(Bkwpkbxx bkwpkbxx){
		// TODO: implement
		return bkwpkbxxDao.getListBkwpkbxx(bkwpkbxx);
	}

	public IBkwpkbxxDao getBkwpkbxxDao() {
		return bkwpkbxxDao;
	}

	public void setBkwpkbxxDao(IBkwpkbxxDao bkwpkbxxDao) {
		this.bkwpkbxxDao = bkwpkbxxDao;
	}
}
