package com.aisino2.sysadmin.service;

import java.util.List;

import com.aisino2.sysadmin.domain.User_role;

public interface IUser_roleService {
	/** @param 用户角色(t_user_role) 增加 */
	void insertUser_role(User_role user_role);

	/** @param 用户角色(t_user_role) 删除 */
	void deleteUser_role(User_role user_role);

	/** @param 用户角色(t_user_role) 修改 */
	void updateUser_role(User_role user_role);

	/** @param 用户角色(t_user_role) 查询单条 */
	User_role getUser_role(User_role user_role);

	/** @param 用户角色(t_user_role) 分页查询 */
	List getListForPage(User_role user_role, int pageNo,int pageSize,String sort,String desc);

	/** @param 用户角色(t_user_role) 多条查询 */
	List<User_role> getListUser_role(User_role user_role);
	
	/** @param 由用户id获得所有角色 多条查询 */
	List<User_role> getUser_roleListByUserid(User_role user_role);
}
