package com.aisino2.sysadmin.service;

import java.util.List;

import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.User;

public interface IMenuService {
	/** @param 菜单(t_menu) 增加 */
	void insertMenu(Menu menu);

	/** @param 菜单(t_menu) 删除 */
	void deleteMenu(Menu menu);

	/** @param 菜单(t_menu) 修改 */
	void updateMenu(Menu menu);

	/** @param 菜单(t_menu) 查询单条 */
	Menu getMenu(Menu menu);

	/** @param 菜单(t_menu) 分页查询 */
	List getListForPage(Menu menu, int pageNo,int pageSize,String sort,String desc);

	/** @param 菜单(t_menu) 多条查询 */
	List<Menu> getListMenu(Menu menu);
	
	/** 
	 * 
	 * 根据menucode，systemcode取得子菜单
	 * @param menu */
	List<Menu> getChildMenu(Menu menu);
	  
	/** 根据 用户id和syscode 获取菜单 3.29需求只看到用户所拥有的菜单 */
	List<Menu> getTheUserChildMenu(Menu menu,User user);
	  
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
	 List<Menu> getOwnMenu(Menu menu) ;
	 
	  /**
	   * 根据parentCode取得菜单
	   *  
	   *  @param system */
	  Menu getParentMenu(Menu menu);
	 
	 
	  /**
	   * 取得所有菜单
	   * @return
	   */
	   List<Menu> getAllMenu();
	  
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
	  List<Menu> getRoleCheckedMenuList(Menu menu);
	 
}
