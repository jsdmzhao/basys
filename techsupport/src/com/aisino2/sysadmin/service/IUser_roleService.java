package com.aisino2.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.User_role;

public interface IUser_roleService {
	/** @param 用户角色(t_user_role) 增加 */
	User_role insertUser_role(User_role user_role);

	/** @param 用户角色(t_user_role) 删除 */
	boolean deleteUser_role(User_role user_role);

	/** @param 用户角色(t_user_role) 修改 */
	boolean updateUser_role(User_role user_role);

	/** @param 用户角色(t_user_role) 查询单条 */
	User_role getUser_role(User_role user_role);

	/** @param 用户角色(t_user_role) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 用户角色(t_user_role) 多条查询 */
	List getListUser_role(User_role user_role);
	
	/** @param 由用户id获得所有角色 多条查询 */
	List getUser_roleListByUserid(User_role user_role);
}
