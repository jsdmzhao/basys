package com.aisino2.icksystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.icksystem.domain.Icksl_wldj;
import com.aisino2.icksystem.service.IIcksl_wldjService;

public class Icksl_wldjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IIcksl_wldjService icksl_wldjService;

	/** @param IC卡受理_物流登记信息(t_icksl_wldj) */

	public void test() {
		Icksl_wldj icksl_wldj = new Icksl_wldj();

	/** @ IC卡受理ID(ickslid) */
	icksl_wldj.setIckslid(0);

	/** @ 物流ID(wlid) */
	icksl_wldj.setWlid(0);

		/*
		//插入对象
		icksl_wldjService.insertIcksl_wldj(icksl_wldj);

		//读取对象比较
		BaseObject bo = icksl_wldjService.getIcksl_wldj(icksl_wldj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Icksl_wldj icksl_wldjNew = (Icksl_wldj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(icksl_wldjNew.getIckslid(), icksl_wldj.getIckslid());
		assertEquals(icksl_wldjNew.getWlid(), icksl_wldj.getWlid());

		//删除对象
		// @ IC卡受理ID(ickslid) 
		icksl_wldj.setIckslid(1)
		// @ 物流ID(wlid) 
		icksl_wldj.setWlid(1)

		icksl_wldjService.deleteIcksl_wldj(icksl_wldj);

		//修改对象
		// @ IC卡受理ID(ickslid) 
		icksl_wldj.setIckslid(1)
		// @ 物流ID(wlid) 
		icksl_wldj.setWlid(1)

		icksl_wldjService.updateIcksl_wldj(icksl_wldj);

		//查询单条
		// @ IC卡受理ID(ickslid) 
		icksl_wldj.setIckslid(1)
		// @ 物流ID(wlid) 
		icksl_wldj.setWlid(1)

		icksl_wldjService.getIcksl_wldj(icksl_wldj);

		//查询多条
		// @ IC卡受理ID(ickslid) 
		icksl_wldj.setIckslid(1)
		// @ 物流ID(wlid) 
		icksl_wldj.setWlid(1)

		icksl_wldjService.getListIcksl_wldj(icksl_wldj);

		//翻页查询
		// @ IC卡受理ID(ickslid) 
		icksl_wldj.setIckslid(1)
		// @ 物流ID(wlid) 
		icksl_wldj.setWlid(1)

		icksl_wldjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		icksl_wldjService.insertIcksl_wldj(icksl_wldj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setIcksl_wldjService(IIcksl_wldjService icksl_wldjService) {
		this.icksl_wldjService = icksl_wldjService;
	}
}
