package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Zdycxtj;
import com.aisino2.basicsystem.service.IZdycxtjService;
import com.aisino2.core.test.BaseTestCase;

public class ZdycxtjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IZdycxtjService zdycxtjService;

	/** @param 自定义查询条件(t_zdycxtj) */

	public void test() {
		Zdycxtj zdycxtj = new Zdycxtj();

	/** @ 自定义查询条件ID(zdycxtjid) */
	zdycxtj.setZdycxtjid(0);

	/** @ 高级查询方案ID(gjcxfaid) */
	zdycxtj.setGjcxfaid(0);

	/** @ 查询条件(cxtj) */
	zdycxtj.setCxtj("test");

	/** @ 查询排序(cxpx) */
	zdycxtj.setCxpx("test");

		/*
		//插入对象
		zdycxtjService.insertZdycxtj(zdycxtj);

		//读取对象比较
		BaseObject bo = zdycxtjService.getZdycxtj(zdycxtj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Zdycxtj zdycxtjNew = (Zdycxtj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(zdycxtjNew.getZdycxtjid(), zdycxtj.getZdycxtjid());
		assertEquals(zdycxtjNew.getGjcxfaid(), zdycxtj.getGjcxfaid());
		assertEquals(zdycxtjNew.getCxtj(), zdycxtj.getCxtj());
		assertEquals(zdycxtjNew.getCxpx(), zdycxtj.getCxpx());

		//删除对象
		// @ 自定义查询条件ID(zdycxtjid) 
		zdycxtj.setZdycxtjid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		zdycxtj.setGjcxfaid(1)

		zdycxtjService.deleteZdycxtj(zdycxtj);

		//修改对象
		// @ 自定义查询条件ID(zdycxtjid) 
		zdycxtj.setZdycxtjid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		zdycxtj.setGjcxfaid(1)

		zdycxtjService.updateZdycxtj(zdycxtj);

		//查询单条
		// @ 自定义查询条件ID(zdycxtjid) 
		zdycxtj.setZdycxtjid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		zdycxtj.setGjcxfaid(1)

		zdycxtjService.getZdycxtj(zdycxtj);

		//查询多条
		// @ 自定义查询条件ID(zdycxtjid) 
		zdycxtj.setZdycxtjid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		zdycxtj.setGjcxfaid(1)

		zdycxtjService.getListZdycxtj(zdycxtj);

		//翻页查询
		// @ 自定义查询条件ID(zdycxtjid) 
		zdycxtj.setZdycxtjid(1)
		// @ 高级查询方案ID(gjcxfaid) 
		zdycxtj.setGjcxfaid(1)

		zdycxtjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		zdycxtjService.insertZdycxtj(zdycxtj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setZdycxtjService(IZdycxtjService zdycxtjService) {
		this.zdycxtjService = zdycxtjService;
	}
}
