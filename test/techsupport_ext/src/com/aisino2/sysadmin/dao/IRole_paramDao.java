package com.aisino2.sysadmin.dao;
import java.util.List;

import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_param;
public interface IRole_paramDao {
	/** @param 角色参数(t_role_param) 增加 */
	void insertRole_param(Role_param role_param);

	/** @param 角色参数(t_role_param) 删除 */
	void deleteRole_param(Role_param role_param);

	/** @param 角色参数(t_role_param) 修改 */
	void updateRole_param(Role_param role_param);

	/** @param 角色参数(t_role_param) 查询单条 */
	Role_param getRole_param(Role_param role_param);

	/** @param 角色参数(t_role_param) 分页查询 */
	List<Role_param> getListForPage(Role_param map, int pageNo,int pageSize,String sort,String desc);

	/** @param 角色参数(t_role_param) 多条查询 */
	List<Role_param> getListRole_param(Role_param role_param);
	void deleteRoleParamByRole(Role role);
}
