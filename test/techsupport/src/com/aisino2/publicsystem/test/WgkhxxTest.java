package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Wgkhxx;
import com.aisino2.publicsystem.service.IWgkhxxService;

public class WgkhxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IWgkhxxService wgkhxxService;

	/** @param 外国客户信息(t_wgkhxx) */

	public void test() {
		Wgkhxx wgkhxx = new Wgkhxx();

	/** @ 客户信息ID(khxxid) */
	wgkhxx.setKhxxid(0);

	/** @ 英文姓(ywx) */
	wgkhxx.setYwx("test");

	/** @ 英文名(ywm) */
	wgkhxx.setYwm("test");

	/** @ 签证种类代码(qzzldm) */
	wgkhxx.setQzzldm("test");

	/** @ 签证种类(qzzl) */
	wgkhxx.setQzzl("test");

	/** @ 签证号码(qzhm) */
	wgkhxx.setQzhm("test");

	/** @ 在华停留期至(zatlq) */
	wgkhxx.setZatlq(new Date());

	/** @ 签发机关(qfjg) */
	wgkhxx.setQfjg("test");

	/** @ 入境日期(rjrq) */
	wgkhxx.setRjrq(new Date());

	/** @ 入境口岸(rjka) */
	wgkhxx.setRjka("test");

		/*
		//插入对象
		wgkhxxService.insertWgkhxx(wgkhxx);

		//读取对象比较
		BaseObject bo = wgkhxxService.getWgkhxx(wgkhxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Wgkhxx wgkhxxNew = (Wgkhxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(wgkhxxNew.getKhxxid(), wgkhxx.getKhxxid());
		assertEquals(wgkhxxNew.getYwx(), wgkhxx.getYwx());
		assertEquals(wgkhxxNew.getYwm(), wgkhxx.getYwm());
		assertEquals(wgkhxxNew.getQzzldm(), wgkhxx.getQzzldm());
		assertEquals(wgkhxxNew.getQzzl(), wgkhxx.getQzzl());
		assertEquals(wgkhxxNew.getQzhm(), wgkhxx.getQzhm());
		assertEquals(wgkhxxNew.getZatlq(), wgkhxx.getZatlq());
		assertEquals(wgkhxxNew.getQfjg(), wgkhxx.getQfjg());
		assertEquals(wgkhxxNew.getRjrq(), wgkhxx.getRjrq());
		assertEquals(wgkhxxNew.getRjka(), wgkhxx.getRjka());

		//删除对象
		// @ 客户信息ID(khxxid) 
		wgkhxx.setKhxxid(1)

		wgkhxxService.deleteWgkhxx(wgkhxx);

		//修改对象
		// @ 客户信息ID(khxxid) 
		wgkhxx.setKhxxid(1)

		wgkhxxService.updateWgkhxx(wgkhxx);

		//查询单条
		// @ 客户信息ID(khxxid) 
		wgkhxx.setKhxxid(1)

		wgkhxxService.getWgkhxx(wgkhxx);

		//查询多条
		// @ 客户信息ID(khxxid) 
		wgkhxx.setKhxxid(1)

		wgkhxxService.getListWgkhxx(wgkhxx);

		//翻页查询
		// @ 客户信息ID(khxxid) 
		wgkhxx.setKhxxid(1)

		wgkhxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		wgkhxxService.insertWgkhxx(wgkhxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setWgkhxxService(IWgkhxxService wgkhxxService) {
		this.wgkhxxService = wgkhxxService;
	}
}
