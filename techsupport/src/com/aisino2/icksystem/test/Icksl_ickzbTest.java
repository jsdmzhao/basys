package com.aisino2.icksystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Icksl_ickzb;
import com.aisino2.icksystem.service.IIcksl_ickzbService;

public class Icksl_ickzbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IIcksl_ickzbService icksl_ickzbService;

	/** @param IC卡受理_IC卡组包(t_icksl_ickzb) */

	public void test() {
		Icksl_ickzb icksl_ickzb = new Icksl_ickzb();

	/** @ IC卡受理ID(ickslid) */
	icksl_ickzb.setIckslid(0);

	/** @ 组包ID(zbid) */
	icksl_ickzb.setZbid(0);

	/** @ 批次中的排版号(pczdpbh) */
	icksl_ickzb.setPczdpbh(0);

	/** @ 组包后所处的页码(zbhsuym) */
	icksl_ickzb.setZbhsuym(0);

		/*
		//插入对象
		icksl_ickzbService.insertIcksl_ickzb(icksl_ickzb);

		//读取对象比较
		BaseObject bo = icksl_ickzbService.getIcksl_ickzb(icksl_ickzb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Icksl_ickzb icksl_ickzbNew = (Icksl_ickzb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(icksl_ickzbNew.getIckslid(), icksl_ickzb.getIckslid());
		assertEquals(icksl_ickzbNew.getZbid(), icksl_ickzb.getZbid());
		assertEquals(icksl_ickzbNew.getPczdpbh(), icksl_ickzb.getPczdpbh());
		assertEquals(icksl_ickzbNew.getZbhsuym(), icksl_ickzb.getZbhsuym());

		//删除对象
		// @ IC卡受理ID(ickslid) 
		icksl_ickzb.setIckslid(1)
		// @ 组包ID(zbid) 
		icksl_ickzb.setZbid(1)

		icksl_ickzbService.deleteIcksl_ickzb(icksl_ickzb);

		//修改对象
		// @ IC卡受理ID(ickslid) 
		icksl_ickzb.setIckslid(1)
		// @ 组包ID(zbid) 
		icksl_ickzb.setZbid(1)

		icksl_ickzbService.updateIcksl_ickzb(icksl_ickzb);

		//查询单条
		// @ IC卡受理ID(ickslid) 
		icksl_ickzb.setIckslid(1)
		// @ 组包ID(zbid) 
		icksl_ickzb.setZbid(1)

		icksl_ickzbService.getIcksl_ickzb(icksl_ickzb);

		//查询多条
		// @ IC卡受理ID(ickslid) 
		icksl_ickzb.setIckslid(1)
		// @ 组包ID(zbid) 
		icksl_ickzb.setZbid(1)

		icksl_ickzbService.getListIcksl_ickzb(icksl_ickzb);

		//翻页查询
		// @ IC卡受理ID(ickslid) 
		icksl_ickzb.setIckslid(1)
		// @ 组包ID(zbid) 
		icksl_ickzb.setZbid(1)

		icksl_ickzbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		icksl_ickzbService.insertIcksl_ickzb(icksl_ickzb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setIcksl_ickzbService(IIcksl_ickzbService icksl_ickzbService) {
		this.icksl_ickzbService = icksl_ickzbService;
	}
}
