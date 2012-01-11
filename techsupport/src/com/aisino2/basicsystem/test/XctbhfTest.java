package com.aisino2.basicsystem.test;

import java.util.Date;

import com.aisino2.basicsystem.domain.Xctbhf;
import com.aisino2.basicsystem.service.IXctbhfService;
import com.aisino2.core.test.BaseTestCase;

public class XctbhfTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IXctbhfService xctbhfService;

	/** @param 协查通报回复(t_xctbhf) */

	public void test() {
		Xctbhf xctbhf = new Xctbhf();

	/** @ 通报ID(tbid) */
	xctbhf.setTbid(0);

	/** @ 接收单位ID(jsdwid) */
	xctbhf.setJsdwid(0);

	/** @ 回复ID(hfid) */
	xctbhf.setHfid(0);

	/** @ 回复时间(hfsj) */
	xctbhf.setHfsj(new Date());

	/** @ 回复内容(hfnr) */
	xctbhf.setHfnr("test");

	/** @ 回复人(hfr) */
	xctbhf.setHfr("test");

		/*
		//插入对象
		xctbhfService.insertXctbhf(xctbhf);

		//读取对象比较
		BaseObject bo = xctbhfService.getXctbhf(xctbhf);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Xctbhf xctbhfNew = (Xctbhf)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(xctbhfNew.getTbid(), xctbhf.getTbid());
		assertEquals(xctbhfNew.getJsdwid(), xctbhf.getJsdwid());
		assertEquals(xctbhfNew.getHfid(), xctbhf.getHfid());
		assertEquals(xctbhfNew.getHfsj(), xctbhf.getHfsj());
		assertEquals(xctbhfNew.getHfnr(), xctbhf.getHfnr());
		assertEquals(xctbhfNew.getHfr(), xctbhf.getHfr());

		//删除对象
		// @ 通报ID(tbid) 
		xctbhf.setTbid(1)
		// @ 通报ID(tbid) 
		xctbhf.setTbid(1)
		// @ 接收单位ID(jsdwid) 
		xctbhf.setJsdwid(1)
		// @ 接收单位ID(jsdwid) 
		xctbhf.setJsdwid(1)
		// @ 回复ID(hfid) 
		xctbhf.setHfid(1)

		xctbhfService.deleteXctbhf(xctbhf);

		//修改对象
		// @ 通报ID(tbid) 
		xctbhf.setTbid(1)
		// @ 通报ID(tbid) 
		xctbhf.setTbid(1)
		// @ 接收单位ID(jsdwid) 
		xctbhf.setJsdwid(1)
		// @ 接收单位ID(jsdwid) 
		xctbhf.setJsdwid(1)
		// @ 回复ID(hfid) 
		xctbhf.setHfid(1)

		xctbhfService.updateXctbhf(xctbhf);

		//查询单条
		// @ 通报ID(tbid) 
		xctbhf.setTbid(1)
		// @ 通报ID(tbid) 
		xctbhf.setTbid(1)
		// @ 接收单位ID(jsdwid) 
		xctbhf.setJsdwid(1)
		// @ 接收单位ID(jsdwid) 
		xctbhf.setJsdwid(1)
		// @ 回复ID(hfid) 
		xctbhf.setHfid(1)

		xctbhfService.getXctbhf(xctbhf);

		//查询多条
		// @ 通报ID(tbid) 
		xctbhf.setTbid(1)
		// @ 通报ID(tbid) 
		xctbhf.setTbid(1)
		// @ 接收单位ID(jsdwid) 
		xctbhf.setJsdwid(1)
		// @ 接收单位ID(jsdwid) 
		xctbhf.setJsdwid(1)
		// @ 回复ID(hfid) 
		xctbhf.setHfid(1)

		xctbhfService.getListXctbhf(xctbhf);

		//翻页查询
		// @ 通报ID(tbid) 
		xctbhf.setTbid(1)
		// @ 通报ID(tbid) 
		xctbhf.setTbid(1)
		// @ 接收单位ID(jsdwid) 
		xctbhf.setJsdwid(1)
		// @ 接收单位ID(jsdwid) 
		xctbhf.setJsdwid(1)
		// @ 回复ID(hfid) 
		xctbhf.setHfid(1)

		xctbhfService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		xctbhfService.insertXctbhf(xctbhf);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setXctbhfService(IXctbhfService xctbhfService) {
		this.xctbhfService = xctbhfService;
	}
}
