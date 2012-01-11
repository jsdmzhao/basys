package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Zktjjb;
import com.aisino2.icksystem.service.IZktjjbService;

public class ZktjjbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IZktjjbService zktjjbService;

	/** @param 制卡统计季报(t_zktjjb) */

	public void test() {
		Zktjjb zktjjb = new Zktjjb();

	/** @ 制卡统计季报ID(zktjjbid) */
	zktjjb.setZktjjbid(0);

	/** @ 采集端统计日期(cjdtjrq) */
	zktjjb.setCjdtjrq(new Date());

	/** @ 采集点编码(cjdbm) */
	zktjjb.setCjdbm("test");

	/** @ 采集点名称(cjdmc) */
	zktjjb.setCjdmc("test");

	/** @ 制卡中心编码(zkzxbm) */
	zktjjb.setZkzxbm("test");

	/** @ 制卡中心名称(zkzxmc) */
	zktjjb.setZkzxmc("test");

	/** @ 制卡数(zks) */
	zktjjb.setZks(0);

	/** @ 印刷数(yss) */
	zktjjb.setYss(0);

	/** @ 重印数(cys) */
	zktjjb.setCys(0);

	/** @ 打印错误数(dycws) */
	zktjjb.setDycws(0);

	/** @ 塑封错误数(sfcws) */
	zktjjb.setSfcws(0);

	/** @ 冲卡错误数(ckcws) */
	zktjjb.setCkcws(0);

	/** @ 卡片损坏数(kpshs) */
	zktjjb.setKpshs(0);

	/** @ 未能接收数(wnjss) */
	zktjjb.setWnjss(0);

	/** @ 其他(qt) */
	zktjjb.setQt(0);

	/** @ 电写入错误数(dxrcws) */
	zktjjb.setDxrcws(0);

	/** @ 平均制卡量(pjzkl) */
	zktjjb.setPjzkl(0);

	/** @ 平均废卡量(pjfkl) */
	zktjjb.setPjfkl(0);

	/** @ 废卡率(fkl) */
	zktjjb.setFkl(new Float(9.9));

		/*
		//插入对象
		zktjjbService.insertZktjjb(zktjjb);

		//读取对象比较
		BaseObject bo = zktjjbService.getZktjjb(zktjjb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Zktjjb zktjjbNew = (Zktjjb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(zktjjbNew.getZktjjbid(), zktjjb.getZktjjbid());
		assertEquals(zktjjbNew.getCjdtjrq(), zktjjb.getCjdtjrq());
		assertEquals(zktjjbNew.getCjdbm(), zktjjb.getCjdbm());
		assertEquals(zktjjbNew.getCjdmc(), zktjjb.getCjdmc());
		assertEquals(zktjjbNew.getZkzxbm(), zktjjb.getZkzxbm());
		assertEquals(zktjjbNew.getZkzxmc(), zktjjb.getZkzxmc());
		assertEquals(zktjjbNew.getZks(), zktjjb.getZks());
		assertEquals(zktjjbNew.getYss(), zktjjb.getYss());
		assertEquals(zktjjbNew.getCys(), zktjjb.getCys());
		assertEquals(zktjjbNew.getDycws(), zktjjb.getDycws());
		assertEquals(zktjjbNew.getSfcws(), zktjjb.getSfcws());
		assertEquals(zktjjbNew.getCkcws(), zktjjb.getCkcws());
		assertEquals(zktjjbNew.getKpshs(), zktjjb.getKpshs());
		assertEquals(zktjjbNew.getWnjss(), zktjjb.getWnjss());
		assertEquals(zktjjbNew.getQt(), zktjjb.getQt());
		assertEquals(zktjjbNew.getDxrcws(), zktjjb.getDxrcws());
		assertEquals(zktjjbNew.getPjzkl(), zktjjb.getPjzkl());
		assertEquals(zktjjbNew.getPjfkl(), zktjjb.getPjfkl());
		assertEquals(zktjjbNew.getFkl(), zktjjb.getFkl());

		//删除对象
		// @ 制卡统计季报ID(zktjjbid) 
		zktjjb.setZktjjbid(1)

		zktjjbService.deleteZktjjb(zktjjb);

		//修改对象
		// @ 制卡统计季报ID(zktjjbid) 
		zktjjb.setZktjjbid(1)

		zktjjbService.updateZktjjb(zktjjb);

		//查询单条
		// @ 制卡统计季报ID(zktjjbid) 
		zktjjb.setZktjjbid(1)

		zktjjbService.getZktjjb(zktjjb);

		//查询多条
		// @ 制卡统计季报ID(zktjjbid) 
		zktjjb.setZktjjbid(1)

		zktjjbService.getListZktjjb(zktjjb);

		//翻页查询
		// @ 制卡统计季报ID(zktjjbid) 
		zktjjb.setZktjjbid(1)

		zktjjbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		zktjjbService.insertZktjjb(zktjjb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setZktjjbService(IZktjjbService zktjjbService) {
		this.zktjjbService = zktjjbService;
	}
}
