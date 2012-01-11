package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Bafwht;
import com.aisino2.publicsystem.service.IBafwhtService;

public class BafwhtTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBafwhtService bafwhtService;

	/** @param 保安服务合同(t_bafwht) */

	public void test() {
		Bafwht bafwht = new Bafwht();

	/** @ 保安服务合同ID(bafwhtid) */
	bafwht.setBafwhtid(0);

	/** @ 企业ID(qyid) */
	bafwht.setQyid(0);

	/** @ 保安服务公司名称(bafwgsmc) */
	bafwht.setBafwgsmc("test");

	/** @ 保安人员资格证书名称(baryzgzsmc) */
	bafwht.setBaryzgzsmc("test");

	/** @ 保安人员培训结束日期(barypxjsrq) */
	bafwht.setBarypxjsrq(new Date());

	/** @ 合同编号(htbh) */
	bafwht.setHtbh("test");

	/** @ 签订日期(qdrq) */
	bafwht.setQdrq(new Date());

	/** @ 结束日期(jsrq) */
	bafwht.setJsrq(new Date());

	/** @ 保安人员培训内容(barypxnr) */
	bafwht.setBarypxnr("test");

		/*
		//插入对象
		bafwhtService.insertBafwht(bafwht);

		//读取对象比较
		BaseObject bo = bafwhtService.getBafwht(bafwht);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bafwht bafwhtNew = (Bafwht)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bafwhtNew.getBafwhtid(), bafwht.getBafwhtid());
		assertEquals(bafwhtNew.getQyid(), bafwht.getQyid());
		assertEquals(bafwhtNew.getBafwgsmc(), bafwht.getBafwgsmc());
		assertEquals(bafwhtNew.getBaryzgzsmc(), bafwht.getBaryzgzsmc());
		assertEquals(bafwhtNew.getBarypxjsrq(), bafwht.getBarypxjsrq());
		assertEquals(bafwhtNew.getHtbh(), bafwht.getHtbh());
		assertEquals(bafwhtNew.getQdrq(), bafwht.getQdrq());
		assertEquals(bafwhtNew.getJsrq(), bafwht.getJsrq());
		assertEquals(bafwhtNew.getBarypxnr(), bafwht.getBarypxnr());

		//删除对象
		// @ 保安服务合同ID(bafwhtid) 
		bafwht.setBafwhtid(1)
		// @ 企业ID(qyid) 
		bafwht.setQyid(1)

		bafwhtService.deleteBafwht(bafwht);

		//修改对象
		// @ 保安服务合同ID(bafwhtid) 
		bafwht.setBafwhtid(1)
		// @ 企业ID(qyid) 
		bafwht.setQyid(1)

		bafwhtService.updateBafwht(bafwht);

		//查询单条
		// @ 保安服务合同ID(bafwhtid) 
		bafwht.setBafwhtid(1)
		// @ 企业ID(qyid) 
		bafwht.setQyid(1)

		bafwhtService.getBafwht(bafwht);

		//查询多条
		// @ 保安服务合同ID(bafwhtid) 
		bafwht.setBafwhtid(1)
		// @ 企业ID(qyid) 
		bafwht.setQyid(1)

		bafwhtService.getListBafwht(bafwht);

		//翻页查询
		// @ 保安服务合同ID(bafwhtid) 
		bafwht.setBafwhtid(1)
		// @ 企业ID(qyid) 
		bafwht.setQyid(1)

		bafwhtService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bafwhtService.insertBafwht(bafwht);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBafwhtService(IBafwhtService bafwhtService) {
		this.bafwhtService = bafwhtService;
	}
}
