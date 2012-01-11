package com.aisino2.basicsystem.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.aisino2.basicsystem.dao.IGatztbDao;
import com.aisino2.basicsystem.dao.IGatztb_fjDao;
import com.aisino2.basicsystem.dao.IGatztbjsdwDao;
import com.aisino2.basicsystem.domain.Gatztb;
import com.aisino2.basicsystem.domain.Gatztb_fj;
import com.aisino2.basicsystem.domain.Gatztbjsdw;
import com.aisino2.basicsystem.service.IGatztbService;
import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;

public class GatztbServiceImpl extends BaseService implements IGatztbService {

	private IGatztbDao gatztbDao;
	private IGatztb_fjDao gatztb_fjDao;
	private IGatztbjsdwDao gatztbjsdwDao;

	/** @param 公安通知通报(t_gatztb) 增加 */
	public Gatztb insertGatztb(Gatztb gatztb){
		gatztbDao.insertGatztb(gatztb);
		List fjList=gatztb.getLXctbfjList();
		if(fjList!=null){
			for(int i=0;i<fjList.size();i++){
				Gatztb_fj fj=(Gatztb_fj)fjList.get(i);
				fj.setGatbid(gatztb.getGatbid());
				gatztb_fjDao.insertGatztb_fj(fj);
			}
		}
		if(gatztb.getJsdwMap()!=null){
			Map<String, String> jsdwmap=gatztb.getJsdwMap();
			for(Entry<String,String> e : jsdwmap.entrySet()){
				Gatztbjsdw jsdw=new Gatztbjsdw();
				jsdw.setGatbid(gatztb.getGatbid());
				jsdw.setJsdwbm(e.getKey());
				jsdw.setJsdwmc(e.getValue());
				gatztbjsdwDao.insertGatztbjsdw(jsdw);
			}
		}
		return gatztb;
	}

	/** @param 公安通知通报(t_gatztb) 删除 */
	public boolean deleteGatztb(Gatztb gatztb){
		Gatztb newGatztb=new Gatztb();
		newGatztb.setGatbid(gatztb.getGatbid());
		newGatztb.setGqbs("0");
		// TODO: implement
		return gatztbDao.deleteGatztb(gatztb)>0;
	}

	/** @param 公安通知通报(t_gatztb) 修改 */
	public boolean updateGatztb(Gatztb gatztb){
		List fjList=gatztb.getLXctbfjList();
		if(fjList!=null){
			for(int i=0;i<fjList.size();i++){
				Gatztb_fj fj=(Gatztb_fj)fjList.get(i);
				fj.setGatbid(gatztb.getGatbid());
				gatztb_fjDao.insertGatztb_fj(fj);
			}
		}
		return gatztbDao.updateGatztb(gatztb)>0;
	}

	/** @param 公安通知通报(t_gatztb) 查询单条 */
	public Gatztb getGatztb(Gatztb gatztb){
		// TODO: implement
		return (Gatztb)gatztbDao.getGatztb(gatztb);
	}

	/** @param 公安通知通报(t_gatztb) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return gatztbDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 公安通知通报(t_gatztb) 多条查询 */
	public List getListGatztb(Gatztb gatztb){
		// TODO: implement
		return gatztbDao.getListGatztb(gatztb);
	}

	public IGatztbDao getGatztbDao() {
		return gatztbDao;
	}

	public void setGatztbDao(IGatztbDao gatztbDao) {
		this.gatztbDao = gatztbDao;
	}

	public IGatztb_fjDao getGatztb_fjDao() {
		return gatztb_fjDao;
	}

	public void setGatztb_fjDao(IGatztb_fjDao gatztb_fjDao) {
		this.gatztb_fjDao = gatztb_fjDao;
	}

	public IGatztbjsdwDao getGatztbjsdwDao() {
		return gatztbjsdwDao;
	}

	public void setGatztbjsdwDao(IGatztbjsdwDao gatztbjsdwDao) {
		this.gatztbjsdwDao = gatztbjsdwDao;
	}
}
