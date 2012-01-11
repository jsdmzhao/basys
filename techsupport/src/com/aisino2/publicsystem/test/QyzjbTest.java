package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyzjb;
import com.aisino2.publicsystem.service.IQyzjbService;

public class QyzjbTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyzjbService qyzjbService;

	/** @param 企业证件表(t_qyzjb) */

	public void test() {
		Qyzjb qyzjb = new Qyzjb();

	/** @ 证件ID(zjid) */
	qyzjb.setZjid(0);

	/** @ 企业ID(qyid) */
	qyzjb.setQyid(0);

	/** @ 证件分类(zjfl) */
	qyzjb.setZjfl("test");

	/** @ 证件编号(zjbh) */
	qyzjb.setZjbh("test");

	/** @ 发证机关(fzjg) */
	qyzjb.setFzjg("test");

	/** @ 起始日期(qsrq) */
	qyzjb.setQsrq(new Date());

	/** @ 截止日期(jzrq) */
	qyzjb.setJzrq(new Date());

		/*
		//插入对象
		qyzjbService.insertQyzjb(qyzjb);

		//读取对象比较
		BaseObject bo = qyzjbService.getQyzjb(qyzjb);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyzjb qyzjbNew = (Qyzjb)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyzjbNew.getZjid(), qyzjb.getZjid());
		assertEquals(qyzjbNew.getQyid(), qyzjb.getQyid());
		assertEquals(qyzjbNew.getZjfl(), qyzjb.getZjfl());
		assertEquals(qyzjbNew.getZjbh(), qyzjb.getZjbh());
		assertEquals(qyzjbNew.getFzjg(), qyzjb.getFzjg());
		assertEquals(qyzjbNew.getQsrq(), qyzjb.getQsrq());
		assertEquals(qyzjbNew.getJzrq(), qyzjb.getJzrq());

		//删除对象
		// @ 证件ID(zjid) 
		qyzjb.setZjid(1)
		// @ 企业ID(qyid) 
		qyzjb.setQyid(1)

		qyzjbService.deleteQyzjb(qyzjb);

		//修改对象
		// @ 证件ID(zjid) 
		qyzjb.setZjid(1)
		// @ 企业ID(qyid) 
		qyzjb.setQyid(1)

		qyzjbService.updateQyzjb(qyzjb);

		//查询单条
		// @ 证件ID(zjid) 
		qyzjb.setZjid(1)
		// @ 企业ID(qyid) 
		qyzjb.setQyid(1)

		qyzjbService.getQyzjb(qyzjb);

		//查询多条
		// @ 证件ID(zjid) 
		qyzjb.setZjid(1)
		// @ 企业ID(qyid) 
		qyzjb.setQyid(1)

		qyzjbService.getListQyzjb(qyzjb);

		//翻页查询
		// @ 证件ID(zjid) 
		qyzjb.setZjid(1)
		// @ 企业ID(qyid) 
		qyzjb.setQyid(1)

		qyzjbService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyzjbService.insertQyzjb(qyzjb);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyzjbService(IQyzjbService qyzjbService) {
		this.qyzjbService = qyzjbService;
	}
}
