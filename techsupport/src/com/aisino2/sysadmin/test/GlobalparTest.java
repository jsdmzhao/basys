package com.aisino2.sysadmin.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.sysadmin.domain.Globalpar;
import com.aisino2.sysadmin.service.IGlobalparService;

public class GlobalparTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IGlobalparService globalparService;

	/** @param 全局参数(t_globalpar) */

	public void test() {
		Globalpar globalpar = new Globalpar();

	/** @ 参数编码(globalparcode) */
	globalpar.setGlobalparcode("test");

	/** @ 参数名称(globalparname) */
	globalpar.setGlobalparname("test");

	/** @ 参数值(globalparvalue) */
	globalpar.setGlobalparvalue("test");

		/*
		//插入对象
		globalparService.insertGlobalpar(globalpar);

		//读取对象比较
		BaseObject bo = globalparService.getGlobalpar(globalpar);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Globalpar globalparNew = (Globalpar)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(globalparNew.getGlobalparcode(), globalpar.getGlobalparcode());
		assertEquals(globalparNew.getGlobalparname(), globalpar.getGlobalparname());
		assertEquals(globalparNew.getGlobalparvalue(), globalpar.getGlobalparvalue());

		//删除对象
		// @ 参数编码(globalparcode) 
		globalpar.setGlobalparcode(1)

		globalparService.deleteGlobalpar(globalpar);

		//修改对象
		// @ 参数编码(globalparcode) 
		globalpar.setGlobalparcode(1)

		globalparService.updateGlobalpar(globalpar);

		//查询单条
		// @ 参数编码(globalparcode) 
		globalpar.setGlobalparcode(1)

		globalparService.getGlobalpar(globalpar);

		//查询多条
		// @ 参数编码(globalparcode) 
		globalpar.setGlobalparcode(1)

		globalparService.getListGlobalpar(globalpar);

		//翻页查询
		// @ 参数编码(globalparcode) 
		globalpar.setGlobalparcode(1)

		globalparService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		globalparService.insertGlobalpar(globalpar);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setGlobalparService(IGlobalparService globalparService) {
		this.globalparService = globalparService;
	}
}
