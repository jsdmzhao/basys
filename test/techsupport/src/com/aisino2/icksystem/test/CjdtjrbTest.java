package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Cjdtjrb;
import com.aisino2.icksystem.service.ICjdtjrbService;

public class CjdtjrbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ICjdtjrbService cjdtjrbService;

	/** @param 采集端统计日报(t_cjdtjrb) */

	public void test() {
		Cjdtjrb cjdtjrb = new Cjdtjrb();

	/** @ 采集端统计日报ID(cjdtjrbid) */
	cjdtjrb.setCjdtjrbid(0);

	/** @ 采集端统计日期(cjdtjrq) */
	cjdtjrb.setCjdtjrq(new Date());

	/** @ 所属地市编码(ssdsbm) */
	cjdtjrb.setSsdsbm("test");

	/** @ 所属地市名称(ssdsmc) */
	cjdtjrb.setSsdsmc("test");

	/** @ 采集点编码(cjdbm) */
	cjdtjrb.setCjdbm("test");

	/** @ 采集点名称(cjdmc) */
	cjdtjrb.setCjdmc("test");

	/** @ 已录入场所数(lrcss) */
	cjdtjrb.setLrcss(0);

	/** @ 已录入从业人员数(lrcyrys) */
	cjdtjrb.setLrcyrys(0);

	/** @ 已受理IC卡数(yslicks) */
	cjdtjrb.setYslicks(0);

	/** @ 已接收(yjss) */
	cjdtjrb.setYjss(0);

	/** @ 已发放(yffs) */
	cjdtjrb.setYffs(0);

		/*
		//插入对象
		cjdtjrbService.insertCjdtjrb(cjdtjrb);

		//读取对象比较
		BaseObject bo = cjdtjrbService.getCjdtjrb(cjdtjrb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Cjdtjrb cjdtjrbNew = (Cjdtjrb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(cjdtjrbNew.getCjdtjrbid(), cjdtjrb.getCjdtjrbid());
		assertEquals(cjdtjrbNew.getCjdtjrq(), cjdtjrb.getCjdtjrq());
		assertEquals(cjdtjrbNew.getSsdsbm(), cjdtjrb.getSsdsbm());
		assertEquals(cjdtjrbNew.getSsdsmc(), cjdtjrb.getSsdsmc());
		assertEquals(cjdtjrbNew.getCjdbm(), cjdtjrb.getCjdbm());
		assertEquals(cjdtjrbNew.getCjdmc(), cjdtjrb.getCjdmc());
		assertEquals(cjdtjrbNew.getLrcss(), cjdtjrb.getLrcss());
		assertEquals(cjdtjrbNew.getLrcyrys(), cjdtjrb.getLrcyrys());
		assertEquals(cjdtjrbNew.getYslicks(), cjdtjrb.getYslicks());
		assertEquals(cjdtjrbNew.getYjss(), cjdtjrb.getYjss());
		assertEquals(cjdtjrbNew.getYffs(), cjdtjrb.getYffs());

		//删除对象
		// @ 采集端统计日报ID(cjdtjrbid) 
		cjdtjrb.setCjdtjrbid(1)

		cjdtjrbService.deleteCjdtjrb(cjdtjrb);

		//修改对象
		// @ 采集端统计日报ID(cjdtjrbid) 
		cjdtjrb.setCjdtjrbid(1)

		cjdtjrbService.updateCjdtjrb(cjdtjrb);

		//查询单条
		// @ 采集端统计日报ID(cjdtjrbid) 
		cjdtjrb.setCjdtjrbid(1)

		cjdtjrbService.getCjdtjrb(cjdtjrb);

		//查询多条
		// @ 采集端统计日报ID(cjdtjrbid) 
		cjdtjrb.setCjdtjrbid(1)

		cjdtjrbService.getListCjdtjrb(cjdtjrb);

		//翻页查询
		// @ 采集端统计日报ID(cjdtjrbid) 
		cjdtjrb.setCjdtjrbid(1)

		cjdtjrbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		cjdtjrbService.insertCjdtjrb(cjdtjrb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setCjdtjrbService(ICjdtjrbService cjdtjrbService) {
		this.cjdtjrbService = cjdtjrbService;
	}
}
