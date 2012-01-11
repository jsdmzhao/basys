package com.aisino2.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Menu;

public interface IMenuService {
	/** @param 菜单(t_menu) 增加 */
	Menu insertMenu(Menu menu);

	/** @param 菜单(t_menu) 删除 */
	boolean deleteMenu(Menu menu);

	/** @param 菜单(t_menu) 修改 */
	boolean updateMenu(Menu menu);

	/** @param 菜单(t_menu) 查询单条 */
	Menu getMenu(Menu menu);

	/** @param 菜单(t_menu) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 菜单(t_menu) 多条查询 */
	List getListMenu(Menu menu);
	
	/** 
	 * 
	 * 根据menucode，systemcode取得子菜单
	 * @param menu */
	List getChildMenu(Menu menu);
	  
	/** 根据 用户id和syscode 获取菜单 3.29需求只看到用户所拥有的菜单 */
	List getTheUserChildMenu(Menu menu);
	  
	  /**
	   * 
	   * 根据userid和menuCode查看用户是否有这个菜单权限。
	   * @param condition
	   * @return
	   */
	  
	 boolean  checkMenu(Menu menu) ;
	 /**
	  * 
	  * 根据userid取得用户的菜单
	  * systemcode可选
	  * @param condition
	  * @return
	  */
	 List getOwnMenu(Menu menu) ;
	 
	  /**
	   * 根据parentCode取得菜单
	   *  
	   *  @param system */
	  Menu getParentMenu(Menu menu);
	 
	 
	  /**
	   * 取得所有菜单
	   * @return
	   */
	   
	   
	   List getAllMenu();
	  
	   /**
	    * 菜单的上移、下移、置顶、置底
	    * @param menu
	    * menu.way取值：上移,下移,置顶,置底
	    * @return
	    */
	  boolean updateMenuEditEdOrder(Menu menu);
	  /**
	   * 获得下一个排序号
	   * @param menu.parentmenucode
	   * @return 
		*/
	Integer getNextNodeorder(Menu menu);

	  /** @根据角色取得所有菜单 */
	  List getRoleCheckedMenuList(Menu menu);
	 
}
