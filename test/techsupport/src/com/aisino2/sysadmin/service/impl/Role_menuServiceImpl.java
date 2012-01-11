package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IRole_menuDao;
import com.aisino2.sysadmin.domain.Role_menu;
import com.aisino2.sysadmin.service.IRole_menuService;

public class Role_menuServiceImpl extends BaseService implements IRole_menuService {

	private IRole_menuDao role_menuDao;

	/** @param 角色菜单(t_role_menu) 增加 */
	public Role_menu insertRole_menu(Role_menu role_menu){
		// TODO: implement
		return (Role_menu)role_menuDao.insertRole_menu(role_menu);
	}

	/** @param 角色菜单(t_role_menu) 删除 */
	public boolean deleteRole_menu(Role_menu role_menu){
		// TODO: implement
		return role_menuDao.deleteRole_menu(role_menu)>0;
	}

	/** @param 角色菜单(t_role_menu) 修改 */
	public boolean updateRole_menu(Role_menu role_menu){
		// TODO: implement
		return role_menuDao.updateRole_menu(role_menu)>0;
	}

	/** @param 角色菜单(t_role_menu) 查询单条 */
	public Role_menu getRole_menu(Role_menu role_menu){
		// TODO: implement
		return (Role_menu)role_menuDao.getRole_menu(role_menu);
	}

	/** @param 角色菜单(t_role_menu) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return role_menuDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 角色菜单(t_role_menu) 多条查询 */
	public List getListRole_menu(Role_menu role_menu){
		// TODO: implement
		return role_menuDao.getListRole_menu(role_menu);
	}

	public IRole_menuDao getRole_menuDao() {
		return role_menuDao;
	}

	public void setRole_menuDao(IRole_menuDao role_menuDao) {
		this.role_menuDao = role_menuDao;
	}

	public List getRoleMenusByRoleidAndSystemcode(Role_menu role_menu) {
		// TODO Auto-generated method stub
		return role_menuDao.getRoleMenusByRoleidAndSystemcode(role_menu);
	}
	
	/** @param 角色菜单(t_role_menu) 多条查询 查询指定角色拥有哪个系统下的菜单*/
	public List getRolesystemListNoPage(Role_menu role_menu)
	{
		return role_menuDao.getRolesystemListNoPage(role_menu);
	}
	
	/** @param 角色菜单(t_role_menu) 多条查询 查询指定角色指定系统下的菜单*/
	public List getRolesystemenuListNoPage(Role_menu role_menu)
	{
		return role_menuDao.getRolesystemenuListNoPage(role_menu);
	}
}
