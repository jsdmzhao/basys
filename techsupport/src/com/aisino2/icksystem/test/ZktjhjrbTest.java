package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Zktjhjrb;
import com.aisino2.icksystem.service.IZktjhjrbService;

public class ZktjhjrbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IZktjhjrbService zktjhjrbService;

	/** @param 制卡统计汇总日报(t_zktjhjrb) */

	public void test() {
		Zktjhjrb zktjhjrb = new Zktjhjrb();

	/** @ 制卡统计汇总日报ID(zktjhzrbid) */
	zktjhjrb.setZktjhzrbid(0);

	/** @ 采集端统计日期(cjdtjrq) */
	zktjhjrb.setCjdtjrq(new Date());

	/** @ 采集点编码(cjdbm) */
	zktjhjrb.setCjdbm("test");

	/** @ 采集点名称(cjdmc) */
	zktjhjrb.setCjdmc("test");

	/** @ 制卡中心编码(zkzxbm) */
	zktjhjrb.setZkzxbm("test");

	/** @ 制卡中心名称(zkzxmc) */
	zktjhjrb.setZkzxmc("test");

	/** @ 提交卡片总数(tjkpzs) */
	zktjhjrb.setTjkpzs(0);

	/** @ 总制卡数(zzks) */
	zktjhjrb.setZzks(0);

	/** @ 未制卡数(wzks) */
	zktjhjrb.setWzks(0);

	/** @ 已组包数(yzbs) */
	zktjhjrb.setYzbs(0);

	/** @ 已发送数(yfss) */
	zktjhjrb.setYfss(0);

	/** @ 已发卡数(yfks) */
	zktjhjrb.setYfks(0);

	/** @ 重制卡数(czks) */
	zktjhjrb.setCzks(0);

		/*
		//插入对象
		zktjhjrbService.insertZktjhjrb(zktjhjrb);

		//读取对象比较
		BaseObject bo = zktjhjrbService.getZktjhjrb(zktjhjrb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Zktjhjrb zktjhjrbNew = (Zktjhjrb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(zktjhjrbNew.getZktjhzrbid(), zktjhjrb.getZktjhzrbid());
		assertEquals(zktjhjrbNew.getCjdtjrq(), zktjhjrb.getCjdtjrq());
		assertEquals(zktjhjrbNew.getCjdbm(), zktjhjrb.getCjdbm());
		assertEquals(zktjhjrbNew.getCjdmc(), zktjhjrb.getCjdmc());
		assertEquals(zktjhjrbNew.getZkzxbm(), zktjhjrb.getZkzxbm());
		assertEquals(zktjhjrbNew.getZkzxmc(), zktjhjrb.getZkzxmc());
		assertEquals(zktjhjrbNew.getTjkpzs(), zktjhjrb.getTjkpzs());
		assertEquals(zktjhjrbNew.getZzks(), zktjhjrb.getZzks());
		assertEquals(zktjhjrbNew.getWzks(), zktjhjrb.getWzks());
		assertEquals(zktjhjrbNew.getYzbs(), zktjhjrb.getYzbs());
		assertEquals(zktjhjrbNew.getYfss(), zktjhjrb.getYfss());
		assertEquals(zktjhjrbNew.getYfks(), zktjhjrb.getYfks());
		assertEquals(zktjhjrbNew.getCzks(), zktjhjrb.getCzks());

		//删除对象
		// @ 制卡统计汇总日报ID(zktjhzrbid) 
		zktjhjrb.setZktjhzrbid(1)

		zktjhjrbService.deleteZktjhjrb(zktjhjrb);

		//修改对象
		// @ 制卡统计汇总日报ID(zktjhzrbid) 
		zktjhjrb.setZktjhzrbid(1)

		zktjhjrbService.updateZktjhjrb(zktjhjrb);

		//查询单条
		// @ 制卡统计汇总日报ID(zktjhzrbid) 
		zktjhjrb.setZktjhzrbid(1)

		zktjhjrbService.getZktjhjrb(zktjhjrb);

		//查询多条
		// @ 制卡统计汇总日报ID(zktjhzrbid) 
		zktjhjrb.setZktjhzrbid(1)

		zktjhjrbService.getListZktjhjrb(zktjhjrb);

		//翻页查询
		// @ 制卡统计汇总日报ID(zktjhzrbid) 
		zktjhjrb.setZktjhzrbid(1)

		zktjhjrbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		zktjhjrbService.insertZktjhjrb(zktjhjrb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setZktjhjrbService(IZktjhjrbService zktjhjrbService) {
		this.zktjhjrbService = zktjhjrbService;
	}
}
