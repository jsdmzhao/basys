package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Role_menu;
import com.aisino2.sysadmin.service.IRole_menuService;

public class Role_menuTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IRole_menuService role_menuService;

	/** @param 角色菜单(t_role_menu) */

	public void test() {
		Role_menu role_menu = new Role_menu();

	/** @ 菜单代码(menucode) */
	role_menu.setMenucode("test");

	/** @ 角色ID(roleid) */
	role_menu.setRoleid(0);

		/*
		//插入对象
		role_menuService.insertRole_menu(role_menu);

		//读取对象比较
		BaseObject bo = role_menuService.getRole_menu(role_menu);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Role_menu role_menuNew = (Role_menu)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(role_menuNew.getMenucode(), role_menu.getMenucode());
		assertEquals(role_menuNew.getRoleid(), role_menu.getRoleid());

		//删除对象
		// @ 菜单代码(menucode) 
		role_menu.setMenucode(1)
		// @ 菜单代码(menucode) 
		role_menu.setMenucode(1)
		// @ 角色ID(roleid) 
		role_menu.setRoleid(1)
		// @ 角色ID(roleid) 
		role_menu.setRoleid(1)

		role_menuService.deleteRole_menu(role_menu);

		//修改对象
		// @ 菜单代码(menucode) 
		role_menu.setMenucode(1)
		// @ 菜单代码(menucode) 
		role_menu.setMenucode(1)
		// @ 角色ID(roleid) 
		role_menu.setRoleid(1)
		// @ 角色ID(roleid) 
		role_menu.setRoleid(1)

		role_menuService.updateRole_menu(role_menu);

		//查询单条
		// @ 菜单代码(menucode) 
		role_menu.setMenucode(1)
		// @ 菜单代码(menucode) 
		role_menu.setMenucode(1)
		// @ 角色ID(roleid) 
		role_menu.setRoleid(1)
		// @ 角色ID(roleid) 
		role_menu.setRoleid(1)

		role_menuService.getRole_menu(role_menu);

		//查询多条
		// @ 菜单代码(menucode) 
		role_menu.setMenucode(1)
		// @ 菜单代码(menucode) 
		role_menu.setMenucode(1)
		// @ 角色ID(roleid) 
		role_menu.setRoleid(1)
		// @ 角色ID(roleid) 
		role_menu.setRoleid(1)

		role_menuService.getListRole_menu(role_menu);

		//翻页查询
		// @ 菜单代码(menucode) 
		role_menu.setMenucode(1)
		// @ 菜单代码(menucode) 
		role_menu.setMenucode(1)
		// @ 角色ID(roleid) 
		role_menu.setRoleid(1)
		// @ 角色ID(roleid) 
		role_menu.setRoleid(1)

		role_menuService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		role_menuService.insertRole_menu(role_menu);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setRole_menuService(IRole_menuService role_menuService) {
		this.role_menuService = role_menuService;
	}
}
