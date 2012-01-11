package com.aisino2.sysadmin.service.impl;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IUser_roleDao;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IUser_roleService;

public class User_roleServiceImpl extends BaseService implements IUser_roleService {

	private IUser_roleDao user_roleDao;

	/** @param 用户角色(t_user_role) 增加 */
	public User_role insertUser_role(User_role user_role){
		// TODO: implement
		return (User_role)user_roleDao.insertUser_role(user_role);
	}

	/** @param 用户角色(t_user_role) 删除 */
	public boolean deleteUser_role(User_role user_role){
		// TODO: implement
		return user_roleDao.deleteUser_role(user_role)>0;
	}

	/** @param 用户角色(t_user_role) 修改 */
	public boolean updateUser_role(User_role user_role){
		// TODO: implement
		return user_roleDao.updateUser_role(user_role)>0;
	}

	/** @param 用户角色(t_user_role) 查询单条 */
	public User_role getUser_role(User_role user_role){
		// TODO: implement
		return (User_role)user_roleDao.getUser_role(user_role);
	}

	/** @param 用户角色(t_user_role) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return user_roleDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 用户角色(t_user_role) 多条查询 */
	public List getListUser_role(User_role user_role){
		// TODO: implement
		return user_roleDao.getListUser_role(user_role);
	}

	public IUser_roleDao getUser_roleDao() {
		return user_roleDao;
	}

	public void setUser_roleDao(IUser_roleDao user_roleDao) {
		this.user_roleDao = user_roleDao;
	}
	
	/** @param 由用户id获得所有角色 多条查询 */
	public List getUser_roleListByUserid(User_role user_role){
		// TODO: implement
		return user_roleDao.getUser_roleListByUserid(user_role);
	}
}
