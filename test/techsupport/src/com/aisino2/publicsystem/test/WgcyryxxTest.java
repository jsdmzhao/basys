package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Wgcyryxx;
import com.aisino2.publicsystem.service.IWgcyryxxService;

public class WgcyryxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IWgcyryxxService wgcyryxxService;

	/** @param 外国从业人员信息(t_wgcyryxx) */

	public void test() {
		Wgcyryxx wgcyryxx = new Wgcyryxx();

	/** @ 企业ID(qyid) */
	wgcyryxx.setQyid(0);

	/** @ 从业人员ID(ryid) */
	wgcyryxx.setRyid(0);

	/** @ 英文姓(ywx) */
	wgcyryxx.setYwx("test");

	/** @ 英文名(ywm) */
	wgcyryxx.setYwm("test");

	/** @ 外国人就业许可证号(wgrjyxkz) */
	wgcyryxx.setWgrjyxkz("test");

	/** @ 签证种类代码(qzzldm) */
	wgcyryxx.setQzzldm("test");

	/** @ 签证号码(qzhm) */
	wgcyryxx.setQzhm("test");

	/** @ 在华停留期至(zatlq) */
	wgcyryxx.setZatlq(new Date());

	/** @ 签发机关(qfjg) */
	wgcyryxx.setQfjg("test");

	/** @ 入境日期(rjrq) */
	wgcyryxx.setRjrq(new Date());

	/** @ 入境口岸(rjka) */
	wgcyryxx.setRjka("test");

		/*
		//插入对象
		wgcyryxxService.insertWgcyryxx(wgcyryxx);

		//读取对象比较
		BaseObject bo = wgcyryxxService.getWgcyryxx(wgcyryxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Wgcyryxx wgcyryxxNew = (Wgcyryxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(wgcyryxxNew.getQyid(), wgcyryxx.getQyid());
		assertEquals(wgcyryxxNew.getRyid(), wgcyryxx.getRyid());
		assertEquals(wgcyryxxNew.getYwx(), wgcyryxx.getYwx());
		assertEquals(wgcyryxxNew.getYwm(), wgcyryxx.getYwm());
		assertEquals(wgcyryxxNew.getWgrjyxkz(), wgcyryxx.getWgrjyxkz());
		assertEquals(wgcyryxxNew.getQzzldm(), wgcyryxx.getQzzldm());
		assertEquals(wgcyryxxNew.getQzhm(), wgcyryxx.getQzhm());
		assertEquals(wgcyryxxNew.getZatlq(), wgcyryxx.getZatlq());
		assertEquals(wgcyryxxNew.getQfjg(), wgcyryxx.getQfjg());
		assertEquals(wgcyryxxNew.getRjrq(), wgcyryxx.getRjrq());
		assertEquals(wgcyryxxNew.getRjka(), wgcyryxx.getRjka());

		//删除对象
		// @ 企业ID(qyid) 
		wgcyryxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		wgcyryxx.setRyid(1)

		wgcyryxxService.deleteWgcyryxx(wgcyryxx);

		//修改对象
		// @ 企业ID(qyid) 
		wgcyryxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		wgcyryxx.setRyid(1)

		wgcyryxxService.updateWgcyryxx(wgcyryxx);

		//查询单条
		// @ 企业ID(qyid) 
		wgcyryxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		wgcyryxx.setRyid(1)

		wgcyryxxService.getWgcyryxx(wgcyryxx);

		//查询多条
		// @ 企业ID(qyid) 
		wgcyryxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		wgcyryxx.setRyid(1)

		wgcyryxxService.getListWgcyryxx(wgcyryxx);

		//翻页查询
		// @ 企业ID(qyid) 
		wgcyryxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		wgcyryxx.setRyid(1)

		wgcyryxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		wgcyryxxService.insertWgcyryxx(wgcyryxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setWgcyryxxService(IWgcyryxxService wgcyryxxService) {
		this.wgcyryxxService = wgcyryxxService;
	}
}
