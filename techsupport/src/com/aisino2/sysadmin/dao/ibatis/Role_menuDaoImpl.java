package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IRole_menuDao;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_menu;

public class Role_menuDaoImpl extends BaseDao implements IRole_menuDao {
	/** @param 角色菜单(t_role_menu) 增加 */
	public Role_menu insertRole_menu(Role_menu role_menu){
		// TODO: implement
		return (Role_menu)insert("insertRole_menu", role_menu);
	}

	/** @param 角色菜单(t_role_menu) 删除 */
	public int deleteRole_menu(Role_menu role_menu){
		// TODO: implement
		return delete("deleteRole_menu", role_menu);
	}

	/** @param 角色菜单(t_role_menu) 修改 */
	public int updateRole_menu(Role_menu role_menu){
		// TODO: implement
		return update("updateRole_menu", role_menu);
	}

	/** @param 角色菜单(t_role_menu) 查询单条 */
	public Role_menu getRole_menu(Role_menu role_menu){
		// TODO: implement
		return (Role_menu)queryForObject("getRole_menu", role_menu);
	}
	
	/** @param 角色菜单(t_role_menu) 多条查询 查询指定角色拥有哪个系统下的菜单*/
	public List getRolesystemListNoPage(Role_menu role_menu)
	{
		return queryForList("getRolesystemListNoPage", role_menu);
	}
	
	/** @param 角色菜单(t_role_menu) 多条查询 查询指定角色指定系统下的菜单*/
	public List getRolesystemenuListNoPage(Role_menu role_menu)
	{
		return queryForList("getRolesystemenuListNoPage", role_menu);
	}

	/** @param 角色菜单(t_role_menu) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Menucode desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getRole_menuList", map, pageNo,pageSize);
	}

	/** @param 角色菜单(t_role_menu) 多条查询 */
	public List getListRole_menu(Role_menu role_menu){
		// TODO: implement
		return queryForList("getRole_menuListNoPage", role_menu);
	}

	public List getRoleMenusByRoleidAndSystemcode(Role_menu role_menu) {
		// TODO Auto-generated method stub
		return queryForList("getRoleMenusByRoleidAndSystemcode", role_menu);
	}

	public int deleteRoleMenuByMenu(Menu menu) {
		// TODO Auto-generated method stub
		return this.delete("deleteRoleMenuByMenu", menu);
	}

	public int deleteRoleMenuByRole(Role role) {
		// TODO Auto-generated method stub
		return this.delete("deleteRoleMenuByRole", role);
	}

	public List getRoleMenus(Role role) {
		// TODO Auto-generated method stub
		return this.queryForList("getRoleMenus", role);
	}
}
