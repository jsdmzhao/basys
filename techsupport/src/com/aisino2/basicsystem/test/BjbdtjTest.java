package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Bjbdtj;
import com.aisino2.basicsystem.service.IBjbdtjService;
import com.aisino2.core.test.BaseTestCase;

public class BjbdtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBjbdtjService bjbdtjService;

	/** @param 报警比对条件(t_bjbdtj) */

	public void test() {
		Bjbdtj bjbdtj = new Bjbdtj();

	/** @ 报警规则ID(bjgzid) */
	bjbdtj.setBjgzid(0);

	/** @ 报警比对条件ID(bjbdtjid) */
	bjbdtj.setBjbdtjid(0);

	/** @ 条件类型(tjlx) */
	bjbdtj.setTjlx("test");

	/** @ 业务表字段名(ywbzdm) */
	bjbdtj.setYwbzdm("test");

	/** @ 比对表字段名(bdbzdm) */
	bjbdtj.setBdbzdm("test");

	/** @ 比对关系(bdgx) */
	bjbdtj.setBdgx("test");

	/** @ 关系串(gxc) */
	bjbdtj.setGxc("test");

	/** @ 执行顺序(zxsx) */
	bjbdtj.setZxsx("test");

	/** @ 逻辑关系(ljgx) */
	bjbdtj.setLjgx("test");

	/** @ 级别(jibie) */
	bjbdtj.setJibie(0);

		/*
		//插入对象
		bjbdtjService.insertBjbdtj(bjbdtj);

		//读取对象比较
		BaseObject bo = bjbdtjService.getBjbdtj(bjbdtj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bjbdtj bjbdtjNew = (Bjbdtj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bjbdtjNew.getBjgzid(), bjbdtj.getBjgzid());
		assertEquals(bjbdtjNew.getBjbdtjid(), bjbdtj.getBjbdtjid());
		assertEquals(bjbdtjNew.getTjlx(), bjbdtj.getTjlx());
		assertEquals(bjbdtjNew.getYwbzdm(), bjbdtj.getYwbzdm());
		assertEquals(bjbdtjNew.getBdbzdm(), bjbdtj.getBdbzdm());
		assertEquals(bjbdtjNew.getBdgx(), bjbdtj.getBdgx());
		assertEquals(bjbdtjNew.getGxc(), bjbdtj.getGxc());
		assertEquals(bjbdtjNew.getZxsx(), bjbdtj.getZxsx());
		assertEquals(bjbdtjNew.getLjgx(), bjbdtj.getLjgx());
		assertEquals(bjbdtjNew.getJibie(), bjbdtj.getJibie());

		//删除对象
		// @ 报警规则ID(bjgzid) 
		bjbdtj.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bjbdtj.setBjgzid(1)
		// @ 报警比对条件ID(bjbdtjid) 
		bjbdtj.setBjbdtjid(1)

		bjbdtjService.deleteBjbdtj(bjbdtj);

		//修改对象
		// @ 报警规则ID(bjgzid) 
		bjbdtj.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bjbdtj.setBjgzid(1)
		// @ 报警比对条件ID(bjbdtjid) 
		bjbdtj.setBjbdtjid(1)

		bjbdtjService.updateBjbdtj(bjbdtj);

		//查询单条
		// @ 报警规则ID(bjgzid) 
		bjbdtj.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bjbdtj.setBjgzid(1)
		// @ 报警比对条件ID(bjbdtjid) 
		bjbdtj.setBjbdtjid(1)

		bjbdtjService.getBjbdtj(bjbdtj);

		//查询多条
		// @ 报警规则ID(bjgzid) 
		bjbdtj.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bjbdtj.setBjgzid(1)
		// @ 报警比对条件ID(bjbdtjid) 
		bjbdtj.setBjbdtjid(1)

		bjbdtjService.getListBjbdtj(bjbdtj);

		//翻页查询
		// @ 报警规则ID(bjgzid) 
		bjbdtj.setBjgzid(1)
		// @ 报警规则ID(bjgzid) 
		bjbdtj.setBjgzid(1)
		// @ 报警比对条件ID(bjbdtjid) 
		bjbdtj.setBjbdtjid(1)

		bjbdtjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bjbdtjService.insertBjbdtj(bjbdtj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBjbdtjService(IBjbdtjService bjbdtjService) {
		this.bjbdtjService = bjbdtjService;
	}
}
