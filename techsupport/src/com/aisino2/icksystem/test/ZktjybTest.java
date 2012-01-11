package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Zktjyb;
import com.aisino2.icksystem.service.IZktjybService;

public class ZktjybTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IZktjybService zktjybService;

	/** @param 制卡统计月报(t_zktjyb) */

	public void test() {
		Zktjyb zktjyb = new Zktjyb();

	/** @ 制卡统计月报ID(zktjybid) */
	zktjyb.setZktjybid(0);

	/** @ 采集端统计日期(cjdtjrq) */
	zktjyb.setCjdtjrq(new Date());

	/** @ 采集点编码(cjdbm) */
	zktjyb.setCjdbm("test");

	/** @ 采集点名称(cjdmc) */
	zktjyb.setCjdmc("test");

	/** @ 制卡中心编码(zkzxbm) */
	zktjyb.setZkzxbm("test");

	/** @ 制卡中心名称(zkzxmc) */
	zktjyb.setZkzxmc("test");

	/** @ 制卡数(zks) */
	zktjyb.setZks(0);

	/** @ 印刷数(yss) */
	zktjyb.setYss(0);

	/** @ 重印数(cys) */
	zktjyb.setCys(0);

	/** @ 打印错误数(dycws) */
	zktjyb.setDycws(0);

	/** @ 塑封错误数(sfcws) */
	zktjyb.setSfcws(0);

	/** @ 冲卡错误数(ckcws) */
	zktjyb.setCkcws(0);

	/** @ 卡片损坏数(kpshs) */
	zktjyb.setKpshs(0);

	/** @ 未能接收数(wnjss) */
	zktjyb.setWnjss(0);

	/** @ 其他(qt) */
	zktjyb.setQt(0);

	/** @ 电写入错误数(dxrcws) */
	zktjyb.setDxrcws(0);

	/** @ 平均制卡量(pjzkl) */
	zktjyb.setPjzkl(0);

	/** @ 平均废卡量(pjfkl) */
	zktjyb.setPjfkl(0);

	/** @ 废卡率(fkl) */
	zktjyb.setFkl(new Float(9.9));

		/*
		//插入对象
		zktjybService.insertZktjyb(zktjyb);

		//读取对象比较
		BaseObject bo = zktjybService.getZktjyb(zktjyb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Zktjyb zktjybNew = (Zktjyb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(zktjybNew.getZktjybid(), zktjyb.getZktjybid());
		assertEquals(zktjybNew.getCjdtjrq(), zktjyb.getCjdtjrq());
		assertEquals(zktjybNew.getCjdbm(), zktjyb.getCjdbm());
		assertEquals(zktjybNew.getCjdmc(), zktjyb.getCjdmc());
		assertEquals(zktjybNew.getZkzxbm(), zktjyb.getZkzxbm());
		assertEquals(zktjybNew.getZkzxmc(), zktjyb.getZkzxmc());
		assertEquals(zktjybNew.getZks(), zktjyb.getZks());
		assertEquals(zktjybNew.getYss(), zktjyb.getYss());
		assertEquals(zktjybNew.getCys(), zktjyb.getCys());
		assertEquals(zktjybNew.getDycws(), zktjyb.getDycws());
		assertEquals(zktjybNew.getSfcws(), zktjyb.getSfcws());
		assertEquals(zktjybNew.getCkcws(), zktjyb.getCkcws());
		assertEquals(zktjybNew.getKpshs(), zktjyb.getKpshs());
		assertEquals(zktjybNew.getWnjss(), zktjyb.getWnjss());
		assertEquals(zktjybNew.getQt(), zktjyb.getQt());
		assertEquals(zktjybNew.getDxrcws(), zktjyb.getDxrcws());
		assertEquals(zktjybNew.getPjzkl(), zktjyb.getPjzkl());
		assertEquals(zktjybNew.getPjfkl(), zktjyb.getPjfkl());
		assertEquals(zktjybNew.getFkl(), zktjyb.getFkl());

		//删除对象
		// @ 制卡统计月报ID(zktjybid) 
		zktjyb.setZktjybid(1)

		zktjybService.deleteZktjyb(zktjyb);

		//修改对象
		// @ 制卡统计月报ID(zktjybid) 
		zktjyb.setZktjybid(1)

		zktjybService.updateZktjyb(zktjyb);

		//查询单条
		// @ 制卡统计月报ID(zktjybid) 
		zktjyb.setZktjybid(1)

		zktjybService.getZktjyb(zktjyb);

		//查询多条
		// @ 制卡统计月报ID(zktjybid) 
		zktjyb.setZktjybid(1)

		zktjybService.getListZktjyb(zktjyb);

		//翻页查询
		// @ 制卡统计月报ID(zktjybid) 
		zktjyb.setZktjybid(1)

		zktjybService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		zktjybService.insertZktjyb(zktjyb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setZktjybService(IZktjybService zktjybService) {
		this.zktjybService = zktjybService;
	}
}
