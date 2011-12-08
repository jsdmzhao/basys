package com.aisino2.sysadmin.authorization;


import java.util.List;



public interface IFunctionAuthorization {

/**
 * 
 * 检查用户权限
 * @param userID
 * @param funcDefine 功能定义
 * @return
 */
	boolean checkFunction(int userID,String funcDefine);
	/**
	 * 通过用户id和功能定义获得访问控制参数
	 * @param userID 用户id
	 * @param funcDefine 功能代码
	 * @return
	 */
	String getParam(int userID,String funcDefine);
	/**
	 * 通过用户id和斯通id获得改用户拥有权限信息列表,如果systemID为null则查询全部功能
	 * @param userID 用户id
	 * @return List Function Object
	 */
	List getOwnFunction(int userID,String systemID);
}
