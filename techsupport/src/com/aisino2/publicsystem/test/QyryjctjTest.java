package com.aisino2.publicsystem.test;

import java.util.Date;

import com.aisino2.core.test.BaseTestCase;
import com.aisino2.publicsystem.domain.Qyryjctj;
import com.aisino2.publicsystem.service.IQyryjctjService;

public class QyryjctjTest {

	//定义服务，名称与bean id一致，利用spring注入模式实例化
	private IQyryjctjService qyryjctjService;

	/** @param 企业人员奖惩统计表(t_qyryjctj) */

	public void test() {
		Qyryjctj qyryjctj = new Qyryjctj();

	/** @ 企业人员奖惩统计ID(qyryjctjid) */
	qyryjctj.setQyryjctjid(0);

	/** @ 行业类别代码(hylbdm) */
	qyryjctj.setHylbdm("test");

	/** @ 行业类别(hylb) */
	qyryjctj.setHylb("test");

	/** @ 统计日期(tjrq) */
	qyryjctj.setTjrq(new Date());

	/** @ 从业人员编号(cyrybh) */
	qyryjctj.setCyrybh("test");

	/** @ 从业人员类别代码(cyrylbdm) */
	qyryjctj.setCyrylbdm("test");

	/** @ 从业人员类别名称(cyrylbmc) */
	qyryjctj.setCyrylbmc("test");

	/** @ 姓名(xm) */
	qyryjctj.setXm("test");

	/** @ 证件号码(zjhm) */
	qyryjctj.setZjhm("test");

	/** @ 地市机关名称(dsjgmc) */
	qyryjctj.setDsjgmc("test");

	/** @ 分县局代码(fxjdm) */
	qyryjctj.setFxjdm("test");

	/** @ 地市机关代码(dsjgdm) */
	qyryjctj.setDsjgdm("test");

	/** @ 分县局名称(fxjmc) */
	qyryjctj.setFxjmc("test");

	/** @ 管辖单位代码(gxdwdm) */
	qyryjctj.setGxdwdm("test");

	/** @ 管辖单位名称(gxdwmc) */
	qyryjctj.setGxdwmc("test");

	/** @ 企业名称(qymc) */
	qyryjctj.setQymc("test");

	/** @ 企业编码(qybm) */
	qyryjctj.setQybm("test");

	/** @ 警告(jg) */
	qyryjctj.setJg(0);

	/** @ 罚款(fk) */
	qyryjctj.setFk(0);

	/** @ 拘留(jl) */
	qyryjctj.setJl(0);

	/** @ 拘留并罚款(jlbfk) */
	qyryjctj.setJlbfk(0);

	/** @ 追究刑事责任(zjxszr) */
	qyryjctj.setZjxszr(0);

	/** @ 限期出境或驱逐出境(xqcjhqzcj) */
	qyryjctj.setXqcjhqzcj(0);

	/** @ 其他处罚类型(qtfklx) */
	qyryjctj.setQtfklx(0);

	/** @ 小计(xj) */
	qyryjctj.setXj(0);

		/*
		//插入对象
		qyryjctjService.insertQyryjctj(qyryjctj);

		//读取对象比较
		BaseObject bo = qyryjctjService.getQyryjctj(qyryjctj);
		//保证能获取刚才保存的对象
		assertNotNull(bo);
		Qyryjctj qyryjctjNew = (Qyryjctj)(bo);
		// 保证获取对象的属性值与保存时相同
		assertEquals(qyryjctjNew.getQyryjctjid(), qyryjctj.getQyryjctjid());
		assertEquals(qyryjctjNew.getHylbdm(), qyryjctj.getHylbdm());
		assertEquals(qyryjctjNew.getHylb(), qyryjctj.getHylb());
		assertEquals(qyryjctjNew.getTjrq(), qyryjctj.getTjrq());
		assertEquals(qyryjctjNew.getCyrybh(), qyryjctj.getCyrybh());
		assertEquals(qyryjctjNew.getCyrylbdm(), qyryjctj.getCyrylbdm());
		assertEquals(qyryjctjNew.getCyrylbmc(), qyryjctj.getCyrylbmc());
		assertEquals(qyryjctjNew.getXm(), qyryjctj.getXm());
		assertEquals(qyryjctjNew.getZjhm(), qyryjctj.getZjhm());
		assertEquals(qyryjctjNew.getDsjgmc(), qyryjctj.getDsjgmc());
		assertEquals(qyryjctjNew.getFxjdm(), qyryjctj.getFxjdm());
		assertEquals(qyryjctjNew.getDsjgdm(), qyryjctj.getDsjgdm());
		assertEquals(qyryjctjNew.getFxjmc(), qyryjctj.getFxjmc());
		assertEquals(qyryjctjNew.getGxdwdm(), qyryjctj.getGxdwdm());
		assertEquals(qyryjctjNew.getGxdwmc(), qyryjctj.getGxdwmc());
		assertEquals(qyryjctjNew.getQymc(), qyryjctj.getQymc());
		assertEquals(qyryjctjNew.getQybm(), qyryjctj.getQybm());
		assertEquals(qyryjctjNew.getJg(), qyryjctj.getJg());
		assertEquals(qyryjctjNew.getFk(), qyryjctj.getFk());
		assertEquals(qyryjctjNew.getJl(), qyryjctj.getJl());
		assertEquals(qyryjctjNew.getJlbfk(), qyryjctj.getJlbfk());
		assertEquals(qyryjctjNew.getZjxszr(), qyryjctj.getZjxszr());
		assertEquals(qyryjctjNew.getXqcjhqzcj(), qyryjctj.getXqcjhqzcj());
		assertEquals(qyryjctjNew.getQtfklx(), qyryjctj.getQtfklx());
		assertEquals(qyryjctjNew.getXj(), qyryjctj.getXj());

		//删除对象
		// @ 企业人员奖惩统计ID(qyryjctjid) 
		qyryjctj.setQyryjctjid(1)

		qyryjctjService.deleteQyryjctj(qyryjctj);

		//修改对象
		// @ 企业人员奖惩统计ID(qyryjctjid) 
		qyryjctj.setQyryjctjid(1)

		qyryjctjService.updateQyryjctj(qyryjctj);

		//查询单条
		// @ 企业人员奖惩统计ID(qyryjctjid) 
		qyryjctj.setQyryjctjid(1)

		qyryjctjService.getQyryjctj(qyryjctj);

		//查询多条
		// @ 企业人员奖惩统计ID(qyryjctjid) 
		qyryjctj.setQyryjctjid(1)

		qyryjctjService.getListQyryjctj(qyryjctj);

		//翻页查询
		// @ 企业人员奖惩统计ID(qyryjctjid) 
		qyryjctj.setQyryjctjid(1)

		qyryjctjService.getListForPage(map,pageNo,pageSize,sort,desc);
		*/

		//插入对象
		qyryjctjService.insertQyryjctj(qyryjctj);
		//保存到数据库，如不想保存到数据库，可注释此句
		this.setComplete();
	}

	public void setQyryjctjService(IQyryjctjService qyryjctjService) {
		this.qyryjctjService = qyryjctjService;
	}
}
