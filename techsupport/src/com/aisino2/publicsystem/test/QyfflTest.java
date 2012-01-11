package com.aisino2.publicsystem.test;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyffl;
import com.aisino2.publicsystem.service.IQyfflService;

public class QyfflTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyfflService qyfflService;

	/** @param 企业副分类(t_qyffl) */

	public void test() {
		Qyffl qyffl = new Qyffl();

	/** @ 企业分类ID(qyflid) */
	qyffl.setQyflid(0);

	/** @ 企业ID(qyid) */
	qyffl.setQyid(0);

	/** @ 企业分类编码(qyflbm) */
	qyffl.setQyflbm("test");

	/** @ 上级场所分类名称(sjcsflmc) */
	qyffl.setSjcsflmc("test");

	/** @ 企业分类名称(qyflmc) */
	qyffl.setQyflmc("test");

		/*
		//插入对象
		qyfflService.insertQyffl(qyffl);

		//读取对象比较
		BaseObject bo = qyfflService.getQyffl(qyffl);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyffl qyfflNew = (Qyffl)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyfflNew.getQyflid(), qyffl.getQyflid());
		assertEquals(qyfflNew.getQyid(), qyffl.getQyid());
		assertEquals(qyfflNew.getQyflbm(), qyffl.getQyflbm());
		assertEquals(qyfflNew.getSjcsflmc(), qyffl.getSjcsflmc());
		assertEquals(qyfflNew.getQyflmc(), qyffl.getQyflmc());

		//删除对象
		// @ 企业分类ID(qyflid) 
		qyffl.setQyflid(1)
		// @ 企业ID(qyid) 
		qyffl.setQyid(1)

		qyfflService.deleteQyffl(qyffl);

		//修改对象
		// @ 企业分类ID(qyflid) 
		qyffl.setQyflid(1)
		// @ 企业ID(qyid) 
		qyffl.setQyid(1)

		qyfflService.updateQyffl(qyffl);

		//查询单条
		// @ 企业分类ID(qyflid) 
		qyffl.setQyflid(1)
		// @ 企业ID(qyid) 
		qyffl.setQyid(1)

		qyfflService.getQyffl(qyffl);

		//查询多条
		// @ 企业分类ID(qyflid) 
		qyffl.setQyflid(1)
		// @ 企业ID(qyid) 
		qyffl.setQyid(1)

		qyfflService.getListQyffl(qyffl);

		//翻页查询
		// @ 企业分类ID(qyflid) 
		qyffl.setQyflid(1)
		// @ 企业ID(qyid) 
		qyffl.setQyid(1)

		qyfflService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyfflService.insertQyffl(qyffl);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyfflService(IQyfflService qyfflService) {
		this.qyfflService = qyfflService;
	}
}
