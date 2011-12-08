package com.aisino2.sysadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IRole_menuDao;
import com.aisino2.sysadmin.domain.Role_menu;
import com.aisino2.sysadmin.service.IRole_menuService;

@Component
public class RoleMenuServiceImpl implements IRole_menuService {

	private IRole_menuDao role_menu_dao;
	
	public void insertRole_menu(Role_menu role_menu) {
		role_menu_dao.insertRole_menu(role_menu);
	}

	public void deleteRole_menu(Role_menu role_menu) {
		role_menu_dao.deleteRole_menu(role_menu);
	}

	public void updateRole_menu(Role_menu role_menu) {
		role_menu_dao.updateRole_menu(role_menu);
	}

	public Role_menu getRole_menu(Role_menu role_menu) {
		return role_menu_dao.getRole_menu(role_menu);
	}

	public List getListForPage(Role_menu map, int pageNo, int pageSize,
			String sort, String desc) {
		return role_menu_dao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	public List<Role_menu> getListRole_menu(Role_menu role_menu) {
		return role_menu_dao.getListRole_menu(role_menu);
	}

	public List<Role_menu> getRoleMenusByRoleidAndSystemcode(Role_menu role_menu) {
		return role_menu_dao.getRoleMenusByRoleidAndSystemcode(role_menu);
	}

	public List<Role_menu> getRolesystemListNoPage(Role_menu role_menu) {
		return role_menu_dao.getRolesystemListNoPage(role_menu);
	}

	public List<Role_menu> getRolesystemenuListNoPage(Role_menu role_menu) {
		return role_menu_dao.getRolesystemenuListNoPage(role_menu);
	}

	@Resource(name="role_menuDaoImpl")
	public void setRole_menu_dao(IRole_menuDao role_menu_dao) {
		this.role_menu_dao = role_menu_dao;
	}

}
