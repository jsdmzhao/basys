package com.aisino2.publicsystem.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.publicsystem.dao.IWscqyDao;
import com.aisino2.publicsystem.domain.Wscqy;
import com.aisino2.publicsystem.service.IWscqyService;

public class WscqyServiceImpl extends BaseService implements IWscqyService {

	private IWscqyDao wscqyDao;

	/** @param 未上传企业(t_wscqy) 增加 */
	public Wscqy insertWscqy(Wscqy wscqy){
		// TODO: implement
		return (Wscqy)wscqyDao.insertWscqy(wscqy);
	}

	/** @param 未上传企业(t_wscqy) 删除 */
	public boolean deleteWscqy(Wscqy wscqy){
		// TODO: implement
		return wscqyDao.deleteWscqy(wscqy)>0;
	}

	/** @param 未上传企业(t_wscqy) 修改 */
	public boolean updateWscqy(Wscqy wscqy){
		// TODO: implement
		return wscqyDao.updateWscqy(wscqy)>0;
	}

	/** @param 未上传企业(t_wscqy) 查询单条 */
	public Wscqy getWscqy(Wscqy wscqy){
		// TODO: implement
		return (Wscqy)wscqyDao.getWscqy(wscqy);
	}

	/** @param 未上传企业(t_qyscbcf) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		getConditions(map);
		
		return wscqyDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}
	private void getConditions(Map map) {
		String groupBy = "";
		String selectConditon = "";
			groupBy = "a.dsjgdm,a.dsjgmc" + ",a.fxjdm,a.fxjmc" + ",a.gxdwdm,a.gxdwmc"
					+ ",a.qybm,a.qymc" +",a.hylbdm,a.hylb";
			selectConditon = groupBy;
		
		map.put("groupBy", groupBy);
		map.put("selectConditon", selectConditon);
	}
	/** @param 未上传企业(t_wscqy) 多条查询 */
	public List getListWscqy(Wscqy wscqy){
		// TODO: implement
		return wscqyDao.getListWscqy(wscqy);
	}

	public IWscqyDao getWscqyDao() {
		return wscqyDao;
	}

	public void setWscqyDao(IWscqyDao wscqyDao) {
		this.wscqyDao = wscqyDao;
	}

	public Page getXxListForPage(Map map, int pageNo, int pageSize,
			String sort, String desc) {
		// TODO Auto-generated method stub
		return wscqyDao.getXxListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 未上传企业(t_qyscbcf) 分页查询 采集点台账用*/
	public Page getWscqyListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return wscqyDao.getWscqyListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 未上传企业(t_qyscbcf) 分页查询 采集点台账用*/
	public Page getSkcstjListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		String groupBy = "";
		String selectTab="";
		if(((String)map.get("gxdwbz")).equalsIgnoreCase("1"))
		{
			groupBy = "a.dsjgdm,a.dsjgmc,a.fxjdm,a.fxjmc,a.gxdwdm,a.gxdwmc";
			selectTab = groupBy;
		}else if(((String)map.get("fxjbz")).equalsIgnoreCase("1"))
		{
			groupBy = "a.dsjgdm,a.dsjgmc,a.fxjdm,a.fxjmc";
			selectTab = groupBy + ",'' as gxdwdm,'' as gxdwmc";
		}else if(((String)map.get("dsjgbz")).equalsIgnoreCase("1"))
		{
			groupBy = "a.dsjgdm,a.dsjgmc";
			selectTab = groupBy + ",'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
		}else{
			groupBy="";
			selectTab="'' as dsjgdm,'' as dsjgmc,'' as fxjdm,'' as fxjmc,'' as gxdwdm,'' as gxdwmc";
		}
		map.put("groupBy", groupBy);
		map.put("selectTab", selectTab);
		return wscqyDao.getSkcstjListForPage(map,pageNo,pageSize,sort,desc);
	}
	
	/** @param 未上传企业(t_wscqy) 分页查询 企业刷卡未上传明细*/
	public Page getSkwscmxListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		return wscqyDao.getSkwscmxListForPage(map,pageNo,pageSize,sort,desc);
	}
}
