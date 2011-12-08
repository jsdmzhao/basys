package com.aisino2.sysadmin.service;

import java.util.List;

import com.aisino2.sysadmin.domain.Role_menu;

public interface IRole_menuService {
	/** @param 角色菜单(t_role_menu) 增加 */
	void insertRole_menu(Role_menu role_menu);

	/** @param 角色菜单(t_role_menu) 删除 */
	void deleteRole_menu(Role_menu role_menu);

	/** @param 角色菜单(t_role_menu) 修改 */
	void updateRole_menu(Role_menu role_menu);

	/** @param 角色菜单(t_role_menu) 查询单条 */
	Role_menu getRole_menu(Role_menu role_menu);

	/** @param 角色菜单(t_role_menu) 分页查询 */
	List getListForPage(Role_menu map, int pageNo,int pageSize,String sort,String desc);

	/** @param 角色菜单(t_role_menu) 多条查询 */
	List<Role_menu> getListRole_menu(Role_menu role_menu);
	/**
	 * 根据roleid和systemcode取得这个角色在这个系统下的角色菜单
	 * @param role_menu
	 * @return
	 */
	List<Role_menu> getRoleMenusByRoleidAndSystemcode(Role_menu role_menu);
	
	/** @param 角色菜单(t_role_menu) 多条查询 查询指定角色拥有哪个系统下的菜单*/
	List<Role_menu> getRolesystemListNoPage(Role_menu role_menu);
	
	/** @param 角色菜单(t_role_menu) 多条查询 查询指定角色指定系统下的菜单*/
	List<Role_menu> getRolesystemenuListNoPage(Role_menu role_menu);
}
