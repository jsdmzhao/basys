package com.webService.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.aisino2.basicsystem.dao.IBjxxbDao;
import com.aisino2.cache.CacheManager;
import com.aisino2.common.NullEntityResolver;
import com.aisino2.common.StringUtil;
import com.aisino2.sysadmin.domain.Globalpar;
import com.webService.IBaoJingWebService;
public class BaoJingWebServiceImpl implements IBaoJingWebService{
	
 
 	 
 	 
	private IBjxxbDao bjxxbDao;
	public IBjxxbDao getBjxxbDao() {
		return bjxxbDao;
	}
	public void setBjxxbDao(IBjxxbDao bjxxbDao) {
		this.bjxxbDao = bjxxbDao;
	}
	
	public int getBaojingCount(String jqztdm,String gxdwbm) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		map.put("jqztdm", jqztdm);
		map.put("gxdwbm", StringUtil.trimEven0(gxdwbm)+"%");
		return bjxxbDao.getBjxxbCount(map);
		
	}
	public String getSessionOutA() {
		//      /D:/PROJECTS/scpt/WebRoot/WEB-INF/classes/
		//System.getProperty("user.dir");
		String classPathName="";
		try{
//			 ss= this.getClass().getClassLoader().getResource("").getPath();
//			 ss =ss.replace("/","\\\\");
//			ss = ss.substring(2, ss.length()-9);
//			ss=ss+"web.xml";
			 classPathName = BaoJingWebServiceImpl.class.getClassLoader().getResource("struts.xml").getPath();
		    // String classPathName = BaoJingWebServiceImpl.class.getClassLoader().getResource("web.xml").getPath(); 
			int endingIndex = classPathName.length()-"struts.xml".length();
			classPathName = classPathName.substring(0, endingIndex);
			
			    String sPath="/";
				if(classPathName.indexOf(":")!=-1){
					sPath="\\";
					classPathName =classPathName.replace("/",sPath);
				}
				classPathName = classPathName.substring(0, classPathName.length()-9);
				classPathName=classPathName+sPath+"web.xml";
				

			File file = new File(classPathName);
			SAXReader reader = new SAXReader();
			
			//去掉取消DTD的验证start
			       NullEntityResolver resolver = new NullEntityResolver();
			      reader.setEntityResolver(resolver);
			//去掉取消DTD的验证end
			
//			Document doc = reader.read(file);
//			XMLDocument xmlDocument = new XMLDocument();
//		 	xmlDocument.paseText(doc.asXML());
//		 	XMLElement xml=xmlDocument.getRootElement();
//		 	int time = Integer.parseInt(xml.selectSingleElement("//session-timeout").getText());
		     	 Document xmlDoc=reader.read(file);   
		     	Element	element =xmlDoc.getRootElement();
		     	Element ele = element.element("session-config");
		     	String times =ele.elementText("session-timeout");
			    int time = Integer.parseInt(times);
		 	Globalpar globalpar = new Globalpar();
			globalpar.setGlobalparcode("bjsxzxsj");
			List list = CacheManager.getCacheGlobalpar(globalpar);
			String bjsxzxsj="30";
			if(list!=null&&list.size()>0){
				bjsxzxsj =( ((Globalpar)list.get(0)).getGlobalparvalue()).toString();
				}
		 	return time*60+","+bjsxzxsj;
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println("7============"+classPathName);
			return "";//0异常
		}
	}
	
	public int getSessionOut() {
		//      /D:/PROJECTS/scpt/WebRoot/WEB-INF/classes/
		//System.getProperty("user.dir");
		String classPathName="";
		try{
			 classPathName = BaoJingWebServiceImpl.class.getClassLoader().getResource("struts.xml").getPath();
			 //1============/D:/IBM/WebSphere/AppServer/profiles/AppSrv01/installedApps/scptdbCell01/SCPT-GZ_war.ear/SCPT-GZ.war/WEB-INF/classes/struts.xml
			int endingIndex = classPathName.length()-"struts.xml".length();
			classPathName = classPathName.substring(0, endingIndex);
		    String sPath="/";
			if(classPathName.indexOf(":")!=-1){
				sPath="\\";
				classPathName =classPathName.replace("/",sPath);
			}
			classPathName = classPathName.substring(0, classPathName.length()-9);
			classPathName=classPathName+sPath+"web.xml";
			
			File file = new File(classPathName);
			   SAXReader reader=new SAXReader();   
			 //去掉取消DTD的验证start
		       NullEntityResolver resolver = new NullEntityResolver();
		      reader.setEntityResolver(resolver);
		     //去掉取消DTD的验证end
		 	 Document xmlDoc=reader.read(file);   
		     	Element	element =xmlDoc.getRootElement();
		     	Element ele = element.element("session-config");
		     	String times =ele.elementText("session-timeout");
			    int time = Integer.parseInt(times);
		 	   return time*60;

		}catch(Exception e){
			e.printStackTrace();
			return 0;//0异常
		}
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
