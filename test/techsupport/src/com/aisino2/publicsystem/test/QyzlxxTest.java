package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyzlxx;
import com.aisino2.publicsystem.service.IQyzlxxService;

public class QyzlxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyzlxxService qyzlxxService;

	/** @param 企业质量信息(t_qyzlxx) */

	public void test() {
		Qyzlxx qyzlxx = new Qyzlxx();

	/** @ 企业质量信息ID(qyzlxxid) */
	qyzlxx.setQyzlxxid(0);

	/** @ 行业类别代码(hylbdm) */
	qyzlxx.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyzlxx.setHylb("test");

	/** @ 发布单位代码(fbdwdm) */
	qyzlxx.setFbdwdm("test");

	/** @ 发布单位名称(fbdwmc) */
	qyzlxx.setFbdwmc("test");

	/** @ 发布人(fbr) */
	qyzlxx.setFbr("test");

	/** @ 发布时间(fbsj) */
	qyzlxx.setFbsj(new Date());

	/** @ 删除标志(scbz) */
	qyzlxx.setScbz(0);

		/*
		//插入对象
		qyzlxxService.insertQyzlxx(qyzlxx);

		//读取对象比较
		BaseObject bo = qyzlxxService.getQyzlxx(qyzlxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyzlxx qyzlxxNew = (Qyzlxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyzlxxNew.getQyzlxxid(), qyzlxx.getQyzlxxid());
		assertEquals(qyzlxxNew.getHylbdm(), qyzlxx.getHylbdm());
		assertEquals(qyzlxxNew.getHylb(), qyzlxx.getHylb());
		assertEquals(qyzlxxNew.getFbdwdm(), qyzlxx.getFbdwdm());
		assertEquals(qyzlxxNew.getFbdwmc(), qyzlxx.getFbdwmc());
		assertEquals(qyzlxxNew.getFbr(), qyzlxx.getFbr());
		assertEquals(qyzlxxNew.getFbsj(), qyzlxx.getFbsj());
		assertEquals(qyzlxxNew.getScbz(), qyzlxx.getScbz());

		//删除对象
		// @ 企业质量信息ID(qyzlxxid) 
		qyzlxx.setQyzlxxid(1)

		qyzlxxService.deleteQyzlxx(qyzlxx);

		//修改对象
		// @ 企业质量信息ID(qyzlxxid) 
		qyzlxx.setQyzlxxid(1)

		qyzlxxService.updateQyzlxx(qyzlxx);

		//查询单条
		// @ 企业质量信息ID(qyzlxxid) 
		qyzlxx.setQyzlxxid(1)

		qyzlxxService.getQyzlxx(qyzlxx);

		//查询多条
		// @ 企业质量信息ID(qyzlxxid) 
		qyzlxx.setQyzlxxid(1)

		qyzlxxService.getListQyzlxx(qyzlxx);

		//翻页查询
		// @ 企业质量信息ID(qyzlxxid) 
		qyzlxx.setQyzlxxid(1)

		qyzlxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyzlxxService.insertQyzlxx(qyzlxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyzlxxService(IQyzlxxService qyzlxxService) {
		this.qyzlxxService = qyzlxxService;
	}
}
