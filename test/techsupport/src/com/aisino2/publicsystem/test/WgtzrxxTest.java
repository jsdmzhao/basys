package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Wgtzrxx;
import com.aisino2.publicsystem.service.IWgtzrxxService;

public class WgtzrxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IWgtzrxxService wgtzrxxService;

	/** @param 外国投资人信息(t_wgtzrxx) */

	public void test() {
		Wgtzrxx wgtzrxx = new Wgtzrxx();

	/** @ 外国投资人信息ID(wgtzrxxid) */
	wgtzrxx.setWgtzrxxid(0);

	/** @ 企业ID(qyid) */
	wgtzrxx.setQyid(0);

	/** @ 投资者姓名(tzzxm) */
	wgtzrxx.setTzzxm("test");

	/** @ 联系电话(lxdh) */
	wgtzrxx.setLxdh("test");

	/** @ 国籍代码(gjdm) */
	wgtzrxx.setGjdm("test");

	/** @ 国籍(gj) */
	wgtzrxx.setGj("test");

	/** @ 签证种类代码(qzzldm) */
	wgtzrxx.setQzzldm("test");

	/** @ 签证种类名称(qzzlmc) */
	wgtzrxx.setQzzlmc("test");

	/** @ 签证号码(qzhm) */
	wgtzrxx.setQzhm("test");

	/** @ 护照种类代码(hzzldm) */
	wgtzrxx.setHzzldm("test");

	/** @ 护照种类名称(hzzlmc) */
	wgtzrxx.setHzzlmc("test");

	/** @ 护照号码(hzhm) */
	wgtzrxx.setHzhm("test");

		/*
		//插入对象
		wgtzrxxService.insertWgtzrxx(wgtzrxx);

		//读取对象比较
		BaseObject bo = wgtzrxxService.getWgtzrxx(wgtzrxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Wgtzrxx wgtzrxxNew = (Wgtzrxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(wgtzrxxNew.getWgtzrxxid(), wgtzrxx.getWgtzrxxid());
		assertEquals(wgtzrxxNew.getQyid(), wgtzrxx.getQyid());
		assertEquals(wgtzrxxNew.getTzzxm(), wgtzrxx.getTzzxm());
		assertEquals(wgtzrxxNew.getLxdh(), wgtzrxx.getLxdh());
		assertEquals(wgtzrxxNew.getGjdm(), wgtzrxx.getGjdm());
		assertEquals(wgtzrxxNew.getGj(), wgtzrxx.getGj());
		assertEquals(wgtzrxxNew.getQzzldm(), wgtzrxx.getQzzldm());
		assertEquals(wgtzrxxNew.getQzzlmc(), wgtzrxx.getQzzlmc());
		assertEquals(wgtzrxxNew.getQzhm(), wgtzrxx.getQzhm());
		assertEquals(wgtzrxxNew.getHzzldm(), wgtzrxx.getHzzldm());
		assertEquals(wgtzrxxNew.getHzzlmc(), wgtzrxx.getHzzlmc());
		assertEquals(wgtzrxxNew.getHzhm(), wgtzrxx.getHzhm());

		//删除对象
		// @ 外国投资人信息ID(wgtzrxxid) 
		wgtzrxx.setWgtzrxxid(1)
		// @ 企业ID(qyid) 
		wgtzrxx.setQyid(1)

		wgtzrxxService.deleteWgtzrxx(wgtzrxx);

		//修改对象
		// @ 外国投资人信息ID(wgtzrxxid) 
		wgtzrxx.setWgtzrxxid(1)
		// @ 企业ID(qyid) 
		wgtzrxx.setQyid(1)

		wgtzrxxService.updateWgtzrxx(wgtzrxx);

		//查询单条
		// @ 外国投资人信息ID(wgtzrxxid) 
		wgtzrxx.setWgtzrxxid(1)
		// @ 企业ID(qyid) 
		wgtzrxx.setQyid(1)

		wgtzrxxService.getWgtzrxx(wgtzrxx);

		//查询多条
		// @ 外国投资人信息ID(wgtzrxxid) 
		wgtzrxx.setWgtzrxxid(1)
		// @ 企业ID(qyid) 
		wgtzrxx.setQyid(1)

		wgtzrxxService.getListWgtzrxx(wgtzrxx);

		//翻页查询
		// @ 外国投资人信息ID(wgtzrxxid) 
		wgtzrxx.setWgtzrxxid(1)
		// @ 企业ID(qyid) 
		wgtzrxx.setQyid(1)

		wgtzrxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		wgtzrxxService.insertWgtzrxx(wgtzrxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setWgtzrxxService(IWgtzrxxService wgtzrxxService) {
		this.wgtzrxxService = wgtzrxxService;
	}
}
