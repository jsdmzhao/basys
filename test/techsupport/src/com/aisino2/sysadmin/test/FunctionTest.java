package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Function;
import com.aisino2.sysadmin.service.IFunctionService;

public class FunctionTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IFunctionService functionService;

	/** @param 功能(t_function) */

	public void test() {
		Function function = new Function();

	/** @ 功能代码(funccode) */
	function.setFunccode("test");

	/** @ 系统代码(systemcode) */
	function.setSystemcode("test");

	/** @ 功能名称(funcname) */
	function.setFuncname("test");

	/** @ 功能定义(funcdefine) */
	function.setFuncdefine("test");

	/** @ 功能类别(functype) */
	function.setFunctype(0);

		/*
		//插入对象
		functionService.insertFunction(function);

		//读取对象比较
		BaseObject bo = functionService.getFunction(function);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Function functionNew = (Function)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(functionNew.getFunccode(), function.getFunccode());
		assertEquals(functionNew.getSystemcode(), function.getSystemcode());
		assertEquals(functionNew.getFuncname(), function.getFuncname());
		assertEquals(functionNew.getFuncdefine(), function.getFuncdefine());
		assertEquals(functionNew.getFunctype(), function.getFunctype());

		//删除对象
		// @ 功能代码(funccode) 
		function.setFunccode(1)
		// @ 系统代码(systemcode) 
		function.setSystemcode(1)

		functionService.deleteFunction(function);

		//修改对象
		// @ 功能代码(funccode) 
		function.setFunccode(1)
		// @ 系统代码(systemcode) 
		function.setSystemcode(1)

		functionService.updateFunction(function);

		//查询单条
		// @ 功能代码(funccode) 
		function.setFunccode(1)
		// @ 系统代码(systemcode) 
		function.setSystemcode(1)

		functionService.getFunction(function);

		//查询多条
		// @ 功能代码(funccode) 
		function.setFunccode(1)
		// @ 系统代码(systemcode) 
		function.setSystemcode(1)

		functionService.getListFunction(function);

		//翻页查询
		// @ 功能代码(funccode) 
		function.setFunccode(1)
		// @ 系统代码(systemcode) 
		function.setSystemcode(1)

		functionService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		functionService.insertFunction(function);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setFunctionService(IFunctionService functionService) {
		this.functionService = functionService;
	}
}
