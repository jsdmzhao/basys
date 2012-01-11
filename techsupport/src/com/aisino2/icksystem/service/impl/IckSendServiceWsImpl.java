package com.aisino2.icksystem.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.icksystem.dao.IIckSendDaoWS;
import com.aisino2.icksystem.dao.IZzzxscDao;
import com.aisino2.icksystem.domain.SendIckInfoWs;
import com.aisino2.icksystem.domain.Zzzxsc;
import com.aisino2.icksystem.service.IIckSendServiceWS;

public class IckSendServiceWsImpl extends BaseService implements IIckSendServiceWS {

	private IIckSendDaoWS ickSendDaoWs;
	private IZzzxscDao zzzxscDao;

	public IZzzxscDao getZzzxscDao() {
		return zzzxscDao;
	}

	public void setZzzxscDao(IZzzxscDao zzzxscDao) {
		this.zzzxscDao = zzzxscDao;
	}

	public IIckSendDaoWS getIckSendDaoWs() {
		return ickSendDaoWs;
	}

	public void setIckSendDaoWs(IIckSendDaoWS ickSendDaoWs) {
		this.ickSendDaoWs = ickSendDaoWs;
	}

	public List getSendIckInfoList() {
		// TODO Auto-generated method stub
		List list =  ickSendDaoWs.getSendIckInfoList();
		if(list==null||list.size()==0){
			return null;
		}else{
			return list;
		}
	}

	public int getUpdateSendIckInfo(List list) {
		// TODO Auto-generated method stub
		if(list==null||list.size()==0){
			return 0;
		}else{
			SendIckInfoWs  sendIckInfoWs = null;
			Zzzxsc zzzxsc=new Zzzxsc();
		 for(int i =0;i<list.size();i++){
			 sendIckInfoWs=(SendIckInfoWs)list.get(i);
			 zzzxsc=new Zzzxsc();
			 zzzxsc.setFssj(new Date());
			 zzzxsc.setIckslid(sendIckInfoWs.getIckslid());
			 /*zzzxsc.setCsid(sendIckInfoWs.getCsid());
		 	 zzzxsc.setRyid(sendIckInfoWs.getRyid());*/
			 if (sendIckInfoWs.getZzzxsc()==null){
				 zzzxsc.setSjscbz("1");
			 	 
			 }
			 sendIckInfoWs = (SendIckInfoWs)list.get(i);
			 sendIckInfoWs.setFszkzxsj(new Date());
			 ickSendDaoWs.getUpdateSendIckInfo(sendIckInfoWs);
			 zzzxscDao.insertZzzxsc(zzzxsc);
		 }
		 
		}
		return 1;
	}

	public Page getPage(Map arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}
	


	

	
}
