package com.aisino2.sysadmin.test;

import java.util.ArrayList;
import java.util.List;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Param;
import com.aisino2.sysadmin.domain.Role_param;
import com.aisino2.sysadmin.service.IParamService;

public class ParamTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IParamService paramService;

	/** @param 参数设置(t_param) */

	public void test() {
		Param param = new Param();
		Role_param role_param = null;
		List lRole_param = new ArrayList();

	/** @ 参数编码(paramcode) */
	param.setParamcode("test1");

	/** @ 参数名称(paramname) */
	param.setParamname("测试1修改");

	/** @ 参数值(paramvalue) */
	param.setParamvalue("222");
	
	role_param = new Role_param();
	role_param.setRoleid(4);
	lRole_param.add(role_param);
	role_param = null;
	
	role_param = new Role_param();
	role_param.setRoleid(8);
	lRole_param.add(role_param);
	role_param = null;

	
	role_param = new Role_param();
	role_param.setRoleid(12);
	lRole_param.add(role_param);
	role_param = null;
	
	param.setLRoleParamList(lRole_param);
		/*
		//插入对象
		paramService.insertParam(param);

		//读取对象比较
		BaseObject bo = paramService.getParam(param);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Param paramNew = (Param)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(paramNew.getParamcode(), param.getParamcode());
		assertEquals(paramNew.getParamname(), param.getParamname());
		assertEquals(paramNew.getParamvalue(), param.getParamvalue());

		//删除对象
		// @ 参数编码(paramcode) 
		param.setParamcode(1)

		paramService.deleteParam(param);

		//修改对象
		// @ 参数编码(paramcode) 
		param.setParamcode(1)

		paramService.updateParam(param);

		//查询单条
		// @ 参数编码(paramcode) 
		param.setParamcode(1)

		paramService.getParam(param);

		//查询多条
		// @ 参数编码(paramcode) 
		param.setParamcode(1)

		paramService.getListParam(param);

		//翻页查询
		// @ 参数编码(paramcode) 
		param.setParamcode(1)

		paramService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/
		paramService.deleteParam(param);
		//插入对象
		//paramService.insertParam(param);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setParamService(IParamService paramService) {
		this.paramService = paramService;
	}
}
