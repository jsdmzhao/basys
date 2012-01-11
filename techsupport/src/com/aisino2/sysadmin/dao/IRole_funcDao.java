package com.aisino2.sysadmin.dao;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_func;
public interface IRole_funcDao {
	/** @param 角色功能(t_role_func) 增加 */
	Role_func insertRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 删除 */
	int deleteRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 修改 */
	int updateRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 查询单条 */
	Role_func getRole_func(Role_func role_func);

	/** @param 角色功能(t_role_func) 分页查询 */
	Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc);

	/** @param 角色功能(t_role_func) 多条查询 */
	List getListRole_func(Role_func role_func);
	 /**
     * 根据用户userid和funcDefine取得功能角色参数。
     * @param condition
     * @return
     */
    List getParam(Role_func role_func);
    
    Page getRoleFunctionList(Map map, int pageNo, int pageSize);
    
    
    int deleteRoleFunctionByRole(Role role);
    int deleteRoleFunctionByFunction(Function function);
    /** @param roleFunction */
    int updateRoleFunctionParam(Role_func role_func);
    List getFunctionListNotInRole(Role_func role_func);
    Page getRoleFunctionForPage(Map condition, int pageNo);
}
