package com.webService;


public interface IBaoJingWebService {
	 

	/** @param  返回报警条数 */
	public int getBaojingCount(String jqztdm,String gxdwbm);
	/** @param  返回sessionOut 单位秒*/
	public int getSessionOut();
	/** @param  返回sessionOut和最小刷新时间 单位秒*/
	public String getSessionOutA();
	/**
	 * 返回ftp的地址，账号，密码，用,|分割
	 * @return
	 */
	public String getFtpIpAccountPass();

}
