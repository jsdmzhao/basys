package com.aisino2.icksystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Ickzb;
import com.aisino2.icksystem.service.IIckzbService;

public class IckzbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IIckzbService ickzbService;

	/** @param IC卡组包(t_ickzb) */

	public void test() {
		Ickzb ickzb = new Ickzb();

	/** @ 组包ID(zbid) */
	ickzb.setZbid(0);

	/** @ 批次号(pch) */
	ickzb.setPch("test");

	/** @ 组包数量(zbsl) */
	ickzb.setZbsl(0);

	/** @ 组包人(zbr) */
	ickzb.setZbr("test");

	/** @ 组包时间(zbsj) */
	ickzb.setZbsj(new Date());

	/** @ 包中所含的受理点数(slds) */
	ickzb.setSlds(0);

		/*
		//插入对象
		ickzbService.insertIckzb(ickzb);

		//读取对象比较
		BaseObject bo = ickzbService.getIckzb(ickzb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Ickzb ickzbNew = (Ickzb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(ickzbNew.getZbid(), ickzb.getZbid());
		assertEquals(ickzbNew.getPch(), ickzb.getPch());
		assertEquals(ickzbNew.getZbsl(), ickzb.getZbsl());
		assertEquals(ickzbNew.getZbr(), ickzb.getZbr());
		assertEquals(ickzbNew.getZbsj(), ickzb.getZbsj());
		assertEquals(ickzbNew.getSlds(), ickzb.getSlds());

		//删除对象
		// @ 组包ID(zbid) 
		ickzb.setZbid(1)

		ickzbService.deleteIckzb(ickzb);

		//修改对象
		// @ 组包ID(zbid) 
		ickzb.setZbid(1)

		ickzbService.updateIckzb(ickzb);

		//查询单条
		// @ 组包ID(zbid) 
		ickzb.setZbid(1)

		ickzbService.getIckzb(ickzb);

		//查询多条
		// @ 组包ID(zbid) 
		ickzb.setZbid(1)

		ickzbService.getListIckzb(ickzb);

		//翻页查询
		// @ 组包ID(zbid) 
		ickzb.setZbid(1)

		ickzbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		try {
			ickzbService.insertIckzb(ickzb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setIckzbService(IIckzbService ickzbService) {
		this.ickzbService = ickzbService;
	}
}
