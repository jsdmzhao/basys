package com.aisino2.sysadmin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.aisino2.sysadmin.dao.IUser_roleDao;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IUser_roleService;

@Component
public class UserRoleServiceImpl implements IUser_roleService{
	private IUser_roleDao user_role_dao;

	@Resource(name="userRoleDaoImpl")
	public void setUser_role_dao(IUser_roleDao user_role_dao) {
		this.user_role_dao = user_role_dao;
	}

	public void insertUser_role(User_role user_role) {
		this.user_role_dao.insertUser_role(user_role);
	}

	public void deleteUser_role(User_role user_role) {
		this.user_role_dao.deleteUser_role(user_role);
	}

	public void updateUser_role(User_role user_role) {
		this.user_role_dao.updateUser_role(user_role);
	}

	public User_role getUser_role(User_role user_role) {
		return this.user_role_dao.getUser_role(user_role);
	}

	public List<User_role> getListForPage(User_role user_role, int pageNo, int pageSize,
			String sort, String desc) {
		return this.user_role_dao.getListForPage( user_role, pageNo, pageSize, sort, desc);
	}

	public List<User_role> getListUser_role(User_role user_role) {
		return this.user_role_dao.getListUser_role(user_role);
	}

	public List<User_role> getUser_roleListByUserid(User_role user_role) {
		return this.user_role_dao.getUser_roleListByUserid(user_role);
	}
	
	
}
