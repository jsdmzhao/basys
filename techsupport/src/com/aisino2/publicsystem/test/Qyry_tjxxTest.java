package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyry_tjxx;
import com.aisino2.publicsystem.service.IQyry_tjxxService;

public class Qyry_tjxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyry_tjxxService qyry_tjxxService;

	/** @param 企业人员体检信息(t_qyry_tjxx) */

	public void test() {
		Qyry_tjxx qyry_tjxx = new Qyry_tjxx();

	/** @ 企业ID(qyid) */
	qyry_tjxx.setQyid(0);

	/** @ 从业人员ID(ryid) */
	qyry_tjxx.setRyid(0);

	/** @ 体检信息ID(tjxxid) */
	qyry_tjxx.setTjxxid(0);

	/** @ 体检日期(tijianrq) */
	qyry_tjxx.setTijianrq(new Date());

	/** @ 体检状况及描述(tjzkjms) */
	qyry_tjxx.setTjzkjms("test");

	/** @ 录入人(lrr) */
	qyry_tjxx.setLrr("test");

	/** @ 录入日期(lrrq) */
	qyry_tjxx.setLrrq(new Date());

		/*
		//插入对象
		qyry_tjxxService.insertQyry_tjxx(qyry_tjxx);

		//读取对象比较
		BaseObject bo = qyry_tjxxService.getQyry_tjxx(qyry_tjxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyry_tjxx qyry_tjxxNew = (Qyry_tjxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyry_tjxxNew.getQyid(), qyry_tjxx.getQyid());
		assertEquals(qyry_tjxxNew.getRyid(), qyry_tjxx.getRyid());
		assertEquals(qyry_tjxxNew.getTjxxid(), qyry_tjxx.getTjxxid());
		assertEquals(qyry_tjxxNew.getTijianrq(), qyry_tjxx.getTijianrq());
		assertEquals(qyry_tjxxNew.getTjzkjms(), qyry_tjxx.getTjzkjms());
		assertEquals(qyry_tjxxNew.getLrr(), qyry_tjxx.getLrr());
		assertEquals(qyry_tjxxNew.getLrrq(), qyry_tjxx.getLrrq());

		//删除对象
		// @ 企业ID(qyid) 
		qyry_tjxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyry_tjxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyry_tjxx.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyry_tjxx.setRyid(1)
		// @ 体检信息ID(tjxxid) 
		qyry_tjxx.setTjxxid(1)

		qyry_tjxxService.deleteQyry_tjxx(qyry_tjxx);

		//修改对象
		// @ 企业ID(qyid) 
		qyry_tjxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyry_tjxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyry_tjxx.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyry_tjxx.setRyid(1)
		// @ 体检信息ID(tjxxid) 
		qyry_tjxx.setTjxxid(1)

		qyry_tjxxService.updateQyry_tjxx(qyry_tjxx);

		//查询单条
		// @ 企业ID(qyid) 
		qyry_tjxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyry_tjxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyry_tjxx.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyry_tjxx.setRyid(1)
		// @ 体检信息ID(tjxxid) 
		qyry_tjxx.setTjxxid(1)

		qyry_tjxxService.getQyry_tjxx(qyry_tjxx);

		//查询多条
		// @ 企业ID(qyid) 
		qyry_tjxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyry_tjxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyry_tjxx.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyry_tjxx.setRyid(1)
		// @ 体检信息ID(tjxxid) 
		qyry_tjxx.setTjxxid(1)

		qyry_tjxxService.getListQyry_tjxx(qyry_tjxx);

		//翻页查询
		// @ 企业ID(qyid) 
		qyry_tjxx.setQyid(1)
		// @ 企业ID(qyid) 
		qyry_tjxx.setQyid(1)
		// @ 从业人员ID(ryid) 
		qyry_tjxx.setRyid(1)
		// @ 从业人员ID(ryid) 
		qyry_tjxx.setRyid(1)
		// @ 体检信息ID(tjxxid) 
		qyry_tjxx.setTjxxid(1)

		qyry_tjxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyry_tjxxService.insertQyry_tjxx(qyry_tjxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyry_tjxxService(IQyry_tjxxService qyry_tjxxService) {
		this.qyry_tjxxService = qyry_tjxxService;
	}
}
