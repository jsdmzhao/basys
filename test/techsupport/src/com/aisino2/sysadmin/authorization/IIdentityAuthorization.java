package com.aisino2.sysadmin.authorization;

import java.util.Map;


public interface IIdentityAuthorization {
	/**
	 * 用户帐号名和密码查找用户对象，查询不到则返回null
	 * @param account
	 * @param passWord
	 * @return
	 */
	Object getUser(String account,String passWord);
	/**
	 * 利用给定参数查找用户对象，查询不到则返回null
	 * @param account
	 * @param passWord
	 * @return
	 */
	Object getUser(Map paramMap);
	/**
	 *  验证给定用户名和密码的用户是否合法
	 * @param account
	 * @param passWord
	 * @return
	 */
	boolean  userIsExist(String account,String passWord);
	/**
	 *  验证给定参数的用户是否合法
	 * @param account
	 * @param passWord
	 * @return
	 */
	boolean  userIsExist(Map paramMap);
	
	
	
	/**
	 * 用户帐号名查找用户对象，查询不到则返回null
	 * @param account
	 * @param passWord
	 * @return
	 */
	Object getUserAcc(String account);
}
