package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Zktjrb;
import com.aisino2.icksystem.service.IZktjrbService;

public class ZktjrbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IZktjrbService zktjrbService;

	/** @param 制卡统计日报(t_zktjrb) */

	public void test() {
		Zktjrb zktjrb = new Zktjrb();

	/** @ 制卡统计日报ID(zktjrbid) */
	zktjrb.setZktjrbid(0);

	/** @ 采集端统计日期(cjdtjrq) */
	zktjrb.setCjdtjrq(new Date());

	/** @ 采集点编码(cjdbm) */
	zktjrb.setCjdbm("test");

	/** @ 采集点名称(cjdmc) */
	zktjrb.setCjdmc("test");

	/** @ 制卡中心编码(zkzxbm) */
	zktjrb.setZkzxbm("test");

	/** @ 制卡中心名称(zkzxmc) */
	zktjrb.setZkzxmc("test");

	/** @ 制卡数(zks) */
	zktjrb.setZks(0);

	/** @ 印刷数(yss) */
	zktjrb.setYss(0);

	/** @ 重印数(cys) */
	zktjrb.setCys(0);

	/** @ 打印错误数(dycws) */
	zktjrb.setDycws(0);

	/** @ 塑封错误数(sfcws) */
	zktjrb.setSfcws(0);

	/** @ 冲卡错误数(ckcws) */
	zktjrb.setCkcws(0);

	/** @ 卡片损坏数(kpshs) */
	zktjrb.setKpshs(0);

	/** @ 未能接收数(wnjss) */
	zktjrb.setWnjss(0);

	/** @ 其他(qt) */
	zktjrb.setQt(0);

	/** @ 电写入错误数(dxrcws) */
	zktjrb.setDxrcws(0);

	/** @ 平均制卡量(pjzkl) */
	zktjrb.setPjzkl(0);

	/** @ 平均废卡量(pjfkl) */
	zktjrb.setPjfkl(0);

	/** @ 废卡率(fkl) */
	zktjrb.setFkl(new Float(9.9));

		/*
		//插入对象
		zktjrbService.insertZktjrb(zktjrb);

		//读取对象比较
		BaseObject bo = zktjrbService.getZktjrb(zktjrb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Zktjrb zktjrbNew = (Zktjrb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(zktjrbNew.getZktjrbid(), zktjrb.getZktjrbid());
		assertEquals(zktjrbNew.getCjdtjrq(), zktjrb.getCjdtjrq());
		assertEquals(zktjrbNew.getCjdbm(), zktjrb.getCjdbm());
		assertEquals(zktjrbNew.getCjdmc(), zktjrb.getCjdmc());
		assertEquals(zktjrbNew.getZkzxbm(), zktjrb.getZkzxbm());
		assertEquals(zktjrbNew.getZkzxmc(), zktjrb.getZkzxmc());
		assertEquals(zktjrbNew.getZks(), zktjrb.getZks());
		assertEquals(zktjrbNew.getYss(), zktjrb.getYss());
		assertEquals(zktjrbNew.getCys(), zktjrb.getCys());
		assertEquals(zktjrbNew.getDycws(), zktjrb.getDycws());
		assertEquals(zktjrbNew.getSfcws(), zktjrb.getSfcws());
		assertEquals(zktjrbNew.getCkcws(), zktjrb.getCkcws());
		assertEquals(zktjrbNew.getKpshs(), zktjrb.getKpshs());
		assertEquals(zktjrbNew.getWnjss(), zktjrb.getWnjss());
		assertEquals(zktjrbNew.getQt(), zktjrb.getQt());
		assertEquals(zktjrbNew.getDxrcws(), zktjrb.getDxrcws());
		assertEquals(zktjrbNew.getPjzkl(), zktjrb.getPjzkl());
		assertEquals(zktjrbNew.getPjfkl(), zktjrb.getPjfkl());
		assertEquals(zktjrbNew.getFkl(), zktjrb.getFkl());

		//删除对象
		// @ 制卡统计日报ID(zktjrbid) 
		zktjrb.setZktjrbid(1)

		zktjrbService.deleteZktjrb(zktjrb);

		//修改对象
		// @ 制卡统计日报ID(zktjrbid) 
		zktjrb.setZktjrbid(1)

		zktjrbService.updateZktjrb(zktjrb);

		//查询单条
		// @ 制卡统计日报ID(zktjrbid) 
		zktjrb.setZktjrbid(1)

		zktjrbService.getZktjrb(zktjrb);

		//查询多条
		// @ 制卡统计日报ID(zktjrbid) 
		zktjrb.setZktjrbid(1)

		zktjrbService.getListZktjrb(zktjrb);

		//翻页查询
		// @ 制卡统计日报ID(zktjrbid) 
		zktjrb.setZktjrbid(1)

		zktjrbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		zktjrbService.insertZktjrb(zktjrb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setZktjrbService(IZktjrbService zktjrbService) {
		this.zktjrbService = zktjrbService;
	}
}
