package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qybaxx;
import com.aisino2.publicsystem.service.IQybaxxService;

public class QybaxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQybaxxService qybaxxService;

	/** @param 企业备案信息(t_qybaxx) */

	public void test() {
		Qybaxx qybaxx = new Qybaxx();

	/** @ 企业ID(qyid) */
	qybaxx.setQyid(0);

	/** @ 企业备案信息ID(qybaxxid) */
	qybaxx.setQybaxxid(0);

	/** @ 企业编码(qybm) */
	qybaxx.setQybm("test");

	/** @ 企业备案编码(qybabm) */
	qybaxx.setQybabm("test");

	/** @ 备案日期(barq) */
	qybaxx.setBarq(new Date());

	/** @ 备案部门编码(babmbm) */
	qybaxx.setBabmbm("test");

	/** @ 备案部门名称(babmmc) */
	qybaxx.setBabmmc("test");

	/** @ 备案人(bar) */
	qybaxx.setBar("test");

	/** @ 是否提交完整(sftjwz) */
	qybaxx.setSftjwz("te");

		/*
		//插入对象
		qybaxxService.insertQybaxx(qybaxx);

		//读取对象比较
		BaseObject bo = qybaxxService.getQybaxx(qybaxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qybaxx qybaxxNew = (Qybaxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qybaxxNew.getQyid(), qybaxx.getQyid());
		assertEquals(qybaxxNew.getQybaxxid(), qybaxx.getQybaxxid());
		assertEquals(qybaxxNew.getQybm(), qybaxx.getQybm());
		assertEquals(qybaxxNew.getQybabm(), qybaxx.getQybabm());
		assertEquals(qybaxxNew.getBarq(), qybaxx.getBarq());
		assertEquals(qybaxxNew.getBabmbm(), qybaxx.getBabmbm());
		assertEquals(qybaxxNew.getBabmmc(), qybaxx.getBabmmc());
		assertEquals(qybaxxNew.getBar(), qybaxx.getBar());
		assertEquals(qybaxxNew.getSftjwz(), qybaxx.getSftjwz());

		//删除对象
		// @ 企业ID(qyid) 
		qybaxx.setQyid(1)
		// @ 企业ID(qyid) 
		qybaxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		qybaxx.setQybaxxid(1)

		qybaxxService.deleteQybaxx(qybaxx);

		//修改对象
		// @ 企业ID(qyid) 
		qybaxx.setQyid(1)
		// @ 企业ID(qyid) 
		qybaxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		qybaxx.setQybaxxid(1)

		qybaxxService.updateQybaxx(qybaxx);

		//查询单条
		// @ 企业ID(qyid) 
		qybaxx.setQyid(1)
		// @ 企业ID(qyid) 
		qybaxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		qybaxx.setQybaxxid(1)

		qybaxxService.getQybaxx(qybaxx);

		//查询多条
		// @ 企业ID(qyid) 
		qybaxx.setQyid(1)
		// @ 企业ID(qyid) 
		qybaxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		qybaxx.setQybaxxid(1)

		qybaxxService.getListQybaxx(qybaxx);

		//翻页查询
		// @ 企业ID(qyid) 
		qybaxx.setQyid(1)
		// @ 企业ID(qyid) 
		qybaxx.setQyid(1)
		// @ 企业备案信息ID(qybaxxid) 
		qybaxx.setQybaxxid(1)

		qybaxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qybaxxService.insertQybaxx(qybaxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQybaxxService(IQybaxxService qybaxxService) {
		this.qybaxxService = qybaxxService;
	}
}
