package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Bjgz;
import com.aisino2.basicsystem.service.IBjgzService;
import com.aisino2.core.test.BaseTestCase;

public class BjgzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBjgzService bjgzService;

	/** @param 报警规则(t_bjgz) */

	public void test() {
		Bjgz bjgz = new Bjgz();

	/** @ 报警规则ID(bjgzid) */
	bjgz.setBjgzid(0);

	/** @ 业务表名(ywbm) */
	bjgz.setYwbm("test");

	/** @ 比对表名(bdbm) */
	bjgz.setBdbm("test");

	/** @ 比对类型(bdlx) */
	bjgz.setBdlx("test");

	/** @ 是否有效(sfyx) */
	bjgz.setSfyx("test");

	/** @ 发布策略(fbcl) */
	bjgz.setFbcl("test");

	/** @ 发布方式(fbfs) */
	bjgz.setFbfs("test");

	/** @ 特行单位字段(txdwzd) */
	bjgz.setTxdwzd("test");

	/** @ 管辖单位字段(gxdwzd) */
	bjgz.setGxdwzd("test");

	/** @ 报警级别(bjjb) */
	bjgz.setBjjb("test");

	/** @ 报警方式(bjfs) */
	bjgz.setBjfs("test");

	/** @ 报警类型(bjlx) */
	bjgz.setBjlx("test");

		/*
		//插入对象
		bjgzService.insertBjgz(bjgz);

		//读取对象比较
		BaseObject bo = bjgzService.getBjgz(bjgz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bjgz bjgzNew = (Bjgz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bjgzNew.getBjgzid(), bjgz.getBjgzid());
		assertEquals(bjgzNew.getYwbm(), bjgz.getYwbm());
		assertEquals(bjgzNew.getBdbm(), bjgz.getBdbm());
		assertEquals(bjgzNew.getBdlx(), bjgz.getBdlx());
		assertEquals(bjgzNew.getSfyx(), bjgz.getSfyx());
		assertEquals(bjgzNew.getFbcl(), bjgz.getFbcl());
		assertEquals(bjgzNew.getFbfs(), bjgz.getFbfs());
		assertEquals(bjgzNew.getTxdwzd(), bjgz.getTxdwzd());
		assertEquals(bjgzNew.getGxdwzd(), bjgz.getGxdwzd());
		assertEquals(bjgzNew.getBjjb(), bjgz.getBjjb());
		assertEquals(bjgzNew.getBjfs(), bjgz.getBjfs());
		assertEquals(bjgzNew.getBjlx(), bjgz.getBjlx());

		//删除对象
		// @ 报警规则ID(bjgzid) 
		bjgz.setBjgzid(1)

		bjgzService.deleteBjgz(bjgz);

		//修改对象
		// @ 报警规则ID(bjgzid) 
		bjgz.setBjgzid(1)

		bjgzService.updateBjgz(bjgz);

		//查询单条
		// @ 报警规则ID(bjgzid) 
		bjgz.setBjgzid(1)

		bjgzService.getBjgz(bjgz);

		//查询多条
		// @ 报警规则ID(bjgzid) 
		bjgz.setBjgzid(1)

		bjgzService.getListBjgz(bjgz);

		//翻页查询
		// @ 报警规则ID(bjgzid) 
		bjgz.setBjgzid(1)

		bjgzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bjgzService.insertBjgz(bjgz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBjgzService(IBjgzService bjgzService) {
		this.bjgzService = bjgzService;
	}
}
