package com.aisino2.sysadmin.service;

import java.util.List;

import com.aisino2.sysadmin.domain.Role_func;

public interface IRole_funcService {
	/** @param 角色功能(t_role_func) 增加 */
	void insertRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 删除 */
	void deleteRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 修改 */
	void updateRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 查询单条 */
	Role_func getRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 分页查询 */
	List getListForPage(Role_func map, int pageNo,int pageSize,String sort,String desc);
	
	 List getRoleFunctionList(Role_func map, int pageNo, int pageSize);

	/** @param 角色功能(t_role_func) 多条查询 */
	List<Role_func> getListRole_func(Role_func role_func);
	
	 /**
     * 根据用户userid和funcDefine取得功能角色参数。
     * @param condition
     * @return
     */
    List getParam(Role_func role_func);
    
    /** @param  查询菜单下在Role_func中不存在的功能 */
    List<Role_func> getFunctionListNotInRole(Role_func role_func);
	
}
