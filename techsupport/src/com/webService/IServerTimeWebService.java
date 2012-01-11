package com.webService;


public interface IServerTimeWebService {
	 

	//返回服务器时间格式十四位的字符串20090922121109

	public String getServerTime14();
	/**
	 * 返回ftp的地址，账号，密码，用,|分割
	 * @return
	 */
	public String getFtpIpAccountPass();
}
