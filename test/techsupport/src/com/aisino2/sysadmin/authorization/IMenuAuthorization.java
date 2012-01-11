package com.aisino2.sysadmin.authorization;

import java.util.List;

/**
 * 
 * @author lly
 *
 */
public interface IMenuAuthorization {

	/**
	 * 检查用户是否具有给定菜单的访问权限
	 * @param userID 用户id
	 * @param menuCode 菜单id
	 * @return
	 */
	boolean checkMenu(int userID,String menuCode);
	/**
	 * 根据用户id和系统代码获得改用户具有权限的菜单对象
	 * 如果systemID为null则查询全部
	 * @param userID
	 * @return
	 */
	List getOwnMenu(int userID,String systemID);
}
