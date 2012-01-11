package com.aisino2.sysadmin.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Menu;
public interface IMenuDao {
	/** @param 菜单(t_menu) 增加 */
	Menu insertMenu(Menu menu);

	/** @param 菜单(t_menu) 删除 */
	int deleteMenu(Menu menu);

	/** @param 菜单(t_menu) 修改 */
	int updateMenu(Menu menu);

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
	 
	  /** @param system */
	  Menu getParentMenu(Menu menu);


	  /** @取得所有子菜单 */
	  List getAllChildren(Menu  menu);
	  /** @取得所有菜单 */
	  List getAllMenu();
	  /** @根据系统代码取得所有菜单 */
	  List getMenuBySystem(Menu menu);
	  /**
	   * 检查是否还有子类；
	   * @param condition
	   * @return
	   */
	  boolean checkChild(Menu menu);
	  /** 获得下一个排序号 */
	  Menu getNextNodeorder(Menu menu);
	  
	  /** @根据角色取得所有菜单 */
	  List getRoleCheckedMenuList(Menu menu);
}
