package com.webService.test;

import java.net.MalformedURLException;

import org.codehaus.xfire.client.Client;

public class Bjd {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws MalformedURLException, Exception {
		// TODO Auto-generated method stub
		
		 Client client=new Client(new java.net.URL("http://192.168.12.116:8080/jxy/baoJingWS.ws?wsdl"));
	       
		// String flag=client.invoke("getSessionOut", new String[]{"ss"})[0].toString();
		
		//System.out.println("刷卡结果================="+flag);
		// String flag=client.invoke("getFtpIpAccountPass", new String[]{"ss"})[0].toString();
		 String flag=client.invoke("getSessionOut", new String[]{"ss"})[0].toString();
			
		 System.out.println(flag);
	}

}
