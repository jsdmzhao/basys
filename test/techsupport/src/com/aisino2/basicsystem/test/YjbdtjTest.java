package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Yjbdtj;
import com.aisino2.basicsystem.service.IYjbdtjService;
import com.aisino2.core.test.BaseTestCase;

public class YjbdtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IYjbdtjService yjbdtjService;

	/** @param 预警比对条件(t_yjbdtj) */

	public void test() {
		Yjbdtj yjbdtj = new Yjbdtj();

	/** @ 预警规则ID(yjgzid) */
	yjbdtj.setYjgzid(0);

	/** @ 预警比对条件ID(yjbdtjid) */
	yjbdtj.setYjbdtjid(0);

	/** @ 条件类型(tjlx) */
	yjbdtj.setTjlx("test");

	/** @ 业务表字段名(ywbzdm) */
	yjbdtj.setYwbzdm("test");

	/** @ 比对表字段名(bdbzdm) */
	yjbdtj.setBdbzdm("test");

	/** @ 比对关系(bdgx) */
	yjbdtj.setBdgx("test");

	/** @ 关系串(gxc) */
	yjbdtj.setGxc("test");

	/** @ 执行顺序(zxsx) */
	yjbdtj.setZxsx("test");

	/** @ 逻辑关系(ljgx) */
	yjbdtj.setLjgx("test");

	/** @ 级别(jibie) */
	yjbdtj.setJibie(0);

		/*
		//插入对象
		yjbdtjService.insertYjbdtj(yjbdtj);

		//读取对象比较
		BaseObject bo = yjbdtjService.getYjbdtj(yjbdtj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Yjbdtj yjbdtjNew = (Yjbdtj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(yjbdtjNew.getYjgzid(), yjbdtj.getYjgzid());
		assertEquals(yjbdtjNew.getYjbdtjid(), yjbdtj.getYjbdtjid());
		assertEquals(yjbdtjNew.getTjlx(), yjbdtj.getTjlx());
		assertEquals(yjbdtjNew.getYwbzdm(), yjbdtj.getYwbzdm());
		assertEquals(yjbdtjNew.getBdbzdm(), yjbdtj.getBdbzdm());
		assertEquals(yjbdtjNew.getBdgx(), yjbdtj.getBdgx());
		assertEquals(yjbdtjNew.getGxc(), yjbdtj.getGxc());
		assertEquals(yjbdtjNew.getZxsx(), yjbdtj.getZxsx());
		assertEquals(yjbdtjNew.getLjgx(), yjbdtj.getLjgx());
		assertEquals(yjbdtjNew.getJibie(), yjbdtj.getJibie());

		//删除对象
		// @ 预警规则ID(yjgzid) 
		yjbdtj.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		yjbdtj.setYjgzid(1)
		// @ 预警比对条件ID(yjbdtjid) 
		yjbdtj.setYjbdtjid(1)

		yjbdtjService.deleteYjbdtj(yjbdtj);

		//修改对象
		// @ 预警规则ID(yjgzid) 
		yjbdtj.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		yjbdtj.setYjgzid(1)
		// @ 预警比对条件ID(yjbdtjid) 
		yjbdtj.setYjbdtjid(1)

		yjbdtjService.updateYjbdtj(yjbdtj);

		//查询单条
		// @ 预警规则ID(yjgzid) 
		yjbdtj.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		yjbdtj.setYjgzid(1)
		// @ 预警比对条件ID(yjbdtjid) 
		yjbdtj.setYjbdtjid(1)

		yjbdtjService.getYjbdtj(yjbdtj);

		//查询多条
		// @ 预警规则ID(yjgzid) 
		yjbdtj.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		yjbdtj.setYjgzid(1)
		// @ 预警比对条件ID(yjbdtjid) 
		yjbdtj.setYjbdtjid(1)

		yjbdtjService.getListYjbdtj(yjbdtj);

		//翻页查询
		// @ 预警规则ID(yjgzid) 
		yjbdtj.setYjgzid(1)
		// @ 预警规则ID(yjgzid) 
		yjbdtj.setYjgzid(1)
		// @ 预警比对条件ID(yjbdtjid) 
		yjbdtj.setYjbdtjid(1)

		yjbdtjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		yjbdtjService.insertYjbdtj(yjbdtj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setYjbdtjService(IYjbdtjService yjbdtjService) {
		this.yjbdtjService = yjbdtjService;
	}
}
