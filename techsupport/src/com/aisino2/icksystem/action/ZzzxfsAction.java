package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aisino2.cache.CacheResult;
import com.aisino2.common.Base64;
import com.aisino2.common.DateToString;
import com.aisino2.core.web.BaseAction;
import com.aisino2.icksystem.domain.SendIckInfoWs;
import com.aisino2.icksystem.domain.Zzzxsc;
import com.aisino2.icksystem.service.IIckSendServiceWS;
import com.aisino2.sysadmin.domain.Globalpar;

public class ZzzxfsAction extends BaseAction{
	
	private IIckSendServiceWS ickSendServiceWs;
		
	public void setIckSendServiceWs(IIckSendServiceWS ickSendServiceWs) {
		this.ickSendServiceWs = ickSendServiceWs;
	}
	
	public IIckSendServiceWS getIckSendServiceWs() {
		return ickSendServiceWs;
	}
	/**
	 * 生成数据包
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 */
	public void newCardList() {
		
		StringBuffer sbXML=new StringBuffer();
		String sXml="";
		CacheResult cacheResult=new CacheResult();
		Globalpar globalpar=new Globalpar();
		globalpar=cacheResult.getCacheGlobalpar("jdzkd");
		if (globalpar.getGlobalparvalue().equals("1")){
			try {
				//System.out.println("globalpar.getGlobalparvalue()2="+globalpar.getGlobalparvalue());
				Zzzxjk yzdl=new Zzzxjk();
				String sAccesscode=yzdl.getSAccesscode();
				Object[] params;
				String sErrTxt=yzdl.getSErrTxt(); 
				
				sbXML.append("<?xml version=\"1.0\" encoding=\"utf-16\"?>");
				sbXML.append("<ArrayOfMakeCardInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">");
				List sendList=new ArrayList();
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
						new String[] {	"config/spring/applicationContext.xml",
										"config/spring/sysadmin-dao.xml",
										"config/spring/sysadmin-service.xml",
										"config/spring/basicsystem-dao.xml",
										"config/spring/basicsystem-service.xml",
										"config/spring/icksystem-dao.xml",
										"config/spring/icksystem-service.xml"});
				
				//完成依赖注入
				ickSendServiceWs = (IIckSendServiceWS)ctx.getBean("ickSendServiceWs");
	
				sendList=ickSendServiceWs.getSendIckInfoList();
				if(sendList==null) sendList = new ArrayList();
				int iRows=sendList.size();
				if (sendList.size()>10)
					iRows=10;
				List updateList=new ArrayList();	
				for (int i=0;i<iRows;i++){
					SendIckInfoWs sendIckInfoWs=(SendIckInfoWs)sendList.get(i);
					
					sbXML.append("<MakeCardInfo>");
					sbXML.append(setXMl("ApplyID",Integer.toString(sendIckInfoWs.getIckslid())));
					sbXML.append(setXMl("AccessUserLoginName",sAccesscode));
					sbXML.append(setXMl("EmpCode",sendIckInfoWs.getCyrybh()));	
					sbXML.append(setXMl("CollectionID",sendIckInfoWs.getCjdbm()));			
					sbXML.append(setXMl("CollectionName",sendIckInfoWs.getCjdmc()));
					sbXML.append(setXMl("LocalCantonCode",sendIckInfoWs.getCjdbm().substring(3, sendIckInfoWs.getCjdbm().length())));
					sbXML.append(setXMl("NotifyTime",DateToString.getDateNoFormat(new Date())));
					sbXML.append(setXMl("Informer",sendIckInfoWs.getCjr()));
					sbXML.append(setXMl("MakeCardReason","0"));
					sbXML.append(setXMl("CardID",sendIckInfoWs.getIckslh()));
					sbXML.append(setXMl("Name",sendIckInfoWs.getXingming()));
					sbXML.append(setXMl("SexCode",sendIckInfoWs.getXb()));
					sbXML.append(setXMl("ENLastName",sendIckInfoWs.getYwx()));
					sbXML.append(setXMl("ENFirstName",sendIckInfoWs.getYwm()));
					sbXML.append(setXMl("Birthday",DateToString.getDateNoFormat(sendIckInfoWs.getCsrq())));
					sbXML.append(setXMl("Photo",Base64.getBASE64(sendIckInfoWs.getWjnr())));
					sbXML.append(setXMl("NationalityCode",sendIckInfoWs.getGj()));
					sbXML.append(setXMl("FolkCode",sendIckInfoWs.getMinzu()));
					sbXML.append(setXMl("PlaceOfBirCantonCode",sendIckInfoWs.getHjsx()));
					sbXML.append(setXMl("PlaceOfBirCantonAddress",sendIckInfoWs.getHjdxz()));
					sbXML.append(setXMl("IDCard",sendIckInfoWs.getZjhm()));
					sbXML.append(setXMl("StayCardCode",sendIckInfoWs.getZzzhm()));
					sbXML.append(setXMl("StayAddress",sendIckInfoWs.getXzd()));
					sbXML.append(setXMl("ForeignerLicenceCode",sendIckInfoWs.getWgrjyxkz()));
					sbXML.append(setXMl("EmpTypeCode",sendIckInfoWs.getCyrylb()));
					sbXML.append(setXMl("BeginDate",DateToString.getDateNoFormat(sendIckInfoWs.getYxsksrq())));
					sbXML.append(setXMl("EndDate",DateToString.getDateNoFormat(sendIckInfoWs.getYxqhzrq())));
					sbXML.append(setXMl("Remark",sendIckInfoWs.getBeizhu()));
					sbXML.append("</MakeCardInfo>");
					sendIckInfoWs.setZkztbs("10");
					updateList.add(sendIckInfoWs);
				}
				sbXML.append("</ArrayOfMakeCardInfo>");
				sXml=sbXML.toString();
				
				
				
				
				
				//if (sErrTxt.equals("")){
				if (sErrTxt.equals("") && sendList.size()>0){
					
					sXml=sXml.replaceAll("null", "");
					params=new Object[4];
					params[0]=sAccesscode;
					params[1]=sXml;
					params[2]="";
					params[3]="";
					yzdl.transfrXmlWebService("SendMakeCardInfos",params);
	
					sXml=yzdl.getSXml(); 
					int iCount=yzdl.getICount();
					sErrTxt=yzdl.getSErrTxt(); 
					if (sXml.equals("true")){
						if (iCount==iRows){
							ickSendServiceWs.getUpdateSendIckInfo(updateList);
						}	
					}else if (!sXml.equals("true") && !sXml.equals("false")){
						Document document = DocumentHelper.parseText(sXml);
						Element root=document.getRootElement();
						Element eErrorCard;
						Integer iArryID=0;
						String sErrtxt="";
						List lErrorMessage=root.selectNodes("//ArrayOfErrorItem/ErrorItem");
						Zzzxsc zzzxsc=new Zzzxsc();
						String error="";
						for (int i=0;i<lErrorMessage.size();i++){
							eErrorCard=(Element)lErrorMessage.get(i);
							iArryID=Integer.parseInt(eErrorCard.selectSingleNode("ErrApplyId").getStringValue());
							sErrtxt=eErrorCard.selectSingleNode("ErrTxt").getStringValue();
							error=sErrtxt.split("-")[1];
							sErrTxt=sErrtxt.split("-")[0];
							for (int a=0;a<updateList.size();a++){
								SendIckInfoWs sendIckInfoWs=(SendIckInfoWs)updateList.get(a);
								if (iArryID==sendIckInfoWs.getIckslid()){
									updateList.remove(a);
									if (!sErrTxt.equals("4")){
										zzzxsc=new Zzzxsc();
										sendIckInfoWs.setZkztbs("11");
										zzzxsc.setSjscbz("0");
										zzzxsc.setZzcwyy(error);
										sendIckInfoWs.setZzzxsc(zzzxsc);
										updateList.add(sendIckInfoWs);
									}
									break;
								}
							}
						}
						ickSendServiceWs.getUpdateSendIckInfo(updateList);
					}
					//System.out.println("SendMakeCardInfos："+sXml+"="+sErrTxt);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private String setXMl(String xmlnode,String xmlvalue){
		return "<"+xmlnode+">"+xmlvalue+"</"+xmlnode+">";
	}
	
	
}
