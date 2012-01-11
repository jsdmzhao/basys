package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Role_func;
import com.aisino2.sysadmin.service.IRole_funcService;

public class Role_funcTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IRole_funcService role_funcService;

	/** @param 角色功能(t_role_func) */

	public void test() {
		Role_func role_func = new Role_func();

	/** @ 角色ID(roleid) */
	role_func.setRoleid(0);

	/** @ 功能代码(funccode) */
	role_func.setFunccode("test");

	/** @ 参数(param) */
	role_func.setParam("test");

		/*
		//插入对象
		role_funcService.insertRole_func(role_func);

		//读取对象比较
		BaseObject bo = role_funcService.getRole_func(role_func);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Role_func role_funcNew = (Role_func)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(role_funcNew.getRoleid(), role_func.getRoleid());
		assertEquals(role_funcNew.getFunccode(), role_func.getFunccode());
		assertEquals(role_funcNew.getParam(), role_func.getParam());

		//删除对象
		// @ 角色ID(roleid) 
		role_func.setRoleid(1)
		// @ 角色ID(roleid) 
		role_func.setRoleid(1)
		// @ 功能代码(funccode) 
		role_func.setFunccode(1)
		// @ 功能代码(funccode) 
		role_func.setFunccode(1)

		role_funcService.deleteRole_func(role_func);

		//修改对象
		// @ 角色ID(roleid) 
		role_func.setRoleid(1)
		// @ 角色ID(roleid) 
		role_func.setRoleid(1)
		// @ 功能代码(funccode) 
		role_func.setFunccode(1)
		// @ 功能代码(funccode) 
		role_func.setFunccode(1)

		role_funcService.updateRole_func(role_func);

		//查询单条
		// @ 角色ID(roleid) 
		role_func.setRoleid(1)
		// @ 角色ID(roleid) 
		role_func.setRoleid(1)
		// @ 功能代码(funccode) 
		role_func.setFunccode(1)
		// @ 功能代码(funccode) 
		role_func.setFunccode(1)

		role_funcService.getRole_func(role_func);

		//查询多条
		// @ 角色ID(roleid) 
		role_func.setRoleid(1)
		// @ 角色ID(roleid) 
		role_func.setRoleid(1)
		// @ 功能代码(funccode) 
		role_func.setFunccode(1)
		// @ 功能代码(funccode) 
		role_func.setFunccode(1)

		role_funcService.getListRole_func(role_func);

		//翻页查询
		// @ 角色ID(roleid) 
		role_func.setRoleid(1)
		// @ 角色ID(roleid) 
		role_func.setRoleid(1)
		// @ 功能代码(funccode) 
		role_func.setFunccode(1)
		// @ 功能代码(funccode) 
		role_func.setFunccode(1)

		role_funcService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		role_funcService.insertRole_func(role_func);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setRole_funcService(IRole_funcService role_funcService) {
		this.role_funcService = role_funcService;
	}
}
