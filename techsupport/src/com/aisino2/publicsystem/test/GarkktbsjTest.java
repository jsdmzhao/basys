package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Garkktbsj;
import com.aisino2.publicsystem.service.IGarkktbsjService;

public class GarkktbsjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IGarkktbsjService garkktbsjService;

	/** @param 公安人口库同步数据(t_garkktbsj) */

	public void test() {
		Garkktbsj garkktbsj = new Garkktbsj();

	/** @ 公安人口库同步数据ID(garkktbsjid) */
	garkktbsj.setGarkktbsjid(0);

	/** @ 公民身份证号码(gmsfzhm) */
	garkktbsj.setGmsfzhm("test");

	/** @ 姓名(xm) */
	garkktbsj.setXm("test");

	/** @ 性别(xb) */
	garkktbsj.setXb("test");

	/** @ 民族(mz) */
	garkktbsj.setMz("test");

	/** @ 婚姻状况(hyzk) */
	garkktbsj.setHyzk("test");

	/** @ 户籍省县(hjsx) */
	garkktbsj.setHjsx("test");

	/** @ 户籍地详址(hjdxz) */
	garkktbsj.setHjdxz("test");

	/** @ 出生日期(csrq) */
	garkktbsj.setCsrq(new Date());

	/** @ 照片(zp) */
	garkktbsj.setZp(null);

		/*
		//插入对象
		garkktbsjService.insertGarkktbsj(garkktbsj);

		//读取对象比较
		BaseObject bo = garkktbsjService.getGarkktbsj(garkktbsj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Garkktbsj garkktbsjNew = (Garkktbsj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(garkktbsjNew.getGarkktbsjid(), garkktbsj.getGarkktbsjid());
		assertEquals(garkktbsjNew.getGmsfzhm(), garkktbsj.getGmsfzhm());
		assertEquals(garkktbsjNew.getXm(), garkktbsj.getXm());
		assertEquals(garkktbsjNew.getXb(), garkktbsj.getXb());
		assertEquals(garkktbsjNew.getMz(), garkktbsj.getMz());
		assertEquals(garkktbsjNew.getHyzk(), garkktbsj.getHyzk());
		assertEquals(garkktbsjNew.getHjsx(), garkktbsj.getHjsx());
		assertEquals(garkktbsjNew.getHjdxz(), garkktbsj.getHjdxz());
		assertEquals(garkktbsjNew.getCsrq(), garkktbsj.getCsrq());
		assertEquals(garkktbsjNew.getZp(), garkktbsj.getZp());

		//删除对象
		// @ 公安人口库同步数据ID(garkktbsjid) 
		garkktbsj.setGarkktbsjid(1)

		garkktbsjService.deleteGarkktbsj(garkktbsj);

		//修改对象
		// @ 公安人口库同步数据ID(garkktbsjid) 
		garkktbsj.setGarkktbsjid(1)

		garkktbsjService.updateGarkktbsj(garkktbsj);

		//查询单条
		// @ 公安人口库同步数据ID(garkktbsjid) 
		garkktbsj.setGarkktbsjid(1)

		garkktbsjService.getGarkktbsj(garkktbsj);

		//查询多条
		// @ 公安人口库同步数据ID(garkktbsjid) 
		garkktbsj.setGarkktbsjid(1)

		garkktbsjService.getListGarkktbsj(garkktbsj);

		//翻页查询
		// @ 公安人口库同步数据ID(garkktbsjid) 
		garkktbsj.setGarkktbsjid(1)

		garkktbsjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		garkktbsjService.insertGarkktbsj(garkktbsj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setGarkktbsjService(IGarkktbsjService garkktbsjService) {
		this.garkktbsjService = garkktbsjService;
	}
}
