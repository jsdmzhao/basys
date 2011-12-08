package com.aisino2.sysadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IRole_funcDao;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.service.IRole_funcService;

@Component
public class RoleFuncServiceImpl implements IRole_funcService {

	private IRole_funcDao role_func_dao;
	
	public void insertRole_func(Role_func role_func) {
		role_func_dao.insertRole_func(role_func);
	}

	public void deleteRole_func(Role_func role_func) {
		role_func_dao.deleteRole_func(role_func);
	}

	public void updateRole_func(Role_func role_func) {
		role_func_dao.updateRole_func(role_func);
	}

	public Role_func getRole_func(Role_func role_func) {
		return role_func_dao.getRole_func(role_func);
	}

	public List getListForPage(Role_func map, int pageNo, int pageSize, String sort,
			String desc) {
		return role_func_dao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	public List getRoleFunctionList(Role_func map, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role_func> getListRole_func(Role_func role_func) {
		return role_func_dao.getListRole_func(role_func);
	}

	public List getParam(Role_func role_func) {
		return role_func_dao.getParam(role_func);
	}

	public List<Role_func> getFunctionListNotInRole(Role_func role_func) {
		return role_func_dao.getFunctionListNotInRole(role_func);
	}

	@Resource(name="role_funcDaoImpl")
	public void setRole_func_dao(IRole_funcDao role_func_dao) {
		this.role_func_dao = role_func_dao;
	}

}
