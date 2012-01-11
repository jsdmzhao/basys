package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Bjjsx;
import com.aisino2.basicsystem.service.IBjjsxService;
import com.aisino2.core.test.BaseTestCase;

public class BjjsxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IBjjsxService bjjsxService;

	/** @param 报警机刷新(t_bjjsx) */

	public void test() {
		Bjjsx bjjsx = new Bjjsx();

	/** @ 报警机序号(bjjxh) */
	bjjsx.setBjjxh(0);

	/** @ 公安机关编码(gajgbm) */
	bjjsx.setGajgbm("test");

	/** @ 公安机关名称(gajgmc) */
	bjjsx.setGajgmc("test");

	/** @ 报警机IP地址(bjjipdz) */
	bjjsx.setBjjipdz("test");

	/** @ 报警机刷新时间(bjjsxj) */
	bjjsx.setBjjsxj(new Date());

	/** @ 与上次刷新时间间隔(yscsxsjdjg) */
	bjjsx.setYscsxsjdjg(0);

		/*
		//插入对象
		bjjsxService.insertBjjsx(bjjsx);

		//读取对象比较
		BaseObject bo = bjjsxService.getBjjsx(bjjsx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Bjjsx bjjsxNew = (Bjjsx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(bjjsxNew.getBjjxh(), bjjsx.getBjjxh());
		assertEquals(bjjsxNew.getGajgbm(), bjjsx.getGajgbm());
		assertEquals(bjjsxNew.getGajgmc(), bjjsx.getGajgmc());
		assertEquals(bjjsxNew.getBjjipdz(), bjjsx.getBjjipdz());
		assertEquals(bjjsxNew.getBjjsxj(), bjjsx.getBjjsxj());
		assertEquals(bjjsxNew.getYscsxsjdjg(), bjjsx.getYscsxsjdjg());

		//删除对象
		// @ 报警机序号(bjjxh) 
		bjjsx.setBjjxh(1)

		bjjsxService.deleteBjjsx(bjjsx);

		//修改对象
		// @ 报警机序号(bjjxh) 
		bjjsx.setBjjxh(1)

		bjjsxService.updateBjjsx(bjjsx);

		//查询单条
		// @ 报警机序号(bjjxh) 
		bjjsx.setBjjxh(1)

		bjjsxService.getBjjsx(bjjsx);

		//查询多条
		// @ 报警机序号(bjjxh) 
		bjjsx.setBjjxh(1)

		bjjsxService.getListBjjsx(bjjsx);

		//翻页查询
		// @ 报警机序号(bjjxh) 
		bjjsx.setBjjxh(1)

		bjjsxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		bjjsxService.insertBjjsx(bjjsx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setBjjsxService(IBjjsxService bjjsxService) {
		this.bjjsxService = bjjsxService;
	}
}
