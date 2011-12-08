package com.aisino2.sysadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IRole_paramDao;
import com.aisino2.sysadmin.domain.Role_param;
import com.aisino2.sysadmin.service.IRole_paramService;

@Component
public class RoleParamServiceImpl implements IRole_paramService {

	private IRole_paramDao role_param_dao;
	
	public void insertRole_param(Role_param role_param) {
		role_param_dao.insertRole_param(role_param);
	}

	public void deleteRole_param(Role_param role_param) {
		role_param_dao.deleteRole_param(role_param);
	}

	public void updateRole_param(Role_param role_param) {
		role_param_dao.updateRole_param(role_param);
	}

	public Role_param getRole_param(Role_param role_param) {
		return role_param_dao.getRole_param(role_param);
	}

	public List getListForPage(Role_param map, int pageNo, int pageSize,
			String sort, String desc) {
		return role_param_dao.getListForPage(map, pageNo, pageSize, sort, desc);
	}

	public List<Role_param> getListRole_param(Role_param role_param) {
		return role_param_dao.getListRole_param(role_param);
	}

	@Resource(name="role_paramDaoImpl")
	public void setRole_param_dao(IRole_paramDao role_param_dao) {
		this.role_param_dao = role_param_dao;
	}

}
