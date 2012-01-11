package com.aisino2.sysadmin.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_menu;
public interface IRole_menuDao {
	/** @param 角色菜单(t_role_menu) 增加 */
	Role_menu insertRole_menu(Role_menu role_menu);

	/** @param 角色菜单(t_role_menu) 删除 */
	int deleteRole_menu(Role_menu role_menu);

	/** @param 角色菜单(t_role_menu) 修改 */
	int updateRole_menu(Role_menu role_menu);

	/** @param 角色菜单(t_role_menu) 查询单条 */
	Role_menu getRole_menu(Role_menu role_menu);

	/** @param 角色菜单(t_role_menu) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 角色菜单(t_role_menu) 多条查询 */
	List getListRole_menu(Role_menu role_menu);
	
	/** @param 角色菜单(t_role_menu) 多条查询 查询指定角色拥有哪个系统下的菜单*/
	List getRolesystemListNoPage(Role_menu role_menu);
	
	/** @param 角色菜单(t_role_menu) 多条查询 查询指定角色指定系统下的菜单*/
	List getRolesystemenuListNoPage(Role_menu role_menu);
	
	/**
	 * 根据roleid和systemcode取得这个角色在这个系统下的角色菜单
	 * @param role_menu
	 * @return
	 */
	List getRoleMenusByRoleidAndSystemcode(Role_menu role_menu);
	
	
	 int deleteRoleMenuByRole(Role role);
	  //马志永 修改start
	  int deleteRoleMenuByMenu(Menu menu);
	  //end
	   List getRoleMenus(Role role);
	
}
