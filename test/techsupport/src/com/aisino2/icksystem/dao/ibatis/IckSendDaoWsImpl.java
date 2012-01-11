package com.aisino2.icksystem.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.cache.CacheManager;
import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.icksystem.dao.IIckSendDaoWS;
import com.aisino2.icksystem.domain.SendIckInfoWs;
import com.aisino2.sysadmin.domain.Globalpar;

public class IckSendDaoWsImpl extends BaseDao implements IIckSendDaoWS {
	

	public List getSendIckInfoList() {
		// TODO Auto-generated method stub
		SendIckInfoWs  sendIckInfoWs = new SendIckInfoWs();
		
		Globalpar globalpar = new Globalpar();
		globalpar.setGlobalparcode("sfjxgarkkbd");
		List list = CacheManager.getCacheGlobalpar(globalpar);
		String sfjxgarkkbd="0";//是否进行核对 0 ，不核对，1核对
		if(list!=null&&list.size()>0){
			sfjxgarkkbd =( ((Globalpar)list.get(0)).getGlobalparvalue()).toString();
			}
		//
		sendIckInfoWs.setBeizhu(sfjxgarkkbd);
		
	   
		return queryForList(SendIckInfoWs.class.getName()+".getSendIckInfoWsListNoPage", sendIckInfoWs);
	}



	public int getUpdateSendIckInfo(SendIckInfoWs sendIckInfoWs) {
		// TODO Auto-generated method stub
		return  update(SendIckInfoWs.class.getName()+".updateSendIckInfoWs", sendIckInfoWs);
	}



	public Page getPage(Map arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}
}
