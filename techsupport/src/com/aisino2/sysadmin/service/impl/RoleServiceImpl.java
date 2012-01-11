package com.aisino2.sysadmin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aisino2.core.dao.Page;
import com.aisino2.core.service.BaseService;
import com.aisino2.sysadmin.dao.IMenuDao;
import com.aisino2.sysadmin.dao.IRoleDao;
import com.aisino2.sysadmin.dao.IRole_funcDao;
import com.aisino2.sysadmin.dao.IRole_menuDao;
import com.aisino2.sysadmin.dao.IRole_paramDao;
import com.aisino2.sysadmin.dao.IUser_roleDao;
import com.aisino2.sysadmin.domain.Menu;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.domain.Role_menu;
import com.aisino2.sysadmin.domain.User;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IRoleService;

public class RoleServiceImpl extends BaseService implements IRoleService {

	private IRoleDao roleDao;

	private IUser_roleDao user_roleDao;
	
	private  IRole_funcDao  role_funcDao;
	private   IRole_menuDao  role_menuDao;
	private   IMenuDao  menuDao;
	private IRole_paramDao role_paramDao ;
	public IRole_paramDao getRole_paramDao() {
		return role_paramDao;
	}

	public void setRole_paramDao(IRole_paramDao role_paramDao) {
		this.role_paramDao = role_paramDao;
	}

	/** @param 角色(t_role) 增加 */
	public Role insertRole(Role role){
		// TODO: implement
		return (Role)roleDao.insertRole(role);
	}

	/** @param 角色(t_role) 删除 */
	public boolean deleteRole(Role role){
		// TODO: implement
		user_roleDao.deleteRoleUserByRole(role);
		role_menuDao.deleteRoleMenuByRole(role);
		role_funcDao.deleteRoleFunctionByRole(role);
		role_paramDao.deleteRoleParamByRole(role);
		return roleDao.deleteRole(role)>0;
	}

	/** @param 角色(t_role) 修改 */
	public boolean updateRole(Role role){
		// TODO: implement
		return roleDao.updateRole(role)>0;
	}

	/** @param 角色(t_role) 查询单条 */
	public Role getRole(Role role){
		// TODO: implement
		return (Role)roleDao.getRole(role);
	}

	/** @param 角色(t_role) 分页查询 */
	public Page getListForPage(Map map, int pageNo,int pageSize,String sort,String desc){
		// TODO: implement
		return roleDao.getListForPage(map,pageNo,pageSize,sort,desc);
	}

	/** @param 角色(t_role) 多条查询 */
	public List getListRole(Role role){
		// TODO: implement
		return roleDao.getListRole(role);
	}

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public boolean addFunctionsToRole(List roleFunctionList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < roleFunctionList.size(); i++) {
			Role_func roleFunction = (Role_func) roleFunctionList.get(i);
			role_funcDao.insertRole_func(roleFunction);
		}
		return true;
	}

	public boolean deleteRoleFunctions(List roleFunctionList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < roleFunctionList.size(); i++) {
			Role_func roleFunction = (Role_func) roleFunctionList.get(i);
			role_funcDao.deleteRole_func(roleFunction);
		}
		return true;
	}

	public List getFunctionListNotInRole(Role_func role_func) {
		// TODO Auto-generated method stub

		return role_funcDao.getFunctionListNotInRole(role_func);
	}

	public Page getRoleFunctionForPage(Map conditoin, int pageNo) {
		// TODO Auto-generated method stub
		return role_funcDao.getRoleFunctionForPage(conditoin, pageNo);
	
	}

	public List getRoleMenus(Role role) {
		// TODO Auto-generated method stub
		return role_menuDao.getRoleMenus(role);
	}

	public List getRoleMenusByRoleAndSystem(Role role, String systemCode) {
		// TODO Auto-generated method stub
		if (systemCode != null && systemCode.trim().length() > 0) {
			// 获得该系统下所有菜单
			Role_menu 	role_menu = new Role_menu();
			role_menu.setRoleid(role.getRoleid());
			role_menu.setSystemcode(systemCode);
			// 查询
			return role_menuDao.getRoleMenusByRoleidAndSystemcode(role_menu);
		} else {
			return role_menuDao.getRoleMenus(role);
		}
	}

	public boolean saveRoleFunctionParam(Role_func role_func) {
		// TODO Auto-generated method stub
		return role_funcDao.updateRoleFunctionParam(role_func) > 0;
	}
	public boolean saveRoleMenuByList(Role role, List roleMenuList) {
		// TODO Auto-generated method stub
		String systemCode = role.getSystemcode();
		if (systemCode != null && systemCode.trim().length() > 0) {
			// 获取该系统下的所有menu
			Menu menua = new Menu();
			menua.setSystemcode(systemCode);
			List menuList =  menuDao.getMenuBySystem(menua);
			// 构造RoleMenu对象并删除
			if (menuList != null) {
				for (int i = 0; i < menuList.size(); i++) {
					Menu menu = (Menu) menuList.get(i);
					Role_menu roleMenu = new Role_menu();
					roleMenu.setRoleid(role.getRoleid());
					roleMenu.setMenucode(menu.getMenucode());
					role_menuDao.deleteRole_menu(roleMenu);
				}
			}

		} else {
			role_menuDao.deleteRoleMenuByRole(role);
		}
		for (int i = 0; i < roleMenuList.size(); i++) {
			role_menuDao.insertRole_menu((Role_menu) roleMenuList.get(i));
		}
		return true;
	}
	
	/**
	    * 角色的上移、下移、置顶、置底
	    * @param role
	    * role.way取值：上移,下移,置顶,置底
	    * @return
	    */
	public  boolean updateRoleEditEdOrder(Role role)
	{
		return true;
	}
	
	/**
	   * 更新角色-菜单和角色-功能
	   * @param role
	   * @return
	   */
	public  boolean updateRolemenuAndRolefunc(Role role)
	{
		boolean isSuccess = false;
		
		Role_menu role_menu = new Role_menu();
		Role_func role_func = new Role_func();
		
		if(role != null)
		{
			Integer roleid = role.getRoleid();

			//设置角色ID
			role_menu.setRoleid(roleid);
			role_func.setRoleid(role.getRoleid());
			
			//删除该角色下所有菜单
			role_menuDao.deleteRole_menu(role_menu);
			//增加角色菜单
			//前台返回的需要保存的菜单列表
			List <Role_menu> lRoleMenu = role.getLRoleMenu();
			
			Role_menu mapRole_menu = new Role_menu();
			mapRole_menu.setRoleid(roleid);
			
			//角色可以操作的菜单(不包括页面中已经加载的部分)
			Map roleMenuMap = role.getRoleMenuMap();
			List roleMenuList;
			
			//还有菜单为加载到前台页面的情况
			if(roleMenuMap!=null && roleMenuMap.size()>0){
				//得到前台选中的系统(全部选中/部分选中)
				String systemStr = role.getSystemcode();
				
				//判断是否选中系统,选中系统才保存菜单项
				if(systemStr!=null && !systemStr.equals("")){
					Menu menu; 
					String []systemArry = systemStr.split("\\|");
					int length = systemArry.length;
					int roleMenuLength;
					
					//循环选中的系统,找出后台中选中的菜单,并保存
					for(int arIndex=0;arIndex<length;arIndex++){
						systemStr = systemArry[arIndex];
						
						roleMenuList = (List)roleMenuMap.get(systemStr);
						roleMenuLength = roleMenuList.size();
						
						for(int index=0;index<roleMenuLength;index++){
							menu = (Menu)roleMenuList.get(index);
							if(menu.getIschecked()!=0){
								role_menu.setMenucode(menu.getMenucode());
								role_menuDao.insertRole_menu(role_menu);
							}
						}
					}
					
					//保存前台选中的菜单
					if(lRoleMenu!=null){
						int checkLength = lRoleMenu.size();
						for(int index=0;index<checkLength;index++){
							role_menu = (Role_menu)lRoleMenu.get(index);
							role_menu.setRoleid(roleid);
							role_menuDao.insertRole_menu(role_menu);
						}
					}
				}
			}
		}
		
		//删除该角色下所有功能
		role_funcDao.deleteRole_func(role_func);
		//增加角色功能
		if(role.getLRoleFunc()!=null)
		{
			for(int i = 0;i<role.getLRoleFunc().size();i++)
			{
				role_func = (Role_func)role.getLRoleFunc().get(i);
				role_func.setRoleid(role.getRoleid());
				role_funcDao.insertRole_func(role_func);
			}
		}
		isSuccess = true;
	
		return isSuccess;
	}
	
	/**
	   * 修改用户角色
	   * @param user_role
	   * @return
	   */
	public  boolean updateUser_role(Role role)
	{
		boolean isSuccess = false;
		User_role user_role = null;
		User_role deleteUser_role = new User_role();
		List user_roleList = new ArrayList();
		if(role != null)
		{
			if(role.getRoleid() != null)
			{
				//删除该角色所有用户

				deleteUser_role.setRoleid(role.getRoleid());
				user_roleDao.deleteUser_role(deleteUser_role);
				//添加用户
				if(role.getLUserRoleList()!= null)
				{
					for(int i = 0;i<role.getLUserRoleList().size();i++)
					{
						user_role = new User_role();
						user_role = (User_role)role.getLUserRoleList().get(i);
						user_role.setRoleid(role.getRoleid());
						user_roleDao.insertUser_role(user_role);
						user_role = null;
					}
				}
				isSuccess = true;
			}
			
		}
		
		return isSuccess;
	}

	public IUser_roleDao getUser_roleDao() {
		return user_roleDao;
	}

	public void setUser_roleDao(IUser_roleDao user_roleDao) {
		this.user_roleDao = user_roleDao;
	}

	public IRole_funcDao getRole_funcDao() {
		return role_funcDao;
	}

	public void setRole_funcDao(IRole_funcDao role_funcDao) {
		this.role_funcDao = role_funcDao;
	}

	public IRole_menuDao getRole_menuDao() {
		return role_menuDao;
	}

	public void setRole_menuDao(IRole_menuDao role_menuDao) {
		this.role_menuDao = role_menuDao;
	}

	public IMenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(IMenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public List getloginUserRoleOutDeptList(User user) {
		// TODO Auto-generated method stub
		user.setDepartcode(user.getDepartment().getDepartfullcode());
		return roleDao.getloginUserRoleOutDeptList(user);
	}

	public List getDeptRoleList(User user) {
		// TODO Auto-generated method stub
		user.setDepartcode(user.getDepartment().getDepartfullcode());
		return roleDao.getDeptRoleList(user);
	}
}
