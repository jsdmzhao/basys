package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IRoleDao;
import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.service.IRoleService;
@Component
public class RoleServiceImpl implements IRoleService {
	private IRoleDao role_dao;
	public Role insertRole(Role role) {
		role_dao.insertRole(role);
		return role;
	}

	public boolean deleteRole(Role role) {
		role_dao.deleteRole(role);
		return false;
	}

	public boolean updateRole(Role role) {
		role_dao.updateRole(role);
		return false;
	}

	public boolean updateUser_role(Role role) {
		
		return false;
	}

	public Role getRole(Role role) {
		return role_dao.getRole(role);
	}

	public List getListForPage(Role map, int pageNo, int pageSize, String sort,
			String desc) {
		return role_dao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	public List<Role> getListRole(Role role) {
		return role_dao.getListRole(role);
	}

	public List<Menu> getRoleMenus(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Menu> getRoleMenusByRoleAndSystem(Role role, String systemCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveRoleMenuByList(Role role, List roleMenuList) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Function> getRoleFunctionForPage(Map conditoin, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Function> getFunctionListNotInRole(Role_func role_func) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteRoleFunctions(List roleFunctionList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addFunctionsToRole(List roleFunctionList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveRoleFunctionParam(Role_func role_func) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateRoleEditEdOrder(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateRolemenuAndRolefunc(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	public List getloginUserRoleOutDeptList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getDeptRoleList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Resource(name="roleDaoImpl")
	public void setRole_dao(IRoleDao role_dao) {
		this.role_dao = role_dao;
	}
	

}
