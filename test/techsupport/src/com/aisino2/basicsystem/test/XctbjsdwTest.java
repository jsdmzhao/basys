package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Xctbjsdw;
import com.aisino2.basicsystem.service.IXctbjsdwService;
import com.aisino2.core.test.BaseTestCase;

public class XctbjsdwTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IXctbjsdwService xctbjsdwService;

	/** @param 协查通报接收单位(t_xctbjsdw) */

	public void test() {
		Xctbjsdw xctbjsdw = new Xctbjsdw();

	/** @ 通报ID(tbid) */
	xctbjsdw.setTbid(0);

	/** @ 接收单位ID(jsdwid) */
	xctbjsdw.setJsdwid(0);

	/** @ 接收单位编码(jsdwbm) */
	xctbjsdw.setJsdwbm("test");

	/** @ 接收单位名称(jsdwmc) */
	xctbjsdw.setJsdwmc("test");

	/** @ 收取时间(sqsj) */
	xctbjsdw.setSqsj(new Date());

		/*
		//插入对象
		xctbjsdwService.insertXctbjsdw(xctbjsdw);

		//读取对象比较
		BaseObject bo = xctbjsdwService.getXctbjsdw(xctbjsdw);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Xctbjsdw xctbjsdwNew = (Xctbjsdw)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(xctbjsdwNew.getTbid(), xctbjsdw.getTbid());
		assertEquals(xctbjsdwNew.getJsdwid(), xctbjsdw.getJsdwid());
		assertEquals(xctbjsdwNew.getJsdwbm(), xctbjsdw.getJsdwbm());
		assertEquals(xctbjsdwNew.getJsdwmc(), xctbjsdw.getJsdwmc());
		assertEquals(xctbjsdwNew.getSqsj(), xctbjsdw.getSqsj());

		//删除对象
		// @ 通报ID(tbid) 
		xctbjsdw.setTbid(1)
		// @ 通报ID(tbid) 
		xctbjsdw.setTbid(1)
		// @ 接收单位ID(jsdwid) 
		xctbjsdw.setJsdwid(1)

		xctbjsdwService.deleteXctbjsdw(xctbjsdw);

		//修改对象
		// @ 通报ID(tbid) 
		xctbjsdw.setTbid(1)
		// @ 通报ID(tbid) 
		xctbjsdw.setTbid(1)
		// @ 接收单位ID(jsdwid) 
		xctbjsdw.setJsdwid(1)

		xctbjsdwService.updateXctbjsdw(xctbjsdw);

		//查询单条
		// @ 通报ID(tbid) 
		xctbjsdw.setTbid(1)
		// @ 通报ID(tbid) 
		xctbjsdw.setTbid(1)
		// @ 接收单位ID(jsdwid) 
		xctbjsdw.setJsdwid(1)

		xctbjsdwService.getXctbjsdw(xctbjsdw);

		//查询多条
		// @ 通报ID(tbid) 
		xctbjsdw.setTbid(1)
		// @ 通报ID(tbid) 
		xctbjsdw.setTbid(1)
		// @ 接收单位ID(jsdwid) 
		xctbjsdw.setJsdwid(1)

		xctbjsdwService.getListXctbjsdw(xctbjsdw);

		//翻页查询
		// @ 通报ID(tbid) 
		xctbjsdw.setTbid(1)
		// @ 通报ID(tbid) 
		xctbjsdw.setTbid(1)
		// @ 接收单位ID(jsdwid) 
		xctbjsdw.setJsdwid(1)

		xctbjsdwService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		xctbjsdwService.insertXctbjsdw(xctbjsdw);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setXctbjsdwService(IXctbjsdwService xctbjsdwService) {
		this.xctbjsdwService = xctbjsdwService;
	}
}
