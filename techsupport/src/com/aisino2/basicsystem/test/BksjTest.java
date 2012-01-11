package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Bksj;
import com.aisino2.basicsystem.service.IBksjService;
import com.aisino2.core.test.BaseTestCase;

public class BksjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBksjService bksjService;

	/** @param 布控手机(t_bksj) */

	public void test() {
		Bksj bksj = new Bksj();

	/** @ 布控物品基本信息ID(bkwpjbxxid) */
	bksj.setBkwpjbxxid(0);

	/** @ 布控手机ID(bksjid) */
	bksj.setBksjid(0);

	/** @ 手机串号(sjch) */
	bksj.setSjch("test");

	/** @ 品牌(pp) */
	bksj.setPp("test");

	/** @ 型号(xh) */
	bksj.setXh("test");

	/** @ 颜色(ys) */
	bksj.setYs("test");

		/*
		//插入对象
		bksjService.insertBksj(bksj);

		//读取对象比较
		BaseObject bo = bksjService.getBksj(bksj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bksj bksjNew = (Bksj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bksjNew.getBkwpjbxxid(), bksj.getBkwpjbxxid());
		assertEquals(bksjNew.getBksjid(), bksj.getBksjid());
		assertEquals(bksjNew.getSjch(), bksj.getSjch());
		assertEquals(bksjNew.getPp(), bksj.getPp());
		assertEquals(bksjNew.getXh(), bksj.getXh());
		assertEquals(bksjNew.getYs(), bksj.getYs());

		//删除对象
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bksj.setBkwpjbxxid(1)
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bksj.setBkwpjbxxid(1)
		// @ 布控手机ID(bksjid) 
		bksj.setBksjid(1)

		bksjService.deleteBksj(bksj);

		//修改对象
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bksj.setBkwpjbxxid(1)
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bksj.setBkwpjbxxid(1)
		// @ 布控手机ID(bksjid) 
		bksj.setBksjid(1)

		bksjService.updateBksj(bksj);

		//查询单条
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bksj.setBkwpjbxxid(1)
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bksj.setBkwpjbxxid(1)
		// @ 布控手机ID(bksjid) 
		bksj.setBksjid(1)

		bksjService.getBksj(bksj);

		//查询多条
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bksj.setBkwpjbxxid(1)
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bksj.setBkwpjbxxid(1)
		// @ 布控手机ID(bksjid) 
		bksj.setBksjid(1)

		bksjService.getListBksj(bksj);

		//翻页查询
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bksj.setBkwpjbxxid(1)
		// @ 布控物品基本信息ID(bkwpjbxxid) 
		bksj.setBkwpjbxxid(1)
		// @ 布控手机ID(bksjid) 
		bksj.setBksjid(1)

		bksjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bksjService.insertBksj(bksj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBksjService(IBksjService bksjService) {
		this.bksjService = bksjService;
	}
}
