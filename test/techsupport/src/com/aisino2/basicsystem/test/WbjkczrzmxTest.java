package com.aisino2.basicsystem.test;

import com.aisino2.basicsystem.domain.Wbjkczrzmx;
import com.aisino2.basicsystem.service.IWbjkczrzmxService;
import com.aisino2.core.test.BaseTestCase;

public class WbjkczrzmxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IWbjkczrzmxService wbjkczrzmxService;

	/** @param 外部接口操作日志明细(t_wbjkczrzmx) */

	public void test() {
		Wbjkczrzmx wbjkczrzmx = new Wbjkczrzmx();

	/** @ 操作日志id(czrzid) */
	wbjkczrzmx.setCzrzid(0);

	/** @ 明细id(mxid) */
	wbjkczrzmx.setMxid(0);

	/** @ 操作结果类型(czjglx) */
	wbjkczrzmx.setCzjglx("test");

	/** @ 失败原因(sbyy) */
	wbjkczrzmx.setSbyy("test");

	/** @ 第几条(djt) */
	wbjkczrzmx.setDjt(0);

	/** @ 名称(mc) */
	wbjkczrzmx.setMc("test");

		/*
		//插入对象
		wbjkczrzmxService.insertWbjkczrzmx(wbjkczrzmx);

		//读取对象比较
		BaseObject bo = wbjkczrzmxService.getWbjkczrzmx(wbjkczrzmx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Wbjkczrzmx wbjkczrzmxNew = (Wbjkczrzmx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(wbjkczrzmxNew.getCzrzid(), wbjkczrzmx.getCzrzid());
		assertEquals(wbjkczrzmxNew.getMxid(), wbjkczrzmx.getMxid());
		assertEquals(wbjkczrzmxNew.getCzjglx(), wbjkczrzmx.getCzjglx());
		assertEquals(wbjkczrzmxNew.getSbyy(), wbjkczrzmx.getSbyy());
		assertEquals(wbjkczrzmxNew.getDjt(), wbjkczrzmx.getDjt());
		assertEquals(wbjkczrzmxNew.getMc(), wbjkczrzmx.getMc());

		//删除对象
		// @ 操作日志id(czrzid) 
		wbjkczrzmx.setCzrzid(1)
		// @ 操作日志id(czrzid) 
		wbjkczrzmx.setCzrzid(1)
		// @ 明细id(mxid) 
		wbjkczrzmx.setMxid(1)

		wbjkczrzmxService.deleteWbjkczrzmx(wbjkczrzmx);

		//修改对象
		// @ 操作日志id(czrzid) 
		wbjkczrzmx.setCzrzid(1)
		// @ 操作日志id(czrzid) 
		wbjkczrzmx.setCzrzid(1)
		// @ 明细id(mxid) 
		wbjkczrzmx.setMxid(1)

		wbjkczrzmxService.updateWbjkczrzmx(wbjkczrzmx);

		//查询单条
		// @ 操作日志id(czrzid) 
		wbjkczrzmx.setCzrzid(1)
		// @ 操作日志id(czrzid) 
		wbjkczrzmx.setCzrzid(1)
		// @ 明细id(mxid) 
		wbjkczrzmx.setMxid(1)

		wbjkczrzmxService.getWbjkczrzmx(wbjkczrzmx);

		//查询多条
		// @ 操作日志id(czrzid) 
		wbjkczrzmx.setCzrzid(1)
		// @ 操作日志id(czrzid) 
		wbjkczrzmx.setCzrzid(1)
		// @ 明细id(mxid) 
		wbjkczrzmx.setMxid(1)

		wbjkczrzmxService.getListWbjkczrzmx(wbjkczrzmx);

		//翻页查询
		// @ 操作日志id(czrzid) 
		wbjkczrzmx.setCzrzid(1)
		// @ 操作日志id(czrzid) 
		wbjkczrzmx.setCzrzid(1)
		// @ 明细id(mxid) 
		wbjkczrzmx.setMxid(1)

		wbjkczrzmxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		wbjkczrzmxService.insertWbjkczrzmx(wbjkczrzmx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setWbjkczrzmxService(IWbjkczrzmxService wbjkczrzmxService) {
		this.wbjkczrzmxService = wbjkczrzmxService;
	}
}
