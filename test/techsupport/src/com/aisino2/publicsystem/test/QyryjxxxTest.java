package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;

public class QyryjxxxTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyryjxxxService qyryjxxxService;

	/** @param 企业人员简项信息(t_qyryjxxx) */

	public void test() {
		Qyryjxxx qyryjxxx = new Qyryjxxx();

	/** @ 企业业人员简项ID(qyryjxid) */
	qyryjxxx.setQyryjxid(0);

	/** @ 企业ID(qyid) */
	qyryjxxx.setQyid(0);

	/** @ 行业类别代码(hylbdm) */
	qyryjxxx.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyryjxxx.setHylb("test");

	/** @ 从业人员编号(cyrybh) */
	qyryjxxx.setCyrybh("test");

	/** @ 姓名(xm) */
	qyryjxxx.setXm("test");

	/** @ 姓名拼音(xmpy) */
	qyryjxxx.setXmpy("test");

	/** @ 国籍代码(gjdm) */
	qyryjxxx.setGjdm("test");

	/** @ 国籍(gj) */
	qyryjxxx.setGj("test");

	/** @ 性别代码(xbdm) */
	qyryjxxx.setXbdm("test");

	/** @ 性别(xb) */
	qyryjxxx.setXb("test");

	/** @ 出生日期(csrq) */
	qyryjxxx.setCsrq(new Date());

	/** @ 户籍地行政区划(hjdxzqh) */
	qyryjxxx.setHjdxzqh("test");

	/** @ 户籍地行政区划代码(hjdxzqhdm) */
	qyryjxxx.setHjdxzqhdm("test");

	/** @ 常用证件代码(cyzjdm) */
	qyryjxxx.setCyzjdm("test");

	/** @ 常用证件(cyzj) */
	qyryjxxx.setCyzj("test");

	/** @ 证件号码(zjhm) */
	qyryjxxx.setZjhm("test");

	/** @ 录入时间(lrsj) */
	qyryjxxx.setLrsj(new Date());

	/** @ 录入人(lrr) */
	qyryjxxx.setLrr("test");

	/** @ 录入单位编码(lrdwbm) */
	qyryjxxx.setLrdwbm("test");

	/** @ 录入单位名称(lrdwmc) */
	qyryjxxx.setLrdwmc("test");

	/** @ 状态(zt) */
	qyryjxxx.setZt("test");

		/*
		//插入对象
		qyryjxxxService.insertQyryjxxx(qyryjxxx);

		//读取对象比较
		BaseObject bo = qyryjxxxService.getQyryjxxx(qyryjxxx);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyryjxxx qyryjxxxNew = (Qyryjxxx)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyryjxxxNew.getQyryjxid(), qyryjxxx.getQyryjxid());
		assertEquals(qyryjxxxNew.getQyid(), qyryjxxx.getQyid());
		assertEquals(qyryjxxxNew.getHylbdm(), qyryjxxx.getHylbdm());
		assertEquals(qyryjxxxNew.getHylb(), qyryjxxx.getHylb());
		assertEquals(qyryjxxxNew.getCyrybh(), qyryjxxx.getCyrybh());
		assertEquals(qyryjxxxNew.getXm(), qyryjxxx.getXm());
		assertEquals(qyryjxxxNew.getXmpy(), qyryjxxx.getXmpy());
		assertEquals(qyryjxxxNew.getGjdm(), qyryjxxx.getGjdm());
		assertEquals(qyryjxxxNew.getGj(), qyryjxxx.getGj());
		assertEquals(qyryjxxxNew.getXbdm(), qyryjxxx.getXbdm());
		assertEquals(qyryjxxxNew.getXb(), qyryjxxx.getXb());
		assertEquals(qyryjxxxNew.getCsrq(), qyryjxxx.getCsrq());
		assertEquals(qyryjxxxNew.getHjdxzqh(), qyryjxxx.getHjdxzqh());
		assertEquals(qyryjxxxNew.getHjdxzqhdm(), qyryjxxx.getHjdxzqhdm());
		assertEquals(qyryjxxxNew.getCyzjdm(), qyryjxxx.getCyzjdm());
		assertEquals(qyryjxxxNew.getCyzj(), qyryjxxx.getCyzj());
		assertEquals(qyryjxxxNew.getZjhm(), qyryjxxx.getZjhm());
		assertEquals(qyryjxxxNew.getLrsj(), qyryjxxx.getLrsj());
		assertEquals(qyryjxxxNew.getLrr(), qyryjxxx.getLrr());
		assertEquals(qyryjxxxNew.getLrdwbm(), qyryjxxx.getLrdwbm());
		assertEquals(qyryjxxxNew.getLrdwmc(), qyryjxxx.getLrdwmc());
		assertEquals(qyryjxxxNew.getZt(), qyryjxxx.getZt());

		//删除对象
		// @ 企业业人员简项ID(qyryjxid) 
		qyryjxxx.setQyryjxid(1)
		// @ 企业ID(qyid) 
		qyryjxxx.setQyid(1)

		qyryjxxxService.deleteQyryjxxx(qyryjxxx);

		//修改对象
		// @ 企业业人员简项ID(qyryjxid) 
		qyryjxxx.setQyryjxid(1)
		// @ 企业ID(qyid) 
		qyryjxxx.setQyid(1)

		qyryjxxxService.updateQyryjxxx(qyryjxxx);

		//查询单条
		// @ 企业业人员简项ID(qyryjxid) 
		qyryjxxx.setQyryjxid(1)
		// @ 企业ID(qyid) 
		qyryjxxx.setQyid(1)

		qyryjxxxService.getQyryjxxx(qyryjxxx);

		//查询多条
		// @ 企业业人员简项ID(qyryjxid) 
		qyryjxxx.setQyryjxid(1)
		// @ 企业ID(qyid) 
		qyryjxxx.setQyid(1)

		qyryjxxxService.getListQyryjxxx(qyryjxxx);

		//翻页查询
		// @ 企业业人员简项ID(qyryjxid) 
		qyryjxxx.setQyryjxid(1)
		// @ 企业ID(qyid) 
		qyryjxxx.setQyid(1)

		qyryjxxxService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyryjxxxService.insertQyryjxxx(qyryjxxx);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyryjxxxService(IQyryjxxxService qyryjxxxService) {
		this.qyryjxxxService = qyryjxxxService;
	}
}
