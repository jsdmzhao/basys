package com.aisino2.icksystem.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

import org.codehaus.xfire.client.Client;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.aisino2.common.DateToString;

public class Zzzxjk {
	private String sUrl="";
	private String sUserName="";
	private String sPassword="";
	private String sAccesscode="";
	private String sErrTxt="";
	private boolean bFlag;
	private int iCount=0;
	private String sXml="";
	private String sReturn="";
	private Document documentXML;
	private Client client;
	private Element eWeb;
	private Object[] params;
	private Object[] oret;
	private List lweb;
	public Zzzxjk(){
		Element root=getXmlObject(ZzzxfsAction.class.getClassLoader().getResource("").getPath()+"config/webserviceConfig.xml");
		lweb=root.selectNodes("//WebServices/WebService");
		try {
			setValue();		
			client=new Client(new java.net.URL(sUrl));
			
			if (sAccesscode.equals("")){
				getLogin();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void setValue(){
		for (int i=0;i<lweb.size();i++){
			eWeb=(Element)lweb.get(i);
			if (eWeb.attributeValue("name").equals("Zkzx")){
				sUrl=eWeb.selectSingleNode("Url").getStringValue();
				sUserName=eWeb.selectSingleNode("UserName").getStringValue();
				sPassword=eWeb.selectSingleNode("Password").getStringValue();
				sAccesscode=eWeb.selectSingleNode("Accesscode").getStringValue();
			}
		}
	}
	
	public boolean transfrWebService(String inteface,Object[] params){
		
		Object[] oret;
		try {
			if (createFile((String)params[1],"Send",inteface)){
				params[0]=sAccesscode;
				oret = client.invoke(inteface,params);
				setBlogResponse(oret,params);
				sReturn=bFlag+"======"+iCount+"======"+sErrTxt;
				createFile(sReturn,"Accept",inteface);
				if (sErrTxt.equals("1-用户未被验证或未被授权.")){
					getLogin();
					params[0]=sAccesscode;
					oret = client.invoke(inteface,params);
					setBlogResponse(oret,params);
					sReturn=bFlag+"======"+iCount+"======"+sErrTxt;
					createFile(sReturn,"Accept",inteface);
				}
				
			}else{
				bFlag=true;
				sErrTxt="创建文件失败！";
			}
			return bFlag;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean transfrStringWebService(String inteface,Object[] params){
		
		Object[] oret;
		try {
			params[0]=sAccesscode;
			oret = client.invoke(inteface,params);
			setStringResponse(oret,params);
			sReturn=sXml+"\n============\n"+iCount+"\n============\n"+sErrTxt;
			createFile(sReturn,"Accept",inteface);
			if (sErrTxt.equals("1-用户未被验证或未被授权.")){
				getLogin();
				params[0]=sAccesscode;
				oret = client.invoke(inteface,params);
				setStringResponse(oret,params);
				sReturn=sXml+"\n============\n"+iCount+"\n============\n"+sErrTxt;
				createFile(sReturn,"Accept",inteface);
			}
			if (sErrTxt.equals(""))
				return true;
			else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean transfrXmlWebService(String inteface,Object[] params){
		
		Object[] oret;
		try {
			params[0]=sAccesscode;
			createFile((String)params[1],"Send",inteface);
			oret = client.invoke(inteface,params);
			setXmlResponse(oret,params);
			sReturn=sXml+"\n============\n"+iCount+"\n============\n"+sErrTxt;
			createFile(sReturn,"Accept",inteface);
			if (sErrTxt.equals("1-用户未被验证或未被授权.")){
				getLogin();
				params[0]=sAccesscode;
				oret = client.invoke(inteface,params);
				setXmlResponse(oret,params);
				sReturn=sXml+"\n============\n"+iCount+"\n============\n"+sErrTxt;
				createFile(sReturn,"Accept",inteface);
			}
			if (sErrTxt.equals(""))
				return true;
			else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	private void setBlogResponse(Object[] oret,Object[] params){
		bFlag=(Boolean)oret[0]; 
		int iP=1;
		for (int i=2;i<params.length;i++){
			if (params[i].equals("")){
				if (i!=params.length-1){
					iCount=(Integer)oret[iP]; 
				}else{
					sErrTxt=(String)oret[iP]; 
				}
				iP=iP+1;
			}
		}
	}
	private void setStringResponse(Object[] oret,Object[] params){
		sXml=(String)oret[0]; 
		int iP=1;
		for (int i=1;i<params.length;i++){
			if (params[i].equals("")){
				if (i!=params.length-1){
					iCount=(Integer)oret[iP]; 
				}else{
					sErrTxt=(String)oret[iP]; 
				}
				iP=iP+1;
			}
		}
	}
	private void setXmlResponse(Object[] oret,Object[] params){
		if (oret.length==2){
			sXml=(String)oret[0]; 
			sErrTxt=(String)oret[1];
		}else if (oret.length==3){
			sXml=(String)oret[0]; 
			iCount=(Integer)oret[1];
			sErrTxt=(String)oret[2];
		}
	}
	private boolean createFile(String sXml,String sPath,String sFilePath){
		try {
			// 新建一输出文件流

			String sCreatePath=ZzzxfsAction.class.getClassLoader().getResource("").getPath()+sPath+"/"+sFilePath+"/"+DateToString.getDateNoFormat(new Date());
			if(!(new File(sCreatePath).isDirectory())){
					new File(sCreatePath).mkdir();	
			}
			String sFielName=sCreatePath+"/"+DateToString.getDateTimeNoFormat(new Date())+".txt";
			FileOutputStream fOut;
			fOut = new FileOutputStream(sFielName);
			fOut.write(sXml.getBytes("UTF-8"));
			fOut.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	
	public void getLogin(){
		
		//调用服务开始	
		try {
			client=new Client(new java.net.URL(sUrl)); 
			params=new Object[3];
		    params[0]="htjd";
		    params[1]="";
		    params[2]="";
			//调用服务开始
			oret = client.invoke("Login",params);
			sAccesscode=(String)oret[0]; 
			sErrTxt=(String)oret[1]; 
			if (sErrTxt.equals("")){
				for (int i=0;i<lweb.size();i++){
					eWeb=(Element)lweb.get(i);
					if (eWeb.attributeValue("name").equals("Zkzx")){
						eWeb.remove(eWeb.selectSingleNode("Accesscode"));
						Element element=eWeb.addElement("Accesscode");
						element.setText(sAccesscode);
						createWebFile(ZzzxfsAction.class.getClassLoader().getResource("").getPath()+"config/webserviceConfig.xml",documentXML);
					}
				}
			}else{
				createFile(sErrTxt,"Accept","Login");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	//读取xml
	public Element getXmlObject(String sPath){
		try { 
			SAXReader saxReader = new SAXReader();  
			documentXML = saxReader.read(new File(sPath));
			Element rootXML=documentXML.getRootElement();
			return rootXML;
		} catch (Exception je) {	
			//提示框的提示内容 
			je.printStackTrace(); 
			return null;
		} 

	}
	//生成webservice文件
	private void createWebFile(String sFile,Document document) throws IOException{
		try
		{
			
			XMLWriter writer = null;
			OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");// 设置XML文件的编码格式
			writer = new XMLWriter(new FileWriter(sFile), format);
            writer.write(document);
            writer.close();

		}
		catch(SecurityException e)
		{
		     System.out.println(e.getMessage());
		}
	}
	
	public String getSUrl() {
		return sUrl;
	}
	public void setSUrl(String url) {
		sUrl = url;
	}
	public String getSUserName() {
		return sUserName;
	}
	public void setSUserName(String userName) {
		sUserName = userName;
	}
	public String getSPassword() {
		return sPassword;
	}
	public void setSPassword(String password) {
		sPassword = password;
	}
	public String getSAccesscode() {
		return sAccesscode;
	}
	public void setSAccesscode(String accesscode) {
		sAccesscode = accesscode;
	}
	public Document getDocumentXML() {
		return documentXML;
	}
	public void setDocumentXML(Document documentXML) {
		this.documentXML = documentXML;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Element getEWeb() {
		return eWeb;
	}
	public void setEWeb(Element web) {
		eWeb = web;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	public Object[] getOret() {
		return oret;
	}
	public void setOret(Object[] oret) {
		this.oret = oret;
	}
	public List getLweb() {
		return lweb;
	}
	public void setLweb(List lweb) {
		this.lweb = lweb;
	}
	
	public boolean isBFlag() {
		return bFlag;
	}
	public void setBFlag(boolean flag) {
		bFlag = flag;
	}
	public String getSXml() {
		return sXml;
	}
	public void setSXml(String xml) {
		sXml = xml;
	}
	public String getSReturn() {
		return sReturn;
	}
	public void setSReturn(String return1) {
		sReturn = return1;
	}
	public int getICount() {
		return iCount;
	}
	public void setICount(int count) {
		iCount = count;
	}
	public String getSErrTxt() {
		return sErrTxt;
	}
	public void setSErrTxt(String errTxt) {
		sErrTxt = errTxt;
	}
	
}
