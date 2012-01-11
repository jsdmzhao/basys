package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qybgxx;
import com.aisino2.publicsystem.service.IQybgxxService;

public class QybgxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQybgxxService qybgxxService;

	/** @param 企业变更信息(t_qybgxx) */

	public void test() {
		Qybgxx qybgxx = new Qybgxx();

	/** @ 企业ID(qyid) */
	qybgxx.setQyid(0);

	/** @ 企业历史ID(qylsid) */
	qybgxx.setQylsid(0);

	/** @ 企业变更信息ID(qybgxxid) */
	qybgxx.setQybgxxid(0);

	/** @ 变更登记序号(bgdjxh) */
	qybgxx.setBgdjxh("test");

	/** @ 变更类型代码(bglxdm) */
	qybgxx.setBglxdm("test");

	/** @ 变更类型(bglx) */
	qybgxx.setBglx("test");

	/** @ 变更日期(bgrq) */
	qybgxx.setBgrq(new Date());

	/** @ 变更原因(bgyy) */
	qybgxx.setBgyy("test");

	/** @ 变更前内容(bgqnr) */
	qybgxx.setBgqnr("test");

	/** @ 变更后内容(bghnr) */
	qybgxx.setBghnr("test");

		/*
		//插入对象
		qybgxxService.insertQybgxx(qybgxx);

		//读取对象比较
		BaseObject bo = qybgxxService.getQybgxx(qybgxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qybgxx qybgxxNew = (Qybgxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qybgxxNew.getQyid(), qybgxx.getQyid());
		assertEquals(qybgxxNew.getQylsid(), qybgxx.getQylsid());
		assertEquals(qybgxxNew.getQybgxxid(), qybgxx.getQybgxxid());
		assertEquals(qybgxxNew.getBgdjxh(), qybgxx.getBgdjxh());
		assertEquals(qybgxxNew.getBglxdm(), qybgxx.getBglxdm());
		assertEquals(qybgxxNew.getBglx(), qybgxx.getBglx());
		assertEquals(qybgxxNew.getBgrq(), qybgxx.getBgrq());
		assertEquals(qybgxxNew.getBgyy(), qybgxx.getBgyy());
		assertEquals(qybgxxNew.getBgqnr(), qybgxx.getBgqnr());
		assertEquals(qybgxxNew.getBghnr(), qybgxx.getBghnr());

		//删除对象
		// @ 企业ID(qyid) 
		qybgxx.setQyid(1)
		// @ 企业ID(qyid) 
		qybgxx.setQyid(1)
		// @ 企业历史ID(qylsid) 
		qybgxx.setQylsid(1)
		// @ 企业历史ID(qylsid) 
		qybgxx.setQylsid(1)
		// @ 企业变更信息ID(qybgxxid) 
		qybgxx.setQybgxxid(1)

		qybgxxService.deleteQybgxx(qybgxx);

		//修改对象
		// @ 企业ID(qyid) 
		qybgxx.setQyid(1)
		// @ 企业ID(qyid) 
		qybgxx.setQyid(1)
		// @ 企业历史ID(qylsid) 
		qybgxx.setQylsid(1)
		// @ 企业历史ID(qylsid) 
		qybgxx.setQylsid(1)
		// @ 企业变更信息ID(qybgxxid) 
		qybgxx.setQybgxxid(1)

		qybgxxService.updateQybgxx(qybgxx);

		//查询单条
		// @ 企业ID(qyid) 
		qybgxx.setQyid(1)
		// @ 企业ID(qyid) 
		qybgxx.setQyid(1)
		// @ 企业历史ID(qylsid) 
		qybgxx.setQylsid(1)
		// @ 企业历史ID(qylsid) 
		qybgxx.setQylsid(1)
		// @ 企业变更信息ID(qybgxxid) 
		qybgxx.setQybgxxid(1)

		qybgxxService.getQybgxx(qybgxx);

		//查询多条
		// @ 企业ID(qyid) 
		qybgxx.setQyid(1)
		// @ 企业ID(qyid) 
		qybgxx.setQyid(1)
		// @ 企业历史ID(qylsid) 
		qybgxx.setQylsid(1)
		// @ 企业历史ID(qylsid) 
		qybgxx.setQylsid(1)
		// @ 企业变更信息ID(qybgxxid) 
		qybgxx.setQybgxxid(1)

		qybgxxService.getListQybgxx(qybgxx);

		//翻页查询
		// @ 企业ID(qyid) 
		qybgxx.setQyid(1)
		// @ 企业ID(qyid) 
		qybgxx.setQyid(1)
		// @ 企业历史ID(qylsid) 
		qybgxx.setQylsid(1)
		// @ 企业历史ID(qylsid) 
		qybgxx.setQylsid(1)
		// @ 企业变更信息ID(qybgxxid) 
		qybgxx.setQybgxxid(1)

		qybgxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qybgxxService.insertQybgxx(qybgxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQybgxxService(IQybgxxService qybgxxService) {
		this.qybgxxService = qybgxxService;
	}
}
