package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.System;
import com.aisino2.sysadmin.service.ISystemService;

public class SystemTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ISystemService systemService;

	/** @param 系统(t_system) */

	public void test() {
		System system = new System();

	/** @ 系统代码(systemcode) */
	system.setSystemcode("test");

	/** @ 系统名称(systemname) */
	system.setSystemname("test");

	/** @ 系统定义(systemdefine) */
	system.setSystemdefine("test");

	/** @ 图片路径(picturepath) */
	system.setPicturepath("test");

	/** @ 上级系统代码(parentsystemcode) */
	system.setParentsystemcode("test");

	/** @ 节点顺序(nodeorder) */
	system.setNodeorder(0);

	/** @ 是否叶结点(isleaf) */
	system.setIsleaf("te");

	/** @ 系统全路径代码(fullcode) */
	system.setFullcode("test");

		/*
		//插入对象
		systemService.insertSystem(system);

		//读取对象比较
		BaseObject bo = systemService.getSystem(system);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		System systemNew = (System)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(systemNew.getSystemcode(), system.getSystemcode());
		assertEquals(systemNew.getSystemname(), system.getSystemname());
		assertEquals(systemNew.getSystemdefine(), system.getSystemdefine());
		assertEquals(systemNew.getPicturepath(), system.getPicturepath());
		assertEquals(systemNew.getParentsystemcode(), system.getParentsystemcode());
		assertEquals(systemNew.getNodeorder(), system.getNodeorder());
		assertEquals(systemNew.getIsleaf(), system.getIsleaf());
		assertEquals(systemNew.getFullcode(), system.getFullcode());

		//删除对象
		// @ 系统代码(systemcode) 
		system.setSystemcode(1)

		systemService.deleteSystem(system);

		//修改对象
		// @ 系统代码(systemcode) 
		system.setSystemcode(1)

		systemService.updateSystem(system);

		//查询单条
		// @ 系统代码(systemcode) 
		system.setSystemcode(1)

		systemService.getSystem(system);

		//查询多条
		// @ 系统代码(systemcode) 
		system.setSystemcode(1)

		systemService.getListSystem(system);

		//翻页查询
		// @ 系统代码(systemcode) 
		system.setSystemcode(1)

		systemService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/
		System systemSort = new System();
		systemSort.setSystemcode("cjd");
		systemSort.setNodeorder(0);
		//systemSort.setWay("置顶");
		systemSort.setWay("上移");
		//systemSort.setWay("下移");
		//systemSort.setWay("置底");
		systemService.updateSystemEditEdOrder(systemSort);
		//插入对象
		//systemService.insertSystem(system);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setSystemService(ISystemService systemService) {
		this.systemService = systemService;
	}
}
