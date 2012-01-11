package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.User_role;
import com.aisino2.sysadmin.service.IUser_roleService;

public class User_roleTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IUser_roleService user_roleService;

	/** @param 用户角色(t_user_role) */

	public void test() {
		User_role user_role = new User_role();

	/** @ 角色ID(roleid) */
	user_role.setRoleid(0);

	/** @ 用户ID(userid) */
	user_role.setUserid(0);

		/*
		//插入对象
		user_roleService.insertUser_role(user_role);

		//读取对象比较
		BaseObject bo = user_roleService.getUser_role(user_role);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		User_role user_roleNew = (User_role)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(user_roleNew.getRoleid(), user_role.getRoleid());
		assertEquals(user_roleNew.getUserid(), user_role.getUserid());

		//删除对象
		// @ 角色ID(roleid) 
		user_role.setRoleid(1)
		// @ 角色ID(roleid) 
		user_role.setRoleid(1)
		// @ 用户ID(userid) 
		user_role.setUserid(1)
		// @ 用户ID(userid) 
		user_role.setUserid(1)

		user_roleService.deleteUser_role(user_role);

		//修改对象
		// @ 角色ID(roleid) 
		user_role.setRoleid(1)
		// @ 角色ID(roleid) 
		user_role.setRoleid(1)
		// @ 用户ID(userid) 
		user_role.setUserid(1)
		// @ 用户ID(userid) 
		user_role.setUserid(1)

		user_roleService.updateUser_role(user_role);

		//查询单条
		// @ 角色ID(roleid) 
		user_role.setRoleid(1)
		// @ 角色ID(roleid) 
		user_role.setRoleid(1)
		// @ 用户ID(userid) 
		user_role.setUserid(1)
		// @ 用户ID(userid) 
		user_role.setUserid(1)

		user_roleService.getUser_role(user_role);

		//查询多条
		// @ 角色ID(roleid) 
		user_role.setRoleid(1)
		// @ 角色ID(roleid) 
		user_role.setRoleid(1)
		// @ 用户ID(userid) 
		user_role.setUserid(1)
		// @ 用户ID(userid) 
		user_role.setUserid(1)

		user_roleService.getListUser_role(user_role);

		//翻页查询
		// @ 角色ID(roleid) 
		user_role.setRoleid(1)
		// @ 角色ID(roleid) 
		user_role.setRoleid(1)
		// @ 用户ID(userid) 
		user_role.setUserid(1)
		// @ 用户ID(userid) 
		user_role.setUserid(1)

		user_roleService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		user_roleService.insertUser_role(user_role);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setUser_roleService(IUser_roleService user_roleService) {
		this.user_roleService = user_roleService;
	}
}
