package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Sjb;
import com.aisino2.basicsystem.service.ISjbService;
import com.aisino2.core.test.BaseTestCase;

public class SjbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private ISjbService sjbService;

	/** @param 数据表(t_sjb) */

	public void test() {
		Sjb sjb = new Sjb();

	/** @ 数据表ID(sjbid) */
	sjb.setSjbid(0);

	/** @ 数据表名(sjbm) */
	sjb.setSjbm("test");

	/** @ 数据表中文名(sjbzwm) */
	sjb.setSjbzwm("test");

	/** @ 对应类对象(dyldx) */
	sjb.setDyldx("test");

	/** @ 是否记录操作日志(sfjlczrz) */
	sjb.setSfjlczrz(0);

	/** @ 是否系统字典(sfxtzd) */
	sjb.setSfxtzd(0);

	/** @ 所属数据库用户(sssjkyh) */
	sjb.setSssjkyh("test");

	/** @ 主键(zj) */
	sjb.setZj("test");

		/*
		//插入对象
		sjbService.insertSjb(sjb);

		//读取对象比较
		BaseObject bo = sjbService.getSjb(sjb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Sjb sjbNew = (Sjb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(sjbNew.getSjbid(), sjb.getSjbid());
		assertEquals(sjbNew.getSjbm(), sjb.getSjbm());
		assertEquals(sjbNew.getSjbzwm(), sjb.getSjbzwm());
		assertEquals(sjbNew.getDyldx(), sjb.getDyldx());
		assertEquals(sjbNew.getSfjlczrz(), sjb.getSfjlczrz());
		assertEquals(sjbNew.getSfxtzd(), sjb.getSfxtzd());
		assertEquals(sjbNew.getSssjkyh(), sjb.getSssjkyh());
		assertEquals(sjbNew.getZj(), sjb.getZj());

		//删除对象
		// @ 数据表ID(sjbid) 
		sjb.setSjbid(1)

		sjbService.deleteSjb(sjb);

		//修改对象
		// @ 数据表ID(sjbid) 
		sjb.setSjbid(1)

		sjbService.updateSjb(sjb);

		//查询单条
		// @ 数据表ID(sjbid) 
		sjb.setSjbid(1)

		sjbService.getSjb(sjb);

		//查询多条
		// @ 数据表ID(sjbid) 
		sjb.setSjbid(1)

		sjbService.getListSjb(sjb);

		//翻页查询
		// @ 数据表ID(sjbid) 
		sjb.setSjbid(1)

		sjbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		sjbService.insertSjb(sjb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setSjbService(ISjbService sjbService) {
		this.sjbService = sjbService;
	}
}
