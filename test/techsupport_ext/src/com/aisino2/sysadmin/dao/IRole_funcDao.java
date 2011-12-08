package com.aisino2.sysadmin.dao;
import java.util.List;

import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_func;
public interface IRole_funcDao {
	/** @param 角色功能(t_role_func) 增加 */
	void insertRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 删除 */
	void deleteRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 修改 */
	void updateRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 查询单条 */
	Role_func getRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 分页查询 */
	List<Role_func> getListForPage(Role_func map, int pageNo,int pageSize,String sort,String desc);

	/** @param 角色功能(t_role_func) 多条查询 */
	List<Role_func> getListRole_func(Role_func role_func);
	 /**
     * 根据用户userid和funcDefine取得功能角色参数。
     * @param condition
     * @return
     */
    List<Role_func> getParam(Role_func role_func);
    
    List<Role_func> getRoleFunctionList(Role_func map, int pageNo, int pageSize);
    
    
    void deleteRoleFunctionByRole(Role role);
    void deleteRoleFunctionByFunction(Function function);
    /** @param roleFunction */
    void updateRoleFunctionParam(Role_func role_func);
    List<Role_func> getFunctionListNotInRole(Role_func role_func);
    List<Role_func> getRoleFunctionForPage(Role_func condition, int pageNo);
}
