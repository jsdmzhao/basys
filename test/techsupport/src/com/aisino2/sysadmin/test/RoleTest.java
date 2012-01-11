package com.aisino2.sysadmin.test;

import java.util.ArrayList;
import java.util.List;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Role;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.domain.Role_menu;
import com.aisino2.sysadmin.service.IRoleService;
import com.aisino2.sysadmin.service.IRole_funcService;
import com.aisino2.sysadmin.service.IRole_menuService;

public class RoleTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IRoleService roleService;
	private IRole_menuService role_menuService;
	private IRole_funcService role_funcService;

	/** @param 角色(t_role) */

	public void test() {
		Role role = new Role();
		Role_menu role_menu = new Role_menu();
		Role_func role_func = new Role_func();

	/** @ 角色ID(roleid) */
	role.setRoleid(0);

	/** @ 机构ID(departid) */
	role.setDepartid(0);

	/** @ 角色名称(rolename) */
	role.setRolename("test");

	/** @ 角色描述(roledescription) */
	role.setRoledescription("test");

	/** @ 角色类别(roletype) */
	role.setRoletype(0);

		/*
		//插入对象
		roleService.insertRole(role);

		//读取对象比较
		BaseObject bo = roleService.getRole(role);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Role roleNew = (Role)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(roleNew.getRoleid(), role.getRoleid());
		assertEquals(roleNew.getDepartid(), role.getDepartid());
		assertEquals(roleNew.getRolename(), role.getRolename());
		assertEquals(roleNew.getRoledescription(), role.getRoledescription());
		assertEquals(roleNew.getRoletype(), role.getRoletype());

		//删除对象
		// @ 角色ID(roleid) 
		role.setRoleid(1)
		// @ 机构ID(departid) 
		role.setDepartid(1)

		roleService.deleteRole(role);

		//修改对象
		// @ 角色ID(roleid) 
		role.setRoleid(1)
		// @ 机构ID(departid) 
		role.setDepartid(1)

		roleService.updateRole(role);

		//查询单条
		// @ 角色ID(roleid) 
		role.setRoleid(1)
		// @ 机构ID(departid) 
		role.setDepartid(1)

		roleService.getRole(role);

		//查询多条
		// @ 角色ID(roleid) 
		role.setRoleid(1)
		// @ 机构ID(departid) 
		role.setDepartid(1)

		roleService.getListRole(role);

		//翻页查询
		// @ 角色ID(roleid) 
		role.setRoleid(1)
		// @ 机构ID(departid) 
		role.setDepartid(1)

		roleService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/
	
	role = null;
	role_menu = null;
	role_func = null;
	role = new Role();
	List lRoleMenu = new ArrayList();
	List lRoleFunc = new ArrayList();
	role.setRoleid(3);
	
	role_menu = new Role_menu();
	role_menu.setMenucode("gngl");
	lRoleMenu.add(role_menu);
	role_menu = null;
	
	role_menu = new Role_menu();
	role_menu.setMenucode("hyhhh");
	lRoleMenu.add(role_menu);
	role_menu = null;
	
	/*role_menu = new Role_menu();
	role_menu.setMenucode("cdgl");
	lRoleMenu.add(role_menu);
	role_menu = null;*/
	
	role_menu = new Role_menu();
	role_menu.setMenucode("amdin");
	lRoleMenu.add(role_menu);
	role_menu = null;
	
	
	
	/*role_func = new Role_func();
	role_func.setFunccode("AAB");
	lRoleFunc.add(role_func);
	role_func = null;*/
	
	role_func = new Role_func();
	role_func.setFunccode("AAA");
	lRoleFunc.add(role_func);
	role_func = null;
	
	role_func = new Role_func();
	role_func.setFunccode("BBB");
	lRoleFunc.add(role_func);
	role_func = null;
	
	role_func = new Role_func();
	role_func.setFunccode("CCC");
	lRoleFunc.add(role_func);
	role_func = null;
	
	role.setLRoleMenu(lRoleMenu);
	role.setLRoleFunc(lRoleFunc);
	
	
	
		//插入对象
		//roleService.insertRole(role);
	roleService.updateRolemenuAndRolefunc(role);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public void setRole_menuService(IRole_menuService role_menuService) {
		this.role_menuService = role_menuService;
	}

	public void setRole_funcService(IRole_funcService role_funcService) {
		this.role_funcService = role_funcService;
	}
}
