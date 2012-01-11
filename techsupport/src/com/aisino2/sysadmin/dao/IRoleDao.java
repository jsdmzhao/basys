package com.aisino2.sysadmin.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.User;
public interface IRoleDao {
	/** @param 角色(t_role) 增加 */
	Role insertRole(Role role);

	/** @param 角色(t_role) 删除 */
	int deleteRole(Role role);

	/** @param 角色(t_role) 修改 */
	int updateRole(Role role);

	/** @param 角色(t_role) 查询单条 */
	Role getRole(Role role);

	/** @param 角色(t_role) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 角色(t_role) 多条查询 */
	List getListRole(Role role);
	
	  List getRolesByUser(User user);

	  List getOptionRolesForUser(User user);
	  /** @param 查询登陆账号非所属部门和下属部门的角色(t_role) 多条查询 */
      List getloginUserRoleOutDeptList(User user);
      
      /** @param 查询部门及下属部门的全部角色(t_role) 多条查询 */
      List getDeptRoleList(User user);
}
