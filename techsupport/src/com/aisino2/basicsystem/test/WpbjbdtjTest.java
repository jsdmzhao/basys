package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Wpbjbdtj;
import com.aisino2.basicsystem.service.IWpbjbdtjService;
import com.aisino2.core.test.BaseTestCase;

public class WpbjbdtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IWpbjbdtjService wpbjbdtjService;

	/** @param 物品报警比对条件(t_wpbjbdtj) */

	public void test() {
		Wpbjbdtj wpbjbdtj = new Wpbjbdtj();

	/** @ 报警信息ID(bjxxid2) */
	wpbjbdtj.setBjxxid2(0);

	/** @ 物品报警规则ID(wpbjgzid) */
	wpbjbdtj.setWpbjgzid(0);

	/** @ 物品报警比对条件ID(wpbjbdtjid) */
	wpbjbdtj.setWpbjbdtjid(0);

	/** @ 条件类型(tjlx) */
	wpbjbdtj.setTjlx("test");

	/** @ 业务表字段名(ywbzdm) */
	wpbjbdtj.setYwbzdm("test");

	/** @ 比对表字段名(bdbzdm) */
	wpbjbdtj.setBdbzdm("test");

	/** @ 比对关系(bdgx) */
	wpbjbdtj.setBdgx("test");

	/** @ 关系串(gxc) */
	wpbjbdtj.setGxc("test");

	/** @ 执行顺序(zxsx) */
	wpbjbdtj.setZxsx("test");

	/** @ 逻辑关系(ljgx) */
	wpbjbdtj.setLjgx("test");

	/** @ 级别(jibie) */
	wpbjbdtj.setJibie(0);

		/*
		//插入对象
		wpbjbdtjService.insertWpbjbdtj(wpbjbdtj);

		//读取对象比较
		BaseObject bo = wpbjbdtjService.getWpbjbdtj(wpbjbdtj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Wpbjbdtj wpbjbdtjNew = (Wpbjbdtj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(wpbjbdtjNew.getBjxxid2(), wpbjbdtj.getBjxxid2());
		assertEquals(wpbjbdtjNew.getWpbjgzid(), wpbjbdtj.getWpbjgzid());
		assertEquals(wpbjbdtjNew.getWpbjbdtjid(), wpbjbdtj.getWpbjbdtjid());
		assertEquals(wpbjbdtjNew.getTjlx(), wpbjbdtj.getTjlx());
		assertEquals(wpbjbdtjNew.getYwbzdm(), wpbjbdtj.getYwbzdm());
		assertEquals(wpbjbdtjNew.getBdbzdm(), wpbjbdtj.getBdbzdm());
		assertEquals(wpbjbdtjNew.getBdgx(), wpbjbdtj.getBdgx());
		assertEquals(wpbjbdtjNew.getGxc(), wpbjbdtj.getGxc());
		assertEquals(wpbjbdtjNew.getZxsx(), wpbjbdtj.getZxsx());
		assertEquals(wpbjbdtjNew.getLjgx(), wpbjbdtj.getLjgx());
		assertEquals(wpbjbdtjNew.getJibie(), wpbjbdtj.getJibie());

		//删除对象
		// @ 报警信息ID(bjxxid2) 
		wpbjbdtj.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		wpbjbdtj.setBjxxid2(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjbdtj.setWpbjgzid(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjbdtj.setWpbjgzid(1)
		// @ 物品报警比对条件ID(wpbjbdtjid) 
		wpbjbdtj.setWpbjbdtjid(1)

		wpbjbdtjService.deleteWpbjbdtj(wpbjbdtj);

		//修改对象
		// @ 报警信息ID(bjxxid2) 
		wpbjbdtj.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		wpbjbdtj.setBjxxid2(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjbdtj.setWpbjgzid(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjbdtj.setWpbjgzid(1)
		// @ 物品报警比对条件ID(wpbjbdtjid) 
		wpbjbdtj.setWpbjbdtjid(1)

		wpbjbdtjService.updateWpbjbdtj(wpbjbdtj);

		//查询单条
		// @ 报警信息ID(bjxxid2) 
		wpbjbdtj.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		wpbjbdtj.setBjxxid2(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjbdtj.setWpbjgzid(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjbdtj.setWpbjgzid(1)
		// @ 物品报警比对条件ID(wpbjbdtjid) 
		wpbjbdtj.setWpbjbdtjid(1)

		wpbjbdtjService.getWpbjbdtj(wpbjbdtj);

		//查询多条
		// @ 报警信息ID(bjxxid2) 
		wpbjbdtj.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		wpbjbdtj.setBjxxid2(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjbdtj.setWpbjgzid(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjbdtj.setWpbjgzid(1)
		// @ 物品报警比对条件ID(wpbjbdtjid) 
		wpbjbdtj.setWpbjbdtjid(1)

		wpbjbdtjService.getListWpbjbdtj(wpbjbdtj);

		//翻页查询
		// @ 报警信息ID(bjxxid2) 
		wpbjbdtj.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		wpbjbdtj.setBjxxid2(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjbdtj.setWpbjgzid(1)
		// @ 物品报警规则ID(wpbjgzid) 
		wpbjbdtj.setWpbjgzid(1)
		// @ 物品报警比对条件ID(wpbjbdtjid) 
		wpbjbdtj.setWpbjbdtjid(1)

		wpbjbdtjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		wpbjbdtjService.insertWpbjbdtj(wpbjbdtj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setWpbjbdtjService(IWpbjbdtjService wpbjbdtjService) {
		this.wpbjbdtjService = wpbjbdtjService;
	}
}
