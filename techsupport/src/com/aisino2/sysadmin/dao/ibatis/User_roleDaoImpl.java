package com.aisino2.sysadmin.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.BaseDao;
import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.dao.IUser_roleDao;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.domain.User_role;

public class User_roleDaoImpl extends BaseDao implements IUser_roleDao {
	/** @param 用户角色(t_user_role) 增加 */
	public User_role insertUser_role(User_role user_role){
		// TODO: implement

		return (User_role)insert("insertUser_role", user_role);
	}

	/** @param 用户角色(t_user_role) 删除 */
	public int deleteUser_role(User_role user_role){
		// TODO: implement
		return delete("deleteUser_role", user_role);
	}

	/** @param 用户角色(t_user_role) 修改 */
	public int updateUser_role(User_role user_role){
		// TODO: implement
		return update("updateUser_role", user_role);
	}

	/** @param 用户角色(t_user_role) 查询单条 */
	public User_role getUser_role(User_role user_role){
		// TODO: implement
		return (User_role)queryForObject("getUser_role", user_role);
	}

	/** @param 用户角色(t_user_role) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		String sCol="";
		if (sort!=null){
		}else{
			sCol="a.Roleid desc";
		}
		map.put("pageSort", sCol);
		return queryForPage("getUser_roleList", map, pageNo,pageSize);
	}

	/** @param 用户角色(t_user_role) 多条查询 */
	public List getListUser_role(User_role user_role){
		// TODO: implement
		return queryForList("getUser_roleListNoPage", user_role);
	}

	public int deleteRoleUserByRole(Role role) {
		// TODO Auto-generated method stub
		return delete("deleteRoleUserByRole", role);
	}

	public int deleteRoleUserByUser(User user) {
		// TODO Auto-generated method stub
		return delete("deleteRoleUserByUser", user);
	}
	
	/** @param 由用户id获得所有角色 多条查询 */
	public List getUser_roleListByUserid(User_role user_role){
		// TODO: implement
		return queryForList("getUser_roleListByUserid", user_role);
	}
}
