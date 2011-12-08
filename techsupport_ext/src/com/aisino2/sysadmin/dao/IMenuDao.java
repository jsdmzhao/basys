package com.aisino2.sysadmin.dao;
import java.util.List;

import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.User;
public interface IMenuDao {
	/** @param 菜单(t_menu) 增加 */
	void insertMenu(Menu menu);

	/** @param 菜单(t_menu) 删除 */
	void deleteMenu(Menu menu);

	/** @param 菜单(t_menu) 修改 */
	void updateMenu(Menu menu);

	/** @param 菜单(t_menu) 查询单条 */
	Menu getMenu(Menu menu);

	/** @param 菜单(t_menu) 分页查询 */
	List<Menu> getListForPage(Menu menu, int pageNo,int pageSize,String sort,String desc);

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
	 
	  /** @param system */
	  Menu getParentMenu(Menu menu);


	  /** @取得所有子菜单 */
	  List<Menu> getAllChildren(Menu  menu);
	  /** @取得所有菜单 */
	  List<Menu> getAllMenu();
	  /** @根据系统代码取得所有菜单 */
	  List<Menu> getMenuBySystem(Menu menu);
	  /**
	   * 检查是否还有子类；
	   * @param condition
	   * @return
	   */
	  boolean checkChild(Menu menu);
	  /** 获得下一个排序号 */
	  Menu getNextNodeorder(Menu menu);
	  
	  /** @根据角色取得所有菜单 */
	  List<Menu> getRoleCheckedMenuList(Menu menu);
	  
}
