package com.aisino2.icksystem.action;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aisino2.cache.CacheResult;
import com.aisino2.core.web.BaseAction;
import com.aisino2.icksystem.domain.AcceptIckInfoWs;
import com.aisino2.icksystem.domain.Icksl;
import com.aisino2.icksystem.service.IIckAcceptErrorServiceWS;
import com.aisino2.sysadmin.domain.Globalpar;


public class ZzzxjsErrorAction   extends BaseAction{
	
	private IIckAcceptErrorServiceWS ickAcceptErrorServiceWs;
	
	Icksl icksl=new Icksl();

	List lIcksl=new ArrayList();
	
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
		Document document;
		AcceptIckInfoWs acceptIckInfoWs=new AcceptIckInfoWs();
		CacheResult cacheResult=new CacheResult();
		Globalpar globalpar=new Globalpar();
		globalpar=cacheResult.getCacheGlobalpar("jdzkd");
		if (globalpar.getGlobalparvalue().equals("1")){
		
			try {
				Zzzxjk yzdl=new Zzzxjk();
				Object[] params;
				String sErrTxt=""; 
				params=new Object[3];
				params[0]="";
				params[1]="";
				params[2]="";
				
				boolean bFlag=yzdl.transfrStringWebService("GetMakeErrCardInfos",params);
				int iRows=yzdl.getICount();
				sErrTxt=yzdl.getSErrTxt();
				
				/**
				XMLDocument xmlDocument=new XMLDocument();
				File f=new File(ZkzxfsAction.class.getClassLoader().getResource("").getPath()+"Accept/GetMakeErrCardInfos/200905311723.txt"); 
				xmlDocument.pase(f);
				
				XMLElement xmlElement=xmlDocument.getRootElement();
				List lRows=xmlElement.getChildElements("MakeCardInfo");
				boolean bFlag=true;
				int iRows=lRows.size();
				sErrTxt="";
				**/
				if (sErrTxt.equals("") && bFlag==true){
					sXML=yzdl.getSXml();
					
					
					
					document = DocumentHelper.parseText(sXML);
					Element root=document.getRootElement();
					List lMakeCards=root.selectNodes("//ArrayOfMakeCardInfo/MakeCardInfo");
					String sApplyID="";
					String sZkztbs="";
					
					if (lIcksl.size()==0){
						if (iRows==lMakeCards.size()){
							
							for (int i=0;i<lMakeCards.size();i++){
								eMakeCard=(Element)lMakeCards.get(i);
								icksl=new Icksl();
								icksl.setIckslid(Integer.parseInt(eMakeCard.selectSingleNode("ApplyID").getStringValue()));
								sZkztbs=eMakeCard.selectSingleNode("CurrErrStateReason").getStringValue().split("-")[0];
								icksl.setZkztbs(sZkztbs);
								lIcksl.add(icksl);	
							}
							ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
									new String[] {	"config/spring/applicationContext.xml",
											"config/spring/sysadmin-dao.xml",
											"config/spring/sysadmin-service.xml",
											"config/spring/basicsystem-dao.xml",
											"config/spring/basicsystem-service.xml",
											"config/spring/icksystem-dao.xml",
											"config/spring/icksystem-service.xml"});
							
							//完成依赖注入
							ickAcceptErrorServiceWs = (IIckAcceptErrorServiceWS)ctx.getBean("ickAcceptErrorServiceWs");
							sApplyID=ickAcceptErrorServiceWs.getUpdateAcceptIckInfo(lIcksl);
							if (!sApplyID.equals("")){
								params=new Object[3];
								params[0]="";
								params[1]=sApplyID;
								params[2]="";
								yzdl.transfrWebService("RemoveMakeErrInfo",params);
							}
							lIcksl=new ArrayList();
						}	
					}
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
	public IIckAcceptErrorServiceWS getIckAcceptErrorServiceWs() {
		return ickAcceptErrorServiceWs;
	}
	public void setIckAcceptErrorServiceWs(
			IIckAcceptErrorServiceWS ickAcceptErrorServiceWs) {
		this.ickAcceptErrorServiceWs = ickAcceptErrorServiceWs;
	}
	
	
}
