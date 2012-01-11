package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Wpbjgz;
import com.aisino2.basicsystem.service.IWpbjgzService;
import com.aisino2.core.test.BaseTestCase;

public class WpbjgzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IWpbjgzService wpbjgzService;

	/** @param 物品报警规则(t_wpbjgz) */

	public void test() {
		Wpbjgz wpbjgz = new Wpbjgz();

	/** @ 报警信息ID(bjxxid2) */
	wpbjgz.setBjxxid2(0);

	/** @ 物品报警规则ID(wpbjgzid) */
	wpbjgz.setWpbjgzid(0);

	/** @ 业务表名(ywbm) */
	wpbjgz.setYwbm("test");

	/** @ 业务表字段名(ywbzdm) */
	wpbjgz.setYwbzdm("test");

	/** @ 比对表名(bdbm) */
	wpbjgz.setBdbm("test");

	/** @ 比对表字段名(bdbzdm) */
	wpbjgz.setBdbzdm("test");

	/** @ 比对类型代码(bdlxdm) */
	wpbjgz.setBdlxdm("test");

	/** @ 比对类型(bdlx) */
	wpbjgz.setBdlx("test");

	/** @ 是否有效(sfyx) */
	wpbjgz.setSfyx("test");

	/** @ 发布策略(fbcl) */
	wpbjgz.setFbcl("test");

	/** @ 发布方式(fbfs) */
	wpbjgz.setFbfs("test");

	/** @ 特行单位字段(txdwzd) */
	wpbjgz.setTxdwzd("test");

	/** @ 管辖单位字段(gxdwzd) */
	wpbjgz.setGxdwzd("test");

	/** @ 报警级别(bjjb) */
	wpbjgz.setBjjb("test");

	/** @ 报警方式(bjfs) */
	wpbjgz.setBjfs("test");

	/** @ 报警类型代码(bjlxdm) */
	wpbjgz.setBjlxdm("test");

	/** @ 报警类型(bjlx) */
	wpbjgz.setBjlx("test");

	/** @ 行业类别代码(hylbdm) */
	wpbjgz.setHylbdm("test");

	/** @ 行业类别(hylb) */
	wpbjgz.setHylb("test");

		/*
		//插入对象
		wpbjgzService.insertWpbjgz(wpbjgz);

		//读取对象比较
		BaseObject bo = wpbjgzService.getWpbjgz(wpbjgz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Wpbjgz wpbjgzNew = (Wpbjgz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(wpbjgzNew.getBjxxid2(), wpbjgz.getBjxxid2());
		assertEquals(wpbjgzNew.getWpbjgzid(), wpbjgz.getWpbjgzid());
		assertEquals(wpbjgzNew.getYwbm(), wpbjgz.getYwbm());
		assertEquals(wpbjgzNew.getYwbzdm(), wpbjgz.getYwbzdm());
		assertEquals(wpbjgzNew.getBdbm(), wpbjgz.getBdbm());
		assertEquals(wpbjgzNew.getBdbzdm(), wpbjgz.getBdbzdm());
		assertEquals(wpbjgzNew.getBdlxdm(), wpbjgz.getBdlxdm());
		assertEquals(wpbjgzNew.getBdlx(), wpbjgz.getBdlx());
		assertEquals(wpbjgzNew.getSfyx(), wpbjgz.getSfyx());
		assertEquals(wpbjgzNew.getFbcl(), wpbjgz.getFbcl());
		assertEquals(wpbjgzNew.getFbfs(), wpbjgz.getFbfs());
		assertEquals(wpbjgzNew.getTxdwzd(), wpbjgz.getTxdwzd());
		assertEquals(wpbjgzNew.getGxdwzd(), wpbjgz.getGxdwzd());
		assertEquals(wpbjgzNew.getBjjb(), wpbjgz.getBjjb());
		assertEquals(wpbjgzNew.getBjfs(), wpbjgz.getBjfs());
		assertEquals(wpbjgzNew.getBjlxdm(), wpbjgz.getBjlxdm());
		assertEquals(wpbjgzNew.getBjlx(), wpbjgz.getBjlx());
		assertEquals(wpbjgzNew.getHylbdm(), wpbjgz.getHylbdm());
		assertEquals(wpbjgzNew.getHylb(), wpbjgz.getHylb());

		//删除对象
		// @ 报警信息ID(bjxxid2) 
		wpbjgz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		wpbjgz.setBjxxid2(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjgz.setWpbjgzid(1)

		wpbjgzService.deleteWpbjgz(wpbjgz);

		//修改对象
		// @ 报警信息ID(bjxxid2) 
		wpbjgz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		wpbjgz.setBjxxid2(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjgz.setWpbjgzid(1)

		wpbjgzService.updateWpbjgz(wpbjgz);

		//查询单条
		// @ 报警信息ID(bjxxid2) 
		wpbjgz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		wpbjgz.setBjxxid2(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjgz.setWpbjgzid(1)

		wpbjgzService.getWpbjgz(wpbjgz);

		//查询多条
		// @ 报警信息ID(bjxxid2) 
		wpbjgz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		wpbjgz.setBjxxid2(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjgz.setWpbjgzid(1)

		wpbjgzService.getListWpbjgz(wpbjgz);

		//翻页查询
		// @ 报警信息ID(bjxxid2) 
		wpbjgz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		wpbjgz.setBjxxid2(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjgz.setWpbjgzid(1)

		wpbjgzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		wpbjgzService.insertWpbjgz(wpbjgz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setWpbjgzService(IWpbjgzService wpbjgzService) {
		this.wpbjgzService = wpbjgzService;
	}
}
