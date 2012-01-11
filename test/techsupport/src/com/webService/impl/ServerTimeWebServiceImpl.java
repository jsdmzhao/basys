package com.webService.impl;
import java.util.Date;
import java.util.List;

import com.aisino2.cache.CacheManager;
import com.aisino2.common.DateToString;
import com.aisino2.sysadmin.domain.Globalpar;
import com.webService.IServerTimeWebService;
public class ServerTimeWebServiceImpl implements IServerTimeWebService{
  


	//返回服务器时间格式十四位的字符串20090922121109

	public String getServerTime14() {
		return DateToString.getDateTimeNoFormat14(new Date());
	}
	public String getFtpIpAccountPass() {
		// TODO Auto-generated method stub
		Globalpar globalpar = new Globalpar();
		globalpar.setGlobalparcode("ftpip");
		List list = CacheManager.getCacheGlobalpar(globalpar);
		String ftpIP="";
		if(list!=null&&list.size()>0){
			ftpIP =( ((Globalpar)list.get(0)).getGlobalparvalue()).toString();
			}
		globalpar.setGlobalparcode("ftpAccunt");
		List listftpAccunt = CacheManager.getCacheGlobalpar(globalpar);
		String ftpAccunt="";
		if(listftpAccunt!=null&&listftpAccunt.size()>0){
			ftpAccunt =( ((Globalpar)listftpAccunt.get(0)).getGlobalparvalue()).toString();
			}
		globalpar.setGlobalparcode("ftppass");
		List listpass = CacheManager.getCacheGlobalpar(globalpar);
		String ftppass="";
		if(listpass!=null&&listpass.size()>0){
			ftppass =( ((Globalpar)listpass.get(0)).getGlobalparvalue()).toString();
			}
		
		return ftpIP+","+ftpAccunt+","+ftppass;
	}
}
