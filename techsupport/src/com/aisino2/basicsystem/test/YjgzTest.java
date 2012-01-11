package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Yjgz;
import com.aisino2.basicsystem.service.IYjgzService;
import com.aisino2.core.test.BaseTestCase;

public class YjgzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IYjgzService yjgzService;

	/** @param 预警规则(t_yjgz) */

	public void test() {
		Yjgz yjgz = new Yjgz();

	/** @ 预警规则ID(yjgzid) */
	yjgz.setYjgzid(0);

	/** @ 业务表名(ywbm) */
	yjgz.setYwbm("test");

	/** @ 比对表名(bdbm) */
	yjgz.setBdbm("test");

	/** @ 比对类型(bdlx) */
	yjgz.setBdlx("test");

	/** @ 是否有效(sfyx) */
	yjgz.setSfyx("test");

	/** @ 发布策略(fbcl) */
	yjgz.setFbcl("test");

	/** @ 发布方式(fbfs) */
	yjgz.setFbfs("test");

	/** @ 特行单位字段(txdwzd) */
	yjgz.setTxdwzd("test");

	/** @ 管辖单位字段(gxdwzd) */
	yjgz.setGxdwzd("test");

	/** @ 预警级别(yjjb) */
	yjgz.setYjjb("test");

	/** @ 预警方式(yjfs) */
	yjgz.setYjfs("test");

	/** @ 预警类型(yjlx) */
	yjgz.setYjlx("test");

		/*
		//插入对象
		yjgzService.insertYjgz(yjgz);

		//读取对象比较
		BaseObject bo = yjgzService.getYjgz(yjgz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Yjgz yjgzNew = (Yjgz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(yjgzNew.getYjgzid(), yjgz.getYjgzid());
		assertEquals(yjgzNew.getYwbm(), yjgz.getYwbm());
		assertEquals(yjgzNew.getBdbm(), yjgz.getBdbm());
		assertEquals(yjgzNew.getBdlx(), yjgz.getBdlx());
		assertEquals(yjgzNew.getSfyx(), yjgz.getSfyx());
		assertEquals(yjgzNew.getFbcl(), yjgz.getFbcl());
		assertEquals(yjgzNew.getFbfs(), yjgz.getFbfs());
		assertEquals(yjgzNew.getTxdwzd(), yjgz.getTxdwzd());
		assertEquals(yjgzNew.getGxdwzd(), yjgz.getGxdwzd());
		assertEquals(yjgzNew.getYjjb(), yjgz.getYjjb());
		assertEquals(yjgzNew.getYjfs(), yjgz.getYjfs());
		assertEquals(yjgzNew.getYjlx(), yjgz.getYjlx());

		//删除对象
		// @ 预警规则ID(yjgzid) 
		yjgz.setYjgzid(1)

		yjgzService.deleteYjgz(yjgz);

		//修改对象
		// @ 预警规则ID(yjgzid) 
		yjgz.setYjgzid(1)

		yjgzService.updateYjgz(yjgz);

		//查询单条
		// @ 预警规则ID(yjgzid) 
		yjgz.setYjgzid(1)

		yjgzService.getYjgz(yjgz);

		//查询多条
		// @ 预警规则ID(yjgzid) 
		yjgz.setYjgzid(1)

		yjgzService.getListYjgz(yjgz);

		//翻页查询
		// @ 预警规则ID(yjgzid) 
		yjgz.setYjgzid(1)

		yjgzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		yjgzService.insertYjgz(yjgz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setYjgzService(IYjgzService yjgzService) {
		this.yjgzService = yjgzService;
	}
}
