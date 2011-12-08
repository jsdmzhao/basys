package com.aisino2.sysadmin.service;

import java.util.List;
import java.util.Map;

import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.domain.User;

public interface IRoleService {
	/** @param 角色(t_role) 增加 */
	Role insertRole(Role role);

	/** @param 角色(t_role) 删除 */
	boolean deleteRole(Role role);

	/** @param 角色(t_role) 修改 */
	boolean updateRole(Role role);
	
	/**
	   * 修改用户角色
	   * @param user_role
	   * @return
	   */
	boolean updateUser_role(Role role);

	/** @param 角色(t_role) 查询单条 */
	Role getRole(Role role);

	/** @param 角色(t_role) 分页查询 */
	List getListForPage(Role map, int pageNo,int pageSize,String sort,String desc);

	/** @param 角色(t_role) 多条查询 */
	List<Role> getListRole(Role role);

	/**
	   * 
	   * 根据角色id取得roleMenu对象列表
	   *  @param roleID
	   * @param systemCode */
	  List<Menu> getRoleMenus(Role role);
	  
	  /**
	   * 根据id和systemCode取得RoleMenu对象列表
	   * @param role
	   * @param systemCode
	   * @return
	   */
	  List<Menu> getRoleMenusByRoleAndSystem(Role role,String systemCode);
	  /**
	   * 
	   * 根据角色id和角色菜单list或systemCode保存角色为id，并且在系统代码为systemCode的系统下的菜单权限
	   * @param role
	   * @param roleMenuList
	   * @param systemCode
	   * @return
	   */
	  boolean saveRoleMenuByList(Role role,List roleMenuList);
	  /**
	   * 根据角色id取得这个角色的功能列表
	   *  @param role
	   * @param pageNo */
	  List<Function> getRoleFunctionForPage(Map conditoin, int pageNo);

	  /** 
	   * 根据角色id取得这个角色没有的功能列表
	   * 
	   * systemID可选
	   * 
	   * @param condition
	   * @param pageNo */
	  
	  List<Function> getFunctionListNotInRole(Role_func role_func);

	  /**
	   * 
	   *  根据roleFunctionList中roleFunction对象的的roleID和functionCode删除功能角色权限
	   *  @param role */
	  boolean deleteRoleFunctions(List roleFunctionList);

	  /** 
	   * 
	   * 给角色新增功能权限
	   * 
	   * @param role */
	  boolean addFunctionsToRole(List roleFunctionList);

	  /** 
	   * 根据functionCode和roleID更新角色功能参数
	   * @param roleFunction */
	  boolean saveRoleFunctionParam(Role_func role_func);
	  
	  /**
	    * 角色的上移、下移、置顶、置底
	    * @param role
	    * role.way取值：上移,下移,置顶,置底
	    * @return
	    */
	  boolean updateRoleEditEdOrder(Role role);

	  /**
	   * 更新角色-菜单和角色-功能
	   * @param role
	   * @return
	   */
	  boolean updateRolemenuAndRolefunc(Role role);

		/** @param 查询登陆账号非所属部门和下属部门的角色(t_role) 多条查询 */
       List getloginUserRoleOutDeptList(User user);
       /** @param 查询部门及下属部门的全部角色(t_role) 多条查询 */
       List getDeptRoleList(User user);
}
