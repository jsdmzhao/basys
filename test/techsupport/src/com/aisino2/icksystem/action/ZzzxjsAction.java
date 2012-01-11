package com.aisino2.icksystem.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aisino2.cache.CacheResult;
import com.aisino2.common.DateToString;
import com.aisino2.core.web.BaseAction;
import com.aisino2.icksystem.domain.AcceptIckInfoWs;
import com.aisino2.icksystem.domain.AcceptIckWlInfoWs;
import com.aisino2.icksystem.domain.AcceptIckZbInfoWs;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.domain.Icksl_ickzb;
import com.aisino2.icksystem.domain.Icksl_wldj;
import com.aisino2.icksystem.domain.Ickzb;
import com.aisino2.icksystem.domain.Wldj;
import com.aisino2.icksystem.service.IIckAcceptServiceWS;
import com.aisino2.sysadmin.domain.Globalpar;

public class ZzzxjsAction   extends BaseAction{
	
	private IIckAcceptServiceWS ickAcceptServiceWs;
	AcceptIckWlInfoWs acceptIckWlInfoWs=new AcceptIckWlInfoWs();
	AcceptIckZbInfoWs acceptIckZbInfoWs=new AcceptIckZbInfoWs();
	String sZbCode="";
	String sWlbCode="";
	String sZkzt="";
	String sCjdCode="";
	
	Icksl icksl=new Icksl();
	Ickzb ickzb=new Ickzb();
	Icksl_ickzb ickslickzb=new Icksl_ickzb();
	Wldj wldj=new Wldj();
	Icksl_wldj ickslwldj=new Icksl_wldj();
	
	List lIckslickzb=new ArrayList();
	List lIckslwldj=new ArrayList();
	List IIckzb=new ArrayList();
	List lWldj=new ArrayList();
	List lIcksl=new ArrayList();
	List lZbIcksl=new ArrayList();
	List lWlIcksl=new ArrayList();
	List lIckErrorsl=new ArrayList();
	
	List lAcceptIckWlInfoWs=new ArrayList();
	List lAcceptIckZbInfoWs=new ArrayList();
	int iCjds=0;
	
	Element eMakeCard;
	/**
	 * 接收数据包

	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 */
	public void newAcceptCardList() {
		String sXML="";
		String sErrTxt="";
		int iRows=0;
		Document document;
		CacheResult cacheResult=new CacheResult();
		Globalpar globalpar=new Globalpar();
		globalpar=cacheResult.getCacheGlobalpar("jdzkd");
		if (globalpar.getGlobalparvalue().equals("1")){
			try {
				Zzzxjk yzdl=new Zzzxjk();
				Object[] params;
				params=new Object[3];
				params[0]="";
				params[1]="";
				params[2]="";
				boolean bFlag=yzdl.transfrStringWebService("GetMakeOkCardInfos",params);
				sXML=yzdl.getSXml(); 
				sErrTxt=yzdl.getSErrTxt(); 
				
				iRows=yzdl.getICount();
				if (sErrTxt.equals("") && bFlag==true){
					document = DocumentHelper.parseText(sXML);
					String sApplyID=setObject(document,iRows);
					params=new Object[3];
					params[0]="";
					params[1]=sApplyID;
					params[2]="";
					
					yzdl.transfrWebService("RemoveMakeOkInfo",params);
				}
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void getList(int flag){
		if (!sZbCode.equals("") && !sWlbCode.equals("") && (eMakeCard.selectSingleNode("CurrState").getStringValue().equals("2") || eMakeCard.selectSingleNode("CurrState").getStringValue().equals("10"))){
			lIckErrorsl.add(icksl);
			iCjds=0;
		}else{
			if (sZbCode.equals("") || !sZbCode.equals(eMakeCard.selectSingleNode("PrintBatchID").getStringValue()) || flag==1){
				ickzb=new Ickzb();
				ickzb.setPch(eMakeCard.selectSingleNode("PrintBatchID").getStringValue());
				ickzb.setZbr(eMakeCard.selectSingleNode("PrintCardName").getStringValue());
				ickzb.setZbsj(DateToString.toDate14(eMakeCard.selectSingleNode("PrintCardBeginTime").getStringValue()));
				ickzb.setSlds(iCjds);
				if (!sZbCode.equals("")){
					ickzb.setLIcksl_ickzb(lIckslickzb);
					acceptIckZbInfoWs.setIckzb(ickzb);
					acceptIckZbInfoWs.setIckslList(lZbIcksl);
					lAcceptIckZbInfoWs.add(acceptIckZbInfoWs);
				}
				iCjds=0;
				sZbCode=ickzb.getPch();
				lIckslickzb=new ArrayList();
				lZbIcksl=new ArrayList();
				acceptIckZbInfoWs=new AcceptIckZbInfoWs();
			}
			
			if (sWlbCode.equals("") || (eMakeCard.nodeCount()>0 && !sWlbCode.equals(eMakeCard.selectSingleNode("ConsignmentID").getStringValue())) || flag==1){				
				if (!sWlbCode.equals("")){
					wldj.setLIcksl_wldj(lIckslwldj);
					acceptIckWlInfoWs.setWldj(wldj);
					acceptIckWlInfoWs.setIckslList(lWlIcksl);
					lAcceptIckWlInfoWs.add(acceptIckWlInfoWs);
				}
				wldj=new Wldj();
				wldj.setWlpc(eMakeCard.selectSingleNode("ConsignmentID").getStringValue());
				wldj.setMbsldbh(eMakeCard.selectSingleNode("CollectionID").getStringValue());
				wldj.setMbsldmc(eMakeCard.selectSingleNode("CollectionName").getStringValue());
				wldj.setFsr(eMakeCard.selectSingleNode("PrintCardName").getStringValue());
				wldj.setFssj(DateToString.toDate14(eMakeCard.selectSingleNode("PrintCardEndTime").getStringValue()));
				sWlbCode=wldj.getWlpc();
				lIckslwldj=new ArrayList();
				lWlIcksl=new ArrayList();
				acceptIckWlInfoWs=new AcceptIckWlInfoWs();
			}
		}
	}
	public String setObject(Document document,int iRows){
		AcceptIckInfoWs acceptIckInfoWs=new AcceptIckInfoWs();
		Element root=document.getRootElement();
		List lMakeCards=root.selectNodes("//ArrayOfMakeCardInfo/MakeCardInfo");
		String sApplyID="";
		if 	(iRows==lMakeCards.size()){
			for (int i=0;i<lMakeCards.size();i++){
				eMakeCard=(Element)lMakeCards.get(i);
				getList(0);
				if (sApplyID.equals(""))
					sApplyID=eMakeCard.selectSingleNode("ApplyID").getStringValue();
				else{
					sApplyID+=","+eMakeCard.selectSingleNode("ApplyID").getStringValue();
				}
				icksl=new Icksl();
				icksl.setIckslid(Integer.parseInt(eMakeCard.selectSingleNode("ApplyID").getStringValue()));
				icksl.setDxrsj(DateToString.toDate14(eMakeCard.selectSingleNode("WriteCardTime").getStringValue()));
				icksl.setYssj(DateToString.toDate14(eMakeCard.selectSingleNode("PrintCardEndTime").getStringValue()));
				lWlIcksl.add(icksl);
				lZbIcksl.add(icksl);
				
				if (!sCjdCode.equals(eMakeCard.selectSingleNode("CollectionID").getStringValue())){
					iCjds=iCjds+1;
				}
				
				ickslickzb=new Icksl_ickzb();
				ickslickzb.setIckslid(icksl.getIckslid());
				ickslickzb.setPczdpbh(Integer.parseInt(eMakeCard.selectSingleNode("PrintSerial").getStringValue()));
				ickslickzb.setZbhsuym(Integer.parseInt(eMakeCard.selectSingleNode("PrintPackageID").getStringValue()));
				lIckslickzb.add(ickslickzb);
				
				ickslwldj=new Icksl_wldj();
				ickslwldj.setIckslid(icksl.getIckslid());
				lIckslwldj.add(ickslwldj);
				
				if (i==lMakeCards.size()-1){
						getList(1);
				}
			}
			acceptIckInfoWs.setAcceptErrorIckslList(lIckErrorsl);
			acceptIckInfoWs.setAcceptIckZbInfoWsList(lAcceptIckZbInfoWs);
			acceptIckInfoWs.setAcceptIckWlInfWsList(lAcceptIckWlInfoWs);
			
			lAcceptIckWlInfoWs=new ArrayList();
			lAcceptIckZbInfoWs=new ArrayList();
			sZbCode="";
			sWlbCode="";
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
					new String[] {	"config/spring/applicationContext.xml",
									"config/spring/sysadmin-dao.xml",
									"config/spring/sysadmin-service.xml",
									"config/spring/basicsystem-dao.xml",
									"config/spring/basicsystem-service.xml",
									"config/spring/icksystem-dao.xml",
									"config/spring/icksystem-service.xml"});
			//完成依赖注入
			ickAcceptServiceWs = (IIckAcceptServiceWS)ctx.getBean("ickAcceptServiceWs");
			ickAcceptServiceWs.getUpdateAcceptIckInfo(acceptIckInfoWs);
			return sApplyID;
		}
		return sApplyID;	
	}
	//手工生成
	public void getdata(){
		Element eWeb=null;
		Element root=getXmlObject(ZzzxfsAction.class.getClassLoader().getResource("").getPath()+"config/jsrq.xml");
		List lweb=root.selectNodes("//WebServices/WebService");
		String sDate="";
		for (int i=0;i<lweb.size();i++){
			eWeb=(Element)lweb.get(i);
			if (eWeb.attributeValue("name").equals("Zkzxjs")){
				sDate=eWeb.selectSingleNode("Date").getStringValue();
			}
		}
		String sFilename=sDate+"1015.txt";
		//String sFilename=sDate.substring(0, 3)+"-"+sDate.substring(4, 5)+"-"+sDate.substring(6, 7)+".txt";
		String sPath=ZzzxjsAction.class.getClassLoader().getResource("").getPath()+"Accept/GetMakeOkCardInfos/"+sDate+"/"+sFilename;
		Element element=getXmlObject(sPath);
		List lRows=element.selectNodes("MakeCardInfo");
		int iRows=lRows.size();
		Document document;
		try {
			document = DocumentHelper.parseText(element.asXML());
			String sApplyID=setObject(document,iRows);
			Object[] params=new Object[3];
			params[0]="";
			params[1]=sApplyID;
			params[2]="";
			//Zzzxjk yzdl=new Zzzxjk();
			//yzdl.transfrWebService("RemoveMakeOkInfo",params);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public IIckAcceptServiceWS getIckAcceptServiceWs() {
		return ickAcceptServiceWs;
	}
	public void setIckAcceptServiceWs(IIckAcceptServiceWS ickAcceptServiceWs) {
		this.ickAcceptServiceWs = ickAcceptServiceWs;
	}
	//读取xml
	public Element getXmlObject(String sPath){
		try { 
			SAXReader saxReader = new SAXReader();  
			Document documentXML = saxReader.read(new File(sPath));
			Element rootXML=documentXML.getRootElement();
			return rootXML;
		} catch (Exception je) {	
			//提示框的提示内容 
			je.printStackTrace(); 
			return null;
		} 

	}
}
