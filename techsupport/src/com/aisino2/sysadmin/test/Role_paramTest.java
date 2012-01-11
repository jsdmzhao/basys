package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Role_param;
import com.aisino2.sysadmin.service.IRole_paramService;

public class Role_paramTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IRole_paramService role_paramService;

	/** @param 角色参数(t_role_param) */

	public void test() {
		Role_param role_param = new Role_param();

	/** @ 角色ID(roleid) */
	//role_param.setRoleid(0);

	/** @ 参数编码(paramcode) */
	//role_param.setParamcode("test");

		/*
		//插入对象
		role_paramService.insertRole_param(role_param);

		//读取对象比较
		BaseObject bo = role_paramService.getRole_param(role_param);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Role_param role_paramNew = (Role_param)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(role_paramNew.getRoleid(), role_param.getRoleid());
		assertEquals(role_paramNew.getParamcode(), role_param.getParamcode());

		//删除对象
		// @ 角色ID(roleid) 
		role_param.setRoleid(1)
		// @ 角色ID(roleid) 
		role_param.setRoleid(1)
		// @ 参数编码(paramcode) 
		role_param.setParamcode(1)
		// @ 参数编码(paramcode) 
		role_param.setParamcode(1)

		role_paramService.deleteRole_param(role_param);

		//修改对象
		// @ 角色ID(roleid) 
		role_param.setRoleid(1)
		// @ 角色ID(roleid) 
		role_param.setRoleid(1)
		// @ 参数编码(paramcode) 
		role_param.setParamcode(1)
		// @ 参数编码(paramcode) 
		role_param.setParamcode(1)

		role_paramService.updateRole_param(role_param);

		//查询单条
		// @ 角色ID(roleid) 
		role_param.setRoleid(1)
		// @ 角色ID(roleid) 
		role_param.setRoleid(1)
		// @ 参数编码(paramcode) 
		role_param.setParamcode(1)
		// @ 参数编码(paramcode) 
		role_param.setParamcode(1)

		role_paramService.getRole_param(role_param);

		//查询多条
		// @ 角色ID(roleid) 
		role_param.setRoleid(1)
		// @ 角色ID(roleid) 
		role_param.setRoleid(1)
		// @ 参数编码(paramcode) 
		role_param.setParamcode(1)
		// @ 参数编码(paramcode) 
		role_param.setParamcode(1)

		role_paramService.getListRole_param(role_param);

		//翻页查询
		// @ 角色ID(roleid) 
		role_param.setRoleid(1)
		// @ 角色ID(roleid) 
		role_param.setRoleid(1)
		// @ 参数编码(paramcode) 
		role_param.setParamcode(1)
		// @ 参数编码(paramcode) 
		role_param.setParamcode(1)

		role_paramService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		//role_paramService.insertRole_param(role_param);
	role_param.setRoleid(4);
	role_param.setParamcode("param2");
	//role_paramService.getListRole_param(role_param);
	role_paramService.getRole_param(role_param);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setRole_paramService(IRole_paramService role_paramService) {
		this.role_paramService = role_paramService;
	}
}
