package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Gjcxfa;
import com.aisino2.basicsystem.service.IGjcxfaService;
import com.aisino2.core.test.BaseTestCase;

public class GjcxfaTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IGjcxfaService gjcxfaService;

	/** @param 高级查询方案(t_gjcxfa) */

	public void test() {
		Gjcxfa gjcxfa = new Gjcxfa();

	/** @ 高级查询方案ID(gjcxfaid) */
	gjcxfa.setGjcxfaid(0);

	/** @ 高级查询方案名称(gjcxfamc) */
	gjcxfa.setGjcxfamc("test");

	/** @ 所属用户帐号(ssyhzh) */
	gjcxfa.setSsyhzh("test");

	/** @ 所属功能名称(ssgnmc) */
	gjcxfa.setSsgnmc("test");

	/** @ 高级查询类型(gjcxlx) */
	gjcxfa.setGjcxlx("test");

		/*
		//插入对象
		gjcxfaService.insertGjcxfa(gjcxfa);

		//读取对象比较
		BaseObject bo = gjcxfaService.getGjcxfa(gjcxfa);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Gjcxfa gjcxfaNew = (Gjcxfa)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(gjcxfaNew.getGjcxfaid(), gjcxfa.getGjcxfaid());
		assertEquals(gjcxfaNew.getGjcxfamc(), gjcxfa.getGjcxfamc());
		assertEquals(gjcxfaNew.getSsyhzh(), gjcxfa.getSsyhzh());
		assertEquals(gjcxfaNew.getSsgnmc(), gjcxfa.getSsgnmc());
		assertEquals(gjcxfaNew.getGjcxlx(), gjcxfa.getGjcxlx());

		//删除对象
		// @ 高级查询方案ID(gjcxfaid) 
		gjcxfa.setGjcxfaid(1)

		gjcxfaService.deleteGjcxfa(gjcxfa);

		//修改对象
		// @ 高级查询方案ID(gjcxfaid) 
		gjcxfa.setGjcxfaid(1)

		gjcxfaService.updateGjcxfa(gjcxfa);

		//查询单条
		// @ 高级查询方案ID(gjcxfaid) 
		gjcxfa.setGjcxfaid(1)

		gjcxfaService.getGjcxfa(gjcxfa);

		//查询多条
		// @ 高级查询方案ID(gjcxfaid) 
		gjcxfa.setGjcxfaid(1)

		gjcxfaService.getListGjcxfa(gjcxfa);

		//翻页查询
		// @ 高级查询方案ID(gjcxfaid) 
		gjcxfa.setGjcxfaid(1)

		gjcxfaService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		gjcxfaService.insertGjcxfa(gjcxfa);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setGjcxfaService(IGjcxfaService gjcxfaService) {
		this.gjcxfaService = gjcxfaService;
	}
}
