package com.aisino2.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Role_param;

public interface IRole_paramService {
	/** @param 角色参数(t_role_param) 增加 */
	Role_param insertRole_param(Role_param role_param);

	/** @param 角色参数(t_role_param) 删除 */
	boolean deleteRole_param(Role_param role_param);

	/** @param 角色参数(t_role_param) 修改 */
	boolean updateRole_param(Role_param role_param);

	/** @param 角色参数(t_role_param) 查询单条 */
	Role_param getRole_param(Role_param role_param);

	/** @param 角色参数(t_role_param) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 角色参数(t_role_param) 多条查询 */
	List getListRole_param(Role_param role_param);
}
