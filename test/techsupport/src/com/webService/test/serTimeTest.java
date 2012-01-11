package com.webService.test;

import java.net.MalformedURLException;

import org.codehaus.xfire.client.Client;

public class serTimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws MalformedURLException, Exception {
		// TODO Auto-generated method stub
		 Client client=new Client(new java.net.URL("http://192.168.12.116:8080/jxy/serverTimeWS.ws?wsdl"));
	       
	//	 String flag=client.invoke("getServerTime14", new String[]{""})[0].toString();
		
		 
		 String flag=client.invoke("getFtpIpAccountPass", new String[]{""})[0].toString();
		System.out.println("服务器时间================="+flag);
	}

}
