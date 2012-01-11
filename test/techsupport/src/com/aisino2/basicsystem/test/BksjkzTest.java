package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Bksjkz;
import com.aisino2.basicsystem.service.IBksjkzService;
import com.aisino2.core.test.BaseTestCase;

public class BksjkzTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBksjkzService bksjkzService;

	/** @param 布控手机快照(t_bksjkz) */

	public void test() {
		Bksjkz bksjkz = new Bksjkz();

	/** @ 报警信息ID(bjxxid2) */
	bksjkz.setBjxxid2(0);

	/** @ 布控物品基本信息快照ID(bkwpjbxxkzid) */
	bksjkz.setBkwpjbxxkzid(0);

	/** @ 布控手机快照ID(bksjkzid) */
	bksjkz.setBksjkzid(0);

	/** @ 手机串号(sjch) */
	bksjkz.setSjch("test");

	/** @ 品牌(pp) */
	bksjkz.setPp("test");

	/** @ 型号(xh) */
	bksjkz.setXh("test");

	/** @ 颜色(ys) */
	bksjkz.setYs("test");

		/*
		//插入对象
		bksjkzService.insertBksjkz(bksjkz);

		//读取对象比较
		BaseObject bo = bksjkzService.getBksjkz(bksjkz);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bksjkz bksjkzNew = (Bksjkz)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bksjkzNew.getBjxxid2(), bksjkz.getBjxxid2());
		assertEquals(bksjkzNew.getBkwpjbxxkzid(), bksjkz.getBkwpjbxxkzid());
		assertEquals(bksjkzNew.getBksjkzid(), bksjkz.getBksjkzid());
		assertEquals(bksjkzNew.getSjch(), bksjkz.getSjch());
		assertEquals(bksjkzNew.getPp(), bksjkz.getPp());
		assertEquals(bksjkzNew.getXh(), bksjkz.getXh());
		assertEquals(bksjkzNew.getYs(), bksjkz.getYs());

		//删除对象
		// @ 报警信息ID(bjxxid2) 
		bksjkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bksjkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bksjkz.setBkwpjbxxkzid(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bksjkz.setBkwpjbxxkzid(1)
		// @ 布控手机快照ID(bksjkzid) 
		bksjkz.setBksjkzid(1)

		bksjkzService.deleteBksjkz(bksjkz);

		//修改对象
		// @ 报警信息ID(bjxxid2) 
		bksjkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bksjkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bksjkz.setBkwpjbxxkzid(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bksjkz.setBkwpjbxxkzid(1)
		// @ 布控手机快照ID(bksjkzid) 
		bksjkz.setBksjkzid(1)

		bksjkzService.updateBksjkz(bksjkz);

		//查询单条
		// @ 报警信息ID(bjxxid2) 
		bksjkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bksjkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bksjkz.setBkwpjbxxkzid(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bksjkz.setBkwpjbxxkzid(1)
		// @ 布控手机快照ID(bksjkzid) 
		bksjkz.setBksjkzid(1)

		bksjkzService.getBksjkz(bksjkz);

		//查询多条
		// @ 报警信息ID(bjxxid2) 
		bksjkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bksjkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bksjkz.setBkwpjbxxkzid(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bksjkz.setBkwpjbxxkzid(1)
		// @ 布控手机快照ID(bksjkzid) 
		bksjkz.setBksjkzid(1)

		bksjkzService.getListBksjkz(bksjkz);

		//翻页查询
		// @ 报警信息ID(bjxxid2) 
		bksjkz.setBjxxid2(1)
		// @ 报警信息ID(bjxxid2) 
		bksjkz.setBjxxid2(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bksjkz.setBkwpjbxxkzid(1)
		// @ 布控物品基本信息快照ID(bkwpjbxxkzid) 
		bksjkz.setBkwpjbxxkzid(1)
		// @ 布控手机快照ID(bksjkzid) 
		bksjkz.setBksjkzid(1)

		bksjkzService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bksjkzService.insertBksjkz(bksjkz);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBksjkzService(IBksjkzService bksjkzService) {
		this.bksjkzService = bksjkzService;
	}
}
