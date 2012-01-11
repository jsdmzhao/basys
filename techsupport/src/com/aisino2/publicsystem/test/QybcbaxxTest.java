package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qybcbaxx;
import com.aisino2.publicsystem.service.IQybcbaxxService;

public class QybcbaxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQybcbaxxService qybcbaxxService;

	/** @param 企业补充备案信息(t_qybcbaxx) */

	public void test() {
		Qybcbaxx qybcbaxx = new Qybcbaxx();

	/** @ 企业ID(qyid) */
	qybcbaxx.setQyid(0);

	/** @ 企业备案信息ID(qybaxxid) */
	qybcbaxx.setQybaxxid(0);

	/** @ 补备告知日期(bbgzrq) */
	qybcbaxx.setBbgzrq(new Date());

	/** @ 补备原因(bbyy) */
	qybcbaxx.setBbyy("test");

	/** @ 补备完成日期(bbwcrq) */
	qybcbaxx.setBbwcrq(new Date());

		/*
		//插入对象
		qybcbaxxService.insertQybcbaxx(qybcbaxx);

		//读取对象比较
		BaseObject bo = qybcbaxxService.getQybcbaxx(qybcbaxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qybcbaxx qybcbaxxNew = (Qybcbaxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qybcbaxxNew.getQyid(), qybcbaxx.getQyid());
		assertEquals(qybcbaxxNew.getQybaxxid(), qybcbaxx.getQybaxxid());
		assertEquals(qybcbaxxNew.getBbgzrq(), qybcbaxx.getBbgzrq());
		assertEquals(qybcbaxxNew.getBbyy(), qybcbaxx.getBbyy());
		assertEquals(qybcbaxxNew.getBbwcrq(), qybcbaxx.getBbwcrq());

		//删除对象
		// @ 企业ID(qyid) 
		qybcbaxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		qybcbaxx.setQybaxxid(1)

		qybcbaxxService.deleteQybcbaxx(qybcbaxx);

		//修改对象
		// @ 企业ID(qyid) 
		qybcbaxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		qybcbaxx.setQybaxxid(1)

		qybcbaxxService.updateQybcbaxx(qybcbaxx);

		//查询单条
		// @ 企业ID(qyid) 
		qybcbaxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		qybcbaxx.setQybaxxid(1)

		qybcbaxxService.getQybcbaxx(qybcbaxx);

		//查询多条
		// @ 企业ID(qyid) 
		qybcbaxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		qybcbaxx.setQybaxxid(1)

		qybcbaxxService.getListQybcbaxx(qybcbaxx);

		//翻页查询
		// @ 企业ID(qyid) 
		qybcbaxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		qybcbaxx.setQybaxxid(1)

		qybcbaxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qybcbaxxService.insertQybcbaxx(qybcbaxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQybcbaxxService(IQybcbaxxService qybcbaxxService) {
		this.qybcbaxxService = qybcbaxxService;
	}
}
